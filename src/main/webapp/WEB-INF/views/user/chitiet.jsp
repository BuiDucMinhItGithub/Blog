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
			<div class="txtaside__title">
				<h6>Tag</h6>
			</div>
			<section>
				<nav class="navbar navbar-expand-sm section__header">
					<div class="navbar-nav ml-auto">
						<div class="section__header-btn">
							<c:forEach items="${listHashtag}" var="hashtag">
								<span id="tag"> <a style="font-size: 11px"
									class="nav-link listsection__item-link"
									href="list?tag=${hashtag.id}&limit=1">${hashtag.name}</a>
								</span>
							</c:forEach>
						</div>
					</div>
				</nav>
			</section>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="body row mt-4">
			<nav class="col-md-4 col-lg-3 body_nav">
				<div class="body__nav body__nav-pagey">
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
			<section class="col-md-8 col-lg-6">
				<div class="section__article">
					<div class="section__article-img-detail">
						<div>${post.img}</div>
					</div>
					<div
						class="section__article-txtarticle row mt-3 section__article-detail">
						<div class="txtarticle__title-datail col-sm-12">
							<span id="post_name">${post.title}</span>
						</div>
						<br />
						<section style="padding-left: 10px; margin-top: 30px;">
							<nav class="navbar navbar-expand-sm section__header">
								<div class="navbar-nav ml-auto">
									<div class="section__header-btn">
										<c:forEach items="${hashtag}" var="hashtag">
											<span id="tag"> <a style="font-size: 11px"
												class="nav-link listsection__item-link"
												href="list?tag=${hashtag.id}&limit=1">${hashtag.name}</a>
											</span>
										</c:forEach>
									</div>
								</div>
							</nav>
						</section>
						<div class="txtarticle__text mt-4 col-sm-12">

							<hr>
							<p>${post.content}</p>
						</div>
					</div>
					<div class="txtarticle__text-link col-sm-12">
						<h6>Nguồn thông tin</h6>
						<span>${post.author}</span>
					</div>
					<div class="txtarticle__text-link col-sm-12" id="commentPlace">
						<h5>Bình luận</h5>
						<div class="row" id="comment_place">
							<c:forEach items="${listComment}" var="comment">
								<div class="col-md-12">
									<div class="media g-mb-30 media-comment">
										<div class="media-body u-shadow-v18 g-bg-secondary g-pa-30">
											<div class="g-mb-15">
												<h6 class="h6 g-color-gray-dark-v1 mb-0">${comment.name}</h6>
												<span class="g-color-gray-dark-v4 g-font-size-12">${comment.date}</span>
											</div>
											<p>${comment.content}</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="txtarticle__text-form col-sm-12">
						<p>Thông tin của bạn sẽ được bảo mật</p>
						<textarea name="content" cols="20" rows="5" id="content"
							class="form-control" placeholder="Bình luận "></textarea>
						<input type="text" placeholder="Email của bạn" name="email"
							id="email" class="form-control mt-4"> <input type="text"
							id="name" placeholder="Tên hiển thị" name="name"
							class="form-control mt-4"> <input type="text" id="id"
							placeholder="Tên hiển thị, hãy chọn tên của riêng bạn" name="id"
							class="" value="${post.id }" style="display: none"> <input
							type="text" name="id_post" id="id_post" class="form-control mt-4"
							value="${post.id }" style="display: none">
						<button type="submit" id="btn_submit" class="btn btn-primary mt-4"
							onclick="myFunction()">Gửi</button>
						<script>
							window.onload = function() {
								var name = document.getElementById("post_name").innerHTML;
								newPageTitle = name;
								document.title = newPageTitle;
							};

							function myFunction() {
								var regex = "^[a-z][a-z0-9_\.]{5,32}@[a-z0-9]{2,}(\.[a-z0-9]{2,4}){1,2}$";
								var email = document.getElementById('email').value;
								var name = document.getElementById('name').value;
								var id_post = document
										.getElementById('id_post').value;
								var content = document
										.getElementById('content').value;
								var id = document.getElementById('id').value;
								if (email.match(regex)) {
									$
											.ajax({
												type : "GET",
												url : "${pageContext.request.contextPath}/customer/comment",
												data : {
													id : id,
													content : content,
													id_post : id_post,
													email : email,
													name : name,
												},
												success : function(response) {
													$('#comment_place').html(
															response);
												}
											});
									document.getElementById('email').value = '';
									document.getElementById('content').value = '';
									document.getElementById('name').value = '';
									document.getElementById('id').value = '';
								} else {
									alert("Email không hợp lệ");
								}

							}
						</script>

					</div>
				</div>
				<div class="txtarticle__text-addjs mt-4"></div>
			</section>
			<aside class="col-lg-3 col-md-8 aside">
				<div class="body__aside">
					<div class="body__aside-txtaside">
						<div class="txtaside__title">
							<h6>#Bài viết liên quan</h6>
						</div>
						<ul class="txtaside__list">
							<c:forEach items="${listPostRelated}" var="related">
								<li class="txtaside__list-itemaside"><a
									href="detail?id=${related.id}" class="itemaside__link">${related.title}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="txtaside__title">
					<h6>#Tag</h6>
				</div>
				<section>
					<nav class="navbar navbar-expand-sm section__header">
						<div class="navbar-nav ml-auto">
							<div class="section__header-btn">
								<c:forEach items="${listHashtag}" var="hashtag">
									<span id="tag"> <a style="font-size: 11px"
										class="nav-link listsection__item-link"
										href="list?tag=${hashtag.id}&limit=1">${hashtag.name}</a>
									</span>
								</c:forEach>
							</div>
						</div>
					</nav>
				</section>
				<br>
				<div class="body__aside">
					<div class="body__aside-txtaside">
						<div class="txtaside__title">
							<h6>#Bài viết ngẫu nhiên</h6>
						</div>
						<ul class="txtaside__list">
							<c:forEach items="${listPostRandom}" var="random">
								<li class="txtaside__list-itemaside"><a
									href="detail?id=${random.id}" class="itemaside__link">${random.title}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>

			</aside>
		</div>
	</div>
</body>


</html>