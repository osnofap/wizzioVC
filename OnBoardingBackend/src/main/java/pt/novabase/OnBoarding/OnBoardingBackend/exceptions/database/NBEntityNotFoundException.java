package pt.novabase.OnBoarding.OnBoardingBackend.exceptions.database;

import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBDatabaseException;

public class NBEntityNotFoundException extends NBDatabaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4927468172038141622L;

	public NBEntityNotFoundException(String message) {
		super(message);
	}
	
	public NBEntityNotFoundException(Throwable t) {
		super(t);
	}
	
	public NBEntityNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
