<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>TAG index Webサイト</title>

<script type="text/javascript">
	function check() {

		var flag = 0;

		// 設定開始（チェックする項目を設定してください）

		if (document.form1.post1.value.match(/[^0-9]+/)) {

			flag = 1;

		} else if (document.form1.post2.value.match(/[^0-9]+/)) {

			flag = 1;

		}

		// 設定終了

		if (flag) {

			window.alert('数字以外が入力されています'); // 数字以外が入力された場合は警告ダイアログを表示
			return false; // 送信を中止

		} else {

			return true; // 送信を実行

		}

	}
</script>

</head>
<body>

	<form method="POST" action="example.cgi" name="form1"
		onSubmit="return check()">

		<p>
			〒：<input type="text" name="post1" size="4"> - <input
				type="text" name="post2" size="4"> （半角数字で）
		</p>
		<p>
			<input type="submit" value="送信">
		</p>

	</form>

</body>
</html>