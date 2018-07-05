package com.rita.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rita.db.CiudadesDAO;
import com.rita.models.City;
import com.rita.models.Country;

@WebServlet("/crearciudad")
public class CiudadesCrearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("crearciudad.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name=request.getParameter("name");
		String distrito=request.getParameter("distrito");
		int poblacion =request.getParameter("population")!=null? Integer.parseInt(request.getParameter("population")) : 0;
		String code=request.getParameter("countrycode");
		String codename=request.getParameter("countryname");
		
		City cityToAdd=new City(0,name,distrito,poblacion);
		
		Country countryToAdd=new Country(code, codename);
		cityToAdd.setCountry(countryToAdd);
		
		
		boolean isOk=false;
		try {
			int newId=CiudadesDAO.getInstance().InsertarCiudadPais(cityToAdd,countryToAdd);
			isOk=newId>0?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		if(isOk) {
			response.sendRedirect("listaciudades");
		}else {
			request.setAttribute("error", "Verifica los campos");
			request.setAttribute("city", cityToAdd);
			request.setAttribute("country", countryToAdd);
			
			doGet(request, response);
		}
		
		
		
	}

}
