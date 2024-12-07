/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Wilber
 * Created: 7 dic 2024
 */

-- Verificar e insertar el estado "Admin" si no existe
INSERT INTO Estado (idEstado, nombre)
SELECT 1, 'Admin'
WHERE NOT EXISTS (SELECT 1 FROM Estado WHERE nombre = 'Admin');

-- Verificar e insertar el municipio "Admin" si no existe
INSERT INTO Municipio (idMunicipio, nombre, idEstado)
SELECT 1, 'Admin', 1
WHERE NOT EXISTS (SELECT 1 FROM Municipio WHERE nombre = 'Admin');

-- Verificar e insertar el usuario administrador si no existe
INSERT INTO Usuario (idUsuario, nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, fechaNacimiento, genero, rol, idMunicipio)
SELECT 1, 'admin', 'admin', 'admin', 'admin@gmail.com', 'admin', '12345', '2024-10-02', 'MASCULINO', 'ADMINISTRADOR', 1
WHERE NOT EXISTS (SELECT 1 FROM Usuario WHERE correo = 'admin@gmail.com');

