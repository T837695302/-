<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<script type="text/javascript">
    /**
     * [関数名] ZeroShift
     * [機　能] ゼロ詰め
     * [説　明] 数値の先頭からゼロを除去
     * [引　数]
     * @param  frm   フォームオブジェクト
     * @return ゼロ除去後の文字列をテキストボックス(after)に表示
    */
    function ZeroShift(frm){
        var tmpBefore=frm.before.value;
        var rep = new RegExp("^0+0?");
        return frm.elements["after"].value=tmpBefore.replace(rep,"");
    }
</script>
<script type="text/javascript">
    /**
     * [関数名] ZeroFormat
     * [機　能] ゼロ埋め
     * [説　明] 数値が指定した桁数になるまで数値の先頭をゼロで埋める
     *
     * @param  integer num    数値
     * @param  integer max    桁数
     * @return integer tmpS   ゼロ埋め後の数値
    */
    function ZeroFormat(num,max){
        var tmp=""+num;
        while(tmp.length<max){
            tmp="0"+tmp;
        }
        return tmp;
    }
    /*
    例：document.write(ZeroFormat(1,4)); //0001
    */
</script>
<script type="text/javascript">
    /**
     * [関数名] chkMaxLength
     * [機　能] 入力文字数チェック
     * [説　明] 文字列の文字数を調べ、最大文字数以内で入力されているか調べる
     *　　　　　半角、全角、改行（\n）は1文字としてカウントされる
     * [引　数]
     * @param obj フォームオブジェクト
     * @param strLength 最大文字数
     * [返り値]
     * @return なし
    */
    function chkMaxLength(obj, strLength) {
        var tmpLength=obj.value.length;//入力された文字列の長さ（文字数）
        if(tmpLength > strLength) {
            /* 入力文字数が最大文字数を超えている場合 */
            alert(tmpLength+"文字 &gt; 最大"+strLength+"文字\n\n最大文字数を超えています");
        }else if(tmpLength == strLength){
            /* 入力文字数と最大文字数が等しい場合 */
            alert(tmpLength+"文字 == 最大"+strLength+"文字\n\nこれ以上入力できません");
        }else{
            /* 入力文字数が最大文字数に満たない場合 */
            alert(tmpLength+"文字 &lt; 最大"+strLength+"文字\n\nまだ入力できます");
        }
    }
</script>
<script type="text/javascript">
    /**
     * [関数名] isZenKana
     * [機　能] 全角ナチェック
     * [説　明] 文字列の中に全角カナが含まれるか調べる
     * [引　数]
     * @param  obj テキストボックスオブジェクト
     * [返り値]
     * @return true(含まれている) | false(含まれていない)
    */
    var zen="アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンァィゥェォッャュョ";

    function isZenKana(obj) {
        var str=obj.value; /* 入力値 */
        var mes="";
        for (var i=0; i<str.length; i++) {
            /* 文字列を１文字ずつ調べる */
            var tmp1=str.substr(i,1);
            for (var j=0; j<zen.length; j++) {
                var tmp2=zen.substr(j,1);
                /* 含まれていた全角カナを格納 */
                if (tmp1==tmp2) {
                    mes+="「"+tmp1+"」";
                }
            }
        }
        if(mes!=""){
            /* 全角カナが含まれている場合 */
            alert (mes+"\n\n全角カナが含まれています");
            return true;
        }else{
            /* 全角カナが含まれていない場合 */
            alert ("全角カナは含まれていません。");
            return false;
        }
    }
</script>
<script type="text/javascript">
    /**
     * [関数名] isHanNumAlpha
     * [機　能] 半角英数字チェック
     * [説　明] 文字列の中に半角英数字（0-9,a-z,A-Z）以外の文字が含まれているか調べる
     * 　　　　 半角スペースも半角英数字とみなす
     * [引　数]
     * @param  obj テキストボックスオブジェクト
     * [返り値]
     * @return true(含まれていない) | false(含まれている)
    */
    function isHanNumAlpha(obj){
        var str = obj.value; /* 入力値 */
        for (var i=0 ; i<str.length; i++) {
            var code=str.charCodeAt(i);
            /* 文字コードでチェック */
            if ((48<=code && code<=57) ||
                (65<=code && code<=90) || (97<=code && code<=122) ||
                 str.substr(i,1)==" ") {
                /* 半角数字（0-9）の文字コード範囲 */
                /* 半角英字（a-z,A-Z）の文字コード範囲 */
                /* 半角スペースも許容 */
            }else{
                alert("半角英数字以外が含まれています");
                return false;
            }
        }
        alert("全て半角英数字です");
        return true;
    }
