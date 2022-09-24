<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />

<style>
#qna_table {
	height: 200px;
	width: 99%;
	margin: 50px 10px;
	border-collapse: collapse;
}
#qna_table th {
	background: #C0BA8D;
	border: 1px solid black;
	
}
#qna_table td{
	padding:2px 5px;
	border: 1px solid black;

}
.qna_table_date{
	max-width:100px;
}
.reply_textarea{
	border:none;
}

</style>

<div id="qna_title">
	<div class="title">고객 문의</div>
	<div class="message">고객문의 페이지입니다. 빠른 시일 내에 처리 바랍니다.</div>
</div>
<div id="search_bar">
	<div>
		<dt>검색조건</dt>
		<dd>
			<span>
				<div>
					<span>등록일</span><span class="period_cont"> 지난7일</span>
					<button type="button">▼</button>
				</div>
				<div>
					답변여부<span class="period_cont"> 지난7일</span>
					<button type="button">▼</button>
				</div>
				<div>
					상세검색
					<button id="detailed_search" type="button">▼</button>


				</div>
				<div>
					초기화
					<button type="button">▼</button>
				</div>
			</span>
		</dd>
	</div>

</div>
<form id="search_conditon">
	<div id=search_conditon_wrap>
		<div id=search_conditon_sub_1>
			<div>
				<input type="button" value="오늘"> <input type="button"
					value="지난 7일"> <input type="button" value="지난 30일">
			</div>
			<div>
				<input type="date"> ~ <input type="date">
			</div>
		</div>
		<hr>
		<div>
			<input type="radio" name="answer" value="whole"> 전체 <input
				type="radio" name="answer" value="yes"> 답변 <input
				type="radio" name="answer" value="no"> 미답변
		</div>
		<hr>
		<div>
			<select id="search_condition">
				<option value="customer_name" selected>고객명</option>
				<option value="construction_num">시공번호</option>
			</select> <input type="text" placeholder="입력해주세요">
		</div>
		<hr>

		<div id="search_conditon_hidemenu">
			<div>
				<input type="button" value="검색"> <input type="reset"
					value="초기화">
			</div>
			<input type="button" value="검색 접기" id=hide_button onclick="display()">
		</div>
	</div>

</form>
<table id="qna_table">
	<tr>	
		<th>글번호</th>
		<th>등록일시</th>
		<%--qna_date --%>
		<th>고객명</th>
		<%--  mem_id 통해서 고객명 검색--%>
		<th>문의내용</th>
		<%--글제목 : qna_title,  글내용 : qna_cont --%>
		<th>문의유형</th>
		<%-- qna_type--%>
		<th>답변여부</th>
		<%--reply_state --%>
	</tr>
	<c:if test="${empty qlist }">
		<tr>
			<td colspan="5">조회된 문의 내용이 없습니다.</td>
		</tr>
	</c:if>
	<c:if test="${!empty qlist }">
		<c:forEach var="q" items="${ qlist}">
			<tr>
				<td>${q.qna_no }</td>
				<td class="qna_table_date">${q.qna_date }</td>
				<td>${q.mem_id }</td>
				<td>글제목 : ${q.qna_title } <br>문의내용 : ${q.qna_cont }
				</td>
				<td>${q.qna_type }</td>
				
				
				<c:if test="${q.reply_state =='미답변'}">
					<td><input type="button" value="답변하기" onclick="qna_reply(${q.qna_no })" >
				</c:if>
			</tr>
			<tr>
			<td colspan="6" style="display:none;" id="reply_${q.qna_no }"><textarea rows="10" cols="100%" id="reply_${q.qna_no }_textarea"></textarea></td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<script>
	function qna_reply(number) {
		var test = "#reply_"+number;

		$(test).toggle(200);
	}
</script>	
<jsp:include page="../include/footer.jsp" />


