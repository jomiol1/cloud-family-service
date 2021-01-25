# cloud-family-service

El proyecto esta basado en una arquitectura simple basada en microservicios, a continuacion se indica el despliegue de cada componente.

![](./componentes.png)

## Despliegue del ambiente de microservicios:

Para desplegar el ambiente de microservicios es necessario cada uno de los siguientes servicios:


##### - Servidor de configuraciones (cloud-configuration-service)

- **Proyecto**: cloud-configuration-service
- **Puerto**: 8081
- **Servidor GIT**: https://github.com/jomiol1/cloud-configuration-service.git

##### - Servidor de registro (cloud-discovery-service)

- **Proyecto**: cloud-discovery-service
- **Puerto**: 8082
- **Servidor GIT**: https://github.com/jomiol1/cloud-discovery-service.git


##### - Servidor proxy (cloud-proxy-service)

- **Proyecto**: cloud-proxy-service
- **Puerto**: 8080
- **Servidor GIT**: https://github.com/jomiol1/cloud-proxy-service.git

##### - Family Service(cloud-family-service)

- **Proyecto**: cloud-family-service
- **Puerto**: 8083
- **Servidor GIT**: https://github.com/jomiol1/cloud-family-service.git
- **Swagger**: http://localhost:8083/swagger-ui.html#/

#### - Nota: 
Los proyectos utilizan Gradle como herramienta de compilacion
