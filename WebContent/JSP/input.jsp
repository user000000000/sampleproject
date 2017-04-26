<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<%= request.getContextPath() %>/CSS/sampleStyle.css"  rel="stylesheet"  type="text/css">
		<title>入力画面</title>
	</head>
	<body>

		<% request.setAttribute("viewKbn", "1"); %>
		<%@include file="header.jsp" %>


		<div class='error'>
			<html:errors />
		</div>

		<div class='main'>
			<html:form action="/SampleAction">
				<table>
					<tr>
						<th>名前&nbsp;<font color="red" size="1" >[入力必須]</font>&nbsp;:</th>
						<td><html:text property="name" maxlength="20"/></td>
					</tr>
					<tr>
						<th>年齢&nbsp;<font color="red"  size="1">[入力必須]</font>&nbsp;:</th>
						<td><html:text property="age"  size="5" /></td>
					</tr>
					<tr>
						<th>趣味:</th>
						<td>
							<html:select property = "hobby" size = "1">
								<html:option value = "">未選択</html:option>
								<html:option value = "01">グルメ</html:option>
								<html:option value = "02">ギャンブル</html:option>
								<html:option value = "03">旅行</html:option>
								<html:option value = "04">映画鑑賞</html:option>
							</html:select>
						</td>
					</tr>
					<tr>
						<th>好きな食べ物:</th>
						<td><html:text property="favoriteFood"  maxlength="10" /></td>
					</tr>
				</table>
				<div class="button">
					<html:submit>
						<bean:message key="ok" />
					</html:submit>
				</div>
			</html:form>
		</div>

	</body>
</html:html>