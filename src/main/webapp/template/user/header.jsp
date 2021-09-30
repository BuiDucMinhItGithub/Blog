
<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
</head>
<body>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                
            </div>
        </div>
    </div>
    <header>
        <div class="container-fluid  pd__container-fluid">
            <nav class="navbar navbar-expand-md header_navbar">
                <button class="header__body-logobtn">
                    <span class="navbar-toggler-icon logobtn__icon"></span>
                    <span class="navbar-toggler-icon logobtn__icon"></span>
                    <span class="navbar-toggler-icon logobtn__icon"></span>
                </button>
                <div class="search_flex">
                    <a class="navbar-brand header__logo text-body"  href="${pageContext.request.contextPath}/customer/index?limit=1">
                        <svg xmlns="http://www.w3.org/2000/svg" version="1.0" width="50pt" height="30pt"
                            viewBox="0 0 500.000000 300.000000" preserveAspectRatio="xMidYMid meet">

                            <g transform="translate(0.000000,300.000000) scale(0.100000,-0.100000)" fill="#000000"
                                stroke="none">
                                <path
                                    d="M0 1500 l0 -1500 2500 0 2500 0 0 1500 0 1500 -2500 0 -2500 0 0 -1500z m1480 -50 l0 -480 263 -2 262 -3 3 -62 3 -63 -341 0 -340 0 0 545 0 545 75 0 75 0 0 -480z m1250 420 l0 -60 -195 0 -195 0 0 -485 0 -485 -75 0 -75 0 0 485 0 485 -195 0 -195 0 0 60 0 60 465 0 465 0 0 -60z m335 -397 c93 -249 173 -449 176 -445 4 4 82 208 175 455 l168 447 77 0 77 0 -79 -207 c-43 -115 -137 -359 -207 -543 l-128 -335 -84 -3 -85 -3 -202 528 c-111 290 -205 536 -209 546 -6 16 0 18 72 15 l78 -3 171 -452z" />
                            </g>
                        </svg>
                    </a> 
                    <c:url value="list" var="url"></c:url>
                    <form class="form-inline header__search-xl" action="${url}" method="POST" id="myForm">
                        <input class="form-control mr-sm-2 search" name="key" type="text" id="key" placeholder="Tìm kiếm bài viết"/>
                   		<i class="fa fa-search icon-search" id="icon_search"></i>
                       
                    </form>
                    <script>
                    $('#myForm').on('submit',function(e){
                    	  e.preventDefault();
                    	  var formData=$(this).serialize();
                    	  var fullUrl = "${pageContext.request.contextPath}/customer/list";
                    	  var limit = 1;
                    	  var finalUrl = fullUrl+"?"+formData+"&"+"limit="+limit;
                    	  window.location.href = finalUrl;
                    	});
                    </script>
                    
                   
		
                </div>
                <i class="navbar-toggler header__log-search fa fa-search" type="button" data-toggle="collapse"
                    data-target="#collapsibleNavbar"></i>
                <div class="header__log">
                
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                       <c:url value="list" var="url"></c:url>
                                <form class="form-inline header__search" action="${url}" method="POST" id="myForm2">
                                    <input class="form-control mr-sm-2 search" name="key" type="text" id="key" placeholder="Tìm kiếm bài viết">
                                </form><div style="height: auto;" >
                    <a class="body__menu-icon" href="#!" role="button"><i class="fa fa-facebook-f"></i></a>
                    <a class="body__menu-icon" href="#!" role="button"><i class="fa fa-twitter"></i></a>
                    <a class="body__menu-icon" href="#!" role="button"><i class="fa fa-google"></i></a>
                    <a class="body__menu-icon" href="#!" role="button"><i class="fa fa-instagram"></i></a>
                    <a class="body__menu-icon" href="#!" role="button"><i class="fa fa-linkedin"></i></a>
                    <a class="body__menu-icon" href="#!" role="button"><i class="fa fa-github"></i></a>
                    <a class="body__menu-icon" href="#!" role="button"><i class="fa fa-pinterest-p"></i></a>
                    <a class="body__menu-icon" href="#!" role="button"><i class="fa fa-skype"></i></a>
                </div>
                            </li>
                           <script>
                    $('#myForm2').on('submit',function(e){
                    	  e.preventDefault();
                    	  var formData=$(this).serialize();
                    	  var fullUrl = "${pageContext.request.contextPath}/customer/list";
                    	  var limit = 1;
                    	  var finalUrl = fullUrl+"?"+formData+"&"+"limit="+limit;
                    	  window.location.href = finalUrl;
                    	});
                    </script>
                    </div>
                </div>

            </nav>
            
        </div>
    </header>
    </body>
    </html>
    