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
            <h1>Team Info</h1>
            <table border="1">
                <form action="/LeagueManagement/teamManager.html" method="GET"></tr>
                    <td>Team name:</td>
                    <td><input type="text" name="name"/></td>
                    <td><input type="submit" name="action" value="insert"/>
                    </tr>
                </form>         
               
                        
            </table>
        </div>
    </body>
</html>