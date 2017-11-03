#Aplicação desenvolvida utilizando:
-Java 8
-Maven
-SpringBoot
-JUnit

##Executar:
mvn clean install
cd core
mvn spring-boot:run

##Para testar a aplicação:
curl -s --request POST http://localhost:8080/rest/mars/MML
