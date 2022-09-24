package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dozip.dao.MemberDAOImpl;
import com.dozip.vo.MemberVO;

public class MypagePwdController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("id"); //현재 로그인 되어있는 세션의 아이디 값
		String current_pwd = request.getParameter("current_pwd");
		String new_pwd = request.getParameter("new_pwd");
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		int res = mdao.changePwd(id,current_pwd,new_pwd);
		
		PrintWriter out=response.getWriter();
		
		if(res == 0) { //변경실패
			out.println("<script>");
			out.println("alert('기존 비밀번호를 확인해주세요.');");
			out.println("history.back();");
			out.println("</script>");
		} else { //변경성공
			out.println("<script>");
			out.println("alert('비밀번호 변경이 완료되었습니다.');");
			out.println("location.href = 'mypage_go.do';");
			out.println("</script>");
		}		
		return null;
	}
}
