package com.comsoftacuity.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comsoftacuity.entity.Suggestion;

@Repository
public interface SuggestionRepository extends CrudRepository<Suggestion, String>, JpaSpecificationExecutor<Suggestion> {

}
