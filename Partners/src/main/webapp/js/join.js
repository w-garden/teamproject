/*************************/
/* 회원가입창 유효성 검사 */
/*************************/

function signup_check() {
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
	if ($.trim($('#pMail_id').val()) == '') {
		alert('이메일을 입력하세요');
		$('#pMail_id').focus();
		return false;
	}
	if ($.trim($('#pId').val()) == '') {
		alert('아이디를 입력하세요');
		$('#pId').focus();
		return false;
	}pwchk
	if ($.trim($('#pPw').val()) == '') {
		alert('비밀번호를 입력하세요');
		$('#pPw').focus();
		return false;
	}
	if ($.trim($('#pPw').val()) != $.trim($('#pwchk').val())) {
		alert('비밀번호가 일치하지 않습니다.');
		$('#pPw').val('');
		$('#pwchk').val('');
		$('#pPw').focus();

		return false;
	}
}
/********************/
/*회원가입창 이메일 */
/********************/

$(function() {
	$('#email_adr').change(function() {
		$('#pMail_domain').val($('#email_adr').val());
	});
});