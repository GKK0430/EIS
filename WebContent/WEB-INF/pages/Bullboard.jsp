<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="bullboard" value="disabled text-danger" scope="page" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="multipart/form-data;charset=utf-8" />
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#content {
	width: 60%;
	height: 300px;
}

#title {
	width: 60%;
}

.date {
	width: 24%
}
#BulletinBoardid,.depAuthority{
	display:none;
}
</style>

</head>
<body>
	<%@ include file="Title.jsp"%>

	<section
		class="container text-center my-5 shadow-sm p-3 mb-5 bg-white rounded">
		<h2>
			<p>布告欄更新系統</p>
			<p class="text-danger">${Msg.Msg}</p>
		</h2>

		<div>
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item "><a class="nav-link" id="profile-tab"
					data-toggle="tab" href="#check" role="tab" aria-controls="#check"
					aria-selected="false">目前發布通知</a></li>
				<li class="nav-item"><a class="nav-link" id="contact-tab"
					data-toggle="tab" href="#update" role="tab" aria-controls="update"
					aria-selected="false">新增通知</a></li>
				<li class="nav-item"><a class="nav-link" id="record-tab"
					data-toggle="tab" href="#record" role="tab" aria-controls="#record"
					aria-selected="false">歷年紀錄</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade ${check}" id="check" role="tabpanel"
					aria-labelledby="profile-tab">
					<h3>顯示</h3>
					<div class="accordion" id="checkData"></div>
				</div>

				<div class="tab-pane fade" id="update" role="tabpanel"
					aria-labelledby="contact-tab">
					<h3 id="updateName">新增通知</h3>

					<form id="insertNotice" name="insertNotice"
						action='<c:url value="/insert"></c:url>' method="post"
						enctype="multipart/form-data">
						<p>
							<input type="text" name="title" placeholder="標題" id="title" />
						</p>
						<input type="text" name="BulletinBoardid" id="BulletinBoardid">
						<textarea name="content" placeholder="內文" id="content"></textarea>

						<p>
							發佈日期：<input class="date" id="uptime" type="date" name="uptime">
							下架日期：<input class="date" id="downtime" type="date"
								name="downtime">
						</p>

						<p>
							<input class="my-2" type="radio" id="Authority" name="Authority"
								value="parallel">傳至其他部門 <input class="my-2" type="radio"
								id="Authority" name="Authority" value="down">向下發布
						<div class="depAuthority">

							<c:if test="${loginOK.department!='HR'}">
								<input type="checkbox" value="HR" name="dep"> HR
							</c:if>
							<c:if test="${loginOK.department!='RD'}">
								<input type="checkbox" value="RD" name="dep">RD 
							</c:if>
							<c:if test="${loginOK.department!='Test'}">
								<input type="checkbox" value="Test" name="dep"> Test
									</c:if>
							<c:if test="${loginOK.department!='Sales'}">
								<input type="checkbox" value="Sales" name="dep"> Sales
							</c:if>
							<c:if test="${loginOK.department!='PM'}">
								<input type="checkbox" value="PM" name="dep"> PM
								</c:if>
						</div>




						<p>
							附件:<input id="file" type="file" name="file" />
						</p>

						<section class="text-center">
							<button type="submit" class="my-2 btn btn-secondary">送出</button>
							<button type="button" id="tttttt" class="my-2 btn btn-secondary">測試</button>
						</section>
					</form>
				</div>

				<div class="tab-pane fade ${record}" id="record" role="tabpanel"
					aria-labelledby="contact-tab">
					<h3>歷年紀錄</h3>
					<div class="accordion" id="result"></div>
				</div>
			</div>
		</div>
	
	</section>




	<script type="text/javascript"
		src='<c:url value = "/lib/jquery/jquery-3.4.1.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value = "/lib/bootstrap-4.4.1/js/bootstrap.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/javascript/BulletinBoard/BullBoard.js"></c:url>'></script>


	
</body>
</html>