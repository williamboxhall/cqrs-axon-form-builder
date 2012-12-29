package org.example.eventsourcing.presentation;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.example.eventsourcing.domain.Query;
import org.example.eventsourcing.domain.QueryHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{query}")
public class QueryController {
    @RequestMapping(method = GET)
    public <T> T handle(QueryHandler<T, Query<T>> queryHandler, Query<T> query) {
        return queryHandler.handle(query);
    }
}
