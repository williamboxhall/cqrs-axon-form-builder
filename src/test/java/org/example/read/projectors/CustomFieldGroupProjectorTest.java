package org.example.read.projectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.List;

import org.example.read.queries.CustomFieldGroup;
import org.example.read.views.CustomFieldConfigurationDto;
import org.example.read.views.CustomFieldScreen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomFieldGroupProjectorTest {
    @Mock
    private CustomFieldScreen screen;
    @Mock
    private List<CustomFieldConfigurationDto> fields;
    @InjectMocks
    private CustomFieldGroupProjector projector;

    @Test
    public void shouldFindAllCustomFieldsForContext() {
        when(screen.findByContext("context")).thenReturn(fields);
        assertThat(projector.handle(new CustomFieldGroup("context")), is(fields));
    }
}
