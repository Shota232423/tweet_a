package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.theme;

/**
 * Servlet implementation class settheme
 */
@WebServlet("/settheme")
public class settheme extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tweet = request.getParameter("tweet");//ツイートを取得
		if(!tweet.replace(" ","").replace("　","").replace("\r\n","").isEmpty()) {
			theme t = new theme();
			t.themetodb(tweet);
			response.sendRedirect("/tweet_a");

		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adform.jsp");
			dispatcher.forward(request, response);
		}
	}
	}


