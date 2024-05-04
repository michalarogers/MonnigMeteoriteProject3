package edu.tcu.cs.monnigmeteorite.service;

import edu.tcu.cs.monnigmeteorite.specification.LoansSpecifications;
import edu.tcu.cs.monnigmeteorite.system.LoansNotFoundException;
import edu.tcu.cs.monnigmeteorite.model.Loans;
import edu.tcu.cs.monnigmeteorite.repository.LoansRepository;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoansService {

    private final LoansRepository loansRepository;

    public LoansService(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }


    public List<Loans> searchLoans(Integer id, String loaneeName, String institution, String email, String loanStartDate, String loanDueDate, String sortProperty, boolean desc) {
        Specification<Loans> spec = LoansSpecifications.findByCriteria(id, loaneeName, institution, email, loanStartDate, loanDueDate);
        Sort sort = desc ? Sort.by(sortProperty).descending() : Sort.by(sortProperty).ascending();
        return loansRepository.findAll(spec, sort);
    }


    public Loans findById(Integer loansId) {
        return this.loansRepository.findById(loansId)
                .orElseThrow(() -> new LoansNotFoundException(loansId));
    }

    public List<Loans> findAllUnarchived() {
        List<Loans> allLoans = this.loansRepository.findAll();
        return allLoans.stream()
                .filter(loans -> !loans.isArchived())
                .collect(Collectors.toList());
    }

    public Loans save(Loans newloans) {
        return this.loansRepository.save(newloans);
    }

    public Loans update(Integer loansId, Loans update) {
        Optional<Loans> optionalLoans = this.loansRepository.findById(loansId);
        if (optionalLoans.isPresent()) {
            Loans oldLoans = optionalLoans.get();
            oldLoans.setLoaneeName(update.getLoaneeName());
            oldLoans.setInstitution(update.getInstitution());
            oldLoans.setEmail(update.getEmail());
            oldLoans.setPhone(update.getPhone());
            oldLoans.setAddress(update.getAddress());
            oldLoans.setLoanStartDate(update.getLoanStartDate());
            oldLoans.setLoanDueDate(update.getLoanDueDate());
            oldLoans.setMonnigIds(update.getMonnigIds());
            oldLoans.setNotes(update.getNotes());
            oldLoans.setExtraFile(update.getExtraFile());
            oldLoans.setArchived(update.isArchived());
            return this.loansRepository.save(oldLoans);
        } else {
            throw new LoansNotFoundException(loansId);
        }
    }

    public Loans archive(Integer loansId) {
        Loans loanToArchive = findById(loansId);
        loanToArchive.setArchived(true);
        return this.loansRepository.save(loanToArchive);
    }

    public Loans unarchive(Integer loansId) {
        Loans loanToUnarchive = findById(loansId);
        loanToUnarchive.setArchived(false);
        return this.loansRepository.save(loanToUnarchive);
    }
}
