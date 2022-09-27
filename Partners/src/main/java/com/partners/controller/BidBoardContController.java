package com.partners.controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/BidBoardContController")
public class BidBoardContController implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		EstimateDAOImpl mdao=new EstimateDAOImpl();
	
		if(business_num == null) {
	           out.println("<script>");			
	           out.println("alert('다시 로그인 하세요!');");
	           out.println("location='member_login.do';");
	           out.println("</script>");
		}else {
				
				
		}

		return null;
	}
	

}
