package pt.novabase.OnBoarding.OnBoardingBackend.business.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.novabase.OnBoarding.OnBoardingBackend.business.mappers.ImageMapper;
import pt.novabase.OnBoarding.OnBoardingBackend.business.utils.QueriesUtils;
import pt.novabase.OnBoarding.OnBoardingBackend.dao.ProcessImages;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBDatabaseException;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.database.NBEntityNotFoundException;
import pt.novabase.OnBoarding.OnBoardingBackend.hibernate.HibernateUtils;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ImagesBean;

public class ImageDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ImageDAO.class);

	public static Integer createNew(ImagesBean image) throws NBDatabaseException {
		Session session = null;
		Transaction tx = null;
		try {

			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Query query = session.createSQLQuery(QueriesUtils.newImageQuery(image));

			return query.executeUpdate();

		} catch(Throwable e) {
			LOGGER.error("Failed to insert image for process " + image.getProcessId(), e);
			throw new NBDatabaseException("Failed to retrieve process.", e);
		} finally {
			if(session != null) {
				tx.commit();
				session.close();
			}
		}
	}

	public static List<ImagesBean> getImagesIdByProcess(long processId) throws NBDatabaseException {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Query query = session.createSQLQuery("SELECT IMAGE_ID FROM PROCESS_IMAGES WHERE PROCESS_ID = :code").addScalar("IMAGE_ID", StandardBasicTypes.LONG);
			query.setParameter("code", processId);
			@SuppressWarnings("unchecked")
			List<Long> list = query.list();


			if(list.size() == 0) {
				throw new NBEntityNotFoundException("No images for process " + processId + " were found");
			}
			List<ImagesBean> result = new ArrayList<>();
			for (Long id : list) {
				ProcessImages image = getImagesById(id);
				image.setBase64(null);
				ImagesBean realImage = ImageMapper.mapImage(image);
				result.add(realImage);
				
			}
			LOGGER.info("list " + list);
			return result;

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
		public static ProcessImages getImagesById(long imageId) throws NBDatabaseException {
			Session session = null;
			Transaction tx = null;
			try {
				session = HibernateUtils.getSessionFactory().openSession();
				tx = session.beginTransaction();

				ProcessImages images = null;

				images =  (ProcessImages) session.get(ProcessImages.class, imageId);
				if(images == null) {
					throw new NBEntityNotFoundException("No images with id " + imageId + " were found");
				}
				LOGGER.info("Image retrieved " + imageId);
				return images;

			} catch(NBDatabaseException e) {
				LOGGER.error("Failed to retrieve process: " + imageId, e);
				throw e;

			} catch(Throwable e) {
				LOGGER.error("Failed to retrieve image: " + imageId, e);
				throw new NBDatabaseException("Failed to retrieve image.", e);
			} finally {
				if(session != null) {
					tx.commit();
					session.close();
				}
			}
		}
	

}
