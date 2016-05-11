package it.polito.tdp.porto.model;

import java.util.LinkedList;
import java.util.List;

public class Article {

	private int eprintId;
	private int year;
	private String title;
	private List<Creator> creators;
	
	public Article(int eprintId, int year, String title) {
		super();
		this.eprintId = eprintId;
		this.year = year;
		this.title = title;
		creators = new LinkedList<Creator>();
	}

	public int getEprintId() {
		return eprintId;
	}

	public void setEprintId(int eprintId) {
		this.eprintId = eprintId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eprintId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (eprintId != other.eprintId)
			return false;
		return true;
	}
	
	
	
}
