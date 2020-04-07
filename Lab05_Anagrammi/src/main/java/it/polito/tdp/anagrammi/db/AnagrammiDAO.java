package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Parola;

public class AnagrammiDAO {
	
	public boolean isCorrect(String anagramma) {
		
		boolean pippo = false;
		String sql = "SELECT nome FROM parola WHERE nome = ?";
		
		try {
			Connection connessione = ConnectDB.getConnection();
			PreparedStatement st = connessione.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("nome").equals(anagramma)) {
					pippo = true;
				}
			}
			connessione.close();
			
		}catch(SQLException e){
			throw new RuntimeException();
		}
		return pippo;
	}

}
