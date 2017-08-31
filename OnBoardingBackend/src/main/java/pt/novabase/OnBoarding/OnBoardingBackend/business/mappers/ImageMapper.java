package pt.novabase.OnBoarding.OnBoardingBackend.business.mappers;

import pt.novabase.OnBoarding.OnBoardingBackend.dao.ProcessImages;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ImagesBean;

public class ImageMapper {
	
	public static ImagesBean mapImage(ProcessImages image) {
		ImagesBean finalImage = new ImagesBean();
		
		finalImage.setImageId(image.getImageId());
		finalImage.setImageType(image.getImageType());
		finalImage.setImageBase64(image.getBase64());
		
		return finalImage;
	}

}
