package com.comsoftacuity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comsoftacuity.entity.AccountType;

@Repository
public interface AccountTypeRepository extends CrudRepository<AccountType, Integer> , JpaSpecificationExecutor<AccountType>{
    public AccountType findByDescriptionIgnoreCase(String description) ;
    public List<AccountType> findByDescriptionContainsIgnoreCase(String description) ;
    //List<AccountType> findByIdContainsOrCodeContainsOrDescriptionContainsAllIgnoreCase(Integer idPart , Integer codePart , String descriptionPart) ;
    List<AccountType> findByIdContainsOrCodeContainsAllIgnoreCase(Integer idPart , Integer codePart) ;

}
