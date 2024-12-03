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
            formData.append("image", selectedImageFile); // Se envía el archivo directamente
            // Enviar el post al servidor
            fetch("/WiXDi_Web-1.0-SNAPSHOT/CrearPostServlet", {
                method: "POST",
                body: formData
            })
                    .then((response) => {
                        console.log("Response Status:", response.status);  // Log para verificar el estado
                        console.log("Response Text:", response.text()); // Para verificar el contenido de la respuesta
                        if (response.ok) {
                            return response.json();  // Intentar parsear JSON
                        } else {
                            throw new Error("Error al crear el post, código de respuesta: " + response.status);
                        }
                    })
                    .then((data) => {
                        alert(data.message || "Post creado exitosamente.");
                    })
                    .catch((error) => {
                        console.error("Error de fetch:", error);
                        alert("Error al crear el post.");
                    });

        }
    });
});