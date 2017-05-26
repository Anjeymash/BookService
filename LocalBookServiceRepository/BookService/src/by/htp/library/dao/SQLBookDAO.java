package by.htp.library.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDAO;

public class SQLBookDAO implements BookDAO {
	@Override
	public void addBook(Book book) throws DAOException {
		initArrayListBook();
		books.add(book);
		writeToFile(book);
	}

	@Override
	public void deleteBook(Book book) throws DAOException {
		// TODO Auto-generated method stub
		initArrayListBook();
		dBook(book);
		writeToFile(books);

	}

	@Override
	public ArrayList<Book> findBook(String name) throws DAOException {
		// TODO Auto-generated method stub
		initArrayListBook();
		fBook(name);
		return foundbooks;

	}

	@Override
	public void addEditedBook(Book oldBook, Book newBook) throws DAOException {
		// TODO Auto-generated method stub
		initArrayListBook();
		chBook(oldBook, newBook);
		writeToFile(books);

	}

	public static ArrayList<Book> books = new ArrayList<Book>();
	public static ArrayList<Book> foundbooks = new ArrayList<Book>();

	public static void initArrayListBook() throws DAOException {

		String[] str = new String[3];
		try {
			Scanner in = new Scanner(new File("books.txt"));

			Book mybook;
			while (in.hasNext()) {
				str = in.nextLine().split(" ", 4);
				mybook = new Book(str[0], str[1], str[2]);
				books.add(mybook);
			}
			in.close();
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		}

	}

	public static void fBook(String s) throws DAOException {
		for (Book x : books) {
			if (x.getName().equals(s)) {
				foundbooks.add(x);
			}
		}
		if (foundbooks.isEmpty()) {
			throw new DAOException("such a book does not exist");
		}
	}

	public static void chBook(Book oldbook, Book newBook) throws DAOException {
		int count = 0;
		for (Book x : books) {
			if (x.equals(oldbook)) {
				x.setName(newBook.getName());
				x.setAuthor(newBook.getAuthor());
				x.setAge(newBook.getAge());
				count++;
			}
			
		}
		if (count == 0)
			throw new DAOException("such a book does not exist");

	}

	public static void dBook(Book book) throws DAOException {
		int count = 0;
		for (int i = 0; i < books.size(); i++) {
			if (book.equals(books.get(i))) {
				count++;
				books.remove(i);
			}
		}

		if (count == 0) {
			throw new DAOException("such a book does not exist");
		}
	}

	public static void writeToFile(Book book) throws DAOException {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt", true));
			bw.write(book.getName() + " ");
			bw.write(book.getAuthor() + " ");
			bw.write(book.getAge() + '\n');

			bw.close();

			/*
			 * } catch (FileNotFoundException e) { throw new
			 * DAOException("file not found", e);
			 */

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException("writing to file error", e);
		}

	}

	public static void writeToFile(ArrayList<Book> books) throws DAOException {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt", false));
			for (Book x : books) {

				bw.write(x.getName() + " ");
				bw.write(x.getAuthor() + " ");
				bw.write(x.getAge() + "\n");

			}
			bw.close();
			// finally {bw.close();}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException("writing to file error", e);
		}

	}

}