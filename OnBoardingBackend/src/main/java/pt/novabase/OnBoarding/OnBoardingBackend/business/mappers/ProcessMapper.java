package pt.novabase.OnBoarding.OnBoardingBackend.business.mappers;


import pt.novabase.OnBoarding.OnBoardingBackend.dao.ProcessDetails;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ProcessesBean;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ValidationBean;

public class ProcessMapper {
	
	public static ProcessesBean mapProcess(ProcessDetails process) {
		ProcessesBean finalProcess = new ProcessesBean();
		
		finalProcess.setProcessId(process.getProcessId());
		finalProcess.setNif(process.getNif());
		finalProcess.setIdNumber(process.getIdNumber());
		finalProcess.setName(process.getName());
		finalProcess.setPhone(process.getPhoneNumber());
		finalProcess.setEmail(process.getEmail());
		
		
		return finalProcess;
	}
	
	public static ValidationBean mapValidationProcessDetails(ProcessDetails process) {
		ValidationBean validation = new ValidationBean();
		
		validation.setProcessId(process.getProcessId());
		validation.setNif(process.getNif());
		validation.setIdNumber(process.getIdNumber());
		validation.setName(process.getName());
		validation.setPhone(process.getPhoneNumber());
		validation.setEmail(process.getEmail());
		
		return validation;
		
	}


}
