
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자화면</title>
<link rel="stylesheet" href="<c:url value='/css/admin_layout.css'/>">

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>

<script>
 $( function() {
	 
	 //이전다음버튼
	 $("#btn_before").click(function(){
		 
		 location="admin_nBoardModify.do?unq=${before}";
		 
		  
		 
	 })
	 
	  $("#btn_next").click(function(){
		 
		location="admin_nBoardModify.do?unq=%{next}";
		 
		 
	 })
	 
	 
	 
	 
	 //저장버튼
  	$("#btn_save").click(function(){
  		
  		if($("#title").val() == "" ) {
  			alert("제목을 입력해 주세요.");
  			$("#title").focus();
  			return false;
  		}
  		if($("#content").val() == "" ) {
  			alert("내용을 입력해 주세요.");
  			$("#content").focus();
  			return false;
  		}
  		
  		var formdata = $("#frm").serialize();
  		$.ajax({
  			type : "post",
  			url  : "admin_nBoardModifySave.do",
  			data : formdata,
  			
  			datatype : "text",  //성공여부 ( ok )
  			success : function(data) {
  				
  				if(data == "ok") {
  					alert("저장(변경) 성공");
  					location="admin_nBoardList.do";
  				} else {
  					alert("저장(변경) 실패")
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

<body>

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
			공지사항 수정
		</div>
		
		
		<form name="frm" id="frm">
		<div>
		<input type="hidden" name="unq" value="${vo.unq }">
		
		<table class="table1" style="width:600px;">
			<colgroup>
				<col width="20%" />
				<col width="*%" />
			</colgroup>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" id="title"
							style="width:98%;" value="${vo.title }">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" id="name" value="${vo.name }">
				</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" id="content"
							style="width:98%; height:150px;">${vo.content }</textarea>
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>
					${vo.hits }
				</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>
					${vo.rdate }
				</td>
			</tr>
			<tr>
				<th>변경일</th>
				<td>
					${vo.udate }
				</td>
			</tr>
		</table>
		</div>
		
		<div class="div_button">
			<button type="button" id="btn_before">이전</button>
			&nbsp;
			<button type="button" id="btn_save">저장</button>
			<button type="reset" >취소</button>
			&nbsp;
			<button type="button" id="btn_next">다음</button>
			
		</div>
		</form>
	</div>
</div>

</body>
</html>