package org.example.write.domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.example.write.commands.SubmitForm;

public class FormSubmission extends AbstractAnnotatedAggregateRoot<String> {
    @AggregateIdentifier
    private String guid;

    private FormSubmission() {
    }

    @CommandHandler
    public FormSubmission(SubmitForm command) {
        System.out.println(command);
    }
}
