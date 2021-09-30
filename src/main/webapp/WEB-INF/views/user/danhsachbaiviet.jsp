<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
</head>

<body>
	<script>
window.onload = function()
{
	 newPageTitle = 'Danh sách bài viết';
     document.title = newPageTitle;
     
     
};
</script>
	<nav class="body_nav-media">
		<div class="head__title">
			<h5>DEV Community</h5>
			<button class="return">X</button>
		</div>
		<div class="body__nav">
			<div class="body__nav-txtbody body__nav-txtbody1">
				<div class="txtbody__title">
					<h6>Cập nhật thông tin dành cho sinh viên, lập trình viên
						chuyên ngành CNTT, hiểu rõ ngành nghề, nhận biết tương lai và cải
						thiện bản thân</h6>
				</div>
				<div>
					<p>Thông tin được cập nhật liên tục, đảm bảo chính xác và có
						giá trị</p>
				</div>
			</div>
			<div class="body__menu">
				<ul class="body__menu-listbody">
					<c:forEach items="${listCategory}" var="cat">
						<li class="listbody__item"><a
							href="list?id=${cat.id}&limit=1" class="listbody__item-link">
								<div id="img-cat">${cat.img}</div> <span id="name_cat">${cat.name}</span>
						</a></li>
					</c:forEach>
					<br />
				</ul>
				<p id="tag_first">#Tag phổ biến</p>
				<ul class="body__menu-listbody">

					<c:forEach items="${listBestHashtag}" var="tagbest">
						<li class="listbody__menu"><a
							href="list?tag=${tagbest.id}&limit=1" class="listbody_menu_link">
								<span id="name_tag">#${tagbest.name}</span>
						</a></li>
					</c:forEach>
					<br />
				</ul>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="body row mt-4">
			<nav class="col-md-4 col-lg-3 body_nav">
				<div class="body__nav">
					<div class="body__nav-txtbody">
						<div class="txtbody__title">
							<h6>Cập nhật thông tin dành cho sinh viên, lập trình viên
								chuyên ngành CNTT, hiểu rõ ngành nghề, nhận biết tương lai và
								cải thiện bản thân</h6>
						</div>
						<div>
							<p>Thông tin được cập nhật liên tục, đảm bảo chính xác và có
								giá trị</p>
						</div>
					</div>
					<div class="body__menu">
						<ul class="body__menu-listbody">
							<c:forEach items="${listCategory}" var="cat">
								<li class="listbody__item"><a
									href="list?id=${cat.id}&limit=1" class="listbody__item-link">
										<div id="img-cat">${cat.img}</div> <span id="name_cat">${cat.name}</span>
								</a></li>
							</c:forEach>
							<br />
						</ul>
						<p id="tag_first">#Tag phổ biến</p>
						<ul class="body__menu-listbody">

							<c:forEach items="${listBestHashtag}" var="tagbest">
								<li class="listbody__menu"><a
									href="list?tag=${tagbest.id}&limit=1"
									class="listbody_menu_link"> <span id="name_tag">#${tagbest.name}</span>
								</a></li>
							</c:forEach>
							<br />
						</ul>
					</div>
				</div>
			</nav>

			<section class="col-md-6 col-lg-9" id="here">
				<span id="max" style="display: none">${max}</span>
				<div class="row" id="poss">
					<c:forEach items="${listPost}" var="post">
						<div class="col-lg-6 pd__listing-section" id="posthere">
							<div class="section__article section__article-listing">
								<div class="section__article-img-list" id="imgposthere">
									<a href="detail?id=${post.id}">
										<div style="width: 100%">${post.img}</div>
									</a>
								</div>
								<div class="section__article-txtarticle">
									<div class="txtarticle__title col-sm-12 mt-3">
										<a href="detail?id=${post.id}">
											<h4 id="h4_text">${post.title}</h4>
										</a>
									</div>
									<div class="txtarticle__language mt-2">
										<span id="date_post">${post.date}</span> <span
											id="author_post">${post.author}</span>
									</div>
									<div class="txtarticle__comment">
										<div class="txtarticle__comment-icon">
											<a href=""> <span><i class="fa fa-comment-o"
													aria-hidden="true"></i></i></span> <span>
													${post.soLuongBinhLuan} Bình luận</span>
											</a>
										</div>
									</div>

								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>
			<script>
				$(window).scroll(function() {
				    if($(window).scrollTop() == $(document).height() - $(window).height()) {			    	
				    	var getUrlParameter = function getUrlParameter(sParam) {
				    	    var sPageURL = window.location.search.substring(1),
				    	        sURLVariables = sPageURL.split('&'),
				    	        sParameterName,
				    	        i;
				
				    	    for (i = 0; i < sURLVariables.length; i++) {
				    	        sParameterName = sURLVariables[i].split('=');
								//alert(sParameterName);
				    	        if (sParameterName[0] === sParam) {
				    	            return typeof sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
				    	        }
				    	    }
				    	    return false;
				    	};
				    	var limit1 = parseInt(getUrlParameter('limit'));
				    	var id = getUrlParameter('id');
				    	var key = getUrlParameter('key');
				    	var tag = getUrlParameter('tag');
				    	var max = document.getElementById("max").innerText;
				    	var record_per_page = 8;
				    	var numberpage = Math.ceil(max/record_per_page);
				    	if(limit1==numberpage){
				    		var limit = limit1;
				    	}else if(limit1>numberpage){
				    		
				    	}else{
				    		var limit = parseInt(limit1 + 1);
				    	}

				           $.ajax({
				        	   type:'GET',
				        	   url: '${pageContext.request.contextPath}/customer/listload',
				        	   data: { 
				        		    limit: limit,
				        		    id : id,
				        		    tag : tag,
				        		    key : key,
				        		  },
				        	   success: function(result){
				        		  // $('#poss').empty();
				        		   $('#poss').html(result);
				        		   if(id != false){
				        				history.pushState({}, null, "${pageContext.request.contextPath}/customer/list?id="+id+"&limit="+limit+"");
				        		   }
				        		   if(tag != false){
				        			    history.pushState({}, null, "${pageContext.request.contextPath}/customer/list?tag="+tag+"&limit="+limit+"");
				        		   }
				        		   if(key != false){
				        			   history.pushState({}, null, "${pageContext.request.contextPath}/customer/list?key="+key+"&limit="+limit+"");
				        		   }
				        	   }
				           })
				    }
				});	
				</script>

		</div>
	</div>
</body>

</html>