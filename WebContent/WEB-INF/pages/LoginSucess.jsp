<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>

<!-- 簡單title by GK Start -->
<%@ include file="Title.jsp"%>
<!-- End-->


<h1>登入成功</h1>
<h3>你的個人資訊</h3>
<label>員工編號: </label>${usersResultMap.EmployeeID}<br>
<label>帳號: </label>${usersResultMap.UserName}<br>
<label>密碼: </label>${usersResultMap.UserPassword}<br>
<label>職稱: </label>${usersResultMap.Title}<br>
<label>部門: </label>${usersResultMap.Department}<br>

<a href="/EIS/logout/toLoginPage">LOGOUT</a>

</body>
</html>