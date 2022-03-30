package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.api.server.spi.auth.common.User;

import app.Candidates;


public class Dao {

	private Connection conn;

	// When new instance is created, also DB-connection is created
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "kayttaja", "kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Manually close DB-connection for releasing resource
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int saveCandidate(Candidates candidate) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue, ikä, kotikunta, ehdolle, edustaa, ammatti) "
					+ "values('"+candidate.getEhdokas_id()+"', '"+candidate.getEtunimi()+"' '"+candidate.getSukunimi()+"' '"+candidate.getPuolue()+" '"+candidate.getKotikunta()+"'"
							+ "'"+candidate.getAmmatti()+"''"+candidate.getIka()+"' '"+candidate.getEhdolle()+"' '"+candidate.getEdistaa()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public ArrayList<Candidates> readAllCandidates() {
		ArrayList<Candidates> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Candidates candidate=new Candidates();
				candidate.setEhdokas_id(rs.getInt("EhdokasId"));
				candidate.setEtunimi(rs.getString("Etunimi"));
				candidate.setSukunimi(rs.getString("Sukunimi"));
				candidate.setPuolue(rs.getString("Puolue"));
				candidate.setKotikunta(rs.getString("Kotikunta"));
				candidate.setAmmatti(rs.getString("Ammatti"));
				candidate.setIka(rs.getInt("Ika"));
				candidate.setEhdolle(rs.getString("Ehdolle"));
				candidate.setEdistaa(rs.getString("Edistaa"));
				list.add(candidate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateCandidate(Candidates candidate) {
		int count = 0;
		String sql = "update ehdokkaat set etunimi = ?, sukunimi = ? where ehdokas_id = ? where puolue =? where kotikunta =?"
				+ "where ika = ? where ehdolle = ? where edistaa = ? where ammatti = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, candidate.getEtunimi());
			stmt.setString(2, candidate.getSukunimi());
			stmt.setInt(3, candidate.getEhdokas_id());
			stmt.setString(4, candidate.getPuolue());
			stmt.setString(5, candidate.getKotikunta());
			stmt.setInt(6, candidate.getIka());
			stmt.setString(7, candidate.getEhdolle());
			stmt.setString(8, candidate.getEdistaa());
			stmt.setString(9, candidate.getAmmatti());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return count;
	}
	public int deleteCandidate(Candidates candidate) throws SQLException {
		
		String sql = "DELETE FROM ehdokkaat WHERE Ehdokas_id=?";
		 
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, candidate.getEhdokas_id());
		 
		int remove = stmt.executeUpdate();
		if (remove > 0) {
		    System.out.println("Ehdokas poistettu onnistuneesti!");
		}
		
		return remove;
	}
	
	public Candidates getCandidateInfo(int id) {
		Candidates result = null;
		String sql = "select * from ehdokkaat where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Candidates();
				result.setEhdokas_id(resultset.getInt("id"));
				result.setEtunimi(resultset.getString("Etunimi"));
				result.setSukunimi(resultset.getString("Sukunimi"));
				result.setPuolue(resultset.getString("Puolue"));
				result.setKotikunta(resultset.getString("Kotikunta"));
				result.setIka(resultset.getInt("ika"));
				result.setEhdolle(resultset.getString("Ehdolle"));
				result.setEdistaa(resultset.getString("Edistaa"));
				result.setAmmatti(resultset.getString("Ammatti"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	 public User checkLogin(String email, String password) throws SQLException,
     ClassNotFoundException {
 String jdbcURL = "jdbc:mysql://localhost:3306/vaalikone";
 String dbUser = "root";
 String dbPassword = "password";

 Class.forName("com.mysql.jdbc.Driver");
 Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
 String sql = "SELECT * FROM kirjautuminen WHERE email = ? and password = ?";
 PreparedStatement statement = connection.prepareStatement(sql);
 statement.setString(1, email);
 statement.setString(2, password);

 ResultSet result = statement.executeQuery();

 User user = null;
/*
 if (result.next()) {
     user = new User(user);
     ((Object) user).setFullname(result.getString("fullname"));
     ((Object) user).setEmail(email);
 } this needs some fixing
*/
 connection.close();

 return user;
}
}
