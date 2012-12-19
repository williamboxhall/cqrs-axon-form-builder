package org.example.eventsourcing.presentation;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.example.eventsourcing.domain.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandArgumentResolver extends AbstractWebArgumentResolver<Command> {
    private final ObjectMapper jsonMapper;

    @Autowired
    public CommandArgumentResolver(ObjectMapper jsonMapper) {
        super(Command.class);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public Command resolveArgument(HttpServletRequest request) {
        return convert(bodyOf(request), commandTypeFrom(request));
    }

    private String bodyOf(HttpServletRequest request) {
        return "{\"guid\":\"123\", \"title\":\"Mr\", \"firstName\":\"Will\", \"lastName\":\"Box\", \"birthday\":\"1920-01-01\", \"gender\":\"male\"}";
    }

    private Class<Command> commandTypeFrom(HttpServletRequest request) {
        return commandTypeFor(nameFrom(request));
    }

    private String nameFrom(HttpServletRequest request) {
        return request.getRequestURI().split("/")[1];
    }

    private Class<Command> commandTypeFor(String commandName) {
        try {
            return (Class<Command>) Class.forName("org.example.write.application." + commandName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T convert(String json, Class<T> type) {
        try {
            return jsonMapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
