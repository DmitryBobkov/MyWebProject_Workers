package by.academy.worker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import by.academy.worker.command.CommandFactory;
import by.academy.worker.command.ICommand;

/**
 * WorkerServlet
 * 
 */

@WebServlet("/WorkerServlet")
public class WorkerServlet extends HttpServlet {

	private static final long serialVersionUID = -1635927014543319699L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		CommandFactory factory = CommandFactory.getInstance();
		ICommand command = factory.getCommand(action);
		command.execute(request, response);
	}

}
