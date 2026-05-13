<%-- 
    Document   : getComputerByLetter
    Created on : May 9, 2026
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Search Computer</title>

        <style>

            body{
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
                background: linear-gradient(to right, #74ebd5, #ACB6E5);
                height: 100vh;

                display: flex;
                justify-content: center;
                align-items: center;
            }

            .container{
                width: 450px;
                background-color: white;
                padding: 40px;
                border-radius: 15px;
                box-shadow: 0px 5px 15px rgba(0,0,0,0.2);
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
                font-size: 18px;
                font-weight: bold;
                color: #444;
            }

            input[type="text"]{
                width: 100%;
                padding: 12px;
                margin-top: 8px;
                border: 1px solid #ccc;
                border-radius: 8px;
                font-size: 16px;
                box-sizing: border-box;
            }

            input[type="submit"]{
                width: 100%;
                padding: 12px;
                background-color: #4A90E2;
                color: white;
                border: none;
                border-radius: 8px;
                font-size: 18px;
                cursor: pointer;
                transition: 0.3s;
            }

            input[type="submit"]:hover{
                background-color: #357ABD;
            }

            .result{
                margin-top: 25px;
                padding: 15px;
                background-color: #f5f5f5;
                border-radius: 8px;
                color: #333;
                word-wrap: break-word;
            }

        </style>

    </head>

    <body>

        <div class="container">

            <h1>Search Computer</h1>

            <form action="MainController" method="POST">

                <div class="form-group">
                    <label>Enter Letter</label>
                    <input type="text" name="letter" 
                           placeholder="Example: A">
                </div>

                <input type="submit" 
                       name="action" 
                       value="Search Computer">

            </form>

            <div class="result">
                <strong>List Of Computer:</strong>
                <br><br>

                ${List_Of_Computer}
            </div>

        </div>

    </body>
</html>