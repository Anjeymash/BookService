package by.htp.library.dao;

import java.util.ArrayList;

import by.htp.library.bean.Book;

public interface BookDAO {
        void addBook(Book book) throws DAOException;
        void deleteBook(Book book) throws DAOException;
        ArrayList<Book> findBook(String name) throws DAOException;
        void addEditedBook(Book oldBook, Book newBook) throws DAOException;


}