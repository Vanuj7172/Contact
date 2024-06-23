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
<title>Contact Form - Contact Application</title>

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
		<h3>Contact Form</h3>
		 
		<c:if test="${error != null}">
			
			<p class="error">${error} </p>
		</c:if>
		
		
		<s:url var="url_csave" value="/user/save_contact" />
		<f:form action="${url_csave}" modelAttribute="command">
		
		<table border="1">
		<tr>
		<td>Name</td>
		<td><f:input path="name" /></td>
		</tr>
		
		<tr>
		<td>Phone</td>
		<td><f:input path="phone" /></td>
		</tr>
		
		<tr>
		<td>Email</td>
		<td><f:input path="email" /></td>
		</tr>
		
		
		<tr>
		<td>Address</td>
		<td><f:textarea path="address" /></td>
		</tr>
		
		
		
		<tr>
		<td>Remark</td>
		<td><f:textarea path="remark"  /></td>
		</tr>
		
		
		
		<tr>
		<td colspan="2" align="right">
		<button>Save</button>
		
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