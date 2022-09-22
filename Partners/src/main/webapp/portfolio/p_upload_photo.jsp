<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />




<style>
#uploda_photo_cont {
	height: 130vw;
}

#uploda_photo_cont>div {
	float: left;
	border-right: 3px solid black;
	margin-right: 30px;
}
.photo_inputfile {
	margin-bottom: 20px;
}
#uploda_photo_cont img {
	width: 200px;
	height: 200px;
}

#photo_submit {
	margin: 40px 0px 0px 50px;
	clear: both;
}
#photo_upload_title{

}
</style>
<div id=photo_upload_title>
<h1>사진등록페이지</h1>
<p>포트폴리오에 등록할 사진을 첨부해주세요. 최대 5장까지 가능합니다</p>
</div>
<form action="upload_photo_ok.do" method="post"
	enctype="multipart/form-data">
	<div id=uploda_photo_cont>

		<div>
			<div class="photo_inputfile">
				<input type="file" name="photo01" id="photo01"
					onchange="loadFile1(this)" value="사진">
			</div>
			<div>
				<img alt="미리보기1" id="preview1" style="display: none;">
			</div>
		</div>
		<div>
			<div class="photo_inputfile">
				<input type="file" name="photo02" id="photo02"
					onchange="loadFile2(this)">
			</div>
			<div>
				<img alt="미리보기2" id="preview2" style="display: none;">
			</div>

		</div>
		<div>
			<div class="photo_inputfile">
				<input type="file" name="photo03" id="photo03"
					onchange="loadFile3(this)">
			</div>
			<div>
				<img alt="미리보기3" id="preview3" style="display: none;">

			</div>
		</div>
		<div>
			<div class="photo_inputfile">
				<input type="file" name="photo04" id="photo04"
					onchange="loadFile4(this)">
			</div>
			<div>
				<img alt="미리보기4" id="preview4" style="display: none;">
			</div>
		</div>
		<div>
			<div class="photo_inputfile">
				<input type="file" name="photo05" id="photo05"
					onchange="loadFile5(this)">
			</div>
			<div>
				<img alt="미리보기5" id="preview5" style="display: none;">
			</div>
		</div>

	</div>
	<div>	<input type="submit" value="등록">
	</div>
</form>






<script type="text/javascript">
	function loadFile1(input) {
		// 여러개의 이미지를 읽을수도 있기 때문에 
		if (input.files && input.files[0]) {
			var fr = new FileReader();
			//파일리더로 일고 읽는게 완료되면  만들어준 아이디에 속성값을 지정하여 사용하겠다.
			fr.onload = function(event) {
				document.getElementById('preview1').src = event.target.result;
				document.getElementById('preview1').style.display = "flex";
			};
			fr.readAsDataURL(input.files[0]);
			// 이미지파일을 읽어 온다.
		} else {
			document.getElementById('preview1').src = "";
		}
	}
	function loadFile2(input) {
		// 여러개의 이미지를 읽을수도 있기 때문에 
		if (input.files && input.files[0]) {
			var fr = new FileReader();
			//파일리더로 일고 읽는게 완료되면  만들어준 아이디에 속성값을 지정하여 사용하겠다.
			fr.onload = function(event) {
				document.getElementById('preview2').src = event.target.result;
				document.getElementById('preview2').style.display = "flex";

			};
			fr.readAsDataURL(input.files[0]);
			// 이미지파일을 읽어 온다.
		} else {
			document.getElementById('preview2').src = "";
		}
	}
	function loadFile3(input) {
		// 여러개의 이미지를 읽을수도 있기 때문에 
		if (input.files && input.files[0]) {
			var fr = new FileReader();
			//파일리더로 일고 읽는게 완료되면  만들어준 아이디에 속성값을 지정하여 사용하겠다.
			fr.onload = function(event) {
				document.getElementById('preview3').src = event.target.result;
				document.getElementById('preview3').style.display = "flex";

			};
			fr.readAsDataURL(input.files[0]);
			// 이미지파일을 읽어 온다.
		} else {
			document.getElementById('preview3').src = "";
		}
	}
	function loadFile4(input) {
		// 여러개의 이미지를 읽을수도 있기 때문에 
		if (input.files && input.files[0]) {
			var fr = new FileReader();
			//파일리더로 일고 읽는게 완료되면  만들어준 아이디에 속성값을 지정하여 사용하겠다.
			fr.onload = function(event) {
				document.getElementById('preview4').src = event.target.result;
				document.getElementById('preview4').style.display = "flex";

			};
			fr.readAsDataURL(input.files[0]);
			// 이미지파일을 읽어 온다.
		} else {
			document.getElementById('preview4').src = "";
		}
	}
	function loadFile5(input) {
		// 여러개의 이미지를 읽을수도 있기 때문에 
		if (input.files && input.files[0]) {
			var fr = new FileReader();
			//파일리더로 일고 읽는게 완료되면  만들어준 아이디에 속성값을 지정하여 사용하겠다.
			fr.onload = function(event) {
				document.getElementById('preview5').src = event.target.result;
				document.getElementById('preview5').style.display = "flex";

			};
			fr.readAsDataURL(input.files[0]);
			// 이미지파일을 읽어 온다.
		} else {
			document.getElementById('preview5').src = "";
		}
	}
</script>
<jsp:include page="../include/footer.jsp" />


