<%-- 
    Document   : MenuPrincipal
    Created on : 23 nov 2024, 8:40:27 p.m.
    Author     : haloa
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dominio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession(false);
    Usuario usuario = (Usuario) objSesion.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menú</title>
        <link rel="stylesheet" href="../CSS/inicio.css">
    </head>
    <body>

        <!-- Navegador de arriba -->
        <header>
            <div class="logo">WiXDi Games</div>
            <nav>
                <ul>
                    <li><a href="#" class="active">Feed</a></li>
                    <li><a href="#" onclick="window.location.href='Genshin_JSP.jsp';">Genshin Impact</a></li>
                    <li><a href="#" onclick="window.location.href = 'Valorant_JSP.jsp';">Valorant</a></li>
                    <li><a href="#" onclick="window.location.href='LeagueOfLegends_JSP.jsp';">League of Legends</a></li>
                    <li><a href="#" onclick="window.location.href = 'Overwatch_JSP.jsp';">Overwatch</a></li>
                </ul>
            </nav>
            <div class="user-actions">
                <a href="#" class="icon-button profile">👤</a>
                <a href="#" class="icon-button settings">⚙️</a>
            </div>
        </header>

        <!-- Contenido del panel del perfil -->
        <main>
            <div class="profile-container">
                <%
                    if (usuario.getImagen() != null && !usuario.getImagen().isEmpty()) {
                %>
                <img src="data:image/png;base64,<%= usuario.getImagen()%>" alt="Avatar" class="profile-avatar">
                <%
                } else {
                %>
                <img src="../imagenes/icon.png" alt="Avatar por defecto" class="profile-avatar">
                <%
                    }
                %>
                <div class="profile-info">
                    <!-- En h2 va el nombre -->
                    <h2><%=usuario.getNombre()%> <%=usuario.getApellidoPaterno()%> <%=usuario.getApellidoMaterno()%></h2>
                    <p><strong>Informacion:</strong></p>
                    <p>Cumpleaños: </p>
                    <!-- cumpleaños -->
                    <%
                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                        String fechaFormateada = formato.format(usuario.getFechaNacimiento());
                    %>
                    <p><%=fechaFormateada%></p>
                    <p>Genero: </p>
                    <!-- genero -->
                    <p><%=usuario.getGenero()%></p>
                    <p>Contacto: </p>
                    <!-- contacto -->
                    <p><%=usuario.getCorreo()%></p>
                </div>
            </div>
        </main>

        <script src="../JS/script.js"></script>
    </body>
</html>

