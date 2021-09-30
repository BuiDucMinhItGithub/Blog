<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <script src="<c:url value="/resource/user/jquery/jquery-3.5.1.min.js"></c:url>"></script>
    <script src="<c:url value="/resource/user/bootstrap/js/bootstrap.min.js"></c:url>"></script>
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resource/img/light.ico"></c:url>"/>
    <link rel="stylesheet" href="<c:url value="/resource/user/bootstrap/css/bootstrap.min.css"></c:url>">
    <link rel="stylesheet" href="<c:url value="/resource/user/css/index.css"></c:url>">
    <link rel="stylesheet" href="<c:url value="/resource/user/font-awesome/css/font-awesome.min.css"></c:url>">
    
    <script src="<c:url value="/resource/user/js/index.js"></c:url>"></script>
    <script src="<c:url value="/resource/user/jquery/jquery_321/jquery-3.2.1.min.js"></c:url>"></script>
</head>
<body>
	<%@ include file="/template/user/header.jsp"%>
    <%--menu --%>
    
    <decorator:body/>
    
    <%--footer --%>
	<%@ include file="/template/user/footer.jsp" %>
	


</body>
</html>