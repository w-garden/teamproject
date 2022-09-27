package com.partners.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadPortfolioInfoOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		System.out.println("테스트");
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Partners/portfolio/p_upload.jsp");
		return forward;
	}

}
