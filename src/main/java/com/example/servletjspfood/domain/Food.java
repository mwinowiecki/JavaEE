package com.example.servletjspfood.domain;

public class Food {
	public int id =0;
	private String nazwa2=" ";
	private String name=" ";	
	private String typ = " ";
	private float cena =0;
	public static int lastID=0;
	
	public Food(){
		super();
	}
	
	public Food(int id, String nazwa2, String name, String typ, float cena){
		super();
		this.id = id;
		this.nazwa2 = nazwa2;
		this.name = name;		
		this.typ = typ;
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
