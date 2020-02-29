package by.javatr.atadurdyyew.exception;

public class DAOException extends Exception{
    private static final long serialVersionUID = 1L;
    public DAOException() {
        super();
    }

    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(Exception ex) {
        super(ex);
    }

    public DAOException(String msg, Exception ex) {
        super(msg, ex);
    }
}
