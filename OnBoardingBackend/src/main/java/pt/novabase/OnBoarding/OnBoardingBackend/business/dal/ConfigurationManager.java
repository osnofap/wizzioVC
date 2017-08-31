package pt.novabase.OnBoarding.OnBoardingBackend.business.dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBDatabaseException;
import pt.novabase.OnBoarding.OnBoardingBackend.hibernate.HibernateUtils;
import pt.novabase.OnBoarding.OnBoardingBackend.dao.Configurations;

public class ConfigurationManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationManager.class);
	
    /**
     * Retrieves a configuration from the database
     * @param configid
     * @return
     * @throws NBDatabaseException
     */
	public static String get(String configid) throws NBDatabaseException {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			Configurations conf = (Configurations) session.get(Configurations.class, configid);
			return (conf != null) ? conf.getValue() : null;
			
		} catch (Throwable e) {
			LOGGER.error("Failed to retrieve Configuration.", e);
			
			throw new NBDatabaseException("Failed to retrieve Configuration.", e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	/**
	 * Retrieves an integer configuration from the database
	 * @param configid
	 * @return
	 * @throws NBDatabaseException
	 */
	public static int getInteger(String configid) throws NBDatabaseException {
		return Integer.valueOf(get(configid));
	}
	
	/**
	 * Retrieves an boolean configuration from the database
	 * @param configid
	 * @return
	 * @throws NBDatabaseException
	 */
	public static boolean getBoolean(String configid) throws NBDatabaseException {
		return Boolean.valueOf(get(configid));
	}
}
