package by.javatr.atadurdyyew.exception;

public class ConvertorException extends Exception {
    private static final long serialVersionUID = 1L;

    public ConvertorException() {
        super();
    }

    public ConvertorException(String msg) {
        super(msg);
    }

    public ConvertorException(Exception ex) {
        super(ex);
    }

    public ConvertorException(String msg, Exception ex) {
        super(msg, ex);
    }
}
