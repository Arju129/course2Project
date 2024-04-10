<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batch Information</title>

<style>
        
        #batch-table {
            border-collapse: collapse; /* Collapse border spacing */
            width: wrap_content;
        }
        #batch-table th, #batch-table td {
            border: 1px solid #ddd; /* Border style for table cells */
            padding: 5px;
            text-align: left;
        }
        #batch-table th {
            background-color: #f2f2f2; /* Background color for table header */
        }
    </style>
</head>
<body>

  <h1>List of Batches</h1>
  
   

  
    <table id="batch-table">
        

        <thead>
        
      
            <tr>
                <th>BatchId</th>
                <th>BatchName</th>
                <th>StartDate</th>
                 <th>EndDate</th>
                 <th>Instructor</th>
                 <th>MaxCapacity</th>
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
            
                String query = "SELECT * FROM batch";
                
          
                Statement stmt = conn.createStatement();
                
           
                ResultSet rs = stmt.executeQuery(query);
                
                
                while (rs.next()) {
            %>
            <tr>
            
            
                <td><%= rs.getInt("batch_id") %></td>
                <td><%= rs.getString("batch_name") %></td>
                <td><%= rs.getString("start_date") %></td>
                <td><%= rs.getString("end_date") %></td>
                <td><%= rs.getString("instructor") %></td>
                <td><%= rs.getInt("max_capacity") %></td>
               
                
                 <td><a href="EditBatchJSP.jsp?batch_id=<%= rs.getInt("batch_id") %>&batch_name=<%= rs.getString("batch_name") %>&start_date=<%= rs.getString("start_date") %>&end_date=<%= rs.getString("end_date") %>&instructor=<%= rs.getString("instructor") %>&max_capacity=<%= rs.getInt("max_capacity") %>">UPDATE</a></td>
             
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