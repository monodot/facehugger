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

## Sample output

You should see something like this:

```
2019-11-26 22:25:51.394  INFO 24514 --- [           main] xyz.tomd.MySpringBootApplication         : Started MySpringBootApplication in 3.979 seconds (JVM running for 7.356)
org.springframework.boot.context.event.ApplicationStartedEvent[source=org.springframework.boot.SpringApplication@2e23452f]
**** DUMPING MY BEANS
**** org.springframework.context.annotation.internalConfigurationAnnotationProcessor = org.springframework.context.annotation.ConfigurationClassPostProcessor
**** org.springframework.context.annotation.internalAutowiredAnnotationProcessor = org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
**** org.springframework.context.annotation.internalCommonAnnotationProcessor = org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
**** org.springframework.context.event.internalEventListenerProcessor = org.springframework.context.event.EventListenerMethodProcessor
**** org.springframework.context.event.internalEventListenerFactory = org.springframework.context.event.DefaultEventListenerFactory
**** mySpringBootApplication = xyz.tomd.MySpringBootApplication$$EnhancerBySpringCGLIB$$d3b75339
...
...
**** END DUMP
```
