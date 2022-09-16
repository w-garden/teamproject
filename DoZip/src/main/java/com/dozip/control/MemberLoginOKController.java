package com.dozip.control;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dozip.dao.MemberDAOImpl;

public class MemberLoginOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		String mem_id = request.getParameter("mem_id");
		String mem_pwd = request.getParameter("mem_pwd");
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		String db_pwd = mdao.loginCheck(mem_id);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if(db_pwd == null) {
			out.println("<script>");
			out.println("alert('가입되어 있지 않은 아이디 입니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else if(!db_pwd.equals(mem_pwd)) {
			out.println("<script>");
			out.println("alert('비밀번호를 확인해주세요.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			HttpSession session=request.getSession();
			session.setAttribute("id",mem_id); //세션에 로그인 된 아이디를 저장
			
			out.println("<script>");
			out.println("opener.parent.location.reload();");
			out.println("window.close();");
			out.println("</script>");
			//창을 닫고 메인화면을 새로고침
		}
		return null;
	}

}
