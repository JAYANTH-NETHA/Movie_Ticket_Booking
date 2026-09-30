package com.movie_booking.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.movie_booking.service.UserService;
import com.movie_booking.dto.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 1. Retrieve form data using your HTML input names
	    String userName = request.getParameter("user_name");
	    String email = request.getParameter("email");
	    String mobile = request.getParameter("phone"); // Maps HTML 'phone' to DB 'mobile'
	    String password = request.getParameter("password");
	    String confirmPassword = request.getParameter("confirmPassword");

	    if (!password.equals(confirmPassword)) {
	        response.setContentType("text/html");
	        response.getWriter().println("<h3 style='color:red;'>Passwords do not match!</h3>");
	        return;
	    }
	    String gender = request.getParameter("gender");
	    String dob = request.getParameter("dob"); // 'YYYY-MM-DD' from HTML dates maps perfectly to MySQL DATE
	    String address = request.getParameter("address"); // Make sure your form has an address field, or pass a default string

	    // 2. Debug log to console
	    System.out.println("Form Data -> Name: " + userName + ", Email: " + email + ", Mobile: " + mobile);
	    
	    // 3. Create your User DTO/Entity object matching your exact schema columns
	    User user = new User();
	    user.setUserName(userName);
	    user.setEmail(email);
	    user.setMobile(mobile); 
	    user.setPassword(password);
	    user.setGender(gender);
	    if (dob != null && !dob.isEmpty()) {
	        user.setDob(java.sql.Date.valueOf(dob));
	    } // Converts the HTML date string ('yyyy-mm-dd') directly to MySQL format
	    user.setAddress(address != null ? address : "Not Specified");

	    UserService userService = new UserService();

	    int rowsAffected = userService.registerUser(user);

	    // 5. Handle Redirection based on rows affected (greater than 0 means success!)
	    if (rowsAffected > 0) {
	        response.sendRedirect("Html/login.html");
	    } else {
	        response.setContentType("text/html");
	        response.getWriter().println("<h3 style='color:red; text-align:center;'>Registration Failed! Email might already exist.</h3>");
	    }
	}

}
