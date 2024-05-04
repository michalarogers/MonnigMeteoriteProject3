package edu.tcu.cs.monnigmeteorite.controller;

import edu.tcu.cs.monnigmeteorite.service.LoansService;
import edu.tcu.cs.monnigmeteorite.model.Loans;
import edu.tcu.cs.monnigmeteorite.specification.LoansSpecifications;
import edu.tcu.cs.monnigmeteorite.system.Result;
import edu.tcu.cs.monnigmeteorite.system.StatusCode;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoansController {

    private final LoansService loansService;

    public LoansController(LoansService loansService) {
        this.loansService = loansService;
    }


    @GetMapping("/search")
    public Result searchLoans(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String loaneeName,
            @RequestParam(required = false) String institution,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String loanStartDate,
            @RequestParam(required = false) String loanDueDate,
            @RequestParam(defaultValue = "id") String sortProperty, // default sort by id
            @RequestParam(defaultValue = "false") boolean desc // default sort ascending
    ) {
        List<Loans> foundLoans = loansService.searchLoans(id, loaneeName, institution, email, loanStartDate, loanDueDate, sortProperty, desc);
        return new Result(true, StatusCode.SUCCESS, "Search Success", foundLoans);
    }


    @GetMapping("{loansId}")
    public Result findLoansById(@PathVariable Integer loansId) {
        Loans foundLoans = this.loansService.findById(loansId);
        return new Result(true, StatusCode.SUCCESS, "Find One Success", foundLoans);
        //DO FIND BY ANYTHING
    }

    @GetMapping()
    public Result findAllUnarchivedLoans() {
        List<Loans> unarchivedLoans = this.loansService.findAllUnarchived();
        return new Result(true, StatusCode.SUCCESS, "Find All Unarchived Success", unarchivedLoans);
    }

//    @PostMapping
//    public Result addLoans(@RequestBody Loans loans) {
//        Loans savedLoans = this.loansService.save(loans);
//        return new Result(true, StatusCode.SUCCESS, "Add Success", savedLoans);
//    }
@PostMapping
public Result addLoans(@RequestBody Loans loans) {
    if (loans.getId() == null) {
        // ID is not provided, return a bad request response
        return new Result(false, StatusCode.INVALID_ARGUMENT, "ID is required for new loans.", null);
    }

    Loans savedLoans = this.loansService.save(loans);
    return new Result(true, StatusCode.SUCCESS, "Add Success", savedLoans);
}


    @PutMapping("/{loanId}")
    //@Valid?
    public Result updateLoans(@PathVariable Integer loanId, @RequestBody Loans loans) {
        Loans updatedLoans = this.loansService.update(loanId, loans);
        return new Result(true, StatusCode.SUCCESS, "Update Success", updatedLoans);
    }

    @PutMapping("/{loanId}/archive")
    public Result archiveLoans(@PathVariable Integer loanId) {
        Loans archivedLoans = this.loansService.archive(loanId);
        return new Result(true, StatusCode.SUCCESS, "Archive Success", archivedLoans);
    }

    @PutMapping("/{loanId}/unarchive")
    public Result unarchiveLoans(@PathVariable Integer loanId) {
        Loans unarchivedLoans = this.loansService.unarchive(loanId);
        return new Result(true, StatusCode.SUCCESS, "Unarchive Success", unarchivedLoans);
    }

}

