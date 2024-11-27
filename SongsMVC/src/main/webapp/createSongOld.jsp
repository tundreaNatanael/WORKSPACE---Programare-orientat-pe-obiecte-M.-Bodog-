<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create song</title>
</head>
<body>
	<form:form 
		method="post"
		action="${pageContext.request.contextPath}/songs/saveNewSong"
		modelAttribute="newSong"
	>
		
		<label for="title">title</label>
		<form:input path="title"/><br/><br/>
		
		<label for="author">author</label>
		<form:input path="author"/><br/><br/>
		
		<label for="linkMusicSheet">linkMusicSheet</label>
		<form:input path="linkMusicSheet"/><br/><br/>
		
		<label for="verses">verses</label>
		<form:input path="verses"/><br/><br/>
		
		<label for="nrVotes">nrVotes</label>
		<form:input path="nrVotes"/><br/><br/>
		
		<input type="submit" value="Salveaza" />
	</form:form>
</body>
</html>