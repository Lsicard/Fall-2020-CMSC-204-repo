/**
 * WeakPasswordException thrown when String password qualifies as a valid password but has a String length between six and nine characters.  A 'weak' password is not invalid.
 * @author Lucas Sicard
 *
 */
public class WeakPasswordException extends Exception {
	private String message = "The password is OK but weak - it contains fewer than 10 characters";
	/**
	 * Constructor displaying default exception message
	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
	/**
	 * Constructor passing String message to Exception. When this exception is thrown, this message will be displayed
	 * @param message String message stating exception definition and/or instruction
	 */
	public WeakPasswordException(String message) {
		super(message);
	}
	/**
	 * Gets exception message
	 * @return Returns exception message
	 */
	public String getMessage() {
		return this.message;
	}
}
