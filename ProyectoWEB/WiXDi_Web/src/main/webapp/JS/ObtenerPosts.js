// Función para cargar posts
function attachCommentInteractions() {
    const comments = document.querySelectorAll('.comment');
    comments.forEach(comment => {
        const repliesContainer = comment.querySelector('.replies-container');
        if (repliesContainer && repliesContainer.children.length > 0) {
            comment.classList.add('has-replies');
        }

        comment.addEventListener('click', function (e) {
            const comentarioPadre = this.getAttribute('data-comment-id');
            const url = `http://localhost:8080/WiXDi_Web/ObtenerRespuestasServlet?commentId=${encodeURIComponent(comentarioPadre)}`;

            // Si el clic fue en el input o el botón de respuesta, no hacer nada
            if (e.target.closest('.nested-comment-input, .nested-comment-button')) {
                return;
            }

            // Si el comentario está expandido, colapsar
            if (this.classList.contains('expanded')) {
                this.classList.remove('expanded');
                const repliesContainer = this.querySelector('.replies-container');
                repliesContainer.innerHTML = '';  // Limpiar las respuestas cuando se colapsa
            } else {
                // Si el comentario no está expandido, expandir y cargar las respuestas
                this.classList.add('expanded');

                fetch(url)
                        .then((response) => response.json())
                        .then((respuestas) => {
                            const repliesContainer = this.querySelector('.replies-container');

                            repliesContainer.innerHTML = '';  // Limpiar cualquier respuesta anterior

                            if (respuestas && respuestas.length > 0) {
                                const respuestasHTML = respuestas.map(respuesta => {
                                    const respuestaAvatar = respuesta.usuario?.imagen
                                            ? `data:image/png;base64,${respuesta.usuario.imagen}`
                                            : "../imagenes/icon.png";  // Imagen por defecto

                                    return `<div class="comment nested-comment" data-comment-id="${respuesta.id}">
                                    <img src="${respuestaAvatar}" alt="Avatar" class="avatar">
                                    <div class="comment-content">
                                        <div class="comment-username">${respuesta.usuario?.nombre || "Usuario desconocido"}</div>
                                        <div class="comment-text">${respuesta.contenido || "Respuesta vacía"}</div>
                                    </div>
                                </div>`;
                                }).join('');

                                repliesContainer.innerHTML = respuestasHTML;
                            } else {
                                repliesContainer.innerHTML = "<p>No hay respuestas aún.</p>";
                            }
                        })
                        .catch((error) => console.error("Error al cargar respuestas:", error));
            }
        });

        const nestedCommentButton = comment.querySelector('.nested-comment-button');

        nestedCommentButton.addEventListener('click', function (e) {
            e.stopPropagation();
            const postId = this.getAttribute('data-post-id');
            const parentCommentId = this.getAttribute('data-parent-comment-id');
            const nestedCommentInput = this.previousElementSibling;
            const commentText = nestedCommentInput.value.trim();
            if (commentText) {
                crearComentarioAnidado(postId, commentText, parentCommentId, repliesContainer);
                nestedCommentInput.value = '';
            }
        });
    });
}

function crearComentarioAnidado(postId, comentario, parentCommentId, repliesContainer) {
    const formData = new FormData();
    formData.append("comentario", comentario);
    formData.append("postID", postId);
    formData.append("parentCommentId", parentCommentId);

    fetch("http://localhost:8080/WiXDi_Web/CrearComentarioHijo", {
        method: "POST",
        body: formData
    })
            .then((response) => response.json())
            .then((data) => {
                if (data.success) {


                    const respuestaAvatar = avatarSession
                            ? `data:image/png;base64,${avatarSession}`
                            : "../imagenes/icon.png";  // Imagen por defecto

                    var respuestaHTML = `<div class="comment nested-comment" data-comment-id="${comentario.id}">
                                    <img src="${respuestaAvatar}" alt="Avatar" class="avatar">
                                    <div class="comment-content">
                                        <div class="comment-username">${nombreSession || "Usuario desconocido"}</div>
                                        <div class="comment-text">${comentario || "Respuesta vacía"}</div>
                                    </div>
                                </div>`;

                    repliesContainer.innerHTML += respuestaHTML;

                } else {
                    Swal.fire({
                        title: "Error",
                        text: data.error || "No se pudo responder.",
                        icon: "error",
                        confirmButtonText: "Aceptar"
                    });
                }
            });
}

