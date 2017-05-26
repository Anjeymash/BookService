package by.htp.library.service;

import java.util.ArrayList;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.DAOException;
import by.htp.library.dao.DAOFactory;

public class LibraryServiceImpl implements LibraryService {

	@Override
	public void addNewBook(Book book) throws ServiceException {
		// input data check
		if ((book == null) || (book.getName().contains(" ")) || (book.getAge().contains(" "))
				|| (book.getAuthor().contains(" "))) {
			throw new ServiceException("Incorrect input data");
		}
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			BookDAO bookDAO = daoObjectFactory.getBookDAO();
			bookDAO.addBook(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub
		if ((book == null) || (book.getName().contains(" ")) || (book.getAge().contains(" "))
				|| (book.getAuthor().contains(" "))) {
			throw new ServiceException("Incorrect input data");
		}
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			BookDAO bookDAO = daoObjectFactory.getBookDAO();
			bookDAO.deleteBook(book);
		} catch (DAOException e) {
			throw new ServiceException(e);// System.out.println(d);
		}
	}

	@Override
	public ArrayList<Book> fndBook(String name) throws ServiceException {
		// TODO Auto-generated method stub
		ArrayList<Book> foundbooks = null;
		if (name == null) {
			throw new ServiceException("Incorrect input data");
		}
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			BookDAO bookDAO = daoObjectFactory.getBookDAO();
			foundbooks = bookDAO.findBook(name);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return foundbooks;

	}

	// œ≈–≈œ»—¿“‹!!!!!
	@Override
	public void addEditedBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub
		if (book == null) {
			throw new ServiceException("Incorrect input data");
		}
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			BookDAO bookDAO = daoObjectFactory.getBookDAO();
			//bookDAO.deleteBook(book);
			bookDAO.addBook(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
