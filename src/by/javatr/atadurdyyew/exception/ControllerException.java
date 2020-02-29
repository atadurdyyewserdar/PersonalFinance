package by.javatr.atadurdyyew.exception;

public class ControllerException extends Exception {
    private static final long serialVersionUID = 1L;
    public ControllerException() {
        super();
    }

    public ControllerException(String msg) {
        super(msg);
    }

    public ControllerException(Exception ex) {
        super(ex);
    }

    public ControllerException(String msg, Exception ex) {
        super(msg, ex);
    }
}
