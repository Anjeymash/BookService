package by.htp.library.controller.command.impl;

import by.htp.library.controller.Command;

public class WrongRequest implements Command {
	String response;

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		return response = "The command is invalid";

	}

}
