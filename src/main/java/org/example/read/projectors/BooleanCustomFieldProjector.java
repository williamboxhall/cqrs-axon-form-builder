package org.example.read.projectors;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.example.events.BooleanCustomFieldConfigured;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.BooleanCustomFieldConfiguration;
import org.example.read.views.BooleanCustomFieldConfigurationDto;
import org.example.read.views.BooleanCustomFieldScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BooleanCustomFieldProjector implements QueryHandler<BooleanCustomFieldConfigurationDto, BooleanCustomFieldConfiguration> {
    @Autowired
    private BooleanCustomFieldScreen screen;

    @Override
    public BooleanCustomFieldConfigurationDto handle(BooleanCustomFieldConfiguration query) {
        return screen.findOne(query.getGuid());
    }

    @EventHandler
    private void on(BooleanCustomFieldConfigured event) {
        screen.save(new BooleanCustomFieldConfigurationDto(
                event.getGuid(),
                event.getContext(),
                event.getName(),
                event.getLocale(),
                event.getLabel(),
                event.getHintText()));
    }
}
