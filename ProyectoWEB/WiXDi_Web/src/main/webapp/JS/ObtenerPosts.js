/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

// Función para cargar posts
function cargarPosts() {
        const url = `http://localhost:8080/WiXDi_Web/ObtenerPostsServlet_Valorant?categoria=${encodeURIComponent(currentGame)}`;

    fetch(url)
            .then((response) => response.json())
            .then((posts) => {
                console.log(posts);  // Verifica qué datos están llegando
                // Limpiar el contenedor
                const postContainer = document.querySelector(".posts");

                postContainer.innerHTML = "";

                // Agregar los posts al contenedor
                posts.forEach((post) => {
                    const postElement = document.createElement("div");
                    postElement.classList.add("post");

                    // Avatar del autor
                    const avatar = post.autor?.imagen
                            ? `data:image/png;base64,${post.autor.imagen}`
                            : "../imagenes/icon.png";

                    // Imagen del post
                    const contentImage = post.foto
                            ? `<img src="data:image/png;base64,${post.foto}" alt="Imagen del post" class="post-image">`
                            : "";

                    // Construir el HTML del post
                    postElement.innerHTML = `
                    <div class="post-header">
                        <img src="${avatar}" alt="Avatar" class="avatar">
                        <span class="username">${post.autor?.nombre || "Usuario desconocido"}</span>
                    </div>
                    <div class="post-content">
                        <p>${post.contenido || ""}</p>
                        ${contentImage}
                    </div>

                    <!-- Sección de comentarios -->
                    <div class="comments-section">
                        <div class="comments">
                            ${
                            post.comentarios && post.comentarios.length > 0
                            ? post.comentarios.map((comentario) => {
                                const comentarioAvatar = comentario.usuario?.imagen
                                        ? `data:image/png;base64,${comentario.usuario.imagen}`
                                        : "../imagenes/icon.png";
                                const comentarioText = comentario.contenido || "Comentario vacío";

                                return `
                                              <div class="comment">
                                                  <img src="${comentarioAvatar}" alt="User Avatar" class="avatar">
                                                  <div class="comment-content">
                                                      <div class="comment-username">${comentario.usuario?.nombre || "Usuario desconocido"}</div>
                                                      <div class="comment-text">${comentarioText}</div>
                                                  </div>
                                              </div>
                                          `;
                            }).join('')
                            : '<p>No hay comentarios aún.</p>'
                            }
                        </div>
                    </div>

                    <!-- Formulario para agregar un nuevo comentario -->
                    <div class="comment-form">
                        <input id="contenido+${post.idPost}" type="text" class="comment-input" placeholder="Escribe un comentario...">
                        <button class="comment-button" onclick="crearComentario(${post.idPost}, document.getElementById('contenido+${post.idPost}').value)">Comentar</button>
                    </div>
                `;

                    postContainer.appendChild(postElement);
                });
            })
            .catch((error) => console.error("Error al cargar posts:", error));
}

document.addEventListener("DOMContentLoaded", () => {



    // Llamar a la función de cargar posts cada 3 segundos
    cargarPosts(); // Cargar los posts al inicio
});

function crearComentario(postID, comentario) {

    const formData = new FormData();
    formData.append("comentario", comentario);
    formData.append("postID", postID);


    fetch("http://localhost:8080/WiXDi_Web/CrearComentarioServlet", {
        method: "POST",
        body: formData
    })
            .then((response) => response.json()) // El servidor responde con JSON
            .then((data) => {
                if (data.success) {

                    cargarPosts();

                } else {
                    // Mostrar alerta de error si algo sale mal
                    Swal.fire({
                        title: "Error",
                        text: data.error || "No se pudo comentar.",
                        icon: "error",
                        confirmButtonText: "Aceptar"
                    });
                }
            });
}