package com.partners.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PartnersLoginController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./signin.jsp");
		return forward;
	}

}
