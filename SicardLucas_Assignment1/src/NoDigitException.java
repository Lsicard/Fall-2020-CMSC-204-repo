/**
 * NoDigit Exception thrown when String password contains no numerical characters. Exception message will be displayed informing/instructing user.
 * @author Lucas Sicard
 *
 */
public class NoDigitException extends Exception {
	private String message = "The password must contain at least one digit";
	/**
	 * Constructor displaying default exception message
	 */
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
	/**
	 * Constructor passing String message to Exception. When this exception is thrown, this message will be displayed
	 * @param message String message stating exception definition and/or instruction
	 */
	public NoDigitException(String message) {
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
