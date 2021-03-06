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

@WebServlet(urlPatterns="/updateFoodForm")

public class UpdateFoodForm extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		PrintWriter writer = response.getWriter();
		
		String name = null;
		name = request.getParameter("name");
		
		String typ = null;
		typ = request.getParameter("typ");
		
		float cena = 0;
		if(request.getParameter("cena") != null){
			cena = Float.parseFloat(request.getParameter("cena"));
		}
		
		int ID = Integer.parseInt(request.getParameter("foodId"));
		
		boolean vege = false;
		boolean normal = false;
		
		
		if(request.getParameter("typ").toLowerCase().contains("Vegetarian".toLowerCase()))vege = true;
		if(request.getParameter("typ").toLowerCase().contains("Normal".toLowerCase()))normal = true;

		String body = "<html><body>";
		
		body+="<form action=\"/servletjspdemo/updateFood\"; method=\"get\">"
				+"Nazwa: <input type =\"text\" name=\"name\" value=\"" + name + "\" /><br/>";
				
		
		body+="Typ: ";
		if(vege) body+="<input type=\"radio\" name=\"typ\" value=\"Vegetarian\" checked>Vegetarian";
		else body+="<input type=\"radio\" name=\"typ\" value=\"Vegetarian\">Vegetarian";
		if(normal) body+= "<input type=\"radio\" name=\"typ\" value=\"Normal\" checked>Normal";
		else body+="<input type=\"radio\" name=\"typ\" value=\"Normal\">Normal";
		
		body+="<br/>";
		
		boolean salata = false;
		boolean ser = false;
		boolean szynka = false;
		
		if(request.getParameter("sklad").toLowerCase().contains("Salata".toLowerCase())) salata = true;
		if(request.getParameter("sklad").toLowerCase().contains("Ser".toLowerCase())) ser = true;
		if(request.getParameter("sklad").toLowerCase().contains("Szynka".toLowerCase())) szynka = true;
		
		body+="Sklad: <br/>";
		if(salata)body +="<input type=\"checkbox\" name=\"sklad\" value=\"Salata\" checked>Salata<br/>";
		else body +="<input type=\"checkbox\" name=\"sklad\" value=\"Salata\">Salata<br/>";
		if(ser)body +="<input type=\"checkbox\" name=\"sklad\" value=\"Ser\" checked>Ser<br/>";
		else body +="<input type=\"checkbox\" name=\"sklad\" value=\"Ser\">Ser<br/>";
		if(szynka)body +="<input type=\"checkbox\" name=\"sklad\" value=\"Szynka\" checked>Szynka<br/>";
		else body +="<input type=\"checkbox\" name=\"sklad\" value=\"Szynka\">Szynka<br/>";
		
		
			body+="Cena: <input type =\"float\" name=\"cena\" value=\"" + cena + "\" />"
				+"<input type=\"hidden\" name=\"id\" value=\"" + ID + "\" />"
				+"</br></br> <input type=\"submit\" value=\"Update\" />"
				+"</br></br></body></html>";
		
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
