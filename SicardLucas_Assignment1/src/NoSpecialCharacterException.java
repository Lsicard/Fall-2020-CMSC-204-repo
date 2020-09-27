/**
 * NoSpcialCharacterException thrown when String password contains no special characters. Exception message will be displayed informing/instructing user.
 * @author Lucas Sicard
 *
 */
public class NoSpecialCharacterException extends Exception {
	private String message = "The password must contain at least one special character";
	/**
	 * Constructor displaying default exception message
	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
	/**
	 * Constructor passing String message to Exception. When this exception is thrown, this message will be displayed
	 * @param message String message stating exception definition and/or instruction
	 */
	public NoSpecialCharacterException(String message) {
		super(message);
	}
	/**
	 * Gets exception message
	 * @return Returns recent exception message
	 */
	public String getMessage() {
		return this.message;
	}
}
