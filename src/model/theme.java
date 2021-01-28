package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class theme {
	static final String URL = "jdbc:mysql://localhost/tweet_a";  //データベースURL
	static final String USERNAME = "root";                        //ユーザ名
	static final String PASSWORD = "kamekame1";                   //パスワード

	public void themetodb(String theme) {//データベースにツイートを登録するメソッド
		try {
			Class.forName("com.mysql.jdbc.Driver"); //???
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			String sql ="INSERT INTO theme (theme) VALUES('" +theme+"');";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public String themedata() {
		String theme=null;
		try {
			String sql = "select * from theme order by id desc limit 1;";
			Class.forName("com.mysql.jdbc.Driver"); //???
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement statement = connection.prepareStatement(sql);//statementは問い合わせを実行したり、結果の取得に関するベース
			ResultSet result = statement.executeQuery();//問い合わせを実行
			result.next();
			theme = result.getString("theme");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return theme;
	}


}
