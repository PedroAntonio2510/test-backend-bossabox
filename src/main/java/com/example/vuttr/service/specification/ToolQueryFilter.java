package com.example.vuttr.service.specification;

import com.example.vuttr.domain.Tool;
import org.springframework.data.jpa.domain.Specification;

import static com.example.vuttr.service.specification.ToolSpecification.specification;

public class ToolQueryFilter {

    private String tag;

    public Specification<Tool> toSpecification() {
        return specification(tag);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
