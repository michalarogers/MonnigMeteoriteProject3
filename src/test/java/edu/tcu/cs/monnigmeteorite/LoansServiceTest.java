package edu.tcu.cs.monnigmeteorite;

import edu.tcu.cs.monnigmeteorite.model.Loans;
import edu.tcu.cs.monnigmeteorite.repository.LoansRepository;
import edu.tcu.cs.monnigmeteorite.service.LoansService;
import edu.tcu.cs.monnigmeteorite.system.LoansNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LoansServiceTest {

    @Mock
    LoansRepository loansRepository;
    @InjectMocks
    LoansService loansService;

    List<Loans> loans;

    @BeforeEach
    void setUp() {
        this.loans = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFindByIdSuccess() {
        // Given
        Loans l1 = new Loans();
        l1.setId(1);
        l1.setLoaneeName("John Doe");
        l1.setInstitution("ABC University");
        l1.setEmail("");
        l1.setPhone("");
        l1.setAddress("");
        l1.setLoanStartDate("");
        l1.setLoanDueDate("");
        l1.setMonnigIds("");
        l1.setNotes("");
        l1.setExtraFile("");
        l1.setArchived(false);

        given(loansRepository.findById(1)).willReturn(Optional.of(l1));

        // When
        Loans returnedLoans = loansService.findById(1);

        // Then
        assertThat(returnedLoans.getId()).isEqualTo(l1.getId());
        assertThat(returnedLoans.getLoaneeName()).isEqualTo(l1.getLoaneeName());
        assertThat(returnedLoans.getInstitution()).isEqualTo(l1.getInstitution());

        verify(loansRepository, times(1)).findById(1);

    }
    @Test
    void testFindByIdNotFound() {
        // Given
        given(loansRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.empty());

        // When
        Throwable thrown = catchThrowable(() -> {
            Loans returnedLoans = loansService.findById((1));
        });

        // Then
        assertThat(thrown)
                .isInstanceOf(LoansNotFoundException.class)
                .hasMessage("Could not find loan with id 1 :(");
        verify(loansRepository, times(1)).findById(1);
    }

    @Test
    void testFindAllUnarchivedSuccess() {
        // Given
        Loans archivedLoan = new Loans();
        archivedLoan.setId(1);
        archivedLoan.setArchived(true);

        Loans unarchivedLoan1 = new Loans();
        unarchivedLoan1.setId(2);
        unarchivedLoan1.setArchived(false);

        Loans unarchivedLoan2 = new Loans();
        unarchivedLoan2.setId(3);
        unarchivedLoan2.setArchived(false);

        List<Loans> allLoans = new ArrayList<>();
        allLoans.add(archivedLoan);
        allLoans.add(unarchivedLoan1);
        allLoans.add(unarchivedLoan2);

        given(loansRepository.findAll()).willReturn(allLoans);

        // When
        List<Loans> unarchivedLoans = loansService.findAllUnarchived();

        // Then
        assertThat(unarchivedLoans).containsExactlyInAnyOrder(unarchivedLoan1, unarchivedLoan2);
        verify(loansRepository, times(1)).findAll();
    }

    @Test
    void testSaveSuccess() {
        // Given
        Loans newLoans = new Loans();
        newLoans.setId(0);
        newLoans.setLoaneeName("new loanee 1 service");
        newLoans.setInstitution("new institution 1 service");
        newLoans.setEmail("new email 1 service");
        newLoans.setPhone("new phone 1 service");
        newLoans.setAddress("new address 1 service");
        newLoans.setLoanStartDate("new start date 1 service");
        newLoans.setLoanDueDate("new end date 1 service");
        newLoans.setMonnigIds("new monnig ids 1 service");
        newLoans.setNotes("new Notes 1 service");
        newLoans.setExtraFile("new extra file 1 service");
        newLoans.setArchived(false);

        given(this.loansRepository.save(newLoans)).willReturn(newLoans);

        // When
        Loans savedLoans = this.loansService.save(newLoans);

        // Then
//        assertThat(savedLoans.getId()).isNull();
        assertThat(savedLoans.getId()).isEqualTo(0);
        assertThat(savedLoans.getInstitution()).isEqualTo(newLoans.getInstitution());
        assertThat(savedLoans.getEmail()).isEqualTo(newLoans.getEmail());
        assertThat(savedLoans.getPhone()).isEqualTo(newLoans.getPhone());
        assertThat(savedLoans.getAddress()).isEqualTo(newLoans.getAddress());
        assertThat(savedLoans.getLoanStartDate()).isEqualTo(newLoans.getLoanStartDate());
        assertThat(savedLoans.getLoanDueDate()).isEqualTo(newLoans.getLoanDueDate());
        assertThat(savedLoans.getMonnigIds()).isEqualTo(newLoans.getMonnigIds());
        assertThat(savedLoans.getNotes()).isEqualTo(newLoans.getNotes());
        assertThat(savedLoans.getExtraFile()).isEqualTo(newLoans.getExtraFile());
        assertThat(savedLoans.isArchived()).isEqualTo(newLoans.isArchived());
        verify(loansRepository, times(1)).save(newLoans);
    }

    @Test
    void testUpdateSuccess() {
        // Given
        Loans oldLoans = new Loans();
        oldLoans.setId(1);
        oldLoans.setLoaneeName("loanee 2 service");
        oldLoans.setInstitution("institution 2 service");
        oldLoans.setEmail("email 2 service");
        oldLoans.setPhone("phone 2 service");
        oldLoans.setAddress("address 2 service");
        oldLoans.setLoanStartDate("start date 2 service");
        oldLoans.setLoanDueDate("end date 2 service");
        oldLoans.setMonnigIds("monnig ids 2 service");
        oldLoans.setNotes("Notes 2 service");
        oldLoans.setExtraFile("extra file 2 service");
        oldLoans.setArchived(false);

        Loans update = new Loans();
        update.setId(1);
        update.setLoaneeName("new loanee");
        update.setInstitution("new Instituion");
        update.setEmail("new email");
        update.setPhone("new phone");
        update.setAddress("new address");
        update.setLoanStartDate("new start date");
        update.setLoanDueDate("new end date");
        update.setMonnigIds("new monnig ids");
        update.setNotes("new notes");
        update.setExtraFile("new file");
        update.setArchived(false);

        given(this.loansRepository.findById(oldLoans.getId())).willReturn(Optional.of(oldLoans));
        given(this.loansRepository.save(oldLoans)).willReturn(oldLoans);

        // When
        Loans updatedLoans = loansService.update(1, update);

        // Then
        assertThat(updatedLoans.getId()).isEqualTo(1);
        assertThat(updatedLoans.getLoaneeName()).isEqualTo(update.getLoaneeName());
        verify(this.loansRepository, times(1)).findById(1);
        verify(this.loansRepository, times(1)).save(oldLoans);
    }
    @Test
    void testUpdateNotFound() {
        // Given
        Loans update = new Loans();
        update.setId(1);
        update.setLoaneeName("new loanee");
        update.setInstitution("new Instituion");
        update.setEmail("new email");
        update.setPhone("new phone");
        update.setAddress("new address");
        update.setLoanStartDate("new start date");
        update.setLoanDueDate("new end date");
        update.setMonnigIds("new monnig ids");
        update.setNotes("new notes");
        update.setExtraFile("new file");
        update.setArchived(false);

        given(this.loansRepository.findById(1)).willReturn(Optional.empty());

        // When
        assertThrows(ObjectNotFoundException.class, () -> {
            this.loansService.update(1, update);
        });

        // Then
        verify(this.loansRepository, times(1)).findById(1);
    }

    @Test
    void testArchiveSuccess() {
        // Given
        Loans loanToArchive = new Loans();
        loanToArchive.setId(1);
        loanToArchive.setLoaneeName("new loanee");
        loanToArchive.setArchived(false);

        given(this.loansRepository.findById(1)).willReturn(Optional.of(loanToArchive));
        given(this.loansRepository.save(loanToArchive)).willReturn(loanToArchive);

        // When
        Loans archivedLoan = loansService.archive(1);

        // Then
        assertThat(archivedLoan.getId()).isEqualTo(1);
        assertThat(archivedLoan.isArchived()).isTrue();
        verify(this.loansRepository, times(1)).findById(1);
        verify(this.loansRepository, times(1)).save(loanToArchive);
    }
    @Test
    void testArchiveNotFound() {
        // Given
        given(this.loansRepository.findById(1)).willReturn(Optional.empty());

        // When
        assertThrows(LoansNotFoundException.class, () -> {
            this.loansService.archive(1);
        });

        // Then
        verify(this.loansRepository, times(1)).findById(1);
    }

    @Test
    void testUnarchiveSuccess() {
        // Given
        Loans loanToArchive = new Loans();
        loanToArchive.setId(1);
        loanToArchive.setLoaneeName("new loanee");
        loanToArchive.setArchived(true);

        given(this.loansRepository.findById(1)).willReturn(Optional.of(loanToArchive));
        given(this.loansRepository.save(loanToArchive)).willReturn(loanToArchive);

        // When
        Loans archivedLoan = loansService.unarchive(1);

        // Then
        assertThat(archivedLoan.getId()).isEqualTo(1);
        assertThat(archivedLoan.isArchived()).isFalse();
        verify(this.loansRepository, times(1)).findById(1);
        verify(this.loansRepository, times(1)).save(loanToArchive);
    }
    @Test
    void testUnarchiveNotFound() {
        // Given
        given(this.loansRepository.findById(1)).willReturn(Optional.empty());

        // When
        assertThrows(LoansNotFoundException.class, () -> {
            this.loansService.unarchive(1);
        });

        // Then
        verify(this.loansRepository, times(1)).findById(1);
    }

}
