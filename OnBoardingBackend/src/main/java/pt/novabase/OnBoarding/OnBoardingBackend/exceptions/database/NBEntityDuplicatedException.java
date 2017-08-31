package pt.novabase.OnBoarding.OnBoardingBackend.exceptions.database;

import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBDatabaseException;

public class NBEntityDuplicatedException extends NBDatabaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6210395925562799702L;

	public NBEntityDuplicatedException(String message) {
		super(message);
	}
	
	public NBEntityDuplicatedException(Throwable t) {
		super(t);
	}
	
	public NBEntityDuplicatedException(String message, Throwable t) {
		super(message, t);
	}
}
