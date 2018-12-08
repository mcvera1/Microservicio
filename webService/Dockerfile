FROM java
VOLUME /tmp
ADD webservice-1.0.0.jar webservice-1.0.0.jar
RUN bash -c 'touch /webservice-1.0.0.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/webservice-1.0.0.jar"]