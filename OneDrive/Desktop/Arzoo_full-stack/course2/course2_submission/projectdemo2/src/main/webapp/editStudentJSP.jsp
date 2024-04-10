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
<title>Update Student</title>
</head>
<body>
 <div class="container">

<h1>Update Student</h1>

<form action="Editstudentservlet" method="post">
    <label for="pid">Student ID:</label>
    <input type="text" id="pid" name="pid" value="<%= request.getParameter("pid") %>">
    <br>
    <label for="pname">Name:</label>
    <input type="text" id="pname" name="pname" value="<%= request.getParameter("pname") %>">
    <br>
    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="<%= request.getParameter("email") %>">
    <br>
    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" value="<%= request.getParameter("phone") %>">
    <br>
    <label for="batch_id">Batch ID:</label>
    <input type="text" id="batch_id" name="batch_id" value="<%= request.getParameter("batch_id") %>">
    <br>
    <input type="submit" value="Update">&nbsp;&nbsp;&nbsp;<a href="index.jsp">HOME</a>
</form>
</div>

</body>
</html>