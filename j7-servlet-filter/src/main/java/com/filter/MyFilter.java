package com.filter;

import java.io.IOException;


import javax.servlet.*;
import javax.servlet.http.*;

public class MyFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		// ���ع�������ֻ����1�������� doFilter�ˣ��Ż�ִ���������򲻻�ִ�С�
		
		System.out.println("myFilter do filter ----- ");
		chain.doFilter(request, response);
		System.out.println("myFilter : after do filter");

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("myFilter init....");

	}

}
