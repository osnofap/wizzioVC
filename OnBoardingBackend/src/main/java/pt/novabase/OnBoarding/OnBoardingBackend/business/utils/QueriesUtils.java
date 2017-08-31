package pt.novabase.OnBoarding.OnBoardingBackend.business.utils;

import pt.novabase.OnBoarding.OnBoardingBackend.business.enums.HibernateParams;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ImagesBean;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ProcessesBean;

public class QueriesUtils {
	
	public final static String creationUser = "CREATION_USER";
	public final static String creationDate = "CREATION_DATE";
	public final static String updateUser = "UPDATE_USER";
	public final static String updateDate = "UPDATE_DATE";
	public final static String user = "ME";
	public final static String date = "CURRENT_TIMESTAMP";
	
	public static String formatSelectAllQueryOne(String tableName, String columnName) {
		
		String hql = "SELECT * FROM dbo.PROCESS_DETAILS WHERE "
				+ tableName + "= :" + columnName;
		
		return hql;
	}
	
	/**
	 * Surrounds the String with ' ' 
	 * 
	 * @param text
	 * @return 'text'
	 */
	public static String surr(String text) {
		return "'" + text + "'";
	}
	
	/**
	 * Creates the string to insert a new process
	 * 
	 * @param process
	 * @return
	 */
	public static String newProcessQuery(ProcessesBean process) {
		
		String query = "INSERT INTO "
				+ HibernateParams.PROCESS_ID.getTableName() + "("
				+ HibernateParams.PROCESS_NIF.getColumnName() +","
				+ HibernateParams.PROCESS_NAME.getColumnName() + ","
				+ HibernateParams.PROCESS_IDN.getColumnName() +"," 
				+ HibernateParams.PROCESS_EMAIL.getColumnName() + ","
				+ HibernateParams.PROCESS_PHONE.getColumnName() +", "
						+ creationUser + "," + creationDate + "," + updateUser + "," + updateDate + ") VALUES ("
				+ surr(process.getNif()) + ","
				+ surr(process.getName()) + ","
				+ surr(process.getIdNumber()) + ","
				+ surr(process.getEmail()) + ","
				+ surr(process.getPhone()) + ", "
				+ surr(user) + ","
				+ date + ","
				+ surr(user) + ","
				+ date +")";
		
		
		return query;
	}
	
	public static String newImageQuery(ImagesBean image) {
		
		String query = "INSERT INTO "
				+ HibernateParams.IMAGES_ID.getTableName() + "("
				+ HibernateParams.IMAGES_PROCESS_ID.getColumnName() +","
				+ HibernateParams.IMAGE_TYPE.getColumnName() + ","
				+ HibernateParams.IMAGE_64.getColumnName() +"," 
						+ creationUser + "," + creationDate + "," + updateUser + "," + updateDate + ") VALUES ("
				+ image.getProcessId() + ","
				+ surr(image.getImageType()) + ","
				+ surr(image.getImageBase64()) + ","
				+ surr(user) + ","
				+ date + ","
				+ surr(user) + ","
				+ date +")";
		
		
		return query;
	}
	
	public static String processByIDQuery(String processId) {
		return "SELECT * FROM dbo." + HibernateParams.PROCESS_ID.getTableName() + " where " 
	+ HibernateParams.PROCESS_ID.getColumnName() + " = " + processId;
 	}
	
	public static String updateProcessQuery(ProcessesBean process) {
		
		String query = "UPDATE " + HibernateParams.PROCESS_ID.getTableName() + " SET "
				+ HibernateParams.PROCESS_NIF.getColumnName() + " = " + surr(process.getNif()) +", "
				+ HibernateParams.PROCESS_IDN.getColumnName() + " = " + surr(process.getIdNumber()) +", "
				+ HibernateParams.PROCESS_NAME.getColumnName() + " = " + surr(process.getName()) +", "
				+ HibernateParams.PROCESS_EMAIL.getColumnName() + " = " + surr(process.getEmail()) +", "
				+ HibernateParams.PROCESS_PHONE.getColumnName() + " = " + surr(process.getPhone()) 
				+ " where " + HibernateParams.PROCESS_ID.getColumnName() + " = " + process.getProcessId();
		
		return query;
	}

}
