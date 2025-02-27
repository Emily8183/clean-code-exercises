package com.b.simple.design.business.text;

public class TextHelper {

	public String swapLastTwoCharacters(String str) {

		int length = str.length();

		if (length < 2) return str;

		char lastChar = str.charAt(length-1);
		char secondLastChar = str.charAt(length-2);

		String restOfTheString = str.substring(0, length-2);

		return restOfTheString + lastChar + secondLastChar;
		
	}

	public String truncateAInFirst2Positions(String str) {
		if (str.length() < 2) return str.replaceAll("A","");

		String firstTwoCharacters = str.substring(0,2);

		String restOfString = str.substring(2);

		String updatedFirstTwoCharacters = firstTwoCharacters.replaceAll("A", "");
		//String is immutable, so have to assign to a new variable

		return updatedFirstTwoCharacters + restOfString;
	}
}
