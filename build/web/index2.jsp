<%-- 
    Document   : index3
    Created on : Apr 28, 2026, 7:49:01 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div>Add computer Info</div>
        <form action = "AddComputerServlet" method = POST>
            Id    : <input type = "text" name= "nb1">
            Name  : <input type = "text" name = "nb2" /> 
            Description : <input type = "text" name = "nb3">
            Ram   : <input type= "text" name = "nb4" />
            price : <input type = "text" name = "nb5" />
            
            <input type= "submit" name = "action" value="AddInfo"> <br>
            Sum : ${TongTien} <br>
            ComputerList : ${List_Of_Computer}
        </form>
    </body>
</html>
