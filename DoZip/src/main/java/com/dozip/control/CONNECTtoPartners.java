package com.dozip.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CONNECTtoPartners implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true); // 매핑주소 새롭게 해서 파트너스 페이지로 이동 
		forward.setPath("/Partners/signin.jsp"); 
		return forward;

	}

}
