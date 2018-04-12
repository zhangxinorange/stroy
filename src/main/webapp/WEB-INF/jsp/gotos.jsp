<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
</head>
<body onload="gotoIndex();">

</body>
<script type="text/javascript">
	function gotoIndex()
	{
		window.location.href='${ctx}/user/index';
	}
</script>
</html>
