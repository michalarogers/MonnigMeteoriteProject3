package edu.tcu.cs.monnigmeteorite.specification;

import edu.tcu.cs.monnigmeteorite.model.Loans;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class LoansSpecifications {

    public static Specification<Loans> findByCriteria(
            Integer id,
            String loaneeName,
            String institution,
            String email,
            String loanStartDate,
            String loanDueDate) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (id != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), id));
            }
            if (loaneeName != null && !loaneeName.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("loaneeName")), "%" + loaneeName.toLowerCase() + "%"));
            }
            if (institution != null && !institution.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("institution")), "%" + institution.toLowerCase() + "%"));
            }
            if (email != null && !email.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + email.toLowerCase() + "%"));
            }
            if (loanStartDate != null && !loanStartDate.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("loanStartDate"), loanStartDate));
            }
            if (loanDueDate != null && !loanDueDate.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("loanDueDate"), loanDueDate));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
