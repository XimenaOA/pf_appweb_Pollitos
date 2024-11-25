<%-- 
    Document   : MenuPrincipal
    Created on : 23 nov 2024, 8:40:27 p.m.
    Author     : haloa
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.text.StringEscapeUtils"%>
<%@page import="dominio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession(false);
    Usuario usuario = objSesion != null ? (Usuario) objSesion.getAttribute("usuario") : null;
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
                    <li><a href="#" class="active">Perfil</a></li>
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
                    if (usuario != null) {
                        String avatar = (usuario.getImagen() != null && !usuario.getImagen().isEmpty()) 
                                ? "data:image/png;base64," + StringEscapeUtils.escapeHtml4(usuario.getImagen()) 
                                : "../imagenes/icon.png";
                        String nombre = StringEscapeUtils.escapeHtml4(usuario.getNombre());
                        String apellidoPaterno = StringEscapeUtils.escapeHtml4(usuario.getApellidoPaterno());
                        String apellidoMaterno = StringEscapeUtils.escapeHtml4(usuario.getApellidoMaterno());
                        String generoString = String.valueOf(usuario.getGenero());
                        String genero = StringEscapeUtils.escapeHtml4(generoString);
                        String correo = StringEscapeUtils.escapeHtml4(usuario.getCorreo());
                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                        String fechaFormateada = formato.format(usuario.getFechaNacimiento());
                %>
                <img src="<%= avatar %>" alt="Avatar" class="profile-avatar">
                <div class="profile-info">
                    <!-- En h2 va el nombre -->
                    <h2><%= nombre %> <%= apellidoPaterno %> <%= apellidoMaterno %></h2>
                    <p><strong>Información:</strong></p>
                    <p>Cumpleaños: </p>
                    <!-- cumpleaños -->
                    <p><%= StringEscapeUtils.escapeHtml4(fechaFormateada) %></p>
                    <p>Género: </p>
                    <!-- genero -->
                    <p><%= genero %></p>
                    <p>Contacto: </p>
                    <!-- contacto -->
                    <p><%= correo %></p>
                </div>
                <%
                    } else {
                %>
                <div class="profile-info">
                    <h2>Usuario no autenticado</h2>
                    <p>Por favor, inicie sesión.</p>
                </div>
                <%
                    }
                %>
            </div>
        </main>

        <script src="../JS/script.js"></script>
    </body>
</html>
