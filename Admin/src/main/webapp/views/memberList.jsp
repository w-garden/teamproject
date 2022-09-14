<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/admin_memList.css"/>

<jsp:include page = "../include/header.jsp"/>
<script src="../js/jquery.js" ></script>
<%-- 상단 공통부분 끝 --%>

<%-- 본문 내용 --%>
<div class = "memlist_wrap">
	<div class = "mem_info">
		<div class = "table_type">
			<p id = "table_sel">회원 / 파트너스관리</p>
			<p id = "table_info">원하는 관리 테이블을 선택하세요</p>
		</div>
	</div>
	<div class = "table_btn">
				<input type = "button" id = "mem_btn" value = "회원정보" onClick = "view(1)"/>
				<input type = "button" id = "part_btn" value = "파트너스정보" onClick = "view(2)"/>
	</div>	
	<div class = "mem_table">
		<script>
			function view(arg){
				var t1 = document.getElementById("tb_mem");
				var t2 = document.getElementById("tb_part");
				if(arg == 1){
					t1.style.display = "block";
					t2.style.display= "none";
				}
				else{
					t2.style.display = "block";
					t1.style.display = "none";
				}
			}
		</script>
		<table id = "tb_mem" border = "1" >
			<tr>
				<th id = "tb_check">체크</th>
				<th id = "tb_num">번호</th>
				<th id = "tb_nick">아이디</th>
				<th id = "tb_name">이름</th>
				<th id = "tb_phone">연락처</th>
				<th id = "tb_email">이메일 주소</th>
				<th id = "tb_address">자택주소</th>
			</tr>
			<%! int i = 0; %>
				<% for(i=1; i<=10; i++) { %>
				<tr>
					<td id = "check"><input type = "checkbox" value = "chk"/></td>
					<td id="num"><%=i %></td> 
					<td id="nick">kdm6606</td> 
					<td id="name">구동민</td> 
					<td id="phone">010-7777-9999</td>
					<td id ="email">kdm6606@naver.com</td>
					<td id = "address">서울시 강남구 역삼동</td>
				</tr>
			<% } %>
		</table>
		<table id = "tb_part" border = "1">
			<tr>
				<th id = "tb_check2">체크</th>
				<th id = "tb_num2">번호</th>
				<th id = "tb_nick2">아이디</th>
				<th id = "comp_name">사업자명</th>
				<th id = "comp_num">사업자 번호</th>
				<th id = "comp_address">사업자 주소</th>
				<th id = "ceo">대표자명</th>
				<th id = "comp_tel">연락처</th>
				<th id = "plan">요금제</th>
			</tr>
			<%! int j = 0; %>
				<% for(j=1; j<=10; j++) { %>
				<tr>
					<td id = "tb_check2"><input type = "checkbox" value = "chk2"/></td>
					<td id="num2"><%=j %></td> 
					<td id="nick2">beckycheckin</td> 
					<td id="co_name">동민디자인</td> 
					<td id="co_num">759-41-00656</td>
					<td id = "co_address">서울시 강남구 선릉로</td>
					<td id ="ceo_name">becky@naver.com</td>
					<td id = "co_tel">010-6666-7777</td>
					<td id = "co_plan">3000만원</td>
				</tr>
			<% } %>			
		</table>
	</div>
</div>
<br><br>





<%-- 하단 공통부분--%>
<jsp:include page = "../include/footer.jsp"/>