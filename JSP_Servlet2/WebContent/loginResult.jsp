<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%int admin = Integer.parseInt((String)session.getAttribute("admin"));

%>
<%=session.getAttribute("id")%>님 안녕하세요. <br/>
<a href="Logout">로그아웃</a> &nbsp <a href="modify.jsp">정보 수정</a> &nbsp <%if(admin==1){ %><a href ="member.jsp">회원 정보 보기</a> <%} %>
</body>
</html>