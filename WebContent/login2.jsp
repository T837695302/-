<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">



function check(){

	var flag = 0;


	// 設定開始（必須にする項目を設定してください）

	if(document.form1.field1.value == ""){ // 「お名前」の入力をチェック

		flag = 1;

	}
	else if(document.form1.field2.value == ""){ // 「パスワード」の入力をチェック

		flag = 1;

	}
	else if(document.form1.field3.value == ""){ // 「コメント」の入力をチェック

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('必須項目に未入力がありました'); // 入力漏れがあれば警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}

}



</script>
<title>Insert title here</title>
</head>
<body>
<center><img src="./images/header.jpg"/></center>
<h1 align="center"><a href="all" rel="external nofollow" rel="external nofollow" >进入学員管理主页</a></h1>

<h1>Hello world!</h1>
<h2>Hello world!</h2>
<h3>Hello world!</h3>
<h4>Hello world!</h4>
<h5>Hello world!</h5>
<h6>Hello world!</h6>

<a href="http://www.apple.com/">apple</a>

<p>Hello world!</p>
<p>Hello word!<span>Hello world!</span></p>

<p>Hello.<br>I am studying HTML</p>

<form><input type="text"><br>
<input type="checkbox">
</form>
<br>
<form><input type="checkbox"></form>
<br>
<input type="radio" name="sports" value="0">baseball
<input type="radio" name="sports" value="1">soccer
</form>
<br>
<form>
<select>
<option value ="0">baseball</option>
<option value ="1">soccer</option>
<option value ="2">tennis</option>
</select>
<br>
<form>
<textarea></textarea>
</form>
<br>
<form>
<label>
<input type="checkbox">このサイドは役に立った
</label>
</form>
<br>
<form>
<input type="submit">
</form>
<br>
<p>
順序なし
<ul>
    <li>野球</li>
    <li>サッカー</li>
    <li>バレーボール</li>
</ul>
    順序あり
    <ol>
    <li>野球</li>
    <li>サッカー</li>
    <li>バレーボール</li>
    </ol>
    </p>








































</body>
</html>