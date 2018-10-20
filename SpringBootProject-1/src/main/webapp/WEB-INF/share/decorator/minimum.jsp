<!DOCTYPE html>
<html>
<head>
 <%@ include file="/WEB-INF/share/includes/menu.jsp"  %>
 <%@ include file="/WEB-INF/share/includes/hours.jsp"  %>
  <title><sitemesh:write property="title" /></title>
  <sitemesh:write property="head"/>
</head>
<body>
  <h1><sitemesh:write property="title" /></h1>
  <sitemesh:write property="body"/>
</body>
</html>
