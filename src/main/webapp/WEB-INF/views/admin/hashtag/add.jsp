<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
</head>
<body>
	<div class="container">
		<h4>Thêm Tag</h4>
		<c:url value="add" var="url"></c:url>
		<form:form action="${url}" method="POST" modelAttribute="hashtag">
			<div class="form-group">
				<label for="id">Mã </label> <br>
				<form:input class="form-control" path="id" />
			</div>
			<div class="form-group">
				<label for="name">Tên</label> <br>
				<form:input class="form-control" path="name" />
			</div>
			<form:button name="add" type="submit" class="btn btn-primary mt-2">Thêm tag</form:button>
		</form:form>
	</div>
</body>
</html>