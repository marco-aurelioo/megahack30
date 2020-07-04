FROM adoptopenjdk/openjdk11:s390x-ubuntu-jre11u-nightly

COPY target/api-ambcard.jar /opt/app
EXPOSE 8083
CMD ["java", "-jar", "/opt/app/api-ambcard.jar"]