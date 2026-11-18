-- =============================================================
--  Base de datos NAVES · Acceso a Datos (2º DAM)
--  Script de creación de la estructura
--  Convención: palabras reservadas en MAYÚSCULAS;
--              tablas y columnas en minúsculas (snake_case)
-- =============================================================

-- Indica al servidor que este script está escrito en UTF-8 (tildes, eñes...).
-- Aconsejable, pero no obligatorio: MySQL Workbench y el cliente mysql 8+
-- ya usan UTF-8 por defecto. Evita errores como «HalcÃ³n» si el programa
-- que ejecuta el script estuviera configurado con otro juego de caracteres.
-- Conclusión --> indica que, en esta conexión, el programa y el servidor MySQL
-- se comunican en UTF-8.
SET NAMES utf8mb4;

-- CHARACTER SET utf8mb4: la base de datos guardará los textos en UTF-8 completo.
-- Aconsejable, pero no obligatorio: desde MySQL 8.0 es el valor por defecto.
-- Se indica para que el script funcione igual en cualquier servidor.
-- Conclusión --> controla cómo se guardan los textos dentro de la base de datos
CREATE DATABASE IF NOT EXISTS naves CHARACTER SET utf8mb4;
USE naves;

DROP TABLE IF EXISTS mision;
DROP TABLE IF EXISTS pilota;
DROP TABLE IF EXISTS nave;
DROP TABLE IF EXISTS personaje;

CREATE TABLE personaje (
  id_personaje  INT PRIMARY KEY,
  nombre        VARCHAR(30) NOT NULL,
  descripcion   VARCHAR(45) NOT NULL,
  tipo          VARCHAR(10)
);

CREATE TABLE nave (
  id_nave      INT PRIMARY KEY,
  descripcion  VARCHAR(20) NOT NULL,
  motores      INT NOT NULL
);

CREATE TABLE pilota (
  id_personaje    INT NOT NULL,
  id_nave         INT NOT NULL,
  fecha           DATETIME NOT NULL,
  naves_abatidas  INT NOT NULL DEFAULT 0,
  CONSTRAINT pk_pilota PRIMARY KEY (id_personaje, id_nave, fecha),
  -- No se puede borrar un personaje que tenga pilotajes registrados
  CONSTRAINT fk_pilota_personaje FOREIGN KEY (id_personaje)
    REFERENCES personaje (id_personaje)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  CONSTRAINT fk_pilota_nave FOREIGN KEY (id_nave)
    REFERENCES nave (id_nave)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE mision (
  id_mision     INT AUTO_INCREMENT PRIMARY KEY,
  id_personaje  INT NOT NULL,
  id_nave       INT NOT NULL,
  fecha_inicio  DATETIME NOT NULL,
  fecha_fin     DATETIME,
  objetivo      VARCHAR(100) NOT NULL,
  exito         BOOLEAN NOT NULL,
  -- No se puede borrar un personaje que tenga misiones registradas
  CONSTRAINT fk_mision_personaje FOREIGN KEY (id_personaje)
    REFERENCES personaje (id_personaje)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  CONSTRAINT fk_mision_nave FOREIGN KEY (id_nave)
    REFERENCES nave (id_nave)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
