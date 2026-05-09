<%-- 
    Document   : getAccountsByFirstLetter
    Created on : May 7, 2026
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                width: 450px;
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

        </style>

    </head>

    <body>

        <div class="container">

            <h1>Search Account By First Letter</h1>

            <form action="getAccountsByFirstLetterServlet" method="POST">

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

            <div class="result">
                <strong>List Of Account:</strong><br>
                ${List_Of_Account}
            </div>

        </div>

    </body>
</html>