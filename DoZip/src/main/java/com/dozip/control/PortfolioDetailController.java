package com.dozip.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.PortfolioDAOImpl;
import com.dozip.vo.PartnersVO;
import com.dozip.vo.PortfolioVO;

public class PortfolioDetailController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pf_no = Integer.parseInt(request.getParameter("pf_no"));
		
		PortfolioDAOImpl dao = new PortfolioDAOImpl();
		
		PortfolioVO pf = dao.getOnelist(pf_no); //값을 하나만 갖고 오니 list로 할 필요 없음
		
		request.setAttribute("pf", pf);
		
		PartnersVO pt = dao.getComplist(pf_no);
		
		request.setAttribute("pt", pt);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./portfolio/port_detail.jsp");
		
		return forward;
	}

}
