package com.dozip.control;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dozip.dao.MemberDAOImpl;
import com.dozip.vo.MemberVO;

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
		
		if(db_pwd == null) { //일치하는 아이디가 없다면
			out.println("<script>");
			out.println("alert('가입되어 있지 않은 아이디 입니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else if(!db_pwd.equals(mem_pwd)) { //해당 아이디의 비번과 일치하지 않는다면
			out.println("<script>");
			out.println("alert('비밀번호를 확인해주세요.');");
			out.println("history.back();");
			out.println("</script>");
		} else { //비밀번호가 일치한다면 
			HttpSession session=request.getSession();
			session.setAttribute("id",mem_id); //세션에 로그인 된 아이디를 저장
			
			if(mem_id.equals("admin")) { //로그인 된 아이디가 admin 관리자 아이디라면 관리자 페이지로 이동한다.		
				session.invalidate();//세션 만료 => 로그아웃
				
				out.println("<script>");
				out.println("opener.parent.location.href='/Admin/admin_home.do';"); //admin 쪽 controller로 연결
				out.println("window.close();");
				out.println("</script>");
			} else { //일반 회원이라면 창을 닫고 메인화면을 새로고침 한다.
				out.println("<script>");
				out.println("opener.parent.location.reload();");
				out.println("window.close();");
				out.println("</script>");
			}
		}
		return null;
	}

}
