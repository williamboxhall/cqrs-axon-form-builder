package org.example.read.projectors;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.example.events.BooleanFieldConfigured;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.BooleanFieldConfiguration;
import org.example.read.views.BooleanFieldConfigurationDto;
import org.example.read.views.BooleanFieldScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BooleanFieldProjector implements QueryHandler<BooleanFieldConfigurationDto, BooleanFieldConfiguration> {
    @Autowired
    private BooleanFieldScreen screen;

    @Override
    public BooleanFieldConfigurationDto handle(BooleanFieldConfiguration query) {
        return screen.findOne(query.getGuid());
    }

    @EventHandler
    private void on(BooleanFieldConfigured event) {
        screen.save(new BooleanFieldConfigurationDto(
                event.getGuid(),
                event.getName(),
                event.getLabel(),
                event.getHintText()));
    }
}
