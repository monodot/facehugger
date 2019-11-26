# facehugger

A utility that, when attached to a Spring Boot app, will suck all of the bean definitions out of it and produce a brief report on startup.

Named after the witty and whimsical character from Alien (1979).

## Getting started

1.  In `pom.xml`, update the versions of Spring Boot and Camel to match the application you are targeting.

2.  Compile the JAR locally:

    mvn clean install

3. Add to your application's POM:

    <dependency>
      <groupId>xyz.tomd.facehugger</groupId>
      <artifactId>facehugger</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>

4.  Start your application (`mvn spring-boot:run`), you should see the beans dumped to standard out.

