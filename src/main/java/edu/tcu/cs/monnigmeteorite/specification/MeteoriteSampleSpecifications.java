package edu.tcu.cs.monnigmeteorite.specification;

import edu.tcu.cs.monnigmeteorite.model.MeteoriteSample;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class MeteoriteSampleSpecifications {

    public static Specification<MeteoriteSample> findByCriteria(String name, String classType, String group, String country, String foundOrFall) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (classType != null && !classType.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("classType"), classType));
            }
            if (group != null && !group.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("group"), group));
            }
            if (country != null && !country.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("country"), country));
            }
            if (foundOrFall != null && !foundOrFall.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("foundOrFall"), foundOrFall));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
