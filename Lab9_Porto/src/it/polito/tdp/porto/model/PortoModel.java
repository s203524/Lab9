package it.polito.tdp.porto.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.Multigraph;

import it.polito.tdp.porto.db.PortoDAO;

public class PortoModel {
	
	private Multigraph<Creator, ArcoArticle> grafo = new Multigraph<Creator, ArcoArticle>(ArcoArticle.class);

	private List<Creator> creators;
	
	private List<Article> articles;
	
	private List<Authorship> authorships;
	
	private PortoDAO PDAO;

	public PortoModel() {
		super();
		this.creators = new LinkedList<Creator>();
		this.articles = new LinkedList<Article>();
		this.authorships = new LinkedList<Authorship>();
		PDAO = new PortoDAO();
	}

	public List<Creator> popolaTendina(){
		creators = PDAO.getAllCreators();
		Collections.sort(creators);
		return creators;
	}
	
	public void GenerateGraph(){
		articles = PDAO.getAllArticles();
		authorships = PDAO.getAllAuthorship();
		for(Creator c: creators){
			grafo.addVertex(c);
		}
		System.out.println("Numero Vertici:" + grafo.vertexSet().size());
		//carico la lista di creatori per ciascun articolo
		/*for(Article a: articles){
			a.setCreators(PDAO.getContributorsOfAnArticle(a.getEprintId()));
		}
		*/
		for(Article a: articles){
			a.setCreators(this.authorsForAnArticle(a.getEprintId()));
		}
		this.aggiungiArchi();
		System.out.println("Numero Archi:" + grafo.edgeSet().size());
		
	}
		
	public List<Creator> authorsForAnArticle(long l){
		List<Integer> idCreator = new LinkedList<Integer>();
		List<Creator> creatorsOfArticle = new LinkedList<Creator>();
		for(Authorship as: authorships){
			if(as.getEprintId()==l){
				idCreator.add(as.getIdCreator());
			}
		}
		for(Integer i: idCreator){
			for(Creator c: creators){
				if(c.getIdCreator()==i){
					creatorsOfArticle.add(c);
				}
			}
		}
		return creatorsOfArticle;
	}
		
	public void aggiungiArchi(){
		for(Article a: articles){
			Creator c = a.getCreators().get(0);
			for(int i=0; i<a.getCreators().size(); i++){
				if(!c.equals(a.getCreators().get(i)))
					grafo.addEdge(c, a.getCreators().get(i));
			}
		}
	}
	
	public List<Creator> listaCoautori(Creator c){
		return Graphs.neighborListOf(grafo, c);
		
	}
	
	
}
