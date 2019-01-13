<%--不加就乱码的--%>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--根据设备的大小-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>index</title>
    <meta charset="UTF-8">
    <title>daohan</title>
    <link rel="stylesheet" href="../css/mycss.css">
</head>
<body>
<div class="site-topbar">
    <div class="container">
        <nav class="top">
            <a href="/html/login.jsp">首页</a>
            <span class="sep">|</span>
            <a href="http://www.baidu.com">百度</a>
            <span class="sep">|</span>

            <a href="http://www.tmall.com">天猫</a>
            <span class="sep">|</span>

            <a href="http://www.github.com">github</a>
        </nav>

    </div>
</div>

<div class="site-header">
    <div class="container">
        <div class="header-logo">
            <a href="../img/logo.png" title="home_page">
                <img src="../img/logo.png" width="80" alt="1">
            </a>
        </div>
        <div class="title2">Jn-homePage</div>
        <div class="header-nav">

            <a href="login1.jsp">验证码登录</a>
            <a href="login.jsp">密码登录</a>
            <!--<a href="#">醒悟</a>-->
        </div>


    </div>
</div>

<div class="container">
    <div class="login">
        <div class="title">请登录</div>
        <script>
            tophone = function () {

                var phone = document.getElementById("phone").value;
                console.log("********send message******");
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState === 4) {
                        alert("发送成功");
                    }
                };

                xmlhttp.open("GET", "/servlet/PhoneServlet?phone=" + phone, true);
                xmlhttp.send();

            }
        </script>
        <form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
            <label for="phone"></label>
            <div class="in input-phone"> 电话:<input type="text" name="phone" id="phone">
                <button onclick="tophone()" type="button">发送</button>
            </div>
            <div class="in input-number">验证码:<label for="number"></label><input type="text" name="number" id="number">
            </div>
            <div id="input-submit"><input type="submit" id="submit1" class="btnadpt" value="登录"></div>

            <div id="regi"><a href="${pageContext.request.contextPath}/html/register.html">注册</a>
                <% if (session.getAttribute("msg") != null) {
                %>

                <%=session.getAttribute("msg")%>
                <% }%>
            </div>
        </form>
    </div>

</div>


</body>
</html>