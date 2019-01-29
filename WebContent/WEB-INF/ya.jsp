<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>会員管理</title>
<link rel="stylesheet" type="text/css" href="./css/test.css" />
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="//code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript"
	src="//jpostal-1006.appspot.com/jquery.jpostal.js"></script>
<script type="text/javascript">
	$(function() {
		$("#deletebutton").click(function() {
			$("#deleteForm").submit();
		});
	});
	$(function() {
		$("#yaaddbutton").click(function() {
			$("#yaaddForm").submit();
		});
	});

	$(document)
			.ready(
					function() {
						$("#yaaddbutton")
								.click(
										function() {
											var input_name = $("#addname")
													.val();
											var input_
											hobby = $("#addhobby").val();
											var input_height = $("#addheight")
													.val();
											var input_weight = $("#addweight")
													.val();
											if (input_name == ""
													|| input_name == null) {
												alert("名字不能為空！！！");
												return false;
											} else {
												var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
												if (!username
														.test($("#addname")
																.val())) {
													alert("名字只能是英語或日語");
													return false;
												} else {
													if (input_hobby == ""
															|| input_hobby == null) {
														alert("趣味不能爲空！！！");
														return false;
													} else {
														var userhobby = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
														if (!userhobby.test($(
																"#addhobby")
																.val())) {
															alert("趣味只能是英語或日語");
															return false;
														} else {
															if (input_height == ""
																	|| input_height == null) {
																alert("身長不能爲空！！！");
																return false;
															} else {
																var userheight = /^[0-9]+$/;
																if (!userheight
																		.test($(
																				"#addheight")
																				.val())) {
																	alert("身長必須是數字");
																	return false;
																} else {
																	if (input_weight == ""
																			|| input_weight == null) {
																		alert("体重不能爲空！！！");
																		return false;
																	} else {
																		var userweight = /^[0-9]+$/;
																		if (!userweight
																				.test($(
																						"#addweight")
																						.val())) {
																			alert("体重必須是數字");
																			return false;
																		} else {
																			$(
																					"#yaaddForm")
																					.submit();
																			alert("ok！");
																		}
																	}
																}
															}
														}
													}
												}
											}
										});
					});
</script>
</head>

<body>

	<h1 align="center">信息管理</h1>
	<div id="all_comm" class="all">
		<h2 align="center" style="color: red;">信息一览</h2>
		<table align="center" id="items" width="700px" style="color: #16008b;">
			<tr>
				<td style="background-color: pink" class="Background" width="50px"
					align="center">id</td>
				<td style="background-color: pink" class="Background" width="100px">姓名</td>
				<td style="background-color: pink" class="Background" width="120px">趣味</td>
				<td style="background-color: pink" class="Background" width="50px">身長</td>
				<td style="background-color: pink" class="Background" width="50px">体重</td>
			</tr>
			<c:forEach items="${yaList}" var="ya">
				<tr>
					<td>${ya.id}</td>
					<td>${ya.name}</td>
					<td>${ya.hobby}</td>
					<td>${ya.height}</td>
					<td>${ya.height}</td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="edit_comm" class="all">
		<h3>查找</h3>
		<form action="queryByyaname" method="post">
			<input style="background-color: lightblue" type="text"
				placeholder="name" name="name"> <input
				style="background-color: lightpink" type="submit" value="查找">
		</form>
		<h3>查找</h3>
		<form action="queryByyaid" method="post">
			<input style="background-color: lightblue" type="text"
				placeholder="id" name="id"> <input
				style="background-color: lightpink" type="submit" value="查找">
		</form>

		<h3>删除</h3>
		<form id="deleteForm" action="deleteya" method="post">
			<input style="background-color: lightblue" id="deleteid" type="text"
				placeholder="要删除的id" name="id" />
			<button style="background-color: lightpink" id="deletebutton"
				type="button">
				<p>删除</p>
			</button>
		</form>

		<h3>添加</h3>
		<form id="yaaddForm" action="addYa" method="post">
			<input style="background-color: lightblue" id="addname" type="text"
				placeholder="姓名" name="name" /> <input
				style="background-color: lightblue" id="addhobby" type="text"
				placeholder="趣味" name="hobby" /><br> <input
				style="background-color: lightblue" id="addheight" type="text"
				placeholder="身長" name="height" /> <input
				style="background-color: lightblue" id="addweight" type="text"
				placeholder="体重" name="weight" /> <input
				style="background-color: lightpink" type="submit" value="添加">
		</form>
	</div>


	<div style="background-color:lightblu;width:100px;height:30px" >

<style  type="text/css">
.list {
	list-style: none;
}

.item {
	float: left;
	margin-right: 10px;
	width: 50px;
}
</style>
<ul style="" class="list">
		<c:forEach begin="0" end="${PageCounts}" step="1" var="pagenum">
	<li class="item" style="float: leftp; margin-left: 100px;">
	<a	href="http://localhost:8080/StudentManager/pall?sPage=${pagenum}">NO.${pagenum+1}</a>
</c:forEach>
</ul>
</div>

















</body>
</html>