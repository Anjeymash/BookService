package by.htp.library.service;

import java.util.ArrayList;

import by.htp.library.bean.Book;

public interface LibraryService {
void addNewBook(Book book) throws ServiceException;
void delBook(Book book) throws ServiceException;
ArrayList<Book> fndBook(String name) throws ServiceException;
void addEditedBook(Book book)throws ServiceException;



}
