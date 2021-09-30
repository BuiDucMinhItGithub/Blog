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
		<h4>Sửa bài đăng</h4>
		<c:url value="post-edit" var="url"></c:url>
		<form:form action="${url}" method="POST" modelAttribute="post">
			<div class="form-group">
				<label for="id">Mã bài đăng</label> <br> 
				<form:input class="form-control" path="id" id="id" value="${post.id}" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="name">Tiêu đề</label> <br> 
				<form:input class="form-control" path="title" id="title" value="${post.title}"/>
			</div>
			<div class="form-group">
				<label for="password">Nội dung</label> <br>
				<form:textarea class="form-control" path="content" id="contentpost" value="${post.content}"/>
			</div>
			<div class="form-group">
				<label for="state">Tác giả</label> <br> 
				<form:input class="form-control" path="author" id="author" value="${post.author}"/>
			</div>
			<div class="form-group">
			<label for="id_category">Tag</label> <br> 
				<form:select name="id_category" path="id_category"  class="form-control">
					<option value="${category.id}">${category.name}</option>
				    <c:forEach items="${listCategory}" var="category">
				    	
				        <option value="${category.id}"  ${category.id == selectedRole ? 'selected' : ''}>${category.name}</option>
				    </c:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<label for="state">Ảnh bìa</label> <br> 
				<form:textarea path="img" rows="50" id="postimg" value="${post.img}"/>
			</div>
			<form:button  name="add" type="submit" class="btn btn-primary mt-2">Thêm</form:button>
		</form:form>
	</div>
</body>

</html>