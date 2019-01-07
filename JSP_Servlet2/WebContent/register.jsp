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
	    alert("ID는 영어와 숫자만 사용 가능합니다.");
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
		alert("ID를 입력해 주세요.");
		document.register.id.focus();
		return false;
	}
	if(!document.register.pw.value){
		alert("비밀번호를 입력해 주세요.");
		document.register.pw.focus();
		return false;
	}
	if(!document.register.name.value){
		alert("이름을 입력해 주세요.");
		document.register.name.focus();
		return false;
	}
	if(!document.register.email.value){
		alert("이메일을 입력해 주세요.");
		document.register.email.focus();
		return false;
	}	
	if(!document.register.Idchk.value){
		alert("아이디 중복확인을 해주세요.");
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
<legend>회원가입</legend>
<form action="DBregi" name="register" method="post" onsubmit="return submit_ck()">
	<table>
		<tr>
		<td>아이디 : </td> <td><input type="text" name="id" onkeydown="Idckagain()"></td> <td><input type="button" onclick="IDvalidation()" value="중복확인"></td>
		</tr> <input type="hidden" name="Idchk" value="">
		<tr id="hid" style="display: none;">
			<td colspan="3" align="center" >asdasd</td>
		</tr>
		<tr>
		<td>패스워드 : </td> <td><input type="password" name="pw"></td>
		</tr>
		<tr>
		<td>이름 : </td> <td><input type="text" name="name"></td>
		</tr>
		<tr>
		<td>이메일 : </td> <td><input type="text" name="email"></td>
		</tr>
		<tr>
		<td><input type ="reset" value="초기화"></td> <td><input type="submit" value="가입"></td>
		</tr>		
	</table>
</form>
</fieldset>
</body>
</html>