/**
 * LengthException thrown when String password length is less than six characters. Exception message will be displayed informing/instructing user.
 * @author Lucas Sicard
 *
 */
public class LengthException extends Exception {
	private String message = "The password must be at least 6 characters long";
	/**
	 * Constructor disp;aying default exception message
	 */
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
	/**
	 * Constructor passing String message to Exception. When this exception is thrown, this message will be displayed
	 * @param message String message stating exception definition and/or instruction
	 */
	public LengthException(String message) {
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
