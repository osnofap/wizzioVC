package pt.novabase.OnBoarding.OnBoardingScript.exceptions;

public class NBBusinessConnectorException extends NBConnectorException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8643939855575569629L;

	public NBBusinessConnectorException(String message) {
		super(message);
	}
	
	public NBBusinessConnectorException(Throwable t) {
		super(t);
	}
	
	public NBBusinessConnectorException(String message, Throwable t) {
		super(message, t);
	}
}
