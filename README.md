# Proyecto final para Diplomado Cloud de la UNAM
## Autor: Rodrigo Luna Esquivel

En este repositorio se encontrará el código, referencias, y demás artefactos necesarios para probar y desplegar una aplicación en nativa de cloud escrita en lenguaje Java principalmente.
El funcionamiento de la aplicación se detalla a continuación.

### Descripción de la aplicación

La aplicación desarrollada en JAVA tiene el propósito de realizar diferentes operaciones sobre a una base de datos externa.
La base de datos externa será NoSQL, potencialmente MongoDB, y consiste en una serie de registros de libros que pertenecen al inventario de una librería. 
Entre los atributos que se consideran para cada de registro de libros, se encuentran los siguientes:
* ID
* Nombre (char)
* Autor (char)
* Nacionalidad (char)
* Género (char)
* Calificación (float)
* ¿Posee adaptación a película? (Bit)
* Fecha de lanzamiento (DateTime)
* Costo (int)

Las funciones que se espera que la aplicación relice sobre la base de datos son las siguientes:
* Creación de nuevos registros (POST)
* Modificación/actualización de registros ya existentes, utilizando su ID (PUT)
* Eliminación de registros, utilizando su ID (DELETE)
* Devolver el listado completo de Registros (GET)
* Devolver la información de un Registro en específico basado en su ID (GET)

A continuación se muestra un ejemplo de como funcionaría la aplicación e ilustra el motivo por el que sería considerado como una aplicación nativa de Cloud. La imagen fue hecha en conjunto por miembros del grupo de trabajo durante la sesión del diplomado del Sabado 30 de Septiembre.

![imagen 1](https://github.com/R-Luna75/Diplo_Cloud_FinalProject/assets/68251180/392ea187-a79f-47ff-8a7c-f327018a4297)


Existen varias justificaciones para asegurar que la aplicación que se plantea en este repositorio cumple con todas las características para ser considerada como Nativa de Cloud, entre las que se destacan las siguientes:
1. El Codigo Base de la aplicación ya se encuentra en un repositorio desde donde se puede realizar control de versiones y despliegues.
2. Las dependencias de la aplicación esta correctamente aisladas y explícitamente definidas dentro de ella.
3. Las configuraciones de la aplicación se realizan dentro del entorno y no externamente.
4. 
5. Gracias a las dependencias que se hacen uso para la aplicación, la etapa de construcción y ejecución pueden ser perfectamente separables.
6. y
7. y
8. 
9. La aplicación es perfectamente escalable sin la intervención externa, una vez ya ejecutándose.
10. El inicio y cierre rápido de la aplicación es asegurado gracias a su simplicidad.
11. Se espera que el desarrollo y producción de la aplicación sean similares gracias al uso de dependencias que ayudan al desarrollo y pruebas de la aplicación.
12. 

El resto de características necesarias para asegurar que la aplicación sea nativa de nube aun están por cumplirse con el resto del desarrollo del proyecto..

### Guia de despliegue


### Instrucciones para ejecución

Para ejecutar el proyecto en un entorno local, se puedne seguir los siguientes pasos:

* Clonar el repositorio en la máquina local.
* Abrire el proyecto en un entorno de desarrollo.
* Asegurar de tener las dependencias necesarias instaladas y propiamente actualizadas, principalmente Spring Boot y Swagger.
* Ejecuta la aplicación desde el IDE.

Con las configuraciones actuales de la aplicación, esta estará disponible en http://localhost:8083, aunque se puede configurar el puerto a conveniencia dentro del archivo de propiedades de Spring Boot. Actualmente, algunas de las variables relevantes para la configuración y correcto despliege local de la aplicación, son las siguientes.

* spring.data.mongodb.host=localhost
* spring.data.mongodb.port=27017
* spring.data.mongodb.authentication-database=admin
* spring.data.mongodb.database=discodb
* spring.data.mongodb.username=disco_owner
* spring.data.mongodb.password=disco_password
* server.port=8083

Para desplegar la aplicación en un ambiente de nube, aun se necesita profundizar sobre contenderos y docker. Esto será principalmente de ayuda para asegurar que la aplicación siempre tenga acceso a las versiones de dependencias necesarias para su correcto funcionamiento. 

### Pruebas del Servicio

Para probbar los Endpoints de la API se pueden utilizar herramientas como Postman o Curl. Por fines de practicidad, a continuación se detallan algunos ejemplos de Curls con los que se espera que la aplicación trabaje apropiadamente gracias a los métodos definidos en su interfaz API.

Curl para crear un nuevo registro

```shell
curl -X 'POST' \
  'http://localhost:8083/api/libros' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "64f76d1d08199c722d6bc041",
    "Nombre": "Libro 1"
    ...
    ...
    ...
    }' 
```

El resultado esperado para el curl anterior seria el siguiente:

```
{
    "id": "64f76d1d08199c722d6bc041",
    "Nombre": "Libro 1"
    ...
    ...
    ...
}
```

Curl para obtener todos los registros

```shell
curl -X 'GET' \
  'http://localhost:8083/api/libros' \
  -H 'accept: application/json'
```

El resultado esperado para el curl anterior seria el siguiente:

```
[
  {
      "id": "64f76d1d08199c722d6bc041",
      "Nombre": "Libro 2"
      ...
      ...
      ...
  }

  {
        "id": "76f456d1d456156c465d6bc087",
        "Nombre": "Libro 2"
        ...
        ...
        ...
    }
]
```

Curl para eliminar un registro

```shell
curl -X 'DELETE' \
  'http://localhost:8083/api/libros/76f456d1d456156c465d6bc087' \
```

El resultado esperado para el curl anterior seria el siguiente:

```
{}
```

Curl para obtener un registro basado en su ID

```shell
curl -X 'GET' \
  'http://localhost:8083/api/libros/64f76d1d08199c722d6bc041' \
  -H 'accept: application/json' \
```

El resultado esperado para el curl anterior seria el siguiente:

```
{
    "id": "64f76d1d08199c722d6bc041",
    "Nombre": "Libro 1"
    ...
    ...
    ...
}
```

Curl para modificar un registro basado en su ID

```shell
curl -X 'PUT' \
  'http://localhost:8083/api/libros/64f76d1d08199c722d6bc041' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "64f76d1d08199c722d6bc041",
    "Nombre": "Libro 3"
    ...
    ...
    ...
    }' 
```

El resultado esperado para el curl anterior seria el siguiente:

```
{
    "id": "64f76d1d08199c722d6bc041",
    "Nombre": "Libro 3"
    ...
    ...
    ...
}
```

Como nota, el puerto que se plantea utilizar para la aplicación sería el 8083, aunque está sujeto a cambios y será actualizado en esta documentación.
Por otro lado, en el archivo API_Documentation_Example.yaml se muestran las especificaciones de una API que corresponden a una aplicación con funcionalidades muy similares a las que se plantean en este repositorio. Se recomienda revisar este archivo para darse una idea sobre las especificaciones que tendrá la API de esta aplicación una vez que haya terminado su desarrollo. Cuando las especificaciones finales esten listas, se añadirá en este repositorio un archivo YAML similar al del ejemplo, pero con las características reales de la aplicación.


