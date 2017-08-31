package pt.novabase.OnBoarding.OnBoardingBackend.web.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonSetter;

@XmlRootElement
public class Error {
	private int id;
	private String message;
	
	enum Errors {
		UNKNOWN(-1),
		NOT_FOUND(1),
		DUPLICATED(2),
		INVALID(3),
		BUSINESS(4);
		
		private int code;
		
		Errors(int code) {
			this.code = code;
		}
	}
	
	public Error() {
	}
	
	protected static Error error(Errors errorid, String message) {
		Error error = new Error();
		error.id = errorid.code;
		error.message = message;
		return error;
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
