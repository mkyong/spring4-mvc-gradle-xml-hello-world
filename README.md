나는 mysql 대신 오라클을 사용함
=============
jdbc.properties 대신
WEB-INF/context/context-defult-orcl.xml 사용함
jdbc.properties 파일은 넣어놓기만 하고  불러오는 태그는 주석처리함
어느족이 편한지는 상황에 따라 다르므로..

http://syaku.tistory.com/269
========
위 예제 따라하기 위한 브런치

=== ===

전자정부 프레임워크 따라하는중

=== ===

어떤 jar 파일이 누락 되었음
뭔지는 모름

=== ===
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

