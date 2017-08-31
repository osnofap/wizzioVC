package pt.novabase.OnBoarding.OnBoardingBackend.business;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.novabase.OnBoarding.OnBoardingBackend.business.dal.ImageDAO;
import pt.novabase.OnBoarding.OnBoardingBackend.dao.ProcessImages;
import pt.novabase.OnBoarding.OnBoardingBackend.exceptions.NBDatabaseException;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ImagesBean;

public class Image {

	private static final Logger LOGGER = LoggerFactory.getLogger(Image.class);

	public static String createProcess(ImagesBean image) throws NBDatabaseException {


		LOGGER.info("Calling DAO methods in " + Image.class);
		Integer numberUpdated = ImageDAO.createNew(image); 
		String result = (numberUpdated != 0) ? numberUpdated.toString() + " row(s) updated" : "No row were updated";

		return result;
	}

	public static List<ImagesBean> getImagesByProcess(long processId) throws NBDatabaseException {
		
		List<ImagesBean> images = ImageDAO.getImagesIdByProcess(processId);
		
		return images;

	}
	
	public static BufferedImage getImage(long imageId) throws NBDatabaseException {
		BufferedImage image = null;
		
		ProcessImages imag = ImageDAO.getImagesById(imageId);
		
		
		byte[] imageByte = DatatypeConverter.parseBase64Binary(imag.getBase64());
		ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
		try {
			image = ImageIO.read(bis);
			bis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return image;
	}
}
