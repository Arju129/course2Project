

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projectdemo2.batch;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Servlet implementation class AddbatchServlet
 */
public class AddbatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String batch_name = request.getParameter("batch_name");
	        String start_dateStr = request.getParameter("start_date");
	        String end_dateStr = request.getParameter("end_date");
	        String instructor = request.getParameter("instructor");
	        int max_capacity = Integer.parseInt(request.getParameter("max_capacity"));

	        batch batchObj = new batch();

	        batchObj.setBatch_name(batch_name);

	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date start_date;
	        Date end_date;
	        try {
	            start_date = sdf.parse(start_dateStr);
	            end_date = sdf.parse(end_dateStr);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            // Provide default values for start_date and end_date if parsing fails
	            start_date = new Date();
	            end_date = new Date();
	        }
	        batchObj.setStart_date(start_date);
	        batchObj.setEnd_date(end_date);
	        batchObj.setInstructor(instructor);
	        batchObj.setMax_capacity(max_capacity);

	        Connection conn = null;
	        PreparedStatement pstmt = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba", "root", "Arzoo@123");
	            pstmt = conn.prepareStatement("INSERT INTO batch(batch_name, start_date, end_date, instructor, max_capacity) VALUES (?, ?, ?, ?, ?)");
	            pstmt.setString(1, batchObj.getBatch_name());

	            pstmt.setDate(2, new java.sql.Date(batchObj.getStart_date().getTime()));
	            pstmt.setDate(3, new java.sql.Date(batchObj.getEnd_date().getTime()));

	            pstmt.setString(4, batchObj.getInstructor());
	            pstmt.setInt(5, batchObj.getMax_capacity());

	            int i = pstmt.executeUpdate();
	            if (i > 0) {
	                out.println("<h3>Batch added successfully!</h3>");
	                response.sendRedirect("AddbatchJSP.jsp?batch_name=" + batch_name + "&start_date=" + start_dateStr + "&end_date=" + end_dateStr + "&instructor=" + instructor + "&max_capacity=" + max_capacity);
	            } else {
	                out.println("<h3>Failed to add batch.</h3>");
	            }
	        } catch (Exception e) {
	            out.println("<h3>Error: " + e.getMessage() + "</h3>");
	        } finally {
	            try {
	                if (pstmt != null)
	                    pstmt.close();
	                if (conn != null)
	                    conn.close();
	            } catch (Exception e) {
	                out.println("<h3>Error in closing resources: " + e.getMessage() + "</h3>");
	            }
	        }
	    }
	}