package com.rita.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rita.db.CiudadesDAO;

@WebServlet("/borrar")
public class CityBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("idcity");
		String code=request.getParameter("code");
		
		boolean isOk=false;
		try {
			int idCiudad=(id!=null&&!id.equals(""))?Integer.parseInt(id):0;
			isOk=CiudadesDAO.getInstance().DeleteCiudad(idCiudad);
			
		
		} catch (Exception e) {
			
		}
		if(isOk) {
			request.setAttribute("error", "Se ha borrado correctamente");
		}
		
		
		
		response.sendRedirect("./listaciudades");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
