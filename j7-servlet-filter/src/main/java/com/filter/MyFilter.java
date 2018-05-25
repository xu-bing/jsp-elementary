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
		
		// 多重过滤器，只有上1个过滤器 doFilter了，才会执行它，否则不会执行。
		
		System.out.println("myFilter do filter ----- ");
		chain.doFilter(request, response);
		System.out.println("myFilter : after do filter");

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("myFilter init....");

	}

}
