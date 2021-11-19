# ExerciseGizlo
Prueba técnica Desarrollo


## PASOS PARA EJECUTAR LOS MICROSERVICIOS

1. Compilar ServiceComponent
    - en el directorio ./ServiceComponent ejecute:
    > mvn clean install

1. Compilar UsuarioMS
    - en el directorio ./UsuarioMS ejecute:
    > mvn clean install

1. Compilar UsuarioPY
    - en el directorio ./UsuarioPY ejecute:
    > mvn clean install

1. Ejecutar el siguiente comando de docker compose desde la raiz del reposiorio *./* 
    > docker-compose up -d