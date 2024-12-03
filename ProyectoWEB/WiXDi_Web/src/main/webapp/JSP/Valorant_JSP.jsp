<%-- 
    Document   : Genshin_JSP
    Created on : 24 nov 2024, 12:38:28 a.m.
    Author     : haloa
--%>

<%@page import="enums.Categoria"%>
<%@page import="control.Fachada"%>
<%@page import="java.util.List"%>
<%@page import="dominio.Post"%>
<%@page import="org.apache.commons.text.StringEscapeUtils"%>
<%@page import="dominio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession(false);
    Usuario usuario = objSesion != null ? (Usuario) objSesion.getAttribute("usuario") : null;
    Fachada f = new Fachada();
    List<Post> posts = f.consultarPostsCategoria(Categoria.Valorant);
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>WiXDi - Valorant</title>
        <link rel="stylesheet" href="../CSS/Comunidades.css">
    </head>
    <body>
        <header>
            <div class="logo">WiXDi Games</div>
            <nav>
                <ul>
                    <li><a href="#" onclick="window.location.href = 'MenuPrincipal.jsp';">Perfil</a></li>
                    <li><a href="#" onclick="window.location.href = 'Genshin_JSP.jsp';" >Genshin Impact</a></li>
                    <li><a href="#" onclick="window.location.href = 'Valorant_JSP.jsp';" class="active">Valorant</a></li>
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
                    <% if (usuario != null) {
                            String avatar = (usuario.getImagen() != null && !usuario.getImagen().isEmpty())
                                    ? "data:image/png;base64," + StringEscapeUtils.escapeHtml4(usuario.getImagen())
                                    : "../imagenes/icon.png";
                    %>
                    <img src="<%= avatar%>" alt="Avatar" class="avatar">
                    <!-- Campo de texto para la publicación -->
                    <input type="text" placeholder="Escribe una publicación en WiXDi Games" class="post-input">
                    <!-- Botón para subir una imagen -->
                    <button type="button" class="post-button">📷</button>
                    <% } %>
                </div>


                <script src="../JS/PostCreator.js"></script>
                <div class="posts">

                    <div class="post">
                        <%
                            for (int idx = 0; idx < posts.size(); idx++) {
                        %>
                        <div class="post-header">
                            <%
                                if (posts.get(idx).getAutor() != null) {
                                    String avatar = (posts.get(idx).getAutor().getImagen() != null && !posts.get(idx).getAutor().getImagen().isEmpty())
                                            ? "data:image/png;base64," + StringEscapeUtils.escapeHtml4(posts.get(idx).getAutor().getImagen())
                                            : "../imagenes/icon.png";
                            %>
                            <img src="<%= avatar%>" alt="Avatar" class="avatar">
                            <%
                                }
                            %>
                            <%
                                if (posts.get(idx).getAutor() != null) {
                                    String userPost = StringEscapeUtils.escapeHtml4("" + posts.get(idx).getAutor().getNombre());
                            %>
                            <span class="username"><%= userPost%></span>
                            <%
                                }
                            %>
                        </div>
                        <div class="post-content">
                            <%
                                if (posts.get(idx).getContenido() != null) {
                                    String content = StringEscapeUtils.escapeHtml4("" + posts.get(idx).getContenido());
                            %>
                            <p><%= content%></p>
                            <%
                                }
                            %>
                            <%
                                if (posts.get(idx).getAutor() != null) {
                                    if (posts.get(idx).getFoto() != null && !posts.get(idx).getFoto().isEmpty()) {
                                        String contentImage = "data:image/png;base64," + StringEscapeUtils.escapeHtml4(posts.get(idx).getFoto());


                            %>
                            <img src="<%= contentImage%>" alt="Imagen del post" class="post-image">
                            <%
                                    }
                                }
                            %>
                        </div>


                        <%
                            for (int i = 0; i < posts.get(idx).getComentarios().size(); i++) {
                        %>
                        <div class="comments-section">

                            <div class="comments">

                                <div class="comment">
                                    <%
                                        if (posts.get(idx).getComentarios().get(i) != null) {
                                            String avatar = (posts.get(idx).getComentarios().get(i).getUsuario().getImagen() != null && !posts.get(idx).getComentarios().get(i).getUsuario().getImagen().isEmpty())
                                                    ? "data:image/png;base64," + StringEscapeUtils.escapeHtml4(posts.get(idx).getComentarios().get(i).getUsuario().getImagen())
                                                    : "../imagenes/icon.png";
                                    %>
                                    <img src="<%= avatar%>" alt="User Avatar" class="avatar">
                                    <%
                                        }
                                    %>
                                    <%
                                        if (posts.get(idx).getComentarios().get(i).getUsuario().getNombre() != null) {
                                            String nombreUserComentario = StringEscapeUtils.escapeHtml4("" + posts.get(idx).getComentarios().get(i).getUsuario().getNombre());
                                            String comentariosPadres = StringEscapeUtils.escapeHtml4("" + posts.get(idx).getComentarios().get(i).getContenido());

                                    %>
                                    <div class="comment-content">
                                        <div class="comment-username"><%= nombreUserComentario%></div>
                                        <div class="comment-text"> <%= comentariosPadres%> </div>
                                        <%
                                            }
                                        %>
                                    </div>
                                </div>
                            </div>
                            <%
                                }

                            %>


                            <div class="comment-form">
                                <%                                    if (usuario != null) {
                                        String avatarComment = (usuario.getImagen() != null && !usuario.getImagen().isEmpty())
                                                ? "data:image/png;base64," + StringEscapeUtils.escapeHtml4(usuario.getImagen())
                                                : "../imagenes/icon.png";
                                %>

                                <img src="<%= avatarComment%>" alt="User Avatar" class="avatar">
                                <input type="text" class="comment-input" placeholder="Escribe un comentario...">
                                <button class="comment-button">Comentar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <%

                        }
                    }
                %>

            </section>
        </main>

        <script src="../JS/script.js"></script>
    </body>
</html>
