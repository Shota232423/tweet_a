package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.adLoginLogic;

/**
 * Servlet implementation class adlogin
 */
@WebServlet("/adlogin")
public class adlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password"); //リクエストパラメータの値を取得
		adLoginLogic ll = new adLoginLogic();
		int x = Integer.parseInt(ll.e(name,password));
		if(!name.replace(" ","").replace("　","").isEmpty()&&!password.replace(" ","").replace("　","").isEmpty()) {//両項目とも入力されている場合の処理
			if(x==0) {
				Boolean b = true;//trueの場合、ログイン失敗
				request.setAttribute("adlogin", b);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adlogin.jsp");
				dispatcher.forward(request, response);
			}
			else {
				//ログインが成功
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adform.jsp");
				dispatcher.forward(request,response);
			}
		}else {//未入力の項目があった場合の処理
			Boolean blank = true;
			request.setAttribute("adblank", blank);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/adlogin.jsp");
			dispatcher.forward(request, response);
		}
	}

}
