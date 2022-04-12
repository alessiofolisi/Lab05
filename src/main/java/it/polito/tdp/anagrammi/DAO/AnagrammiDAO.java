package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AnagrammiDAO {
	
	
	
	public List<String> getParoleAmmesse(){
		
		final String sql = "SELECT * FROM parola";

		List<String> paroleAmmesse = new ArrayList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				paroleAmmesse.add(rs.getString("nome"));
			}
			
			
			st.close();
			rs.close();
			conn.close();
			return paroleAmmesse;

		} catch (SQLException e) {
			 e.printStackTrace();
			System.err.println("Errore nel DAO");
			return null;
		}
	}

}
