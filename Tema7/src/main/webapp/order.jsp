<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
</head>
<body>
	<h1>Single order page</h1>
	<h3> Id: <c:out value="${s.id}" /> </h3> <br/>
	<h3> Date: <c:out value="${s.date}" /> </h3> <br/>
	<h3> Id Product: <c:out value="${s.idProduct}" /> </h3>
	
</body>
</html>