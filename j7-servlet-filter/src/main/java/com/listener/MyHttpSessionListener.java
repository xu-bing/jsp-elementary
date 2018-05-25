package com.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * 实现在线人数统计
 * 
 *
 */
public class MyHttpSessionListener implements HttpSessionListener {

	private int count;
	
	
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		count++;
		System.out.print("上线人数：" + count);

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		count--;
		System.out.println("下线人数：" + count);
		
	}

}

/*
 * 配置listener
 * 注释掉servletContextAttributeListener, 
 * 
 * 重启服务器
 * 测试：
 * 依次打开几个浏览器，打开测试页面。然后关闭1,2个，观察控制台结果。
 * win8系统上测试有问题，不稳定，打开n个窗口，只有几个有反应 ！！ 待完善。
 * 
 * session的毁，取决于gc，等服务器来回收。
 * 如何做，当客户端下线了 ，就立即发送通知给server, 让服务器移除掉session。
 * 
 * 将session 存于list中
 * 
 * 总结：
 * 之前，数据库的配置配置文件写在外部，
 * 访问DBManager时才去加载这个文件。
 * 
 * 现在，我们也可以在服务器启动时就去加载它。那怎样把握这个启动时机呢？
 * 可以通过serverletContext，也就是application的特性来启动它。
 * 换句话，可用它来做些初始化、准备工作。
 * 
 * 
 */
