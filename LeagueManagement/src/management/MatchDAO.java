package management;
import org.springframework.orm.hibernate3.HibernateTemplate;  
import java.util.*;  
public class MatchDAO {  
HibernateTemplate template;  

public MatchDAO(){
	this.setTemplate(template);
}

public void setTemplate(HibernateTemplate template) {  
    this.template = template;  
}  
//method to save Match  
public void saveMatch(Match e){  
    template.save(e);  
}  
//method to update Match  
public void updateMatch(Match e){  
    template.update(e);  
}  
//method to delete Match  
public void deleteMatch(Match e){  
    template.delete(e);  
}  
//method to return one Match of given id  
public Match getById(int id){  
    Match e=(Match)template.get(Match.class,id);  
    return e;  
}  
//method to return all Matchs  
public List<Match> getMatchs(){  
    List<Match> list=new ArrayList<Match>();  
    list=template.loadAll(Match.class);  
    return list;  
}  
}  