<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />



<h1>사진등록페이지</h1>
<form action="upload_photo_ok.do" method="post"
	enctype="multipart/form-data">

	<input type="file" name="photo01" id="photo01"
		onchange="loadFile(this)"><br> <input type="file"
		name="photo02" id="photo02" onchange="loadFile(this)"><br>
	<input type="file" name="photo03" id="photo03"><br> <input
		type="file" name="photo04" id="photo04"><br> <input
		type="file" name="photo05" id="photo05"><br> <input
		type="submit" value="등록">

</form>


<img alt="미리보기1" id="preview1"
	style="height: 200px; width: 200px; display: none;">
<img alt="미리보기2" id="preview2" style="height: 200px; width: 200px;">
<img alt="미리보기3" id="preview3" style="height: 200px; width: 200px;">
<img alt="미리보기4" id="preview4" style="height: 200px; width: 200px;">
<img alt="미리보기5" id="preview5" style="height: 200px; width: 200px;">

<script>
	function loadFile(input){
		// 여러개의 이미지를 읽을수도 있기 때문에
		if(input.files && input.files[0]){
			var fr = new FileReader();
			//파일리더로 읽는게 완료되면 만들어준 아이디에 속성값을 지정하여 사용
			
			fr.onload=function(event){
				document.getElementById('preview1').src=event.target.result;
				document.getElementById('preview1').style.display="flex";
			};
			fr.readAsDataURL(input.files[0]);
		}
		else{
			document.getElementById('preview1').src="";
		}
		
		
		

</script>
<jsp:include page="../include/footer.jsp" />


