package com.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConfig {

	private Properties prop;

	public DbConfig() {
		this.read();
	}


	private void read(){
		prop = new Properties();
		
		InputStream is = DbConfig.class.getResourceAsStream("/dbConfig.properties");
		System.out.println(is);
		
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	// read
	
	
	public String getValue(String key){
		return prop.getProperty(key);
	} 	
	
	/**
	 * ≤‚ ‘
	 * @param args
	 */
	public static void main(String[] args) {
		DbConfig dbConfig = new DbConfig();
		System.out.println(dbConfig.getValue("driver"));
	}
}
