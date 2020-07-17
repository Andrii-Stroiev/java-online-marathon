
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read Record</title>
</head>
<body>
<%@include file="header.html"%>
<br><br>
<%String[] record =(String[]) request.getAttribute("record"); %>

<p>First name: <%=record[0]%></p>
<p>Last name: <%=record[1]%></p>
<p>Address: <%=record[2]%></p>

</body>
</html>
