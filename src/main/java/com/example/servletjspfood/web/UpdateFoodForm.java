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
		
		Float cena = null;
		if(request.getParameter("cena") != null){
			cena = Float.parseFloat(request.getParameter("cena"));
		}
		
		int ID = Integer.parseInt(request.getParameter("foodId"));
		
		boolean vege = false;
		boolean normal = false;
		
		
		//ponizej jakies nulle sa
		if(request.getParameter("typ").toLowerCase().contains("Vegetarian".toLowerCase()))vege = true;
		if(request.getParameter("typ").toLowerCase().contains("Normal".toLowerCase()))normal = true;

		String body = "<html><body>";
		
		body+="<form action=\"/servletjspdemo/updateFood\"; method=\"get\">"
				+"Nazwa: <input type =\"text\" name=\"name\" value=\"" + name + "\" />";
				
		if(vege) body+= "Typ: <input type=\"radio\" name=\"typ\" value=\"Vegetarian\" checked>Vegetarian";
		else body+="Typ: <input type=\"radio\" name=\"typ\" value=\"Vegetarian\">Vegetarian";
		if(normal) body+= "Typ: <input type=\"radio\" name=\"typ\" value=\"Normal\" checked>Normal";
		else body+="Typ: <input type=\"radio\" name=\"typ\" value=\"Normal\">Normal";
		
		boolean salata = false;
		boolean ser = false;
		boolean szynka = false;
		
		if(request.getParameter("sklad").toLowerCase().contains("Salata".toLowerCase())) salata = true;
		if(request.getParameter("sklad").toLowerCase().contains("Ser".toLowerCase())) ser = true;
		if(request.getParameter("sklad").toLowerCase().contains("Szynka".toLowerCase())) szynka = true;
		
		if(salata)body +="Sklad: <br><input type=\"checkbox\" name=\"sklad\" value=\"Salata\" checked>Salata<br/>";
		else body +="Sklad: <br><input type=\"checkbox\" name=\"sklad\" value=\"Salata\">Salata<br/>";
		if(ser)body +="Sklad: <br><input type=\"checkbox\" name=\"sklad\" value=\"Ser\" checked>Ser<br/>";
		else body +="Sklad: <br><input type=\"checkbox\" name=\"sklad\" value=\"Ser\">Ser<br/>";
		if(szynka)body +="Sklad: <br><input type=\"checkbox\" name=\"sklad\" value=\"Szynka\" checked>Szynka<br/>";
		else body +="Sklad: <br><input type=\"checkbox\" name=\"sklad\" value=\"Szynka\">Szynka<br/>";
		
		
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
