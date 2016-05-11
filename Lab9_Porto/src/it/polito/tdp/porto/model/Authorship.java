package it.polito.tdp.porto.model;

public class Authorship {
	
	private int idAuthorship;
	private long eprintId;
	private int idCreator;
	
	public Authorship(int idAuthorship, long eprintId, int idCreator) {
		super();
		this.idAuthorship = idAuthorship;
		this.eprintId = eprintId;
		this.idCreator = idCreator;
	}

	public int getIdAuthorship() {
		return idAuthorship;
	}

	public void setIdAuthorship(int idAuthorship) {
		this.idAuthorship = idAuthorship;
	}

	public long getEprintId() {
		return eprintId;
	}

	public void setEprintId(int eprintId) {
		this.eprintId = eprintId;
	}

	public int getIdCreator() {
		return idCreator;
	}

	public void setIdCreator(int idCreator) {
		this.idCreator = idCreator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAuthorship;
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
		Authorship other = (Authorship) obj;
		if (idAuthorship != other.idAuthorship)
			return false;
		return true;
	}
	
	
	

}
