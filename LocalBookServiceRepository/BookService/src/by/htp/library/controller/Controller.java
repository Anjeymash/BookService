package by.htp.library.controller;


public final class Controller {
private final CommandProvider provider = new CommandProvider();
private final char paramDelimeter = ' ';

public String executeTask(String request){
	String commandName;
	String response;
	
	Command executionCommand;
	commandName = request.substring(0, request.indexOf(paramDelimeter));
	
	executionCommand = provider.getCommand(commandName);
	response = executionCommand.execute(request);
	
	return response;
	
}
}
