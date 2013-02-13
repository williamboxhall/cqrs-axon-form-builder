package org.example.read.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonProfileRepository extends CrudRepository<PersonProfile, String> {
}
