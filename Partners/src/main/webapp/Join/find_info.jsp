<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원 정보 찾기</title>
<link rel="stylesheet" href="/Partners/css/main_style.css">
<link rel="stylesheet" href="/Partners/css/partners_style.css">
<link rel="stylesheet" href="/Partners/css/join_style.css">

<script src="/Partners/js/jquery.js"></script>
<script src="/Partners/js/javascript.js"></script>

<style>
body {
	margin: 50px 0px;
	background: #F9FAFB;
}

footer {
	background: white;
}
#findinfo_cont input[type=text]:hover,#findinfo_cont input[type=email]:hover{
	border: 2.5px solid #659832;

}

</style>

</head>
<body>
	<div id="findinfo_wrap">

		<div id="findinfo_title">
			<div>
				<a href="../signin.jsp"> <img src="../images/logo.png"
					alt="메인로고"></a>
			</div>
			<div class="msg">회원정보 찾기</div>
		</div>
		<div id="findinfo_menu">
			<input type="button" id="findid_btn" value="아이디 찾기"> <input
				type="button" id="findpwd_btn" value="비밀번호 찾기">

		</div>


		<div id=findinfo_cont>
			<form id="findid_form">
				<div>
					<div class="findinfo_label">
						<label>사업자 등록번호</label>
					</div>
					<div>
						<input type="text" placeholder="000-00-00000">
					</div>
				</div>
				<div>
					<div class="findinfo_label">
						<label>가입시 등록한 핸드폰 번호</label>
					</div>
					<div>
						<input type="text" placeholder="000-0000-0000">
					</div>
				</div>
				<div>
					<div class="findinfo_label">
						<label>이메일</label>
					</div>
					<div>
						<input type="email">
					</div>
				</div>
				<div class="findinfo_findbtn">
					<div>
						<input type="button" value="아이디 찾기">
					</div>
					<div>
						<input type="reset" value="취소">
					</div>

				</div>

			</form>

			<form id="findpwd_form">
				<div>
					<div class="findinfo_label">
						<label>사업자 등록번호</label>
					</div>
					<div>
						<input type="text" placeholder="000-00-00000">
					</div>
				</div>
				<div>
					<div class="findinfo_label">
						<label>계정 ID</label>
					</div>
					<div>
						<input type="text">
					</div>
				</div>
				<div>
					<div class="findinfo_label">
						<label>계정 사용자명</label>
					</div>
					<div>
						<input type="text">
					</div>
				</div>
				<p>*가입시 등록한 이메일로 전송됩니다.</p>
				<div class="findinfo_findbtn">
					<div>
						<input type="button" value="비밀번호 찾기">
					</div>
					<div>
						<input type="reset" value="취소">
					</div>

				</div>

			</form>


		</div>


		<script>
			/* 회원정보 찾기 창 전환 */
		
			$(function() {
				$('#findid_btn').click(function() {
					$('#findid_form').show();
					$('#findpwd_form').hide();
					$('#findid_btn').css("background","#659832");
					$('#findpwd_btn').css("background","#F0F0F0");

				});
			});
			$(function() {
				$('#findpwd_btn').click(function() {
					$('#findpwd_form').show();
					$('#findid_form').hide();
					$('#findpwd_btn').css("background","#659832");
					$('#findid_btn').css("background","#F0F0F0");
					
				});
			});
			
			$(document).ready(function () {
				$('#findid_btn').css("background","#659832");
			});
			
			
		</script>


			

		<jsp:include page="../include/footer.jsp" />