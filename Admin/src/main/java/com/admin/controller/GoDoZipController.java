package com.admin.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GoDoZipController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.println("<script>");
		out.println("alert('로그아웃 되었습니다.');");
		out.println("location='/DoZip/home.do';");
		out.println("</script>");		
		out.close();
		
		return null;
	}

}
