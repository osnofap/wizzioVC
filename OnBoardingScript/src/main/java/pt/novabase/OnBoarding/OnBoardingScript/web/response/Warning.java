package pt.novabase.OnBoarding.OnBoardingScript.web.response;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Warning {
	private int id;
	private String message;
	
	enum Warns {
		UNKNOWN(0),
		MAX_RESULTS(1),;
		
		private int code;
		
		Warns(int code) {
			this.code = code;
		}
	}
	
	public Warning() {
	}
	
	private Warning(Warns warn, String message) {
		this.id = warn.code;
		this.message = message;
	}
	
	public static Warning maxResults(int max) {
		return new Warning(Warns.MAX_RESULTS,
				"Demasiados resultados encontrados. São mostrados os primeiros " + max + " processos.");
	}
	
	public int getId() {
		return id;
	}
	
	@JsonSetter("Id")
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	@JsonSetter("Message")
	public void setMessage(String message) {
		this.message = message;
	}
}
