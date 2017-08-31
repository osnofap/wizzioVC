package pt.novabase.OnBoarding.OnBoardingBackend.business.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.novabase.OnBoarding.OnBoardingBackend.business.mappers.ProcessMapper;
import pt.novabase.OnBoarding.OnBoardingBackend.business.utils.QueriesUtils;
import pt.novabase.OnBoarding.OnBoardingBackend.dao.ProcessDetails;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBDatabaseException;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.database.NBEntityNotFoundException;
import pt.novabase.OnBoarding.OnBoardingBackend.hibernate.HibernateUtils;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ImagesBean;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ProcessesBean;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ValidationBean;

public class ProcessDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessDAO.class);
	
	public static ValidationBean getDetailsAndImages(long processId) throws NBDatabaseException {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			ProcessDetails process = null;

			process =  (ProcessDetails) session.get(ProcessDetails.class, processId);
			if(process == null) {
				throw new NBEntityNotFoundException("No process with id (" + processId + ") was found");
			}
			
			List<ImagesBean> images = ImageDAO.getImagesIdByProcess(processId);
			
			ValidationBean result = ProcessMapper.mapValidationProcessDetails(process);
			result.setImages(images);

		return result;

		} catch(NBDatabaseException e) {
			LOGGER.error("Failed to retrieve process: " + processId, e);
			throw e;

		} catch(Throwable e) {
			LOGGER.error("Failed to retrieve process: " + processId, e);
			throw new NBDatabaseException("Failed to retrieve process.", e);
		} finally {
			if(session != null) {
				tx.commit();
				session.close();
			}
		}
	}


	public static ProcessesBean getDetails(long processId) throws NBDatabaseException {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			ProcessDetails process = null;

			process =  (ProcessDetails) session.get(ProcessDetails.class, processId);
			if(process == null) {
				throw new NBEntityNotFoundException("No process with id (" + processId + ") was found");
			}
			
			ProcessesBean result = ProcessMapper.mapProcess(process);

		return result;

		} catch(NBDatabaseException e) {
			LOGGER.error("Failed to retrieve process: " + processId, e);
			throw e;

		} catch(Throwable e) {
			LOGGER.error("Failed to retrieve process: " + processId, e);
			throw new NBDatabaseException("Failed to retrieve process.", e);
		} finally {
			if(session != null) {
				tx.commit();
				session.close();
			}
		}
	}
	
	public static List<?> getDetailsAlternative(String processId) throws NBDatabaseException {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Query query = session.createSQLQuery(QueriesUtils.processByIDQuery(processId));

			return query.list();

		}  catch(Throwable e) {
			LOGGER.error("Failed to retrieve process: " + processId, e);
			throw new NBDatabaseException("Failed to retrieve process.", e);
		} finally {
			if(session != null) {
				tx.commit();
				session.close();
			}
		}
	}
	
	/**
	 * Creates a new process
	 * 
	 * @param process
	 * @return
	 * @throws NBDatabaseException
	 */
	public static Integer createNew(ProcessesBean process) throws NBDatabaseException {
		Session session = null;
		Transaction tx = null;

		try {
			
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Query query = session.createSQLQuery(QueriesUtils.newProcessQuery(process));

			return query.executeUpdate();
			
		} catch(Throwable e) {
			LOGGER.error("Failed to create process for client with NIF: " + process.getNif(), e);
			throw new NBDatabaseException("Failed to retrieve process.", e);
		} finally {
			if(session != null) {
				tx.commit();
				session.close();
			}
		}
	}
	
	public static Integer updateProcess(ProcessesBean process) throws NBDatabaseException {
		
		Session session = null;
		Transaction tx = null;

		try {
			
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			
			Query query = session.createSQLQuery(QueriesUtils.updateProcessQuery(process));
			
			return query.executeUpdate();
	
			
		} catch(Throwable e) {
			LOGGER.error("Failed to update process: " + process.getProcessId(), e);
			throw new NBDatabaseException("Failed to retrieve process.", e);
		} finally {
			if(session != null) {
				tx.commit();
				session.close();
			}
		}
	}
}
