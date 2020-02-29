package by.javatr.atadurdyyew.exception;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    public ServiceException() {
        super();
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(Exception ex) {
        super(ex);
    }

    public ServiceException(String msg, Exception ex) {
        super(msg, ex);
    }
}
