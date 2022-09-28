package com.partners.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.partners.dao.PartnersDAO;

//@WebServlet("/BidBoardContController")
public class PartnersPwdController implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("id"); //현재 로그인 되어있는 세션의 아이디 값
		String current_pwd = request.getParameter("current_pwd");
		String new_pwd = request.getParameter("new_pwd");
		
		PartnersDAO pdao = new PartnersDAO();
		//int res = pdao.updatePwdPartners();
		
		PrintWriter out=response.getWriter();
		
//		if(res == 0) { //변경실패
//			out.println("<script>");
//			out.println("alert('기존 비밀번호를 확인해주세요.');");
//			out.println("history.back();");
//			out.println("</script>");
//		} else { //변경성공
//			out.println("<script>");
//			out.println("alert('비밀번호 변경이 완료되었습니다.');");
//			out.println("location.href = 'mypage_go.do';");
//			out.println("</script>");
//		}		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/mypage/pw_change.jsp"); //여기서 만들어놓은 뷰페이지 경로로 넘어간다.
		return forward;
	}
	
	//return null;
}