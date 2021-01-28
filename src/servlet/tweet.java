package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.tweet_logic;


@WebServlet("/tweet")
public class tweet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//List<String> tweetlist = new ArrayList<String>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");//ログインしているユーザーの名前を取得
		//ログインされているか確認、直接アクセスされた場合の処理
		if(name==null) {
			System.out.println("リダイレクトテスト");
			//リダイレクト
			response.sendRedirect("/tweet_a/entry");
		}
		else {
			tweet_logic t = new tweet_logic();
			ServletContext application = this.getServletContext();
			application.setAttribute("tweet", t.tweetdata());//アプリケーションスコープ使用
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");//ログインしているユーザーの名前を取得
		String tweet = request.getParameter("tweet");//ツイートを取得
		if(!tweet.replace(" ","").replace("　","").replace("\r\n","").isEmpty()) {
			tweet_logic t = new tweet_logic();
			t.tweettodb(name, tweet);
			ServletContext application = this.getServletContext();
			application.setAttribute("tweet", t.tweetdata());//アプリケーションスコープ使用
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}

	}

}
