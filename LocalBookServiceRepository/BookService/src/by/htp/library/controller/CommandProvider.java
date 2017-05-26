package by.htp.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.library.controller.command.CommandName;
import by.htp.library.controller.command.impl.AddBook;
import by.htp.library.controller.command.impl.ChangeBook;
import by.htp.library.controller.command.impl.DelBook;
import by.htp.library.controller.command.impl.FndBook;
import by.htp.library.controller.command.impl.WrongRequest;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.ADD_BOOK, new AddBook());
		repository.put(CommandName.FND_BOOK, new FndBook());
		repository.put(CommandName.DEL_BOOK, new DelBook());
		repository.put(CommandName.CHANGE_BOOK, new ChangeBook());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());

	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

}
