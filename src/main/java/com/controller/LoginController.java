package com.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.*;
import com.utilties.HibernateUtils;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null)
		{
			response.sendRedirect("home.jsp");
		}else
		{
			response.sendRedirect("login.jsp");

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		HttpSession session = request.getSession(true);

		if(userName.isEmpty() || userName.isBlank())
		{
			response.sendRedirect("login.jsp?error=Please Enter User Name");
		}else if (userPassword.isEmpty())
		{
			response.sendRedirect("login.jsp?error=Please Enter Password");

		}else {	
			Session s = HibernateUtils.getSessionFactory().openSession();
			Transaction tx = s.beginTransaction();
			Query hql = s.createQuery("from Users as u where u.username=:x and u.password=:y");
			hql.setParameter("x", userName);
			hql.setParameter("y", userPassword);
			hql.setMaxResults(1);
			Users user=(Users)hql.uniqueResult();
			if(hql.equals(null))
			{
			    response.sendRedirect("login.jsp?error=Invalid User Name or password");	
			}else
			{
				session.setAttribute("loginUser", user);
				response.sendRedirect("home.jsp");
			}

		}
		
		
		
	}

}
