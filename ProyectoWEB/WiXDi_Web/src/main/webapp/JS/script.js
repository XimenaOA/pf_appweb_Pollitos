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

    // Sistema de comentarios
    const commentForms = document.querySelectorAll('.comment-form');
    
    commentForms.forEach(form => {
        const input = form.querySelector('.comment-input');
        const button = form.querySelector('.comment-button');
        const commentsContainer = form.nextElementSibling;

        button.addEventListener('click', () => {
            const commentText = input.value.trim();
            if (commentText) {
                const newComment = document.createElement('div');
                newComment.className = 'comment';
                newComment.innerHTML = `
                    <img src="/assets/recursos/kinich genshin impact icon pfp.jpg" alt="User Avatar" class="avatar">
                    <div class="comment-content">
                        <div class="comment-username">Usuario${Math.floor(Math.random() * 1000)}</div>
                        <div class="comment-text">${commentText}</div>
                    </div>
                `;
                commentsContainer.appendChild(newComment);
                input.value = '';
            }
        });

        // Permitir enviar comentario con Enter
        input.addEventListener('keypress', (e) => {
            if (e.key === 'Enter') {
                button.click();
            }
        });
    });

    // Sistema de "Me gusta"
    const likeButtons = document.querySelectorAll('.post-action');
    likeButtons.forEach(button => {
        if (button.textContent.includes('Me gusta')) {
            button.addEventListener('click', function() {
                this.style.color = this.style.color === 'red' ? '#666' : 'red';
            });
        }
    });
});