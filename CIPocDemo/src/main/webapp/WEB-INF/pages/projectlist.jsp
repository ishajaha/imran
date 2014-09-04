<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>List of Projects </h1>

<c:if test="${not empty projects}">

			<c:forEach var="listValue" items="${projects}">
			<table><tr><td>${listValue}</td>
			<td><a href="*.htm?action=build&jobname=${listValue}">Build</a></td>
			<td><a href="*.htm?action=details&jobname=${listValue}">Details</a></td>
			<td><a href="*.htm?action=delete&jobname=${listValue}">Delete</a></td>
			</tr></table>
			</c:forEach>
	</c:if>

</body>
</html>