package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounselFindOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String selected = request.getParameter("selected");
		
		System.out.println(selected);
		
		request.setAttribute("b_name", selected);
		
		PrintWriter out=response.getWriter();
		
		if(selected != null) {
			out.println("<script>");
			//out.println("opener.parent.location.href='/DoZip/counsel_partner_write.do';"); 
			out.println("window.close();");
			//out.println("history.back();");
			out.println("</script>");
		}
		
		return null;
	}

}
