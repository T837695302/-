<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>TAG index Webサイト</title>

<script type="text/javascript">
	function check() {
		window.alert('必須項目入力check Start');
		var flag = 0;

		// 設定開始（必須にする項目を設定してください）
		if (document.form1.name.value != "liu") { // 「お名前」の入力をチェック
			flag = 1;
		} else if (document.form1.password.value != "first2015") { // 「パスワード」の入力をチェック
			flag = 1;
		} else if (document.form1.commnet.value == "") { // 「コメント」の入力をチェック
			flag = 1;
		}
		if (document.form1.post1.value.match(/[^0-9]+/)) {
			flag = 1;
		} else if (document.form1.post2.value.match(/[^0-9]+/)) {
			flag = 1;
		}
		if (!document.form1.email.value.match(/.+@.+\..+/)) {
			flag = 1;
		}
		// 設定終了 if(1),if(true)
		if (flag) {
			//if(1),if(true)
			window.alert('必須項目に入力ミスがありました'); // 入力漏れがあれば警告ダイアログを表示
			return false; // 送信を中止
		} else {
			// 設定開始（チェックする項目を設定してください）

			if (!document.form1.check1.checked) {

				flag = 1;

			}

			// 設定終了
			if (flag) {

				window.alert('チェックされていません'); // チェックされていない場合は警告ダイアログを表示
				return false; // 送信を中止

			}

			return true; // 送信を実行
		}

	}
</script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.0/jquery.min.js"></script>
<script>
	$(function() {
		$('input').click(function() {
			if ($(this).val() == 2)
				alert('正解！');
			else
				alert('はずれ！');
		});
	});
</script>
</head>


<body>
	<p>あなたの好きな食べ物は？</p>
	<p>
		<input type="radio" name="food" value="1">そば <input
			type="radio" name="food" value="2">うどん <input type="radio"
			name="food" value="3">ラーメン
	</p>
	<form method="POST" action="all" name="form1" onSubmit="return check()">

		<p>
			お名前：<br> <input type="text" name="name" size="30"> （必須）
		</p>
		<p>
			パスワード：<br> <input type="password" name="password" size="30">
			（必須）
		</p>
		<p>
			コメント：<br>
			<textarea name="commnet" rows="5" cols="30"></textarea>
			（必須）
		</p>
		<p>
			〒：<input type="text" name="post1" size="4"> - <input
				type="text" name="post2" size="4"> （半角数字で）
		</p>
		<p>
			E-Mail：<input type="text" name="email" size="30">
		</p>

		<p>
			<input type="checkbox" name="check1" value="ok"> チェックしてください
		</p>
		<p>
			<input type="submit" value="送信">
		</p>

	</form>


	<p></p>



</body>
</html>

























