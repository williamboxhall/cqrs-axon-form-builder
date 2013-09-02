package org.example.read.projectors;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.example.events.TextFieldConfigured;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.TextFieldConfiguration;
import org.example.read.views.TextFieldConfigurationDto;
import org.example.read.views.TextFieldScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextFieldProjector implements QueryHandler<TextFieldConfigurationDto, TextFieldConfiguration> {
    @Autowired
    private TextFieldScreen screen;

    @Override
    public TextFieldConfigurationDto handle(TextFieldConfiguration query) {
        return screen.findOne(query.getGuid());
    }

    @EventHandler
    private void on(TextFieldConfigured event) {
        screen.save(new TextFieldConfigurationDto(
                event.getName(),
                event.getLabel(),
                event.getHintText(),
                event.getMinLength(),
                event.getMaxLength()));
    }
}
