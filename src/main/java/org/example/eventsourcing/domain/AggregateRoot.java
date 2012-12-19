package org.example.eventsourcing.domain;

import static org.springframework.util.ReflectionUtils.findMethod;

import java.lang.reflect.Method;
import java.util.List;

import com.google.common.collect.Lists;


public abstract class AggregateRoot {
    private List<Event> changes = Lists.newArrayList();

    public abstract Guid getGuid();

    List<Event> getChanges() {
        return changes;
    }

    void loadFromHistory(List<Event> changes) {
        for (Event change : changes) {
            applyChange(change, false);
        }
    }

    protected void applyChange(Event change) {
        applyChange(change, true);
    }

    private void applyChange(Event change, boolean isNew) {
        invokeApplyReflectively(change);
        if (isNew) {
            changes.add(change);
        }
    }

    private void invokeApplyReflectively(Event change) {
        Method applyMethod = findMethod(getClass(), "apply", change.getClass());
        try {
            applyMethod.setAccessible(true);
            applyMethod.invoke(this, change);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
