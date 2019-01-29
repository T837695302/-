<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>管理</title>
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
		$("#queryBysname").click(function() {
			$("#queryBysname").submit();
		})
	})
$(function() {
		$("#displayteaList").click(function() {
			$("#displayteaList").submit();
		});
	});
	$(function() {
		$("#editbutton").click(function() {
			$("#updates").submit();
		});
	});
	$(function() {
		$("#addbutton").click(function() {
			$("#addaaa").submit();
		});
	});
	$(function () {
		$('#zipa').jpostal({
			postcode : [
				'#zipa',
				'#zipb'
			],
			address : {
				'#addaddress'  : '%3%4%5'
			}
		});
	});
	$(function () {
		$('#zip1').jpostal({
			postcode : [
				'#zip1',
				'#zip2'
			],
			address : {
				'#editaddress'  : '%3%4%5'
			}
		});
	});

	$(document)
	.ready(
			function() {
				$("#addbutton")
						.click(
								function() {
									var input_name = $("#addname").val();
									var input_place = $("#addplace").val();
									var input_weight = $("#addweight").val();
									var input_line = $("#addline").val();
									var input_address = $("#addaddress").val();
									if (input_name == ""
											|| input_name == null) {
										alert("名字不能為空！！！");
										return false;
									} else {
										var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
										if (!username.test($("#addname").val())) {
											alert("名字只能是英語或日語");
											return false;
										} else {
											if (input_place== ""
													|| input_place== null) {
												alert("産地不能爲空！！！");
												return false;
													} else {
														var userplace = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
														if (!userplace.test($("#addplace").val())) {
															alert("産地只能是英語或日語");
															return false;
														}else{
															if (input_weight == ""
																|| input_weight == null) {
															alert("weight不能爲空！！！");
															return false;
														} else {
														var userweight = /^[0-9]+$/;
														if (!userweight.test($("#addweight").val())) {
															alert("重さ必須是數字");
															return false;
														} else {
															if (input_line == ""
																	|| input_line == null) {
																alert("line不能爲空！！！");
																return false;
															} else {
																var userline = /^[0-9]+$/;
																if (!userline.test($("#addline").val())) {
																	alert("line必須是數字");
																	return false;
																} else {
																	if (input_address == ""
																			|| input_address == null) {
																		alert("address不能爲空！！！");
																		return false;
																		} else {
																			var useraddress = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
																			if (!useraddress.test($("#addaddress").val())) {
																				alert("address只能是英語或日語");
																				return false;
																			} else {
																			$("#addForm").submit();
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
							   });
			               });
	$(document)
			.ready(
					function() {
						$("#editbutton")
								.click(
										function() {
											var input_name = $("#editname").val();
											var input_place = $("#editplace").val();
											var input_weight = $("#editweight").val();
											var input_line = $("#editline").val();
											var input_address = $("#editaddress").val();
											if (input_name == ""
													|| input_name == null) {
												alert("名字不能為空！！！");
												return false;
											} else {
												var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
												if (!username.test($("#editname").val())) {
													alert("名字只能是英語或日語");
													return false;
												} else {
													if (input_place== ""
															|| input_place== null) {
														alert("産地不能爲空！！！");
														return false;
															} else {
																var userplace = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
																if (!userplace.test($("#editplace").val())) {
																	alert("産地只能是英語或日語");
																	return false;
																}else{
																	if (input_weight == ""
																		|| input_weight == null) {
																	alert("weight不能爲空！！！");
																	return false;
																} else {
																var userweight = /^[0-9]+$/;
																if (!userweight.test($("#editweight").val())) {
																	alert("重さ必須是數字");
																	return false;
																} else {
																	if (input_line == ""
																			|| input_line == null) {
																		alert("line不能爲空！！！");
																		return false;
																	} else {
																		var userline = /^[0-9]+$/;
																		if (!userline.test($("#editline").val())) {
																			alert("line必須是數字");
																			return false;
																				} else {
																					if (input_address == ""
																							|| input_address == null) {
																						alert("address不能爲空！！！");
																						return false;
																					} else {
																					var useraddress = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
																					if (!useraddress.test($("#editaddress").val())) {
																						alert("address只能是英語或日語");
																						return false;
																					} else {
																					$("#editForm").submit();
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
									});
					        });

	</script>

</head>
<body>


	<h1 align="center">信息管理</h1>
	<div id="all_comm" class="all">
		<h2 align="center" style="color:red;">信息一览</h2>
		<table align="center" id="items" width="700px" style="color:#16008b;">
			<tr>
				<td style="background-color:pink" class="Background" width="50px" align="center">id</td>
				<td style="background-color:pink" class="Background" width="100px">姓名</td>
				<td style="background-color:pink" class="Background" width="120px">産地</td>
				<td style="background-color:pink" class="Background" width="50px">重さ</td>
				<td style="background-color:pink" class="Background" width="50px">line</td>
				<td style="background-color:pink" class="Background" width="350px">住所</td>
			</tr>
			<c:forEach items="${aaaList}" var="aaa">
				<tr>
					<td>${aaa.id}</td>
					<td>${aaa.name}</td>
					<td>${aaa.place}</td>
					<td>${aaa.weight}</td>
					<td>${aaa.line}</td>
					<td>${aaa.address}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="edit_comm" class="all">
		<h3>查找</h3>
		<form action="queryBysname" method="post">
			<input style="background-color:lightblue" type="text" placeholder="name" name="name"> <input
				style="background-color:lightpink" type="submit" value="查找">
		</form>
		<div>
			<h3>削除</h3>
			<form action="delebyid" method="post">
				<input style="background-color:lightblue" type="text" placeholder="id" name="id"> <input
				style="background-color:lightpink"	type="submit" value="削除">
			</form>
			<h3 id="add_title">添加</h3>
			<form id="addForm" action="addaaa" method="post">
				<input style="background-color:lightblue" id="addname" type="text" placeholder="姓名" name="name" /> <input
					style="background-color:lightblue" id="addplace" type="text" placeholder="産地" name="place" /> <input
					style="background-color:lightblue" id="addweight" type="text" placeholder="重さ" name="weight" /> <input
				style="background-color:lightblue" 	id="addline" type="text" placeholder="line" name="line" /><br>
				<input style="background-color:lightblue" type="text" id="zipa" placeholder="郵便番号" name="zipa"> - <input
					style="background-color:lightblue" type="text" id="zipb" placeholder="郵便番号" name="zipb"> 	<input style="background-color:lightblue" type="text" id="addaddress" placeholder="住所" name="address">
				<button style="background-color:lightpink" id="addbutton" placeholder="住所" type="button">
					<p>添加</p>
				</button>
			</form>
		</div>
		<h3 id="edit_title">编辑</h3>
		<form id="editForm" action="updates" method="post">
			<input style="background-color:lightblue" id="editid" type="text" placeholder="要修改的id" name="id" /><br>
			<input style="background-color:lightblue" id="editname" type="text" placeholder="姓名" name="name" /> <input
				style="background-color:lightblue" id="editplace" type="text" placeholder="産地" name="place" /> <input
				style="background-color:lightblue" id="editweight" type="text" placeholder="重さ" name="weight" /> <input
				style="background-color:lightblue" id="editline" type="text" placeholder="line" name="line" /><br>
			<input style="background-color:lightblue" type="text" id="zip1" placeholder="郵便番号"name="zip1"> - <input
				style="background-color:lightblue" type="text" id="zip2"placeholder="郵便番号" name="zip2">
			<input style="background-color:lightblue" type="text" id="editaddress"placeholder="住所" name="address">
			<button style="background-color:lightpink" id="editbutton" type="button">
				<p>编辑</p>
			</button>
		</form>
	</div>
</head>
</html>