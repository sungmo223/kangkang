
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용후기 상세보기</title>
<link rel="stylesheet" href="<c:url value='/css/admin_layout.css'/>">

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>

<script>

function fn_comm_del(u) {
	$("#btn_submit").html("삭제");
	$("#unq").val(u);
	
	alert("암호를 입력 후 삭제버튼을 클릭해주세요.");

}


function fn_comm_mod(u,n,c,k) {
	
	$("#unq").val(u); //hidden 
	$("#name").val(n);
	$("#comment1").val(c);
	$("#pass").val("");
	
	var m = 5 - Number(k);
	$("#mark option:selected").attr("selected",false);
	$("#mark option:eq("+m+")").attr("selected",true);
	$("#btn_submit").html("수정");

}


$( function() {
	
	$("#btn_save").click(function(){
		location = "reviewBoardModify.do?unq=${vo.unq}";
	});
	
	
	$("#btn_delete").click(function(){
		location = "passWrite.do?unq=${vo.unq}";
	});
	
	
	// 코멘트 저장, 수정, 삭제
	 $("#btn_submit").click(function(){
		
		 var url = "commentSave.do";
		 
		 if($("#btn_submit").text() == "수정")  {
			 url = "commentModify.do";
		 } else if($("#btn_submit").text() == "삭제")  {
			 url = "commentDelete.do";
		 }
		
		 
		 if($("#btn_submit").text() != "삭제") {
		 	if($("#name").val() == "" ) {
		 		alert("이름을 입력해주세요.");
		 		$("#name").focus();
		 		return false; 
		 	}
		 	
		 	if($("#comment1").val() == "" ) {
		 		alert("내용을 입력해주세요.");
		 		$("#comment1").focus();
		 		return false; 
		 	}
		 }
		 
		 if($("#pass").val() == "" ) {
		 		alert("암호를 입력해주세요.");
		 		$("#pass").focus();
		 		return false; 
		 	}
		 
		 
		 
	 	var formdata = $("#frm").serialize();
	 	$.ajax({
	 		
	 		type : "post",
	 		url : url,
	 		data : formdata,
	 			
	 		datatype : "text",
	 		success :	function(data) {
	 			
	 			if(data == "ok") {
	 				alert("처리완료");
	 				document.location.reload();
	 			} else if(data == "pass_fail") {
	 				alert("암호를 다시 확인해주세요.");	
	 			} else {
	 				alert("처리실패");
	 			}
	 		},
	 		error : function() {
	 			alert("오류. 처리실패");
	 		}	

	 	});
	 	
		});
 } );
</script>

</head>

<style>
.div_cont {
	width:98%;
	height:100px;
	overflow : scroll;
}

</style>

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
			이용후기 상세
		</div>
		
		
		<div>
		<table class="table1" style="width:600px;">
		
			<colgroup>
				<col width="20%" />
				<col width="*%" />
			</colgroup>
			<tr>
				<th>제목</th>
				<td>
					${vo.title }
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					${vo.name }	
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					${vo.email }
				</td>
			</tr>
			<tr>
				<th>SNS</th>
				<td>
					${vo.sns }
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<div class="div_cont">
						${vo.content }
					</div>
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
			<tr>
				<th>조회수</th>
				<td>
					${vo.hits }
				</td>
			</tr>
			
		
		</table>
		</div>
		
		<div class="div_button">
			<button type="button" id="btn_save">수정</button>
			<button type="button" id="btn_delete" >삭제</button>
			
		</div>
		<div >
		
		<form id="frm">
		<input type="hidden" name="p_unq" value="${vo.unq}">
		<input type="hidden" name="unq" id="unq" value="0">
		<table style="width:600px; margin-top:20px" class="table1">
			<colgroup>
				<col width="15%" />
				<col width="15%" />
				<col width="15%" />
				<col width="15%" />
				<col width="15%" />
				<col width="15%" />
				<col width="*" />
			</colgroup>
			
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" id="name" style="width:70px;">
				</td>
			
				<th>암호</th>
				<td>
					<input  type="password" name="pass" id="pass" style="width:70px;">
				</td>
				<th>평점</th>
				<td>
					<select name ="mark" id="mark">
						<option value="5">아주좋음</option>
						<option value="4">좋음</option>
						<option value="3">보통</option>
						<option value="2">나쁨</option>
						<option value="1">아주나쁨</option>
					</select>
				</td>
				<th> 
					<button type="button" id="btn_submit">저장</button>
				</th>
			</tr>			
			<tr>
				<td colspan="7">
					<input type="text" name="comment1" id="comment1"
							style="width:99%">
				</td>
			</tr>
		</table>
		</form>
	
	
		<table style="width:600px; margin-top:10px;" class="table1">
			<colgroup>
				<col width="10%" />
				<col width="*%" />
				<col width="10%" />
				<col width="10%" />
				<col width="8%" />
				<col width="8%" />
			</colgroup>
			<tr>
				<th>번호</th>
				<th>코멘트</th>
				<th>이름</th>
				<th>평점</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		
			<c:forEach var="i" items="${comList }" varStatus="status" >
			<tr>
				<td style="text-align:center;">${status.count }</td>
				<td><span name="">${i.comment1 }</span></td>
				<td style="text-align:center;">
					<span name="">${i.name }</span></td>
				<td style="text-align:center;">${i.markmsg }</td>
				<td style="text-align:center;">
					<a href="javascript:fn_comm_mod('${i.unq }','${i.name }','${i.comment1 }','${i.mark }')">
						M</a></td>
				<td style="text-align:center;">
					<a href="javascript:fn_comm_del('${i.unq }')">
						D</a></td>
			</tr>
			</c:forEach>
			<c:if test="${vo.commcnt == 0 }" >
				<tr>
					<td colspan="5" 
						style="text-align: center;
						height:50px;
						background:#f8cacc"> 
							아직 첫 댓글이 업습니다. 
					</td>
				</tr>
			
			</c:if>
		</table>
		
	
		
		</div>


	</div>
</div>

</body>
</html>