<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学员管理</title>
<link rel="stylesheet" type="text/css" href="./css/all.css" />
<style type="text/css">
</style>
 <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
  <!-- jQuery -->
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <!-- DataTables -->
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
  <script>
$(document).ready(function(){
  $('#table_id').dataTable();
});
</script>
<script type="text/javascript">
	function addCheckForm() {
		var form = document.getElementById('addForm');

		var input_teachername = document.getElementById('addteachername').value;
		var input_course = document.getElementById('addcourse').value;

		if (input_teachername == "" || input_teachername == null) {
			alert("请输入先生姓名！！！");
			return false;
		}

		if (input_course == "" || input_course == null) {
			alert("请输入先生出生年月！！！");
			return false;
		}

		form.submit();
		return true;
	}

	function delCheckForm() {
		var form = document.getElementById('delForm');
		var flag = 0;
		var input_id = document.getElementById("delid").value;
		if (input_id == "" || input_id == null) {
			alert("请输入削除先生id！！！");
			return false;
		}

		if (input_id.match(/[^0-9]+/)) {
			flag = 1;
		}

		if (flag) {
			window.alert('数字以外が入力できません');
			return false; // 送信を中止
		}

		form.submit();
		return true;
	}

	function editCheckForm() {
		var form = document.getElementById('editForm');

		var input_id = document.getElementById('editid');
		var input_teachername = document.getElementById('editteachername');
		var input_score = document.getElementById('editscore');

		if (input_id == "" || input_id == null) {
			alert("请输入先生id！！！");
			return false;
		}

		if (input_teachername == "" || input_teachername == null) {
			alert("请输入先生姓名！！！");
			return false;
		}


		form.submit();
		return true;
	}
</script>
</head>
<body>
	<img src="./images/header.jpg" /> ${msg}
	<h1 align="center">先生信息管理</h1>



	<div id="all_comm" class="all">
		<h2 align="center">先生信息一览</h2>
		<table id="table_id">
			<tr>
				<td>id</td>
				<td>teachername</td>
				<td>course</td>

			</tr>

			<c:forEach items="${teachers}" var="teacher">
				<tr>
					<td id="id${teacher.id }">${teacher.id}</td>
					<td id="teachername${teacher.id }">${teacher.teachername}</td>
					<td id="course${teacher.id}">${teacher.course}</td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="add_comm" class="all" align="left">
		<h2>查找先生</h2>
		<form action="queryByNameTeac" method="post">
			<input type="text" placeholder="姓名" name="teachername"> <input
				type="submit" value="查找先生">
		</form>

		<h2 id="edit_title">添加先生</h2>
		<form id="addForm" action="addTeac" method="post">
			<input id="addteachername" type="text" placeholder="姓名"
				name="teachername" /> <input id="addcourse" type="text"
				placeholder="科目" name="course" /> <input type="button" value="添加"
				onClick="addCheckForm(this.form.txt)" />
		</form>
	</div>

	<div id="edit_comm" class="all">
		<h2>删除先生</h2>
		<form id="delForm" action="deleteByIdTeac" method="post">
			<input id="delid" type="text" placeholder="要删除的id" name="id" /> <input
				type="button" value="删除先生" onclick="delCheckForm()" />
		</form>

		<h2 id="edit_title">编辑先生</h2>
		<form id="editForm" action="updateTeac" method="post">
			<input id="editid" type="text" placeholder="要修改的id" id="edit_id"
			name="id" placeholder="要修改的id为" /><br> <input
				id="editteachername" type="text" placeholder="姓名" name="teachername" />
			<input id="editcourse" type="text" placeholder="科目" name="course" />
			<input type="submit" value="确定修改"  />
		</form>
	</div>
</body>
</html>