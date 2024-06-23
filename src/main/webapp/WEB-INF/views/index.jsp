<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
 <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>  
 <%@taglib prefix="s" uri="http://www.springframework.org/tags" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login - Contact Application</title>

<link rel="stylesheet" type="text/css" href="static/css/style.css"/>

</head>
<body>

	<table border="2" width="80%" align="center">
		<tr>
		<td height="80px">
		<%-- Header --%>
		<jsp:include page="include/header.jsp" />
		</td>
		</tr>
		
		<tr>
		<td height="25px">
		<%-- Menu --%>
		<jsp:include page="include/menu.jsp" />
		</td>
		</tr>
		<tr>
		<td height="350px" valign="top">
		<%-- Page Content Area --%>
		<h3>User Login</h3>
		 
		<c:if test="${error != null}">
			
			<p class="error">${error} </p>
		</c:if>
		
		<c:if test="${param.act eq 'lo'}">
			
			<p class="success">Logout Sucessfully. Thanks for using Contact Application </p>
		</c:if>
		
		<c:if test="${param.act eq 'reg'}">
			
			<p class="success">User Registered Successfully . Please Login </p>
		</c:if>
		
		<s:url var="url_login" value="/login" />
		<s:url var="url_reg" value="/reg_form" />
		<f:form action="${url_login}" modelAttribute="command">
		
		<table border="1">
		<tr>
		<td>Username</td>
		<td><f:input path="loginName" /></td>
		</tr>
		
		<tr>
		<td>Password</td>
		<td><f:password path="password" /></td>
		</tr>
		
		<tr>
		<td colspan="2" align="right">
		<button>Login</button>
		<a href="${url_reg}">New User Registration </a>
		</td>
		</tr>
		
		</table>
		
		</f:form>
		</td>
		</tr>
		
		<tr>
		<td height="25px">
		<jsp:include page="include/footer.jsp" />
		<%-- Footer --%>
		</td>
		</tr>
	
	</table>

</body>
</html>