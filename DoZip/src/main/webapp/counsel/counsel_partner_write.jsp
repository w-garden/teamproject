<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<%-- 상단 공통부분 끝 --%>

<div class="counsel_write_wrap">
	<div class="counsel_write_title">
		<hr/>
		<p>업체문의하기</p>
	</div>
	<div class="counsel_write_form_box">
		<form id="counsel_write_form" action="" method="post">
			<span>제목<br/></span>
			<input type="text" name="cw_title"  id="cw_title"  placeholder="제목을 입력해주세요."/><br/>
			<span>업체명<br/></span>
			<input type="text" name="cw_partner_name"  id="cw_partner_name"  readonly placeholder="업체명을 검색해주세요."/>
			<button type="button" id="cw_search_btn">검색</button><br/>
			<span>문의유형<br/></span>
			<!-- <input type="text" name="cw_check"  id="cw_check"  placeholder="제목을 입력해주세요"/><br/> <select name="choice1" class="choice_group"> -->
			<select name="cw_check" id="cw_check">
				<option selected>문의유형</option>
				<option value="1">1번 문의유형</option>
				<option value="2">2번 문의유형</option>
				<option value="3">3번 문의유형</option>
				<option value="4">4번 문의유형</option>
				<option value="5">5번 문의유형</option>
			</select><br />
			<span>문의내용<br /></span>
			<textarea name="cw_cont" id="cw_cont" placeholder="문의내용을 상세히 적어주시면 상담에 도움이 됩니다."></textarea><br/>
    		<div class="cw_btn_wrap"><button type="button" id="cw_btn">작성완료</button></div>
		</form>	
	</div>



</div>

<%-- 하단 공통부분 --%>
<jsp:include page="../common/footer.jsp" />