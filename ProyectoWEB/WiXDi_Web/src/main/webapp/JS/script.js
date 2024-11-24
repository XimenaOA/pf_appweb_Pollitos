/* Aqui ira el funcionamiendo dinamico para cambiar entre las comunidades y feeds */
document.addEventListener("DOMContentLoaded", () => {
    const navLinks = document.querySelectorAll("nav ul li a");
    const feedSection = document.querySelector(".feed");
    const communitySections = document.querySelectorAll(".communities, .Amistades");

    navLinks.forEach(link => {
        link.addEventListener("click", (event) => {
            event.preventDefault();

            // Quitar la clase 'active' de todos los enlaces
            navLinks.forEach(nav => nav.classList.remove("active"));
            // Añadir la clase 'active' al enlace actual
            link.classList.add("active");

            // Mostrar u ocultar las secciones basadas en el enlace seleccionado
            if (link.textContent === "Feed") {
                feedSection.style.display = "block";
                communitySections.forEach(section => section.style.display = "none");
            } else {
                feedSection.style.display = "none";
                communitySections.forEach(section => section.style.display = "block");
                // Puedes mostrar contenido específico según la comunidad seleccionada
                // Por ejemplo, aquí podrías cargar contenido dinámico de Genshin Impact, Valorant, etc.
            }
        });
    });
});