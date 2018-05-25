package com.servlet;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.*;

import javax.imageio.*;

public class CaptchaServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		// PrintWriter out = response.getWriter();	// 只能用1次，下面已经用了。 会出错，说已经被使用了。

		// 1. 生成验证码图片
		// 设置图片的大小
		int width = 78;
		int height = 20;
		//创建图片对象
		BufferedImage bim = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//获取图片绘图对象
		Graphics g = bim.getGraphics();
		
		// 创建1个随机类
		Random rm = new Random();
		
		//随机产生背景颜色并填充整个图片
		g.setColor(new Color(rm.nextInt(155),rm.nextInt(220),rm.nextInt(255)));
		g.fillRect(0,0, width, height);		// 绘制一个有填充颜色的长方形（横坐标、纵坐标、宽、高）
		
		// 绘制文字
		StringBuffer sbf = new StringBuffer("");
		for(int i=0;i<4;i++){//循环输出数字
			g.setColor(new Color(rm.nextInt(88),rm.nextInt(188),rm.nextInt(255)));
			g.setFont(new Font("Dotum",Font.BOLD|Font.ITALIC,22));
			int n = rm.nextInt(10);		// 生成1个随机整数
			sbf.append(n);
			g.drawString(""+n,i*16+5, 18);	// 使用此图形上下文的当前字体和颜色绘制由指定 string 给定的文本。
											// 最左侧字符的基线位于此图形上下文坐标系的 (x, y) 位置处。
		}
		// 2. 将图片对象响应给客户端
		// javax.imageio.*
		ImageIO.write(bim, "JPEG", response.getOutputStream()); 	//输出对象，格式，输出流: servlet.output.stream
		
		// 将验证码存入Session
		// javax.servlet.http.*
		HttpSession session = request.getSession();
		session.setAttribute("captcha", sbf.toString());	
	}
}
