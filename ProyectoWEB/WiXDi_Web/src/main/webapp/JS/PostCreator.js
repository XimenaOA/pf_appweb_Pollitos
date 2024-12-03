document.addEventListener("DOMContentLoaded", () => {
    const postInput = document.querySelector(".post-input");
    const postButton = document.querySelector(".post-button"); // Botón de la cámara
    const postContainer = document.querySelector(".post-container"); // Contenedor de posts

    const fileInput = document.createElement("input");
    fileInput.type = "file";
    fileInput.accept = "image/*";
    fileInput.style.display = "none";
    document.body.appendChild(fileInput);

    let selectedImageFile = null;

    postButton.addEventListener("click", () => {
        fileInput.click();
    });

    fileInput.addEventListener("change", (event) => {
        const file = event.target.files[0];
        selectedImageFile = file ? file : null;
    });

    postInput.addEventListener("keypress", (event) => {
        if (event.key === "Enter") {
            const content = postInput.value.trim();
            if (!content) {
                alert("El contenido del post no puede estar vacío.");
                return;
            }

            const formData = new FormData();
            formData.append("content", content);
            if (selectedImageFile) {
                formData.append("image", selectedImageFile);
            }

            fetch("http://localhost:8080/WiXDi_Web/CrearPostServlet", {
                method: "POST",
                body: formData
            })
                    .then((response) => response.json()) // El servidor responde con JSON
                    .then((data) => {
                        if (data.success) {
                            // Mostrar alerta animada de éxito
                            Swal.fire({
                                title: "¡Éxito!",
                                text: "Tu post se ha publicado correctamente.",
                                icon: "success",
                                confirmButtonText: "Aceptar",
                                timer: 3000, // Tiempo de la alerta (3 segundos)
                                timerProgressBar: true, // Barra de progreso en la alerta
                            });

                            // Agregar el nuevo post al contenedor si lo deseas
                            const postElement = document.createElement("div");
                            postElement.classList.add("post");
                            postElement.innerHTML = `<p>${data.content}</p>`;
                            postContainer.prepend(postElement); // Agregar el nuevo post al inicio

                            postInput.value = ""; // Limpiar el input
                            selectedImageFile = null; // Reiniciar la imagen seleccionada
                        } else {
                            // Mostrar alerta de error si algo sale mal
                            Swal.fire({
                                title: "Error",
                                text: data.error || "No se pudo publicar el post.",
                                icon: "error",
                                confirmButtonText: "Aceptar",
                            });
                        }
                    });



        }
    });
});

document.addEventListener("DOMContentLoaded", () => {
    const postContainer = document.querySelector(".posts");

    // Función para cargar posts
    function cargarPosts() {
        fetch("http://localhost:8080/WiXDi_Web/ObtenerPostsServlet_Valorant")
                .then((response) => response.json())
                .then((posts) => {
                    console.log(posts);  // Verifica qué datos están llegando
                    // Limpiar el contenedor
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
                        <input type="text" class="comment-input" placeholder="Escribe un comentario...">
                        <button class="comment-button">Comentar</button>
                    </div>
                `;

                        postContainer.appendChild(postElement);
                    });
                })
                .catch((error) => console.error("Error al cargar posts:", error));
    }


    // Llamar a la función de cargar posts cada 3 segundos
    setInterval(cargarPosts, 3000); // Actualiza cada 3 segundos
    cargarPosts(); // Cargar los posts al inicio
});
