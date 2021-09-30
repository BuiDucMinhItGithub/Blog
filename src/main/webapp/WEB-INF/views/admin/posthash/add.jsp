<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Thêm mới</title>

</head>
<body>
	<div class="container">
		<c:url value="add" var="url"></c:url>
		<form:form action="${url}" method="POST" modelAttribute="posthash">
			<div class="form-group">
				<label for="id_post">Bài đăng</label> <br> 
				<form:select name="id_hashtag" path="id_post"  class="form-control">
					<option value="">Chọn post</option>
				    <c:forEach items="${listPost}" var="role">
				    	
				        <option value="${role.id}"  ${role.title == selectedRole ? 'selected' : ''}>${role.title}</option>
				    </c:forEach>
				</form:select>
			</div>
	
			<div class="row">
			<c:forEach items="${listHashtag}" var="role">
				<div class="col-3">
					<input type="checkbox" id="id_hashtag" name="id_hashtag" value="${role.id}">
					<label for="${role.id}">${role.name}</label><br>
		 		</div>
			</c:forEach>
			</div>
			<form:button  name="add" type="submit" class="btn btn-primary mt-2">Thêm mới</form:button>
		</form:form>
		
	</div>
</body>
</html>