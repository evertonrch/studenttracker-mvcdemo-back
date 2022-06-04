package br.com.studenttracker.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/testDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "springuser";
		String passwd = "spring99";
		String url = "jdbc:mysql://localhost:3306/springmvc_hibernate_project";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		response.setContentType("text/plain");
		
		try {			
			PrintWriter writer = response.getWriter();
			
			Class.forName(driver);
			
			try(Connection conn = DriverManager.getConnection(url, user, passwd)){
				ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM customer");
				while(rs.next()) {
					String fn = rs.getString("first_name");
					String ln = rs.getString("last_name");
					String email = rs.getString("email");
					writer.println(fn + " - " + ln + " - " + email);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
