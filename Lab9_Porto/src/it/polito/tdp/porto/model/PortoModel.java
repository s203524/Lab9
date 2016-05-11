package it.polito.tdp.porto.model;

import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.Multigraph;

import it.polito.tdp.porto.db.PortoDAO;

public class PortoModel {
	
	private Multigraph<Creator, ArcoArticle> grafo = new Multigraph<Creator, ArcoArticle>(ArcoArticle.class);

	private List<Creator> creators;
	
	private List<Article> articles;
	
	private List<Authorship> autorships;
	
	private PortoDAO PDAO;

	public PortoModel() {
		super();
		this.creators = new LinkedList<Creator>();
		this.articles = new LinkedList<Article>();
		this.autorships = new LinkedList<Authorship>();
		PDAO = new PortoDAO();
	}

	public List<Creator> popolaTendina(){
		creators = PDAO.getAllCreators();
		this.GenerateGraph();
		System.out.println(grafo.vertexSet().size());
		return creators;
	}
	
	public void GenerateGraph(){
		
		for(Creator c: creators){
			
			grafo.addVertex(c);
		}
		
		
	}
	
}
