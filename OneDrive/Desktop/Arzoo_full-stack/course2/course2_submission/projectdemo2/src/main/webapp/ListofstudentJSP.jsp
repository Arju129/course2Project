<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students Information</title>

<style>
        
        #student-table {
            border-collapse: collapse; /* Collapse border spacing */
            width: wrap_content;
        }
        #student-table th, #student-table td {
            border: 1px solid #ddd; /* Border style for table cells */
            padding: 5px;
            text-align: left;
        }
        #student-table th {
            background-color: #f2f2f2; /* Background color for table header */
        }
    </style>
</head>
<body>

  <h1>List of Students</h1>

  
    <table id="student-table">
        

        <thead>
        
      
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                 <th>Phone</th>
                 <th>BatchId</th>
                 <th>Action</th>
                 
        </thead>
        <tbody>
            <%@ page import="java.sql.*" %>
            <%
              
                String url = "jdbc:mysql://localhost:3306/zumba";
                String user = "root";
                String password = "Arzoo@123";
                
             
                Class.forName("com.mysql.cj.jdbc.Driver");
                
            
                Connection conn = DriverManager.getConnection(url, user, password);
            
                String query = "SELECT * FROM participant";
                
          
                Statement stmt = conn.createStatement();
                
           
                ResultSet rs = stmt.executeQuery(query);
                
                
                while (rs.next()) {
            %>
            <tr>
            
            
                <td><%= rs.getInt("pid") %></td>
                <td><%= rs.getString("pname") %></td>
                <td><%= rs.getString("email") %></td>
                <td><%= rs.getString("phone") %></td>
                <td><%= rs.getInt("batch_id") %></td>
               <td><a href="editStudentJSP.jsp?pid=<%= rs.getInt("pid") %>&pname=<%= rs.getString("pname") %>&email=<%= rs.getString("email") %>&phone=<%= rs.getString("phone") %>&batch_id=<%= rs.getInt("batch_id") %>">UPDATE</a></td>
             
           
            </tr>
          
            <%
                }
                
                rs.close();
                stmt.close();
                conn.close();
            %>
            
          
        </tbody>
         
    </table>
    
    <div style="text-align: left; margin-top: 20px;">
    <a href="index.jsp" style="font-size: 18px; margin-left: 20px;">HOME</a>
</div>
</body>
</html>