package org.example.read.views;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEventsScreen extends CrudRepository<PersonEventView, String> {
    List<PersonEventView> findByPersonId(String personId);
}
