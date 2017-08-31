package pt.novabase.OnBoarding.OnBoardingBackend.exceptions;

public class NBDatabaseException extends NBException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -271347054950589097L;
	
	public NBDatabaseException(String message) {
		super(message);
	}
	
	public NBDatabaseException(Throwable t) {
		super(t);
	}
	
	public NBDatabaseException(String message, Throwable t) {
		super(message, t);
	}
}
