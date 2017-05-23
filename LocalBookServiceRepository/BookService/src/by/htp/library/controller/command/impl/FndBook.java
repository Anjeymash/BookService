package by.htp.library.controller.command.impl;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.service.LibraryService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;

public class FndBook implements Command {

	public String execute(String request) {
		String response = null;
		Book book;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LibraryService libraryService = serviceFactory.getLibraryService();

		String s[] = request.split(" ", 2);

		try {
			book = libraryService.fndBook(s[1]);
			response = "The book " + book.getName() + " " + book.getAuthor() + " " + book.getAge() + " is found";
		} catch (ServiceException e) {
			e.printStackTrace();
			response = "The book is not found";
		}

		return response;
	}
}