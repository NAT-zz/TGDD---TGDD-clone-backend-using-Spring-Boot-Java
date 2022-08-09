package hcmute.edu.tgdd.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	private static final String VALID_PHONE_REGEX = "^\\d{10}$";
	private static final String VALID_EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	
	public enum Type{
		EMAIl,
		PHONE;
	}
	
	public static boolean isWhatever(Type type, String value)
	{
		String tempRegex = "";
		switch (type) {
			case PHONE:
				tempRegex = VALID_PHONE_REGEX;
				break;
			case EMAIl:
				tempRegex = VALID_EMAIL_REGEX;
				break;
		}
		Pattern pattern = Pattern.compile(tempRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
}
