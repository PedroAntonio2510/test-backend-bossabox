package com.example.vuttr.service.specification;

import com.example.vuttr.domain.Tool;
import org.springframework.data.jpa.domain.Specification;

public class ToolSpecification {

    public static Specification<Tool> specification(String tag) {
        return (root, query, criteriaBuilder) -> {
            if (tag == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.isMember(tag, root.get("tags"));
        };
    }
}