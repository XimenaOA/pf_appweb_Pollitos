<%-- 
    Document   : Genshin_JSP
    Created on : 24 nov 2024, 12:38:28 a.m.
    Author     : haloa
--%>

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
        <title>WiXDi - Genshin Impact</title>
        <link rel="stylesheet" href="../CSS/Comunidades.css">
    </head>
    <body>
        <header>
            <div class="logo">WiXDi Games</div>
            <nav>
                <ul>
                    <li><a href="#" onclick="window.location.href = 'MenuPrincipal.jsp';">Feed</a></li>
                    <li><a href="#" class="active">Genshin Impact</a></li>
                    <li><a href="#" onclick="window.location.href = 'Valorant_JSP.jsp';">Valorant</a></li>
                    <li><a href="#" onclick="window.location.href = 'LeagueOfLegends_JSP.jsp';">League Of Legends</a></li>
                    <li><a href="#" onclick="window.location.href = 'Overwatch_JSP.jsp';">Overwatch</a></li>
                </ul>
            </nav>
            <div class="user-actions">
                <a href="#" class="icon-button profile">👤</a>
                <a href="#" class="icon-button settings">⚙️</a>
            </div>
        </header>

        <main>
            <section class="feed">
                <div class="post-creator">
                    <%
                        if (usuario.getImagen() != null && !usuario.getImagen().isEmpty()) {
                    %>
                    <img src="data:image/png;base64,<%= usuario.getImagen()%>" alt="Avatar" class="avatar">
                    <%
                    } else {
                    %>
                    <img src="../imagenes/icon.png" alt="Avatar por defecto" class="avatar">
                    <%
                        }
                    %>
                    <input type="text" placeholder="Escribe una publicación en WiXDi Games">
                    <button class="post-button">📷</button>
                    <button class="post-button">🎥</button>
                </div>

                <div class="posts">
                    <div class="post">
                        <div class="post-header">
                            <img src="/assets/recursos/kinich genshin impact icon pfp.jpg" alt="Avatar" class="avatar">
                            <span class="username">Usuario123</span>
                        </div>
                        <div class="post-content">
                            <p>Primer post: ¡Hola a todos!</p>
                            <img src="/assets/recursos/kinichUlti.gif" alt="Imagen del post" class="post-image">
                        </div>
                    </div>
                </div>
            </section>
        </main>

        <script src="../JS/script.js"></script>
    </body>
</html>

