package it.polito.tdp.porto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.porto.model.Article;
import it.polito.tdp.porto.model.Authorship;
import it.polito.tdp.porto.model.Creator;

public class PortoDAO {
	
	public List<Creator> getAllCreators(){
		
		List<Creator> creators = new LinkedList<Creator>();
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT * FROM creator";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			
			while(res.next()){
				Creator tempC = new Creator(res.getInt("id_creator"), res.getString("family_name"), res.getString("given_name"));
				creators.add(tempC);
			}
			res.close();
			return creators;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	public List<Article> getAllArticles(){
		
		List<Article> articles = new LinkedList<Article>();
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT * FROM article";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			
			while(res.next()){
				Article tempA = new Article (res.getLong("eprintid"), res.getInt("year"), res.getString("title"));
				articles.add(tempA);
				
			}
			res.close();
			return articles;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public List<Authorship> getAllAuthorship(){
		
		List<Authorship> authorship = new LinkedList<Authorship>();
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT * FROM authorship";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			
			while(res.next()){
				Authorship tempAs = new Authorship(res.getInt("id_authorship"), res.getLong("eprintid"), res.getInt("id_creator"));
				authorship.add(tempAs);
			}
			res.close();
			return authorship;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public List<Creator> getContributorsOfAnArticle(long l){
		List<Creator> creators = new LinkedList<Creator>();
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT * FROM creator WHERE id_creator IN (SELECT id_creator FROM authorship WHERE eprintid=?)";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, l);
			ResultSet res = st.executeQuery();
			
			while(res.next()){
				Creator tempC = new Creator(res.getInt("id_creator"), res.getString("family_name"), res.getString("given_name"));
				creators.add(tempC);
			}
			res.close();
			return creators;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
}
