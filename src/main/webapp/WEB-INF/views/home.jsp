	<%@ page import="com.TaskManagement.entity.Userss" %>
	<html>
	    <head>
	        <title>Home</title>
	    </head>
	
	    <body>
	
	        <h1>${msg}</h1>
			
			<h3 style="color:red">${NotFound}</h3> <!--if task not found then this will print-->  

	
	        <%
	            Userss u = (Userss) session.getAttribute("user");
	            if (u == null) {
	       
	            session.setAttribute("msg", "Please login again!");
				
				response.sendRedirect("login");
				
	            return;   
	            }
	        %>
	
	        <h1>Welcome, <%= u.getName() %></h1>    
	                
	        <form action="/task/addtask" method="get">    
	            <input type="submit" value="Add Task">
	        </form>
	        
	        <form action="/task/view" method="get">
	            <input type="submit" value="View Task">
	        </form>
	
			<form action="/logout" method="get">
			     <input type="submit" value="Logout">
			 </form>
	
				   
	    </body>
	</html>
