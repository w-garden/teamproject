<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<link rel="stylesheet" type="text/css" href="../css/login.css" />
</head>
<body>
<div id="join_wrap">
	<div id="join_title"><p>회원가입</p></div>
	<form id="join_form_box" method="post"  action="#" >
		<table id="join_form_table">
			<tr>
				<th>아이디</th>
				<td><input type="text"  name="mem_id" placeholder="아이디를 입력해주세요"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password"  name="mem_pwd"  placeholder="비밀번호를 입력해주세요(4자이상)"/></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password"  name="mem_pwd_check"  placeholder="비밀번호를 다시 입력해주세요"/></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text"  name="mem_name" placeholder="이름을 입력해주세요" /></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text"  name="mem_phone"  placeholder="-없이 숫자만 입력해주세요"/></td>
			</tr>
			<tr>
				<th>이메일주소</th>
				<td><input type="text"  name="mem_email"  placeholder="이메일주소를 입력해주세요"/></td>
			</tr>
		</table>
		
		<div class="join_agree">
			<label id="all_check"><span class="agree_text"><input type="checkbox"  name="all"  onclick="allselect(this.checked)"></span><span class="agree_text">전체동의</span></label>
			<hr/ width="100%">
			<label><span class="agree_text"><input type="checkbox" name="chk" onclick="checkSelectAll()"></span><span class="agree_text" id="text1">(필수)</span><span class="agree_text" id="text2"><a href="#" >개인정보 처리방침</a>에 동의</span></label>
			<label><span class="agree_text"><input type="checkbox" name="chk" onclick="checkSelectAll()"></span><span class="agree_text" id="text1">(필수)</span><span class="agree_text" id="text2"><a href="#" >이용약관</a>에 동의</span></label>
			<label><span class="agree_text"><input type="checkbox" name="chk" onclick="checkSelectAll()"></span><span class="agree_text" id="text1">(선택)</span><span class="agree_text" id="text2"><a href="#" >인테리어 정보 및 마케팅 수신</a>에 동의</span></label>
			<span id="text3">※개인정보 처리방침에 동의해주세요.</span>
		</div>
		<div>
			<button id="join_btn"  type="submit">가 입 하 기</button>
		</div>
	</form>
	
	<script>
		/* 전체선택 */
		function allselect(bool){
			var chks = document.getElementsByName("chk");
			for(var i = 0; i < chks.length; i++){
				chks[i].checked = bool;
			}
		}
		/* 아래 항목 선택여부 따라 자동으로 전체선택 적용, 해제 */
		function checkSelectAll()  {
			  const checkboxes = document.querySelectorAll('input[name="chk"]');
			  const checked = document.querySelectorAll('input[name="chk"]:checked');
			  const selectAll = document.querySelector('input[name="all"]');
			  
			  if(checkboxes.length === checked.length)  {
			    selectAll.checked = true;
			  }else {
			    selectAll.checked = false;
			  }
		}
	</script>
</div>
</body>
</html>