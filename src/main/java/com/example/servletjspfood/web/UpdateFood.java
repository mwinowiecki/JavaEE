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

@WebServlet(urlPatterns="/updateFood")

public class UpdateFood extends HttpServlet{

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
		if(request.getParameter("typ")!=null){
			for(String typ : request.getParameterValues("typ")){
				selectedTyp += typ +" ";
			}
		}
		else if(request.getParameter("typ")==null)
			selectedTyp="";
		
		String selectedSklad = "";
		if(request.getParameter("sklad")!= null){
			for(String sklad : request.getParameterValues("sklad")){
				selectedSklad+= sklad + " ";
			}
		
		}
		else if(request.getParameter("sklad")==null)
			selectedSklad = "";
		
		Float cena = null;
		if(request.getParameter("cena") != null){
			cena = Float.parseFloat(request.getParameter("cena"));
		}
		
		int ID = Integer.parseInt(request.getParameter("id"));
		
		String body = "<html><body>";
		
		Food newFood = new Food();
		
		newFood.setName(name);
		newFood.setTyp(selectedTyp);
		newFood.setSklad(selectedSklad);
		newFood.setCena(cena);
		newFood.setId(ID);
		
		ss.update(newFood, ID);
		
		
		body+="<form action=\"/servletjspdemo/showAll.jsp\"; method=\"get\">"
				+"<br/><br/> <input type=\"submit\" value=\"Wroc\">"
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
