package pt.novabase.OnBoarding.OnBoardingBackend.exceptions;

public class NBConnectorException extends NBException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2057522012322526362L;

	public NBConnectorException(String message) {
		super(message);
	}
	
	public NBConnectorException(Throwable t) {
		super(t);
	}
	
	public NBConnectorException(String message, Throwable t) {
		super(message, t);
	}
}
