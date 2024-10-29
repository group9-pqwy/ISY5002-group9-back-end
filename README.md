## Petoria(Spring Boot)

This system is a Pet Identification chatbot with a back-end powered by Spring Boot and Mybatis.

## Key Features

1. **Chat**
2. **Breed Identification**
3. **Feedback Record**

### Prerequisites

1. **Java 17**: Ensure that Java is installed and configured in your system.
2. **Maven**: Use Maven for dependency management (optional if using an IDE that manages dependencies automatically)

The following explains how to run this project in your local environment. If needed, you can try to change the port in the code and deploy it to the cloud by yourself.

### Step 1: Clone the Repository

Clone the repository to your local machine:

```
git clone https://github.com/group9-pqwy/ISY5002-group9-back-end.git
```

### Step 2: Adjusting configuration files

1. Create a MySQL database for the project.

2. In the `src/main/resources/application.yml` file, update configuration file by your own configuration(If you need bot API of our group, please contact us) :

   ``` yml
   telegram:
       bot:
           username: pet_professor_bot
           token: 
   
   spring:
       datasource:
           url: jdbc:mysql://
           username: 
           password: 
           driver-class-name: com.mysql.cj.jdbc.Driver
   ```

3. In the `src/main/resources/generatorConfig.xml` file, update configuration file in this part:

   ``` xml
     <!-- Fill in the connection configuration for the database -->
     <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                           connectionURL=""
                           userId=""
                           password="">
                           <property name="nullCatalogMeansCurrent" value="true" />
           </jdbcConnection>
   ```

### Step 3: Build the Project

If you are using Maven, run the following command to build the project and download all necessary dependencies:

```
mvn clean install
```

Alternatively, you can build the project using your IDE (e.g., IntelliJ IDEA, Eclipse).

### Step 4: Build Kafka Cluster

Open a terminal in the Kafka folder in the project root directory, then input:

```
docker-compose up -d
```

Alternatively, you can build the project using your IDE (e.g., IntelliJ IDEA, Eclipse).

### Step 5: Run the Spring Boot Application

You can start the Spring Boot application in one of the following ways:

#### Using Maven

Run the following command to start the Spring Boot application with Maven:

```
mvn spring-boot:run
```

#### Using Java Command

If you have already built the project, you can start it with the Java command:

```
java -jar target/yourprojectname-0.0.1-SNAPSHOT.jar
```

#### Using IDE

- Open the project in your IDE.
- Navigate to the main application file (usually located in `src/main/java/nus/iss/ais/carquest/CarQuestApplication.java`).
- Run the application by right-clicking on the file and selecting `Run` or using the run option in your IDE toolbar.

### Step 5: Test the API Endpoints

Once the application is running, you can test the API endpoints using a tool like Postman or cURL. The default server will be hosted at `http://localhost:8080`.

### Additional Notes

- **Logs**: Check the console output or the logs directory for any errors or debug information.
- **Environment-Specific Configurations**: You can add separate configuration files for different environments (`application-dev.yml`, `application-prod.yml`, etc.) and specify the active profile with `spring.profiles.active` in `application.yml`.

