<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<style>
		.admin_qna_wrap {
			width: 90%;
			margin: 0 auto;
		}
		.admin_qna_table {
			width: 100%;
			margin-top: 50px;
		}
		.admin_qna_table td , .admin_qna_ans_table td{
			padding-left: 20px;
			height: 40px;
		}
	</style>
</head>
<body>
	<div class="admin_qna_wrap">
	
			<table class="admin_qna_table">
				<tr>
					<th>고객정보</th><td>고객아이디나 이름</td>
				</tr>
				<tr>
					<th>문의유형</th><td>선택된 문의유형</td>
				</tr>
				<tr>
					<th>제목</th><td>이거이거는 어떻게 되나요?</td>
				</tr>
				<tr>
					<th>작성일자</th><td>2022-10-01</td>
				</tr>
				<tr>
					<th>내용</th><td><textarea>여기</textarea></td>
				</tr>
			</table>
			
			<hr/>
			
			<form>
				<table class="admin_qna_ans_table">
					<tr>
						<th>답변내용</th><td><textarea>여기</textarea></td>
					</tr>
					<tr>
						<th colspan="2"><button>답변작성</button></th>
					</tr>
				</table>
			</form>
			
	</div>
</body>
</html>