-- =============================================================
--  Base de datos NAVES · Datos de prueba
--  Ejecutar después de creaBD.sql
-- =============================================================
-- Indica al servidor que este script está escrito en UTF-8 (tildes, eñes...).
-- Aconsejable, pero no obligatorio: MySQL Workbench y el cliente mysql 8+
-- ya usan UTF-8 por defecto. Evita errores como «HalcÃ³n» si el programa
-- que ejecuta el script estuviera configurado con otro juego de caracteres.
-- Conclusión --> indica que, en esta conexión, el programa y el servidor MySQL
-- se comunican en UTF-8.
SET NAMES utf8mb4;

USE naves;

INSERT INTO personaje (id_personaje, nombre, descripcion, tipo) VALUES
(1, 'Han Solo', 'Contrabandista', 'Humano'),
(2, 'Luke Skywalker', 'Jedi hijo de Anakin', 'Jedi'),
(3, 'Leia', 'Princesa hija de Anakin', 'Humano'),
(4, 'C3PO', 'Androide propiedad de Leia', 'Robot'),
(5, 'R2D2', 'Robot propiedad de Leia', 'Robot'),
(6, 'Chewbacca', 'Wookiee del planeta Valmori', 'Wookiee'),
(7, 'Anakin Skywalker', 'Alias Darth Vader', 'Jedi'),
(8, 'Obi-Wan Kenobi', 'Jedi maestro de Anakin', 'Jedi');

INSERT INTO nave (id_nave, descripcion, motores) VALUES
(1, 'Halcón Milenario', 3),
(2, 'Tie Fighter', 2),
(3, 'X Wing', 2),
(4, 'Y Wing', 4),
(5, 'Lanzadera GR', 8);

INSERT INTO pilota (id_personaje, id_nave, fecha, naves_abatidas) VALUES
(1, 1, '1995-01-29', 3),
(1, 1, '2011-02-12', 0),
(2, 3, '2010-11-07', 5),
(6, 1, '1999-06-05', 5),
(8, 5, '2008-12-12', 5),
(2, 4, '2009-02-12', 8);

INSERT INTO mision (id_personaje, id_nave, fecha_inicio, fecha_fin, objetivo, exito) VALUES
(1, 1, '1995-01-29 10:30:00', '1995-01-29 12:00:00', 'Escapar de Tatooine', TRUE),
(1, 3, '1995-01-29 10:30:00', '1995-01-29 12:00:00', 'Escapar de Tatooine', FALSE),
(2, 3, '2010-11-07 09:00:00', NULL, 'Patrulla en el sector Hoth', FALSE),
(6, 1, '1999-06-05 18:15:00', '1999-06-05 20:00:00', 'Ataque a destructor imperial', TRUE);
