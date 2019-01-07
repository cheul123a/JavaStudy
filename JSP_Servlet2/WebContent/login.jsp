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
<legend>로그인</legend>
<form action="DBlogin" method="post">
	<table>
		<tr>
		<td>아이디 : </td> <td><input type="text" name="id" required="required"></td>
		</tr>
		<tr>
		<td>패스워드 : </td> <td><input type="password" name="pw" required="required"></td>
		</tr>	
		<tr>
		<td><a href="register.jsp">회원가입</a></td>&nbsp<td><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>
</fieldset>
</body>
</html>