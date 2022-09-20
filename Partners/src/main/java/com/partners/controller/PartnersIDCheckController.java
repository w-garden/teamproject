package com.partners.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PartnersIDCheckController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		System.out.println("dd");
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		return null;
	}

}
