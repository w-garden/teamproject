package com.dozip.control;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.vo.EstimateVO;

public class EstimateApplyController implements Action {
	
	EstimateVO e = new EstimateVO();
	
	//Cookie c1 = new Cookie();

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./apply/applicationSheet.jsp"); //뷰페이지 경로 설정
		return forward;
	}
}
