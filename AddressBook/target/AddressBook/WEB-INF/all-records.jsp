<%@ page import="com.softserve.itacademy.AddressBook" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Records</title>
</head>
<body>
<%@include file="header.html"%>
<br><br>
Sort by:
<a href="/addressbook/allrecords?sort=<%="asc"%>">ascending</a> |
<a href="/addressbook/allrecords?sort=<%="desc"%>">descending</a>

<br><br>
<table border ="1">
    <tr>
        <th>№</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Address</th>
        <th colspan="3">Operation</th>
    </tr>
    <%
        int a=0;
      AddressBook  addressBook = (AddressBook) request.getAttribute("addressbook");
       Iterator iterator =  addressBook.iterator();
       while(iterator.hasNext()){
           a++;
        String[] str = iterator.next().toString()
                .replaceAll("First name: ","")
                .replaceAll(" Last name: ","")
                .replaceAll(" Address: ","")
                .split(",");
    %>
    <tr>
        <td><%=a%></td>
        <td><%=str[0]%></td>
        <td><%=str[1]%></td>
        <td><%=str[2]%></td>
        <td>
            <a href="/addressbook/read?id=<%=str[0]+"+"+str[1]%>">Read</a>
        </td>
        <td>
            <a href="/addressbook/update?id=<%=str[0]+"+"+str[1]%>">Update</a>
        </td>
        <td>
            <a href="/addressbook/delete?id=<%=str[0]+"+"+str[1]%>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
