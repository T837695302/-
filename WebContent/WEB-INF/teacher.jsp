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

function addCheckForm() {
	var form = document.getElementById('addForm');

	var input_name = document.getElementById('addname').value;
	var input_course = document.getElementById('addcourse').value;

	if (input_name == "" || input_name == null) {
		alert("请输入教師姓名！！！");
		return false;
	}

	if (input_course == "" || input_course == null) {
		alert("请输入科目！！！");
		return false;
	}

	form.submit();
	return true;
}


	function delCheckForm() {
		var form = document.getElementById('delForm');
		var input_id = document.getElementById("delid").value;
		var flag = 0;
		if (input_id == "" || input_id == null) {
			alert("请输入削除教師id！！！")
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
		var input_name = document.getElementById('editname');
		var input_course = document.getElementById('editcourse');

		if (input_id == "" || input_id == null) {
			alert("请输入教師id！！！");
			return false;
		}

		if (input_name == "" || input_name == null) {
			alert("请输入教師姓名！！！");
			return false;
		}

		if (input_course == "" || input_course == null) {
			alert("请输入科目！！！");
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
		<table id="items">
			<tr>
				<td>id</td>
				<td>姓名</td>
				<td>科目</td>

			</tr>

			<c:forEach items="${teachers}" var="teacher">
				<tr>
					<td id="id${teacher.id }">${teacher.id}</td>
					<td id="name${teacher.id }">${teacher.teachername}</td>
					<td id="birthday${teacher.id}">${teacher.course}</td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="add_comm" class="all" align="left">
		<h2>查找先生</h2>
		<form action="queryByNameTeac" method="post">
			<input type="text" placeholder="姓名" name="teacername"> <input
				type="submit" value="查找先生">
		</form>

		<h2 id="edit_title">添加先生</h2>
		<form id="addForm" action="addTeac" method="post">
			<input id="addname" type="text" placeholder="姓名" name="name" /> <input
				id="addcourse" type="text" placeholder="科目" name="course" /> <input
				type="button" value="添加" onClick="addCheckForm(this.form.txt)" />
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
				name="id" placeholder="要修改的id为" /><br> <input id="editname"
				type="text" placeholder="姓名" name="name" /> <input id="editcourse"
				type="text" placeholder="科目" name="course" /> <input type="button"
				value="确定修改" onclick="editCheckForm()" />
		</form>
	</div>
</body>
</html>