
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용후기 글쓰기</title>
<link rel="stylesheet" href="css/admin_layout.css">

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>

<script>
 $( function() {
	 
	 
  	$("#btn_save").click(function(){
  		
  		if($("#title").val() == "" ) {
  			alert("제목을 입력해 주세요.");
  			$("#title").focus();
  			return false;
  		}
  		if($("#pass").val() == "" ) {
  			alert("암호를 입력해 주세요.");
  			$("#pass").focus();
  			return false;
  		}
  		if($("#name").val() == "" ) {
  			alert("이름을 입력해 주세요.");
  			$("#name").focus();
  			return false;
  		}
  		if($("#content").val() == "" ) {
  			alert("내용을 입력해 주세요.");
  			$("#content").focus();
  			return false;
  		}
  		
  		var formdata = new FormData(document.getElementById('frm'));
  		$.ajax({
  			type : "post",
  			url  : "fileBoardWriteSave.do",
  			data : formdata,
  			
  			processData : false,
  			contentType : false, 
  			
  			datatype : "text",  //성공여부 ( ok )
  			success : function(data) {
  				
  				if(data == "ok") {
  					alert("저장성공");
  					location="reviewBoardList.do";
  				} else {
  					alert("저장실패");
  				}
  				
  			},
  			error  : function() {
					alert("오류발생");
  			}
  			
  		});
  		
  		
  		
  	});
 } );
</script>
</head>

<body onload="document.frm.title.focus()">

<div class="container">
	<div class="top">
		<h2 align="center">관리자화면</h2>
	</div>
	
	<div class ="div1">
	<%@ include file = "../include/amLeftmenu.jsp" %>
	</div>
	
	<div class ="div2">
		<div style="width:90%;
					margin-left:15px;
					text-align:left;
					font-weight:bold;
					font-size: 20px;">
			자료실 등록
		</div>
		
		
		<form name="frm" id="frm" enctype="miltipart/form-data">
		<div>
		<table class="table1" style="width:600px;">
			<colgroup>
				<col width="20%" />
				<col width="*%" />
			</colgroup>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" id="title"
							style="width:98%;" placeholder="제목을 입력해주세요." autofocus >
				</td>
			</tr>
			<tr>
				<th>암호</th>
				<td>
					<input type="password" name="pass" id="pass" value="" 
							style="width::50%;" placeholder="암호를 입력해주세요.">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" id="name" value="" 
								style="width::50%;" placeholder="이름을 입력해주세요.">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" id="content"
							style="width:98%; height:150px;"></textarea>
				</td>
			</tr>
			<tr>
				<th>파일</th>
				<td>
					<input type="file" name="file1" id="file2" > <br>
					<input type="file" name="file1" id="file2" >
				</td>
			</tr>
		
		</table>
		</div>
		
		<div class="div_button">
			<button type="button" id="btn_save">저장</button>
			<button type="reset" >취소</button>
			
		</div>
		</form>
	</div>
</div>

</body>
</html>