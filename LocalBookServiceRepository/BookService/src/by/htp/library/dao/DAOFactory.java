package by.htp.library.dao;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	private final BookDAO sqlBookImpl = new SQLBookDAO();

	public static DAOFactory getInstance() {
		return instance;
	}

	public BookDAO getBookDAO() {
		return sqlBookImpl;
	}

}
