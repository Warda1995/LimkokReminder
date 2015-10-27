package com.warda.anam.limkokreminder.model;

public class examsm {
	 int id;
	    String name,venue,date,time;
	    int status;
	    String created_at;
	 
	    // constructors
	    public examsm() {
	    }
	 
	    public examsm(String name, String venue,String date,String time) {
	        this.name = name;
	        this.venue = venue;
	        this.date = date;
	        this.time = time;
	    }
	    
	    public examsm(int id,String name, String venue,String date,String time) {
	    	this.id=id;
	        this.name = name;
	        this.venue = venue;
	        this.date = date;
	        this.time = time;
	    }
	 
	 
	    // setters
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public void setVenue(String venue) {
	        this.venue = venue;
	    }
	    public void setDate(String date) {
	        this.date = date;
	    }
	    public void setTime(String time) {
	        this.time = time;
	    }

	 
	    // getters
	    public long getId() {
	        return this.id;
	    }
	 
	    public String getName() {
	        return this.name;
	    }
	    public String getVenue() {
	        return this.venue;
	    }
	    public String getDate() {
	        return this.date;
	    }
	    public String getTime() {
	        return this.time;
	    }
	 
}
