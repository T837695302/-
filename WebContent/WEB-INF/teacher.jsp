<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>先生管理</title>
<link rel="stylesheet" type="text/css" href="./css/all.css" />
<style type="text/css">
</style>
<script type="text/javascript">

</script>

<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script type="text/javascript">

	$(function(){
		$("#display").click(function() {
			$("#displsayGood").submit();
		});
	});
	$(function(){
		$("#delebutton").click(function() {
			$("#deleForm").submit();
		});

	});

	$(function(){
		$("#displaystudentList").click(function() {
			$("#displaystudentList").submit();
		});

	});

	$(document).ready(function(){
		  $("#addteachersumit").click(function(){
			  var input_name=$("#addteachename").val();
			  var input_course=$("#addcourse").val();
			  if (input_name == "" || input_name == null) {
					alert("请输入先生姓名！！！");
					return false;
				}else{
					if (input_course == "" || input_course == null){
						alert("请输入先生課程！！！");
						return false;
					}
					   var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
						console.log("addCheckForm Function!");
					    console.log($("#addteachername").val());
					    if(!username.test($("#addteachername").val())){
							alert("先生姓名只能输入日文和英文");
							return false;
					    }else{
								alert("添加成功！");
								$("#addForm").submit();
					}
				}
		  });
		});
	$(function(){
		$("#addbutton").click(function() {
			$("#addForm").submit();
		});
	});
	</script>
</head>
<body>
	<img src="./images/header.jpg" />
	<h1 align="center">先生信息管理</h1>

<div>
		<form id="displaystudentList" action="displaystudentList"
			method="post">
			<button id="play" type="button">
				<p>学生の情報</p>
			</button>
		</form>
	</div>

	<div id="all_comm" class="all">
		<h2 align="center">先生信息一览</h2>
		<table id="items" border="8">

			<tr>
				<td>id</td>
				<td>姓名</td>
				<td>科目</td>

			</tr>

			<c:forEach items="${teachers}" var="teacher">
				<tr>
					<td id="${teacher.id }">${teacher.id}</td>
					<td id="${teacher.name}">${teacher.name}</td>
					<td id="${teacher.course}">${teacher.course}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<h2>查找name</h2>
	<form action="queryByteaName" method="post">
		<input type="text" placeholder="姓名" name="name"> <input
			type="submit" value="查找">
	</form>
	<h2>查找id</h2>
	<form action="queryByteaId" method="post">
		<input type="text" placeholder="id" name="id"> <input
			type="submit" value="查找">
	</form>

	<h2>追加</h2>
	<form id="addForm" action="addtea" method="post" class="checkform">
			<input id="addname" type="text" placeholder="氏名" name="name" />
			<input id="addcourse" type="text" placeholder="course" name="course" />
			<button id="addbutton" type="button">
			<p>追加</p>
		</button>
	</form>
<div id="dele_comm" class="all">
			<h2>删除</h2>
			<form id="deleForm" action="deleteByteaId" method="post">
				<input id="delid" type="text" placeholder="要删除的id" name="id" />
				 <button id="delebutton" type="button">
			<p>删除</p >
			</button>
			</form>
</div>
</body>
</html>