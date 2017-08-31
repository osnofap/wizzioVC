package pt.novabase.OnBoarding.OnBoardingBackend.exceptions;

public class NBMappingException extends NBException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NBMappingException(String message) {
		super(message);
	}
	
	public NBMappingException(Throwable t) {
		super(t);
	}
	
	public NBMappingException(String message, Throwable t) {
		super(message, t);
	}
}
