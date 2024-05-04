package edu.tcu.cs.monnigmeteorite.system;

import edu.tcu.cs.monnigmeteorite.model.Loans;
import edu.tcu.cs.monnigmeteorite.model.MeteoriteSample;
import edu.tcu.cs.monnigmeteorite.repository.LoansRepository;
import edu.tcu.cs.monnigmeteorite.repository.MeteoriteSampleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataIntializer implements CommandLineRunner {

    private final LoansRepository loansRepository;
    private final MeteoriteSampleRepository meteoriteSampleRepository;

    public DBDataIntializer(LoansRepository loansRepository, MeteoriteSampleRepository meteoriteSampleRepository) {
        this.loansRepository = loansRepository;
        this.meteoriteSampleRepository = meteoriteSampleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

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
        l2.setId(2);
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
        l3.setId(3);
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

        loansRepository.save(l1);
        loansRepository.save(l2);
        loansRepository.save(l3);

        MeteoriteSample m1 = new MeteoriteSample();
        m1.setName("Acfer 358");
        m1.setMonnigNumber("M2142.1");
        m1.setCountry("Algeria");
        m1.setClassType("Ordinary Chondrite");
        m1.setGroup("H");
        m1.setYearFound(2002);
        m1.setSampleWeight(5.9);

        MeteoriteSample m2 = new MeteoriteSample();
        m2.setName("Acfer 359");
        m2.setMonnigNumber("M2143.1");
        m2.setCountry("Algeria");
        m2.setClassType("Ordinary Chondrite");
        m2.setGroup("H");
        m2.setYearFound(2002);
        m2.setSampleWeight(4.2);

        MeteoriteSample m3 = new MeteoriteSample();
        m3.setName("Acfer 361");
        m3.setMonnigNumber("M2145.1");
        m3.setCountry("Algeria");
        m3.setClassType("Ordinary Chondrite");
        m3.setGroup("H");
        m3.setYearFound(2002);
        m3.setSampleWeight(5.3);

        meteoriteSampleRepository.save(m1);
        meteoriteSampleRepository.save(m2);
        meteoriteSampleRepository.save(m3);


    }
}
