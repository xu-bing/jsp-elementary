package com.util;

import java.util.*;
import java.io.*;

public class DBConfig {
	
	private Properties prop;
	
	public DBConfig() {
		this.read();
	}
	
	/**
	 * 读取prop
	 *
	 */
	private void read(){
		// A.
		prop = new Properties();
		
		// B.1
		InputStream is = DBConfig.class.getResourceAsStream("/dbConfig.properties");

		//System.out.println(DBConfig.class);

		// B.2
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 根据键取得属性值
	 * @param key
	 */
	public String getValue(String key){
		
		return prop.getProperty(key);
	}
	
	public static void main(String[] args) {
		DBConfig dbConfig = new DBConfig();
		System.out.println(dbConfig.getValue("driver"));
	}
	
}	// DBConfig
