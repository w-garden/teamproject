package com.partners.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partners.controller.Action;
import com.partners.controller.ActionForward;

//@WebServlet("/BidBoardContController")
public class BidMyBoardListController implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/estimate_request/my_bid.jsp"); //여기서 만들어놓은 뷰페이지 경로로 넘어간다.
		return forward;
	}
	

}