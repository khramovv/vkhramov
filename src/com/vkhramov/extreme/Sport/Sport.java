package com.vkhramov.extreme.Sport;

public class Sport {
	     
	    //private variables
	    int _id;
	    String _name;
	    String _description;
	    String _area;
	     
	    // Empty constructor
	    public Sport(){
	         
	    }
	    // constructor
	    public Sport(int id, String name, String descriptoin, String area){
	        this._id = id;
	        this._name = name;
	        this._description = descriptoin;
	        this._area = area;
	    }
	     
	    // constructor
	    public Sport(String name, String descriptoin, String area){
	        this._name = name;
	        this._description = descriptoin;
	        this._area = area;
	    }
	    
	    // getting ID
	    public int getID(){
	        return this._id;
	    }
	     
	    // setting id
//	    public void setID(int id){
//	        this._id = id;
//	    }
	     
	    // getting name
	    public String getName(){
	        return this._name;
	    }
	     
	    // setting name
	    public void setName(String name){
	        this._name = name;
	    }
	     
	    // getting description
	    public String getDescription(){
	        return this._description;
	    }
	     
	    // setting description
	    public void setPDescription(String description){
	        this._description = description;
	    }
	    
	    // getting area
	    public String getArea(){
	        return this._area;
	    }
	     
	    // setting area
	    public void setArea(String area){
	        this._area = area;
	    }
	}
