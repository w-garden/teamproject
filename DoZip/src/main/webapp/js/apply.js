/*평/m2 계산기*/
function calculator(num) {
  if (num == 1) {
    document.getElementById('cal2').value = parseFloat(document.getElementById('cal1').value) * 3.3058;
  } else {
    document.getElementById('cal1').value = parseFloat(document.getElementById('cal2').value) / 3.3058;
  }
}
function change(){
	$('#cal1').val("");
}

/*전체선택*/
$(document).ready(function(){
  $('#allCk').click(function () {
    var checked = $('#allCk').is(':checked');
  
     if (checked){
       $('[name=check]').prop('checked', true);
       $("[name='detail']").show();
      }else{
        $('[name=check]').prop('checked', false);
        $("[name='detail']").hide();}
  });
  $("input[name=check]").click(function(){
    var totalBt = $('input[name=check]').length;
    var checkedBt = $('input[name=check]:checked').length;
    
    if(totalBt != checkedBt){
      $('input[name=checkAll]').prop('checked', false);
    }else{
      $('input[name=checkAll]').prop('checked', true);
    }
});
});

/*라디오*/

$('#1').change(function () {
  if ($('#1').val() == 'on') {
    $('#type01').show();
    $('#type02').hide();
  }
});
$('#2').change(function () {
  if ($('#2').val() == 'on') {
    $('#type02').show();
    $('#type01').hide();
  }
});

/*토글*/
/*$('#wall').click(function () {
	if($('#wall').is(':checked')){
   		$("#detail01").show();
	}else{
		$("#detail01").hide();
	}
});*/
$('#wall').click(function () {
  $("#detail01").toggle();
});

$('#floor').click(function () {
  $("#detail02").toggle();
});

$('#kitchen').click(function () {
  $("#detail03").toggle();
});

$('#washroom').click(function(){
  $("#detail04").toggle();
});

$('#porch').click(function(){
  $("#detail05").toggle();
});

$("#window").click(function(){
  $("#detail06").toggle();
});

$("#light").click(function(){
  $("#detail07").toggle();
});

$("#door").click(function(){
  $("#detail08").toggle();
});

/*천단위로 콤마찍기*/
function comma(str) {
  str = String(str);
  return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

function uncomma(str) {
  str = String(str);
  return str.replace(/[^\d]+/g, '');
}

function inputNumberFormat(obj) {
  obj.value = comma(uncomma(obj.value));
}

function inputOnlyNumberFormat(obj) {
  obj.value = onlynumber(uncomma(obj.value));
}

function onlynumber(str) {
  str = String(str);
  return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1');
}

/*달력*/
$(function () {
  //오늘 날짜를 출력
  $("#today").text(new Date().toLocaleDateString());

  //datepicker 한국어로 사용하기 위한 언어설정
  $.datepicker.setDefaults($.datepicker.regional['ko']);

  // 시작일(fromDate)은 종료일(toDate) 이후 날짜 선택 불가
  // 종료일(toDate)은 시작일(fromDate) 이전 날짜 선택 불가

  //시작일.
  $('#fromDate').datepicker({
    showOn: "both",                     // 달력을 표시할 타이밍 (both: focus or button)
    buttonImage: "images/calendar.gif", // 버튼 이미지
    buttonImageOnly: true,             // 버튼 이미지만 표시할지 여부
    buttonText: "",             // 버튼의 대체 텍스트
    dateFormat: "yy-mm-dd",             // 날짜의 형식
    changeMonth: true,                  // 월을 이동하기 위한 선택상자 표시여부
    //minDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이전 날짜 선택 불가)
    onClose: function (selectedDate) {
      // 시작일(fromDate) datepicker가 닫힐때
      // 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
      $("#toDate").datepicker("option", "minDate", selectedDate);
    }
  });

  //종료일
  $('#toDate').datepicker({
    showOn: "both",
    buttonImage: "images/calendar.gif",
    buttonImageOnly: true,
    buttonText: "",
    dateFormat: "yy-mm-dd",
    changeMonth: true,
    //minDate: 0, // 오늘 이전 날짜 선택 불가
    onClose: function (selectedDate) {
      // 종료일(toDate) datepicker가 닫힐때
      // 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
      $("#fromDate").datepicker("option", "maxDate", selectedDate);
    }
  });
});

//글자수
$('#paragraph').keyup(function (e) {
	let content = $(this).val();
    
    // 글자수 세기
    if (content.length == 0 || content == '') {
    	$('.textCount').text('0자');
    } else {
    	$('.textCount').text(content.length + '자');
    }
});