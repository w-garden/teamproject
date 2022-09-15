package com.dozip.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLoginController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);//기본매핑주소를 유지하면서 뷰페이지로 이동
		forward.setPath("./common/login.jsp");//뷰페이지 경로 설정
		
		return forward;
	}

}
