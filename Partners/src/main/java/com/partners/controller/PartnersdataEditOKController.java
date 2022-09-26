package com.partners.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.partners.dao.PartnersDAO;
import com.partners.dao.Partners_subDAO;
import com.partners.dto.PartnersDTO;
import com.partners.dto.Partners_subDTO;

public class PartnersdataEditOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");//웹브라우저에 응답하는 문자/태그, 언어코딩 타입을
		//지정
		PrintWriter out=response.getWriter();//출력 스트림 out을 생성
		HttpSession session=request.getSession();//서버에 작동되는 세션 객체 생성
		
		String business_num = (String)session.getAttribute("business_num");
		
		if(business_num == null) {
           out.println("<script>");			
           out.println("alert('다시 로그인 하세요!');");
           out.println("location='data_manage.do';");
           out.println("</script>");
		}else { 
			request.setCharacterEncoding("UTF-8");
			
			String businessName=request.getParameter("businessName");
			System.out.println("상호 : "+businessName);
			String pName=request.getParameter("pName");
			String pTel=request.getParameter("pTel");
			String pAddress=request.getParameter("pAddress");
			
			PartnersDAO pdao=new PartnersDAO();
			PartnersDTO pdto=new PartnersDTO();
			
			pdto.setBusiness_num(business_num);
			pdto.setBusinessName(businessName);
			pdto.setpName(pName); pdto.setpTel(pTel);
			pdto.setpAddress(pAddress);
			
			pdao.insertPartners(pdto);
			
			String pShortstate=request.getParameter("pShortstate");
			String pInt_img=request.getParameter("pInt_img");
			String pComp_logo=request.getParameter("pComp_logo");
//			String [] pService= request.getParameterValues("pService");
//			for(String value: pService){
//				out.print(value);
//			}
			String pService=request.getParameter("pService");
			String pHomepg=request.getParameter("pHomepg");
			String pRes_build_type=request.getParameter("pRes_build_type"); //배열로?
			String pRes_space_type=request.getParameter("pRes_space_type");
			String pCom_build_type=request.getParameter("pShortstate");
			String pCom_space_type=request.getParameter("pCom_space_type");
			String pRes_person_name=request.getParameter("pRes_person_name");
			String pRes_person_tel=request.getParameter("pRes_person_tel");
			String pCom_person_name=request.getParameter("pCom_person_name");
			String pCom_person_tel=request.getParameter("pCom_person_tel");
			int pBalance=Integer.parseInt(request.getParameter("pBalance"));
			String pAccount_bank=request.getParameter("pAccount_bank");
			String pAccount_name=request.getParameter("pAccount_name");
			String pAccount_num=request.getParameter("pAccount_num");
			String pAccount_file=request.getParameter("pAccount_file");
			String pBusiness_lic_file=request.getParameter("pBusiness_lic_file");
			
			Partners_subDAO psdao=new Partners_subDAO();
			Partners_subDTO psdto=new Partners_subDTO();
			
			psdto.setpShortstate(pShortstate); 
			psdto.setpInt_img(pInt_img); psdto.setpComp_logo(pComp_logo); 
			psdto.setpService(pService); psdto.setpHomepg(pHomepg); 
			psdto.setpRes_build_type(pRes_build_type); psdto.setpRes_space_type(pRes_space_type); 
			psdto.setpCom_build_type(pCom_build_type); psdto.setpCom_space_type(pCom_space_type);
			psdto.setpRes_person_name(pRes_person_name); psdto.setpRes_person_tel(pRes_person_tel);
			psdto.setpCom_person_name(pCom_person_name); psdto.setpCom_person_tel(pCom_person_tel);
			psdto.setpBalance(pBalance);
			psdto.setpAccount_bank(pAccount_bank); psdto.setpAccount_name(pAccount_name);
			psdto.setpAccount_num(pAccount_num);
			psdto.setpAccount_num(pAccount_file); psdto.setpAccount_num(pBusiness_lic_file);
			
			psdao.insertPartnersSub(psdto);
			
			/*
			ActionForward forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("data_manage_edit.do");//뷰페이지 경로 설정
			return forward; */
			out.println("<script>");
			out.println("alert('회원 정보 수정했습니다!');");
			out.println("location='data_manage.do';");
			out.println("</script>");
		}//if else
			return null;
	}
}