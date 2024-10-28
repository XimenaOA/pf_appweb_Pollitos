function addComment() {
    // Obtener el valor del comentario ingresado
    const commentInput = document.getElementById("commentInput");
    const commentText = commentInput.value.trim();

    // Validar que no esté vacío
    if (commentText === "") {
        alert("Por favor, escribe un comentario.");
        return;
    }

    // Crear el elemento del nuevo comentario
    const commentSection = document.querySelector(".comments-list");
    const newComment = document.createElement("div");
    newComment.classList.add("comment");

    // Añadir contenido HTML al nuevo comentario
    newComment.innerHTML = `
        <img src="assets/recursos/kinich genshin impact icon pfp.jpg" alt="Avatar" class="avatar">
        <div class="comment-body">
            <span class="comment-username">TuUsuario</span>
            <p>${commentText}</p>
        </div>
    `;

    // Insertar el nuevo comentario en la sección de comentarios
    commentSection.appendChild(newComment);

    // Limpiar el campo de entrada de comentario
    commentInput.value = "";
}
