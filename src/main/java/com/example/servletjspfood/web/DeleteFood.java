package com.example.servletjspfood.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspfood.domain.Food;
import com.example.servletjspfood.service.StorageService;

@WebServlet(urlPatterns = "/deleteFood")

public class DeleteFood  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		PrintWriter writer = response.getWriter();
		
		StorageService ss = (StorageService)getServletContext().getAttribute("storage");
		
		if(request.getSession().getAttribute("food") == null){
			request.getSession().setAttribute("food", new Food());
		}
		
		Food food = (Food)request.getSession().getAttribute("food");
		
		String name = null;
		name = request.getParameter("name");
		
		String typ = null;
		typ = request.getParameter("typ");
		
		String sklad = null;
		sklad = request.getParameter("sklad");
		
		float cena = 0;
		if(request.getParameter("cena") != null){
			cena=Float.parseFloat(request.getParameter("cena"));
		}
		
		int ID = Integer.parseInt(request.getParameter("foodId"));
		
				
		String body = "<html><body> Food with id " + ID + " removed";
		ss.delete(ID);
		
		body+="<form action=\"/servletjspdemo/index.jsp\""
				+"<br/><br/> <input type=\"submit\" value=\"Wroc\" /> "
				+"<br/><br/></body></html>";
		
		writer.println(body);
		writer.close();
	}
	
	@Override
	public void init() throws ServletException{
		if(getServletContext().getAttribute("storage")==null)
		{
			getServletContext().setAttribute("storage", new StorageService());
		}
	}
	

}
