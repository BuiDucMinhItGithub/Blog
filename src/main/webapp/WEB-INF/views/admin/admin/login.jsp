<%@ include file="/template/taglib.jsp"%>
<html>
<head>
<title>login</title>
</head>
<body>
	
	<div class="container">
	<br/>
    <div class="card card0 border-0">
        <div class="row d-flex">
            <div class="col-lg-6">
                <div class="card1 pb-5">
                	<br/>
                	<br/>
                    <div class="row px-3 justify-content-center mt-4 mb-5 border-line"> <img src="https://i.imgur.com/uNGdWHi.png" class="image"> </div>
                </div>
            </div>
            <div class="col-lg-6">
            <c:url value="/loginProcess" var="url"></c:url>
			<form name='loginForm' action="${url}" method="POST">
                <div class="card2 card border-0 px-4 py-5">
                    <div class="row px-3"> <label class="mb-1">
                    <c:choose>
					  <c:when test="${not empty message}">
					    <h2>${message}</h2>
					  </c:when>
					  <c:otherwise>
					   <h4>Bạn không có quyền truy cập trang, vui lòng đăng nhập</h4>
					  </c:otherwise>
					</c:choose>
                    
                    
                            <h6 class="mb-0 text-sm">Tên đăng nhập</h6>
                        </label> <input class="mb-4" name="username" type="text" placeholder="Nhập tên đăng nhập"> </div>
                    <div class="row px-3"> <label class="mb-1">
                            <h6 class="mb-0 text-sm">Mật khẩu</h6>
                        </label> <input name="password" type="password" placeholder="Nhập mật khẩu"> </div>
                    <button  name="submit" type="submit" class="btn btn-primary mt-2">Đăng nhập</button>
                </div>
                </form>
            </div>
        </div>
       
    </div>
</div>
	
</body>
</html>