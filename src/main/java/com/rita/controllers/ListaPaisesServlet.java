package com.rita.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rita.db.CountryDAO;
import com.rita.models.Country;

@WebServlet("/listapaises")
public class ListaPaisesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Country> listaPaises=null;
		try {
			listaPaises=CountryDAO.getInstance().getLista();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("listapaises",listaPaises);
		request.getRequestDispatcher("listapaises.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
