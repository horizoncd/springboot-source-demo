FROM maven:3.8.6-amazoncorretto-17 as builder

COPY . /builds

COPY ./settings.xml /usr/share/maven/conf/settings.xml

WORKDIR /builds

RUN mvn clean package -Dmaven.test.skip=true \
    && cp /builds/target/*.jar /lib/app.jar

ENV D_SERVER_PORT 8080

CMD exec java $JAVA_OPTS -jar /lib/app.jar -Dserver.port=${D_SERVER_PORT}