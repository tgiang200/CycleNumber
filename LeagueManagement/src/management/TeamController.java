package management;

import java.util.List;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  


import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
public class TeamController {  
	private TeamDAO teamDAO = new TeamDAO();;
     
    @RequestMapping("/teamManager")  
    public ModelAndView manageTeam(HttpServletRequest request,HttpServletResponse res) { 
    	String action = request.getParameter("action");
    	System.out.println(action);
    	if(action!=null){
    		if(action.equals("insert")){
    			String name = request.getParameter("name");
    			Team team = new Team(name);
    			teamDAO.saveTeam(team);
    			
    		}
    		
    		if(action.equals("update")){
    			int id = Integer.parseInt(request.getParameter("id"));
    			String name = request.getParameter("name");
    			Team team = teamDAO.getById(id);
    			team.setName(name);
    			teamDAO.updateTeam(team);
    			
    		}
    		
    		if(action.equals("delete")){
    			int id = Integer.parseInt(request.getParameter("id"));
    			Team team = teamDAO.getById(id);
    			teamDAO.deleteTeam(team);
    			
    		}
    	}
    	
    	List<Team> list = teamDAO.getTeams();
    	
		return new ModelAndView("listTeams", "teamList", list);
    	
    	
          
    }  
    	
    
      
}  