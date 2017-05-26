package by.htp.library.controller.command.impl;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
//import by.htp.library.dao.DAOException;
import by.htp.library.service.LibraryService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;

public class DelBook implements Command {

	public String execute(String request) {
		String response = null;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LibraryService libraryService = serviceFactory.getLibraryService();
		
		try {
		String s[] = request.split(" ", 4);
		Book book = new Book(s[1], s[2], s[3]);

		try {
			libraryService.delBook(book);
			response = "Book " + book.getName() + " " + book.getAuthor() + " " + book.getAge() + " deleted";
		} catch (ServiceException e) {
			e.printStackTrace();
			response = "Error duiring delete procedure";
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			response = "parsing failed";}
		
		return response;
	}
}
