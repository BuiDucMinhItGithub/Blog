<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<%--ckediter --%>
<script src="<c:url value="/resource/admin/ckeditor/ckeditor.js"></c:url>"></script>
</head>
<body>
	<div class="container">
		<h4>Thêm bài đăng</h4>
		<c:url value="add" var="url"></c:url>
		<form:form action="${url}" method="POST" modelAttribute="post">
			<div class="form-group">
				<label for="id">Mã bài đăng</label> <br> 
				<form:input class="form-control" path="id" id="id"/>
			</div>
			<div class="form-group">
				<label for="name">Tiêu đề</label> <br> 
				<form:input class="form-control" path="title" id="title"/>
			</div>
			<div class="form-group">
				<label for="password">Nội dung</label> <br>
				<form:textarea class="form-control" path="content" id="contentpost"/>
			</div>
			<div class="form-group">
				<label for="state">Tác giả</label> <br> 
				<form:input class="form-control" path="author" id="author"/>
			</div>
			<div class="form-group" style="display:none">
				<label for="state">Ngày đăng</label> <br> 
				<form:input class="form-control" path="date" id="sate" value="01/01/2021" />
			</div>
			<div class="form-group">
				<label for="id_post">Tag</label> <br> 
				<form:select name="id_category" path="id_category"  class="form-control">
					<option value="">Thể loại</option>
				    <c:forEach items="${listCategory}" var="category">			    	
				        <option value="${category.id}">${category.name}</option>
				    </c:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<label for="img">Ảnh bìa</label> <br> 
				<form:textarea path="img" id="postimg" value="${post.img}"/>
			</div>
			<form:button  name="add" type="submit" class="btn btn-primary mt-2">Thêm bài</form:button>
		</form:form>
	</div>
</body>

</html>