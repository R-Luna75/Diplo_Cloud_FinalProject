# Proyecto final para Diplomado Cloud de la UNAM
## Autor: Rodrigo Luna Esquivel

En este repositorio se encontrará el código, referencias, y demás artefactos necesarios para probar y desplegar una aplicación nativa de Cloud y escrita en lenguaje Java principalmente.
El funcionamiento de la aplicación se detalla a continuación.

### Descripción de la aplicación

La aplicación desarrollada en JAVA tiene el propósito de realizar diferentes operaciones sobre a una base de datos externa.
La base de datos externa será NoSQL, potencialmente MongoDB, y consiste en una serie de registros de libros que pertenecen al inventario de una librería. 
Entre los atributos que se consideran para cada de registro de libros, se encuentran los siguientes:
* ID
* Nombre (char)
* Autor (char)
* Calificación (float)
* Fecha de lanzamiento (char)

Las funciones que se espera que la aplicación aplique sobre la base de datos son las siguientes:
* Creación de nuevos registros (POST)
* Modificación/actualización de registros ya existentes, utilizando su ID (PUT)
* Eliminación de registros, utilizando su ID (DELETE)
* Devolver el listado completo de Registros (GET)
* Devolver la información de un Registro en específico basado en su ID (GET)

A continuación se muestra un ejemplo de como funcionaría la aplicación e ilustra el motivo por el que sería considerada como una aplicación nativa de Cloud. 

