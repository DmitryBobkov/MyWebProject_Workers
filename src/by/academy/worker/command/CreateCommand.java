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
import by.academy.worker.entities.Address;
import by.academy.worker.entities.Manager;
import by.academy.worker.entities.Scientist;
import by.academy.worker.entities.Worker;

/**
 * Class CreateCommand
 *
 */

public class CreateCommand implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String WORKER = "Worker";
		final String MANAGER = "Manager";
		final String SCIENTIST = "Scientist";
		final String WORKMAN = "Workman";

		final String TYPE = "type";
		final String NAME = "name";
		final String CITY = "city";
		final String COUNTRY = "country";
		final String POSITION = "position";
		final String GATHERING = "gathering";
		final String PUBLICATIONS = "publications";

		final String WORKERLIST = "workerList";
		final String SHOWALL_JSP = "/ShowAll.jsp";

		Worker worker = null;

		IWorkerJDBC iw = new WorkerJDBC();
		RequestDispatcher showAllPage = request.getRequestDispatcher(SHOWALL_JSP);
		List<Worker> workerList = new ArrayList<Worker>();

		String type = request.getParameter(TYPE);
		String name = request.getParameter(NAME);
		String city = request.getParameter(CITY);
		String country = request.getParameter(COUNTRY);

		if (WORKER.equals(type) || WORKMAN.equals(type)) {
			worker = new Worker(0, type, name, new Address(city, country));
		}

		if (MANAGER.equals(type)) {
			int position = Integer.parseInt(request.getParameter(POSITION));
			int gathering = Integer.parseInt(request.getParameter(GATHERING));
			worker = new Manager(0, type, name, new Address(city, country), position, gathering);
		}

		if (SCIENTIST.equals(type)) {
			int publications = Integer.parseInt(request.getParameter(PUBLICATIONS));
			worker = new Scientist(0, type, name, new Address(city, country), publications);
		}

		iw.create(worker);
		workerList = iw.showAll();
		request.setAttribute(WORKERLIST, workerList);
		showAllPage.forward(request, response);
	}

}
