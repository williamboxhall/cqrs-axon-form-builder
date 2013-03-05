A toy webapp with a minimalist implementation of CQRS/event-sourcing using the Axon Framework.
<br />
Build and run with: mvn clean install jetty:run
<br />
<br />
Commands (POST, Content-Type:"application/json"):<br />
http://localhost:8080/perform/RegisterPerson<br />
{ "personId":"1234", "title":"Mr", "firstName":"John", "lastName":"Smith", "birthday":"09-12-1984","gender":"male" }<br />
<br />
http://localhost:8080/perform/ChangeSex<br />
{ "personId":"1234", "gender":"female" }<br />
<br />
http://localhost:8080/perform/BuyThing<br />
{ "personId":"1234", "thing":"pie" }<br />
<br />
<br />
Queries (GET, Content-Type:"application/json"):<br />
http://localhost:8080/view/PersonEventStream?personId=1234<br />
http://localhost:8080/view/PersonProfile?personId=1234<br />
http://localhost:8080/view/JustInTimePersonProfileQuery?personId=1234<br />
<br />
<br />
Replay all events (regenerate views)<br />
http://localhost:8080/view/replayAll<br />