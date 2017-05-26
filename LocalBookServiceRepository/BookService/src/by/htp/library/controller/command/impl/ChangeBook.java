package by.htp.library.controller.command.impl;

import java.util.ArrayList;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.service.LibraryService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;

public class ChangeBook implements Command {

        public String execute(String request) {
                String response;// = "changed";
                ArrayList<Book> foundBooks;

                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                LibraryService libraryService = serviceFactory.getLibraryService();

                String s[] = request.split(" ", 2);
                String pair[] = s[1].split("-",2);
                String p1[] = pair[0].split(" ", 3);
                String p2[] = pair[1].split(" ", 3);
                Book oldBook = new Book(p1[0],p1[1], p1[2]);
                Book newBook = new Book(p2[0], p2[1], p2[2]);
               // System.out.println(oldBook.getName() + " " + oldBook.getAuthor() + " " + oldBook.getAge());
                //System.out.println(newBook.getName() + " " + newBook.getAuthor() + " " + newBook.getAge());

                try {
                        libraryService.addEditedBook(oldBook, newBook);
                        response = oldBook.getName() + " " + oldBook.getAuthor() + " " + oldBook.getAge()+ "is changed to "+newBook.getName() + " " + newBook.getAuthor() + " " + newBook.getAge();
                       /* for(Book x:foundBooks)
                        response = response +"\n"+x.getName() + " " + x.getAuthor() + " " + x.getAge();*/
                } catch (ServiceException e) {
                    	e.printStackTrace();
                        response = "The book is not found";
                }

                return response;
        }
}