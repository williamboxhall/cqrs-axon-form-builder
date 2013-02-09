package org.example.eventsourcing.presentation;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import com.google.common.io.CharStreams;
import org.codehaus.jackson.map.ObjectMapper;
import org.example.eventsourcing.domain.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CommandArgumentResolver extends AbstractWebArgumentResolver<Command> {
    private final ObjectMapper jsonMapper;

    public CommandArgumentResolver(ObjectMapper jsonMapper) {
        super(Command.class);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public Command resolveArgument(HttpServletRequest request) {
        return convert(bodyOf(request), toCommandTypeFrom(request));
    }

    public static Class<Command> toCommandTypeFrom(HttpServletRequest request) {
        return commandTypeFor(nameFrom(request));
    }

    private static String nameFrom(HttpServletRequest request) {
        return request.getRequestURI().split("/")[1];
    }

    private String bodyOf(HttpServletRequest request) {
        try {
            return CharStreams.toString(request.getReader());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<Command> commandTypeFor(String commandName) {
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
