package by.academy.worker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Class DataSource
 *
 */

public class DataSource {

	private static Connection connection;

	public static Connection getConnection() {

		String urlDB = "db.url";
		String userDB = "db.user";
		String passDB = "db.password";
		String resourceDB = "database";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			ResourceBundle resource = ResourceBundle.getBundle(resourceDB);
			String url = resource.getString(urlDB);
			String user = resource.getString(userDB);
			String pass = resource.getString(passDB);

			connection = DriverManager.getConnection(url, user, pass);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
