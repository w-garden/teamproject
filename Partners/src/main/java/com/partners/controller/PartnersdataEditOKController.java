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
			
			//text에 넣은 값을 가져와 partners테이블에 값을 저장해준다.
			String businessName=request.getParameter("businessName");
			//System.out.println("상호 : "+businessName);
			String pName=request.getParameter("pName");
			String pTel=request.getParameter("pTel");
			String pAddress=request.getParameter("pAddress");

			PartnersDAO pdao=new PartnersDAO();
			PartnersDTO pdto=new PartnersDTO();
			
			pdto.setBusiness_num(business_num);
			pdto.setBusinessName(businessName);
			pdto.setpName(pName); pdto.setpTel(pTel);
			pdto.setpAddress(pAddress);
			
			pdao.updatePartners(pdto); //기존 파트너스 정보 수정 (추후묶음)
			
			Partners_subDAO psdao=new Partners_subDAO();
			
			//dto 값을 받아서 
			int res = psdao.nullCheck(business_num); 
			
			String[] pService = {};
			String[] pRes_build_type = {};
			String[] pRes_space_type = {};
			String[] pCom_build_type = {};
			String[] pCom_space_type = {};
			
			pService= request.getParameterValues("pService");
			pRes_build_type=request.getParameterValues("pRes_build_type");
			pRes_space_type=request.getParameterValues("pRes_space_type");
			pCom_build_type=request.getParameterValues("pCom_build_type");
			pCom_space_type=request.getParameterValues("pCom_space_type");
			String pServicep = "";

			for(int i=0; i<pService.length; i++) {
				pServicep+=pService[i]+"/";
			}
			System.out.println(pServicep);
			
			
			String pRes_build_typep = "";
			for(int i=0; i<pRes_build_type.length; i++) {
				pRes_build_typep+=pRes_build_type[i]+"/";
			}
			System.out.println(pRes_build_typep);
			
			String pRes_space_typep = "";
			for(int i=0; i<pRes_space_type.length; i++) {
				pRes_space_typep+=pRes_space_type[i]+"/";
			}
			System.out.println(pRes_space_typep);
			
			String pCom_build_typep = "";
			for(int i=0; i<pCom_build_type.length; i++) {
				pCom_build_typep+=pCom_build_type[i]+"/";
			}
			System.out.println(pCom_build_typep);
			
			String pCom_space_typep = "";
			for(int i=0; i<pCom_space_type.length; i++) {
				pCom_space_typep+=pCom_space_type[i]+"/";
			}
			System.out.println(pCom_space_typep);
			
			
			String pShortstate=request.getParameter("pShortstate");
//			String pInt_img=request.getParameter("pInt_img");
//			String pComp_logo=request.getParameter("pComp_logo");			
			String pHomepg=request.getParameter("pHomepg"); 
			String pRes_person_name=request.getParameter("pRes_person_name");
			String pRes_person_tel=request.getParameter("pRes_person_tel");
			String pCom_person_name=request.getParameter("pCom_person_name");
			String pCom_person_tel=request.getParameter("pCom_person_tel");
			int pBalance=Integer.parseInt(request.getParameter("pBalance"));
			String pAccount_bank=request.getParameter("pAccount_bank");
			String pAccount_name=request.getParameter("pAccount_name");
			String pAccount_num=request.getParameter("pAccount_num");
//			String pAccount_file=request.getParameter("pAccount_file");			
//			String pBusiness_lic_file=request.getParameter("pBusiness_lic_file");
			
			
			Partners_subDTO psdto=new Partners_subDTO();
			
			psdto.setBusiness_num(business_num);
			psdto.setpShortstate(pShortstate); 
		//	psdto.setpInt_img(pInt_img); psdto.setpComp_logo(pComp_logo); 
			psdto.setpService(pServicep); 
			psdto.setpHomepg(pHomepg); 
			psdto.setpRes_build_type(pRes_build_typep); psdto.setpRes_space_type(pRes_space_typep); 
			psdto.setpCom_build_type(pCom_build_typep); psdto.setpCom_space_type(pCom_space_typep);
			psdto.setpRes_person_name(pRes_person_name); 
			psdto.setpRes_person_tel(pRes_person_tel);
			psdto.setpCom_person_name(pCom_person_name); 
			psdto.setpCom_person_tel(pCom_person_tel);
			psdto.setpBalance(pBalance);
			psdto.setpAccount_bank(pAccount_bank); 
			psdto.setpAccount_name(pAccount_name);
			psdto.setpAccount_num(pAccount_num);
		//	psdto.setpAccount_num(pAccount_file); psdto.setpAccount_num(pBusiness_lic_file);
			
			
			if(res == 1/*서브테이블에 저장된 정보가 있으면*/){
				res = psdao.updatePartnersSub(psdto);
				
				request.setAttribute("pd", res);
				out.println("<script>");
				out.println("alert('정보 수정 성공!');");
				out.println("location='data_manage.do';");
				out.println("</script>");
				
			}else { //없으면
				int re = psdao.insertPartnersSub(psdto);
				if(re==1) {
					request.setAttribute("pd", re);
					
					out.println("<script>");
					out.println("alert('정보 입력 성공!');");
					out.println("history.back();");
					out.println("</script>");
				}
			}
			
//			ActionForward forward = new ActionForward();
//			forward.setRedirect(false);
//			forward.setPath("data_manage.do");
//			return forward; 
		}//if else
		
		
		return null;
	}
}