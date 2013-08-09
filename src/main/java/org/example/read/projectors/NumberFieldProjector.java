package org.example.read.projectors;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.example.events.NumberFieldConfigured;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.NumberFieldConfiguration;
import org.example.read.views.NumberFieldConfigurationDto;
import org.example.read.views.NumberFieldScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberFieldProjector implements QueryHandler<NumberFieldConfigurationDto, NumberFieldConfiguration> {
    @Autowired
    private NumberFieldScreen screen;

    @Override
    public NumberFieldConfigurationDto handle(NumberFieldConfiguration query) {
        return screen.findOne(query.getGuid());
    }

    @EventHandler
    private void on(NumberFieldConfigured event) {
        screen.save(new NumberFieldConfigurationDto(
                event.getGuid(),
                event.getName(),
                event.getLabel(),
                event.getHintText(),
                event.getUnitQuantity(),
                event.getUnitName(),
                event.getUnitSymbol()));
    }
}
