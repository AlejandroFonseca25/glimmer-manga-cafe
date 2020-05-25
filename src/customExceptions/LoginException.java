package customExceptions;

@SuppressWarnings("serial")
public class LoginException extends Exception{
	
	public LoginException () {
		super("Incorrect username or password. Try again.");
	}
}
