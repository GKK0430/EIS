$(document).ready(
				function() {
					$("#tttttt").click(function() {
						alert("$('#file').val():" + $('#file').val())
					})
					
					$("input[type='radio']").click(function() {
						var data = $(this).val();
						if(data=="parallel"){
							$(".depAuthority").css("display","inline");
							console.log("inline");
						}else{
							$(".depAuthority").css("display","none");
							console.log("none");
						}
					})
					
					$("input[type='checkbox']").click(function() {
						console.log($(this).val());
					})
					
					
					
					
					

					
					result();
					function result() {
						$("#result").html("");
						var str = "";

						$.ajax({
									url : "http://localhost:8080/EIS/queryBulletinRecord",
									type : "get",
									cache : false,
									async : false,
									success : function(rs) {
										var rs2 =  JSON.parse(rs);
										console.log("sucess");
										console.log("rs2.length:" + rs2.length);
										for (var i = 0; i < rs2.length; i++) {

											str += '<div class="card">'
												+'<div class="card-header" id="heading'+i+'">'
												+'<h2 class="mb-0">'
												+'<button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse'+i+'" aria-expanded="true" aria-controls="collapse'+i+'">'
												+rs2[i].Title
												+'</button></h2></div>'
												+' <div id="collapse'+i+'" class="collapse" aria-labelledby="heading'+i+'" data-parent="#result">'													
												+'<div class="card-body">'
												+rs2[i].Context
												+'<p>權限:' + rs2[i].Authority + '</p>'
												+'<p>上線日期:' + rs2[i].upTime + '</p>'
												+'<p>下架日期:' + rs2[i].downTime + '</p>'
												+'<p>創造日期:' + rs2[i].Date + '</p>'
												+'</div></div></div>'
											
										}

										$("#result").html(str);

									},
									error : function(rs) {
										console.log("error")
									}

								})
					}
						
								
								
								
						checkData();
						function checkData() {
						$("#checkData").html("");
						var str = "";
						
						$.ajax({
									url : "http://localhost:8080/EIS/checkdata",
									type : "get",
									cache : false,
									async : false,
									success : function(rs) {
										console.log("sucess");
										var rs2 =  JSON.parse(rs);
										console.log("rs2.length:" + rs2.length);
										
										for (var i = 0; i < rs2.length; i++) {
			
											str += '<div class="card">'
												+'<div class="card-header" id="heading'+i+'">'
												+'<h2 class="mb-0">'
												+'<button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse'+i+'" aria-expanded="true" aria-controls="collapse'+i+'">'
												+rs2[i].Title
												+'</button></h2></div>'
												+' <div id="collapse'+i+'" class="collapse" aria-labelledby="heading'+i+'" data-parent="#checkData">'													
												+'<div class="card-body">'
												+rs2[i].Context
												+'<p>權限:' + rs2[i].Authority + '</p>'
												+'<p>上線日期:' + rs2[i].upTime + '</p>'
												+'<p>下架日期:' + rs2[i].downTime + '</p>'
												+'<p>創造日期:' + rs2[i].Date + '</p>'
												+'</div></div></div>'
										}

										$("#checkData").html(str);

									},
									error : function(rs) {
										console.log("error")
									}

								})
						}

					
				})