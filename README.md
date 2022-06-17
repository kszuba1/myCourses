* Instructor 
  * Login and Registration
  * Read your courses
  * Read course details
  * Search courses by title
  * Course CRUD
### Technology stack
  * Java 8
  * Spring Boot
  * Spring Security
  * Spring Data
  * Hibernate
  * Thymeleaf
  * HTML, CSS, Bootstrap
  * MySQL
<hr>
  
## How to run

You will need MySQL. Run this /resources/my_courses_init.sql script in MySQL Workbench.
Then change /resources/application.properties with your credentials.
```.properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```
Run /src/main/java/io.github.kszuba1/MyCoursesApplication.
<br>
App should be running on localhost. Remember to add /myCourses to URL

