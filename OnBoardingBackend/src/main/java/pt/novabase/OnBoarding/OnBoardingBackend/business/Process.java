package pt.novabase.OnBoarding.OnBoardingBackend.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.novabase.OnBoarding.OnBoardingBackend.business.dal.ProcessDAO;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBDatabaseException;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ProcessesBean;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ValidationBean;

public class Process {
	private static final Logger LOGGER = LoggerFactory.getLogger(Process.class);
	/**
	 * Retrieves the process details
	 * 
	 * @param processId
	 * @return
	 * @throws NBDatabaseException
	 */
	public static ProcessesBean getProcessDetails(long processId) throws NBDatabaseException {
		
		ProcessesBean process = (ProcessesBean) ProcessDAO.getDetails(processId);
		
		LOGGER.info("Process retrieved: " + process);
	
		return process;
		
	}
	
	public static ValidationBean getFullProcess(long processId) throws NBDatabaseException {
		
		ValidationBean validation = ProcessDAO.getDetailsAndImages(processId);
		LOGGER.info("Full details retrieved : " + validation);
		
		return validation;
		
	}
	
	public static String createProcess(ProcessesBean process) throws NBDatabaseException {
		
		Integer numberUpdated = ProcessDAO.createNew(process); 
		LOGGER.info("SQL execut resut : " + numberUpdated);
		String result = (numberUpdated != 0) ? numberUpdated.toString() + " row updated" : "No row were updated";
		
		return result;
	}
	
	public static String updateProcess(ProcessesBean process) throws NBDatabaseException {
		
			Integer update = ProcessDAO.updateProcess(process);
			LOGGER.info("SQL execut resut : " + update);
			return (update != 0) ? update.toString() + " row updated" : "No row were updated";
		
		
	}
}
