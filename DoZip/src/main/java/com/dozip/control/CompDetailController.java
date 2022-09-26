package com.dozip.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.PortfolioDAOImpl;
import com.dozip.vo.PartnersVO;

public class CompDetailController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PortfolioDAOImpl dao = new PortfolioDAOImpl();
		
		String businessName = request.getParameter("businessName");
		
		PartnersVO pc = dao.getOnecomp(businessName);
		
		request.setAttribute("pc", pc);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./portfolio/comp_detail.jsp");
		
		return forward;
	}

}
