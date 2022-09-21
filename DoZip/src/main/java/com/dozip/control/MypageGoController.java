package com.dozip.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dozip.dao.MemberDAOImpl;
import com.dozip.dao.QnaDAOImpl;
import com.dozip.vo.MemberVO;
import com.dozip.vo.QnaVO;

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
		
		//파트너스 리스트 출력
		QnaDAOImpl qdao = new QnaDAOImpl();
		List<QnaVO> qlist = new ArrayList<QnaVO>();
		qlist = qdao.getPlist(id);
		System.out.println(qlist.size());
		request.setAttribute("qlist", qlist);
		
		
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./mypage/mypage_main.jsp");
		
		return forward;
	}
}
