<%-- 
    Document   : codigo-excepcion
    Created on : 24 nov 2024, 6:20:56?p.m.
    Author     : haloa
--%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error de Aplicación</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fff3cd;
            color: #856404;
            padding: 20px;
            margin: 0;
        }
        .error-container {
            max-width: 600px;
            margin: 50px auto;
            text-align: center;
            border: 1px solid #ffeeba;
            background-color: #fff3cd;
            padding: 20px;
            border-radius: 8px;
        }
        .details {
            margin-top: 20px;
            font-size: 0.9em;
            color: #6c757d;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Error de Aplicación</h1>
        <p>Ocurrió una excepción inesperada.</p>
        <div class="details">
            <p>Detalles del error:</p>
            <pre><%= exception.getMessage() %></pre>
        </div>
    </div>
</body>
</html>

