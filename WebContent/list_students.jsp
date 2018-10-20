<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Web Student Tracker</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<!-- ${STUDENT_LIST}-->
<div id="wrapper">
	<div id="header">
	<h2>ESILV Engineer School</h2>
	</div>
</div>
<div id="container">
	<div id= "content">
	<form action="AddStudentServlet" method="get">
	<input type="submit" value="Add Student"/> 
	</form> 

	<table>
	<tr>
			<th>First Name </th>
			<th>Last Name </th>
			<th>Email </th>
	</tr>
	<c:forEach var ="tempStudent" items="${STUDENT_LIST }">
	<tr>
		<td> ${tempStudent.first_name}</td>
		<td> ${tempStudent.last_name}</td>
		<td> ${tempStudent.email}</td>
	</tr>
	</c:forEach>
	</table>
</div>
</div>
</body>
</html>