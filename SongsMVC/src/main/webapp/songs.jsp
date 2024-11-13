<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Songs</title>
</head>
<body>
	<h1>Songs</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Music Sheet</th>
			<th>verses</th>
			<th>Nr Votes</th>
		</tr>
		<c:forEach var="song" items="${all}">
			<tr>
				<th> <c:out value="${song.id}" /> </th>
				<th> <c:out value="${song.title}" /> </th>
				<th> <c:out value="${song.author}" /> </th>
				<th> <c:out value="${song.linkMusicSheet}" /> </th>
				<th> <c:out value="${song.verses}" /> </th>
				<th> <c:out value="${song.nrVotes}" /> </th>
			</tr>
		</c:forEach>
		
		
	</table>
</body>
</html>