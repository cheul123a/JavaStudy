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
<legend>���� ����</legend>
<form action="DBmodify" method="post">
	<table>
		<tr>
		<td>���̵� : </td> <td><input type="text" name="id" value="<%=session.getAttribute("id")%>"></td>
		</tr>
		<tr>
		<td>�н����� : </td> <td><input type="password" name="pw" required="required"></td>
		</tr>
		<tr>
		<td>�̸� : </td> <td><input type="text" name="name" value="<%=session.getAttribute("name")%>"></td>
		</tr>
		<tr>
		<td>�̸��� : </td> <td><input type="text" name="email" value="<%=session.getAttribute("email")%>"></td>
		</tr>
		<tr>
	 	<td><input type="submit" value="����"></td>
		</tr>		
	</table>
</form>
</fieldset>
</body>
</html>