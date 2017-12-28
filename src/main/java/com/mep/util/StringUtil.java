package com.mep.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	private static final String PASSWORD_CHECK = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	
	private static final String ENGLISH_LANGUAGE_CHECK = "^[\\s*a-zA-Z0-9]+$";

	public static boolean validatePassword(String strPassword) {
		if (!validateRegex(strPassword, PASSWORD_CHECK)) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean validateInputLanguage(String str) {
		if (!validateRegex(str, ENGLISH_LANGUAGE_CHECK)) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean validateRegex(String str, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.find();
	}
	
	public static String replaceWhiteSpaceWithHyphen(String str) {		
		return str.replace(' ', '-');
	}
	
	public static String replaceHyphenWithWhiteSpace(String str) {
		return str.replace('-', ' ');
	}
}
