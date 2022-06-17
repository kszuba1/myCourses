# myCourses
<hr>

live: [http://my-courses-application.herokuapp.com/myCourses/](http://my-courses-application.herokuapp.com/myCourses/)
<br>

Use these credentials to login as:
* Student:
  * login: user
  * password: pass
* Instructor:
  * login: instr
  * password: pass
<br>
  * 
Full-stack application. There are 2 account types: Student and Instructor.
As a student, you can sign up for courses and comment on the courses for which you are enrolled. Instructor has a different interface, can add new courses or update/delete their courses.
<br>
### Features
* Student:
  * Login and Registration
  * Read all courses
  * Read course details
  * Search courses by title
  * Check courses you are signed up for
  * Review CRUD
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


