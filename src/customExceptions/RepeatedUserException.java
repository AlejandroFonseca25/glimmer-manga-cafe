package customExceptions;

@SuppressWarnings("serial")
public class RepeatedUserException extends Exception{

	
	public RepeatedUserException() {
		
		super("User already exists in database");
	}
}
