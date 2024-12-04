/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


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
