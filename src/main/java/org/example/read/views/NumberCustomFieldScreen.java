package org.example.read.views;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberCustomFieldScreen extends CrudRepository<NumberCustomFieldConfigurationDto, String> {
}
