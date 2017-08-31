package pt.novabase.OnBoarding.OnBoardingScript.business.utils;

import pt.novabase.OnBoarding.OnBoardingScript.business.enums.HibernateParams;

public class HibernateQueryUtils {
	
	private final static String SQL_DESC = "DESC";
	
	//private final static String SQL_ASC = "ASC";
	
	/**
	 * Gives a space
	 */
	private final static String SPACE = " ";
	
	/**
	 * Surrounds the String with ' ' 
	 * 
	 * @param text
	 * @return 'text'
	 */
	public static String surr(String text) {
		return "'" + text + "'";
	}
	
	public static String getScriptQuery(String scriptCode) {
		String query = "SELECT TOP 1 " + HibernateParams.SCRIPT_ID.getColumnName()
		+ " from " + HibernateParams.SCRIPT_ID.getTableName()
		+ " WHERE " + HibernateParams.SCRIPT_CODE.getColumnName()
		+ " = " + surr(scriptCode)
		+ " AND ACTIVE = 1 ORDER BY " + HibernateParams.SCRIPT_UPDATE.getColumnName() + SPACE + SQL_DESC;
		
		return query;
	}

}
