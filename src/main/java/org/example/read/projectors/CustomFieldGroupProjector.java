package org.example.read.projectors;

import static com.google.common.collect.Ordering.usingToString;

import java.util.List;

import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.CustomFieldGroup;
import org.example.read.views.CustomFieldConfigurationDto;
import org.example.read.views.CustomFieldScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomFieldGroupProjector implements QueryHandler<List<CustomFieldConfigurationDto>, CustomFieldGroup> {
    @Autowired
    private CustomFieldScreen screen;

    @Override
    public List<CustomFieldConfigurationDto> handle(CustomFieldGroup query) {
        return usingToString().sortedCopy(screen.findByContext(query.getContext()));
    }
}
