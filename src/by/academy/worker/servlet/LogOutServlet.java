package by.academy.worker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class LogOutServlet
 *
 */

@WebServlet("/LogOutSrvlet")
public class LogOutServlet extends HttpServlet {

	private static final long serialVersionUID = 6260185221660626271L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("LogOutServlet");

		HttpSession session = request.getSession();
		session.invalidate();

		String loginURI = request.getContextPath() + "/webProjectWorker/LoginServlet";
		response.sendRedirect(loginURI);
	}

}
