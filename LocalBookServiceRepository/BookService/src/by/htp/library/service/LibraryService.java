package by.htp.library.service;

import by.htp.library.bean.Book;

public interface LibraryService {
void addNewBook(Book book) throws ServiceException;
void delBook(Book book) throws ServiceException;
Book fndBook(String name) throws ServiceException;
void addEditedBook(Book book)throws ServiceException;



}
