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
	public Book findBook(String name) throws DAOException {
		// TODO Auto-generated method stub
		Book book = null;

		initArrayListBook();
		book = fBook(name);
		return book;

	}

	public static ArrayList<Book> books = new ArrayList<Book>();

	public static void initArrayListBook() throws DAOException {

		String[] str = new String[3];
		try {
			Scanner in = new Scanner(new File("books.txt"));

			Book mybook;
			while (in.hasNext()) {
				str = in.nextLine().split(" ", 3);
				mybook = new Book(str[0], str[1], str[2]);
				books.add(mybook);
			}
			in.close();
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		}

	}

	public static Book fBook(String s) throws DAOException {
		Book book = null;
		for (Book x : books) {
			if (x.getName().equals(s)) {
			book = x;
			}
		}
		if (book == null) {
			throw new DAOException("such a book does not exist");
		}
		return book;
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
			bw.write(book.getAge() + " ");
			bw.write('\n');

			bw.close();
			/*
			 * } catch (FileNotFoundException e) { throw new
			 * DAOException("файл не найден", e);
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
				bw.write(x.getAge() + " ");
				bw.write('\n');

			}
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException("writing to file error", e);
		}

	}

}