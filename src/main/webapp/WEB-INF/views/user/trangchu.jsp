<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
</head>
<body>
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

					<c:forEach items="${listCat}" var="cat">
						<li class="listbody__item"><a
							href="list?id=${cat.id}&limit=1" class="listbody__item-link">
								<div id="img-cat">${cat.img}</div> <span id="name_cat">${cat.name}</span>
						</a></li>
					</c:forEach>
					<br />
				</ul>
				<p id="tag_first">#Tag phổ biến</p>
				<ul class="body__menu-listbody">
					<li class="listbody__item"></li>
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

							<c:forEach items="${listCat}" var="cat">
								<li class="listbody__menu"><a
									href="list?id=${cat.id}&limit=1" class="listbody_menu_link">
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
			<section class="col-md-8 col-lg-6" id="post_here">
				<nav class="navbar navbar-expand-sm section__header">
					<h3>Bài đăng</h3>
					<div class="navbar-nav ml-auto">
						<div class="section__header-btn"></div>
					</div>
				</nav>

				<c:forEach items="${listPostWithLimit}" var="adminDTO">
					<div class="section__article mt-3">
						<div class="section__article-img" id="img_post">
							<a href="detail?id=${adminDTO.id}"><div style="width: 100%">${adminDTO.img}</div></a>
						</div>
						<div class="section__article-txtarticle row mt-3">
							<div class="txtarticle__title col-sm-12">
								<a href="detail?id=${adminDTO.id}">
									<h4 id="h4_text">${adminDTO.title}</h4>
								</a>
							</div>
							<div class="txtarticle__language mt-2">
								<span id="date_post">${adminDTO.date}</span> <span
									id="author_post">${adminDTO.author}</span>
							</div>
							<div class="txtarticle__comment">
								<div class="txtarticle__comment-icon">
									<a href=""> <span><i class="fa fa-comment-o"
											aria-hidden="true"></i></i></span> <span>
											${adminDTO.soLuongBinhLuan} Bình luận</span>
									</a>
								</div>
							</div>

						</div>
					</div>
				</c:forEach>
			</section>
			<script>
				$(window).scroll(function() {
				    if($(window).scrollTop() == $(document).height() - $(window).height()) {
				    	
				    	var getUrlParameter = function getUrlParameter(sParam) {
				    	    var sPageURL = window.location.search.substring(1),
				    	        sURLVariables = sPageURL.split('?'),
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
				    	var max = document.getElementById("maxpost").innerText;
				    	var record_per_page = 16;
				    	var numberpage = Math.ceil(max/record_per_page);
				    	if(limit1==numberpage){
				    		var limit = limit1;
				    	}else if(limit1>numberpage){
				    		alert("Đừng làm thế");
				    	}else{
				    		var limit = parseInt(limit1 + 1);
				    	}
				           $.ajax({
				        	   type:'GET',
				        	   url: '${pageContext.request.contextPath}/customer/indexload',
				        	   data: { 
				        		    limit: limit
				        		  },
				        	   success: function(result){
				        		  // $('#poss').empty();
				        		   $('#post_here').html(result);
				        				history.pushState({}, null, "${pageContext.request.contextPath}/customer/index?limit="+limit+"");
				        		   
				        	   }
				           })
				    }
				});	
				</script>
			<aside class="col-lg-3 aside">
				<div class="body__aside">
					<div class="body__aside-txtaside">
						<div class="txtaside__title">
							<h6>#Bài viết mới nhất</h6>
						</div>
						<ul class="txtaside__list">
							<c:forEach items="${listPostNewest}" var="newest">
								<li class="txtaside__list-itemaside"><a
									href="detail?id=${newest.id}" class="itemaside__link">
										${newest.title}<span id="new_badge"
										class="badge badge-secondary"> New</span>
								</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="txtaside__title">
					<h6>#Tag</h6>
				</div>
				<section>
					<span id="maxpost" style="display: none">${max}</span>
					<nav class="navbar navbar-expand-sm section__header">
						<div class="navbar-nav ml-auto">
							<div class="section__header-btn">
								<c:forEach items="${listHashtag}" var="hashtag">
									<span id="tag"> <a
										class="nav-link listsection__item-link"
										href="list?tag=${hashtag.id}&limit=1">${hashtag.name}</a>
									</span>
								</c:forEach>
							</div>
						</div>
					</nav>
				</section>
				<br />
				<div class="body__aside">
					<div class="body__aside-txtaside">
						<div class="txtaside__title">
							<h6>#Bài viết bất kỳ</h6>
						</div>
						<ul class="txtaside__list">
							<c:forEach items="${listPostRandom}" var="random">
								<li class="txtaside__list-itemaside"><a
									href="detail?id=${random.id}" class="itemaside__link">${random.title}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<br />
				<div class="body__aside">
					<div class="body__aside-txtaside">
						<div class="txtaside__title">
							<h6>#Tương tác nhiều nhất</h6>
						</div>
						<ul class="txtaside__list">
							<c:forEach items="${listBestReact}" var="react">
								<li class="txtaside__list-itemaside"><a
									href="detail?id=${react.id}" class="itemaside__link"> <span
										id="title_post_react">${react.title}</span><span
										id="best_badge" class="badge badge-danger">best</span>
										<p id="number_comment">${react.soLuongBinhLuan}Bình luận</p>
								</a></li>

							</c:forEach>
						</ul>
					</div>
				</div>
				<br />
				<div class="body__aside">
					<div class="body__aside-txtaside">
						<div class="txtaside__title">
							<h6>#Bài viết cũ nhất</h6>
						</div>
						<ul class="txtaside__list">
							<c:forEach items="${listPostOldest}" var="old">
								<li class="txtaside__list-itemaside"><a
									href="detail?id=${old.id}" class="itemaside__link">${old.title}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</aside>
		</div>
	</div>
	<script>
window.onload = function()
{
	 newPageTitle = "BlogIT";
     document.title = newPageTitle;
};
</script>
</body>
</html>