package banco.com.dao;

public class DAOException extends Exception {

 
	private static final long serialVersionUID = 1L;


    public DAOException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

 
    public DAOException(String errorMessage) {
        super(errorMessage);
    }
}
