package com.dozip.vo;

import lombok.Data;

@Data
public class QnaVO { //14개
	private int qna_no;
	private String mem_id;
	private String business_num;
	private String qna_type;
	private String qna_title;
	private String qna_cont;
	private String qna_date;
	private String edit_date;
	private int qna_state;
	private int qna_ref;
	private int qna_step;
	private int qna_level;
	private String reply_state;
	private String reply_date;
	
	private String businessName;
	
	//페이징. 쪽나누기 관련변수
	private int startrow; //시작행번호
	private int endrow; //끝행 번호
}
