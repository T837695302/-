<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>管理</title>
<link rel="stylesheet" type="text/css" href="./css/all.css" />
<style type="text/css">
</style>
 <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
  <!-- jQuery -->
  <!-- DataTables -->
</head>
<body>
	<img src="./images/header.jpg" />

<table cellspacing="0px" cellspadding="0px" width="300">
		<table id="table_id" border="8">
			<tr>
				<td>id</td>
				<td>name</td>
				<td>weight</td>

			</tr>

			<c:forEach items="${pros}" var="pro">
				<tr>
					<td id="${pro.id}">${pro.id}</td>
					<td id="${pro.id}">${pro.name}</td>
					<td id="${pro.id}">${pro.weight}</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>