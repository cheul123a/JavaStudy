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
<%=session.getAttribute("id")%>�� �ȳ��ϼ���. <br/>
<a href="Logout">�α׾ƿ�</a> &nbsp <a href="modify.jsp">���� ����</a> &nbsp <%if(admin==1){ %><a href ="member.jsp">ȸ�� ���� ����</a> <%} %>
</body>
</html>