/**
 * UnmatchedException thrown when String password and String passwordConfirmed are not identical. Exception message will be displayed informing/instructing user. 
 * @author Lucas Sicard
 *
 */
public class UnmatchedException extends Exception {
	private String message = "Passwords do not match";
	/**
	 * Constructor displaying default exception message
	 */
	public UnmatchedException() {
		super("Passwords do not match");
	}
	/**
	 * Constructor passing String message to Exception. When this exception is thrown, this message will be displayed
	 * @param message String message stating exception definition and/or instruction
	 */
	public UnmatchedException(String message) {
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
