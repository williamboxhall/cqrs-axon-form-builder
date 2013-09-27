package org.example.write.domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.example.write.commands.SubmitForm;

public class FormSubmission extends AbstractAnnotatedAggregateRoot<String> {
    // TODO how to load all custom fields generically
//    @CommandHandler
//    public FormSubmission(SubmitForm command, Repos) {
//
//    }
}
