<%-- 
    Document   : GetAllComputer
    Created on : May 14, 2026, 7:03:29 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Computers - MobileShop</title>

        
    </head>
    <body>

        <div class="container">

            <h1>Manager Computers</h1>

            <div class="result-title">
                <p>💻 List Of Computers: ${Signal}</p>
            </div>

            <p:if test="${empty List_Of_Computer}">
                <div class="empty-msg">
                    <strong>Oops!</strong> The computer list is currently empty.
                </div>
            </p:if>

            <p:if test="${not empty List_Of_Computer}">
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Ram</th>
                            <th>Price</th>
                            <th><th>
                        </tr> 
                    </thead>
                    <tbody>
                        <p:forEach items="${List_Of_Computer}" var="computer">
                            <tr>
                        <form action="MainController" method="get">
                            
                            <td>${computer.id}</td>

                            <td>${computer.name}</td>
                            <td>${computer.description}</td>
                            <td>${computer.ram}</td>
                            <td>$${computer.price}</td>
                            <td>
                                <input type="submit" name="action" value ="Delete"/>
                                <input type ="hidden" name="id" value="${computer.id}">
                                
                            </td>
                        </form>
                        </tr>


                    </p:forEach>
                    </tbody>
                </table>
            </p:if>

        </div>

    </body>
</html>