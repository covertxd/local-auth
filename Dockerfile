FROM openjdk:8u171-jdk-alpine AS build

COPY . /

RUN set -ex; \
    chmod +x ./gradlew ; \
    ./gradlew -q build ; \
    mv build/libs/LocalAuth.jar / ;

FROM node:13-alpine AS client

COPY src/main/resources/ui .

RUN set -ex; \
    npm install ; \
    npm run build ; \
    mv build/ /client

FROM openjdk:8u171-jre-alpine

COPY --from=build LocalAuth.jar /opt/localauth/
COPY --from=client /client /opt/localauth/public

WORKDIR /opt/localauth

ENTRYPOINT ["java", "-jar", "/opt/localauth/LocalAuth.jar"]
