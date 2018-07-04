package com.comsoftacuity.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.comsoftacuity.entity.Suggestion;

public class SuggestionSpecification {

	public static Specification<Suggestion> queryTerm(String queryTerm){
		return (root , query , cb) -> {
            String containsLikePattern = getContainsLikePattern(queryTerm);
            return cb.like(cb.lower(root.get("autocomplete").as(String.class)), containsLikePattern);
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
