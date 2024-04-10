<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
  
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: wrap_content;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error-message {
            color: red;
            font-size: 14px;
            margin-top: 5px;
        }
    
</style>
<meta charset="ISO-8859-1">
<title>Update Batch</title>
</head>
<body>
<div class="container">

<h1>Update Batch</h1>


<form action="Editbatchservlet" method="post" >

    <label for="batch_id">Batch ID:</label>
    <input type="text" id="batch_id" name="batch_id" value="<%= request.getParameter("batch_id") %>">

    <label for="batch_name">Name:</label>
    <input type="text" id="batch_name" name="batch_name" value="<%= request.getParameter("batch_name") %>">
  
    <label for="start_date">Start Date:</label>
    <input type="text" id="start_date" name="start_date" value="<%= request.getParameter("start_date") %>">
 
    <label for="end_date">End Date:</label>
    <input type="text" id="end_date" name="end_date" value="<%= request.getParameter("end_date") %>">

    <label for="instructor">Instructor:</label>
    <input type="text" id="instructor" name="instructor" value="<%= request.getParameter("instructor") %>">
  
    <label for="max_capacity">Max Capacity:</label>
    <input type="text" id="max_capacity" name="max_capacity" value="<%= request.getParameter("max_capacity") %>">
    <br>
    <input type="submit" value="Update">&nbsp;&nbsp;&nbsp;<a href="index.jsp">HOME</a>
</form>
</div>

</body>
</html>