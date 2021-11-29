
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용후기 암호입력</title>
<link rel="stylesheet" href="<c:url value='/css/admin_layout.css'/>">

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>

<script>
 $( function() {
	 
	 
  	$("#btn_save").click(function(){
  		
  		
  		if($("#pass").val() == "" ) {
  			alert("암호를 입력해 주세요.");
  			$("#pass").focus();
  			return false;
  		}
  		
  		
  		var formdata = $("#frm").serialize();
  		$.ajax({
  			type : "post",
  			url  : "reviewBoardDelete.do",
  			data : formdata,
  			
  			datatype : "text",  //성공여부 ( ok )
  			success : function(data) {
  				
  				if(data == "ok") {
  					alert("삭제완료");
  					location="reviewBoardList.do";
  				} else if(data == "pass_fail") {
  					alert("암호를 다시 확인해주세요.");
  				} else {
  					alert("삭제실패");
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
			암호입력
		</div>
		
		
		<form name="frm" id="frm">
		<input type="hidden" name="unq" id="unq" value="${unq }">
		<div>
		<table class="table1" style="width:600px;">
			<colgroup>
				<col width="20%" />
				<col width="*%" />
			</colgroup>
			<tr>
				<th>암호</th>
				<td>
					<input type="password" name="pass" id="pass"
							style="width::50%;" placeholder="암호를 입력해주세요.">
				</td>
			</tr>
		</table>
		</div>
		
		<div class="div_button">
			<button type="button" id="btn_save">삭제</button>
			<button type="reset" >취소</button>
			
		</div>
		</form>
	</div>
</div>

</body>
</html>