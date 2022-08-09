package hcmute.edu.tgdd.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	private static final String VALID_PHONE_REGEX = "^\\d{10}$";
	private static final String VALID_EMAIL_REGEX = " ^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
	
	public enum Type{
		EMAIl,
		PHONE;
	}
	
	public static boolean isWhatever(Type type, String value)
	{
		String tempRegex = "";
		switch (type) {
			case EMAIl:
				tempRegex = VALID_EMAIL_REGEX;
			case PHONE:
				tempRegex = VALID_PHONE_REGEX;
		}
		Pattern pattern = Pattern.compile(tempRegex);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
}
