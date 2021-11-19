FROM openjdk:11
RUN mkdir -p /usr/src/UsuarioPY
COPY /target/UsuarioPY-1.0.0.jar /usr/src/UsuarioPY
WORKDIR /usr/src/UsuarioPY
EXPOSE 8090
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Duser.timezone=EC", "-jar", "UsuarioPY-1.0.0.jar"]
