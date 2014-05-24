#cqrs-axon-form-builder

A toy webapp with a minimalist implementation of CQRS/event-sourcing using the Axon Framework and AngularJS<br />
AngularJS Frontend, Spring(MVC/REST/TX), Jackson JSON mapping, JSR303 validation of commands, Hibernate w/ Grepo Generic Repositories, Maven or Gradle for build, jetty web server.<br />
Testing with jUnit, Hamcrest and Mockito.

All commands/queries are handled via two generic controllers, no further controllers/glue layers required. The framework will automagically populate a command by convention and dispatch it on to the command handler inside the domain.

Build and run with:

```mvn clean install jetty:run```

OR

```gradle build jettyRun```

Point your browser at localhost:8080 and have a play.
