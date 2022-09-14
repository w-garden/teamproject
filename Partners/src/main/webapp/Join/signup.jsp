<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파트너스 회원가입</title>
<link rel="stylesheet" href="/Partners/css/main_style.css">
<link rel="stylesheet" href="/Partners/css/join_style.css">

<script src="/Partners/js/jquery.js"></script>
<script src="/Partners/js/javascript.js"></script>
<style>
body {
	margin: 0px;
	background: #F9FAFB;
}

footer {
	background: white;
}
</style>
<script>
	function login_check() {
		if ($.trim($('#businessName').val()) == '') {
			alert('업체명을 입력하세요');
			$('#businessName').focus();
			return false;
		}
		if ($.trim($('#business_num').val()) == '') {
			alert('사업자번호를 입력하세요');
			$('#business_num').focus();
			return false;
		}
		if ($.trim($('#pName').val()) == '') {
			alert('이름을 입력하세요');
			$('#pName').focus();
			return false;
		}
		if ($.trim($('#pTel').val()) == '') {
			alert('연락처를 입력하세요');
			$('#pTel').focus();
			return false;
		}
		if ($.trim($('#pMail').val()) == '') {
			alert('이메일을 입력하세요');
			$('#pMail').focus();
			return false;
		}
		if ($.trim($('#pId').val()) == '') {
			alert('아이디를 입력하세요');
			$('#pId').focus();
			return false;
		}
		if ($.trim($('#pPw').val()) == '') {
			alert('비밀번호를 입력하세요');
			$('#pPw').focus();
			return false;
		}
	}
</script>



</head>
<body>
	<div id="signup_wrap">

		<section id="signup_form">

			<div id="signup_title">
				<div>
					<a href="/Partners/Join/signin.jsp"> <img
						src="../images/logo.png" alt="메인로고"></a>
				</div>
				<div class="msg">파트너스 회원가입</div>
			</div>
			<form action="signin.jsp" method="post"
				onsubmit="return login_check();">
				<div class="info">
					<label for="businessName">사업자명</label> <input type="text"
						id="businessName" name="businessName" placeholder="업체명을 입력해주세요">
				</div>
				<div class="info">
					<label for="business_num">사업자번호</label> <input type="text"
						id="business_num" name="business_num"
						placeholder="사업자번호를 숫자만 입력해주세요">
				</div>
				<div class="info">
					<label for="pName">대표자 이름</label> <input type="text" id="pName"
						name="pName" placeholder="대표자 이름을 입력해주세요">
				</div>
				<div class="info">
					<label for="pTel">대표자 연락처</label> <input type="text" id="pTel"
						name="pTel" placeholder="대표자 연락처를 숫자만 입력해주세요">
				</div>
				<div class="info">
					<label for="pMail">대표자 이메일</label> <input type="text" id="pMail"
						name="pMail" placeholder="대표자 이메일을 입력해주세요">
				</div>
				<div class="info">
					<label for="pId">아이디</label>
					<div class=signup_idchk>
						<input type="text" id="pId" name="pId"
							placeholder="2~16자 영문, 숫자"> <input type="button"
							name="idchk" value="중복확인">
					</div>
				</div>
				<div class="signup_pwd">
					<label for="pPw">비밀번호</label> <input type="password"
						id="pPw" name="pPw"
						placeholder="10~16자 영문, 숫자, 특수문자 조합"> <input
						type="password" id="pwchk" placeholder="비밀번호 다시 입력">
				</div>


				<div id=signup_personalInfo>
					<div>
						<div>
							<input type="checkbox" id="all">
						</div>
						<div id=signup_personalInfo_label>
							<label for="all">전체동의</label>
						</div>
					</div>

					<div>
						<div>
							<input type="checkbox" id=check_1>
						</div>
						<div id=signup_personalInfo_label>
							<label for="check_1">개인(신용)정보의 수집 이용 동의 </label>
						</div>
					</div>
					<div>
						<div>
							<input type="checkbox" id="check_2">
						</div>
						<div id=signup_personalInfo_label>
							<label for="check_2">개인(신용)정보의 제3자 제공 동의</label>
						</div>
					</div>
					<div>
						<div>
							<input type="checkbox" id="check_3">
						</div>
						<div id=signup_personalInfo_label>
							<label for="check_3">서비스이용약관 동의</label>
						</div>
					</div>

				</div>

				<div class=signup_submit>
					<input type="submit" value="가입하기">
				</div>
			</form>
		</section>
		<jsp:include page="../include/footer.jsp" />
</body>
</html>