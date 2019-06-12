package by.academy.worker.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.academy.worker.dao.IWorkerJDBC;
import by.academy.worker.dao.WorkerJDBC;
import by.academy.worker.entities.Worker;

/**
 * Class ReadCommand
 *
 */

public class ReadCommand implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String ID = "id";
		final String WORKERLIST = "workerList";
		final String SHOWUSER_JSP = "/ShowUser.jsp";

		IWorkerJDBC iw = new WorkerJDBC();
		RequestDispatcher showUserPage = request.getRequestDispatcher(SHOWUSER_JSP);
		List<Worker> workerList = new ArrayList<Worker>();

		workerList.add(iw.read(Integer.parseInt(request.getParameter(ID))));
		request.setAttribute(WORKERLIST, workerList);
		showUserPage.forward(request, response);
	}

}
