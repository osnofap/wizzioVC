package pt.novabase.OnBoarding.OnBoardingScript.business.enums;

public enum HibernateParams {
	
	SCRIPT_ID("SCRIPTS", "SCRIPT_ID"),
	
	SCRIPT_CODE("SCRIPTS", "SCRIPT_CODE"),
	
	SCRIPT_TEMPLATE("SCRIPTS", "SCRIPT_TEMPLATE"),
	
	SCRIPT_ACTIVE("SCRIPTS", "ACTIVE"),
	
	SCRIPT_CREATION("SCRIPTS", "CREATION_DATE"),
	
	SCRIPT_UPDATE("SCRIPTS", "UPDATE_DATE");
	
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
