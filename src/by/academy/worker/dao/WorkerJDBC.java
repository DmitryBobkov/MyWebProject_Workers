package by.academy.worker.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.academy.worker.entities.Address;
import by.academy.worker.entities.Manager;
import by.academy.worker.entities.Scientist;
import by.academy.worker.entities.Worker;

/**
 * Class WorkerJDBC
 *
 */

public class WorkerJDBC implements IWorkerJDBC {

	private static final String WORKER = "Worker";
	private static final String MANAGER = "Manager";
	private static final String SCIENTIST = "Scientist";
	private static final String WORKMAN = "Workman";

	private static final String ID = "id";
	private static final String TYPE = "type";
	private static final String NAME = "name";
	private static final String CITY = "city";
	private static final String COUNTRY = "country";
	private static final String POSITION = "position";
	private static final String GATHERING = "gathering";
	private static final String PUBLICATIONS = "publications";

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	// will close in Controller

	@Override
	public void create(Worker worker) {

		String createWorker = null;
		System.out.print(worker.getType());
		String type = worker.getType();

		try (Connection connection = DataSource.getConnection()) {

			String temp = worker.getType() + "', '" + worker.getName() + "', '" + worker.getAddress().getCity() + "', '"
					+ worker.getAddress().getCountry();

			if (WORKER.equals(type) || WORKMAN.equals(type)) {
				createWorker = "INSERT INTO worker_table (type, name, city, country) VALUES ('" + temp + "');";

			} else if (MANAGER.equals(type)) {
				createWorker = "INSERT INTO worker_table (type, name, city, country, position, gathering) VALUES ('"
						+ temp + "', '" + ((Manager) worker).getPosition() + "', '" + ((Manager) worker).getGathering()
						+ "');";

			} else if (SCIENTIST.equals(type)) {
				createWorker = "INSERT INTO worker_table (type, name, city, country, publications) VALUES ('" + temp
						+ "', '" + ((Scientist) worker).getPublications() + "');";
			}
			PreparedStatement statemant = connection.prepareStatement(createWorker);
			statemant.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Worker read(int messageId) {

		Integer id = null;
		String type = null;
		String name = null;
		String city = null;
		String country = null;
		Integer position = null;
		Integer gathering = null;
		Integer publications = null;

		Worker worker = null;

		try (Connection connection = DataSource.getConnection()) {
			PreparedStatement statemant = connection.prepareStatement("SELECT * FROM worker_table WHERE id=?");

			statemant.setInt(1, messageId);
			ResultSet rs = statemant.executeQuery();

			while (rs.next()) {
				id = rs.getInt(ID);
				type = rs.getString(TYPE);
				name = rs.getString(NAME);
				city = rs.getString(CITY);
				country = rs.getString(COUNTRY);

				if (MANAGER.equals(type)) {
					position = rs.getInt(POSITION);
					gathering = rs.getInt(GATHERING);
				}

				if (SCIENTIST.equals(type)) {
					publications = rs.getInt(PUBLICATIONS);
				}
			}
			if (WORKER.equals(type) || WORKMAN.equals(type)) {
				worker = new Worker(id, type, name, new Address(city, country));
			}

			if (MANAGER.equals(type)) {
				worker = new Manager(id, type, name, new Address(city, country), position, gathering);
			}
			if (SCIENTIST.equals(type)) {
				worker = new Scientist(id, type, name, new Address(city, country), publications);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return worker;
	}

	@Override
	public void update(Worker worker) {

		try (Connection connection = DataSource.getConnection()) {

			String createWorker = null;

			if (WORKER.equals(worker.getType()) || WORKMAN.equals(worker.getType())) {
				createWorker = "UPDATE worker_table SET type = '" + worker.getType() + "', name = '" + worker.getName()
						+ "', city = '" + worker.getAddress().getCity() + "', country = '"
						+ worker.getAddress().getCountry()
						+ "', position = NULL, publications = NULL, gathering = NULL WHERE id = " + worker.getId()
						+ ";";

			} else if (MANAGER.equals(worker.getType())) {
				createWorker = "UPDATE worker_table SET type = '" + worker.getType() + "', name = '" + worker.getName()
						+ "', city = '" + worker.getAddress().getCity() + "', country = '"
						+ worker.getAddress().getCountry() + "', position = " + ((Manager) worker).getPosition()
						+ ", gathering = " + ((Manager) worker).getGathering() + ", publications = NULL WHERE id = "
						+ worker.getId() + ";";

			} else if (SCIENTIST.equals(worker.getType())) {
				createWorker = "UPDATE worker_table SET type = '" + worker.getType() + "', name = '" + worker.getName()
						+ "', city = '" + worker.getAddress().getCity() + "', country = '"
						+ worker.getAddress().getCountry() + "', publications = "
						+ ((Scientist) worker).getPublications() + ", position = NULL, gathering = NULL WHERE id = "
						+ worker.getId() + ";";
			}
			PreparedStatement statemant = connection.prepareStatement(createWorker);
			statemant.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int messageId) {

		try (Connection connection = DataSource.getConnection()) {
			PreparedStatement statemant = connection.prepareStatement("DELETE FROM worker_table WHERE id = ?");
			statemant.setInt(1, messageId);
			statemant.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Worker> showAll() {

		Integer id;
		String type;
		String name;
		String city;
		String country;
		Integer position = null;
		Integer gathering = null;
		Integer publications = null;

		Worker worker = null;

		List<Worker> resultList = new ArrayList<Worker>();

		try (Connection connection = DataSource.getConnection()) {
			PreparedStatement statemant = connection.prepareStatement("SELECT * FROM worker_table");
			ResultSet rs = statemant.executeQuery();
			while (rs.next()) {

				id = rs.getInt(ID);
				type = rs.getString(TYPE);
				name = rs.getString(NAME);
				city = rs.getString(CITY);
				country = rs.getString(COUNTRY);

				if (MANAGER.equals(type)) {
					position = rs.getInt(POSITION);
					gathering = rs.getInt(GATHERING);
				}

				if (SCIENTIST.equals(type)) {
					publications = rs.getInt(PUBLICATIONS);
				}

				if (type.equals(WORKER) || type.equals(WORKMAN)) {
					worker = new Worker(id, type, name, new Address(city, country));
				}

				if (MANAGER.equals(type)) {
					worker = new Manager(id, type, name, new Address(city, country), position, gathering);
				}
				if (SCIENTIST.equals(type)) {
					worker = new Scientist(id, type, name, new Address(city, country), publications);
				}
				resultList.add(worker);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
