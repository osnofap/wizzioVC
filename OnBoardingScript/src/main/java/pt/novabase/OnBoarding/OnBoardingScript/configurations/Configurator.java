package pt.novabase.OnBoarding.OnBoardingScript.configurations;


import java.io.File;
import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.xml.XmlConfiguration;


public class Configurator {

	private static final String HOME = "SAFEHUB";
	
	private static String findHome() {
		if(System.getenv(HOME) == null) {
			return System.getProperty(HOME);
		}
		System.setProperty(HOME, System.getenv(HOME));
		return System.getenv(HOME);
	}
	
	/**
	 * Hibernate configuration file
	 * @return
	 */
	public static File hibernateConfig() {
		File dbconfig = new File(findHome(), "conf/hibernate.cfg.xml");
		if(dbconfig.exists() && dbconfig.isFile()) {
			return dbconfig;
		}
		return null;
	}
	
	/**
	 * Log4j2 configuration file
	 * @return
	 */
	public static void log4jConfig() {
		File logconfig = new File(findHome(), "conf/log4j2.xml");
		if(logconfig.exists() && logconfig.isFile()) {
			try {
				ConfigurationSource source = new ConfigurationSource(new FileInputStream(logconfig));
				XmlConfiguration xmlConfig = new XmlConfiguration(source);
				Logger logger = (Logger) LogManager.getLogger(); 
				logger.getContext().start(xmlConfig);
			} catch(Throwable t) {
				t.printStackTrace();
			}
		}
	}
}