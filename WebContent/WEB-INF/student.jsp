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
  <!-- DataTables -->
</head>
<body>
	<img src="./images/header.jpg" /> ${msg}
	<h1 align="center">先生信息管理</h1>

	<div id="all_comm" class="all">
		<h2 align="center">先生信息一览</h2>
		<table id="table_id" border="8">
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
</body>
</html>