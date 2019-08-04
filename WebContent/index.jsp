<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>欢迎访问粤嵌西安论坛</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
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
</HEAD>

<BODY>

	<DIV>
		<IMG src="image/logo.png" style="width: 200px; height: 50px">
		<div id="showtime" align="right"></div>
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
	<DIV class="t">
		<TABLE cellSpacing="0" cellPadding="0" width="100%">
			<TR class="tr2" align="center">
				<TD colSpan="2">主题</TD>
				<TD style="WIDTH: 10%;">数量</TD>
				<TD style="WIDTH: 30%">最后发表</TD>
			</TR>
			<!--       主版块       -->

			<c:forEach items="${forcum}" var="f">
				<TR class="tr3">
					<TD colspan="4">${ f.forcumName}</TD>
				</TR>
				<c:forEach items="${board}" var="b">
					<c:if test="${f.forcumId == b.forcumid }">
						<TR class="tr3">
							<TD width="5%">&nbsp;</TD>
							<TH align="left"><IMG src="image/board.gif"> <A
								href="ListServlet?bid=${b.boardid}">${b.boardName }</A></TH>
					</c:if>
					<c:forEach items="${count }" var="count">
						 <c:if
							test="${b.boardid==count.boardId && f.forcumId == b.forcumid }">
							<TD align="center">${count.total }</TD>
						</c:if>
						<%-- ${f.forcumId == b.forcumid && c2.boardid != b.boardid } --%>
					</c:forEach>

					<c:if test="${f.forcumId == b.forcumid}">
						<TH><SPAN> <A href="ListServlet?bid=${b.boardid}">c#是微软开发的语言
							</A>
						</SPAN> <BR /> <SPAN>accp</SPAN> <SPAN class="gray">[ 2007-07-30
								10:25 ]</SPAN></TH>
					</c:if>
					</TR>


				</c:forEach>
			</c:forEach>

		</TABLE>
	</DIV>

	<BR />
	<CENTER class="gray">版权所有 2005-2011 西安粤嵌科技有限公司</CENTER>
</BODY>
</HTML>