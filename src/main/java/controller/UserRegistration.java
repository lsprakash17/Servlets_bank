package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Customerdao;
import dto.Customer;

@WebServlet("/register")
public class UserRegistration extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("fname");
		String lname = req.getParameter("lname");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String pass = req.getParameter("pwd");
		Date date=Date.valueOf(req.getParameter("dob"));
	    Customerdao dao=new Customerdao();
	    Customer user=new Customer();
	    user.setFname(name);
		user.setLname(lname);
		user.setDob(date);
		user.setMobile(mobile);
		user.setPass(pass);
		user.setGender(gender);
		user.setEmail(email);
		dao.save(user);
		if(user!=null)
		{
			resp.getWriter().print("\"<script language=javascript>alert('your acount Created successfully please note Your ID);</script>");
			req.getRequestDispatcher("SignUp.html").include(req, resp);
		}
		Customer user2=dao.check(email).get(0);
		if(user2.getGender().equals("male"))
			resp.getWriter().print("<h1>Hello Sir</h1>");
		else
			resp.getWriter().print("<h1>Hello Mam</h1>");
		resp.getWriter().print("<h1>Your Customer Id is : " + user2.getId() + "</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
		
		
		
		
	
	}
	
}
