package com.dozip.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.PortfolioDAOImpl;
import com.dozip.vo.PortfolioVO;
import com.partners.dto.PortfolioDTO;

public class PortfolioSearchController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PortfolioVO p = new PortfolioVO();
		
		String type1 = request.getParameter("sub1");
		String type2 = request.getParameter("sub2");
		if(type1.equals("주거유형") && !type2.equals("상업유형")) {
			p.setPf_subtype(type2);
		}else if(type2.equals("상업유형") && !type1.equals("주거유형")) {
			p.setPf_subtype(type1);
		}else if(type1.equals("주거유형") && type2.equals("상업유형")){
			p.setPf_subtype("선택안됨");
		}
		System.out.println(p.getPf_subtype());
		p.setPf_concept(request.getParameter("con"));
		p.setPf_area(Integer.parseInt(request.getParameter("area")));
		p.setPf_cost(Integer.parseInt(request.getParameter("cost")));
	
		PortfolioDAOImpl pdao = new PortfolioDAOImpl();
		List<PortfolioVO> slist = new ArrayList<>(); 
		slist = pdao.getSearchList(p);
		request.setAttribute("slist", slist);
		
		System.out.println(p.toString());
		System.out.println(slist.size());
		
		for(PortfolioVO e : slist) {
			System.out.println(e.toString());
		}
		
		return null;
	}

}
