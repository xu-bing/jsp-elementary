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
		// PrintWriter out = response.getWriter();	// ֻ����1�Σ������Ѿ����ˡ� �����˵�Ѿ���ʹ���ˡ�

		// 1. ������֤��ͼƬ
		// ����ͼƬ�Ĵ�С
		int width = 78;
		int height = 20;
		//����ͼƬ����
		BufferedImage bim = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//��ȡͼƬ��ͼ����
		Graphics g = bim.getGraphics();
		
		// ����1�������
		Random rm = new Random();
		
		//�������������ɫ���������ͼƬ
		g.setColor(new Color(rm.nextInt(155),rm.nextInt(220),rm.nextInt(255)));
		g.fillRect(0,0, width, height);		// ����һ���������ɫ�ĳ����Σ������ꡢ�����ꡢ���ߣ�
		
		// ��������
		StringBuffer sbf = new StringBuffer("");
		for(int i=0;i<4;i++){//ѭ���������
			g.setColor(new Color(rm.nextInt(88),rm.nextInt(188),rm.nextInt(255)));
			g.setFont(new Font("Dotum",Font.BOLD|Font.ITALIC,22));
			int n = rm.nextInt(10);		// ����1���������
			sbf.append(n);
			g.drawString(""+n,i*16+5, 18);	// ʹ�ô�ͼ�������ĵĵ�ǰ�������ɫ������ָ�� string �������ı���
											// ������ַ��Ļ���λ�ڴ�ͼ������������ϵ�� (x, y) λ�ô���
		}
		// 2. ��ͼƬ������Ӧ���ͻ���
		// javax.imageio.*
		ImageIO.write(bim, "JPEG", response.getOutputStream()); 	//������󣬸�ʽ�������: servlet.output.stream
		
		// ����֤�����Session
		// javax.servlet.http.*
		HttpSession session = request.getSession();
		session.setAttribute("captcha", sbf.toString());	
	}
}
