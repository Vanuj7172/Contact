<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserList - Contact Application</title>

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
		<h1>User List</h1>
		<table border=1 cellpadding=5>
		<tr>
		
		<th>SR</th>
		<th>USER ID</th>
		<th>NAME</th>
		<th>PHONE</th>
		<th>EMAIL</th>
		<th>ADDRESS</th>
		<th>LOGINNAME</th>
		<th>ROLE</th>
		<th>LOGIN STATUS</th>
		
		</tr>
		
		<c:forEach var="u" items= "${userList }" varStatus="st">
		<tr>
		<td>${st.count}</td>
		<td>${u.userId}</td>
		<td>${u.name}</td>
		<td>${u.phone}</td>
		<td>${u.email}</td>
		<td>${u.address}</td>
		<td>${u.loginname}</td>
		<td>${u.role}</td>
		
		<td>${u.looginStatus}</td>		
		<td>
			<select>
				<option value="1" >Active</option>
				<option value="2" >Block</option>
			</select>
			
		
		</td>
		</tr>
		
		</c:forEach>
		</table>
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