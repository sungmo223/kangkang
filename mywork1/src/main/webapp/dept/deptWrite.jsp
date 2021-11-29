<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="kr">
 <head>
	<meta charset="UTF-8">
	<title>Document</title>


 </head>

<script>

</script>
<body>



<form name="frm" method="post" action="deptWriteSave.do">

<table border="1" style="width:300px">
	<tr>
		<th width="30%">부서번호</th>
		<td width="*"> <input type="text" name="deptno" id="deptno"> </td>
	</tr>
	<tr>
		<th >부서이름</th>
		<td > <input type="text" name="dname" id="dname"> </td>
	</tr>
	<tr>
		<th >부서위치</th>
		<td > <input type="text" name="loc" id="loc"> </td>
	</tr>
	<tr>
	<th colspan="2">
		 <button type="submit" id="btn_save" >저장</button>
		 <button type="reset">취소</button> 
	</th>
	</tr>
	


</table>


</form>


</body>
</html>
