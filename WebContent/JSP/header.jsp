<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// フォントカラー
String cr1="";
String cr2="";
String cr3="";
String cr4="";
// 表示画面名
String viewName="";

// どの画面からインクルードされているのか、区分値を取得
String viewKbn = (String) request.getAttribute("viewKbn");
viewKbn = viewKbn == null ? "":viewKbn;

// 区分値を元に、表示する内容を決定する
if("1".equals(viewKbn)){// 入力画面
	cr1="#adff2f";
	cr2="#9acd32";
	cr3="#6b8e23";
	cr4="#006400";
	viewName = "入力画面";
}else if("2".equals(viewKbn)){// 確認画面
	cr1="#ffc0cb";
	cr2="#ff69b4";
	cr3="#ff1493";
	cr4="#c71585";
	viewName = "確認画面";
}else if("3".equals(viewKbn)){// 完了画面
	cr1="#b0e0e6";
	cr2="#87cefa";
	cr3="#1e90ff";
	cr4="#0000cd";
	viewName = "完了画面";
}

%>

		<div class='header'>
			<font color="<%=cr1%>">■</font>
			<font color="<%=cr2%>">■</font>
			<font color="<%=cr3%>">■</font>
			<font color="<%=cr4%>">【<%=viewName%>】</font>
			<font color="<%=cr3%>">■</font>
			<font color="<%=cr2%>">■</font>
			<font color="<%=cr1%>">■</font>
		</div>

