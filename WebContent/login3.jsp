<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TAG index Webサイト<script type="text/javascript">

function check(){

	if(window.confirm('送信してよろしいですか？')){ // 確認ダイアログを表示

		return true; // 「OK」時は送信を実行

	}
	else{ // 「キャンセル」時の処理

		window.alert('キャンセルされました'); // 警告ダイアログを表示
		return false; // 送信を中止

	}

}

</script><script type="text/javascript">

function check(){

	if(window.confirm('リセットしてもよろしいですか？')){ // 確認ダイアログを表示

		return true; // 「OK」時はリセットを実行

	}
	else{ // 「キャンセル」時の処理

		window.alert('キャンセルされました'); // 警告ダイアログを表示
		return false; // リセットを中止

	}

}


</script></title><script type="text/javascript">

function check(){

	var flag = 0;


	// 設定開始（チェックする項目を設定してください）

	if(!document.form1.email.value.match(/.+@.+\..+/)){

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('メールアドレスが正しくありません'); // メールアドレス以外が入力された場合は警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}

}

</script><script type="text/javascript">

function check(){

	var flag = 0;


	// 設定開始（チェックする項目を設定してください）

	if(document.form1.post1.value.match(/[^0-9]+/)){

		flag = 1;

	}
	else if(document.form1.post2.value.match(/[^0-9]+/)){

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('数字以外が入力されています'); // 数字以外が入力された場合は警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}

}

</script><script type="text/javascript">

function out(){

	var docdata = document.form1.field1.value;

	parent.main.document.open(); // 書き出しを開始

	parent.main.document.write('<html>\n');
	parent.main.document.write('<head><title>書き出しのテスト</title></head>\n');
	parent.main.document.write('<body>\n');
	parent.main.document.write('<p>' + docdata + '</p>\n');
	parent.main.document.write('</body>\n');
	parent.main.document.write('</html>');

	parent.main.document.close(); // 書き出しを終了

}
</script>

<script type="text/javascript">

function check(){

	var flag = 0;


	// 設定開始（チェックする項目を設定してください）

	if(document.form1.question1.length) { // 選択肢が複数ある場合

		flag = 1;
		var i;

		for(i = 0; i < document.form1.question1.length; i ++){

			if(document.form1.question1[i].checked){

				flag = 0; break;

			}

		}

	}
	else{ // 選択肢が1つだけの場合

		if(!document.form1.question1.checked){

			flag = 1;

		}

	}

	// 設定終了


	if(flag){

		window.alert('選択されていません'); // 選択されていない場合は警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}

}

</script><script type="text/javascript">


// パターン1の色設定開始
function color1(){

	document.bgColor = "#eeeeff"; // bgcolor：背景色
	document.fgColor = "#0080ff"; // text：文字の基本色
	document.linkColor = "#ff0000"; // link：リンク文字の色
	document.vlinkColor = "#ff0000"; // vlink：リンク文字の色（アクセス済みのリンク）
	document.alinkColor = "#ff8000"; // alink：リンク文字の色（クリックした瞬間の色）

}
// パターン1の色設定終了

// パターン2の色設定開始
function color2(){

	document.bgColor = "#fbeae6";
	document.fgColor = "#ff0000";
	document.linkColor = "#ff00ff";
	document.vlinkColor = "#ff00ff";
	document.alinkColor = "#ff8000";

}
// パターン2の色設定終了

</script><script type="text/javascript">


// 設定開始（メッセージの内容と動きを設定してください）

var msg = 'メッセージをスクロールさせてみます・・・・・・・・・・・・・・・・'; // メッセージ内容
var speed = 300; // スクロールのスピード（1に近いほど速く）
var move = 2; // スクロールのなめらかさ（1に近いほどなめらかに）

// 設定終了


function disp(){

	msg = msg.substring(move, msg.length) + msg.substring(0, move);

	// テキストフィールドにデータを渡す処理
	document.form1.field1.value = msg;

	setTimeout("disp()", speed);

}


</script>

<script type="text/javascript">

function check(){

	var flag = 0;


	// 設定開始（チェックする項目を設定してください）

	if(document.form1.select1.options[document.form1.select1.selectedIndex].value == ""){

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('選択されていません'); // 選択されていない場合は警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}

}

</script></head>
<script type="text/javascript">


function check(){

	var flag = 0;


	// 設定開始（チェックする項目を設定してください）

	if(!document.form1.check1.checked){

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('チェックされていません'); // チェックされていない場合は警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}

}

</script><body onLoad="disp()">

<form action="#" name="form1">
<input type="text" name="field1" size="30">
</form>



<p>
<input type="button" value="パターン1" onClick="color1()">
<input type="button" value="パターン2" onClick="color2()">
</p>




<form action="#" name="form1">
<p><input type="text" name="field1" size="50">
<input type="button" value="書き出す" onClick="out()"></p>
</form>

<p><input type="button" value="印刷する" onClick="print()"></p>

<p><input type="button" value="お気に入りの追加" onClick="window.external.AddFavorite('https://www.tagindex.com/','TAG index')"></p>



<form method="POST" action="example.cgi" name="form1" onSubmit="return check()">

<p>〒：<input type="text" name="post1" size="4"> - <input type="text" name="post2" size="4"> （半角数字で）</p>
<p><input type="submit" value="送信"></p>

</form>



<form method="POST" action="example.cgi" name="form1" onSubmit="return check()">

<p>E-Mail：<input type="text" name="email" size="30"></p>
<p><input type="submit" value="送信"></p>

</form>

<form method="POST" action="example.cgi" name="form1" onSubmit="return check()">

<p><input type="checkbox" name="check1" value="ok"> チェックしてください</p>
<p><input type="submit" value="送信"></p>

</form>


<form method="POST" action="example.cgi" name="form1" onSubmit="return check()">

<p>
<input type="radio" name="question1" value="yes">はい
<input type="radio" name="question1" value="no">いいえ
<input type="radio" name="question1" value="other">その他
</p>

<p><input type="submit" value="送信"></p>

</form>


<form method="POST" action="example.cgi" name="form1" onSubmit="return check()">

<p><select name="select1">
<option value="">選択してください
<option value="sample1">選択サンプル1
<option value="sample2">選択サンプル2
<option value="sample3">選択サンプル2
</select></p>

<p><input type="submit" value="送信"></p>

</form>



<form method="POST" action="example.cgi" onSubmit="return check()">

<p>お名前：<input type="text" name="field1" size="25"></p>
<p><input type="submit" value="送信"></p>

</form>






</body>
</html>