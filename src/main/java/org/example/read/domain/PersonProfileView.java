package org.example.read.domain;

import org.axonframework.domain.MetaData;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.PersonProfileQuery;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class PersonProfileView implements BeanFactoryAware, QueryHandler<PersonProfile, PersonProfileQuery>{
    private BeanFactory beanFactory;

    @Override
    public PersonProfile handle(PersonProfileQuery query) {
        return repository().get(query.getGuid());
    }

    @EventHandler
    private void on(PersonRegistered event) {
        repository().save(new PersonProfile()
                .guid(event.getGuid())
                .title(event.getTitle())
                .firstName(event.getFirstName())
                .lastName(event.getLastName())
                .birthday(event.getBirthday())
                .gender(event.getGender()));
    }

    @EventHandler
    private void on(SexChanged sexChanged, MetaData metaData) {
        repository().save(repository().get((String) metaData.get("guid")).gender(sexChanged.getGender()));
    }

    private PersonProfileRepository repository() {
        return beanFactory.getBean(PersonProfileRepository.class);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
