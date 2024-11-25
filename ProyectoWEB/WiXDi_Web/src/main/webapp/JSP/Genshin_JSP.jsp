<%-- 
    Document   : Genshin_JSP
    Created on : 24 nov 2024, 12:38:28 a.m.
    Author     : haloa
--%>

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
        <title>WiXDi - Genshin Impact</title>
        <link rel="stylesheet" href="../CSS/Comunidades.css">
    </head>
    <body>
        <header>
            <div class="logo">WiXDi Games</div>
            <nav>
                <ul>
                    <li><a href="#" onclick="window.location.href = 'MenuPrincipal.jsp';">Perfil</a></li>
                    <li><a href="#" onclick="window.location.href = 'Genshin_JSP.jsp';" class="active">Genshin Impact</a></li>
                    <li><a href="#" onclick="window.location.href = 'Valorant_JSP.jsp';">Valorant</a></li>
                    <li><a href="#" onclick="window.location.href = 'LeagueOfLegends_JSP.jsp';">League of Legends</a></li>
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
                        if (usuario != null) {
                            String avatar = (usuario.getImagen() != null && !usuario.getImagen().isEmpty())
                                    ? "data:image/png;base64," + StringEscapeUtils.escapeHtml4(usuario.getImagen())
                                    : "../imagenes/icon.png";
                            String nombreUsuario = StringEscapeUtils.escapeHtml4(usuario.getNombre());
                    %>
                    <img src="<%= avatar %>" alt="Avatar" class="avatar">
                    <input type="text" placeholder="Escribe una publicación en WiXDi Games">
                    <button class="post-button">📷</button>
                    <%
                        } else {
                    %>
                    <p>Usuario no autenticado. Por favor, inicie sesión.</p>
                    <%
                        }
                    %>
                </div>

                <div class="posts">
                    <div class="post">
                        <div class="post-header">
                            <img src="../imagenes/icon.png" alt="Avatar" class="avatar">
                            <span class="username"><%= StringEscapeUtils.escapeHtml4("Usuario123") %></span>
                        </div>
                        <div class="post-content">
                            <p>Primer post: ¡Hola a todos!</p>
                            <img src="../imagenes/Genshin.jpg" alt="Imagen del post" class="post-image">
                        </div>
                        <div class="comments-section">
                            <div class="comments">
                                <div class="comment">
                                    <img src="../imagenes/icon.png" alt="User Avatar" class="avatar">
                                    <div class="comment-content">
                                        <div class="comment-username"><%= StringEscapeUtils.escapeHtml4("Usuario456") %></div>
                                        <div class="comment-text">¡Bienvenido a la comunidad! 🎮</div>
                                    </div>
                                </div>
                            </div>
                            <div class="comment-form">
                                <%
                                    if (usuario != null) {
                                        String avatarComment = (usuario.getImagen() != null && !usuario.getImagen().isEmpty())
                                                ? "data:image/png;base64," + StringEscapeUtils.escapeHtml4(usuario.getImagen())
                                                : "../imagenes/icon.png";
                                %>
                                <img src="<%= avatarComment %>" alt="User Avatar" class="avatar">
                                <input type="text" class="comment-input" placeholder="Escribe un comentario...">
                                <button class="comment-button">Comentar</button>
                                <%
                                    } else {
                                %>
                                <p>Usuario no autenticado. Por favor, inicie sesión para comentar.</p>
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>

        <script src="../JS/script.js"></script>
    </body>
</html>
