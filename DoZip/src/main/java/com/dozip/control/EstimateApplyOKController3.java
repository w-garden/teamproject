package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.EstimateDAOImpl;
import com.dozip.vo.EstimateVO;

public class EstimateApplyOKController3 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("estimate_apply4.do");
				
		return forward;
	}

}
