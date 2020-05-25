package customExceptions;

@SuppressWarnings("serial")
public class RepeatedException extends Exception{

	
	public RepeatedException() {
		super("Person/Product already exists in database.");
	}
}
