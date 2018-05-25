package com.util;

import java.util.*;
import java.io.*;
import java.net.*;


/**
 * 用来读取数据库配置文件
 * @author xab
 *
 */
public class DBConfig {
	
	private Properties prop;
	
	public DBConfig(){
		super();
		this.read();
	}
	
	/**
	 * 读取配置文件
	 */
	private void read(){
		prop = new Properties();
		
		URL url = DBConfig.class.getResource("/");
		System.out.println(url);
		// => file:/E:/test/java/myeclipse6.5/J6_2/WebRoot/WEB-INF/classes/
		
		InputStream is = DBConfig.class.getResourceAsStream("/dbConfig.properties");
		System.out.println(DBConfig.class);
		// => class com.util.DBConfig
		
		
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 根据键取值
	 * @param key
	 * @return 值
	 */
	public String getValue(String key){
		
		return prop.getProperty(key);
		
	}
	
	public static void main(String[] args){
		DBConfig dbConfig = new DBConfig();
		
		System.out.println(dbConfig.getValue("dbDriver"));
	}

}
