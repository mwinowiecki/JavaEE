package com.example.servletjspfood.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletjspfood.domain.Food;

public class StorageService {
	
	private List<Food> db = new ArrayList<Food>();
	
	public void add(Food food){
		Food newFood = new Food(food.getId(), food.getName(), food.getName(), food.getTyp(), food.getCena());
		
		db.add(newFood);
	}
	
	public List<Food> getAllFood(){
		return db;
	}
	
	public void delete(int id){
		int i=0;
		while(db.get(i).id !=id)
			i++;
		if(db.get(i).id==id)
			db.remove(i);
	}
	
	public void update(Food food, int id){
		int i =0;
		while(db.get(i).id != id)
			i++;
		if(db.get(i).id==id)
			db.set(i, food);
	}
	
	public int size(){
		return db.size();
	}

}
