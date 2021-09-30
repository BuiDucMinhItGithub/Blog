package com.blog.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static boolean ckEmail(String email, String regex) {
		regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex); 
		Matcher m = pattern.matcher(email);  
		if(m.matches()) {
			return true;
		}else {
			return false;
		}
	}
}
