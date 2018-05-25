package com.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.*;

/**
 * 1. ����1������������ʵ����ӿ�
 * 2. web.xml��ע��
 * @author xab
 *
 */

public class MyServletContextAttributeListener implements
		ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("attr added.......");
		
		ServletContext application = scab.getServletContext();
		String name = scab.getName();
		Object value = scab.getValue();
		System.out.println("+++" +application + "\n name: " + name + "\n value: " + value);
	}

	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("attr removed.......");
		
		ServletContext application = scab.getServletContext();
		String name = scab.getName();
		Object value = scab.getValue();
		System.out.println("---" + application + "\n name: " + name + "\n value: " + value);
	}

	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("attr replaced........");
		
		ServletContext application = scab.getServletContext();
		String name = scab.getName();
		Object value = scab.getValue();
		System.out.println("===" + application + "\n name: " + name  + "\n value: " + value );
	}
}
