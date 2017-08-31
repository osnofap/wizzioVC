package pt.novabase.OnBoarding.OnBoardingScript.business.hibernate;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.novabase.OnBoarding.OnBoardingScript.business.configurations.Configurator;
import pt.novabase.OnBoarding.OnBoardingScript.business.hibernate.HibernateUtils;

public class HibernateUtils {
private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtils.class);
	
	private SessionFactory sessionFactory;
	private static HibernateUtils instance = null;
	
	private HibernateUtils() {
		try {
            File dbconfig = Configurator.hibernateConfig();
			Configuration configuration = new Configuration();
			configuration.configure("/hibernate.cfg.xml");
			if(dbconfig == null || !dbconfig.exists()) {
				LOGGER.warn("Unable to load ConfigurationSource DB configurations. Using default properties...");
			} else {
				configuration.configure(dbconfig);
			}

			ServiceRegistryBuilder ssrb = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(ssrb.buildServiceRegistry());
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	private static HibernateUtils getInstance() {
		if(instance == null) {
			instance = new HibernateUtils();
		}
		return instance;
	}
	
	public static SessionFactory getSessionFactory() {
		return getInstance().sessionFactory;
	}
}
