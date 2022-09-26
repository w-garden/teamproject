package com.dozip.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dozip.dao.ApplyDAOImpl;
import com.dozip.dao.MemberDAOImpl;
import com.dozip.vo.MemberVO;
import com.dozip.vo.PartnersVO;

public class EstimateApplyController4 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("id");

		
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		MemberVO vo =mdao.getMemberInfo(mem_id); //회원정보 저장
		
		ApplyDAOImpl adao = new ApplyDAOImpl();
		List<PartnersVO> list = adao.selectNearPartners("서울시 강남구");
//		지역에 맞는 파트너스 정보 불러오기 (시, 구를 기준으로)..
//		서울시 강남구는 시공원하는 주소 정보중 시, 군 
		
		
		//지역에 맞는 업체 수 불러오기
		int count = adao.countNearPartners("서울시 강남구");
		
		
		
		
		request.setAttribute("count", count);
		request.setAttribute("vo", vo);
		request.setAttribute("list", list);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./apply/applicationSheet4.jsp"); //뷰페이지 경로 설정
		return forward;
	}

}
