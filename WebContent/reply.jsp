<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>粤嵌西安论坛--发布帖子</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
<script type="text/javascript">
	function check() {
		if (document.postForm.content.value == "") {
			alert("内容不能为空");
			return false;
		}
		if (document.postForm.content.value.length > 1000) {
			alert("长度不能大于1000");
			return false;
		}
	}
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
	<DIV>
		<BR />
		<!--      导航        -->
		<DIV>
			&gt;&gt;<B><a href="IndexServlet">论坛首页</a></B>&gt;&gt; <B><a
				href="DetailServlet?bid=${bid}&tid=${tid}">${topic.topicCaption }</a></B>
		</DIV>
		<BR />
		<DIV>
			<FORM name="postForm" onsubmit="return check()"
				action="ReplyServlet" method="POST">
				<INPUT type="hidden" name="boardId" value="4" /> <INPUT
					type="hidden" name="topicId" value="" />
				<DIV class="t">
					<TABLE cellSpacing="0" cellPadding="0" align="center">
						<TR>
							<TD class="h" colSpan="3"><B>发表帖子</B></TD>
						</TR>

						<TR class="tr3">
							<TH vAlign=top>
								<DIV>
									<B>内容</B>
								</DIV>
							</TH>
							<TH colSpan=2>
								<DIV>
									<span><textarea style="WIDTH: 500px;" name="content"
											rows="20" cols="90" tabIndex="2"></textarea></span>
								</DIV> (不能大于:<FONT color="blue">1000</FONT>字)
							</TH>
						</TR>
					</TABLE>
				</DIV>

				<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
					<INPUT class="btn" tabIndex="3" type="submit" value="提 交">
					<INPUT class="btn" tabIndex="4" type="reset" value="重 置">
				</DIV>
			</FORM>
		</DIV>
	</DIV>
	<!--      声明        -->
	<BR />
	<CENTER class="gray">版权所有 2005-2011 西安粤嵌科技有限公司</CENTER>

</BODY>
</HTML>
