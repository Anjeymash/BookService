package by.htp.library.dao;

import by.htp.library.bean.Book;

public interface BookDAO {
        void addBook(Book book) throws DAOException;
        void deleteBook(Book book) throws DAOException;
       Book findBook(String name) throws DAOException; 


}