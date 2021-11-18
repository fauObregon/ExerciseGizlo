FROM openjdk:11
RUN mkdir -p /usr/src/UsuarioMS
COPY /target/UsuarioMS-1.0.0.jar /usr/src/UsuarioMS
WORKDIR /usr/src/UsuarioMS
EXPOSE 8080
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Duser.timezone=EC", "-jar", "UsuarioMS-1.0.0.jar"]
