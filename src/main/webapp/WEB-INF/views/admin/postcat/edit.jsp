<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Sửa</title>

</head>
<body>
	<div class="container">
		<h4>Thêm posthash</h4>
		<c:url value="postcat-edit" var="url"></c:url>
		<form:form action="${url}" method="POST" modelAttribute="postcat">
			<div class="form-group">
				<label for="id">Mã </label> <br>
				<form:input class="form-control" path="id" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="id_post">Bài đăng</label> <br>
				<form:select name="id_post" path="id_post" class="form-control">
					<option value="${post.id}">${post.title}</option>
					<c:forEach items="${listPost}" var="role">

						<option value="${role.id}"
							${role.title == selectedRole ? 'selected' : ''}>${role.title}</option>
					</c:forEach>
				</form:select>
			</div>

			<div class="form-group">
				<label for="id_category">Bài đăng</label> <br>
				<form:select name="id_category" path="id_category"
					class="form-control">
					<option value="${category.id}">${category.name}</option>
					<c:forEach items="${listCategory}" var="role">

						<option value="${role.id}"
							${role.id == selectedRole ? 'selected' : ''}>${role.name}</option>
					</c:forEach>
				</form:select>
			</div>
			<form:button name="add" type="submit" class="btn btn-primary mt-2">Thêm posthash</form:button>
		</form:form>
	</div>
</body>
</html>