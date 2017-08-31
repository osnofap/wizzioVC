package pt.novabase.OnBoarding.OnBoardingScript.exceptions;

public class NBSecurityException extends NBException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7839799572655165554L;

	public NBSecurityException(String message) {
		super(message);
	}
	
	public NBSecurityException(Throwable t) {
		super(t);
	}
	
	public NBSecurityException(String message, Throwable t) {
		super(message, t);
	}
}
