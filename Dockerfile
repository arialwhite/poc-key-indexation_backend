FROM openjdk:8

ENV DEBUG_PORT=89321

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . /usr/src/app

RUN apt-get -qq update && \
    apt-get install -y maven && \
    mvn install -Dmaven.test.skip=true

VOLUME /tmp

EXPOSE 9333
CMD sleep 10 && mvn -Dmaven.repo.local=/root/.m2/repository spring-boot:run  -Dmaven.test.skip=true
