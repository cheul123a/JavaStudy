<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
 function IDvalidation() {
	var regExp1 = /^\S[a-zA-Z0-9]*$/;
	if(!regExp1.test(document.register.id.value))
	{
	    alert("ID�� ����� ���ڸ� ��� �����մϴ�.");
	    document.register.id.value.focus();
	}else{
		IdChk();
	}
}
 function IDvalidation2() {
	var regExp1 = /^\S[a-zA-Z0-9]*$/;
	if(!regExp1.test(document.register.id.value))
	{
		document.getElementById("hid").style.display = inline;
	}
}
 
 
function IdChk(){
	var url = "IdCheck.jsp?id="+ document.register.id.value;
	window.open(url, "Idcheck", "width=500, height=300, resizable=no, scrollbars=no");	
}

function Idckagain(){
	document.register.Idchk.value = "";
}

function submit_ck() {
	if(!document.register.id.value){
		alert("ID�� �Է��� �ּ���.");
		document.register.id.focus();
		return false;
	}
	if(!document.register.pw.value){
		alert("��й�ȣ�� �Է��� �ּ���.");
		document.register.pw.focus();
		return false;
	}
	if(!document.register.name.value){
		alert("�̸��� �Է��� �ּ���.");
		document.register.name.focus();
		return false;
	}
	if(!document.register.email.value){
		alert("�̸����� �Է��� �ּ���.");
		document.register.email.focus();
		return false;
	}	
	if(!document.register.Idchk.value){
		alert("���̵� �ߺ�Ȯ���� ���ּ���.");
		return false;
	}
}
/* $('hid').blur(function(){
	document.getElementById("hid").style.display: inline;
});
 */

</script>
</head>
<body onload="Idckagain()">
<fieldset>
<legend>ȸ������</legend>
<form action="DBregi" name="register" method="post" onsubmit="return submit_ck()">
	<table>
		<tr>
		<td>���̵� : </td> <td><input type="text" name="id" onkeydown="Idckagain()"></td> <td><input type="button" onclick="IDvalidation()" value="�ߺ�Ȯ��"></td>
		</tr> <input type="hidden" name="Idchk" value="">
		<tr id="hid" style="display: none;">
			<td colspan="3" align="center" >asdasd</td>
		</tr>
		<tr>
		<td>�н����� : </td> <td><input type="password" name="pw"></td>
		</tr>
		<tr>
		<td>�̸� : </td> <td><input type="text" name="name"></td>
		</tr>
		<tr>
		<td>�̸��� : </td> <td><input type="text" name="email"></td>
		</tr>
		<tr>
		<td><input type ="reset" value="�ʱ�ȭ"></td> <td><input type="submit" value="����"></td>
		</tr>		
	</table>
</form>
</fieldset>
</body>
</html>