<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="management.Team,java.util.List" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Team List</h1>
            <a href="addTeam.jsp">Add a team</a>
            <table border="1">
                <th>No</th>
                <th>Name</th>
               <th>Action</th>
               <% List<Team> teams = (List<Team>) request.getAttribute("teamList") ; 
              
                for(Team team : teams ){%>
                	 </tr>
                    <td><%=team.getId()%></td>
                    <td><%=team.getName()%></td>
                    <td><a href="updateTeam.jsp?id=<%=team.getId()%>&name=<%=team.getName()%>">Update</a>
                    <a href="/LeagueManagement/teamManager.html?action=delete&id=<%=team.getId()%>">Delete</a></td>
                    </tr>
                <% }%>           
               
                        
            </table>
        </div>
    </body>
</html>