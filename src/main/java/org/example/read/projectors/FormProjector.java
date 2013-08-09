package org.example.read.projectors;

import static com.google.common.collect.Ordering.usingToString;

import java.util.List;

import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.FormConfiguration;
import org.example.read.views.FieldConfigurationDto;
import org.example.read.views.FieldScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormProjector implements QueryHandler<List<FieldConfigurationDto>, FormConfiguration> {
    @Autowired
    private FieldScreen screen;

    @Override
    public List<FieldConfigurationDto> handle(FormConfiguration query) {
        return usingToString().sortedCopy(screen.findAll());
    }
}
