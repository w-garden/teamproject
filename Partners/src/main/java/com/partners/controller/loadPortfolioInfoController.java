package com.partners.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loadPortfolioInfoController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String business_num = request.getParameter("business_num");
		System.out.println(business_num);
		return null;
	}

}
