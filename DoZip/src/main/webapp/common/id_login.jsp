<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디로 로그인</title>
	<link rel="stylesheet" type="text/css" href="../css/login.css" />
</head>
<body>
<div id="id_login_wrap">
	<div id="id_login_title">
		<p>아이디로 시작하기</p>
	</div>
	<form id="id_login_box" method="post" action="#">
		<input type="text"  name="member_id" placeholder="  아이디"/>
		<input type="password" name="member_pwd" placeholder="  비밀번호"/>
		<button id="login_btn" type="submit">로 그 인</button>
	</form>
	<div id="find_box">
		<span>
			<a href="./find_id_pwd.jsp" >아이디/비밀번호 찾기 </a>
		</span>
	</div>
	<div id="join_info">
		<span>
			<p>아직 두집 회원이 아니시라면? &nbsp;
			<a href="#none" onclick="openJoin();">회원가입하기</a></p>
		</span>
	</div>
</div>

<!-- 회원가입 -->
	<script>
    function openJoin(){
        window.open("mem_join.jsp", "_blank", 
        		"toolbar=no, menubar=no, scrollbars=no, resizable=no, width=500, height=750, left=0, top=0" );
    }
	</script>
</body>
</html>