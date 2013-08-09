package org.example.read.views;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberFieldScreen extends CrudRepository<NumberFieldConfigurationDto, String> {
}
