package com.comsoftacuity.specifications ;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.comsoftacuity.entity.AccountType;

public final class AccountTypeSpecification {

    private AccountTypeSpecification() {

    }

    public static Specification<AccountType> searchTerm(String searchTerm) {
        return (root , query , cb) -> {
            String containsLikePattern = getContainsLikePattern(searchTerm);
            Predicate [] petterns = {
                cb.like(root.get("id").as(String.class), containsLikePattern),
                cb.like(root.get("code").as(String.class), containsLikePattern),
                cb.like(cb.lower(root.get("description")), containsLikePattern)
            } ;
            
            return cb.or(
                //cb.like(cb.lower(root.get("description")), containsLikePattern)
                petterns
            );
        };
    }

    private static String getContainsLikePattern(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        }
        else {
            return "%" + searchTerm.toLowerCase() + "%";
        }
    }

/*     static Specification<AccountType> hasDescription(String search) {
        return new Specification<AccountType>() {

            @Override
            public Predicate toPredicate(Root<AccountType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        };
    } 

    static Specification<AccountType> hasId(String search) {
        return new Specification<AccountType>() {

            @Override
            public Predicate toPredicate(Root<AccountType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        };
    } 

    static Specification<AccountType> hasCode(String search) {
        return new Specification<AccountType>() {

            @Override
            public Predicate toPredicate(Root<AccountType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        };
    }  */
}