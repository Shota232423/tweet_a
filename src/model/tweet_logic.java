package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class tweet_logic {
	static final String URL = "jdbc:mysql://localhost/tweet_a";  //データベースURL
	static final String USERNAME = "root";                        //ユーザ名
	static final String PASSWORD = "kamekame1";                   //パスワード

	public void tweettodb(String name,String tweet) {//データベースにツイートを登録するメソッド
		try {
			Class.forName("com.mysql.jdbc.Driver"); //???
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			String sql ="INSERT INTO tweet (name,tweet) VALUES('" + name +"',"+"'"+tweet+"');";
			statement.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public List<tweet_info> tweetdata() {
		String name=null;
		String tweet=null;
		String time=null;
		List<tweet_info> l = new ArrayList<tweet_info>();
		try {
			String sql = "select * from tweet";
			Class.forName("com.mysql.jdbc.Driver"); //???
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement statement = connection.prepareStatement(sql);//statementは問い合わせを実行したり、結果の取得に関するベース
			ResultSet result = statement.executeQuery();//問い合わせを実行
			while(result.next()) {
				name = result.getString("name");
				tweet = result.getString("tweet");
				time = result.getString("created_at");
				l.add(0,new tweet_info(name,tweet,time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return l;
	}

}
