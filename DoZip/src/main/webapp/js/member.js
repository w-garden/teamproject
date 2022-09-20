/* 이메일주소 동기화 */
var changeSelect = function(value) {
	$("#mem_domain").val(value);
}

/* 회원가입 전체동의 */
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

/* 회원가입 창 띄우기 */
function openJoin(){
	window.open("member_join.do", "_blank", "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=550, height=750, left=0, top=0" );
}

/* 회원가입 유효성 검증 */
function validate_userid($mem_id)
{
  var pattern= new RegExp(/^[a-z0-9_]+$/);//아이디를 영문소문
  //자와 숫자 와 _조합으로 처리
  return pattern.test($mem_id);
};

function id_check(){
 /* copy begin */
	$("#idcheck").hide();
	//아이디 영역을 숨김
	$mem_id=$.trim($("#mem_id").val());
	//1.입력글자 길이 체크
	if($mem_id.length < 4){
		$newtext='<font color="red" size="2"><b>아이디는 4자 이상이어야 합니다.</b></font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append($newtext);
		$("#mem_id").val('').focus();
		return false;
	};
	if($mem_id.length > 20){
		$newtext='<font color="red" size="2"><b>아이디는 20자 이하이어야 합니다.</b></font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append($newtext);
		$("#mem_id").val('').focus();
		return false;
	};
	//2.입력글자 확인
	if(!(validate_userid($mem_id))){
		$newtext='<font color="red" size="2"><b>아이디는 영문소문자,숫자,_조합만 가능합니다.</b></font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append($newtext);
		$("#mem_id").val('').focus();
		return false;
	};
	//아이디 중복확인
    $.ajax({
        type:"POST",
        url:"member_id_check.do", 
        data: {"mem_id":$mem_id},
        datatype:"int",
        success: function (data) {
      	  if(data==1){
      		$newtext='<font color="red" size="2"><b>중복 아이디입니다.</b></font>';
      		$("#idcheck").text('');
        	$("#idcheck").show();
        	$("#idcheck").append($newtext);          		
          	$("#mem_id").val('').focus();
          	return false;
      	  }else{
      		$newtext='<font color="blue" size="2"><b>사용가능한 아이디입니다.</b></font>';
      		$("#idcheck").text('');
      		$("#idcheck").show();
      		$("#idcheck").append($newtext);
      		$("#mem_pwd").focus();
      	  }  	    	  
        },
    	  error:function(){//비동기식 아작스로 서버디비 데이터를 못가져와서 에러가 발생했을 때 호출되는 함수이다.
    		  alert("data error");
    	  }
      });//$.ajax
}

function join_check(){
	$mem_id=$.trim($("#mem_id").val());
	if($mem_id ==''){
		  alert('아이디를 입력해주세요.');
		  $('#mem_id').val('').focus();
		  return false;
	  }
	$mem_pwd=$.trim($("#mem_pwd").val());
	$mem_pwd_check=$.trim($("#mem_pwd_check").val());
	if($mem_pwd == ""){
		  alert('비밀번호를 입력해주세요.');
		  $('#mem_pwd').val('').focus();
		  return false;
	  }
	if($mem_pwd.length < 4){
		alert("비밀번호는 4자리 이상 입력해주세요.");
		$("#mem_pwd").focus();
	}
	if($mem_pwd_check == ""){
		  alert('비밀번호를 한 번 더 입력해주세요.');
		  $('#mem_pwd_check').val('').focus();
		  return false;
	  }
	if($mem_pwd != $mem_pwd_check){
		alert("비번이 다릅니다!");
		$("#mem_pwd").val("");//비번 입력박스를 초기화
		$("#mem_pwd_check").val("");
		$("#mem_pwd").focus();
		return false;
	}
	if($.trim($('#mem_name').val())==''){
		  alert('이름을 입력해주세요.');
		  $('#mem_name').val('').focus();
		  return false;
	}
	$mem_tel = $.trim($('#mem_tel').val());
	if($mem_tel ==''){
		  alert('연락처를 입력해주세요.');
		  $('#mem_tel').val('').focus();
		  return false;
	}
	if($mem_tel.length!=11){
		  alert('연락처 11자리를 확인해주세요.');
		  $('#mem_tel').focus();
		  return false;
	}
	if($.trim($('#mem_email').val())==''){
		  alert('이메일주소를 입력해주세요.');
		  $('#mem_email').val('').focus();
		  return false;
	  }
	if($.trim($('#mem_domain').val())==''){
		  alert('이메일주소를 입력해주세요.');
		  $('#mem_domain').val('').focus();
		  return false;
	  }
}

/* 아이디 로그인 유효성 */
function login_check(){
	if($.trim($('#mem_id').val())==''){
		  alert('아이디를 입력해주세요.');
		  $('#mem_id').val('').focus();
		  return false;
	  }
	if($.trim($('#mem_pwd').val())==''){
		  alert('비밀번호를 입력해주세요.');
		  $('#mem_pwd').val('').focus();
		  return false;
	  }
}
