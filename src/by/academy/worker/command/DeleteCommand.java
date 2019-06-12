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
 * Class DeleteCommand
 *
 */

public class DeleteCommand implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String ID = "id";
		final String WORKERLIST = "workerList";
		final String SHOWALL_JSP = "/ShowAll.jsp";

		IWorkerJDBC iw = new WorkerJDBC();
		RequestDispatcher showAllPage = request.getRequestDispatcher(SHOWALL_JSP);
		List<Worker> workerList = new ArrayList<Worker>();

		iw.delete(Integer.parseInt(request.getParameter(ID)));
		workerList = iw.showAll();
		request.setAttribute(WORKERLIST, workerList);
		showAllPage.forward(request, response);
	}

}
