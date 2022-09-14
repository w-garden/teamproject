<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디/비밀번호 찾기</title>
	<link rel="stylesheet" type="text/css" href="../css/login.css" />
	<script src="../js/jquery.js"></script>
	<script>
		function on_find_id() {
			$('.find_pwd').hide();
			$('.find_id').show();
		}
		
		function on_find_pw() {
			$('.find_id').hide();
			$('.find_pwd').show();
		}
	</script>
</head>
<body>
<div class="find_wrap">
	<div id="find_select">
		<button class="select_btn"  type="button" onclick="on_find_id()" >아이디 찾기</button>
		<button class="select_btn"  type="button"  onclick="on_find_pw()">비밀번호 찾기</button>
	</div>
	
	<form class="find_id" method="post" action="#">
		<input class="find_id_input"  type="text" name="member_name"  placeholder="이름" />
		<input class="find_id_input" type="text" name="member_phone"  placeholder="전화번호" />
		<button id="find_id_btn" type="submit">아이디 찾기</button>
	</form>
	
	<form class="find_pwd" method="post" action="#"   style="display: none;">
		<input class="find_pwd_input"  type="text" name="member_id"  placeholder="아이디" />
		<input class="find_pwd_input" type="text" name="member_name"  placeholder="이름" />
		<input class="find_pwd_input" type="text" name="member_phone"  placeholder="전화번호" />
		<input class="find_pwd_input" type="text" name="member_email"  placeholder="이메일주소" />
		<p id="find_pwd_info">※비밀번호 찾기를 누르면 임시번호를 메일주소로 보내드립니다.</p>
		<button id="find_pwd_btn" type="submit">비밀번호 찾기</button>
	</form>
	
	<div class="find_info">
		<button type="button" onclick="history.go(-1)">← 로그인 화면으로 돌아가기</button>
	</div>
</div>
</body>
</html>