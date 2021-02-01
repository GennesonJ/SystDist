<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<jsp:include page='menu.jsp'/>

<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<p>
    <%
        String variable = (String)request.getAttribute("mes");
        out.println("Contenue de la variable envoyé par la servlet : " + variable);
    %>
</p>

<p>
    <%
        for(int i=1; i<=10;i++)
        {
            out.println("Bonjour ");
        }
    %>
</p>
    <%
        out.println((String)request.getAttribute("mes1"));
    %>
<p>

</p>

</body>
</html>