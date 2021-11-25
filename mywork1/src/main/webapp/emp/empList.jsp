<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function fn_del(empno) {
	if(confirm("정말 삭제하시겠습니까?")) {
		location="empDelete.do?empno="+empno;
	}
}

</script>


<body>
	총 데이터 개수 : ${total }
	
	
	
	<table border="1">
		<colgroup>
			<col width="17%" />
			<col width="17%" />
			<col width="17%" />
			<col width="17%" />
			<col width="17%" />
			<col width="*%" />
		</colgroup>
		<tr>
			<th>번호</th>
			<th>사원명</th>
			<th>사원번호</th>
			<th>업무</th>
			<th>부서</th>
			<th>삭제</th>
		</tr>
		<!--  변수 선언 예시  -->
		<c:set var="a" value="1" />
		<c:set var="a" value="${a+1 }" />
		
		<c:forEach var="result" items="${list }" varStatus="status">
		<tr>
			<td>${rownum }</td>
			<td><a href="empModify.do?empno=${result.empno }">${result.ename}</a> </td>
			<td>${result.empno} </td>
			<td>${result.job} </td>
			<td>${result.deptno} </td>
			<td><a href="javascript:fn_del('${result.empno }')">del</a></td>
		</tr>
		
		<!-- rownum--; 가감처리-->
		<c:set var="rownum" value="${rownum-1 }" />
		</c:forEach>
	</table>
	
	<div style="width:500px; text-align:right; margin-top:10px;">
		<button type="button" onclick="location='empWrite.do'">사원등록</button>
	</div>
	
	<div style="text-align:center; width:600px; margin-top:10px;">
		<c:forEach var="i" begin="1" end="${total_page }">
			<a href="empList.do?page_no=${i} ">${i} </a> 
		</c:forEach>
	
	</div>


</body>
</html>