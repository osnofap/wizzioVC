package pt.novabase.OnBoarding.OnBoardingBackend.web.response;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBBusinessConnectorException;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBDatabaseException;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBException;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBMappingException;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBValidationException;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.database.NBEntityDuplicatedException;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.database.NBEntityNotFoundException;
import pt.novabase.OnBoarding.OnBoardingBackend.web.response.Error.Errors;

@XmlRootElement
public class ServiceResult {
	private Object data;
	
	private List<Error> errors;
	private List <Warning> warnings;
	
	@JsonIgnore
	private Response.Status webStatus;
	
	public ServiceResult() {
	}
	
	public ServiceResult(Object data, List<Error> errors, List <Warning> warnings) {
		this.data = data;
		this.errors = errors;
		this.warnings = warnings;
	}
	
	public void addWarningMaxResults(int max) {
		if(getWarnings() == null) {
			setWarnings(new ArrayList<Warning>());
		}
		getWarnings().add(Warning.maxResults(max));
	}
	
	private static void error(ServiceResult result,Error error, Warning warning) {
		ArrayList<Error> errors = new ArrayList<Error>();
		ArrayList<Warning> warnings = new ArrayList<Warning>();
		
		if(error != null)
			errors.add(error);
		if(warning != null)
			warnings.add(warning);
		
		if(errors.size() > 0)
			result.errors = errors;
		if(warnings.size() > 0)
			result.warnings = warnings;
	}
	
	public static ServiceResult error(Throwable t) {
		ServiceResult sr = new ServiceResult();
		
		if(t instanceof NBException) {
			if(t instanceof NBDatabaseException) {
				if(t instanceof NBEntityNotFoundException) {
					sr.webStatus = Status.NOT_FOUND;
					error(sr, Error.error(Errors.NOT_FOUND, t.getMessage()), null);
					return sr;
				} else if(t instanceof NBEntityDuplicatedException) {
					sr.webStatus = Status.CONFLICT;
					error(sr, Error.error(Errors.DUPLICATED, t.getMessage()), null);
					return sr;
				}
				
				sr.webStatus = Status.INTERNAL_SERVER_ERROR;
				error(sr, Error.error(Errors.UNKNOWN, t.getMessage()), null);
				
			} else if(t instanceof NBMappingException || t instanceof NBValidationException) {
				sr.webStatus = Status.INTERNAL_SERVER_ERROR;
				error(sr, Error.error(Errors.INVALID, t.getMessage()), null);
			} else if(t instanceof NBBusinessConnectorException) {
				sr.webStatus = Status.INTERNAL_SERVER_ERROR;
				error(sr, Error.error(Errors.BUSINESS, t.getMessage()), null);
			} else {
				sr.webStatus = Status.INTERNAL_SERVER_ERROR;
				error(sr, Error.error(Errors.UNKNOWN, t.getMessage()), null);
			}
		} else {
			sr.webStatus = Status.INTERNAL_SERVER_ERROR;
			error(sr, Error.error(Errors.UNKNOWN, t.getMessage()), null);
		}
		return sr;
	}
	
	public ServiceResult(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	
	@JsonSetter("Data")
	public void setData(Object data) {
		this.data = data;
	}
	
	public List<Error> getErrors() {
		return errors;
	}
	
	@JsonSetter("Errors")
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	public List<Warning> getWarnings() {
		return warnings;
	}
	
	@JsonSetter("Warnings")
	public void setWarnings(List<Warning> warnings) {
		this.warnings = warnings;
	}

	public Response.Status getWebStatus() {
		return webStatus;
	}
}