function cargarPosts() {
    const url = `http://localhost:8080/WiXDi_Web/ObtenerPostsServlet_Valorant?categoria=${encodeURIComponent(currentGame)}`;

    fetch(url)
            .then((response) => response.json())
            .then((posts) => {
                const postContainer = document.querySelector(".posts");
                postContainer.innerHTML = "";

                posts.forEach((post) => {
                    const postElement = document.createElement("div");
                    postElement.classList.add("post");

                    const avatar = post.autor?.imagen
                            ? `data:image/png;base64,${post.autor.imagen}`
                            : "../imagenes/icon.png";

                    const contentImage = post.foto
                            ? `<img src="data:image/png;base64,${post.foto}" alt="Imagen del post" class="post-image">`
                            : "";

                    const commentsHTML = post.comentarios && post.comentarios.length > 0
                            ? post.comentarios.map((comentario) => {
                                const comentarioAvatar = comentario.usuario?.imagen
                                        ? `data:image/png;base64,${comentario.usuario.imagen}`
                                        : "../imagenes/icon.png";
                                const comentarioText = comentario.contenido || "Comentario vacío";

                                const nestedCommentsHTML = comentario.respuestas && comentario.respuestas.length > 0
                                        ? comentario.respuestas.map((respuesta) => {
                                            const respuestaAvatar = respuesta.usuario?.imagen
                                                    ? `data:image/png;base64,${respuesta.usuario.imagen}`
                                                    : "../imagenes/icon.png";
                                            return `
                                <div class="comment nested-comment" data-comment-id="${respuesta.id}">
                                    <img src="${respuestaAvatar}" alt="User Avatar" class="avatar">
                                    <div class="comment-content">
                                        <div class="comment-username">${respuesta.usuario?.nombre || "Usuario desconocido"}</div>
                                        <div class="comment-text">${respuesta.contenido || "Respuesta vacía"}</div>
                                    </div>
                                </div>
                            `;
                                        }).join('')
                                        : '';

                                return `
                        <div class="comment ${comentario.respuestas?.length > 0 ? 'has-replies' : ''}" data-comment-id="${comentario.id}">
                            <img data-avatar="${comentarioAvatar}" src="${comentarioAvatar}" alt="User Avatar" class="avatar">
                            <div class="comment-content">
                                <div class="comment-username" data-nombre="${comentario.usuario?.nombre}">${comentario.usuario?.nombre || "Usuario desconocido"}</div>
                                <div class="comment-text">${comentarioText}</div>
                                ${comentario.respuestas?.length > 0 ? '<span class="reply-indicator"></span>' : ''}
                            </div>
                            <div class="replies-container">
                                ${nestedCommentsHTML}
                            </div>
                            <div class="nested-comment-form">
                                <input type="text" class="nested-comment-input" placeholder="Responder...">
                                <button class="nested-comment-button" 
                                        data-post-id="${post.idPost}" 
                                        data-parent-comment-id="${comentario.id}">
                                    Responder
                                </button>
                            </div>
                        </div>
                    `;
                            }).join('')
                            : '<p>No hay comentarios aún.</p>';

                    postElement.innerHTML = `
                <div class="post-header">
                    <img src="${avatar}" alt="Avatar" class="avatar">
                    <span class="username">${post.autor?.nombre || "Usuario desconocido"}</span>
                </div>
                <div class="post-content">
                    <p>${post.contenido || ""}</p>
                    ${contentImage}
                </div>
                <div class="comments-section">
                    <div class="comments">
                        ${commentsHTML}
                    </div>
                </div>
                <div class="comment-form">
                    <input id="contenido+${post.idPost}" type="text" class="comment-input" placeholder="Escribe un comentario...">
                    <button class="comment-button" onclick="crearComentario(${post.idPost}, document.getElementById('contenido+${post.idPost}').value)">Comentar</button>
                </div>
            `;

                    postContainer.appendChild(postElement);
                });

                attachCommentInteractions();
            })
            .catch((error) => console.error("Error al cargar posts:", error));
}

document.addEventListener("DOMContentLoaded", () => {
    cargarPosts();
});

function crearComentario(postID, comentario) {
    const formData = new FormData();
    formData.append("comentario", comentario);
    formData.append("postID", postID);

    fetch("http://localhost:8080/WiXDi_Web/CrearComentarioServlet", {
        method: "POST",
        body: formData
    })
            .then((response) => response.json())
            .then((data) => {
                if (data.success) {
                    cargarPosts();
                } else {
                    Swal.fire({
                        title: "Error",
                        text: data.error || "No se pudo comentar.",
                        icon: "error",
                        confirmButtonText: "Aceptar"
                    });
                }
            });
}