<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="disabled text-danger" scope="page" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<style>
#helfpresent {
	width: 30%;
}
</style>

</head>
<body>

	<div class="container">
		<%@ include file="Title.jsp"%>
	</div>
	<section class="container text-center">
		<p class="text-center">我是主頁面</p>


		<section class="accordion" id="board"></section>



		<img src="images/pabow.jpg" />


	</section>


	<script type="text/javascript"
		src='<c:url value = "/lib/jquery/jquery-3.4.1.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value = "/lib/bootstrap-4.4.1/js/bootstrap.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/javascript/BulletinBoard/index.js"></c:url>'></script>


</body>
</html>