https://github.com/packtpublishing/learn-spring-boot-in-100-steps---beginner-to-expert
https://www.coursera.org/learn/packt-spring-boot-foundations-lutga/home/module/1
https://github.com/in28minutes/spring-boot-master-class/blob/master/02.Spring-Boot-Web-Application-V2/99-step-by-step-changes.md

### New project
* https://start.spring.io


### Run project
* ./mvnw spring-boot:run

### spring-boot-devtools (pom.xml)
* Auto restart
* Does not work on pom.xml
* Gradle: 2 terminals
  * ./gradlew build --continuous
  * ./gradlew bootRun

### Configuration using Profiles
* Different configurations per env
* application-{environment}.properties
  * logging.level.org.springframework=trace
  * server.port=8081
* application.properties
  * spring.profiles.active=prod
  
### Configuration Services
* application.properties
  * currency-service.url
* create a class
  * Annotated w/ @Component and @ConfigurationProperties(prefix="currency-service")
  * Attribute url w/ getters and setters

### Actuator
  * ```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
    ```
  * management.endpoints.web.exposure.include=* health,metrics

### Gradle
You need 2 sessions
./gradlew build --continuous
./gradlew bootRun 

./gradlew build --continuous --parallel --build-cache --configuration-cache

### Controller
```
@Controller
@RequestMapping("/login")
public class LoginController {

   @GetMapping({"/", ""})
   public String showLoginJsp(@RequestParam String name, ModelMap model) {
    System.out.println(name);
    model.addAttribute("name", name);
    return "login";
   } 
}
```
### JSP
* src/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
* application.properties
  * spring.mvc.view.prefix=/WEB-INF/jsp
  * spring.mvc.view.sufix=jsp
* build.gradle
  * implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'
* ModelMap model -> model.addAttribute("name", name);

### Query parameters
* @RequestParam String name

### Logging
* import org.slf4j.Logger;
* private final Logger logger = LoggerFactory.getLogger(getClass());


### Session


### Forms


### JSTL
https://central.sonatype.com/artifact/javax.servlet/jstl
    @PostMapping("/add")
    public String saveToDo(@RequestBody String entity) {
        return "redirect:/todos/";
    }
@SessionAttributes("name")

# Validation
	implementation 'org.springframework.boot:spring-boot-starter-validation'
  Command Bean Form Binding Object
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <form:form method="post" modelAttribute="toDo">
    <form:input type="text" name="description" path="description">


# JPA
* implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
* @Entity Map bean to Database
* @Id and @Generate 
* src/main/resources/data.sql // Init script
* application.properties: spring.jpa.defer-datasource-initialization=true
* H2: In Memory database
  * runtimeOnly 'com.h2database:h2'
  * http://localhost:8080/h2-console
  * spring.datasource.url=jdbc:h2:mem:testdb (updates random default)

# Spring JPA
* 

# Spring security

* Default
  * All URLs are protected
  * Login for unauthorized request
  * CSRF
* interface SecureFilterChain
  * defines a chain matched against every request


