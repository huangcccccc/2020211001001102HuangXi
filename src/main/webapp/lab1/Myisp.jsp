<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//.println(basePath);
%>
<html>
<head>
    <title>MyJsp</title>
    <style>
        form div {
            margin: 10px 0;
        }
        input {
            outline: none;
            border: none;
        }
    </style>
</head>
<body>
<%--action="<%=basePath%>MyDear" or action="MyDearJsp.jsp"--%>
<form method="post" action="MyDearJsp.jsp" style="width: 20%; height: auto; background:linear-gradient(to top, #2980b9, #6dd5fa, #ffffff); display: flex; flex-direction: column;  align-items: center; border-radius: 5px; border: 1px solid darkgray;">
    <div>I am MyJsp.jsp</div>
    <div><label for="name">name:</label><input id="name" name="name" type="text" required></div>
    <div><label for="clas">class:</label><input id="clas" name="clas" type="text" required></div>
    <div><label for="ID">ID:</label><input id="ID" name="ID" type="text" required></div>
    <div><input name="submit" type="submit" value="Send data to server"></div>
</form>
</body>
</html>