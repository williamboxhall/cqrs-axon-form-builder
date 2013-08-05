package org.example.write.domain;

import static org.example.write.domain.UnitOfMeasure.LENGTH_METRE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class UnitOfMeasureTest {
    @Test
    public void shouldBeAbleToResolveUnitOfMeasureByNameLowerHyphen() {
        assertThat(UnitOfMeasure.valueOfLowerHyphen("length-metre"), is(LENGTH_METRE));
    }
}
