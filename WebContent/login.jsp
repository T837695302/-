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
  var prefs = [
    ['北海道', 43.03, 141.21],
    ['青森県', 40.49, 140.44],
    ['岩手県', 39.42, 141.09],
    ['宮城県', 38.16, 140.52],
    ['秋田県', 39.43, 140.06],
    ['山形県', 38.15, 140.20],
    ['福島県', 37.45, 140.28],
    ['茨城県', 36.22, 140.28],
    ['栃木県', 36.33, 139.53],
    ['群馬県', 36.23, 139.03],
    ['埼玉県', 35.51, 139.38],
    ['千葉県', 35.36, 140.06],
    ['東京都', 35.41, 139.45],
    ['神奈川県', 35.26, 139.38],
    ['新潟県', 37.55, 139.02],
    ['富山県', 36.41, 137.13],
    ['石川県', 36.33, 136.39],
    ['福井県', 36.03, 136.13],
    ['山梨県', 35.39, 138.34],
    ['長野県', 36.39, 138.11],
    ['岐阜県', 35.25, 136.45],
    ['静岡県', 34.58, 138.23],
    ['愛知県', 35.11, 136.54],
    ['三重県', 34.43, 136.30],
    ['滋賀県', 35.00, 135.52],
    ['京都府', 35.00, 135.46],
    ['大阪府', 34.41, 135.29],
    ['兵庫県', 34.41, 135.11],
    ['奈良県', 34.41, 135.48],
    ['和歌山県', 34.14, 135.10],
    ['鳥取県', 35.29, 134.13],
    ['島根県', 35.27, 133.04],
    ['岡山県', 34.39, 133.54],
    ['広島県', 34.23, 132.27],
    ['山口県', 34.11, 131.27],
    ['徳島県', 34.03, 134.32],
    ['香川県', 34.20, 134.02],
    ['愛媛県', 33.50, 132.44],
    ['高知県', 33.33, 133.31],
    ['福岡県', 33.35, 130.23],
    ['佐賀県', 33.16, 130.16],
    ['長崎県', 32.45, 129.52],
    ['熊本県', 32.48, 130.42],
    ['大分県', 33.14, 131.37],
    ['宮崎県', 31.56, 131.25],
    ['鹿児島県', 31.36, 130.33],
    ['沖縄県', 26.13, 127.41]
  ];

  navigator.geolocation.getCurrentPosition(function(pos) {
    var lat = pos.coords.latitude;
    var long = pos.coords.longitude;
    $.each(prefs, function(i, p) {
      p[3] = (lat - p[1]) * (lat - p[1]) + (long - p[2]) * (long - p[2]);
    });
    prefs.sort(function(p1, p2) {
      return p1[3] - p2[3];
    });
    $.each(prefs, function(i, p) {
      $('<option></option>').html(p[0]).appendTo('#pref');
    });
  });
});
</script>
<script>
$(function() {
  $('#block').click(function() {
    $('#shim').css({
      backgroundColor: 'black',
      position: 'absolute',
      display: 'block',
      left: 0,
      top: 0,
      opacity: 0.5,
      width: $(document).width(),
      height: $(document).height()
    });
    $(window).on('resize.shim', function() {
      $('#shim').css({
        width: $(document).width(),
        height: $(document).height()
      });
    });
  });
  $('#shim').click(function() {
    $(this).css({display: 'none'});
    $(window).off('resize.shim');
  });
});
</script>

<script>
$(function() {
  $('#start').click(function() {
    $(this).hide();

    // 変数初期化
    var FLEN = 16;                  // フィールドの大きさ
    var px = 0, py = 1;             // プレイヤー座標
    var pd = 1;                     // プレイヤー方向(0:上 1:右 2:下 3:左)
    var score = 0;                  // 得点

    // フィールドを表示する。
    var field = '';
    for (var y = 0; y < FLEN; y++) {
      for (var x = 0; x < FLEN; x++) {
        field += '<span id="field_' + x + '_' + y + '">';
        if (x == 0 || x == FLEN - 1 || y == 0 || y == FLEN - 1) field += '■';
        else field += '□';
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
      if (pd == 0) py--;
      else if (pd == 1) px++;
      else if (pd == 2) py++;
      else px--;
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
$(function() {
  $('a').click(function() {
    var NUM = 5;                    // チェックボックス数
    var SIZE = 200;                 // ステージの大きさ
    var count = 0;                  // 現在チェックされている数
    var st = new Date().getTime();  // 開始時間
    $('body').empty();

    // チェックボックスの新しい位置を返す。
    function newPos() {
      return {
        left: Math.floor(Math.random() * SIZE),
        top: Math.floor(Math.random() * SIZE)
      };
    }

    // チェックボックスの生成・アニメーションの設定
    for (var i = 0; i < NUM; i++) {
      $('<input type="checkbox">')
      .appendTo('body')
      .css('position', 'absolute')
      .css(newPos())
      .each(function() {
        $(this).animate(newPos(), 3000, arguments.callee);
      });
    }

    // チェックボックスが押されたときの処理
    $('input').click(function() {
      $(this).stop().attr('disabled', 'disabled');
      var t = (new Date().getTime() - st) / 1000;
      if (++count >= NUM) alert('クリア！所要時間：' + t + '秒');
    });

    return false;
  });
});
</script>

</head>

<body>
<select id="pref"></select>
<br>
<a href="#" id="block">ブロック！</a>
<div id="shim"></div>
<div id="field"></div>
<p><a id="start" href="javascript:void(0)">スタート</a> 得点：<span id="score"></span></p>
<a href="#">素早く全てクリックするのだ！</a>


</body>
</html>