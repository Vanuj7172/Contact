<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard - Contact Application</title>

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
		<h1>Admin Dashboard</h1>
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