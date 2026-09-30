package com.movie_booking.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.movie_booking.dto.User;
import com.movie_booking.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
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
	    // 1. Get the email and password entered by the user
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    UserService userService = new UserService();

	    User user = userService.loginUser(email, password);

	    // 4. Verify if a user was found with those credentials
	    if (user != null) {
	        // Success! Create a session to keep the user logged in across pages
	        jakarta.servlet.http.HttpSession session = request.getSession();
	        session.setAttribute("currentUser", user);

	        // Redirect them straight to the Home Page
//	        response.sendRedirect("Html/index.html");
	        response.sendRedirect("movies");
	    } else {
	        // Failed login -> Show an error message
	    	response.setContentType("text/html");
	    	response.getWriter().println("""
	    	<h3 style='color:red;text-align:center;'>
	    	Invalid Email or Password!
	    	</h3>
	    	<a href='Html/login.html'>Try Again</a>
	    	""");
	    }
	}

}
