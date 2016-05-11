package it.polito.tdp.porto.db;

import java.sql.Connection;
import java.util.List;

import it.polito.tdp.porto.model.Creator;

public class PortoDAO {
	
	public List<Creator> getAllCreators(){
		
		Connection conn = DBConnect.getInstance().getConnection();
		String sql = "";
		return null;
		
	
	}
}
