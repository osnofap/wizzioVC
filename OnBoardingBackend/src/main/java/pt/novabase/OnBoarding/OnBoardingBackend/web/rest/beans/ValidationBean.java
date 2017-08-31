package pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans;

import java.util.List;



public class ValidationBean {
	
	private long processId;
	private List<ImagesBean> images;
	private List<String> images64;
	private String name;
	private String idNumber;
	private String nif;
	private String email;
	private String phone;

	public ValidationBean() {
	}

	public long getProcessId() {
		return processId;
	}

	public void setProcessId(long l) {
		this.processId = l;
	}

	public List<ImagesBean> getImages() {
		return images;
	}

	public void setImages(List<ImagesBean> imagesURL) {
		this.images = imagesURL;
	}

	public List<String> getImages64() {
		return images64;
	}

	public void setImages64(List<String> images64) {
		this.images64 = images64;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}
