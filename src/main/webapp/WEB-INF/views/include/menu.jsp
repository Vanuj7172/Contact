<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="s" %> 

<s:url var="url_logout" value="/logout" />
<s:url var="url_reg" value="/reg_form" />
<s:url var="url_home" value="/" />
<c:if test="${ sessionScope.userId == null }">


 <!-- user is not yet logged in : Guest Menu -->
<a href="${url_home }">Home</a> | <a href="${url_home }">Login</a> | <a href="${url_reg}">Register</a> | <a href="#">About</a> | <a href="#">Help</a>

</c:if>


<c:if test="${ sessionScope.userId != null && sessionScope.role == 1}">
 <!-- Admin is  logged in : Guest Menu -->
	<a href="#">Home</a> | <a href="<s:url value="/admin/users "/>"> User List</a> |  <a href="${url_logout}">Log Out</a>

</c:if>

<c:if test="${ sessionScope.userId != null && sessionScope.role == 2}">
	<s:url var="url_uhome" value="/user/dashboard" />
	<s:url var="url_cform" value="/user/contact_form" />
	<s:url var="url_contact" value="/user/clist" />
	
 <!-- User is  logged in : Guest Menu -->
	<a href="${url_uhome }">Home</a> | <a href="${url_cform}">Add Contact</a> |  <a href="${url_contact }">Contact List</a> | <a href="${url_logout}">Log Out</a>

</c:if>
