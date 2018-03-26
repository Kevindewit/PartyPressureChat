package BusinessLogicLayer.Authentication;

import BusinessLogicLayer.Authentication.User;

import java.util.*;

public class Authentication {

	Collection<User> user;

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public Authentication(String username, String password) {
		// TODO - implement Authentication.Authentication
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param password
	 */
	public Byte[] Encrypt(String password) {
		// TODO - implement Authentication.Encrypt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public User Validate(String username, Byte[] password) {
		// TODO - implement Authentication.Validate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public User SignUp(String username, String password) {
		// TODO - implement Authentication.SignUp
		throw new UnsupportedOperationException();
	}

	public User ProceedAsGuest() {
		// TODO - implement Authentication.ProceedAsGuest
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param password
	 * @param newPassword
	 */
	public void changePassword(String password, String newPassword) {
		// TODO - implement Authentication.changePassword
		throw new UnsupportedOperationException();
	}

}