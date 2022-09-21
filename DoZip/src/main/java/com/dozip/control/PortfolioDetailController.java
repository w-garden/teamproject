package com.dozip.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.PortfolioDAOImpl;
import com.dozip.vo.PortfolioDTO;

public class PortfolioDetailController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pf_no = Integer.parseInt(request.getParameter("pf_no"));
		
		PortfolioDAOImpl dao = new PortfolioDAOImpl();
		
		List<PortfolioDTO> plist = dao.getOnelist(pf_no);
		
		request.setAttribute("plist", plist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./portfolio/port_detail.jsp");
		
		return forward;
	}

}
