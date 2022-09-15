package com.dozip.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원가입 페이지로 이동
public class MemberJoinController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);//기본매핑주소를 유지하면서 뷰페이지로 이동
		forward.setPath("./common/mem_join.jsp");//뷰페이지 경로 설정
		
		return forward;
	}

}
