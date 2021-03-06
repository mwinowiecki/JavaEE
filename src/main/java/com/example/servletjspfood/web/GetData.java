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
	
	String selectedTyp = "";
	if(request.getParameter("typ") != null){
		for(String typ : request.getParameterValues("typ")){
			selectedTyp+=typ;
		}
	}
	else if(request.getParameter("typ") == null)
		selectedTyp="empty";
	
	String selectedSklad = "";
	if(request.getParameter("sklad")!=null){
		for(String sklad : request.getParameterValues("sklad")){
			selectedSklad+=sklad + " ";
		}
	}
	else if(request.getParameter("sklad") == null)
		selectedSklad="empty";
	
	Float cena = null;
	cena = Float.parseFloat(request.getParameter("cena"));
	
	String body = "<html><body>Added food: "
			+"<form action=\"/servletjspdemo/showAll.jsp\">";
			
	Food newFood = new Food();
	
	newFood.setName(name);
	newFood.setTyp(selectedTyp);
	newFood.setSklad(selectedSklad);
	newFood.setCena(cena);
	newFood.setId(Food.lastID);
	
	ss.add(newFood);
	Food.lastID++;
	
	body += "<br/>Nazwa ...... " + newFood.getName()
			+"<br/>Typ ....... " + newFood.getTyp()
			+"<br/>Sklad ..... " + newFood.getSklad()
			+"<br/>Cena ...... " + newFood.getCena() + "<br/>"
			+"<br/> <input type=\"submit\" value=\"Wroc\" />"
			+"<br/></body></html>";
	
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
