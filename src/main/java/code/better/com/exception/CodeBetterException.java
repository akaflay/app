package code.better.com.exception;


public class CodeBetterException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CodeBetterException(String errorMessage) {
		throw new CodeBetterException(errorMessage);
	}

}
