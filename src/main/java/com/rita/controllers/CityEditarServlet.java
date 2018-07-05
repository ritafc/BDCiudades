package com.rita.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rita.db.CiudadesDAO;
import com.rita.models.City;

@WebServlet("/editar")
public class CityEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idcity=(String)request.getParameter("idcity");
		System.out.println("Editar Ciudad::  id::  "+idcity);
		City unaCity=null;
		try {
			int idCiudad=idcity!=null&&!idcity.equals("")?Integer.parseInt(idcity):0;
			unaCity=CiudadesDAO.getInstance().getCiudad(idCiudad);
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Editar Ciudad::  id::  "+unaCity);
		request.setAttribute("city", unaCity);
		
		request.getRequestDispatcher("editarCiudad.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idCiudad=request.getParameter("id_ciudad")!=null ? Integer.parseInt(request.getParameter("id_ciudad")) : 0;
			String name=request.getParameter("name");
			String code=request.getParameter("countrycode");
			String distrito=request.getParameter("distrito");
			int poblacion =request.getParameter("population")!=null? Integer.parseInt(request.getParameter("population")) : 0;
			if(idCiudad>0) {
				City unaCiudad =new City(idCiudad,name,code,distrito,poblacion);
				boolean isOK=CiudadesDAO.getInstance().UpdateCiudad(unaCiudad);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}
