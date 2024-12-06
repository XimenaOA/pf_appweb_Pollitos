<%@page import="dominio.Usuario"%>
<%@page import="org.apache.commons.text.StringEscapeUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession();
    Usuario usuario = objSesion != null ? (Usuario) objSesion.getAttribute("usuario") : null;
    String avatarSession = usuario.getImagen();
    String nombreSession = usuario.getNombre();
    String currentGame = "Valorant";
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
                    <input type="text" placeholder="Escribe una publicación en WiXDi Games" class="post-input">
                    <button type="button" class="post-button">📷</button>
                    <% }%>
                </div>

                <!-- Contenedor de posts vacío -->
                <div class="posts"></div>
            </section>
        </main>

        <!-- Archivos de JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="../JS/CrearPost.js"></script>
        <script src="../JS/ObtenerPosts.js"></script>
        <script src="../JS/script.js"></script>

        <!-- Variable global que contiene el nombre del juego -->
        <script>
                        var nombreSession = "<%= nombreSession%>";
                        var avatarSession = "<%= avatarSession%>";
                        var currentGame = "<%= currentGame%>"; // Esta variable estará disponible en todos tus archivos JS
                        console.log(currentGame); // Puedes verificar que se asignó correctamente
        </script>
    </body>
</html>
