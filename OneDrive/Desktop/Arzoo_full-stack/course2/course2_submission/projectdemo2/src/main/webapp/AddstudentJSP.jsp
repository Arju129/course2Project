<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Students</title>
</head>
<body>
   <h2>Inserted Data</h2>
    <table border="1">
        <tr>
            <th>Participant Name</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Batch ID</th>
        </tr>
        <%
            // Retrieve inserted data from request parameters
            String pname = request.getParameter("pname");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String batch_id = request.getParameter("batch_id");
        %>
        <tr>
            <td><%= pname %></td>
            <td><%= phone %></td>
            <td><%= email %></td>
            <td><%= batch_id %></td>
        </tr>
    </table>
    <a href="Addstudent.html">Create Another Student</a>&nbsp;&nbsp;&nbsp;
    <a href="index.jsp">HOME</a>
</body>
</html>