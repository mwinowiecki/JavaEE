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

@WebServlet(urlPatterns="/foodData")

public class GetData extends HttpServlet{
	
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
	
	float cena = 0;
	cena = Float.parseFloat(request.getParameter("cena"));
	
	String body = "<html><body>Jedzenie: "
			+"<form action=\"/servletjspdemo/showAll.jsp\">";
			/*+ name
			+"<br/> Typ: "
			+typ
			+"<br/> Cena: "
			+cena
			+"<br/><br/>";
	*/
	Food newFood = new Food();
	
	newFood.setName(name);
	newFood.setTyp(typ);
	newFood.setCena(cena);
	newFood.setId(Food.lastID);
	
	ss.add(newFood);
	Food.lastID++;
	
	body += "<br/><br/> <input type=\"submit\" value=\"Wroc\" />"
			+"<br/><br/></body></html>";
	
	writer.println(body);
	writer.close();
	}
	
	@Override
	public void init() throws ServletException{
		if(getServletContext().getAttribute("storage")==null){
			getServletContext().setAttribute("storage", new StorageService());
		}
	}

}