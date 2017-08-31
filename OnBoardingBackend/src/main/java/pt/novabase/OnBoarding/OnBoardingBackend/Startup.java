package pt.novabase.OnBoarding.OnBoardingBackend;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.novabase.OnBoarding.OnBoardingBackend.configurations.Configurator;

/**
 * Load required startup modules of backend
 * @author NB18140
 *
 */
public class Startup implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		Configurator.log4jConfig();
		LOGGER.info("Logger initialized.");

		initializESign();
	}
	
	private void initializESign() {
		new Thread(new Runnable() {
	         public void run() {
				
	         }
	    }).start();
	}
}
