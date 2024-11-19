<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phones</title>
</head>
<body>
	<h1>Phones</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<c:forEach var="phone" items="${all}">
			<tr>
				<td> <c:out value="${phone.id}" /> </td>
				<td> <c:out value="${phone.name}" /> </td>
				<td> 
					<a href="<c:url value='/phone?id=${phone.id}'/>" />
					Details
				</td>
			</tr>
		</c:forEach>
		
		
	</table>
</body>
</html>