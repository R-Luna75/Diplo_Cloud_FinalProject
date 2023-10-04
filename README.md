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

### Guia de despliegue



### Instrucciones para ejecución

Para la correcta ejecución de la aplicación, planteo que se utilicen los siguientes `curls` para validar el 
despliege del servicio.

### Pruebas del Servicio

Para probbar los Endpoints de la API se pueden utilizar herramientas como Postman o Curl. Por fines de practicidad, a continuación se detallan algunos ejemplos de Curls con los que se espera que la aplicación trabaje apropiadamente gracias a los métodos definidos en su interfaz API.
Como nota, el puerto que se plantea utilizar para la aplicación sería el 8083, aunque está sujeto a cambios y será actualizado en esta documentación.

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


