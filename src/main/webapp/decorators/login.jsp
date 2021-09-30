<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập hệ thống BlogIT</title>
<link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resource/img/light.ico"></c:url>"/>
<style>
.card0 {
    box-shadow: 0px 4px 8px 0px #757575;
    border-radius: 0px
}

.card2 {
    margin: 0px 40px
}

.logo {
    width: 200px;
    height: 100px;
    margin-top: 20px;
    margin-left: 35px
}

.image {
    width: 360px;
    height: 280px
}

.border-line {
    border-right: 1px solid #EEEEEE
}

.facebook {
    background-color: #3b5998;
    color: #fff;
    font-size: 18px;
    padding-top: 5px;
    border-radius: 50%;
    width: 35px;
    height: 35px;
    cursor: pointer
}

.twitter {
    background-color: #1DA1F2;
    color: #fff;
    font-size: 18px;
    padding-top: 5px;
    border-radius: 50%;
    width: 35px;
    height: 35px;
    cursor: pointer
}

.linkedin {
    background-color: #2867B2;
    color: #fff;
    font-size: 18px;
    padding-top: 5px;
    border-radius: 50%;
    width: 35px;
    height: 35px;
    cursor: pointer
}

.line {
    height: 1px;
    width: 45%;
    background-color: #E0E0E0;
    margin-top: 10px
}

.or {
    width: 10%;
    font-weight: bold
}

.text-sm {
    font-size: 14px !important
}

::placeholder {
    color: #BDBDBD;
    opacity: 1;
    font-weight: 300
}

:-ms-input-placeholder {
    color: #BDBDBD;
    font-weight: 300
}

::-ms-input-placeholder {
    color: #BDBDBD;
    font-weight: 300
}

input,
textarea {
    padding: 10px 12px 10px 12px;
    border: 1px solid lightgrey;
    border-radius: 2px;
    margin-bottom: 5px;
    margin-top: 2px;
    width: 100%;
    box-sizing: border-box;
    color: #2C3E50;
    font-size: 14px;
    letter-spacing: 1px
}

input:focus,
textarea:focus {
    -moz-box-shadow: none !important;
    -webkit-box-shadow: none !important;
    box-shadow: none !important;
    border: 1px solid #304FFE;
    outline-width: 0
}

button:focus {
    -moz-box-shadow: none !important;
    -webkit-box-shadow: none !important;
    box-shadow: none !important;
    outline-width: 0
}

a {
    color: inherit;
    cursor: pointer
}

.btn-blue {
    background-color: #1A237E;
    width: 150px;
    color: #fff;
    border-radius: 2px
}

.btn-blue:hover {
    background-color: #000;
    cursor: pointer
}

.bg-blue {
    color: #fff;
    background-color: #1A237E
}

@media screen and (max-width: 991px) {
    .logo {
        margin-left: 0px
    }

    .image {
        width: 300px;
        height: 220px
    }

    .border-line {
        border-right: none
    }

    .card2 {
        border-top: 1px solid #EEEEEE !important;
        margin: 0px 15px
    }
}</style>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/resource/admin/vendor/fontawesome-free/css/all.min.css"></c:url>" rel="stylesheet" type="text/css">
   
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/resource/admin/css/sb-admin-2.min.css"></c:url>" rel="stylesheet">
    
    <link href="<c:url value="/resource/vendor/datatables/dataTables.bootstrap4.min.css"></c:url>" rel="stylesheet">
    
</head>
<body>
	<decorator:body/>
</body>

    <script src="<c:url value="/resource/admin/vendor/jquery/jquery.min.js"></c:url>"></script>
    
    <script src="<c:url value="/resource/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></c:url>"></script>
    

    <!-- Core plugin JavaScript-->
    <script src="<c:url value="/resource/admin/vendor/jquery-easing/jquery.easing.min.js"></c:url>"></script>
    

    <!-- Custom scripts for all pages-->
    <script src="<c:url value="/resource/admin/js/sb-admin-2.min.js"></c:url>"></script>
    

    <!-- Page level plugins -->
    <script src="<c:url value="/resource/admin/vendor/chart.js/Chart.min.js"></c:url>"></script>
	
    <!-- Page level custom scripts -->
    <script src="<c:url value="/resource/admin/js/demo/chart-area-demo.js"></c:url>"></script>
    
    <script src="<c:url value="/resource/admin/js/demo/chart-pie-demo.js"></c:url>"></script>
    
    
    <!-- Page level plugins -->
    <script src="<c:url value="/resource/admin/vendor/datatables/jquery.dataTables.min.js"></c:url>"></script>
    
    <script src="<c:url value="/resource/admin/vendor/datatables/dataTables.bootstrap4.min.js"></c:url>"></script>
	
    <!-- Page level custom scripts -->
    <script src="<c:url value="/resource/admin/js/demo/datatables-demo.js"></c:url>"></script>
</html>