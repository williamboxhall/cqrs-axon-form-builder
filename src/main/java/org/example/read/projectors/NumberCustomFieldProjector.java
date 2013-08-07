package org.example.read.projectors;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.example.events.NumberCustomFieldConfigured;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.NumberCustomFieldConfiguration;
import org.example.read.views.NumberCustomFieldConfigurationDto;
import org.example.read.views.NumberCustomFieldScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberCustomFieldProjector implements QueryHandler<NumberCustomFieldConfigurationDto, NumberCustomFieldConfiguration> {
    @Autowired
    private NumberCustomFieldScreen screen;

    @Override
    public NumberCustomFieldConfigurationDto handle(NumberCustomFieldConfiguration query) {
        return screen.findOne(query.getGuid());
    }

    @EventHandler
    private void on(NumberCustomFieldConfigured event) {
        screen.save(new NumberCustomFieldConfigurationDto(
                event.getGuid(),
                event.getContext(),
                event.getName(),
                event.getLocale(),
                event.getLabel(),
                event.getHintText(),
                event.getUnitQuantity(),
                event.getUnitName(),
                event.getUnitSymbol()));
    }
}
