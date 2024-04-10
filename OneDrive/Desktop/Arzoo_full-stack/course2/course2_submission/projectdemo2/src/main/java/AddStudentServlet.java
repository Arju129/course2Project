
import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projectdemo2.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String pname = request.getParameter("pname");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        int batch_id = Integer.parseInt(request.getParameter("batch_id"));
	        
	        student studentObj = new student();
	        studentObj.setPname(pname);
	        studentObj.setEmail(email);
	        studentObj.setPhone(phone);
	        studentObj.setBatch_id(batch_id);

	        Connection conn = null;
	        PreparedStatement pstmt = null;

	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba", "root", "Arzoo@123");
	            pstmt = conn.prepareStatement("INSERT INTO participant(pname, email, phone, batch_id) VALUES (?, ?, ?, ?)");
	            pstmt.setString(1, studentObj.getPname());
	            pstmt.setString(2, studentObj.getEmail());
	            pstmt.setString(3, studentObj.getPhone());
	            pstmt.setInt(4, studentObj.getBatch_id());
	            int i = pstmt.executeUpdate();
	            if (i > 0) {
	                out.println("<h3>Student added successfully!</h3>");
	                response.sendRedirect("AddstudentJSP.jsp?pname=" + pname + "&email=" + email + "&phone=" + phone + "&batch_id=" + batch_id);
	            } else {
	                out.println("<h3>Failed to add student.</h3>");
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