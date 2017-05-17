package by.htp.library.controller.command.impl;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.service.LibraryService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;

public class AddBook implements Command{
public String execute(String request){
	
	String response = null;
	ServiceFactory serviceFactory = ServiceFactory.getInstance();
	LibraryService libraryService = serviceFactory.getLibraryService();
	String s[] =request.split(" ", 4);
	Book book = new Book(s[1], s[2], s[3]);
	try{
		libraryService.addNewBook(book);
		response = "Book "+ book.getName() + " " + book.getAuthor() + " " + book.getAge()+ " is added";
	}
	catch(ServiceException e){
		System.out.println(e);
		response = "Error adding append procedure";
	}
	
	return response;
}
}
