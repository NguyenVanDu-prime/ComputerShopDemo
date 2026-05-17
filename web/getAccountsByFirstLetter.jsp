<%-- 
    Document   : getAccountsByFirstLetter
    Created on : May 7, 2026
    Author     : admin
--%>

<%@page import="model.AccountDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Account</title>

        <style>
            body{
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
                background: #f4f6f9;
            }

            .container{
                width: 550px; /* Tăng độ rộng một chút để chứa bảng vừa vặn hơn */
                margin: 80px auto;
                background: white;
                padding: 30px;
                border-radius: 12px;
                box-shadow: 0 4px 10px rgba(0,0,0,0.15);
            }

            h1{
                text-align: center;
                color: #333;
                margin-bottom: 30px;
            }

            .form-group{
                margin-bottom: 20px;
            }

            label{
                font-weight: bold;
                color: #555;
            }

            input[type="text"]{
                width: 100%;
                padding: 12px;
                margin-top: 8px;
                border: 1px solid #ccc;
                border-radius: 8px;
                font-size: 15px;
                box-sizing: border-box;
            }

            input[type="submit"]{
                width: 100%;
                padding: 12px;
                background: #4CAF50;
                color: white;
                border: none;
                border-radius: 8px;
                font-size: 16px;
                cursor: pointer;
                transition: 0.3s;
            }

            input[type="submit"]:hover{
                background: #45a049;
            }

            .result{
                margin-top: 25px;
                padding: 15px;
                background: #f1f1f1;
                border-radius: 8px;
                color: #333;
            }

            /* CSS mới cho Table */
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 15px;
            }

            th, td {
                padding: 12px;
                border: 1px solid #ddd;
                text-align: left;
            }

            th {
                background-color: #4CAF50;
                color: white;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
        </style>
    </head>

    <body>

        <div class="container">

            <h1>Search Account By First Letter</h1>

            <form action="MainController" method="POST">

                <div class="form-group">
                    <label>Enter Name:</label>

                    <input type="text" 
                           name="name" 
                           placeholder="Input first letter..." />
                </div>

                <input type="submit" 
                       name="action" 
                       value="Search" />

            </form>

            <h1>Scriptlet</h1>
            <%
                ArrayList<AccountDTO> listOfAccount = (ArrayList<AccountDTO>) request.getAttribute("List_Of_Account");
                if (listOfAccount != null && !listOfAccount.isEmpty()) {
            %>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Password</th>
                            <th>Role</th>
                        </tr>
                    </thead>
                    <tbody>
            <%
                    for (AccountDTO account : listOfAccount) {
            %>
                        <tr>
                            <td><%= account.getName() %></td>
                            <td><%= account.getPassword() %></td>
                            <td><%= account.getRole() %></td>
                        </tr>
            <%
                    }
            %>
                    </tbody>
                </table>
            <%
                } else {
            %>
                <p>List is Empty</p>
            <%
                }
            %>

            <h1>JSTL</h1>
            <b:if test="${empty List_Of_Account}">
                <p>List is Empty</p>
            </b:if>

            <b:if test="${not empty List_Of_Account}">
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Password</th>
                            <th>Role</th>
                        </tr>
                    </thead>
                    <tbody>
                        <b:forEach items="${List_Of_Account}" var="account">
                            <tr>
                                <td>${account.name}</td>
                                <td>${account.password}</td>
                                <td>${account.role}</td>
                            </tr>
                        </b:forEach>  
                    </tbody>
                </table>
            </b:if>

        </div>

    </body>
</html>