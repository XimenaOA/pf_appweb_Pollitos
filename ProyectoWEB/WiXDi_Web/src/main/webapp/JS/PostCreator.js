document.addEventListener("DOMContentLoaded", () => {
    const postInput = document.querySelector(".post-input");
    const postButton = document.querySelector(".post-button"); // Botón de la cámara
    // Crear un input de archivo oculto globalmente
    const fileInput = document.createElement("input");
    fileInput.type = "file";
    fileInput.accept = "image/*";
    fileInput.style.display = "none"; // Oculto del usuario
    document.body.appendChild(fileInput);
    let selectedImageFile = null; // Variable para almacenar la imagen seleccionada

    // Cuando se presiona el botón de imagen
    postButton.addEventListener("click", () => {
        fileInput.click(); // Activa el input de archivo
    });

    // Manejar la selección de archivo
    fileInput.addEventListener("change", (event) => {
        const file = event.target.files[0];
        if (file) {
            selectedImageFile = file; // Guardar el archivo seleccionado
            alert("Imagen cargada correctamente."); // Para verificar la carga
        } else {
            selectedImageFile = null; // Asegurarse de que no hay imagen seleccionada
        }
    });

    // Cuando se presiona Enter en el campo de texto
    postInput.addEventListener("keypress", (event) => {
        if (event.key === "Enter") {
            const content = postInput.value.trim();
            if (!content) {
                alert("El contenido del post no puede estar vacío.");
                return;
            }

            // Crear un FormData para enviar el contenido y la imagen
            const formData = new FormData();
            formData.append("content", content);

            // Solo agregar la imagen si se seleccionó una
            if (selectedImageFile) {
                formData.append("image", selectedImageFile); // Se envía el archivo directamente
            }

            // Aquí llamas a tu función de fetch para enviar el FormData
            fetch("http://localhost:8080/WiXDi_Web/CrearPostServlet", {
                method: "POST",
                body: formData
            })
                .then((response) => response.text())
                .then((text) => {
                    console.log("Respuesta del servidor:", text);
                    alert("Post enviado exitosamente.");
                })
                .catch((error) => {
                    console.error("Error al enviar el post:", error);
                    alert("Error al enviar el post.");
                });
        }
    });
});
