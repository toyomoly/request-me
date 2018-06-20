<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Request me</title>
<link href="./css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<h1>Congratulations !!</h1>
		<div>
			<table>
				<tr>
					<th>User</th>
					<th>Stage</th>
					<th>Completed</th>
				</tr>
				<c:forEach var="score" items="${scores}">
					<tr>
						<td><c:out value="${score.userId}" /></td>
						<td><c:out value="${score.level}" /></td>
						<td><c:out value="${score.getCompletedTime()}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>