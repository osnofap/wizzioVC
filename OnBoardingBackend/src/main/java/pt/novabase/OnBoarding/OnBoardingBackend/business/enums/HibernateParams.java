package pt.novabase.OnBoarding.OnBoardingBackend.business.enums;

public enum HibernateParams {
	
	IMAGES_ID("PROCESS_IMAGES", "IMAGE_ID"),
	
	IMAGES_PROCESS_ID("PROCESS_IMAGES", "PROCESS_ID"),
	
	IMAGE_TYPE("PROCESS_IMAGES", "IMAGE_TYPE"),
	
	IMAGE_64("PROCESS_IMAGES", "BASE64"),
	
	PROCESS_ID("PROCESS_DETAILS", "PROCESS_ID"),
	
	PROCESS_NIF("PROCESS_DETAILS", "NIF"),
	
	PROCESS_NAME("PROCESS_DETAILS", "NAME"),
	
	PROCESS_EMAIL("PROCESS_DETAILS", "EMAIL"),
	
	PROCESS_IDN("PROCESS_DETAILS", "ID_NUMBER"),
	
	PROCESS_PHONE("PROCESS_DETAILS", "PHONE_NUMBER");
	
	
	private final String tableName;
	private final String columnName;
	
	HibernateParams(String tableName, String columnName) {
		this.tableName = tableName;
		this.columnName = columnName;
	}

	public String getTableName() {
		return tableName;
	}

	public String getColumnName() {
		return columnName;
	}
	
	


}
