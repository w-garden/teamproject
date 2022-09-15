package com.partners.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partners.dao.PartnersDAO;
import com.partners.dto.PartnersDTO;

public class PartnersSignupOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		request.setCharacterEncoding("UTF-8");
		String business_num1 = request.getParameter("business_num");
		
		int business_num=Integer.parseInt(business_num1);
		String businessName = request.getParameter("businessName");
		String pId = request.getParameter("pId");
		String pPw = request.getParameter("pPw");
		String pName = request.getParameter("pName");
		String pTel1= request.getParameter("pTel");
		int pTel = Integer.parseInt(pTel1);
		
		PartnersDTO dto = new PartnersDTO(business_num, businessName, pId, pPw, pName, pTel, businessName, "d", "d", "d", "d", 1);
		PartnersDAO dao = new PartnersDAO();
		dao.insertPartners(dto);
		return null;
	}

}
