### UDEMY eğitimine paralel geliştirmelerim.

- Paket yönetimi ve katmanların parçalanması 
- Spring Boot ile rest service kullanımları
- Actuator
- Mapstruct kullanımı
- Swagger2
- Hibernate
- JPA 

### HOW TO RUN

- ./docker altındaki docker-compose çalıştırılır.
- ./src/main/java/com.hcg.mastermicroservices.user.configuration altındaki MasterMicroservicesApplication.java üzerinden spring boot applicaton run veya debug edilebilir.

Uygulama içinde **actuator** ve **swagger** aktiftir.
**port:8085** olarak application.yml üzerinden set edilmiştir.
Rest api dokümantasyonu için uygulamayı çalıştırdıktan sonra aşağıdaki adresten inceleyebilirsiniz.
- http://localhost:8085/swagger-ui.html

Spring security aktif olduğu için application.yml içinden swagger erişimi için kullanıcı adı şifre kullanabilirisiniz.
<pre><code>spring:
  security:
    user:
      name: hcguler
      password: Ab123456
</code></pre>