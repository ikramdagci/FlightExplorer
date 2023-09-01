# İlk aşama: Maven ile uygulama bağımlılıklarını çözün ve paketleyin
FROM maven:3.8.4-openjdk-17 AS dependency
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

# İkinci aşama: Uygulama kaynak kodlarını Docker image'a kopyalayın
FROM dependency AS build
COPY src src
RUN mvn package -DskipTests

# Üçüncü aşama: Derlenmiş uygulamayı başka bir Docker image'a kopyalayın
FROM openjdk:17-oracle
COPY --from=build /app/target/flight-search-api-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı başlatın
ENTRYPOINT ["java", "-jar", "/app.jar"]


## Bu aşamada, Maven'ı içeren özel bir Docker image'ını kullanacağız.
## İstenilen Maven sürümünü seçmek için Maven'in resmi Docker image'larını kullanabilirsiniz.
#FROM maven:3.8.4-openjdk-17 AS build
#
## Uygulama kaynak kodlarını Docker image'a kopyalayın
#WORKDIR /app
#COPY . .
#
## Uygulamayı Maven ile derleyin ve paketleyin
#RUN mvn clean package -DskipTests
#
## Derlenmiş uygulamayı başka bir Docker image'a kopyalayın
#FROM openjdk:17-oracle
#COPY --from=build /app/target/flight-search-api-0.0.1-SNAPSHOT.jar app.jar
#
## Uygulamayı başlatın
#ENTRYPOINT ["java", "-jar", "/app.jar"]
#
#
### Fetching latest version of Java
##FROM openjdk:17-oracle
##ADD target/flight-search-api-0.0.1-SNAPSHOT.jar app.jar
##ENTRYPOINT ["java","-jar","/app.jar"]
#### Setting up work directory
###WORKDIR /app
###
#### Copy the jar file into our app
###COPY ./target/flight-search-api-0.0.1-SNAPSHOT.jar /app
###
#### Exposing port 8080
###EXPOSE 8080
###
#### Starting the application
###CMD ["java", "-jar", "flight-search-api-0.0.1-SNAPSHOT.jar"]
