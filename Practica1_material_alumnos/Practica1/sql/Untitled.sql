USE naves;

SELECT * FROM nave;
SELECT * FROM mision;
SELECT * FROM pilota;


SELECT nombre FROM personaje
WHERE id_personaje IN (SELECT id_personaje FROM pilota WHERE YEAR(fecha) < 2000);



SELECT id_personaje FROM pilota WHERE YEAR(fecha) < 2000;