package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dozip.dao.QnaDAOImpl;
import com.dozip.vo.QnaVO;

public class CounselPartnerWriteOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		QnaVO q = new QnaVO();
		QnaDAOImpl qdao = new QnaDAOImpl();
		
		HttpSession session=request.getSession();
		q.setMem_id((String)session.getAttribute("id"));
		q.setQna_title(request.getParameter("qna_title"));
		q.setQna_type(request.getParameter("qna_type"));
		q.setQna_cont(request.getParameter("qna_cont"));
		
		String businessName = request.getParameter("businessName");
		q.setBusiness_num(qdao.getBnum(businessName));
		
		int res = qdao.insertQna(q);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if(res == 1) { //성공
			out.println("<script>");
			out.println("alert('문의글이 등록되었습니다.');");
			out.println("location.href = 'mypage_go.do';");
			out.println("</script>");
		} else { //실패
			out.println("<script>");
			out.println("alert('글작성에 실패했습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}		

		return null;
	}

}
