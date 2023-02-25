# empresa XYZ_CH

# Revisar CreateUser.docx se encuentra con imágenes.


En esta primera versión se tiene la creación de un usuario. Consta de 2 parte Back-end (microservices_XYZ_CH) y Front-end (client_XYZ_CH)

Nota: en la carpeta target del proyecto (microservices_XYZ_CH) se encuentra generado el jar, con esto podemos avanzar al paso 5 de este tutorial.

1. micoroservices_XYZ_CH= es la parte back end desarrollado con Java 8, IDE Eclipse, jpa, base de datos en memoria hdbsql, Spring Boot, Servidor tomcat.

Para ejecutar bajar el proyecto y tener libre el puerto 9000. 

Empaquetado y ejecución del microservicio;

 1. Bajamos el proyecto "micoroservices_XYZ_CH " en el IDE eclipse dar clic derecho sobre el proyecto, ir hacia “Run As”, escoger la 4 opción maven build.

 

2. En la opción Goal poner deploy y dar clic en Run

 

3. Se ejecutará y construirá  el jar.

4. En la carpeta target se creará el jar  micoroservices_XYZ_CH.jar.
 


5. Este jar lo podemos ubicar en cualquier carpeta y con una terminal de comando ejecutamos 
java -jar microservices_XYZ_CH-0.0.1-SNAPSHOT.jar

 

6. Una vez que se encuentre arriba el microservicio nos vamos al proyecto client_XYZ_CH
 

7. En la carpeta “client_XYZ_CH\WebContent”, abrimos el archivo index.html

 

8. Una vez que estemos aquí, podemos ingresar con cualquier usuario sólo se implementó la seguridad con cualquier usuario.
 

9. Una vez ahí podemos ingresar clientes.

 
 

10. Si se quiere  listar damos clic en “Listar Clientes”

 
11. Una vez que se llene de los beneficiaros dependiendo del listado xml o json nos dará un mensaje de error.

 

12. Una vez lleno se puede eliminar un registro y con esto se puede ingresar nuevamente un usuario para ese grupo. Los beneficios se escogen aleatoriamente.

 
