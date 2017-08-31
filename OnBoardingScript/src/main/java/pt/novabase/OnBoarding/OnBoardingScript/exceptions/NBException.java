package pt.novabase.OnBoarding.OnBoardingScript.exceptions;

import org.slf4j.LoggerFactory;

/**
 * Base exception for all exceptions
 * @author NB18140
 *
 */
public class NBException extends Exception {

	private boolean logged = false;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6853162687634971426L;

	public NBException() {
		super();
	}
	
	public NBException(String message) {
		super(message);
	}
	
	public NBException(Throwable t) {
		super(t);
	}
	
	public NBException(String message, Throwable t) {
		super(message, t);
	}
	
	/**
	 * Logs an exception only once<br>
	 * Prevents repeated error logging
	 * @param message
	 * @param clazz
	 */
	public final void logException(String message, Class<?> clazz) {
		if(!logged) {
			LoggerFactory.getLogger(clazz).error(message, this);
			logged = true;
		}
	}
}
