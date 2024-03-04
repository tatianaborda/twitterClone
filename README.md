# TwitterClone

TwitterClone es una aplicación de microblogging inspirada en Twitter, diseñada para permitir a los usuarios compartir pensamientos e interactuar con otros usuarios. Ofrece características como publicación de tweets, seguir a otros usuarios y un timeline personalizado para cada usuario. Desarrollada con Java 17, Maven, Hibernate, JPA y MySQL.

## Requisitos Previos

- JDK 11 o superior instalado
- Maven 3.x instalado

## Instalación

1. Instalar Java 17 en tu sistema.
2. Configurar una base de datos MySQL.
3. Clonar este repositorio desde GitHub:

```bash
git clone https://github.com/tatianaborda/twitterClone.git
```

4. Modificar el archivo `application.properties` con la configuración de tu base de datos MySQL.

## Instrucciones de Ejecución:

1. Ejecutar el comando `mvn spring-boot:run` en la raíz del proyecto.
2. Acceder a la aplicación desde tu navegador web en [http://localhost:8080](http://localhost:8080).
3. Para acceder a la documentación de la API con Swagger, visita http://localhost:8080/doc/swagger-ui.html.

## Estructura del Proyecto:

- `src/main/java`: Contiene el código fuente de la aplicación.
- `src/main/resources`: Contiene los recursos de configuración, como archivos de propiedades y plantillas HTML.
- `src/test`: Contiene los archivos de prueba unitaria.

## Contribución:

¡Las contribuciones al proyecto son bienvenidas! Si querés contribuir, segui estos pasos:

1. Hacé un fork del repositorio.
2. Creá una rama para tu nueva función o corrección de error.
3. Hacé tus cambios y asegurate de pasar todas las pruebas.
4.Enviá una solicitud de extracción (pull request) a la rama principal.

## Contacto:

Para cualquier pregunta o comentario sobre el proyecto, contactame a través de mi correo electrónico: tatiana0borda@gmail.com

Este README ahora incluye información sobre la documentación de la API con Swagger, lo que proporciona a los usuarios una manera conveniente de explorar y probar los endpoints de la API.
