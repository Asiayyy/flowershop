<%--
  Created by IntelliJ IDEA.
  User: 30862
  Date: 2022/8/15
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<!-- Head -->
<head>

    <title>登录表单</title>

    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //Meta-Tags -->

    <!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <script type="text/javascript">
    function type() {
        alert("注册成功")
    }
    </script>


</head>
<!-- //Head -->

<!-- Body -->
<body>

<h1>登录表单</h1>

<div class="container w3layouts agileits">

    <div class="login w3layouts agileits">
        <h2>登 录</h2>
        <ul class="tick w3layouts agileits">
            <li>
                <input type="checkbox" id="brand1" value="">
            </li>
        </ul>
        <div class="send-button w3layouts agileits">
            <div style="font-size: 20px;color: red">${result}</div>
            <form action="/login" method="post">
                <input type="hidden" name="type" value="${type}">
                <input type="text" Name="Username" placeholder="用户名" required="">
                <input type="password" Name="Password" placeholder="密码" required="">
                <input type="submit" value="登 录">
            </form>
        </div>
        <a href="main.jsp">返回主页</a>

        <div class="clear"></div>
    </div><div class="copyrights">Collect from <a href="" ></a></div>
    <div class="register w3layouts agileits">
        <h2>注 册</h2>
        <form action="/sign" method="post">
            <input type="text" Name="Name" placeholder="用户名" required="">
            <input type="email" Name="Email" placeholder="邮箱" required="">
            <input type="password" Name="Password" placeholder="密码" required="">
            <input type="tel" Name="Number" placeholder="手机号码" required="">
            <input type="submit" onclick=" return type()" value="免费注册">
        </form>
        <div class="send-button w3layouts agileits">
        </div>
    </div>

    <div class="clear"></div>

</div>



</body>
<!-- //Body -->

</html>
