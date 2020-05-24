package customExceptions;

@SuppressWarnings("serial")
public class EmptyFieldException extends Exception{

	public EmptyFieldException () {
		super("Input is empty");
	}
}
