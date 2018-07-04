package com.comsoftacuity.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.comsoftacuity.entity.Account;

//@RepositoryRestResource(collectionResourceRel = "accounts" , path="accounts")
public interface AccountRepository extends CrudRepository<Account , Integer>, JpaSpecificationExecutor<Account>, PagingAndSortingRepository<Account, Integer> {

}
