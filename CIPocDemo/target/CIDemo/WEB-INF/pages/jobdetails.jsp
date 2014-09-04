<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Job Details : ${jobdetails.jobName} </h2>
<a href="*.htm?action=list">Job Lists</a>
<table>
<tr>
<td> Job Description  :</td><td>${jobdetails.jobDescription}</td>
</tr>
<tr>
<td> First Build  :</td><td>${jobdetails.firstBuild}</td>
</tr>
<tr>
<td> Last Build  :</td><td>${jobdetails.lastBuild}</td>
</tr>
<tr>
<td> Last Completed Build  :</td><td>${jobdetails.lastCompletedBuild}</td>
</tr>
<tr>
<td> Last Successful Build  :</td><td>${jobdetails.lastSuccessfulBuild}</td>
</tr>
<tr>
<td> Last Stable Build :</td><td>${jobdetails.lastStableBuild}</td>
<td>
</tr>
<tr>
<td> Last Failed Build :</td><td>${jobdetails.lastFailedBuild}</td>
<td>
</tr>
<tr>
<td> Next UnSuccessful Build :</td><td>${jobdetails.lastUnsuccessfulBuild}</td>
<td>
</tr>
<tr>
<td> Next Build Number :</td><td>${jobdetails.nextBuildNumber}</td>
<td>
</tr>
<tr>
<td>
All Builds List : 
<c:forEach items="${jobdetails.builds}" var="current">
<table><tr><td><c:out value="${current}" /></td></tr></table>
</c:forEach>
</td>
</tr>
<tr>

</table>

</body>
</html>