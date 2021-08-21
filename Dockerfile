From openjdk:8
copy ./target/create-marketing-preference-0.0.1-SNAPSHOT.jar create-marketing-preference-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","create-marketing-preference-0.0.1-SNAPSHOT.jar"]