package management;


import org.hibernate.*;

import java.util.*;  
public class TeamDAO {  
	
SessionFactory template;  
Session session;

public TeamDAO(){
	
	template = HibernateUtil.getSessionFactory();
	session = template.openSession();
}


//method to save Team  
public void saveTeam(Team e){  
	

	session.beginTransaction();
	session.save(e);  
	session.getTransaction().commit();
	
}  
//method to update Team  
public void updateTeam(Team e){  
	session.beginTransaction();
    session.update(e);  
    session.getTransaction().commit();
}  
//method to delete Team  
public void deleteTeam(Team e){  
	session.beginTransaction();
    session.delete(e);  
    session.getTransaction().commit();
}  
//method to return one Team of given id  
public Team getById(int id){  
	session.beginTransaction();
    Team e=(Team)session.get(Team.class,id);  
    session.getTransaction().commit();
    return e;  
}  
//method to return all Teams  
public List<Team> getTeams(){  
	session.beginTransaction();
    List<Team> list=new ArrayList<Team>();  
    list=session.createCriteria(Team.class).list(); 
    session.getTransaction().commit();
    return list;  
}  

public void close(){
	this.session.close();

}

}  