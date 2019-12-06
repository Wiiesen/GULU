package com.itranswarp.learnjava;
public class Main {

	public static void main(String[] args) {
			String token = login("admin", "pass");
			System.out.println("Token: " + token);
	}
	static String login(String username, String password) {
		try{
		if (username.equals("admin")) {
			if (password.equals("password")) {
				return "xxxxxx";
			} else {
				// 抛出LoginFailedException:
				throw new LoginFailedException("Bad username or password.");
			}
		} else {
			// 抛出UserNotFoundException:
			throw new UserNotFoundException("User not found.");
		}
	}
}
