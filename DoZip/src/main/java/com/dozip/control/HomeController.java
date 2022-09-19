package com.dozip.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//메인 홈 화면으로 들어가기
public class HomeController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		
		return forward;
	}

}
