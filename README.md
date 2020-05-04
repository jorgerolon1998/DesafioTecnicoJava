# DesafioTecnicoJava
Desafio Tecnico JAVA: El proyecto cuenta con el desarrollo del challenge.

El desarrollo cuenta con una autentucación por medio de JSON WEB TOKEN, consultado el servicio http://localhost:8080/user  ,
que es un post con dos llaves (usser,password), en la que el valor puede ser el que desee, el mismo devuelve un token para consultar el resto de los servicios.


1 - Servicio de búsqueda de candidatos con paginado http://localhost:8080/api/candidatosP   (get)

2 - Servicio de búsqueda de candidato en específico http://localhost:8080/api/getCandidato/{id}  (get con id numerico del candidato)

3 - Servicio de alta de candidato http://localhost:8080/api/candidatos/add  (post con formato del objeto Candidato)

4 - Servicio de modificacion de candidato http://localhost:8080/api/candidatos/update (put con formato del objeto Candidato a modificar)

5 - Servicio de baja de candidato  http://localhost:8080/api/candidatos/delete/{id} (delete con id numero del candidato a eliminar)
