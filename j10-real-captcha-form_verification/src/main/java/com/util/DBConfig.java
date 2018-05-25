package com.util;

import java.util.Properties;
import java.io.IOException;
import java.net.URL;
import java.io.InputStream;

public class DBConfig{
    
	// 1.
	private Properties prop;
	
	// 2. 
	public DBConfig(){
		// 3.1
		this.read();
	}

	/**
	 * 3.
	 * 读取配置文件
	 */
	private void read(){
		// create prop
		prop = new Properties();
		
		URL url = DBConfig.class.getResource("/");
		System.out.println(url);
		// => file:/E:/test/java/myeclipse6.5/J6_2/WebRoot/WEB-INF/classes/
		
		// create prop's resource
		InputStream is = DBConfig.class.getResourceAsStream("dbConfig.properties");		// 更改路径测试，不需要重启服务器。
																						// /com/service/..
		System.out.println(DBConfig.class);
		// => class com.util.DBConfig
		
		/*
		If the name begins with a '/' ('\u002f'), then the absolute name of the resource is the portion of the name following the '/'. 
		
		Otherwise, the absolute name is of the following form: 
		   modified_package_name/name
		 
		Where the modified_package_name is the package name of this object with '/' substituted for '.' ('\u002e'). 
		*/
	
		// load properties
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	// read
	
	
	/**
	 * 4.
	 * 根据键从prop中取值
	 * @param key
	 * @return
	 */
	public String getValue(String key){
		
		return prop.getProperty(key);
	}
	
	/**
	 * 5.
	 * @param args
	 */
	public static void main(String[] args){
		DBConfig read = new DBConfig();
		
		System.out.println(read.getValue("user"));
		
	}

}	// DBConfig
    
