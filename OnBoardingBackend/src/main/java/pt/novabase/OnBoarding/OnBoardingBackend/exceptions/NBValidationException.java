package pt.novabase.OnBoarding.OnBoardingBackend.exceptions;

public class NBValidationException extends NBException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8335341878730610441L;

	public NBValidationException(String message) {
		super(message);
	}
	
	public NBValidationException(Throwable t) {
		super(t);
	}
	
	public NBValidationException(String message, Throwable t) {
		super(message, t);
	}
}
