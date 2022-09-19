package com.partners.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PartnersSignupController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String[] email = {"직접입력","gmail.com", "naver.com", "hanmail.net","nate.com"};
		request.setAttribute("email", email);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./join/signup.jsp");
		return forward;
		
		
	}

}
