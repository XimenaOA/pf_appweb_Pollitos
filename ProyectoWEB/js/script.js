  // Función para mostrar la sección seleccionada y cambiar la imagen principal
  function mostrarSeccion(seccion) {

    // Ocultar todas las secciones
    var secciones = document.querySelectorAll('.juego-contenido');
    secciones.forEach(function(sec) {
        sec.style.display = "none";
    });

    // Mostrar la OPCION seleccionada
    document.getElementById(seccion).style.display = "block";

    // Cambiar la imagen 
    var imagenBanner = document.getElementById("imagen-banner");
    switch (seccion) {
        case 'Valorant':
            imagenBanner.src = "recursos/valorant.gif";  
            break;
        case 'Genshin':
            imagenBanner.src = "recursos/kinch.gif";   
            break;
        case 'LOL':
            imagenBanner.src = "recursos/lol.png";      // PONER IMAGEN QUE NO SE NOS OLVIDE
            break;
        case 'Fortnite':
            imagenBanner.src = "recursos/fortnite.png"; // PONER IMAGEN QUE NO SE NOS OLVIDE
            break;
        default:
            imagenBanner.src = "recursos/descarga.gif"; // PONER IMAGEN QUE NO SE NOS OLVIDE
    }
}

document.addEventListener('DOMContentLoaded', function() {
    mostrarSeccion('Valorant'); // Muestra Valorant y su imagen por defecto
});