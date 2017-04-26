<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<%= request.getContextPath() %>/CSS/sampleStyle.css"  rel="stylesheet"  type="text/css">
		<title>確認画面</title>
	</head>
	<body>

		<% request.setAttribute("viewKbn", "2"); %>
		<%@include file="header.jsp" %>

		<div class="main">

			<html:form action="/Cancel">
			<!-- writeタグを利用してFormクラスの内容を表示する  -->
				<table>
					<tr>
						<th>名前:</th>
						<td><bean:write name="SampleForm" property="name" /></td>
					</tr>
					<tr>
						<th>年齢:</th>
						<td><bean:write name="SampleForm" property="age" />歳</td>
					</tr>
					<tr>
						<th>趣味:</th>
						<td>
							<logic:notEmpty name="SampleForm" property="hobbyLabel">
								<bean:write name="SampleForm" property="hobbyLabel" />
							</logic:notEmpty>
							<logic:empty name="SampleForm" property="hobbyLabel">
								---
							</logic:empty>
						</td>
					</tr>
					<tr>
						<th>好きな食べ物:</th>
						<td>
							<logic:notEmpty name="SampleForm" property="favoriteFood" >
								<bean:write name="SampleForm" property="favoriteFood" />
							</logic:notEmpty>
							<logic:empty name="SampleForm" property="favoriteFood" >
								---
							</logic:empty>
						</td>
					</tr>
				</table>

				<html:hidden property="name" />
				<html:hidden property="age" />
				<html:hidden property="hobby" />
				<html:hidden property="favoriteFood" />

				<div class="button">
					<html:cancel value="戻る" />
					<html:submit property = "finish" value = "終了" />
				</div>
			</html:form>
		</div>
	</body>
</html:html>