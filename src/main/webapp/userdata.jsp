<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User data</title>
</head>
<body>

<table>
<th>name</th><th>email</th><th>city</th>
<c:forEach var="li" items="${users}">
<tr><td><c:out value="${li.get(0)}"/></td><td><c:out value="${li.get(1)}"/></td><td><c:out value="${li.get(2)}"/></td></tr>
</c:forEach>
</table>

<c:set var="cost" value="1001"/>
<c:out value="${cost }"/>
<c:if test="${cost<=1000 }">
<h1>Cost is less tha eq <c:out value="${cost }"/></h1>
</c:if>

<c:set var="String" value="Welcome to javatpoint"/>  
  
<c:if test="${fn:containsIgnoreCase(String, 'javatpoint')}">  
   <p>Found javatpoint string<p>  
</c:if>  
  
<c:if test="${fn:contains(String, 'JAVATPOINT')}">  
   <p>Found JAVATPOINT string<p>  
</c:if>  
</body>
</html>