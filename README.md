/spring4-mvc-gradle-xml-hello-world/src/main/webapp/WEB-INF/views/jsp/index.jsp
파일에서
The superclass "javax.servlet.http.HttpServlet" was not found on the Java Build Path
라는 오류가 뜨지만 잘 구동됨.
대체 왜..?

Gradle - Spring 4 MVC Hello World
===============================
Template for Spring 4 MVC + JSP view + XML configuration, using Gradle build tool.

###1. Technologies used
* Gradle 2.0
* Spring 4.1.6.RELEASE
* JSTL 1.2
* Logback 1.1.3
* Boostrap 3

###2. To Run this project locally
```shell
$ git clone https://github.com/mkyong/spring4-mvc-gradle-xml-hello-world
$ gradle jettyRun
```
Access ```http://localhost:8080/spring4```

###3. To import this project into Eclipse IDE
1. ```$ gradle eclipse```
2. Import into Eclipse via **existing projects into workspace** option.
3. Done.

###4. Project Demo
Please refer to this article [Gradle - Spring 4 MVC Hello World ](http://www.mkyong.com/spring-mvc/gradle-spring-mvc-web-project-example/)

