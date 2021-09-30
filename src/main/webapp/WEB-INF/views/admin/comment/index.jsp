<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="contentType" content="text/html" charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<div class="container-fluid">
		
		<!-- Page Heading -->
		<p class="mb-4">
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Danh sách bình luận</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Mã</th>
								<th>Tên người viết</th>
								<th>Bài viết</th>
								<th>Nội dung</th>
								<th>Ngày</th>
								<th>Email</th>
								<th>Lựa chọn</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listComment}" var="comment">
								<tr>
									<td>${comment.id}</td>
									<td>${comment.name}</td>
									<td>${comment.name_post}</td>
									<td>${comment.content}</td>
									<td>${comment.date}</td>
									<td>${comment.email}</td>
									<td> <a href="delete?id=${comment.id}">Xóa</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>

</body>
</html>