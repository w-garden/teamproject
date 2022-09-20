package com.dozip.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dozip.dao.MemberDAOImpl;
import com.dozip.vo.MemberVO;

public class MypageGoController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("id"); //현재 로그인 되어있는 세션의 아이디 값
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		MemberVO m = mdao.getMemberInfo(id);
		
		request.setAttribute("m", m);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./mypage/mypage_main.jsp");
		
		return forward;
	}
}
