package webBlogging.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webBlogging.metier.Post;

public class PostDAO {
	
	private Connection connection;

	public static final String FIND_ALL_SQL = "SELECT id,titre,corps,categorie,auteur FROM Post";
	public static final String FIND_BY_ID_SQL = "SELECT id,titre,corps,categorie,auteur FROM Post WHERE id=?";
	public static final String INSERT_ONE_SQL = "INSERT INTO Post(titre,corps,categorie,auteur) VALUES (?,?,?,?)";
	public static final String UPDATE_ONE_SQL = "UPDATE Post SET titre=?, corps=?, categorie=?, auteur=? WHERE id=?";
	public static final String DELETE_ONE_SQL = "DELETE FROM Post WHERE id=?";
	
	private PreparedStatement findAllStatement;
	private PreparedStatement findByIdStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement deleteOneStatement;


	public PostDAO(Connection connection) {
		this.connection = connection;

		try {
			findAllStatement = connection.prepareStatement(FIND_ALL_SQL);
			findByIdStatement = connection.prepareStatement(FIND_BY_ID_SQL);
			updateOneStatement = connection.prepareStatement(UPDATE_ONE_SQL);
			insertOneStatement = connection.prepareStatement(INSERT_ONE_SQL);
			deleteOneStatement = connection.prepareStatement(DELETE_ONE_SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Post> findAll() {
		List<Post> posts = new ArrayList<>();

		PreparedStatement findStatement= findAllStatement;
		
		try {
			findStatement.clearParameters();
			ResultSet rs = findStatement.executeQuery();
			while (rs.next()) {
				posts.add(new Post(rs.getInt("id"),
										rs.getString("titre"),
										rs.getString("corps"),
										rs.getString("categorie"),
										rs.getString("auteur")));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return posts;
	}
	
	public Post findByID(int id) {
		Post p = null;
		try {
			findByIdStatement.clearParameters();
			findByIdStatement.setInt(1, id);
			
			ResultSet rs = findByIdStatement.executeQuery();
			if (rs.next()) {
				p = new Post(rs.getInt("id"),
						     rs.getString("titre"),
						     rs.getString("corps"),
						     rs.getString("categorie"),
						     rs.getString("auteur"));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return p;
	}
	
	public void save(Post p) {
		if (p.getId() == 0) {
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, p.getTitre());
				insertOneStatement.setString(2, p.getCorps());
				insertOneStatement.setString(3, p.getCategorie());
				insertOneStatement.setString(4, p.getAuteur());
				insertOneStatement.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();}
			
		}
		else {
			try {
				updateOneStatement.clearParameters();
				updateOneStatement.setString(1, p.getTitre());
				updateOneStatement.setString(2, p.getCorps());
				updateOneStatement.setString(3, p.getCategorie());
				updateOneStatement.setString(4, p.getAuteur());
				updateOneStatement.setInt(5, p.getId());
				updateOneStatement.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	public void deleteOne(int id) {
		try {
			deleteOneStatement.clearParameters();
			deleteOneStatement.setInt(1, id);
			deleteOneStatement.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
	}
	

}
