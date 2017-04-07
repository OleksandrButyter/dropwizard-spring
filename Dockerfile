FROM java:8-jre-alpine
COPY target/dwbook-phonebook-1.0-SNAPSHOT.jar /home
COPY config.yml /home
WORKDIR /home
CMD ["java","-jar","/home/dwbook-phonebook-1.0-SNAPSHOT.jar","server","config.yml"]
EXPOSE 9000-9001