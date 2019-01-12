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
            <a href="#">首页</a>
            <span class="sep">|</span>
            <a href="#">行了啊</a>
            <span class="sep">|</span>

            <a href="#">我真的很</a>
            <span class="sep">|</span>

            <a href="#">五个字啊哦</a>
        </nav>

    </div>
</div>

<div class="site-header">
    <div class="container">
        <div class="header-logo">
            <a href="../img/logo.png" title="通程典当">
                <img src="../img/logo.png" width="100" alt="1">
            </a>
        </div>
        <div class="title2">通程典当</div>


    </div>
</div>

<div class="container">
    <div class="login">
        <div class="title">请登录</div>
        <form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
            <label for="id"></label>
            <div class="in input-id"> 账号:<input type="text" id="id" name="id" class="input1"/></div>
            <label for="password"></label>
            <div class="in input-password">密码:<input type="password" id="password" name="password" class="input1"></div>
            <div id="input-submit"><input type="submit" id="submit1" class="btnadpt" value="登录"></div>

            <div id="regi"><a href="${pageContext.request.contextPath}/html/register.html">注册</a>
                <%=session.getAttribute("msg")%>
            </div>
        </form>
    </div>

</div>


</body>
</html>