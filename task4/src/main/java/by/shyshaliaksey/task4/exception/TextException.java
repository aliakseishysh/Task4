package by.shyshaliaksey.task4.exception;

public class TextException extends Exception {

	private static final long serialVersionUID = -3303410395502061392L;

	public TextException() {
		super();
	}

	public TextException(String message) {
		super(message);
	}

	public TextException(String message, Throwable cause) {
		super(message, cause);
	}

	public TextException(Throwable cause) {
		super(cause);
	}
}
