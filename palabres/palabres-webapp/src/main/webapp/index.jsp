<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to palabres</h2>

${1+3}

<a href="jsp/about.jsp">ABOUT</a>

<p><a href="jsp/login.jsp">Please login</a> to get access.</p>

<s:url action="registerInput" var="registerInputLink" />
<p><a href="${registerInputLink}">Please register</a>.</p>

</body>
</html>