

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


public class Editbatchservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    int batch_id = Integer.parseInt(request.getParameter("batch_id"));
	        String batch_name = request.getParameter("batch_name");
	        String start_date = request.getParameter("start_date");
	        String end_date = request.getParameter("end_date");
	        String instructor = request.getParameter("instructor");
	        int max_capacity = Integer.parseInt(request.getParameter("max_capacity"));

	       
	        String url = "jdbc:mysql://localhost:3306/zumba";
	        String user = "root";
	        String password = "Arzoo@123";

	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            
	            try (Connection conn = DriverManager.getConnection(url, user, password)) {
	                
	                String query = "UPDATE batch SET batch_name=?, start_date=?, end_date=?, instructor=?,max_capacity=? WHERE batch_id=?";
	                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	                    pstmt.setString(1, batch_name);
	                    pstmt.setString(2, start_date);
	                    pstmt.setString(3, end_date);
	                    pstmt.setString(4, instructor);
	                    pstmt.setInt(5, max_capacity);
	                    pstmt.setInt(6, batch_id);
	                    

	                  
	                    int rowsUpdated = pstmt.executeUpdate();
	                    if (rowsUpdated > 0) {
	                       
	                        response.sendRedirect("ListofbatchJSP.jsp");
	                    } else {
	                        
	                        response.getWriter().println("Failed to update batch information.");
	                    }
	                }
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            
	            response.getWriter().println("Error occurred while updating batch information.");
	        }
	    }
	}
