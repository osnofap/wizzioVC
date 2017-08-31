package pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans;



public class ImagesBean {
	private long imageId;
	private long processId;
	private String imageType;
	private String imageBase64;
	private String faceID;
	
	public ImagesBean() {
	}

	public long getProcessId() {
		return processId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getFaceID() {
		return faceID;
	}

	public void setFaceID(String faceID) {
		this.faceID = faceID;
	}

}
