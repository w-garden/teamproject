package com.dozip.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReviewDetailController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./review/review_detail.jsp"); //뷰페이지 경로 설정
		
		return forward;
	}

}
