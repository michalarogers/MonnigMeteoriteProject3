package edu.tcu.cs.monnigmeteorite;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tcu.cs.monnigmeteorite.model.Loans;
import edu.tcu.cs.monnigmeteorite.service.LoansService;
import edu.tcu.cs.monnigmeteorite.system.StatusCode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class LoansControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    LoansService loansService;

    @Autowired
    ObjectMapper objectMapper;

    List<Loans> loans;

    @Value("/api/loans")
    String baseUrl;

    @BeforeEach
    void setUp() {
        this.loans = new ArrayList<>();

        Loans l1 = new Loans();
        l1.setId(1);
        l1.setLoaneeName("John Doe");
        l1.setInstitution("ABC University");
        l1.setEmail("john.doe@example.com");
        l1.setPhone("123-456-7890");
        l1.setAddress("123 Main St, City, Country");
        l1.setLoanStartDate("2024-05-01");
        l1.setLoanDueDate("2024-06-01");
        l1.setMonnigIds("12345, 67890");
        l1.setNotes("Sample notes for loan 1");
        l1.setExtraFile("loan-agreement-1.pdf");
        l1.setArchived(false);

        Loans l2 = new Loans();
        l2.setId(1);
        l2.setLoaneeName("Jane Smith");
        l2.setInstitution("XYZ College");
        l2.setEmail("jane.smithe@example.com");
        l2.setPhone("987-654-3210");
        l2.setAddress("456 Elm St, City, Country");
        l2.setLoanStartDate("2024-05-02");
        l2.setLoanDueDate("2024-06-02");
        l2.setMonnigIds("54321, 09876");
        l2.setNotes("Sample notes for loan 2");
        l2.setExtraFile("loan-agreement-2.pdf");
        l2.setArchived(false);

        Loans l3 = new Loans();
        l3.setId(1);
        l3.setLoaneeName("Alice Johnson");
        l3.setInstitution("DEF Institute");
        l3.setEmail("alice.johnson@example.com");
        l3.setPhone("555-123-4567");
        l3.setAddress("789 Oak St, City, Country");
        l3.setLoanStartDate("2024-05-03");
        l3.setLoanDueDate("2024-06-03");
        l3.setMonnigIds("24680, 13579");
        l3.setNotes("Sample notes for loan 3");
        l3.setExtraFile("loan-agreement-3.pdf");
        l3.setArchived(false);

        this.loans.add(l1);
        this.loans.add(l2);
        this.loans.add(l3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFindLoansByIdSuccess() throws  Exception {
        // Given
        given(this.loansService.findById(1)).willReturn(this.loans.get(0));

        // When and Then
        this.mockMvc.perform(get("/api/loans/1").accept(MediaType.APPLICATION_JSON))
                //client is accepting JSON as response
                .andExpect(jsonPath("$.flag").value(true))
                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
                .andExpect(jsonPath("$.message").value("Find One Success"))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.loaneeName").value("John Doe"));
    }
    @Test
    void testFindLoansByIdNotFound() {

    }

    @Test
    void testFindAllUnarchivedLoansSuccess() {
    }

    @Test
    void addLoans() {
    }

    @Test
    void updateLoans() {
    }

    @Test
    void archiveLoans() {
    }

    @Test
    void unarchiveLoans() {
    }
}