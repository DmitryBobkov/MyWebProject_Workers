package by.academy.worker.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.academy.worker.loginUser.User;
import by.academy.worker.loginUser.UserService;

/**
 * Class LoginServlet
 *
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7235374885524906309L;

	private UserService userService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, String> messages = new HashMap<String, String>();

		System.out.println("LoginServlet" + username + " " + password);

		if (username == null || username.isEmpty()) {
			messages.put("username", "Please enter username");
		}

		if (password == null || password.isEmpty()) {
			messages.put("password", "Please enter password");
		}

		if (messages.isEmpty()) {
			User user = UserService.find(username, password);

			if (user != null) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/?action=showAll");
				return;
			} else {
				messages.put("login", "Unknown login, please try again");
			}
		}

		request.setAttribute("messages", messages);
		request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
