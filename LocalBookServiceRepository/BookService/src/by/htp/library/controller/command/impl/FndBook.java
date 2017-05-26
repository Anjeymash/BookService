package by.htp.library.controller.command.impl;

import java.util.ArrayList;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.service.LibraryService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;

public class FndBook implements Command {

	public String execute(String request) {
		String response = "found";
		ArrayList<Book> foundBooks;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LibraryService libraryService = serviceFactory.getLibraryService();

		try {
			String s[] = request.split(" ", 2);

			try {
				foundBooks = libraryService.fndBook(s[1]);
				for (Book x : foundBooks)
					response = response + "\n" + x.getName() + " " + x.getAuthor() + " " + x.getAge();
			} catch (ServiceException e) {
				e.printStackTrace();
				response = "The book is not found";
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = "parsing failed";
		}
		return response;
	}
}