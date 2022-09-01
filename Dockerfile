FROM azul/zulu-openjdk:18
RUN set -x \
    mkdir -p /app
COPY ./build/libs/micronautguide-0.1-all.jar /app/
EXPOSE 8080
WORKDIR /app
CMD ["java", "-jar", "micronautguide-0.1-all.jar"]