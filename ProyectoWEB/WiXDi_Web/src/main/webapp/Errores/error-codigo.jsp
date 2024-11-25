<%-- 
    Document   : error-codigo
    Created on : 24 nov 2024, 6:18:42?p.m.
    Author     : haloa
--%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error HTTP</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f8d7da;
                color: #721c24;
                padding: 20px;
                margin: 0;
            }
            .error-container {
                max-width: 600px;
                margin: 50px auto;
                text-align: center;
                border: 1px solid #f5c6cb;
                background-color: #f8d7da;
                padding: 20px;
                border-radius: 8px;
            }
        </style>
    </head>
    <body>
        <div class="error-container">
            <h1>Ha ocurrido un error</h1>
            <p>Código HTTP: <%= response.getStatus()%></p>
            <p>Por favor, verifica tu solicitud o contacta al administrador.</p>
        </div>
    </body>
</html>