<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Sửa thông tin admin</title>
<script src="<c:url value="/resource/jquery/jquery-3.5.1.min.js"></c:url>"></script>
<script src="<c:url value="/resource/bootstrap/js/bootstrap.min.js"></c:url>"></script>
<link rel="stylesheet" href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"></c:url>">
<link rel="stylesheet" href="<c:url value="/resource/css/index.css"></c:url>">
<link rel="stylesheet" href="<c:url value="/resource/font-awesome/css/font-awesome.min.css"></c:url>">
<%--ckediter --%>
<script src="<c:url value="/resource/ckeditor/ckeditor.js"></c:url>"></script>
<%--js --%>
<script src="<c:url value="/resource/js/index.js"></c:url>"></script>

</head>
<body>
	<p>${message}</p>
	<div class="container">
		<h4>Sửa thông tin admin</h4>
		<c:url value="admin-edit" var="url"></c:url>
		<form:form action="${url}" method="POST" modelAttribute="admin">
			<div class="form-group">
				<label for="id">Mã </label> <br> 
				<form:input class="form-control" path="id" value="${admin.id}" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="name">Tên</label> <br> 
				<form:input class="form-control" path="name" value="${admin.name}"/>
			</div>
			<div class="form-group">
				<label for="password">Mật khẩu</label> <br>
				<form:input class="form-control" path="password" value="${admin.password}"/>
			</div>
			<div class="form-group">
				<label for="state">State</label> <br> 
				<form:input class="form-control" path="state" value="${admin.state}"/>
			</div>
			<div class="form-group">
				<form:select name="role" path="role"
					class="form-control">
					<option value="${admin.role}">${admin.role}</option>
					<option value="">Chọn quyền</option>
				    <option value="ROLE_ADMIN">Quản trị viên cấp cao</option>
				    <option value="ROLE_EMPLOYEE">Quản trị viên cấp thấp</option>
				</form:select>
			</div>
			<form:button  name="add" type="submit" class="btn btn-primary mt-2">Đồng ý và sửa</form:button>
		</form:form>
	</div>
</body>
<%-- <script type="text/javascript">
    CKEDITOR.replace('content');
    
</script>--%>
</html>