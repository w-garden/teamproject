package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.MemberDAOImpl;
import com.dozip.vo.MemberVO;

public class MemberFindPWController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		MemberVO m = new MemberVO();
		m.setMem_id(request.getParameter("mem_id"));
		m.setMem_name((request.getParameter("mem_name")));
		m.setMem_tel((request.getParameter("mem_tel")));
		m.setMem_email(request.getParameter("mem_email"));
		m.setMem_domain(request.getParameter("mem_domain"));
		
		System.out.println(request.getParameter("mem_id"));
		System.out.println(m.getMem_id());
		MemberDAOImpl mdao = new MemberDAOImpl();
		String res = mdao.getFindPW(m);
		if(res!=null) {
			int result = mdao.sendEmail(m,res);
			if(result==1) {
				out.println("<script>");
				out.println("alert('임시비밀번호가 메일로 발송되었습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				out.println("<script>");
				out.println("alert('입력하신 정보와 일치하는 정보가 없습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
		}
		return null;
	}

}
