package com.partners.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partners.dao.PartnersDAO;
import com.partners.dto.PartnersDTO;

public class PartnersIDCheckController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out= response.getWriter();
		String pId = request.getParameter("pId");
		
		PartnersDAO dao = new PartnersDAO();
		PartnersDTO dto =dao.selectPartner(pId);
		
		int re= -1;
		
		if(dto!= null) 	re=1;
		
		
		out.print(re);
		return null;
	}

}
