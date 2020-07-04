FROM adoptopenjdk/openjdk11:s390x-ubuntu-jre11u-nightly


COPY target/customer.jar /opt/app
EXPOSE 8081
CMD ["java", "-jar", "/opt/app/customer.jar"]