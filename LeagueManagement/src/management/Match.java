package management;

import java.io.Serializable;
import java.util.Date;

public class Match implements Serializable {
	private int id;
	private int cn_id, kh_id;
	private Date date;
	public Match(){
		
	}
	
	public Match(int cn_id, int kh_id, Date date){
		this.cn_id = cn_id;
		this.kh_id = kh_id;
		this.date = date;
	}
	
	public int getCn_id(){
		return this.cn_id;
	}
	public int getKh_id(){
		return this.kh_id;
	}
	public void setCn_id(int cn_id){
		this.cn_id = cn_id;
	}
	public void setKh_id(int kh_id){
		this.kh_id = kh_id;
	}
	public Date getDate(){
		return this.date;
	}
	public void setDate(Date date){
		this.date = date;
	}
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
}
