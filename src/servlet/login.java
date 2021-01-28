package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean b = false;
		request.setAttribute("login", b);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password"); //リクエストパラメータの値を取得
		LoginLogic ll = new LoginLogic();
		int x = Integer.parseInt(ll.e(name,password));
		if(!name.replace(" ","").replace("　","").isEmpty()&&!password.replace(" ","").replace("　","").isEmpty()) {//両項目とも入力されている場合の処理
			if(x==0) {
				Boolean b = true;//trueの場合、ログイン失敗
				request.setAttribute("login", b);
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
			else {
				//ログインが成功
				HttpSession session = request.getSession();
				session.setAttribute("name",name);
				response.sendRedirect("/tweet_a/tweet");
			}
		}else {//未入力の項目があった場合の処理
			Boolean blank = true;
			request.setAttribute("blank", blank);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}

