package com.warda.anam.limkokreminder.model;

public class asm {
	 int id;
	    String name,title,dd,bo;
	    int status;
	    String created_at;
	 
	    // constructors
	    public asm() {
	    }
	 
	    public asm(String name, String title,String dd,String bo) {
	        this.name = name;
	        this.title = title;
	        this.dd = dd;
	        this.bo = bo;
	    }
	    
	    public asm(int id,String name, String title,String dd,String bo) {
	    	this.id=id;
	        this.name = name;
	        this.title = title;
	        this.dd = dd;
	        this.bo = bo;
	    }
	 
	 
	    // setters
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public void setTitle(String title) {
	        this.title = title;
	    }
	    public void setDd(String dd) {
	        this.dd = dd;
	    }
	    public void setBo(String bo) {
	        this.bo = bo;
	    }

	 
	    // getters
	    public long getId() {
	        return this.id;
	    }
	 
	    public String getName() {
	        return this.name;
	    }
	    public String getTitle() {
	        return this.title;
	    }
	    public String getDd() {
	        return this.dd;
	    }
	    public String getBo() {
	        return this.bo;
	    }
}