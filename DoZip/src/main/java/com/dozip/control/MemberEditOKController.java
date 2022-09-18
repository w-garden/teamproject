package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.MemberDAOImpl;
import com.dozip.vo.MemberVO;

public class MemberEditOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		MemberVO m = new MemberVO();
		
		m.setMem_id(request.getParameter("mem_id"));
		m.setMem_name(request.getParameter("mem_name"));
		m.setMem_tel(request.getParameter("mem_tel"));
		m.setMem_email(request.getParameter("mem_email"));
		m.setMem_domain(request.getParameter("mem_domain"));
		m.setMem_zip(request.getParameter("mem_zip"));
		m.setMem_addr1(request.getParameter("mem_addr1"));
		m.setMem_addr2(request.getParameter("mem_addr2"));
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		
		int res = mdao.updateMember(m);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if(res ==1) {
			out.println("<script>");
			out.println("alert('회원정보가 수정되었습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('회원정보가 수정에 실패했습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return null;
	}

}
