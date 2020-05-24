package customExceptions;

@SuppressWarnings("serial")
public class LoginException extends Exception{
	
	public LoginException () {
		super("The username and password don't match");
	}
}
