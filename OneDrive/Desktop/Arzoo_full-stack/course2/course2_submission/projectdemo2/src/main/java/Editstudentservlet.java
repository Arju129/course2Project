

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Editstudentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    int pid = Integer.parseInt(request.getParameter("pid"));
	        String pname = request.getParameter("pname");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        int batch_id = Integer.parseInt(request.getParameter("batch_id"));

	       
	        String url = "jdbc:mysql://localhost:3306/zumba";
	        String user = "root";
	        String password = "Arzoo@123";

	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            
	            try (Connection conn = DriverManager.getConnection(url, user, password)) {
	                
	                String query = "UPDATE participant SET pname=?, email=?, phone=?, batch_id=? WHERE pid=?";
	                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	                    pstmt.setString(1, pname);
	                    pstmt.setString(2, email);
	                    pstmt.setString(3, phone);
	                    pstmt.setInt(4, batch_id);
	                    pstmt.setInt(5, pid);

	                  
	                    int rowsUpdated = pstmt.executeUpdate();
	                    if (rowsUpdated > 0) {
	                       
	                        response.sendRedirect("ListofstudentJSP.jsp");
	                    } else {
	                        
	                        response.getWriter().println("Failed to update student information.");
	                    }
	                }
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            
	            response.getWriter().println("Error occurred while updating student information.");
	        }
	    }
	}
