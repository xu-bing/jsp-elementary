package com.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * ʵ����������ͳ��
 * 
 *
 */
public class MyHttpSessionListener implements HttpSessionListener {

	private int count;
	
	
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		count++;
		System.out.print("����������" + count);

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		count--;
		System.out.println("����������" + count);
		
	}

}

/*
 * ����listener
 * ע�͵�servletContextAttributeListener, 
 * 
 * ����������
 * ���ԣ�
 * ���δ򿪼�����������򿪲���ҳ�档Ȼ��ر�1,2�����۲����̨�����
 * win8ϵͳ�ϲ��������⣬���ȶ�����n�����ڣ�ֻ�м����з�Ӧ ���� �����ơ�
 * 
 * session�Ļ٣�ȡ����gc���ȷ����������ա�
 * ����������ͻ��������� ������������֪ͨ��server, �÷������Ƴ���session��
 * 
 * ��session ����list��
 * 
 * �ܽ᣺
 * ֮ǰ�����ݿ�����������ļ�д���ⲿ��
 * ����DBManagerʱ��ȥ��������ļ���
 * 
 * ���ڣ�����Ҳ�����ڷ���������ʱ��ȥ�������������������������ʱ���أ�
 * ����ͨ��serverletContext��Ҳ����application����������������
 * ���仰������������Щ��ʼ����׼��������
 * 
 * 
 */
