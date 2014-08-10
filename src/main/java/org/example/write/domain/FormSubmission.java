package org.example.write.domain;

import static java.util.UUID.randomUUID;

import java.util.UUID;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import org.example.events.FormSubmitted;
import org.example.write.commands.SubmitForm;

public class FormSubmission extends AbstractAnnotatedAggregateRoot<UUID> {
    @AggregateIdentifier
    private UUID guid;

    private FormSubmission() {
    }

	@EventSourcingHandler
    private void on(FormSubmitted event) {
        this.guid = event.getGuid();
    }

    @CommandHandler
    public FormSubmission(SubmitForm command) {
		// TODO validate
        apply(new FormSubmitted(randomUUID(), command));
    }
}
