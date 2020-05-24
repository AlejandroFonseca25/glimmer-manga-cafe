package customExceptions;

public class RepeatedUserException extends Exception{

	
	public RepeatedUserException() {
		
		super("User already exists in database");
	}
}
