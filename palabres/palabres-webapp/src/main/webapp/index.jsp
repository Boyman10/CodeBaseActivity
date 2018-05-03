<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to palabres</h2>

	${1+3}

	<s:if test="#session.user">
		<s:a action="chat">Access chat room</s:a> dear <s:property value="#session.user.pseudo" />
		<p><s:a action="logout">login out</s:a></p>
	</s:if>

	<s:else>
		<p>
			<s:a action="login">please login</s:a>
			to get access.
		</p>
		<p>
			<s:a action="register">Or register</s:a>
			.
		</p>
	</s:else>


</body>
</html>