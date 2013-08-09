package org.example.read.projectors;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.List;

import org.example.read.queries.FormConfiguration;
import org.example.read.views.FieldConfigurationDto;
import org.example.read.views.FieldScreen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FormProjectorTest {
    @Mock
    private FieldScreen screen;
    @Mock
    private FieldConfigurationDto field;
    @InjectMocks
    private FormProjector projector;

    @Test
    public void shouldFindAllFields() {
        List<FieldConfigurationDto> fields = newArrayList(field);
        when(screen.findAll()).thenReturn(fields);
        assertThat(projector.handle(new FormConfiguration()), is(fields));
    }
}
