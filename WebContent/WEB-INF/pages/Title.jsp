<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta charset="UTF-8">
<link rel="stylesheet" href='<c:url value = "/lib/bootstrap-4.4.1/css/bootstrap.css"/>' />
<style>
body {
	background: #FFF8D7;
}
</style>





<ul class="nav justify-content-center my-5">

	<li class="nav-item border mx-3">
	
	<a class="nav-link ${bullboard}  font-weight-bold" href='<c:url value="/login/BullBoard"/>' tabindex="-1">佈告欄</a>
		
	</li>
	
	<li class="nav-item border mx-3">
	
	<a class="nav-link ${title} font-weight-bold" href='<c:url value="/login/index"/>'
		tabindex="-1">回首頁</a>
		
	</li>
	
	
	<c:if test="${! empty LoginOK }">
	
	<li class="nav-item border mx-3">
	<a class="nav-link ${userLogin} font-weight-bold" href='<c:url value="/logout/toLoginPage"/>'
		tabindex="-1">登出</a>
	</li>
	
	<li class="nav-item border mx-3">
	<a class="nav-link ${userLogin} text-success font-weight-bold" href='<c:url value="/login/LoginSucess"/>'
		tabindex="-1">${usersResultMap.UserName}</a>
	</li>
	
	</c:if>
</ul>





<script type="text/javascript" src='<c:url value = "/lib/jquery/jquery-3.4.1.js"/>'></script>
	<script type="text/javascript" src='<c:url value = "/lib/bootstrap-4.4.1/js/bootstrap.js"/>'></script>
<script type="text/javascript"
		src='<c:url value="/javascript/BulletinBoard/renew.js"></c:url>'></script>

