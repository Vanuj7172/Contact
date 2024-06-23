<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact List - Contact Application</title>

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
		<h3>Contact List</h3>
		
		<c:if test="${param.act eq 'sv' }">
			<p style="color:#00FF00;font-size:18px">Contact Saved Successfully</p>
			
		</c:if>
		
		<c:if test="${param.act eq 'del' }">
			<p style="color:#00FF00;font-size:18px">Contact deleted Successfully</p>
			
		</c:if>
		
		<form  action="<s:url value="/user/contact_search" />">
		
			<input type="text" name="freeText"  value="${param.freeText }" placeholder="Enter Text To Search">
			<button>Find</button>
		</form>
		<br>	

		<form action="<s:url value="/user/bulk_cdelete" />" >
		
		<button>Delete Selected Record</button>
		<br><br>
		
		
		<br>

		<table border=1 cellpadding=5>
		<tr>
		<th>SELECT</th>
		<th>SR</th>
		<th>CONTACT ID</th>
		<th>NAME</th>
		<th>PHONE</th>
		<th>EMAIL</th>
		<th>ADDRESS</th>
		<th>REMARK</th>
		<th>ACTION</th>
		
		</tr>
		
		<c:if test = "${empty contactList }">
		<tr>
		<td align="center" colspan="8" class="error"> No Records Present</td>
		</tr>
		</c:if>
		
		<c:forEach var="c" items = "${contactList}"  varStatus = "st">
		<tr>
		<td align="center"><input type="checkbox" name="cid" value="${c.contactId }"></td>
		<td>${st.count}</td>
		<td>${c.contactId }</td>
		<td>${c.name }</td>
		<td>${c.phone }</td>
		<td>${c.email }</td>
		<td>${c.address }</td>
		<td>${c.remark }</td>
		
		<s:url var="url_del" value="/user/del_contact">
			<s:param name="cid" value="${c.contactId }" />	
		</s:url> 
		
		<s:url var="url_edit" value="/user/edit_contact">
			<s:param name="cid" value="${c.contactId }" />	
		</s:url> 
		
		<td><a href="${url_edit }">Edit </a> |<a href="${url_del }"> Delete</a></td>
		
		</tr>
		
		</c:forEach>
		
		
		</table>
		</form>
		
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