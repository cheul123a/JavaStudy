<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>�α���</legend>
<form action="DBlogin" method="post">
	<table>
		<tr>
		<td>���̵� : </td> <td><input type="text" name="id" required="required"></td>
		</tr>
		<tr>
		<td>�н����� : </td> <td><input type="password" name="pw" required="required"></td>
		</tr>	
		<tr>
		<td><a href="register.jsp">ȸ������</a></td>&nbsp<td><input type="submit" value="�α���"></td>
		</tr>
	</table>
</form>
</fieldset>
</body>
</html>