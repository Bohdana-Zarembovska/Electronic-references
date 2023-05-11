package org.electronicReferences.specification;

import org.electronicReferences.models.User;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.domain.Specification;

@Component
public class UserSpecification {
    public static Specification<User> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }
}
