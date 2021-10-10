-- Datos cines
INSERT INTO "PUBLIC"."CINE"("ID", "CODIGO_POSTAL", "NOMBRE", "POBLACION", "PRECIO_ENTRADA", "PROVINCIA")
VALUES (1, 49600, 'CINE ZAMORA', 'ZAMORA', 3.5, 'ZAMORA');

INSERT INTO "PUBLIC"."CINE"("ID", "CODIGO_POSTAL", "NOMBRE", "POBLACION", "PRECIO_ENTRADA", "PROVINCIA")
VALUES (2, 49600, 'MULTICINES BENAVENTE', 'BENAVENTE', 2, 'ZAMORA');

INSERT INTO "PUBLIC"."CINE"("ID", "CODIGO_POSTAL", "NOMBRE", "POBLACION", "PRECIO_ENTRADA", "PROVINCIA")
VALUES (3, 28013, 'CINES CALLAO', 'MADRID', 9.95, 'MADRID');

-- Datos peliculas
INSERT INTO "PUBLIC"."PELICULA"("ID", "DIRECTOR", "FECHA_ESTRENO", "PUNTUACION", "SINOPSIS", "TITULO")
VALUES (1, 'Justin Lin', '2021-06-18', 10, 'Dom Toretto (Vin Diesel) lleva una vida tranquila con Letty y su hijo, el pequeño Brian, pero saben que el peligro siempre acecha esa tranquilidad. ', 'Fast & Furious 9');

INSERT INTO "PUBLIC"."PELICULA"("ID", "DIRECTOR", "FECHA_ESTRENO", "PUNTUACION", "SINOPSIS", "TITULO")
VALUES (2, 'Santiago Segura', '2021-06-28', 7, 'Cuando Ricardo, padre responsable volcado en su hijo, decide llevarle a un campamento en Asturias en tren nocturno, algunos padres proponen que sea él quien lleve a varios de sus hijos Sin embargo, no cuentan que en el último minuto le acompañe Felipe, abuelo de dos de los niños, un tipo extravagante e irresponsable', ' ¡A todo tren! Destino Asturias');

INSERT INTO "PUBLIC"."PELICULA"("ID", "DIRECTOR", "FECHA_ESTRENO", "PUNTUACION", "SINOPSIS", "TITULO")
VALUES (3, 'Adam Wingard', '2021-02-28', 6, 'Las leyendas chocan en “Godzilla vs. Kong” cuando estos míticos adversarios se dan cita en un titánico combate para todas las edades, mientras el destino del mundo pende de un hilo.','Godzilla vs. Kong');

INSERT INTO "PUBLIC"."PELICULA"("ID", "DIRECTOR", "FECHA_ESTRENO", "PUNTUACION", "SINOPSIS", "TITULO")
VALUES (4, 'Michael Chaves', '2021-09-11', 9, 'Cuenta una escalofriante historia de terror, asesinatos y de un mal desconocido que conmocionó incluso a los experimentados investigadores paranormales Ed y Lorraine Warren en la vida real.','Expediente Warren: Obligado por el demonio');

-- REVIEWS
INSERT INTO "PUBLIC"."REVIEW"("ID","TITULO","PUNTUACION", "REVIEW_TEXT", "PELICULAS_ID")
VALUES(1,'UNA GRAN PELICULA',10, 'UNA GRAN PELICULA, SIN DUDA',1);
INSERT INTO "PUBLIC"."REVIEW"("ID","TITULO","PUNTUACION", "REVIEW_TEXT", "PELICULAS_ID")
VALUES(2,'NO ME GUSTO',2, 'UNA GRAN PELICULA, SIN DUDA',1);
INSERT INTO "PUBLIC"."REVIEW"("ID","TITULO","PUNTUACION", "REVIEW_TEXT", "PELICULAS_ID")
VALUES(3,'NORMALITA...',2, 'Estaba bien, pero el doblaje era malo',2);

--CINE 1: Peliculas 1,2,3
INSERT INTO "PUBLIC"."PELICULA_CINES"("CINES_ID", "PELICULAS_ID")
VALUES (1, 1);
INSERT INTO "PUBLIC"."PELICULA_CINES"("CINES_ID", "PELICULAS_ID")
VALUES (1, 2);
INSERT INTO "PUBLIC"."PELICULA_CINES"("CINES_ID", "PELICULAS_ID")
VALUES (1, 3);

-- CINE 2: Peliculas 2,3
INSERT INTO "PUBLIC"."PELICULA_CINES"("CINES_ID", "PELICULAS_ID")
VALUES (2, 2);
INSERT INTO "PUBLIC"."PELICULA_CINES"("CINES_ID", "PELICULAS_ID")
VALUES (2, 3);

-- CINE 3: Todas las peliculas
INSERT INTO "PUBLIC"."PELICULA_CINES"("CINES_ID", "PELICULAS_ID")
VALUES (3, 1);
INSERT INTO "PUBLIC"."PELICULA_CINES"("CINES_ID", "PELICULAS_ID")
VALUES (3, 2);
INSERT INTO "PUBLIC"."PELICULA_CINES"("CINES_ID", "PELICULAS_ID")
VALUES (3, 3);
INSERT INTO "PUBLIC"."PELICULA_CINES"("CINES_ID", "PELICULAS_ID")
VALUES (3, 4);
