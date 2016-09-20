package firstJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class Program {

	public static void main(String[] args){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/basetest 1", "root", "");
			System.out.println("connection réussie");
			
			Statement request =connection.createStatement();
			ResultSet rs = request.executeQuery("select id,titre from post");
			
			while (rs.next()){
				System.out.println("post d'id" + rs.getInt("id") + "et de titre "+ rs.getString("titre"));
			}
			
			rs.close();
			System.out.println("-------------------------------------------------");
			PreparedStatement request2 = connection.prepareStatement("select id, titre from post where id=?");
			request2.setInt(1, 2);
			
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
