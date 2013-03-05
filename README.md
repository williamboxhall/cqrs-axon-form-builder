A toy webapp with a minimalist implementation of CQRS/event-sourcing using the Axon Framework.

Build and run with: mvn clean install jetty:run

Commands (POST, Content-Type:"application/json"):
http://localhost:8080/perform/RegisterPerson
{ "personId":"1234", "title":"Mr", "firstName":"John", "lastName":"Smith", "birthday":"09-12-1984","gender":"male" }
http://localhost:8080/perform/ChangeSex
{ "personId":"1234", "gender":"female" }
http://localhost:8080/perform/BuyThing
{ "personId":"1234", "thing":"pie" }

Queries (GET, Content-Type:"application/json")
http://localhost:8080/view/PersonEventStream?personId=1234
http://localhost:8080/view/PersonProfile?personId=1234
http://localhost:8080/view/JustInTimePersonProfileQuery?personId=1234

Replay all events (regenerate views)
http://localhost:8080/view/replayAll