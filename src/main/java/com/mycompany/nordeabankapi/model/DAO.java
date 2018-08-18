
package com.mycompany.nordeabankapi.model;

public interface DAO {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/"
			+ "nordea_bank?zeroDateTimeBehavior=CONVERT_TO_NULL";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "root";
}
