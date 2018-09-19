<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>TAG index Webサイト</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.0/jquery.min.js"></script>
	<script>
$(function() {
  var page = 0;
  function draw() {
    $('#page').html(page + 1);
    $('tr').hide();
    $('tr:first,tr:gt(' + page * 10 + '):lt(10)').show();
  }
  $('#prev').click(function() {
    if (page > 0) {
      page--;
      draw();
    }
  });
  $('#next').click(function() {
    if (page < ($('tr').size() - 1) / 10 - 1) {
      page++;
      draw();
    }
  });
  draw();
});
</script>
<style>
td, th {
  border: 1px solid black;
  padding: 2px;
}
#prev, #next {
  color: red;
  cursor: pointer;
}
</style>


</head>

<body>
<span id="prev">＜</span>　<span id="page"></span>　<span id="next">＞</span>
<table>
<tr><th>名前</th><th>消費ＭＰ</th></tr>
<tr><td>メラ</td><td>2</td></tr>
<tr><td>メラミ</td><td>6</td></tr>
<tr><td>リレミト</td><td>3</td></tr>
<tr><td>トラマナ</td><td>2</td></tr>
<tr><td>メラ</td><td>2</td></tr>
<tr><td>メラミ</td><td>6</td></tr>
<tr><td>リレミト</td><td>3</td></tr>
<tr><td>トラマナ</td><td>2</td></tr>
<tr><td>メラ</td><td>2</td></tr>
<tr><td>メラミ</td><td>6</td></tr>
<tr><td>リレミト</td><td>3</td></tr>
<tr><td>トラマナ</td><td>2</td></tr>
<tr><td>メラ</td><td>2</td></tr>
<tr><td>メラミ</td><td>6</td></tr>
<tr><td>リレミト</td><td>3</td></tr>
<tr><td>トラマナ</td><td>2</td></tr>
<tr><td>メラ</td><td>2</td></tr>
<tr><td>メラミ</td><td>6</td></tr>
<tr><td>リレミト</td><td>3</td></tr>
<tr><td>トラマナ</td><td>2</td></tr>
</table>
</body>
</html>