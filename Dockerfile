FROM maven:latest

WORKDIR /var/data/maven

COPY erp-backend-demo /var/data/maven

RUN maven package -Dmaven.test.skip=true

FROM java:latest

WORKDIR /usr/local/web/

COPY --from=0 /tmp/erp-backend-demo/target/erp-backend-demo-0.0.1-SNAPSHOT.jar .

CMD [ "java" "-jar" "erp-backend-demo-0.0.1-SNAPSHOT.jar"]

