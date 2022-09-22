package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CounselWriteController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("id"); //현재 로그인 되어있는 세션의 아이디 값
		
		if(id == null) { //일치하는 아이디가 없다면
			out.println("<script>");
			out.println("alert('로그인 후 이용해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			
			return null;
		}else {
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./counsel/counsel_write.jsp"); //뷰페이지 경로 설정
			
			return forward;
		}
	}

}
