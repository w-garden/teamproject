package com.partners.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partners.dao.BidDAO;
import com.partners.dto.EstimateDTO;

public class BidBoardListController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BidDAO bdao=new BidDAO();
		
		//EstimateDTO edto=bdao.selectBid(est_num);//번호에 해당하는 DB레코드값을 가져옴

		
		//findB.setFind_field(find_field); 
		//findB.setFind_name("%"+find_name+"%");//%는 쿼리문 와일드카드
		//문자로서 검색해서 하나 이상의 임의의 모르는 문자와 매핑 대응한다.
		
		
		//BidDAO bdao=new BidDAO();
		
		//int listcount=bdao.getListCount(findB);//검색 전후 레코드 개수
		//List<EstimateDTO> blist=bdao.getBoardList(page, limit, findB);//검색 전후 목록
		
		//int endpage=maxpage;//마지막 페이지
		
		//if(endpage>startpage+10-1) endpage=startpage+10-1;
		
//		request.setAttribute("blist", blist); //blist속성키이름에 목록을 저장
//		request.setAttribute("page", page);//쪽번호 저장
//		request.setAttribute("startpage",startpage);
//		request.setAttribute("endpage", endpage);
//		request.setAttribute("maxpage", maxpage);
//		request.setAttribute("listcount", listcount);//레코드 개수
//		request.setAttribute("find_field", find_field);//board_title,board_cont 검색필드 저장
//		request.setAttribute("find_name", find_name);//검색어	
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/estimate_request/bid.jsp"); //여기서 만들어놓은 뷰페이지 경로로 넘어간다.
		return forward;
	}

}
