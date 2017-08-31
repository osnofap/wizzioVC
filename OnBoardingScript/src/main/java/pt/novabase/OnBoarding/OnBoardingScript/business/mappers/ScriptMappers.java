package pt.novabase.OnBoarding.OnBoardingScript.business.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.novabase.OnBoarding.OnBoardingScript.dao.Scripts;
import pt.novabase.OnBoarding.OnBoardingScript.web.rest.ScriptBean;

public class ScriptMappers {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScriptMappers.class);
	
	public static ScriptBean mapScript(Scripts script) {
		
		LOGGER.info("Mapping Script.");
		
		ScriptBean finalScript = new ScriptBean();
		
		finalScript.setScriptId(script.getScriptId());
		finalScript.setScriptCode(script.getScriptCode());
		finalScript.setScriptTemplate(script.getScriptTemplate());
		
		return finalScript;
		
	}

}
