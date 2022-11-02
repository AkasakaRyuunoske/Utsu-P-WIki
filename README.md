<div align="center">
    <img src="src/main/resources/readme_resources/full-glitch-logo.svg" alt="css-in-readme">
</div>

Project fully dedicated to <a href="https://www.youtube.com/c/utsupofficial"> Utsu-P / 鬱P Works </a>.<br>

# Navigation
1. <a href="#thanks-utsu-p">Thaks Utsu-P. </a>
2. <a href="#structure">Structure</a>
3. <a href="#how-to-use">How to use</a>
4. <a href="#features">Features</a>
5. <a href="#tecnologies-used">Tecnologies used</a>
6. <a href="#why">Why?</a>

# Thanks Utsu-P

Not much is know about this guy. From <a href="https://vocaloid.fandom.com/wiki/Utsu-P">Fandom wiki: </a>

Utsu-P (鬱P, lit. Depression-P) (born December 01, 1990), is a recognized producer known for his metal VOCALOID songs.

Although at the beginning his songs exclusively featured Miku, he now also uses Rin, GUMI, and flower as well.

He is well known for managing VOCALOIDs to perform shouts, screams and grunts through the use of filters and effects, and his melody generally has a heavy bass line.

Aside from that, his lyrics often are somewhat complex and their hidden meaning is difficult to grasp at first glance.

He is also a member and founder of the band <a href="https://www.youtube.com/channel/UClxtqRMh8Jhl8H6hu5uAoiA/videos"> Ohayougozaimasu </a> (おはようございます, Good Morning), and producer of the idol group <a href="https://www.youtube.com/channel/UC8xlnhEOYqKCOA_zv119T0w/videos">Zsasz.</a>

# Structure 

The project structure is repeating that of Wikipedia, in terms of:
1) Many simple pages refering one to another.
2) Every registered user can manage content of these pages or add new.
3) Some pages are accessible only by certain role.
4) Another annoying stuff written with obvious grammatical errors.

<img src="https://i.ytimg.com/vi/siQxhzOksWU/maxresdefault.jpg"></img>

<h1 id="features">Features</h1>
1. JWT tokens Security
<br>
2. Wide configurations
<br>
3. Scalability

<h1 id="how-to-use"> How to use </h1>
Application is pretty easy to use and needs very little configuration.

## 1.Java <br>
Java enviroment must be configured to run Java applications. The version of Java used is 11(jdks/corretto-11.0.15)

## 2.MySQL database <br>
In order to run the application MySQL database must be running and application.properties must be configured accordingly.
<br> Default are: 
<br> <code>spring.datasource.url = ${SPRING_DATASOURCE_URL:jdbc:mysql://localhost:3306/utsu_p_wiki}</code>
<br> <code>spring.datasource.username          = ${SPRING_DATASOURCE_USERNAME:root}</code>
<br> <code>spring.datasource.password          = ${SPRING_DATASOURCE_PASSWORD:}</code>
<br> <code>spring.datasource.driver-class-name = com.mysql.jdbc.Driver</code>

The only query that has to be manually executed is:

<code>CREATE DATABASE utsu_p_wiki;</code>

To populate database with data consider using database-helper configuration in application.properties. 
<br> Easy and fast way:
<br> <code>database-helper.populate-database  = true</code>
<br> <code>database-helper.populate-all  = true</code>

### To make it work:
<br> 1. Enable these settings.
<br> 2. Run the application, data.sql file must be created.
<br> 3. Disable these settings and run again the application.
<br> 4. Check if data appeared in database, if it is so, manually delete data.sql file. (by default it will be at "\Utsu-P\src\main\resources\data.sql".

## 3.Tomcat <br>
Default port for embeded Tomcat server is 8080: <br>
<br> <code>server.port = 8080</code> <br>
<br> Make sure that port is not in use or change it in application.properties .

# Tecnologies used: 
1. Java.(11)
2. Spring Boot.(2.6.6)      <br>
2.1. Spring Web.            <br>
2.2. Spring Test. (Junit)   <br>
2.3. Spring Data JPA.       <br>
2.4. Spring Security.(JWT)  <br>
3. Mysql.
4. Hibernate.
5. Lombok.
6. Thymeleaf.
7. Maven.
8. HTML/CSS/JS.                     
8.1. JQuery.<br>
<br>

<h1 id="why"> Why? </h1>

Because Utsu-P is just too good at creating vocaloid music, so I will, in some way, try to help him get the attention he deserves.

</div>
