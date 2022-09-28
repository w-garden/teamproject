package com.partners.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.partners.dao.PartnersDAO;
import com.partners.dto.PartnersDTO;

public class PartnersLoginOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String pId=request.getParameter("login_pId");
			String pPw =request.getParameter("login_pPw");
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			PartnersDAO dao = new PartnersDAO();
			
			//로그인 체크 아이디가 없는경우 0, 비번이 일치하지 않는경우 2, 로그인 성공 1
			int result = dao.loginCheck(pId, pPw);
			
			if(result==0) {
				out.println("<script>");
				out.println("alert('존재하지 않는 아이디입니다')");
				out.println("history.back()");
				out.println("</script>");
			}
			else {

				if(result==2) {
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다')");
				out.println("history.back()");
				out.println("</script>");
				}
				else if(result==1) {
					PartnersDTO dto = dao.selectPartner(pId);		
					HttpSession session = request.getSession();
					session.setAttribute("id", pId);				
					session.setAttribute("businessName", dto.getBusinessName());
					session.setAttribute("business_num", dto.getBusiness_num());
					
					
					session.setMaxInactiveInterval(600);   //세션을 통해 로그인 시간 설정
					
					
					ActionForward forward = new ActionForward();
					forward.setRedirect(true);
					forward.setPath("index.do");
					return forward; 
				}
			}
			return null; 	
	}

}
