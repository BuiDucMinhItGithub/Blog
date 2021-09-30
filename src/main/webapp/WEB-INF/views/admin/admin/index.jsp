<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<head>
<meta http-equiv="contentType" content="text/html" charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<div class="container-fluid">
<%-- 	<c:if test="${pageContext.request.userPrincipal.name == 'long'}">
  
     | &nbsp;
     <a href="${pageContext.request.contextPath}/logout">Logout</a>
     
  </c:if> --%>
			<a href="add"><button class="btn btn-primary" type="button">Thêm mới</button></a>
		<!-- Page Heading -->
		<p class="mb-4">
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Danh sách admin</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Mã</th>
								<th>Tên</th>
								<th>Mật khẩu</th>
								<th>Trạng thái</th>
								<th>Quyền</th>
								<th>Tùy chọn</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listUser}" var="adminDTO">
							<tr>
								<td>${adminDTO.id}</td>
								<td>${adminDTO.name}</td>
								<td>${adminDTO.password}</td>
								<c:choose>
								  <c:when test="${adminDTO.state ==1}">
								    <td>Hoạt động</td>
								  </c:when>
								  <c:when test="${adminDTO.state !=1}">
								    <td>Không hoạt động</td>
								  </c:when>
								</c:choose>
								<td>${adminDTO.role}</td>
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