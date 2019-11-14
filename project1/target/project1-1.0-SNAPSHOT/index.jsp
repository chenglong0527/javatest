<%--
  Created by IntelliJ IDEA.
  User: zcl
  Date: 2019/11/13
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .div1{
            left:50%;
            position: fixed;
        }
        .div2{
            height: 600px;
            width: 500px;
            left: -300px;
            position: relative;
        }
        .div3-1{
            height: 30px;
            width: 600px;
            line-height: 30px;
        }
        .div3{
            height: 125px;
            width: 500px;
            border-style: solid;
            border-color: #e9e9e9;
        }
        .div4{
            height: 30px;
            width: 450px;
            line-height: 30px;
        }
        .div4-1{
            height: 30px;
            width: 150px;
            line-height: 30px;
            float: left;
        }
        .div5{
            height: 90px;
            width: 500px;
        }
        .div6{
            height: 60px;
            width: 500px;
        }
    </style>
</head>
<body>
<div class="div1">
    <div class="div2">
        <div class="div3-1">
            欢迎大家来到我的小破站，虽然暂时没啥可看的，欢迎大家注册和留言！！！
        </div>
        <div class="div3">
            <div class="div4">注册页面</div>
            <form action="${pageContext.request.contextPath}/account/register" method="post">
                <div class="div4">用户名：<input type="text" name="username"></div>
                <div class="div4">密码：<input type="text" name="password"></div>
                <div class="div4"><input type="submit" value="注册"></div>
            </form>
        </div>
        <div class="div3">
            <div class="div4">登录页面</div>
            <form action="${pageContext.request.contextPath}/account/login" method="post">
                <div class="div4">用户名：<input type="text" name="username"></div>
                <div class="div4">密码：<input type="text" name="password"></div>
                <div class="div4"><input type="submit" value="登录"></div>
            </form>
        </div>
        <div class="div4">
            <div class="div4-1">查看个人信息</div>
            <form action="${pageContext.request.contextPath}/account/showInfo" method="post">
                <div class="div4-1"><input type="submit" value="查看个人信息"></div>
            </form>
        </div>
        <div class="div4">
            <div class="div4-1">留言</div>
            <form action="${pageContext.request.contextPath}/account/message" method="post">
                <div class="div4-1">
                    <input type="text" name="message">
                </div>
                <div class="div4-1">
                    <input type="submit" value="留言">
                </div>
            </form>
        </div>
        <div class="div4">
            <form action="${pageContext.request.contextPath}/account/checkMessage" method="post">
                <div class="div4-1">
                    <input type="submit" value="查看留言">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