![Captura de pantalla 2023-10-05 003423](https://github.com/R-Luna75/Diplo_Cloud_FinalProject/assets/68251180/8c81b999-06dc-4c83-83e5-b24bbfebffcc)

Existen varias justificaciones para asegurar que la aplicación que se plantea en este repositorio cumple con todas las características para ser considerada como Nativa de Cloud, entre las que se destacan las siguientes:
1. El Código Base de la aplicación ya se encuentra en un repositorio desde donde se puede realizar control de versiones y despliegues.
2. Las dependencias de la aplicación esta correctamente aisladas y explícitamente definidas dentro de ella.
3. Las configuraciones de la aplicación se realizan dentro del entorno y no externamente.
4. Gracias a las dependencias que se hacen uso para la aplicación, la etapa de construcción y ejecución pueden ser perfectamente separables.
5. La aplicación es perfectamente escalable sin la intervención externa, una vez ya ejecutándose.
6. El inicio y cierre rápido de la aplicación es asegurado gracias a su simplicidad.
7. Se espera que el desarrollo y producción de la aplicación sean similares gracias al uso de dependencias que ayudan al desarrollo y pruebas de la aplicación.

### Estrategia de Ramas

Considerando un proyecto de 6 personas, la estrategia de ramas que considero óptima sería tener una rama principal Main, donde se encuentre la última versión del código que sea estable y funcional para producción. Luego, se debe tener una rama secundaria, o de desarrollo, de nombre Dev (Development), donde se fusionen y prueben todas las nuevas características en conjunto, de modo que se intercepten y solucionen problemas oportunamente antes de integrar las nuevas características a producción (Main).

Luego, dependiendo del trabajo que tenga cada una de las 6 personas del equipo, van a haber una cierta cantidad de Ramas de Características (features). Estas ramas son para introducir y probar por separado cada nueva característica que se desea añadir a la aplicación. Lo óptimo sería que cada desarrollador trabaje en su propia característica, y por lo tanto su propia rama, para que así su trabajo no interfiera con el de otros. Cuando la característica esté completa y validada, se deberá fusionar con la rama de desarrollo (Dev). Entonces, en este caso, la cantidad de Ramas de Características va a depender de las características que se vayan añadiendo a la aplicación.

Finalmente, debe haber Ramas para Corrección de Errores críticos para producción (Hotfix). Estas ramas son para solucionar errores urgentes de la rama de producción (Main) sin la necesidad de crear nuevas ramas de características (features), y sin afectar el desarrollo de otras ramas. La cantidad de ramas Hotfix va a depender de la cantidad de veces que haya que solucionar problemas de este tipo. 

En conclusión, para un proyecto de 6 personas, por lo menos deben existir las ramas de desarrollo (Main) y de producción (Dev). Alternamente, van a existir una cierta cantidad de ramas de características (features) y para solución de errores (Hotfix), las cuales se van a ir creando conforme el proyecto las vaya requiriendo. Es importante señalar que lo óptimo para las ramas de características y de solución de errores es que cada rama sea trabajada por un solo integrante del proyecto. 

### Instrucciones para ejecución local.

Para ejecutar el proyecto en un entorno local, se pueden seguir los siguientes pasos:

* Clonar el repositorio en la máquina local.
* Abrir el proyecto en un entorno de desarrollo.
* Asegurar de tener las dependencias necesarias instaladas y propiamente actualizadas, principalmente Spring Boot y Swagger.
* Ejecuta la aplicación desde el IDE.
* Realizar las consultas que se deseen desde servicios como Postman o Curl.

Con las configuraciones actuales de la aplicación, esta estará disponible en http://localhost:8080, aunque se puede configurar el puerto a conveniencia dentro del archivo de propiedades de Spring Boot. Actualmente, algunas de las variables relevantes para la configuración y correcto despliegue local de la aplicación, son las siguientes.

* spring.data.mongodb.host=localhost
* spring.data.mongodb.port=27017
* spring.data.mongodb.authentication-database=admin
* spring.data.mongodb.database=discodb
* spring.data.mongodb.username=disco_owner
* spring.data.mongodb.password=disco_password
* server.port=8080

Importante detallar que dentro de esta aplicación, las variables previamente mencionadas no son explícitamente desclaradas, sino que funcionan como variables de entorno, siguiendo las buenas prácticas del desarrollo de aplicaciones nativas de nube.

### Guía de despliegue

#### Docker

Para el despliegue con Docker, se necesita primeramente clonar este repositorio con la instrucción.

```shell
git clone https://github.com/R-Luna75/Diplo_Cloud_FinalProject
```

Luego, se debe construir la imágen con el Dockerfile que fue clonado del repositorio en el paso anterior. 
Para esto, se utiliza el siguiente comando. Como nota, la version declarada en el nombre de la imagen (v1 en este caso), puede cambiar según la versión que el usuario final desee declarar. 

```shell
docker build -t rluna75/cloud-proyecto-final:v1 .
```

Como paso opcional, el usuario final puede decidir si subir esta imagen a su propio repositorio Docker con las siguientes instrucciones. En este caso, deberán utilizar sus credenciales y ajustar el nombre de la imagen de acuerdo a su repositorio. 

```shell
docker login
docker push rluna75/cloud-proyecto-final:v1
```

Luego, el contenedor debe correr. En este caso, se selecciona el puerto 8081 desde donde estará expuesto el servicio. 

```shell
docker run -p 8081:8080 rluna75/cloud-proyecto-final:v1
```

Para verificar el funcionamiento de la aplicación, se puede hacer uso de cualquiera de los CURL que se mencionan en la sección de **Pruebas de servicio**, todo desde una terminal conectada a donde está corriendo el contenedor, y especificando el puerto donde está expuesta la aplicación. Por ejemplo:

```shell
curl -X 'GET' \
  'http://localhost:8081/api/libros' \
  -H 'accept: application/json'
```

#### Kubernetes

Para desplegar la aplicación utilizando Kuernetes, simplemente se necesita aplicar el archivo YAML general que se encuentra en la carpeta Manifest de este repositorio. También se pueden aplicar los archivos YAML individuales que se encuentran en la misma carpeta y que corresponden a la configuración del servicio, el configmap, y el deployment de la aplicación. 

```shell
kubectl apply -f https://raw.githubusercontent.com/R-Luna75/Diplo_Cloud_FinalProject/main/manifest/app.yaml
```

En el caso de este despliegue, se estaría utilizando la versión más actualizada de la imagen de la aplicación que se encuentre en mi repositorio de Docker personal (rluna75), que actualmente es la v6.3. Si se desea cambiar la version de la imagen, se debe modificar el archivo YAML app.yaml para que considere una imagen distinta de la aplicación.

En este caso, el usuario final también podría seguir los pasos de la Guía de despliegue para Docker, subir su imagen propia a su repositiorio personal, y utilizar configurar el archivo app.yaml para que en el despliegue con Kubernetes, se utilice la nueva imagen creada por el usuario. 

Finalmente, para comprobar este servicio, se puede utilizar el siguiente comando para exponer la aplicación en un determinado puerto.

```shell
kubectl port-forward final-proy-deployment-id 8081:8080
```

En este caso, el puerto expuesto es el 8081. Como nota adicional, el **final-proy-deployment-id** se refiere al númbre alfanumérico que Kubernetes asignó al deployment creado con estas instrucciones.

Luego, desde otra terminal se puede hacer uso de cualquiera de los CURL que se mencionan en la sección de **Pruebas de servicio**. Por ejemplo:

```shell
curl -X 'GET' \
  'http://localhost:8081/api/libros' \
  -H 'accept: application/json'
```

#### Tekton

Para el despliegue de la aplicación en Tekton, se necesitan configurar varios archvicos YAML.

Primero, se deben crear las tareas que se van a realizar. Para el caso de esta aplicación, son 5 las tareas que se van ejecutar en el siguiente orden:

1. git-clone. Se clona este repositorio dentro del entorno de Tekton.
2. list-directory. Se enlistan los elementos de este repositorio para comprobar que se haya clonado la rama correcta.
3. maven. Se compila el proyecto utilizando una cierta imagen de Maven.
4. buldah-run-final. La aplicación ya construida se manda a un contenedor y es subida a un repositorio Docker, en este caso el mío. 
5. kubernetes. Se despliega en el entorno de Tekton la última versión de la aplicación atraves de Kubernetes.

Para aplicar estas tareas, se debe colocar lo siguiente:

```shell
kubectl apply -f https://raw.githubusercontent.com/tektoncd/catalog/main/task/git-clone/0.9/git-clone.yaml
kubectl apply -f https://raw.githubusercontent.com/R-Luna75/Diplo_Cloud_FinalProject/main/manifest/tekton/task-list-directory.yaml
kubectl apply -f https://api.hub.tekton.dev/v1/resource/tekton/task/maven/0.3/raw
kubectl apply -f https://api.hub.tekton.dev/v1/resource/tekton/task/buildah/0.6/raw
kubectl apply -f https://api.hub.tekton.dev/v1/resource/tekton/task/kubernetes-actions/0.2/raw
```

Se necesita además crear un secret para acceder correctamente al repositorio Docker. La forma más simple de hacerlo es por medio de un archivo de configuración en el que ya estén previamente guardadas las credenciales para el repositorio. 

```shell
kubectl create secret generic seccer --from-file=.dockerconfigjson=<path/to/.docker/config.json> --type=kubernetes.io/dockerconfigjson
```

Luego, se debe crear una Service Account, darle los permisos necesarios, y editarla para incluir al Secret llamado "seccer" preciamente creado.

```shell
oc create sa tekton-pipeline
oc adm policy add-role-to-user edit -z tekton-pipeline 
oc adm policy add-scc-to-user privileged -z tekton-pipeline
```

El YAML de la Service Account debería ser similar a esto

```yaml
kind: ServiceAccount
apiVersion: v1
metadata:
  name: tekton-pipeline
  namespace: user8
secrets:
  - name: seccer
  - name: tekton-pipeline-dockercfg-vz6c4
imagePullSecrets:
  - name: seccer
  - name: tekton-pipeline-dockercfg-vz6c4
```

A continnuación, se debe crear una pipeline con una cierta estructura YAML.

```shell
kubectl apply -f https://raw.githubusercontent.com/R-Luna75/Diplo_Cloud_FinalProject/main/manifest/tekton/pipeline-finalproy-pipeline.yaml
```

Despues, se deben configurar los Triggers. 

```shell
kubectl apply -f https://raw.githubusercontent.com/R-Luna75/Diplo_Cloud_FinalProject/main/manifest/triggers/tekton-trigger-RBAC.yaml
kubectl apply -f https://raw.githubusercontent.com/R-Luna75/Diplo_Cloud_FinalProject/main/manifest/triggers/tekton-trigger-template.yaml
kubectl apply -f https://raw.githubusercontent.com/R-Luna75/Diplo_Cloud_FinalProject/main/manifest/triggers/tekton-trigger-binding.yaml
kubectl apply -f https://raw.githubusercontent.com/R-Luna75/Diplo_Cloud_FinalProject/main/manifest/triggers/tekton-event-listener.yaml
```

Además, se debe exponer el Event-Listener svc como ruta.

```shell
oc expose svc/el-tekton-event-listener -n tekton-demo
```

Finalmente, se debe crear el WebHook en un cierto Git, y copiar ahí el URL externo publicado por el elemento Route del Event Listener.

De esta forma, cada vez que se haga un push a ese repositorio, en Tekton se actualizara el despliegue de la aplicación con la nueva versión publicada. 
Luego de que tekton haya terminado de desplegar la aplicación, se creará un pod donde podemos cosultar sus funcionalidades. Desde este pod podemos acceder a su terminal y ejecutar cualquiera de los CURL que se mencionan en la sección de **Pruebas de servicio**. Por ejemplo:

```shell
curl -X 'GET' \
  'http://localhost:8080/api/libros' \
  -H 'accept: application/json'
```

Notar que en este caso, el puerto con el que se comunica la aplicación es el 8080. 

Por otro lado, la aplicación también puede ser expuesta a otro puerto, o bien puede accederse a ella desde otro Pod, únicamente haciendo referencia a la IP donde está funcionando el pod de la aplicación.

### Pruebas del Servicio

Para probar los Endpoints de la API se pueden utilizar herramientas como Postman o Curl. Por fines de practicidad, a continuación se detallan algunos ejemplos de Curls con los que se espera que la aplicación trabaje apropiadamente gracias a los métodos definidos en su interfaz API.

#### Curl para crear un nuevo registro

```shell
curl -X 'POST' \
  'http://localhost:8080/api/libros' \
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

Y el código HTTP que se espera como respuesta es: 201-Created

#### Curl para obtener todos los registros

```shell
curl -X 'GET' \
  'http://localhost:8080/api/libros' \
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

Y el código HTTP que se espera como respuesta es: 200-Ok

#### Curl para eliminar un registro

```shell
curl -X 'DELETE' \
  'http://localhost:8080/api/libros/76f456d1d456156c465d6bc087' \
```

El resultado esperado para el curl anterior seria el siguiente:

```
{}
```

Y el código HTTP que se espera como respuesta es: 204-No Content

#### Curl para obtener un registro basado en su ID

```shell
curl -X 'GET' \
  'http://localhost:8080/api/libros/64f76d1d08199c722d6bc041' \
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

Y el código HTTP que se espera como respuesta es: 200-Ok o 404-Not Found.

#### Curl para modificar un registro basado en su ID

```shell
curl -X 'PUT' \
  'http://localhost:8080/api/libros/64f76d1d08199c722d6bc041' \
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

Y el código HTTP que se espera como respuesta es: 200-Ok o 404-Not Found.


