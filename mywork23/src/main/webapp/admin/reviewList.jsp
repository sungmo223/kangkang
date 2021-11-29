
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자화면</title>

</head>
<link rel="stylesheet" href="<c:url value='/css/admin_layout.css'/>">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<style>
.table1 td {
	text-align:center;
}
</style>

<script>
function fn_delete(unq){
	if(confirm("정말 삭제 하시겠습니까?")) {
	$.ajax ({
	
		type : "post",
		url  : "admin_nBoardDelete.do",
		data : "unq="+unq,
	
		datatype : "text",
		success  : function(data){
			
			if(data == "ok") {
				alert("삭제하였습니다.");	
			} else {
				alert("삭제실패하였습니다.");
			}
			document.location.reload();
		},			
		error    : function(){
			alert("오류발생, 삭제 실패하였습니다.");
		}
	});
	}

}

$(function(){
	
	$("#allchk").click(function() {
		
		var ret = document.getElementById("allchk").checked;
		//alert(ret); // true.
		var len = document.getElementsByName("chk").length;
		
		for(var i=0; i<len; i++) {
			document.getElementsByName("chk")[i].checked = ret;
		}
	
		
	});
	
	$("#btn_all_delete").click(function(){
		
		var count = 0;
		var datas = "";
		var len = document.getElementsByName("chk").length;

		for(var i=0; i<len; i++) {
			var ret = document.getElementsByName("chk")[i].checked;
			if(ret == true) {
				datas += document.getElementsByName("chk")[i].value;
				datas += ",";
				count++;
			}
			
		}
		//alert(datas);
		if(count <= 0) {
			alert("삭제할 데이터를 선택해주세요.");
			return false;
		}
		
		if(confirm("정말 삭제 하시겠습니까?")) {
			$.ajax ({
			
				type : "post",
				url  : "admin_nBoardAllDelete.do",
				data : "datas="+datas,
			
				datatype : "text",
				success  : function(data){
					
					if(data > 0) {
						alert(data+"건 삭제하였습니다.");	
					} else {
						alert("삭제실패하였습니다.");
					}
					document.location.reload();
				},			
				error    : function(){
					alert("오류발생, 삭제 실패하였습니다.");
				}
			});
			}
		

	
	})
	
	
	
	
	
})


</script>


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
			이용후기 목록
		</div>
		
		<div style="float:left; text-align:left; width:300px; margin-left:15px;">
			총 검색 개수 : ${vo.total }
		</div>
		<div style="float:left;text-align:right; width:450px;">
			<form name="frm" method="post" action="reviewBoardList.do">
			(날짜검색 예: 2021/12/25 또는 2021/12)
			<select name="s_field">
				<option value="title"
					<c:if test="${s_field=='title' }">selected</c:if>
					>제목</option>
				<option value="content"
					<c:if test="${s_field=='content' }">selected</c:if>
					>내용</option>
				<option value="rdate"
					<c:if test="${s_field=='rdate' }">selected</c:if>
					>날짜</option>
			</select>
			
			<input type="text" name="s_text" value="${s_text }">
			<button type="submit"> 검색 </button>
			
			</form>
		</div>
		
		
		<div>
	
		<table class="table1">
			<colgroup>
				<col width="5%" />
				<col width="5%" />
				<col width="*%" />
				<col width="10%" />
				<col width="17%" />
				<col width="5%" />
				
				
			</colgroup>
			<tr>
				<th><input type="checkbox" id="allchk" value=""></th>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
				<th>조회수</th>
				
			</tr>
			<c:set var="rownum" value="${vo.rownum }" />						
			<c:forEach var="result" items="${list }">
			<tr>
				<td><input type="checkbox" id="chk" name="chk" value="${result.unq }"></td>
				<td>${rownum }</td>
				<td style="text-align:left;">
					<a href="reviewBoardDetail.do?unq=${result.unq }&s_field=${s_field}&s_text=${s_text}">
						${result.title } (${result.commcnt})</a>
						
				</td>
				<td>${result.name }</td>
				<td>${result.rdate }</td>
				<td>${result.hits }</td>
			</tr>
			
			<c:set var="rownum" value="${rownum-1 }" />		
			
			</c:forEach>
		</table>
		</div>
		<div style="margin-top:10px;">
			<c:forEach var="i" begin="1" end="${vo.total_page }">
				<a href="reviewBoardList.do?page_no=${i }&s_field=${s_field}&s_text=${s_text}">${i }</a>
			</c:forEach>
		</div>
		<div style="margin-top:10px; width:100%; text-align:left; margin-left:15px;">
			<button type="button" id="btn_all_delete">일괄삭제</button>
		</div>
		
	</div>
</div>

</body>
</html>