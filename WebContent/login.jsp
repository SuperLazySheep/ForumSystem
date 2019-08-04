<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>粤嵌西安论坛--登录</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
<Link rel="stylesheet" type="text/css" href="style/style.css"/>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script language="javascript">
function check() {
 if(document.loginForm.uName.value==""){
    alert("用户名不能为空");
    return false;
 }
 if(document.loginForm.uPass.value==""){
    alert("密码不能为空");
    return false;
 }
}

//动态时间
function time(){
	date = new Date();
	year = date.getFullYear();
	month = date.getMonth()+1;
	if(month<10){
		month="0"+month;
	}
	day = date.getDate();
	if(day<10){
		day="0"+day;
	}
	hours = date.getHours();
	if(hours<10){
		hours="0"+hours;
	}
	minutes = date.getMinutes();
	if(minutes<10){
		minutes="0"+minutes;
	}
	seconds = date.getSeconds();
	if(seconds<10){
		seconds="0"+seconds;
	}
$("#showtime").html("现在是:"+year+"-"+month+"-"+day+"\t"+hours+":"+minutes+":"+seconds);

}
setInterval("time()",1000);

</script>
</HEAD>

<BODY>
<DIV>
	<IMG src="image/logo.png" style="width:200px;height:50px">
	<div id="showtime" align="right"></div>
</DIV>
<!--      用户信息、登录、注册        -->

	<DIV class="h">
		您尚未　<a href="login.jsp">登录</a>
		&nbsp;| &nbsp; <A href="reg.jsp">注册</A> |
	</DIV>


<BR/>
<!--      导航        -->
<DIV>
	&gt;&gt;<B><a href="IndexServlet">论坛首页</a></B>
</DIV>
<!--      用户登录表单        -->
<DIV class="t" style="MARGIN-TOP: 15px" align="center">
	<FORM name="loginForm" onSubmit="return check()" action="LoginRegServlet" method="post">
		<br/>用户名 &nbsp;<INPUT class="input" tabIndex="1"  type="text"      maxLength="20" size="35" name="uName">
		<p/>密　码 &nbsp;<INPUT class="input" tabIndex="2"  type="password"  maxLength="20" size="40" name="uPass">
		<span id="span1"></span>
		<input type="hidden" value="2" name="uhidden">
		<p/><INPUT id="denglu" class="btn"  tabIndex="6"  type="submit" value="登 录">
	</FORM>
</DIV>
<!--      声明        -->
<BR/>
<CENTER class="gray">版权所有 2005-2011　西安粤嵌科技有限公司</CENTER>
</BODY>
</HTML>
