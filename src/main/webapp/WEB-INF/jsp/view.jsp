<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>国家(地区)信息</title>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body style="margin-top:50px;overflow: hidden;">
<form action="${pageContext.request.contextPath}/save" method="post">
    <input type="hidden" name="mId" value="${member.mId}"/>
    <table class="gridtable" style="width:800px;">
        <tr>
            <th colspan="5">国家(地区)信息 - [<a href="${pageContext.request.contextPath}/list">返回</a>]</th>
        </tr>
        <tr>
            <th>邮箱：</th>
            <td><input type="text" name="mEmail" value="${member.mEmail}"/></td>
            <th>手机：</th>
            <td><input type="text" name="mPhone" value="${member.mEmail}"/></td>
            <td><input type="submit" value="保存"/></td>
        </tr>
    </table>
</form>
</body>
</html>
