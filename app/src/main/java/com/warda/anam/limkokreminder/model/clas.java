package com.warda.anam.limkokreminder.model;

public class clas {
	 int id;
	    String name,venue,day,time;
	    int status;
	    String created_at;
	 
	    // constructors
	    public clas() {
	    }
	 
	    public clas(String name, String venue,String day,String time) {
	        this.name = name;
	        this.venue = venue;
	        this.day = day;
	        this.time = time;
	    }
	    
	    public clas(int id,String name, String venue,String day,String time) {
	    	this.id=id;
	        this.name = name;
	        this.venue = venue;
	        this.day = day;
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
	    public void setDay(String day) {
	        this.day = day;
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
	    public String getDay() {
	        return this.day;
	    }
	    public String getTime() {
	        return this.time;
	    }
}
