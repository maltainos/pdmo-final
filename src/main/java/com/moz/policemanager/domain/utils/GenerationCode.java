package com.moz.policemanager.domain.utils;

import java.security.SecureRandom;
import java.util.Random;

public class GenerationCode {
	
	private static final Random RANDOM = new SecureRandom();
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVXWYZabcdefghijklmnopqrstuvxwyz";
	
	public String getCodeUser(int length) {
		return generationCodeUser(length);
	}
	
	private String generationCodeUser(int length) {
		StringBuilder string = new StringBuilder();
		
		for(int i = 0; i < length; i++)
			string.append(ALPHABET.charAt(RANDOM.nextInt(10)));
		
		return string.toString();
	}
	
	public String getCodeResource(int length) {
		return generationCodeResource(length);
	}
	
	private String generationCodeResource(int length) {
		StringBuilder string = new StringBuilder();
		
		for(int i = 0; i < length; i++)
			string.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		
		return string.toString();
	}

}









