
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Record</title>
</head>
<body>
<%@include file="header.html"%>
<br><br>
<form action="/addressbook/update" method="post">
    <%String[] record =(String[]) request.getAttribute("record"); %>
    <table>
        <tr>
            <td>
                <label for="firstName"> First name:</label>
            </td>
            <td>
                <input type="text" id="firstName" name="firstName" value="<%=record[0]%>" disabled>
            </td>
        </tr>
        <tr>
            <td>
                <label for="lastName"> Last name:</label>
            </td>
            <td>
                <input type="text" id="lastName" name="lastName" value="<%=record[1]%>" disabled>
            </td>
        </tr>
        <tr>
            <td>
                <label for="address"> Address:</label>
            </td>
            <td>
                <input type="text" id="address" name="address" value="<%=record[2]%>">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>

</body>
</html>

