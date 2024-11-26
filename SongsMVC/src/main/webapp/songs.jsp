<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Songs</title>
</head>
<body>
	<h1>Songs</h1>
	
	<a href="<c:url value="/songs/createSong" />" >Create new song</a>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Details</th>
		</tr>
		<c:forEach var="song" items="${all}">
			<tr>
				<td> <c:out value="${song.id}" /> </td>
				<td> <c:out value="${song.title}" /> </td>
				<td> <c:out value="${song.author}" /> </td>
				<td> 
					<a href="<c:url value='/song?id=${song.id}'/>" />
					Details
				</td>
				<td> 
					<a href="<c:url value='/song/edit/${song.id}'/>" />
					Editeaza
				</td>
			</tr>
		</c:forEach>
		
		
	</table>
</body>
</html>