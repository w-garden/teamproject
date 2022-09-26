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
		<th><input id="write_date"type="button" value="등록일시" onclick="alert('집에가자')"></th>
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
				<div> ${q.qna_cont }</div>
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





<script>
	function qna_reply_toggle($number) {
		var test = "#reply_"+$number;
		$(test).toggle();	
	}
	function qna_reply($number, $id, $title, $step, $level, $type){ //답변 입력 함수
		$qna_no=$number;  //글번호
		$mem_id=$id; //글작성한 회원아이디
		$qna_title=$title; //원본글제목
		$qna_step =$step; //몇번째 답글인지
		$qna_level=$level; //정렬순서
		$qna_type=$type; //질문 유형
			
		$textarea_id="#reply_"+$number+"_textarea";  
		$replytext=($($textarea_id).val()); //댓글내용
		$.ajax({
			type:"post", 
			url:'customer_qna_ok.do', 
			data:{
				qna_ref: $qna_no, //  그룹번호 = 원본글번호
				qna_cont: $replytext, // 답글 내용
				mem_id : $mem_id, //원본글 작성 회원 아이디
				qna_step : $qna_step, //몇번째 답글인지
				qna_level : $qna_level, //정렬순서
				qna_type : $qna_type //질문 유형
			},
			datatype: "text",
			
			success : function(result){			
				alert('댓글등록완료!');
				location.reload();
			}
		});
	}
	function reply_del($del_qna_no){
		$.ajax({
			type:"get",
			url:'customer_qna_del_ok.do?qna_no='+$del_qna_no,
			datatype: "text",
			success : function(result){
			alert('댓글삭제완료!');
			location.reload();
		}
		});
	}
	
	
	
</script>	
<jsp:include page="../include/footer.jsp" />


