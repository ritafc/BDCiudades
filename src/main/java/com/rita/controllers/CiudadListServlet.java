package com.rita.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rita.db.CiudadesDAO;
import com.rita.db.CountryDAO;
import com.rita.models.City;
import com.rita.models.Country;

@WebServlet("/listaciudades")
public class CiudadListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String countryCode=(request.getParameter("pais")!=null?(String)request.getParameter("pais"):"");
		
		countryCode=countryCode.length()>3?"":countryCode;
		request.setAttribute("countryCode", countryCode);
		
		
		List<City> listaCiudad=null;
		List<Country> listaPaises=null;
		try {
			listaCiudad=CiudadesDAO.getInstance().getLista(countryCode);
			listaPaises=CountryDAO.getInstance().getLista();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		request.setAttribute("listaciudades", listaCiudad);
		request.setAttribute("listapaises", listaPaises);

		request.getRequestDispatcher("listaCiudades.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
