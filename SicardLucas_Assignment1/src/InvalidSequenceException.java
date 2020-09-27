/**
 * InvalidSequenceException thrown when String password contains more then two of the same character in a sequence. Exception message will be displayed informing/instructing user.
 * @author Lucas Sicard
 *
 */
public class InvalidSequenceException extends Exception {
	private String message = "The password cannot contain more than two of the same character in sequence";
	/**
	 * Constructor
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
	/**
	 * Constructor passing String message to Exception. When this exception is thrown, this message will be displayed
	 * @param message String message stating exception definition and/or instruction
	 */
	public InvalidSequenceException(String message) {
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
