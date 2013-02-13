package org.example.read.domain;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventhandling.replay.ReplayAware;
import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.events.ThingBought;
import org.example.eventsourcing.domain.QueryHandler;
import org.example.read.queries.PersonProfileQuery;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class PersonProfileView implements BeanFactoryAware, ReplayAware, QueryHandler<PersonProfile, PersonProfileQuery>{
    private BeanFactory beanFactory;

    @Override
    public PersonProfile handle(PersonProfileQuery query) {
        return repository().get(query.getPersonId());
    }

    @EventHandler
    private void on(PersonRegistered event) {
        repository().save(new PersonProfile()
                .personId(event.getPersonId())
                .title(event.getTitle())
                .firstName(event.getFirstName())
                .lastName(event.getLastName())
                .birthday(event.getBirthday())
                .gender(event.getGender()));
    }

    @EventHandler
    private void on(SexChanged sexChanged) {
        repository().update(repository().get(sexChanged.getPersonId()).gender(sexChanged.getGender()));
    }

    @EventHandler
    private void on(ThingBought thingBought) {
        repository().update(repository().get(thingBought.getPersonId()).spent(thingBought.getCost()));
    }

    @Override
    public void beforeReplay() {
    }

    @Override
    public void afterReplay() {
    }

    private PersonProfileRepository repository() {
        return beanFactory.getBean(PersonProfileRepository.class);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
