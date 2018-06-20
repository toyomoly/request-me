<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Request me</title>
</head>
<body>
	<div>
		<h1>Request Me</h1>
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
	<div>
		<div>
			<!-- <form action="./request" method="post"> ←本来のリクエスト先 -->
			<form action="./top" method="get">
				<table>
					<tr>
						<td>user</td>
						<td><input type="text" name="user"
							placeholder="user" /></td>
					</tr>
					<tr>
						<td>password</td>
						<td><input type="password" name="password"
							placeholder="password" /></td>
					</tr>
				</table>
				<div>
					<input type="submit" value="Request" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>