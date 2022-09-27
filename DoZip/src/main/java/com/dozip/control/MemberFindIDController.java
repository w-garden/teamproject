package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.MemberDAOImpl;
import com.dozip.vo.MemberVO;

public class MemberFindIDController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String mem_name = request.getParameter("mem_name2");
		String mem_tel = request.getParameter("mem_tel2");
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		String mem_id = mdao.getFindID(mem_name, mem_tel);
		/* request.setAttribute("mem_id", mem_id); */
		
		PrintWriter out=response.getWriter();
		
		if(mem_id != null) {
			out.println("<script>");
			out.println("alert('고객님의 아이디는 "+mem_id+" 입니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('입력하신 정보와 일치하는 아이디가 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		return null;
	}

}
