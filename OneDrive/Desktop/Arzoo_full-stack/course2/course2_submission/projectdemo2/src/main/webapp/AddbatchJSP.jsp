<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Success!</title>
    <style>
        /* Define a CSS class for link margin */
        .link-margin {
            margin-top: 50px; /* Adjust as needed */
        }
    </style>
   
</head>
<body>
   <h2>Inserted Data</h2>
    <table border="1">
    
         <tr>
            <th>Batch Name</th>
            <th>start_date</th>
            <th>end_date</th>
            <th>instructor</th>
            <th>max_capacity</th>
        </tr>
        <%
            // Retrieve inserted data from request parameters
            String batch_name = request.getParameter("batch_name");
            String start_date = request.getParameter("start_date");
            String end_date = request.getParameter("end_date");
            String instructor = request.getParameter("instructor");
            String max_capacity = request.getParameter("max_capacity");
            
        %>
        <tr>
            <td><%= batch_name %></td>
            <td><%= start_date %></td>
            <td><%= end_date %></td>
            <td><%= instructor %></td>
            <td><%= max_capacity %></td>
        </tr>
    </table>
    
   

    <a href="AddBatch.html" class="link-margin">Create Another Batch</a> &nbsp;&nbsp;&nbsp;
    <a href="index.jsp" class="link-margin">HOME</a>
   
</body>
</html>