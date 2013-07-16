package org.example.read.projectors;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.example.events.BooleanCustomFieldConfigured;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.BooleanCustomFieldConfiguration;
import org.example.read.views.BooleanCustomFieldConigurationDto;
import org.example.read.views.BooleanCustomFieldScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BooleanCustomFieldProjector implements QueryHandler<BooleanCustomFieldConigurationDto, BooleanCustomFieldConfiguration> {
    private BooleanCustomFieldScreen screen;

    @Override
    public BooleanCustomFieldConigurationDto handle(BooleanCustomFieldConfiguration booleanCustomFieldConfiguration) {
        return screen.findOne(booleanCustomFieldConfiguration.getBooleanCustomFieldGuid());
    }

    @EventHandler
    private void on(BooleanCustomFieldConfigured event) {
        screen.save(new BooleanCustomFieldConigurationDto()
                .booleanCustomFieldGuid(event.getBooleanCustomFieldGuid())
                .context(event.getContext())
                .name(event.getName())
                .locale(event.getLocale())
                .label(event.getLabel())
                .tooltip(event.getTooltip()));
    }

    @Autowired
    public void setScreen(BooleanCustomFieldScreen screen) {
        this.screen = screen;
    }
}
