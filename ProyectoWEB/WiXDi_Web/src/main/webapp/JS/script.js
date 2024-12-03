document.addEventListener("DOMContentLoaded", () => {
    // Navegación
    const navLinks = document.querySelectorAll("nav ul li a");
    const feedSection = document.querySelector(".feed");
    const communitySections = document.querySelectorAll(".communities, .Amistades");

    navLinks.forEach(link => {
        link.addEventListener("click", (event) => {
            event.preventDefault();
            navLinks.forEach(nav => nav.classList.remove("active"));
            link.classList.add("active");

            if (link.textContent === "Feed") {
                feedSection.style.display = "block";
                communitySections.forEach(section => section.style.display = "none");
            } else {
                feedSection.style.display = "none";
                communitySections.forEach(section => section.style.display = "block");
            }
        });
    });
});