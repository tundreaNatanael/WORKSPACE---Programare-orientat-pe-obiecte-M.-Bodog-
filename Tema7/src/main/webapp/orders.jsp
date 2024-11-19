<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<body>
	<h1>Orders</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Date</th>
			<th>ID Product</th>
		</tr>
		<c:forEach var="order" items="${all}">
			<tr>
				<td> <c:out value="${order.id}" /> </td>
				<td> <c:out value="${order.name}" /> </td>
				<td> 
					<a href="<c:url value='/order?id=${order.id}'/>" />
					Details
				</td>
			</tr>
		</c:forEach>
		
		
	</table>
</body>
</html>