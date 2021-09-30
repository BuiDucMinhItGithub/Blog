<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Sửa</title>
</head>
<body>
	<div class="container">
		<h4>Sửa category</h4>
		<c:url value="category-edit" var="url"></c:url>
		<form:form action="${url}" method="POST" modelAttribute="category">
			<div class="form-group">
				<label for="id">Mã</label> <br> 
				<form:input class="form-control" path="id" id="id" value="${category.id}" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="name">Tiêu đề</label> <br> 
				<form:input class="form-control" path="name" id="name" value="${category.name}"/>
			</div>
			<div class="form-group">
				<label for="categoryimg">Ảnh bìa</label> <br> 
				<form:textarea path="img" rows="50" id="categoryimg" value="${post.img}"/>
			</div>
			<form:button  name="add" type="submit" class="btn btn-primary mt-2">Đồng ý</form:button>
		</form:form>
	</div>
</body>
</html>