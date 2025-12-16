<html>
<head>
    <title>Login</title>
</head>

<body>

	<h3 style="color:red;">${msg}</h3> 
    <% 
        String m = (String) session.getAttribute("msg"); 
        if (m != null) {
    %>
        <h1 style="color:red;"><%= m %></h1>
    <%
            session.removeAttribute("msg");
        }
    %>

    <form action="${pageContext.request.contextPath}/home" method="post">
        
        EMAIL: <input type="text" name="email">
        <br>

        PASSWORD: <input type="text" name="password">
        <br>

        <input type="submit" value="login">
    </form>
	<form action="/" method="get">

	       <input type="submit" value="Register">
	   </form>
	   
</body>
</html>
