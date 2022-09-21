package com.partners.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partners.dao.PartnersDAO;
import com.partners.dto.PartnersDTO;

public class PartnersdataEditController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");//브라우저로 출력되는 문자/태그, 언어코딩 타입 설정
		PrintWriter out=response.getWriter();//출력 스트림 out 생성
		
		request.setCharacterEncoding("UTF-8");//post로 전달되는 한글을 안깨지게 함
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));//히든으로 전달된 번호값을
		//받아서 정수 숫자로 변경해서 저장
		
		int page=1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		String board_name=request.getParameter("board_name");
		String board_pwd=request.getParameter("board_pwd");
		String board_title=request.getParameter("board_title");
		String board_cont=request.getParameter("board_cont");
		
		PartnersDAO pdao=PartnersDAO();
		PartnersDAO db_pwd=pdao.getBoardCont(board_no);//번호에 해당하는 비번을 오라클 디비로부터 가져옴. 
		
		if(!db_pwd.getBoard_pwd().equals(board_pwd)) {
			out.println("<script>");
			out.println("alert('비번이 다릅니다');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			PartnersDTO eb=new PartnersDTO();
			eb.setBoard_no(board_no); eb.setBoard_name(board_name);
			eb.setBoard_title(board_title); eb.setBoard_cont(board_cont);
			
			bdao.updateBoard(eb);//게시판 수정
			
			ActionForward forward=new ActionForward();
			forward.setRedirect(true);//수정 후 새로운 매핑주소로 이동
			forward.setPath("board_cont.do?board_no="+board_no+"&page="+page+"&state=cont");
			//?뒤에 3개의 인자값을 get방식으로 전달
			return forward;
		}
		return null;
	}
}
