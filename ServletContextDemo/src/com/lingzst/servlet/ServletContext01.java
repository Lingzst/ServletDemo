package com.lingzst.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletContext01 extends HttpServlet {
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		test01();
//		test02();
		test03();
	 }
	 //根据classloader去获取工程下的资源  类加载器（JDBC)
	private void test03() {
		try {
			Properties properties = new Properties();
			//classloader的相对路径指的是    class存放位置的根路径 \wtpwebapp\ServletContextDemo\WEB-INF\classes
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("../../config.properties");
			properties.load(is);
			String name = properties.getProperty("address");
			System.out.println("name33="+ name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void test02() throws IOException {
		ServletContext context = getServletContext();
		Properties properties = new Properties();
		InputStream is = context.getResourceAsStream("config.properties");
		properties.load(is);
		String name = properties.getProperty("address");
		System.out.println("name=" + name);
		System.out.println("test02");
	}

	@SuppressWarnings("unused")
	private void test01() throws FileNotFoundException, IOException {
		ServletContext context = getServletContext(); 
		//给出给定文件在服务器上的绝对路径 "" 返回项目在tomcat中的根路径
		String path = context.getRealPath("config.properties");
		System.out.println(path);
		String address = context.getInitParameter("address");
		System.out.println("address: " + address);
		
		Properties properties = new Properties();
		InputStream is = new FileInputStream(path);
		properties.load(is);
		String name = properties.getProperty("address");
		System.out.println("name=" + name);
	}
	
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	 }
}
