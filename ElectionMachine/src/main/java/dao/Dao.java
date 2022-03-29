package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import app.Candidates;


public class Dao {

	private Connection conn;

	// When new instance is created, also DB-connection is created
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/gamedb", "appuser", "kukkuu");
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

	public int saveGame(Candidates candidate) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into gametable(breed, weight) values('"+candidate.getEhdokas_id()+"', "+candidate.getEtunimi()+")");
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
			ResultSet rs=stmt.executeQuery("select * from vaalikone");
			while (rs.next()) {
				Candidates candidate=new Candidates();
				candidate.setEhdokas_id(rs.getInt("id"));
				candidate.setEtunimi(rs.getString("Etunimi"));
				candidate.setSukunimi(rs.getString("Sukunimi"));
				candidate.setPuolue(rs.getString("Puolue"));
				candidate.setKotikunta(rs.getString("Kotikunta"));
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
		String sql = "update vaalikone set etunimi = ?, sukunimi = ? where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, candidate.getEtunimi());
			stmt.setString(2, candidate.getSukunimi());
			
			stmt.setInt(3, candidate.getEhdokas_id());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int deleteCandidate(Candidates candidate) throws SQLException {
		
		String sql = "DELETE FROM vaalikone WHERE Ehdokas_id=?";
		 
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
		String sql = "select * from vaalikone where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Candidates();
				result.setEhdokas_id(resultset.getInt("id"));
				result.setEtunimi(resultset.getString("Etunimi"));
				result.setSukunimi(resultset.getString("Sukunimi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
