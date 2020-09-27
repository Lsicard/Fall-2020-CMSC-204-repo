/**
 * NoUpperAlphaException thrown when String password contains no uppercase  alphabetical characters. Exception message will be displayed informing/instructing user. 
 * @author Lucas Sicard
 *
 */
public class NoUpperAlphaException extends Exception {
	private String message = "The password must contain at least one uppercase alphabetic character";
	/**
	 * Constructor displaying default exception message
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character.");
	}
	/**
	 * Constructor passing String message to Exception. When this exception is thrown, this message will be displayed
	 * @param message String message stating exception definition and/or instruction
	 */
	public NoUpperAlphaException(String message) {
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
