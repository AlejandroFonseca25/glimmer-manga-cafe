package customExceptions;

@SuppressWarnings("serial")
public class EmptyFieldException extends Exception{

	public EmptyFieldException () {
		super("A field or fields are empty. Try again.");
	}
}
