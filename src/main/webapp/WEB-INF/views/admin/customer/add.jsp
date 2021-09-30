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
<title>Thêm mới customer</title>
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
		<h4>Thêm customer</h4>
		<c:url value="add" var="url"></c:url>
		<form:form action="${url}" method="POST" modelAttribute="customer">
			
			<div class="form-group">
				<label for="name">Tên</label> <br> 
				<form:input class="form-control" path="name"/>
			</div>
			<div class="form-group">
				<label for="name">Tên</label> <br> 
				<form:input class="form-control" path="state"/>
			</div>
			<form:button  name="add" type="submit" class="btn btn-primary mt-2">Thêm</form:button>
		</form:form>
	</div>
</body>
<%-- <script type="text/javascript">
    CKEDITOR.replace('content');
    
</script>--%>
</html>