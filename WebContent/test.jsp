<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="WEB-INF/lib/bootstrap-4.4.1/css/bootstrap.css" />

<link rel="stylesheet" href="wysibb/theme/default/wbbtheme.css" />
<script type="text/javascript" src="jquery/jquery-3.4.1.js"></script>
<script type="text/javascript" src="wysibb/jquery.wysibb.js"></script>

</head>
<body>

	
	<textarea id="editor"></textarea>

	<script>
		$(document).ready(function() {
			var wbbOpt = {
				buttons : "bold,italic,underline,|,img,link,|,code,quote"
			}
			$("#editor").wysibb(wbbOpt);
		});
	</script>


	
<!-- 	<script type="text/javascript" src="wysibb/lang/cn.js"></script> -->



</body>
</html>