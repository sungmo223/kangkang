<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<%

String sql = "select deptno, dname, loc from dept";


%>


<!DOCTYPE html>
<html lang="kr">
 <head>
	<meta charset="UTF-8">
	<title>Document</title>

	<link rel="stylesheet" href="../css/layout.css">
	<link rel="stylesheet" href="../css/main.css">

 </head>
<script>


</script>
<style>



</style>

<body>





<form name="frm" method="post" action="deptList.do">


<table border="1">
		<tr>
			<th width="15%">번호</th>
			<th width="20%">부서번호</th>
			<th width="25%">부서이름</th>
			<th width="25%">부서위치</th>
			<th width="15%"> 삭제 </th>
		</tr>
	<c:set var="number" value="1" />
	<c:forEach var="result" items="${list}" varStatus="status">
		<tr align ="center">
			<td>${status.count }, ${status.last }</td>
			<td><a href="deptModify.do?deptno=${result.deptno }">${result.deptno }</a></td>
			<td>${result.dname }</td>
			<td>${result.loc }</td>
			<td>
				<a href="deptDelete.do?deptno=${result.deptno }">del</a>
			</td>
		</tr>
		<c:set var="number" value="${number+1 }" />
	</c:forEach>
	

</table>
<div>
	<c:forEach var="i" begin="1" end="10">
			
		${i}
		<c:if test="${i ==5 }">
			<br>
		</c:if>	
	</c:forEach>
</div>
</form>


</body>
</html>
