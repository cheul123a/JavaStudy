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
String id = request.getParameter("id");
Connection conn = null;
PreparedStatement pstmt = null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?serverTimezone=Asia/Seoul", "root", "root");			
	
	String sql = "select * from member where id = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	
	ResultSet rs = pstmt.executeQuery();
%>

<fieldset>
<legend>회원 정보</legend>
<form action="Memmodify" method ="post">
	<table border="1">
		<tr>
		<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td>
		</tr>
		<%while(rs.next()){ %>
		<tr><td><input type="text" name = "id" value="<%=rs.getString("id")%>"></td>
		<td><input type="text" name ="pw" value="<%=rs.getString("password")%>"></td>
		<td><input type="text" name ="name" value="<%=rs.getString("name")%>"></td>
		<td><input type="text" name ="email" value="<%=rs.getString("email")%>"></td></tr>
		<%}}catch(Exception e){e.printStackTrace();} %>
	</table>
		<input type="hidden" name="originalID" value="<%=id %>">
		<input type="submit">
	</form>
</fieldset>
</body>
</html>