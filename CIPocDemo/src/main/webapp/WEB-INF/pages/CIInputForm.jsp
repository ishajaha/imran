<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}

</style>
</head>

<body>
<h2>Spring's form tags example</h2>

<form:form method="POST" commandName="CIInputForm">

<form:errors path="*" cssClass="errorblock" element="div"/>

<table>
<tr>
<td>Job Name : </td>
<td><form:input path="jobName" /></td>
<td><form:errors path="jobName" cssClass="error" /></td>
</tr>
<tr>
<td> Job Description : </td>
<td><form:textarea path="jobDesc" /></td>
<td><form:errors path="jobDesc" cssClass="error" /></td>
</tr>
<tr>
<td>Source Code Management : </td>
<td>
<form:radiobutton path="scm" value="svn"/>SVN 
<form:radiobutton path="scm" value="cvs"/>CVS 
<form:radiobutton path="scm" value="git"/>GIT
</td>
<td><form:errors path="scm" cssClass="error" /></td>
</tr>
<tr>
<td>Repository URL </td>
<td><form:input path="url" /></td>
<td><form:errors path="url" cssClass="error" /></td>
</tr>
<tr>
<td> Goals and options : </td>
<td><form:textarea path="goal" /></td>
<td><form:errors path="goal" cssClass="error" /></td>
</tr>
<tr>
<td colspan="3"><input type="submit" /></td>
</tr>
</table>
</form:form>

</body>
</html>