package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class for_database {
	static final String URL = "jdbc:mysql://localhost/tweet_a";  //データベースURL
	static final String USERNAME = "root";                        //ユーザ名
	static final String PASSWORD = "kamekame1";                   //パスワード

	public void x(String a,String b) {//データベースにユーザーを登録するメソッド
		try {
			Class.forName("com.mysql.jdbc.Driver"); //???
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			String sql ="INSERT INTO user VALUES('" + a +"',"+"'"+b+"');";
			statement.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public int y(String a) {//登録の際に同じ名前のユーザーがいるか確認するメソッド
		String count=null;
		try {
			String sql = "select count(name='"+a+"'or null) as namecount from user";
			Class.forName("com.mysql.jdbc.Driver"); //???
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			result.next();
			count = result.getString("namecount");

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		int c = Integer.parseInt(count);
		return c;
	}
}
