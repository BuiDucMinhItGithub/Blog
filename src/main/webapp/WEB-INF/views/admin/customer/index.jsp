<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<head>
<meta http-equiv="contentType" content="text/html" charset="UTF-8">
<title>Quản lý Customer</title>
</head>
<body>
	<div class="container-fluid">
			<a href="add"><button class="btn btn-primary" type="button">Thêm mới</button></a>
		<!-- Page Heading -->
		<p class="mb-4">
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Danh sách customer</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Mã</th>
								<th>Tên</th>
								<th>Tùy chọn</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listCus}" var="adminDTO">
							<tr>
								<td>${adminDTO.id}</td>
								<td>${adminDTO.name}</td>
								<td>
									<a href="edit?id=${adminDTO.id}">Sửa</a>
									<a href="delete?id=${adminDTO.id}">Xóa</a>
								</td>
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