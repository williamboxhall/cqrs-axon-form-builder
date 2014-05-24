#cqrs-axon-form-builder

A toy webapp with a minimalist implementation of CQRS/event-sourcing using the Axon Framework and AngularJS

AngularJS Frontend, Spring(MVC/REST/TX), Axon framework for all command/event handling, Jackson JSON mapping, JSR303 validation of commands, Hibernate w/ Spring Generic Data Repositories, Maven or Gradle for build, jetty web server.

Testing with jUnit, Hamcrest and Mockito.

All commands/queries are handled via two generic controllers, no further controllers/glue layers required. The framework will automagically populate a command by convention and dispatch it on to the command handler inside the domain. All you need to do is define your command/event DTOs, your richly behavioured domain objects with command/event handlers, and your view DTOs and projectors.

Build and run with:

```mvn clean install jetty:run```

OR

```gradle build jettyRun```

Point your browser at localhost:8080 and have a play.
