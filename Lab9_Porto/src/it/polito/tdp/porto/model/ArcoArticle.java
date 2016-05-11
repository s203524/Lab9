package it.polito.tdp.porto.model;

import org.jgrapht.graph.DefaultEdge;

public class ArcoArticle extends DefaultEdge{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Article a;

	public Article getA() {
		return a;
	}

	public void setA(Article a) {
		this.a = a;
	}
	
	
}
