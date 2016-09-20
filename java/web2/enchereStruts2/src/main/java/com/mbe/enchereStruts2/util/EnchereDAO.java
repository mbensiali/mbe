package com.mbe.enchereStruts2.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mbe.enchereStruts2.metier.Enchere;

public class EnchereDAO {
	
	public static final String FIND_ALL_SQL = "select id, description, prixDepart, enchereMin, prixActuel from enchere";
	public static final String INSERT_ONE_SQL =	"INSERT INTO enchere(description, prixDepart, enchereMin, prixActuel) VALUES (?,?,?,?)";

	private Logger log = LogManager.getLogger(EnchereDAO.class);
	
	private Connection connection;

	private PreparedStatement findAllStatement;
	private PreparedStatement insertOneStatement;
	
	public EnchereDAO(Connection connection) {
		this.connection = connection;
		
		try {
			findAllStatement = connection.prepareStatement(FIND_ALL_SQL);
			insertOneStatement = connection.prepareStatement(INSERT_ONE_SQL);
		} catch (SQLException e) {log.error(e);}
	}
	
	public List<Enchere> findAll() {
		List<Enchere> encheres = new ArrayList<>();
		try {
			// effacer les parametres précédent s'il y en avait
			findAllStatement.clearParameters();
			// executer la requette
			ResultSet rs = findAllStatement.executeQuery();
			// parcourir les resultat de l'execution
			while (rs.next()) {
				// pour chaque ligne, ajouter un objet message avec les données correspondantes
				// en provenance de la ligne
				encheres.add(new Enchere(rs.getInt("id"),
										 rs.getString("description"),
										 rs.getDouble("prixDepart"),
										 rs.getDouble("enchereMin"),
										 rs.getDouble("prixActuel")));
			}
			// fermer le resultSet
			rs.close();
		} catch (SQLException e) {log.error(e);}
		return encheres;
	}
	
	public void save(Enchere ech) {
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, ech.getDescription());
				insertOneStatement.setDouble(2, ech.getPrixDepart());
				insertOneStatement.setDouble(3, ech.getEnchereMin());
				insertOneStatement.setDouble(4, ech.getPrixActuel());
				// execution de l'insertion
				insertOneStatement.executeUpdate();
			} catch (SQLException e) {log.error(e);}
			
		}

}
