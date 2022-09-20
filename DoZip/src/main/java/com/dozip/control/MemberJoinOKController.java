package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.MemberDAOImpl;
import com.dozip.vo.MemberVO;

//회원가입기능
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
		int res = mdao.insertMember(m);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if(res == -1) { //회원가입 실패시
			out.println("<script>");
			out.println("alert('회원가입에 실패했습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else { //회원가입 성공시 창을 닫는다.
			out.println("<script>");
			out.println("window.close();");
			out.println("</script>");
		}		

		return null;
	}

}
