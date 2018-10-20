<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit the Student</title>
</head>
<body>
<c:forEach var="tempStudent" items="${STUDENT_LIST }" >
<c:url var="EditLink" value= "EditStudentServlet">
	<c:param name="studentId" value="${tempStudent.id}"/> 
	</c:url> 
		<tr> 
			<td> ${tempStudent.firstName}</td> 
			<td> ${tempStudent.lastName}</td> 
			<td> ${tempStudent.email}</td> 
			</tr> 
	</c:forEach>
</body>
</html>