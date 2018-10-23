FROM maven:3.3.9-jdk-8
RUN mkdir /app
WORKDIR /app

#Copying sources
COPY pom.xml /app
COPY src /app/src
COPY web /app/web

#Packaging the app
RUN mvn install
RUN mvn package

FROM tomcat

#Getting the war from stage 0 and uploading to tomcat
COPY --from=0 /app/target/jersey-1.0.war webapps/jersey.war

#Authorizing access to manager app
COPY tomcat-users.xml conf
RUN mkdir -p conf/Catalina/localhost
COPY manager.xml conf/Catalina/localhost

#CMD ["./bin/catalina.sh","run"]

