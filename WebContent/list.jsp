<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Link rel="stylesheet" type="text/css" href="style/style.css" />
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>

<script type="text/javascript">
	//动态时间
	function time() {
		date = new Date();
		year = date.getFullYear();
		month = date.getMonth() + 1;
		if (month < 10) {
			month = "0" + month;
		}
		day = date.getDate();
		if (day < 10) {
			day = "0" + day;
		}
		hours = date.getHours();
		if (hours < 10) {
			hours = "0" + hours;
		}
		minutes = date.getMinutes();
		if (minutes < 10) {
			minutes = "0" + minutes;
		}
		seconds = date.getSeconds();
		if (seconds < 10) {
			seconds = "0" + seconds;
		}
		$("#showtime").html(
				"现在是:" + year + "-" + month + "-" + day + "\t" + hours + ":"
						+ minutes + ":" + seconds);

	}
	setInterval("time()", 1000);
</script>
</head>
<BODY>
	<DIV>
		<IMG src="image/logo.png" style="width: 200px; height: 50px">
		<div  id="showtime" align="right"></div>
	</DIV>
	<!--      用户信息、登录、注册        -->

	<DIV class="h">
		<c:if test="${not empty user}">
			恭喜  ${user.membername} 登录
		</c:if>

		<c:if test="${empty user}">
			您尚未　<a href="login.jsp">登录</a>
		&nbsp;| &nbsp; <A href="reg.jsp">注册</A> |
		</c:if>
	</DIV>


	<!--      主体        -->
	<DIV>
		<!--      导航        -->
		<br />
		<DIV>
			&gt;&gt;<B><a href="IndexServlet">论坛首页</a></B>&gt;&gt; <B><a
					href="ListServlet?bid=${board.boardid}">${board.boardName}</a></B>
		</DIV>
		<br />
		<!--      新帖        -->
		<DIV>
		<c:if test="${not empty user}">
			<A href="post.jsp?bid=${board.boardid}"><IMG src="image/post.gif" name="td_post"
				border="0" id=td_post></A>
		</c:if>
		<c:if test="${empty user}">
			<A href="login.jsp?bid=${board.boardid}"><IMG src="image/post.gif" name="td_post"
				border="0" id=td_post></A>
		</c:if>
		</DIV>
		<!--         翻 页         -->
		<DIV>
			<a href="list.html">上一页</a>| <a href="list.html">下一页</a>
		</DIV>

		<DIV class="t">
			<TABLE cellSpacing="0" cellPadding="0" width="100%">
				<TR>
					<TH class="h" style="WIDTH: 100%" colSpan="4"><SPAN>&nbsp;</SPAN></TH>
				</TR>
				<!--       表 头           -->
				<TR class="tr2">
					<TD>&nbsp;</TD>
					<TD style="WIDTH: 80%" align="center">文章</TD>
					<TD style="WIDTH: 10%" align="center">作者</TD>
					<TD style="WIDTH: 10%" align="center">回复</TD>
				</TR>
				<!--         主 题 列 表        -->
				<c:forEach items="${sticker}" var="s">
					<TR class="tr3">
						<TD><IMG src="image/topic.gif" border=0></TD>
						<TD style="FONT-SIZE: 15px"><A href="DetailServlet?bid=${board.boardid}&tid=${s.topicid}">${s.topicCaption }</A></TD>
						<TD align="center">${s.lastReplyUser }</TD>
						<TD align="center">2</TD>
					</TR>
				</c:forEach>
			</TABLE>
		</DIV>
		<!--            翻 页          -->
		<DIV>
			<a href="list.html">上一页</a>| <a href="list.html">下一页</a>
		</DIV>
	</DIV>
	<!--             声 明          -->
	<BR />
	<CENTER class="gray">版权所有 2005-2011 西安粤嵌技有限公司</CENTER>

</BODY>

</html>