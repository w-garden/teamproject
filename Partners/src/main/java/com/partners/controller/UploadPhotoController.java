package com.partners.controller;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.partners.dao.PortfolioDAO;
import com.partners.dto.PortfolioDTO;

public class UploadPhotoController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		
		
		PortfolioDAO dao = new PortfolioDAO();
		
		String business_num = (String)session.getAttribute("business_num"); //세션에 저장된 사업자 번호
		String pf_title = request.getParameter("pf_title");
		String pf_type = request.getParameter("pf_type");
		String pf_subtype = request.getParameter("pf_subtype");
		String pf_range = request.getParameter("pf_range");
		String pf_zipcode = request.getParameter("pf_zipcode");
		String pf_addr1 = request.getParameter("pf_addr1");
		String pf_addr2="";
		if(request.getParameter("pf_addr2")!=null) {
			pf_addr2 = request.getParameter("pf_addr2");	
		}
		String pf_addr3 = request.getParameter("pf_addr3");
		int pf_area = Integer.parseInt(request.getParameter("pf_area"));
		int pf_cost = Integer.parseInt(request.getParameter("pf_cost"));
		int pf_period  = Integer.parseInt(request.getParameter("pf_period"));
		String pf_concept = request.getParameter("pf_concept");
		String pf_introduction = request.getParameter("pf_introduction");
		String pf_closing = request.getParameter("pf_closing");
	
		PortfolioDTO dto = new PortfolioDTO(business_num, pf_title, pf_type, pf_subtype, pf_range, pf_zipcode, pf_addr1, 
				pf_addr2, pf_addr3, pf_area, pf_cost, pf_period, pf_concept, pf_introduction, pf_closing);
		
		
		Cookie cookie = new Cookie("pf_no", String.valueOf(dao.addPortfolio(dto)));
	
		
		response.addCookie(cookie);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/portfolio/p_upload_photo.jsp");
		return forward;
	}

}
