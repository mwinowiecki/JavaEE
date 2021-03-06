package com.example.servletjspfood.domain;

import java.util.Date;

public class Food {
	public int id =0;
	private String nazwa2="";
	private String name="empty";	
	private String typ = "";
	private String sklad = "";
	private float cena =0;
	private Date dom = new Date(); //date of make
	public static int lastID=0;
	
	public Food(){
		super();
	}
	
	public Food(int id, String nazwa2, String name, String typ, String sklad, float cena){
		super();
		this.id = id;
		this.nazwa2 = nazwa2;
		this.name = name;		
		this.typ = typ;
		this.sklad = sklad;
		this.cena=cena;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getTyp(){
		return typ;
	}
	
	public void setTyp(String typ){
		this.typ=typ;
	}
	
	public String getSklad(){
		return sklad;
	}
	
	public void setSklad(String sklad){
		this.sklad=sklad;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public float getCena(){
		return cena;
	}
	
	public void setCena(float cena){
		this.cena=cena;
	}

}
