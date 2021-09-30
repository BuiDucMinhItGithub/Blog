<%@ include file="/template/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

</head>
<body>
	<script>
window.onload = function() {
	var dps = new Array();
	var xValue;
	var yValue;
	var chart = new CanvasJS.Chart("chartContainer", {
		theme: "light1", // "light1", "dark1", "dark2"
		animationEnabled: true,
		title: {
			text: "Số lượng bài đăng theo tháng"
		},
		axisX: {
			xValueType: "Integer",
			includeZero: true,
			valueFormatString: xValue
		},
		axisY: {
			title: "Số lượng",
			includeZero: true,
			suffix: " Bài"
		},
		data: [{
			type: "line",
			xValueType: "Integer",
			yValueFormatString: "#,##0 bài viết",
			dataPoints: dps
		}]
	});

	var tempData = new Array();
	<c:forEach items="${postChart}" var="dataPoints" varStatus="loop">	
		xValue = ${dataPoints.month};
		yValue = ${dataPoints.amount};
		for ( var index=0; index<=${loop.index}; index++ ) {
		        dps.push({
		        	x : xValue,
		        	y : yValue,
				});
		}
	</c:forEach>
	chart.render();

var comment = new Array();
var chart = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	theme: "light2",
	title: {
		text: "Tương tác trong năm"
	},
	subtitles: [{
		text: "Đơn vị tính bằng số lượt bình luận"
	}],
	axisX: {
		valueFormatString: label,
		includeZero: true,
		suffix: "",
		title: "Tháng trong năm",
	},
	axisY: {
		title: "Số lượng bình luận"
	},
	data: [{
		type: "splineArea",
		xValueType: "Integer",
		xValueFormatString: label,
		yValueFormatString: "#,##0 bình luận",
		dataPoints: comment
	}]
});
 
var yValue;
var xValue;
var label;
 
<c:forEach items="${commentChart}" var="dataPoints" varStatus="loops">
		yValue = ${dataPoints.amount};
		xValue = ${dataPoints.month};
		label = ${dataPoints.month};
		for ( var index=0; index<=${loops.index}; index++ ) {
	        comment.push({
	        	label : xValue,
	        	x : xValue,
	        	y : yValue,
			});
	}
</c:forEach>
console.log(comment);
chart.render();
	
	
	
//3
var commentDay = new Array();
var chart = new CanvasJS.Chart("chartContainer3", {
	animationEnabled: true,
	exportEnabled: true,
	title: {
		text: "Tương tác trong tháng"
	},
	axisY:{
		title: "Số lượng",
		suffix: " Lượt",
		includeZero: true,
	},
	axisX:{
		title: "Ngày trong tháng",
	},
	data: [{
		type: "column", //change type to bar, line, area, pie, etc
		//indexLabel: "{y}", //Shows y value on all Data Points
		indexLabelFontColor: "#5A5757",
		dataPoints: commentDay
	}]
});
 
var yValuebar;
var xValuebar;
var labelbar;
 
<c:forEach items="${commentChartDay}" var="dataPoints" varStatus="loop">	
		xValuebar = ${dataPoints.month};
		yValuebar = ${dataPoints.amount};
		labelbar = ${dataPoints.month};
		for ( var index=0; index<=${loop.index}; index++ ) {
	        commentDay.push({
	        	label : xValuebar,
	        	x : xValuebar,
	        	y : yValuebar,
			});
	}
</c:forEach> 
chart.render();

//4
var commentSurvey = new Array();
var chart = new CanvasJS.Chart("chartContainer4", {
	animationEnabled: true,
	theme: "light2",
	title: {
		text: "Phân tích nhu cầu và thói quen người đọc theo chu kỳ"
	},
	subtitles: [{
		text: "Tổng hợp từ tất cả ngày trong các tháng"
	}],
	axisX: {
		valueFormatString: xValue,
		title: "Ngày trong tổng hợp từ nhiều tháng",
	},
	axisY: {
		title: "Số lượng tương tác"
	},
	data: [{
		type: "splineArea",
		xValueType: "mm",
		xValueFormatString: label,
		yValueFormatString: "#,##0 tương tác",
		dataPoints: commentSurvey
	}]
});
 
var yValue;
var xValue;
var label
 
<c:forEach items="${commentChartSurvey}" var="dataPoints" varStatus="loop">
		yValue = parseFloat("${dataPoints.amount}");
		xValue = parseFloat("${dataPoints.month}");
		for ( var index=0; index<=${loop.index}; index++ ) {
			commentSurvey.push({
	        	label : xValue,
	        	x : xValue,
	        	y : yValue,
			});
	}
</c:forEach>
 
chart.render();

}
</script>

	<div class="row">
		<div class="col-lg-7">
			<div id="chartContainer" style="height: 400px;"></div>
		</div>
		<!-- Earnings (Monthly) Card Example -->
		<div class="col-lg-5 row">
			<div style="height: auto; margin-bottom: 10px" class="col-lg-6">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div
									class="text-xs font-weight-bold text-primary text-uppercase mb-1">Số
									lượng Bài viết</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">${sizepost}</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-calendar fa-2x text-gray-300"></i>
							</div>
						</div>
						<br />
						<p>Số lượng thể hiện tổng tất cả bài viết mà website đang lưu
							trữ tại cơ sở dữ liệu</p>
					</div>
				</div>
			</div>
			<div style="height: auto; margin-bottom: 10px" class="col-lg-6">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div
									class="text-xs font-weight-bold text-primary text-uppercase mb-1">Số
									lượng Bình luận</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">${sizecomment}</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-calendar fa-2x text-gray-300"></i>
							</div>
						</div>
						<br />
						<p>Số lượng thể hiện tổng tất cả các bình luận của người dùng
							mà website đang lưu trữ tại cơ sở dữ liệu</p>
					</div>
				</div>
			</div>
			<div style="height: auto; margin-bottom: 10px" class="col-lg-6">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div
									class="text-xs font-weight-bold text-primary text-uppercase mb-1">Số
									lượng Tag</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">${sizehashtag}</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-calendar fa-2x text-gray-300"></i>
							</div>
						</div>
						<br />
						<p>Số lượng thể hiện tổng tất cả hashtag của bài viết mà
							website đang lưu trữ tại cơ sở dữ liệu</p>
					</div>
				</div>
			</div>
			<div style="height: auto; margin-bottom: 10px" class="col-lg-6">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div
									class="text-xs font-weight-bold text-primary text-uppercase mb-1">Số
									lượng Thể loại</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">${sizecat}</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-calendar fa-2x text-gray-300"></i>
							</div>
						</div>
						<br />
						<p>Số lượng thể hiện tổng tất cả thể loại bài viết mà website
							đang lưu trữ tại cơ sở dữ liệu</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br />
	<hr>
	<div class="row">
		<!-- Earnings (Monthly) Card Example -->
		<div class="col-12">
			<div id="chartContainer3" style="height: 370px"></div>
		</div>
	</div>
		<br />
	<hr>
	<div class="row">
		<!-- Earnings (Monthly) Card Example -->
		<div class="col-lg-5">
			<div id="chartContainer2" style="height: 370px"></div>
		</div>
		<div class="col-lg-7">
			<div id="chartContainer4" style="height: 370px"></div>
		</div>
	</div>
	<script src="<c:url value="/resource/admin/js/canvasjs.min.js"></c:url>"></script>
</body>
</html>