package com.dozip.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.MemberDAOImpl;
import com.dozip.vo.MemberVO;

public class MemberJoinOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		String mem_id = request.getParameter("mem_id");
		String mem_pwd = request.getParameter("mem_pwd");
		String mem_name = request.getParameter("mem_name");
		String mem_tel = request.getParameter("mem_tel");
		String mem_email = request.getParameter("mem_email");
		String mem_domain = request.getParameter("mem_domain");
		
		MemberVO m = new MemberVO();
		m.setMem_id(mem_id); m.setMem_pwd(mem_pwd);
		m.setMem_name(mem_name); m.setMem_tel(mem_tel);
		m.setMem_email(mem_email); m.setMem_domain(mem_domain);
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		mdao.insertMember(m);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("home.do");
		
		return forward;
	}

}
