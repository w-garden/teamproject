package com.partners.controller;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.partners.dao.PartnersDAO;
import com.partners.dto.PartnersDTO;

public class PartnersdataEditController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");//웹브라우저에 응답하는 문자/태그, 언어코딩 타입을
		//지정
		PrintWriter out=response.getWriter();//출력 스트림 out을 생성
		HttpSession session=request.getSession();//서버에 작동되는 세션 객체 생성
		PartnersDAO pdao=new PartnersDAO();
		
		String business_num = (String)session.getAttribute("business_num");
		
		/*if(business_num == null) {
           out.println("<script>");			
           out.println("alert('다시 로그인 하세요!');");
           out.println("location='data_manage.do';");
           out.println("</script>");
		}else { */
			PartnersDTO p=pdao.selectPartner2(business_num);//오라클 DB로 부터 business_num에 해당하는 회원정보를 가져온다.
			
			request.setAttribute("p",p);
			ActionForward forward=new ActionForward();
			forward.setRedirect(false); //기존 형태를 유지하면서 넘어가는것. true는 새로운 형태일때(대부분 false)
			forward.setPath("./mypage/data_manage.jsp");//뷰페이지 경로 설정
			return forward;
		//}//if else
		//return null;
	}

}
