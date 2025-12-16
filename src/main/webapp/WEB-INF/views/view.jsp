<%@ page import="java.util.List" %>
<%@ page import="com.TaskManagement.entity.Task" %>

<html>
	<head>
		<title>Tasks</title>
	</head>
	
	<body>
		<h3 style="color:blue;"> Dream it Achieve it </h3>
	<%	
		List <Task> task =(List<Task>)request.getAttribute("list"); 
			
			if(task.isEmpty())  
			
			{			
	%>
				<h2>Task is empty<h2>
					
	<%			
			}
			
			else
			{
				
			
	%>				
				<table border="1" cellpadding="5" cellspacing="0">
					<tr>
						<th>Task</th>
						<th>Duration</th>
					</tr>
					
					<% for(Task t : task) 
					{
					%>
					
					<tr>
						<td><%= t.getName()%></td>
						<td><%= t.getDuration()%></td>
					
					</tr>	
						
				<%	}
					%>
				</table>
	<%			
				 
			}
	%>	
	<form action = "/task/addtask" method = "get">
		<input type = "submit" value = "AddTask">
	</form>
	
	<form action = "/logout" method = "get">
			<input type = "submit" value = "logout">
		</form>
	
		<form action = "/home" method = "get">
					<input type = "submit" value = "home">
				</form>
	</body>        
<html>