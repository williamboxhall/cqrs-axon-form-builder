package org.example.read.views;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomFieldScreen extends CrudRepository<CustomFieldConfigurationDto, String> {
    List<CustomFieldConfigurationDto> findByContext(String context);
}
