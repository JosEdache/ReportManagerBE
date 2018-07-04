package com.comsoftacuity.specifications;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.comsoftacuity.entity.PaymentLog;

public class PaymentLogSpecification {

	
	public static Specification<PaymentLog> queryTerm(String queryTerm){
		return (root , query , cb) -> {
            String containsLikePattern = getContainsLikePattern(queryTerm);
            Predicate [] petterns = {
                cb.like(root.get("dateLog").as(String.class), containsLikePattern),
                cb.like(cb.lower(root.get("description")), containsLikePattern),
                cb.like(cb.lower(root.get("paymentType")), containsLikePattern)
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
}
