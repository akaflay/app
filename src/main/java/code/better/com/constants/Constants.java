package code.better.com.constants;

import code.better.com.exception.CodeBetterException;

public class Constants {

	Constants() {

		throw new CodeBetterException("Not Allowed to call the constructor");
	}

	public static final String EMPTY = "";
	public static final String REGULAR_EXPRESSION = "[^a-z]+";

}
