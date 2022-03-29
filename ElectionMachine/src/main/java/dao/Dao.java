package dao;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.api.server.spi.auth.common.User;
public class Dao {
	
	private Connection conn;

	// When new instance is created, also DB-connection is created
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "kayttaja", "kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Manually close DB-connection for releasing resource
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User checkLogin(String email, String password) throws SQLException,
    ClassNotFoundException {
String jdbcURL = "jdbc:mysql://localhost:3306/vaalikone";
String dbUser = "kayttaja";
String dbPassword = "kukkuu";

Class.forName("com.mysql.jdbc.Driver");
Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
String sql = "SELECT * FROM kirjautuminen WHERE email = ? and salasana = ?";
PreparedStatement statement = connection.prepareStatement(sql);
statement.setString(1, email);
statement.setString(2, password);

ResultSet result = statement.executeQuery();

User user = null;

if (result.next()) {
    user = new User(dbUser, dbPassword);
    user.setFullname(result.getString("fullname"));
    user.setEmail(email);
}


connection.close();

return user;

}
}
	
