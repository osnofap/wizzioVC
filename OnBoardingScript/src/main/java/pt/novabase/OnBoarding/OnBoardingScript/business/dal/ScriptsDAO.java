package pt.novabase.OnBoarding.OnBoardingScript.business.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.novabase.OnBoarding.OnBoardingScript.dao.Scripts;
import pt.novabase.OnBoarding.OnBoardingScript.business.hibernate.HibernateUtils;
import pt.novabase.OnBoarding.OnBoardingScript.business.mappers.ScriptMappers;
import pt.novabase.OnBoarding.OnBoardingScript.business.utils.HibernateQueryUtils;
import pt.novabase.OnBoarding.OnBoardingScript.exceptions.NBDatabaseException;
import pt.novabase.OnBoarding.OnBoardingScript.exceptions.database.NBEntityNotFoundException;
import pt.novabase.OnBoarding.OnBoardingScript.web.rest.ScriptBean;

public class ScriptsDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScriptsDAO.class);
	
	
	public static ScriptBean getScript(Integer scriptId) throws NBDatabaseException {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Scripts script = null;

			script =  (Scripts) session.get(Scripts.class, scriptId);
			if(script == null) {
				throw new NBEntityNotFoundException("No script found with id " + scriptId);
			}
			
			
			ScriptBean result = ScriptMappers.mapScript(script);

		return result;

		} catch(NBDatabaseException e) {
			LOGGER.error("Failed to retrieve process: " + scriptId, e);
			throw e;

		} catch(Throwable e) {
			LOGGER.error("Failed to retrieve process: " + scriptId, e);
			throw new NBDatabaseException("Failed to retrieve process.", e);
		} finally {
			if(session != null) {
				tx.commit();
				session.close();
			}
		}
	}
	
	public static ScriptBean getScriptTemplate(String scriptCode) throws NBDatabaseException {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(HibernateQueryUtils.getScriptQuery(scriptCode));
			
			@SuppressWarnings("unchecked")
			List<Integer> list = query.list();


			if(list.size() == 0) {
				throw new NBEntityNotFoundException("No images for process " + scriptCode + " were found");
			}
			

			
			LOGGER.info("list " + list);
			
			return getScript( list.get(0) );

		} catch(Throwable e) {
			LOGGER.error("Failed to retrieve process: " + scriptCode, e);
			throw new NBDatabaseException("Failed to retrieve process.", e);
		} finally {
			if(session != null) {
				tx.commit();
				session.close();
			}
		}
		
	}

}
