<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- jQuery -->
<script type="text/javascript" src="//code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="//jpostal-1006.appspot.com/jquery.jpostal.js"></script>
 <script>
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
</script>


郵便番号<br>
<input type="text" id="zip1" name="zip1"> - <input type="text" id="zip2" name="zip2"><br>
住所<br>
<input type="text" id="address" name="address">





</head>
<body>

</body>
</html>