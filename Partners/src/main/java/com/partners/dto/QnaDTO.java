package com.partners.dto;
import lombok.Data;
@Data
public class QnaDTO { //db 레코드는 14개
		private int qna_no; //글번호
		private String mem_id; //고객아이디(fk)
		private String business_num; //사업자번호(fk)
		private String qna_type; //질문유형
		private String qna_title; //글제목
		private String qna_cont;  //글내용
		private String qna_date;  //작성일자
		private String edit_date; //수정일자
		private int qna_state; //글상태(삭제:0)
		private int qna_ref; //답글(그룹번호)
		private int qna_step; //답글(원본글:0)
		private int qna_level; //답글(정렬순서 원본글:0)
		private String reply_state; //답변상태
		private String reply_date; //답변일자
		
		
		private String businessName; //업체명
		private String mem_name; //고객명

		
		//페이징. 쪽나누기 관련변수
		private int startrow; //시작행번호
		private int endrow; //끝행 번호
		
		//검색하기
		private String find_field; //검색 필드
		private String find_text; //검색어
		private String answer; //답변여부

		
		
}
