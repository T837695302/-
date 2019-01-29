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
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
</head>
<body>
	<img src="./images/header.jpg" /> ${msg}
	<h1 align="center">先生信息管理</h1>


		<div>
		<h2 align="center">先生信息一览</h2>
		<table id="table_id">
			<tr>
				<td>id</td>
				<td>name</td>
				<td>course</td>
			</tr>

			<c:forEach items="${teachers}" var="teacher">
				<tr>
				<td id="${teacher.id }">${teacher.id}</td>
					<td id="${teacher.id }">${teacher.name}</td>
					<td id="${teacher.id}">${teacher.course}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="add_comm" class="all" align="left">
	  <h2>查找</h2>
	  <form action="queryByid" method="post" >
		<input type="text" placeholder="id" name="id" >
		<input type="submit" value="查找" >
	  </form>


</div>
</body>
</html>