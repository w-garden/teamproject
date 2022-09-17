package com.partners.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partners.dao.PartnersDAO;
import com.partners.dto.PartnersDTO;

public class PartnersSignupOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String business_num = request.getParameter("business_num");
		String businessName = request.getParameter("businessName");
		String pId = request.getParameter("pId");
		String pPw = request.getParameter("pPw");
		String pName = request.getParameter("pName");
		String pTel = request.getParameter("pTel");
		String pMail_id = request.getParameter("pMail_id");
		String pMail_domain = request.getParameter("pMail_domain");
		PartnersDTO dto = new PartnersDTO(business_num, businessName, pId, pPw, pName, pTel, pMail_id, pMail_domain);
		PartnersDAO dao = new PartnersDAO();
		int result = dao.insertPartners(dto);
		
		if(result ==1) {
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("partners_login.do");
			return forward;
		}
		return null;
	}

}
