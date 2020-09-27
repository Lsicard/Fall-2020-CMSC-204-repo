import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * PasswordUtilityChecker receives a String password or an Arraylist<String> passwords to check for password validity according to password requirements and throw appropriate invalid password exceptions.
 * @author Lucas Sicard
 *
 */
public class PasswordCheckerUtility {
	
	/**
	 * Constructor
	 */
	public PasswordCheckerUtility() {}
	//------//
	/**
	 * Checks password validity according to the password requirements. Return true if valid and throw one or more exceptions if invalid
	 * @param password String unchecked password
	 * @return Password validity boolean. Return true if valid and throw one or more exceptions if invalid
	 * @throws LengthException 
	 * @throws NoDigitException 
	 * @throws NoUpperAlphaException 
	 * @throws NoLowerAlphaException 
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 */
	public static boolean isValidPassword(java.lang.String password) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException {
		return (isValidLength(password)&&hasDigit(password)&&hasUpperAlpha(password)&&hasLowerAlpha(password)&&hasSpecialChar(password)&&!(hasSameCharInSequence(password)));
	}
	/**
	 * Checks if a String password is considered 'weak'. A 'weak' password is a valid password that is 6-9 characters in length. 
	 * @param password String unchecked password
	 * @return Password strength boolean. Return false if password is not 'weak' or throw WeakPasswordException
	 * @throws WeakPasswordException 
	 * @throws NoSpecialCharacterException 
	 * @throws InvalidSequenceException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws NoDigitException 
	 * @throws LengthException 
	 */
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException, LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException {
		if((isValidPassword(password)==true)&&(hasBetweenSixAndNineChars(password)==false)) {
			return false;
		}
		throw new WeakPasswordException();
	}
	/**
	 * Traverses and checks an Arraylist<String> unchecked passwords and creates an Arraylist<String>  invalid passwords in the correct format
	 * @param passwords Arraylist<String> unchecked passwords
	 * @return Return Arraylist<String> invalid passwords in the correct format: <password><blank><exception message>
	 */
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(ArrayList<java.lang.String> passwords){
		ArrayList<String> invalidPasswords= new ArrayList<String>();
		for(int i=0;i<passwords.size();i++) {
			String message = passwords.get(i) + " -> ";
			try {
				if(isValidPassword(passwords.get(i))==true) {
					continue;
				}
				} 
			catch (LengthException e) {
				message += e.getMessage();
			}
			catch (NoDigitException e) {
				message += e.getMessage();
			}
			catch (NoUpperAlphaException e) {
				message += e.getMessage();
			}
			catch (NoLowerAlphaException e) {
				message += e.getMessage();
			}
			catch (NoSpecialCharacterException e) {
				message += e.getMessage();
			}
			catch (InvalidSequenceException e) {
				message += e.getMessage();
			}
			invalidPasswords.add(message);
		}
		return invalidPasswords;
	}
	//------//
	/**
	 * Compares the length of two String passwords
	 * @param password 
	 * @param passwordConfirm
	 * @throws UnmatchedException 
	 */
	static void comparePasswords(java.lang.String password,java.lang.String passwordConfirm) throws UnmatchedException{
		if(password.equals(passwordConfirm)==false) {
			throw new UnmatchedException();
		}
	}
	/**
	 * Compare the length of two String passwords and return true if the same length 
	 * @param password
	 * @param passwordConfirm
	 * @return Return true if String passwords are identical, false if not identical
	 * @throws UnmatchedException 
	 */
	static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	
	/**
	 * Checks if String password length is between 6-9 characters
	 * @param password String unchecked password
	 * @return Return true if String password length is between 6-9 characters, false if not
	 */
	private static boolean hasBetweenSixAndNineChars(java.lang.String password){
		return ((password.length()>=6)&&(password.length()<=9));
	}
	/**
	 * Checks if String password contains a numerical character
	 * @param password String unchecked password
	 * @return Return true if String password contains at least one numerical character or throw NoDigitException 
	 * @throws NoDigitException 
	 */
	static boolean hasDigit(java.lang.String password) throws NoDigitException{
		for(int i=0;i<password.length();i++) {
			boolean flag = Character.isDigit(password.charAt(i));
			if(flag==true) {
				return flag;
			}
		}
		throw new NoDigitException();
	}
	/**
	 * Checks if String password contains at least one lowercase alphabetic character 
	 * @param password String unchecked password
	 * @return Return true String password contains at least one lowercase alphabetic character or throw NoLowerAlphaException 
	 * @throws NoLowerAlphaException 
	 */
	static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException {
		for(int i=0;i<password.length();i++) {
			boolean flag = Character.isLowerCase(password.charAt(i));
			if(flag==true) {
				return flag;
			}
		}
		throw new NoLowerAlphaException();
	}
	/**
	 * Checks if String password has more than two of a character in sequence.
	 * @param password String unchecked password
	 * @return Return false if String password does not contain at least three of the same character in sequence or throw InvalidSequenceException
	 * @throws InvalidSequenceException 
	 */
	static boolean hasSameCharInSequence(java.lang.String password) throws InvalidSequenceException{
		for(int i=0;i<password.length()-2;i++) {
			boolean flag = ((password.charAt(i)==password.charAt(i+1))&&(password.charAt(i+1))==password.charAt(i+2));
			if(flag==true) {
				throw new InvalidSequenceException();
				}
		}
		return false;
	}
	/**
	 * Checks if String password contains at least one special character
	 * @param password String unchecked password
	 * @return Return true if String password contains at least one special character or throw NoSpecialCharacterException
	 * @throws NoSpecialCharacterException 
	 */
	static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if((!matcher.matches())==true){
			return (!matcher.matches());
		}
		throw new NoSpecialCharacterException();
	}
	/**
	 * Checks if String password contains at least one uppercase alphabetic character 
	 * @param password String unchecked password
	 * @return Return true String password contains at least one uppercase alphabetic character or throw NoUpperAlphaException 
	 * @throws NoUpperAlphaException 
	 */
	static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException{
		for(int i=0;i<password.length();i++) {
			boolean flag = Character.isUpperCase(password.charAt(i));
			if(flag==true) {
				return flag;
			}
		}
		throw new NoUpperAlphaException();
	}
	/**
	 * Checks if String password length is 6 characters or greater
	 * @param password String unchecked password
	 * @return Return true if valid String password length or throw LengthException
	 * @throws LengthException 
	 */
	static boolean isValidLength(java.lang.String password) throws LengthException{
		if(password.length()>=6) {
			return true;
		}
		throw new LengthException();
	}
	
}