</script>
<script type="text/javascript">
    /**
     * [関数名] isHanAlpha
     * [機　能] 半角英字チェック
     * [説　明] 文字列の中に半角英字（a-z,A-Z）以外の文字が含まれているか調べる
     *　　　　　半角スペースも半角英字とみなす
     * [引　数]
     * @param  obj テキストボックスオブジェクト
     * @return true(含まれていない) | false(含まれている)
    */
    function isHanAlpha(obj){
        var str=obj.value; /* 入力値 */
        for(var i=0 ; i<str.length; i++){
            var code=str.charCodeAt(i);
            if ((65<=code && code<=90) || (97<=code && code<=122) ||
                 str.substr(i,1)==' ') {
                /* 半角英字（a-z,A-Z）の文字コード範囲 */
                /* 半角スペースも許容 */
            }else{
                alert("半角英字以外が含まれています");
                return false;
            }
        }
        alert("全て半角英字です");
        return true;
    }
</script>
<script type="text/javascript">
    /**
     * [関数名] isZen
     * [機　能] 全角チェック
     * [説　明] 文字列の中に全角以外の文字が含まれているか調べる
     * 　　　　 全角スペースも全角とみなす
     * [引　数]
     * @param obj テキストボックスオブジェクト
     * [返り値]
     * @return true(含まれていない) | false(含まれている)
    */
    function isZen(obj){
        var str=obj.value; /* 入力値 */
        for(var i=0; i<str.length; i++){
            /* 1文字ずつ文字コードをエスケープし、その長さが4文字以上なら全角 */
            var len=escape(str.charAt(i)).length;
            if(len>=4){
                alert("全角文字が含まれています");
                return false;
            }
        }
        alert("全角文字は含まれていません");
        return true;
    }
</script>




</head>
<body>
<center><img src="./images/header.jpg"/></center>

<h1 align="center"><a href="all" rel="external nofollow" rel="external nofollow" >进入学員管理主页</a></h1>
<h1 align="center"><a href="allTeac" rel="external nofollow" rel="external nofollow" >进入先生管理主页</a></h1>
<form action="#">
    <p>
        ゼロ除去前：<input type="text" name="before" value="00000050" size="20" maxlength="10" />
    </p>
    <p>
        　　　　　　　　<input type="button" onclick="this.form.after.value=ZeroShift(this.form)" value="ゼロ詰め" />
    </p>
    <p>
        ゼロ除去後：<input type="text" name="after" size="20" maxlength="10" />
    </p>
</form>
<form action="#">
    <p>
        ゼロ埋め前：<input type="text" name="before" value="5" size="12" maxlength="10" />
        桁数：<input type="text" name="n" size="2" maxlength="2" value="4" />
    </p>
    <p>
        　　　　　　　　<input type="button" onclick='this.form.elements["after"].value=ZeroFormat(this.form.elements["before"].value,this.form.elements["n"].value)' value="ゼロ埋め" />
    </p>
    <p>
        ゼロ詰め後：<input type="text" name="after" size="40" maxlength="256" />
    </p>
</form>
<form action="#">
    <strong>最大5文字まで入力可</strong>
    <p>
        <!-- テキストボックスの例 -->
        <input type="text" name="txt" value="あiうえお" />
        <input type="button" onclick="chkMaxLength(this.form.txt, 5)" value="文字数チェック" />
    </p>
    <p>
        <!-- テキストエリアの例（改行も1文字としてカウントされる） -->
        <textarea name="area" cols="50" rows="5">あiうえ
お</textarea>
        <input type="button" onclick="chkMaxLength(this.form.area, 5)" value="文字数チェック" />
    </p>
</form>
<form action="#">
    <input type="text" name="txt" value="あイうｴおカキｸけコ" maxlength="20" />
    <input type="button" onclick="isZenKana(this.form.txt)" value="全角カナチェック" />
</form>
<form action="#">
    <input type="text" name="txt" value="abc123" />
    <input type="button" onclick="isHanNumAlpha(this.form.txt)" value="半角英数字チェック" />
</form>
<form action="#">
    <input type="text" name="txt" value="abcABC" />
    <input type="button" onclick="isHanAlpha(this.form.txt)" value="半角英字チェック" />
</form>
<form action="#">
    <input type=text name="txt" value="ｱｲｳエｵ" />
    <input type="button" onclick="isZen(this.form.txt)" value="全角チェック" />
</form>


</body>
</html>

