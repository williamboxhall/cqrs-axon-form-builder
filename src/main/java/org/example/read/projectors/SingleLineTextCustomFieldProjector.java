package org.example.read.projectors;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.example.events.SingleLineTextCustomFieldConfigured;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.SingleLineTextCustomFieldConfiguration;
import org.example.read.views.SingleLineTextCustomFieldConfigurationDto;
import org.example.read.views.SingleLineTextCustomFieldScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleLineTextCustomFieldProjector implements QueryHandler<SingleLineTextCustomFieldConfigurationDto, SingleLineTextCustomFieldConfiguration> {
    @Autowired
    private SingleLineTextCustomFieldScreen screen;

    @Override
    public SingleLineTextCustomFieldConfigurationDto handle(SingleLineTextCustomFieldConfiguration query) {
        return screen.findOne(query.getGuid());
    }

    @EventHandler
    private void on(SingleLineTextCustomFieldConfigured event) {
        screen.save(new SingleLineTextCustomFieldConfigurationDto(
                event.getGuid(),
                event.getContext(),
                event.getName(),
                event.getLocale(),
                event.getLabel(),
                event.getHintText(),
                event.getMinLength(),
                event.getMaxLength()));
    }
}
