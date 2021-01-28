package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.for_database;


@WebServlet("/entry")
public class entry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean b = true;
		request.setAttribute("count",b);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/entry.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		for_database database = new for_database();
		if(!name.replace(" ","").replace("　","").isEmpty()&&!password.replace(" ","").replace("　","").isEmpty()) {
			if(database.y(name)>0) {//すでに同じ名前のユーザーが存在していた
				Boolean b = false;
				request.setAttribute("count",b);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/entry.jsp");
				dispatcher.forward(request, response);
			}
			else {
				database.x(name, password); //データベースに登録
				response.sendRedirect("/tweet_a/login");
			}
		}else {//名前、パスワードの項目が空白だった場合の処理
			Boolean a = true;
			Boolean b = true;
			request.setAttribute("blank",a);
			request.setAttribute("count",b);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/entry.jsp");
			dispatcher.forward(request, response);
		}

	}
}
