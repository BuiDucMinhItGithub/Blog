<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<body>
	<div class="container">
		<h4>Thêm quản trị viên</h4>
		<c:url value="/loginProcess" var="url"></c:url>
		<form action="${url}" method="POST">
			<div class="form-group">
				<label for="name">Name </label> <br> 
				<input class="form-control" name="username"/>
			</div>
			<div class="form-group">
			<label for="password">Pass</label> <br> 
				<input class="form-control"name="password"/>
			</div>
			<button  name="add" type="submit" class="btn btn-primary mt-2">Đăng nhập</button>
		</form>
	</div>
</body>
</html>