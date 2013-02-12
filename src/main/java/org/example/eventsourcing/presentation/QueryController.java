package org.example.eventsourcing.presentation;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.example.eventsourcing.domain.Query;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.eventsourcing.domain.QueryHandlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/read/{query}")
public class QueryController {
    private final QueryHandlerRepository queryHandlerRepository;

    @Autowired
    public QueryController(QueryHandlerRepository queryHandlerRepository) {
        this.queryHandlerRepository = queryHandlerRepository;
    }

    @RequestMapping(method = GET)
    @ResponseBody
    public <T> T handle(Query<T> query) {
        return queryHandlerRepository.<T, Query<T>>handlerFor((Class<Query>) query.getClass()).handle(query);
    }
}
