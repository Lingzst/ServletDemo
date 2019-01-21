package com.lingzst.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		System.out.println("userName "+ userName);
		
		PrintWriter pw = response.getWriter();
		if("admin".equals(userName) && "123".equals(passWord)) {
			System.out.println("成功");
			pw.write("login success...");
			//设置状态吗
			response.setStatus(302);
			response.setHeader("Location", "login_success.html");
		}else {
			System.out.println("失败");
			pw.write("失败");	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
