<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn = null;
PreparedStatement pstmt = null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?serverTimezone=Asia/Seoul", "root", "root");			
	
	String sql = "select * from member";
	pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
%>

<fieldset>
<legend>ȸ�� ����</legend>
	<table border="1">
		<tr>
		<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td><td>�̸���</td>
		</tr>
		<%while(rs.next()){ %>
		<tr><td><%=rs.getString("id")%></td><td><%=rs.getString("password")%></td>
		<td><%=rs.getString("name") %></td><td><%=rs.getString("email") %></td><td><a href="memModify.jsp?id=<%=rs.getString("id")%>">����</a></td></tr>
		<%}}catch(Exception e){e.printStackTrace();} %>
	</table>
	<a href="loginResult.jsp">�α���ȭ��</a>
</fieldset>
</body>
</html>