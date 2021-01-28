package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginLogic {
	static final String URL = "jdbc:mysql://localhost/tweet_a";  //データベースURL
	static final String USERNAME = "root";                        //ユーザ名
	static final String PASSWORD = "kamekame1";                   //パスワード

	public String e(String a,String b) {
		String count=null;
		try {
			String sql = "select count((name='"+a+"' and password='"+b+"') or NULL) as count from user;";
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			result.next();
			count = result.getString("count");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}
}
