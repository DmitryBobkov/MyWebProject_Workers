package by.academy.worker.loginUser;

import java.util.HashMap;
import java.util.Map;

/**
 * Class UserService
 *
 */

public class UserService {

	private static Map<String, User> usersMap = new HashMap<String, User>();

	static {
		usersMap.put("login1", new User("login1", "password1", "user"));
		usersMap.put("login2", new User("login2", "password2", "user"));
		usersMap.put("login3", new User("login3", "password3", "user"));
		usersMap.put("login4", new User("login4", "password4", "admin"));
		usersMap.put("login5", new User("login5", "password5", "admin"));
	}

	public static User find(String login, String password) {

		User findUser = usersMap.get(login);

		if (findUser != null && findUser.getPassword().equals(password)) {
			return findUser;
		} else {
			return null;
		}
	}

}
