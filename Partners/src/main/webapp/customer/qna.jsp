<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />


<article id="main_cont">

	<div id="main_cont_title">
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
				<input type="button" value="검색">
				<input type="reset" value="초기화"></div>
				<input type="button" value="검색 접기" id=hide_button
					onclick="display()">
			</div>
		</div>

	</form>



	<div id="board">
		<table border="1">
			<tr>
				<th>등록일시</th>
				<th>고객명</th>
				<th>문의내용</th>
			</tr>
			<tr>
				<td colspan="3">조회된 문의 내용이 없습니다.</td>
			</tr>
		</table>
	</div>

</article>
<jsp:include page="../include/footer.jsp" />


