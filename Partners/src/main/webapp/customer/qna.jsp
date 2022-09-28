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

td#reply_cont{

	background:#e1deca;

}
span.reply_date_text{
	font-weight: bold;
}
div#reply_cont{
    width: 80%;
    margin: 0 auto;
   	padding: 10px 0;
    display: flex;
    justify-content: space-between;
}
#qna_table th{
	height:50px;
}
#write_date {
    border: none;
    background: none;
    font-weight: bold;
    font-size: 15px;
}
.not_serach_msg {
	text-align: center;
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
<form action="customer_qna.do" method="post" onsubmit='return search_check();'>
<div  id="search_conditon">
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
			<h1>   테스트 ${answer }</h1>
		<div>
			<input type="radio" name="answer" value="whole" <c:if test="${answer =='whole'}"> ${'checked' }</c:if>> 전체 <input
				type="radio" name="answer" value="yes" <c:if test="${answer =='yes' }"> ${'checked' }</c:if>> 답변 <input
				type="radio" name="answer" value="no" <c:if test="${answer =='no' }"> ${'checked' }</c:if>> 미답변
		</div>
		<hr>
		<div>
			<select id="search_condition" name="find_field">
				<option value="default" selected>검색옵션</option>
				<option value="customer_name" <c:if test="${find_field =='customer_name' }"> ${'selected' }</c:if>>고객명</option>
				<option value="qna_type" <c:if test="${find_field =='qna_type' }"> ${'selected' }</c:if>>문의유형</option>
			</select> <input type="search" name="find_text" id="search_text" value="${find_name }" placeholder="입력해주세요">
		</div>
		<hr>

		<div id="search_conditon_hidemenu">
			<div>
				<input type="submit" value="검색"> <input type="reset" value="초기화" onclick="">
			</div>
			<input type="button" value="검색 접기" id="hide_button" onclick="display()">
		</div>
	</div>
</div>
<table id="qna_table">
	<tr>	
		<th>글번호</th>
		<th><input id="write_date"type="button" value="등록일시" onclick="alert('정렬기능 구현 대기중')"></th>
		<th>고객명</th>
		<th>문의내용</th>
		<th>문의유형</th>
		<th>답변여부</th>
	</tr>
	<c:if test="${empty qlist }">
		<tr>
			<td colspan="6" class="not_serach_msg"> 조회된 문의 내용이 없습니다.</td>
		</tr>
	</c:if>
	<c:if test="${!empty qlist }">
		<c:forEach var="q" items="${ qlist}">
			<c:if test="${q.qna_step ==0}">
			<tr>
				<td>${q.qna_no }</td>
				<td class="qna_table_date">${q.qna_date }</td>
				<td>${q.mem_name }</td>
				<td>글제목 : ${q.qna_title } <br>문의내용 : ${q.qna_cont }
				</td>
				<td>${q.qna_type }
				<input type="hidden" id="board_ref" value="${q.qna_ref }">
			    <input type="hidden" id="board_step" value="${q.qna_step }">
			    <input type="hidden" id="board_level" value="${q.qna_level }">
			    </td>
				<td><input type="button" value="답변하기" id = "reply_${q.qna_no }_btn" onclick="qna_reply_toggle(${q.qna_no })" ></td>
			</tr>
			</c:if>
			<c:if test="${q.qna_step==1 }">
			<tr>
			<td colspan="6" >
			<div id="reply_cont">
				<div><span class="reply_date_text"> ${ q.reply_date} </span></div>
				<div> <span style="color:blue; font-weight:bolder;">${q.qna_title} </span>  &nbsp; ${q.qna_cont }</div>
				<div>
				<input type="button" value="삭제" onclick="reply_del(${q.qna_no })">
				</div>
			</div>
				
			</td>
			</tr>
			</c:if>
			<tr>
			 <td colspan="6" style="display:none;" id="reply_${q.qna_no }"> 
				<textarea rows="5%" cols="100%" id="reply_${q.qna_no }_textarea" style="width: 86%; resize: none;"></textarea>
				<input type="button" value="등록" onclick="qna_reply(${q.qna_no }, '${q.mem_id }', '${q.qna_title }',${q.qna_step }, ${q.qna_level },'${q.qna_type }')">
			</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
</form>
<jsp:include page="../include/footer.jsp" />