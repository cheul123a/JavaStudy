<%@page import="java.sql.SQLException"%>
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
	boolean result = false;

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String id = null;

	if(request.getParameter("id") != null) {
		id = request.getParameter("id");
	} else {
		throw new IllegalArgumentException("id값은 필수.");
	}
	
	try {
		String sql = "select * from member where id = ?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?serverTimezone=Asia/Seoul", "root", "root");			
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			result=true;
		}	
	} catch(SQLException e) {
		e.getMessage();
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null){
			pstmt.close();			
		}
		if(conn != null){
			conn.close();			
		}
	}
%>

<%if(result){ %><h4>이미 사용중인 ID 입니다.</h4>
<%}else{%><h4><%=id %>는 사용가능한 ID 입니다.</h4>
<script type="text/javascript">opener.document.register.Idchk.value = 1;</script>
<%} %>



</body>
</html>