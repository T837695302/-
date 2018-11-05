<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TAG index Webサイト</title>

<script type="text/javascript">
	function keisan() {

		// 設定開始

		// 商品1
		var price1 = document.form1.goods1.options[document.form1.goods1.selectedIndex].value;

		// 商品2
		var price2 = document.form1.goods2.options[document.form1.goods2.selectedIndex].value;

		// 商品3
		var price3 = document.form1.goods3.options[document.form1.goods3.selectedIndex].value;

		// 合計を計算
		var total = parseInt(price1) + parseInt(price2) + parseInt(price3);

		// 設定終了

		document.form1.field_total.value = total; // 合計を表示

	}
</script>

</head>
<body>

	<form action="#" name="form1">

		<table>
			<tr>
				<th>商品名</th>
				<th>タイプ</th>
			</tr>
			<tr>
				<td>商品サンプル1</td>
				<td><select name="goods1" onChange="keisan()">
						<option value="0">タイプを選択してください</option>
						<option value="500">タイプ1（500円）</option>
						<option value="1000">タイプ2（1,000円）</option>
						<option value="1500">タイプ3（1,500円）</option>
				</select></td>
			</tr>
			<tr>
				<td>商品サンプル2</td>
				<td><select name="goods2" onChange="keisan()">
						<option value="0">タイプを選択してください</option>
						<option value="500">タイプ1（500円）</option>
						<option value="1000">タイプ2（1,000円）</option>
						<option value="1500">タイプ3（1,500円）</option>
				</select></td>
			</tr>
			<tr>
				<td>商品サンプル3</td>
				<td><select name="goods3" onChange="keisan()">
						<option value="0">タイプを選択してください</option>
						<option value="500">タイプ1（500円）</option>
						<option value="1000">タイプ2（1,000円）</option>
						<option value="1500">タイプ3（1,500円）</option>
				</select></td>
			</tr>
			<tr>
				<td align="right"><strong>合計</strong></td>
				<td><input type="text" name="field_total" size="8" value="0">
					円</td>
			</tr>
		</table>

	</form>

</body>
</html>