<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="contentType" content="text/html" charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<div class="container-fluid">
			<a href="add">
				<button class="btn btn-primary" type="button">Thêm mới</button>
			</a>
			<p></p>
		<!-- Page Heading -->
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Danh sách Tag theo bài đăng
				</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Mã</th>
								<th>Bài đăng</th>
								<th>Tag</th>
								<th>Lựa chọn</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listPosthash}" var="postDTO">
								<tr>
									<td>${postDTO.id}</td>
									<td>${postDTO.post_title}</td>
									<td>${postDTO.hashtag_name}</td>
									<td><a href="edit?id=${postDTO.id}">Sửa</a> <a
										href="delete?id=${postDTO.id}">Xóa</a></td>
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