FROM ubuntu:22.04

RUN apt update -q && \
    apt install -y -q openjdk-17-jre openjdk-17-jdk-headless && \
    apt install -y -q fontconfig fonts-dejavu

RUN apt update && \
    apt install maven -y

ADD src/ /webapp/src
ADD pom.xml /webapp
ADD employee.xsd /webapp

WORKDIR /webapp/
RUN mvn clean package


EXPOSE 8090
CMD ["mvn", "spring-boot:run"]
