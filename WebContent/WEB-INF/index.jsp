<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学员管理</title>
<link rel="stylesheet" type="text/css" href="./css/test.css" />
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="//jpostal-1006.appspot.com/jquery.jpostal.js"></script>
<script type="text/javascript">
$(function() {
	$("#displsayaddress").click(function() {
		$("#displsayaddress").submit();
	});
});
$(function () {
	$('#zip1').jpostal({
		postcode : [
			'#zip1',
			'#zip2'
		],
		address : {
			'#address'  : '%3%4%5'
		}
	});
});
	$(function() {
		$("#displayGokakuController").click(function() {
			$("#displayGokakuController").submit();
		});
	});
	$(function() {
		$("#display").click(function() {
			$("#displsayGoodController").submit();
		});
	});

	$(function() {
		$("#delbutton").click(function() {
			$("#delForm").submit();
		});

	});

	$(function() {
		$("#displayteaList").click(function() {
			$("#displayteaList").submit();
		});

	});

	$(function() {
		$("#editbutton").click(function() {
			$("#update").submit();
		});
	});

	$(document).ready(function() {
		$("#editbutton").click(function() {

											var input_name = $("#editname")
													.val();
											var input_birthday = $(
													"#editbirthday").val();
											var input_age = $("#editage").val();
											var input_score = $("#editscore")
													.val();
											var input_classid = $(
													"#editclassid").val();
											var input_address = $(
											"#editaddress").val();
											if (input_name == ""
													|| input_name == null) {
												alert("姓名不能為空！！！");
												return false;
											} else {
												var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
												if (!username.test($(
														"#editname").val())) {
													alert("名字只能是英語或日語");
													return false;
												} else {
													if (input_birthday == ""
															|| input_birthday == null) {
														alert("出生年月不能爲空！！！");
														return false;
													} else {
														var userbirthday = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
														if (!userbirthday
																.test($(
																		"#editbirthday")
																		.val())) {
															alert("日期格式不正确，正确格式为：xxxx-xx-xx");
															return false;
														} else {
															if (input_age == ""
																	|| input_age == null) {
																alert("年齡不能為空！！！");
																return false;
															} else {
																var userage = /^[0-9]+$/;
																if (!userage
																		.test($(
																				"#editage")
																				.val())) {
																	alert("年齡必須是數字");
																	return false;
																} else {
																	if (input_score == ""
																			|| input_score == null) {
																		alert("成績不能爲空！！！");
																		return false;
																	} else {
																		var userscore = /^[0-9]+$/;
																		if (!userscore
																				.test($(
																						"#editscore")
																						.val())) {
																			alert("成績必須是數字");
																			return false;
																		} else {
																			if (input_classid == ""
																					|| input_classid == null) {
																				alert("班級不能爲空！！！");
																				return false;
																			} else {
																				var userclassid = /^[0-9]+$/;
																				if (!userclassid
																						.test($(
																								"#editclassid")
																								.val())) {
																					alert("班級必須是數字");
																					return false;
																					}else{
																					if (input_editaddress == ""
																						|| input_editaddress == null) {
																					alert("address不能為空！！！");
																					return false;
																				} else {
																					var useraddress = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
																					if (!useraddress.test($(
																							"#editaddress").val())) {
																						alert("address只能是英語或日語");
																						return false;
																						} else {
																					$("#editForm")
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
													}
													}
												}
											}
											});
						});
	$(document)
			.ready(
					function() {
						$("#addbutton")
								.click(
										function() {
											var input_name = $("#addname")
													.val();
											var input_birthday = $(
													"#addbirthday").val();
											var input_age = $("#addage").val();
											var input_score = $("#addscore")
													.val();
											var input_classid = $("#addclassid")
													.val();
											var input_address = $("#addaddress")
											.val();
											if (input_name == ""
													|| input_name == null) {
												alert("姓名不能為空！！！");
												return false;
											} else {
												var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
												if (!username
														.test($("#addname")
																.val())) {
													alert("名字只能是英語或日語");
													return false;
												} else {
													if (input_birthday == ""
															|| input_birthday == null) {
														alert("出生年月不能爲空！！！");
														return false;
													} else {
														var userbirthday = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
														if (!userbirthday
																.test($(
																		"#addbirthday")
																		.val())) {
															alert("日期格式不正确，正确格式为：xxxx-xx-xx");
															return false;
														} else {
															if (input_age == ""
																	|| input_age == null) {
																alert("年齡不能為空！！！");
																return false;
															} else {
																var userage = /^[0-9]+$/;
																if (!userage
																		.test($(
																				"#addage")
																				.val())) {
																	alert("年齡必須是數字");
																	return false;
																} else {
																	if (input_score == ""
																			|| input_score == null) {
																		alert("成績不能爲空！！！");
																		return false;
																	} else {
																		var userscore = /^[0-9]+$/;
																		if (!userscore
																				.test($(
																						"#addscore")
																						.val())) {
																			alert("成績必須是數字");
																			return false;
																		} else {
																			if (input_classid == ""
																					|| input_classid == null) {
																				alert("班級不能爲空！！！");
																				return false;
																			} else {
																				var userclassid = /^[0-9]+$/;
																				if (!userclassid
																						.test($(
																								"#addclassid")
																								.val())) {
																					alert("班級必須是數字");
																					return false;
																				} else {
																					if (input_address == ""
																						|| input_address == null) {
																					alert("address不能為空！！！");
																					return false;
																				} else {
																					var useraddress = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
																					if (!useraddress
																							.test($("#addaddress")
																									.val())) {
																						alert("address只能是英語或日語");
																						return false;
																				} else {
																					$(
																							"#addForm")
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
												}
											}
										}
									}
								});
					});
</script>
</head>
<body>

	<h1 align="center">学员信息管理</h1>
	<div>
		<h1 align="center">
			<form id="displayteaList" action="displayteaList" method="post">
				<button id="play" type="button">
					<p>先生の情報</p>
				</button>

			</form>
		</h1>
	</div>

	<div id="all_comm" class="all">
		<h2>学员信息一览</h2>
		<table id="items" cellspacing="0px" cellspadding="0px" width="700px">
			<tr>
				<td class="headBackground" width="30px" align="center">id</td>
				<td class="headBackground" width="100px">姓名</td>
				<td class="headBackground" width="100px">生年月日</td>
				<td class="headBackground" width="30px">年龄</td>
				<td class="headBackground" width="50px">成績</td>
				<td class="headBackground" width="30px">組</td>
				<td class="headBackground" width="300px">住所</td>
			</tr>

			<c:forEach items="${students}" var="students">
				<tr>
					<td >${students.id}</td>
					<td >${students.name}</td>
					<td >${students.birthday}</td>
					<td >${students.age}</td>
					<td >${students.score}</td>
					<td >${students.classid}</td>
					<td >${students.address}</td>
				</tr>
			</c:forEach>
		</table>

	<input id="editid" type="text" placeholder="要修改的id" name="id"
				value="要修改的id为"/><br>
		郵便番号<br>
<input type="text" id="zip1" name="zip1"> - <input type="text" id="zip2" name="zip2"><br>
住所<br>
<input type="text" id="address" name="address">
</div>

<div>
		<form id="displsayaddress" action="addaddress" method="post">
			<button id="displsayaddress" type="button">
				<p>添加</p>
			</button>
		</form>
	</div>

	<div id="averScoreByClassId" class="all">
		<h2 align="center">りて成績</h2>
		<table id="averScoreByClassIditems">
			<tr>
				<td class="headBackground" width="50px">くらすID</td>

				<td class="headBackground" width="50px">りて成績</td>
			</tr>

			<c:forEach items="${classScoreFormList}" var="classScoreForm">
				<tr>
					<td>${classScoreForm.classId}</td>
					<td>${classScoreForm.averScore}</td>

				</tr>
			</c:forEach>
		</table>

	</div>
	<div id="displsayAverScore" class="all" align="left">
		<form action="displsayAverScoreController" method="post">
			<input type="submit" value="りて成績">

		</form>
	</div>

	<div id="add_comm" class="all" align="left">
		<h2>查找学员</h2>
		<form action="queryByName" method="post">
			<input type="text" placeholder="姓名" name="name"> <input
				type="submit" value="查找学员">
		</form>
		<h2>查找学员</h2>
		<form action="queryByclassid" method="post">
			<input type="text" placeholder="classid" name="classid"> <input
				type="submit" value="查找学员">
		</form>
		<h2>查找学员</h2>
		<form action="queryByid" method="post">
			<input type="text" placeholder="ID" name="id"> <input
				type="submit" value="查找学员">
		</form>

		<h2 id="edit_title">添加学员</h2>
		<form id="addForm" action="add" method="post" class="checkform">
			<input id="addname" type="text" placeholder="氏名" name="name" /> <input
				id="addbirthday" type="text" placeholder="生年月日" name="birthday" />
			<input id="addage" type="text" placeholder="年齢" name="age"
				class="number" /> <span class="alertarea"></span> <input
				id="addscore" type="text" placeholder="成績" name="score" /> <input
				id="addclassid" type="text" placeholder="コースコード" name="classid" />
			<button id="addbutton" type="button">
				<p>添加</p>
			</button>
		</form>
	</div>

	<div id="edit_comm" class="all">
		<h2>删除学员</h2>
		<form id="delForm" action="deleteById" method="post">
			<input id="delid" type="text" placeholder="要删除的id" name="id" />
			<button id="delbutton" type="button">
				<p>删除</p>
			</button>
		</form>

		<h2 id="edit_title">编辑学员</h2>
		<form id="editForm" action="update" method="post">
			<input id="editid" type="text" placeholder="要修改的id" name="id"
				value="要修改的id为" /><br> <input id="editname" type="text"
				placeholder="姓名" name="name" /> <input id="editbirthday"
				type="text" placeholder="生年月日" name="birthday" /> <input
				id="editage" type="text" placeholder="年龄" name="age" /> <input
				id="editscore" type="text" placeholder="分数" name="score" /> <input
				id="editclassid" type="text" placeholder="classid" name="classid" />

			<button id="editbutton">
				<p>编辑</p>
			</button>
		</form>
	</div>




	<div>
		<form id="displsayGood" action="displsayGoodController" method="post">
			<button id="display" type="button">
				<p>成績優秀者</p>
			</button>
		</form>
	</div>
	<div>
		<form id="displayGokakuController" action="displayGokakuController"
			method="post">
			<button id="play" type="button">
				<p>優秀者</p>
			</button>
		</form>
	</div>




</body>
</html>