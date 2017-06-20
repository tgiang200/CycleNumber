package management;

import java.io.Serializable;

public class Team implements Serializable{
	private int id;
	private String name;
	
	public Team(){
		
	}
	
	public Team(String name){
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name =  name;
	}
}
