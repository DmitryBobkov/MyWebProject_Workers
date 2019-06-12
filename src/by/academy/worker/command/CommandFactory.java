package by.academy.worker.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Class CommandFactory
 *
 */

public class CommandFactory {

	private static final String SHOWALL = "showAll";
	private static final String NULL = "null";
	private static final String CREATE = "create";
	private static final String READ = "read";
	private static final String UPDATE = "update";
	private static final String DELETE = "delete";
	private static CommandFactory instance;
	static Map<String, ICommand> commandMap = new HashMap<String, ICommand>();

	static {
		commandMap.put(SHOWALL, new ShowAllCommand());
		commandMap.put(NULL, new ShowAllCommand());
		commandMap.put(CREATE, new CreateCommand());
		commandMap.put(READ, new ReadCommand());
		commandMap.put(UPDATE, new UpdateCommand());
		commandMap.put(DELETE, new DeleteCommand());
	}

	private CommandFactory() {
	}

	public static CommandFactory getInstance() {
		if (instance == null) {
			synchronized (CommandFactory.class) {
				instance = new CommandFactory();
			}
		}
		return instance;
	}

	public ICommand getCommand(String command) {
		return commandMap.get(command);
	}

}
