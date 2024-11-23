<%-- 
    Document   : registrer
    Created on : 23 nov 2024, 12:39:54 a.m.
    Author     : haloa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login y Registro</title>

    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="/CSS/LogInstyle.css" />
</head>

<body>
    <main>
        <div class="contenedor__todo">
            <div class="caja__trasera">
                <div class="caja__trasera-login">
                    <h3>¿Ya tienes una cuenta?</h3>
                    <p>Inicia sesión para hablar con la comunidad</p>
                    <button id="btn__iniciar-sesion">Iniciar Sesión</button>
                </div>
                <div class="caja__trasera-register">
                    <h3>¿Aún no tienes una cuenta?</h3>
                    <p>Regístrate para que puedas unirte a la comunidad</p>
                    <button id="btn__registrarse">Registrarse</button>
                </div>
            </div>

            <!--Formulario de Login y registro-->
            <div class="contenedor__login-register">
                <!--Login-->
                <form action="" method="post" class="formulario__login">
                    <h2>Iniciar Sesión</h2>
                    <input type="text" name="usuario" placeholder="Correo Electrónico" required />
                    <br />
                    <input type="password" name="contrasena" placeholder="Contraseña" required />
                    <br />
                    <button type="submit">Entrar</button>
                </form>

                <!--Registro enctype="multipart/form-data-->
                <form action="${pageContext.request.contextPath}/Registrar_Servlet" class="formulario__register">
                    <h2>Regístrate</h2>
                    <!-- Contenedor de alerta para mensajes de registro -->
                    <div id="registro_alerta" style="display: none; text-align: center; font-weight: bold; margin-bottom: 20px;"></div>

                    <input type="text" name="nombre" placeholder="Nombre" required /><br />
                    <input type="text" name="apellidoPaterno" placeholder="Apellido Paterno" required /><br />
                    <input type="text" name="apellidoMaterno" placeholder="Apellido Materno" required /><br />
                    <input type="email" name="correo" placeholder="Correo Electrónico" required /><br />
                    <input type="password" name="contrasena" placeholder="Contraseña" required /><br />
                    <input type="tel" name="telefono" placeholder="Teléfono" /><br />
                    <label for="avatar">Avatar:</label>
                    <input type="file" name="avatar" id="avatar" /><br />
                    <input type="text" name="municipio" placeholder="Municipio" /><br />
                    <input type="text" name="estado" placeholder="Estado" /><br />
                    <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                    <input type="date" name="fechaNacimiento" id="fechaNacimiento" /><br />
                    <label for="genero">Género:</label>
                    <select name="genero" id="genero">
                        <option value="masculino">Masculino</option>
                        <option value="femenino">Femenino</option>
                        <option value="otro">No especificado</option>
                    </select><br />
                    <button type="submit">Registrarse</button>
                </form>
            </div>
        </div>
    </main>

    <script src="JS/LogIn.js"></script>
    
</body>
</html>
