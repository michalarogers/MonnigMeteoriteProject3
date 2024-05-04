package edu.tcu.cs.monnigmeteorite.repository;

import edu.tcu.cs.monnigmeteorite.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoansRepository extends JpaRepository<Loans, Integer>, JpaSpecificationExecutor<Loans> {
}
