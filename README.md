# SPRING BOOT II

Segundo ejercicio de Acceso a Datos, Spring Boot, JPA.

## Enunciado

_Tomando como partida el código de la aplicación subido por el profesor, queremos hacer lo siguiente_

## Útiles

* Acceso a la base de datos: [Pinchar con aplicación arrancada](http://localhost:8080/h2-console/) y click en _connect_

## Parte 1

Queremos guardar los cines en los que se va a proyectar cada película (no es necesario almacenar la sala ni el horario,
simplemente el cine)

Crear la estructura necesaria en la aplicación para almacenar los cines con la siguiente información:

* Nombre del cine
* Población
* Código postal
* Provincia
* Precio de la entrada

Para ello tendremos que implementar los métodos: GET, POST, PUT y DELETE

## Parte 2

Teniendo una película determinada, (por ejemplo Django Desencadenado) queremos obtener la siguiente información:

Cines en los que se proyecta ordenados por precio, de más barato a más caro. Cines en los que se proyecta con un
determinado código postal. Reviews ordenados de mayor puntuación a menor Tendréis que crear una petición independiente,
en el controlador que creáis adecuado, para cada una de estas consultas. No es necesario que incluyáis toda la lógica de
la búsqueda en el GET de la entidad, aunque esto sea lo adecuado atendiendo la arquitectura REST.

## Parte 3

Queremos crear un usuario especial que sea el encargado de modificar la información de los cines y las películas
relacionadas. Dicho usuario debe ser capaz de dar de alta cines, y vincular películas a los mismos, pero no podrá
modificar películas. El usuario Admin debe poder realizar todas las acciones que puede realizar este usuario.
