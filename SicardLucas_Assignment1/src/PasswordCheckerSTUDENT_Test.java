
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Lucas Sicard
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	String passwordControl = "Abc123@paSsword";
	String passwordInvalidLength = "Efg4@";
	String passwordNoDigit = "Hij@#$%";
	String passwordNoUpperAlpha = "klm567@";
	String passwordNoLowerAlpha = "NOP890@";
	String passwordNoSpecialChar = "Qrs1011";
	String passwordInvalidSequence = "TTTuv12@";
	String weakPassword = "Wxy13@";
	
	@BeforeEach
	void setUp() throws Exception {}

	@AfterEach
	void tearDown() throws Exception {
		passwords = null;
	}
	
	/**
	 * Given two different passwords, compares equality of them (case sensitive)
	 * Invokes comparePasswords method
	 * If the UnmatchedException exception is thrown, the test succeeded, otherwise it fails.
	 */
	@Test
	public void testComparePasswordsNotSame() {
		Throwable exception = Assertions.assertThrows(UnmatchedException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.comparePasswords(passwordControl, passwordInvalidLength);
			}			
		});
		assertEquals("Passwords do not match", exception.getMessage());
	}
	
	/**
	 * Given two same passwords, compares equality of them (case sensitive)
	 * Invokes comparePasswords method
	 * Assert that the both passwords are the same 
	 */
	@Test
	public void testComparePasswordsSame() {
		try {
			PasswordCheckerUtility.comparePasswords(passwordControl, passwordControl);
		} catch (UnmatchedException e) {				
			e.printStackTrace();
		}
	}
	
	/**
	 * Given two same and two different passwords, compares equality of them (case sensitive)
	 * Invokes comparePasswordsWithReturn method	 * 
	 * Assert true or false; both passwords are/are not the same 
	 */
	@Test 
	public void testComparePasswordsWithReturn() {
		assertFalse(PasswordCheckerUtility.comparePasswordsWithReturn(passwordControl, passwordInvalidLength));
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn(passwordControl, passwordControl));
	}

	/**
	 * Give a password with valid length
	 * Invokes isValidLength method	  
	 * Assert that given a password is a valid length
	 */
	@Test
	public void testValidLengthValid()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength(passwordControl));
		} catch (LengthException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Give a password with invalid length
	 * Invokes isValidLength method
	 * If the LengthException exception is thrown, the test succeeded, otherwise it fails.
	 */
	@Test
	public void testInValidLength() {
		Throwable exception = Assertions.assertThrows(LengthException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidLength(passwordInvalidLength);
			}			
		});
		assertEquals("The password must be at least 6 characters long", exception.getMessage());
	}
	
	/**
	 * Give a password that Has Upper Alpha 
	 * Invokes hasUpperAlpha method	  
	 * Assert that given a password Has Upper Alpha 
	 */
	@Test
	public void testHasUpperAlphaValid() {
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(passwordControl));
		} catch (NoUpperAlphaException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Give a password that does not have Upper Alpha 
	 * Invokes hasUpperAlpha method	  
	 * If the NoUpperAlphaException exception is thrown, the test succeeded, otherwise it fails.
	 */
	@Test
	public void testDoesNotHaveUpperAlpha() {
		Throwable exception = Assertions.assertThrows(NoUpperAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasUpperAlpha(passwordNoUpperAlpha);
			}			
		});
		assertEquals("The password must contain at least one uppercase alphabetic character", exception.getMessage());
	}
	
	/**
	 * Give a password that Has Lower Alpha 
	 * Invokes hasLowerAlpha method	  
	 * Assert that given a password Has Lower Alpha 
	 */
	@Test
	public void testHasLowerAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(passwordControl));
		} catch (NoLowerAlphaException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Give a password that does not have Lower Alpha 
	 * Invokes hasLowerAlpha method	  
	 * If the NoLowerAlphaException exception is thrown, the test succeeded, otherwise it fails.
	 */
	@Test
	public void testDoesNotHaveLowerAlpha() {
		Throwable exception = Assertions.assertThrows(NoLowerAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasLowerAlpha(passwordNoLowerAlpha);
			}			
		});
		assertEquals("The password must contain at least one lowercase alphabetic character", exception.getMessage());
	}
	
	/**
	 * Give a password that Has Digit 
	 * Invokes hasDigit method	  
	 * Assert that given a password Has Digit 
	 */
	@Test
	public void testHasDigit() {
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(passwordControl));
		} catch (NoDigitException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Give a password that does not have Digit 
	 * Invokes hasDigit method	  
	 * If the NoDigitException exception is thrown, the test succeeded, otherwise it fails.
	 */
	@Test
	public void testDoesNotHaveDigit() {
		Throwable exception = Assertions.assertThrows(NoDigitException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasDigit(passwordNoDigit);
			}			
		});
		assertEquals("The password must contain at least one digit", exception.getMessage());
	}
	
	/**
	 * Give a password that has a Special character
	 * Invokes hasSpecialChar method	  
	 * Assert that given a password Has Special character
	 */
	@Test
	public void testHasSpecialChar() {
		try {
			assertTrue(PasswordCheckerUtility.hasSpecialChar(passwordControl));
		} catch (NoSpecialCharacterException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Give a password that does not have a Special character
	 * Invokes hasSpecialChar method	  
	 * If the NoSpecialCharacterException exception is thrown, the test succeeded, otherwise it fails.
	 */
	@Test
	public void testDoesNotHaveSpecialChar() {
		Throwable exception = Assertions.assertThrows(NoSpecialCharacterException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSpecialChar(passwordNoSpecialChar);
			}			
		});
		assertEquals("The password must contain at least one special character", exception.getMessage());
	}
	
	/**
	 * Give a password that Has more than two Chars In Sequence
	 * Invokes hasSameCharInSequence method	  
	 * If the InvalidSequenceException exception is thrown, the test succeeded, otherwise it fails.
	 */
	@Test
	public void testHasSameCharInSequence() {
		Throwable exception = Assertions.assertThrows(InvalidSequenceException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSameCharInSequence(passwordInvalidSequence);
			}			
		});
		assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());
	}
	
	/**
	 * Give a password that does not have more than two Chars In Sequence
	 * Invokes hasSameCharInSequence method	  
	 * Assert that given a password does not have more than two Chars In Sequence
	 */
	@Test
	public void testDoesNotHaveSameCharInSequence() {
		try {
			assertFalse(PasswordCheckerUtility.hasSameCharInSequence(passwordControl));
		} catch (InvalidSequenceException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Give a valid password with less than 10 characters
	 * Invokes isWeakPassword method	  
	 * If the WeakPasswordException exception is thrown, the test succeeded, otherwise it fails.
	 */
	@Test
	public void testIsWeakPassword() {
		Throwable exception = Assertions.assertThrows(WeakPasswordException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isWeakPassword(weakPassword);
			}			
		});
		assertEquals("The password is OK but weak - it contains fewer than 10 characters", exception.getMessage());
	}
	
	/**
	 * Give a valid password with more than 10 characters
	 * Invokes isWeakPassword method	  
	 * Assert that given a password is not weak
	 */
	@Test
	public void testIsNotWeakPassword() {
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(passwordControl));
		} catch (WeakPasswordException | LengthException | NoDigitException | NoUpperAlphaException
				| NoLowerAlphaException | InvalidSequenceException | NoSpecialCharacterException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Give an array of valid and invalid passwords
	 * Invokes getInvalidPasswords method	  
	 * Assert the size of expected result
	 * Assert each entry matches the expected result
	 */
	@Test
	public void testGetInvalidPasswords() {
		passwords = new ArrayList<String>();
		passwords.add(passwordControl);
		passwords.add(passwordInvalidLength);
		passwords.add(passwordInvalidSequence);
		passwords.add(passwordNoDigit);
		passwords.add(passwordNoLowerAlpha);
		passwords.add(passwordNoSpecialChar);
		passwords.add(passwordNoUpperAlpha);
		passwords.add(weakPassword);
		
		ArrayList invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(invalidPasswords.size(), 6);
		assertEquals(invalidPasswords.get(0), "Efg4@ -> The password must be at least 6 characters long");
		assertEquals(invalidPasswords.get(1), "TTTuv12@ -> The password cannot contain more than two of the same character in sequence");
		assertEquals(invalidPasswords.get(2), "Hij@#$% -> The password must contain at least one digit");
		assertEquals(invalidPasswords.get(3), "NOP890@ -> The password must contain at least one lowercase alphabetic character");
		assertEquals(invalidPasswords.get(4), "Qrs1011 -> The password must contain at least one special character");
		assertEquals(invalidPasswords.get(5), "klm567@ -> The password must contain at least one uppercase alphabetic character");  
	}
	
	/**
	 * Give an array of only valid passwords
	 * Invokes getInvalidPasswords method	  
	 * Assert the expected result array is empty since all passwords are valid
	 */
	@Test
	public void testGetValidPasswords() {
		passwords = new ArrayList<String>(); 
		passwords.add(passwordControl);
		passwords.add(weakPassword);
		
		assertTrue(PasswordCheckerUtility.getInvalidPasswords(passwords).isEmpty());
	}            
}      