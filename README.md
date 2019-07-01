# MySQL
Connection Prarctice between Java &amp; MySQL

CREATE DATABASE sistema

CREATE TABLE `sistema`.`persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  PRIMARY KEY (`idPersona`));

CREATE TABLE sistema.usuario (
  idUsuario INT NOT NULL AUTO_INCREMENT,
  usuario VARCHAR(45) NOT NULL,
  contraseña VARCHAR(45) NOT NULL,
  idPersona int(6) NOT NULL,
  PRIMARY KEY (idUsuario),
  UNIQUE INDEX usuario_UNIQUE (usuario ASC) VISIBLE,
  FOREIGN KEY (idPersona) REFERENCES sistema.persona(idPersona)
  );


Consultas
SELECT * FROM sistema.usuarios


SELECT * FROM sistema.usuario
INNER JOIN sistema.persona 
WHERE sistema.usuario.idPersona = sistema.persona.idPersona
