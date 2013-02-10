package org.example.read.domain;

import org.codehaus.grepo.query.hibernate.repository.ReadWriteHibernateRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonProfileRepository extends ReadWriteHibernateRepository<PersonProfile, String> {
}
