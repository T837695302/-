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
		$('input').click(function() {
			if ($(this).val() == 2)
				alert('正解！');
			else
				alert('はずれ！');
		});
	});
</script>
<script>
	$(function() {
		$('#answer').hover(function() {
			$('span').hide();
		}, function() {
			$('span').show();
		});
	});
</script>
<script>
	$(function() {
		$('#start').click(function() {
			$(this).hide();

			// 変数初期化
			var FLEN = 16; // フィールドの大きさ
			var px = 0, py = 1; // プレイヤー座標
			var pd = 1; // プレイヤー方向(0:上 1:右 2:下 3:左)
			var score = 0; // 得点

			// フィールドを表示する。
			var field = '';
			for (var y = 0; y < FLEN; y++) {
				for (var x = 0; x < FLEN; x++) {
					field += '<span id="field_' + x + '_' + y + '">';
					if (x == 0 || x == FLEN - 1 || y == 0 || y == FLEN - 1)
						field += '■';
					else
						field += '□';
					field += '</span>';
				}
				field += '<br>';
			}
			$('#field').html(field);

			// マウス押下時に移動方向を時計回りに90度動かす。
			$(document).mousedown(function() {
				pd = (pd + 1) % 4;
				return false;
			})

			// 100ms毎に繰り返し
			var id = setInterval(function() {
				// 移動と当たり判定
				if (pd == 0)
					py--;
				else if (pd == 1)
					px++;
				else if (pd == 2)
					py++;
				else
					px--;
				var item = $('#field_' + px + '_' + py);
				if (item.html() == '□') {
					score++;
					$('#score').html(score);
				} else {
					clearInterval(id);
					$('#start').show();
				}
				item.html('●');
			}, 100);
		});
	});
</script>
<script>
	var sel = -1; // 現在選択されているピース番号
	var pos = []; // 各ピースの現在位置

	$(function() {
		for (var i = 0; i < 16; i++)
			pos[i] = i;
		// シャッフルする。
		for (var i = 16; i > 0; i--) {
			var j = Math.floor(Math.random() * i);
			swap(i - 1, j);
		}

		// ピースを配置する。
		for (var i = 0; i < 16; i++) {
			$('<div id="piece' + i + '" class="piece"></div>').css({
				backgroundPosition : '-' + getx(i) + 'px -' + gety(i) + 'px',
				left : getx(pos[i]),
				top : gety(pos[i])
			}).appendTo($('body'));
		}

		// ピースをクリックしたとき
		$('.piece').click(function() {
			var no = this.id.substring(5);
			if (sel == no) {
				// 自分自身が選択されているときは選択をキャンセルする。
				$(this).fadeTo(100, 1);
				sel = -1;
			} else if (sel == -1) {
				// 何も選択されていないときは選択する。
				$(this).fadeTo(100, 0.5);
				sel = no;
			} else {
				// 他のピースが選択されているときは入れ替える。
				swap(no, sel);
				$('#piece' + sel).fadeTo(100, 1).animate({
					left : getx(pos[sel]),
					top : gety(pos[sel])
				});
				$(this).animate({
					left : getx(pos[no]),
					top : gety(pos[no])
				}, function() {
					// アニメーション終了時にクリア判定する。
					var clear = true;
					for (var i = 0; i < 16; i++)
						if (pos[i] != i)
							clear = false;
					if (clear)
						alert("クリア！");
				});
				sel = -1;
			}
		});
	});

	// ピースの番号から座標を得る。
	function getx(n) {
		return (n % 4) * 80;
	}
	function gety(n) {
		return Math.floor(n / 4) * 80;
	}

	// ピースの配列を入れ替える。
	function swap(i, j) {
		var tmp = pos[i];
		pos[i] = pos[j];
		pos[j] = tmp;
	}
</script>
<style>
.piece {
	S width: 80px;
	height: 80px;
	background-image: url('./images/pict.jpg');
	position: absolute;
}
</style>

<script>
	$(function() {
		$('a').click(
				function() {
					var NUM = 5; // チェックボックス数
					var SIZE = 200; // ステージの大きさ
					var count = 0; // 現在チェックされている数
					var st = new Date().getTime(); // 開始時間
					$('body').empty();

					// チェックボックスの新しい位置を返す。
					function newPos() {
						return {
							left : Math.floor(Math.random() * SIZE),
							top : Math.floor(Math.random() * SIZE)
						};
					}

					// チェックボックスの生成・アニメーションの設定
					for (var i = 0; i < NUM; i++) {
						$('<input type="checkbox">').appendTo('body').css(
								'position', 'absolute').css(newPos()).each(
								function() {
									$(this).animate(newPos(), 3000,
											arguments.callee);
								});
					}

					// チェックボックスが押されたときの処理
					$('input').click(function() {
						$(this).stop().attr('disabled', 'disabled');
						var t = (new Date().getTime() - st) / 1000;
						if (++count >= NUM)
							alert('クリア！所要時間：' + t + '秒');
					});

					return false;
				});
	});
</script>

<script>
	$(function() {
		var round = 0;
		var remain;
		var field = [ [ 1, "●○●○○" ], [ 1, "●○○○●○●" ], [ 2, "●○●○●○●○●" ],
				[ 2, "●○●●○●●●○" ], [ 2, "●●○●●○○●●●○●○●●" ] ];

		// 面の開始
		function start() {
			remain = field[round][0];
			$('#field').html($.map(field[round][1].split(''), function(i) {
				return '<div>' + i + '</div>';
			}).join(''));

			$('#round').text(round + 1);
			$('#remain').text(remain);
		}
		start();

		$('#field').sortable({
			axis : 'x',
			update : function(e, u) {
				// 裏返す
				var color = u.item.text();
				$.each([ 'prev', 'next' ], function(i, dir) {
					var rev = false;
					(function(item) {
						if (item.length < 1)
							return;
						if (item.text() == color)
							rev = true;
						else
							arguments.callee(item[dir]());
						if (rev)
							item.text(color);
					})(u.item[dir]());
				});

				// クリアチェック
				$('#remain').text(--remain);
				if (!$('#field div').is(':contains("○")')) {
					if (++round >= field.length) {
						alert("オールクリア！");
					} else {
						alert("クリア！");
						start();
					}
				}

				// ゲームオーバーチェック
				if (remain <= 0) {
					$('#field').sortable('destroy');
					alert("ゲームオーバー");
				}
			}
		});
	});
</script>
<style>
div {
	float: left;
	cursor: pointer;
}
</style>
</head>


<body>
	<p>あなたの好きな食べ物は？</p>
	<p>
		<input type="radio" name="food" value="1">そば <input
			type="radio" name="food" value="2">うどん <input type="radio"
			name="food" value="3">ラーメン
	</p>


	<p>
		たぬき暗号（<em id="answer">ここにマウスを重ねると解読します</em>）
	</p>
	<p>
		ぼ<span>た</span>く<span>た</span>はき<span>た</span>みをあ<span>た</span>いしていま<span>た</span>す<span>た</span>。
	</p>
	<div id="field"></div>
	<p>
		<a id="start" href="javascript:void(0)">スタート</a> 得点：<span id="score"></span>
	</p>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href="#">素早く全てクリックするのだ！</a>
	<p>
		全て●にせよ！ 第<span id="round"></span>面 残り<span id="remain"></span>手
	</p>
	<div id="field"></div>
</body>
</html>

























