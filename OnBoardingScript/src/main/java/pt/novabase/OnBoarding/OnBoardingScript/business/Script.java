package pt.novabase.OnBoarding.OnBoardingScript.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.novabase.OnBoarding.OnBoardingScript.business.dal.ScriptsDAO;
import pt.novabase.OnBoarding.OnBoardingScript.exceptions.NBDatabaseException;
import pt.novabase.OnBoarding.OnBoardingScript.web.rest.ScriptBean;

public class Script {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Script.class);
	
	public static ScriptBean getTemplateScript(String scriptCode) throws NBDatabaseException {
		LOGGER.info("Getting the script.");
		
		return  ScriptsDAO.getScriptTemplate(scriptCode);
	}
	
	public static ScriptBean scriptTest(Integer scriptId) throws NBDatabaseException {
		LOGGER.info("[TESTING] Getting script");
		
		return ScriptsDAO.getScript(scriptId);
	}

}
