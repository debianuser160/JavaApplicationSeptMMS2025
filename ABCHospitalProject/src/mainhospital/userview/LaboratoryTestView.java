package mainhospital.userview;

import mainhospital.models.LaboratoryTest;

import java.util.List;

public class LaboratoryTestView {

    // =========================================================
    // DISPLAY ALL LABORATORY TESTS
    // =========================================================

    public void displayLaboratoryTests(List<LaboratoryTest> tests) {

        if (tests == null || tests.isEmpty()) {
            System.out.println("No laboratory tests currently.");
            return;
        }

        System.out.println();
        System.out.println("======================================================================================");

        System.out.printf(
                "%-6s %-18s %-18s %-22s %-18s %-10s%n",
                "ID", "Patient", "Technician", "Test", "Test Date", "Status"
        );

        System.out.println("--------------------------------------------------------------------------------------");

        for (LaboratoryTest test : tests) {

            String patientName = test.getPatient().getFirstName()
                    + " " + test.getPatient().getLastName();

            String technicianName = test.getTechnician().getFirstName()
                    + " " + test.getTechnician().getLastName();

            System.out.printf(
                    "%-6d %-18s %-18s %-22s %-18s %-10s%n",
                    test.getId(),
                    patientName,
                    technicianName,
                    test.getTestName(),
                    test.getTestDate(),
                    test.getStatus()
            );
        }

        System.out.println("======================================================================================");
    }


    // =========================================================
    // DISPLAY ONE LABORATORY TEST
    // =========================================================

    public void displayLaboratoryTest(LaboratoryTest test) {

        if (test == null) {
            System.out.println("Laboratory test not found.");
            return;
        }

        System.out.println();
        System.out.println("======================================================");
        System.out.println("              LABORATORY TEST DETAILS");
        System.out.println("======================================================");

        System.out.printf("%-16s : %s%n", "Test ID", test.getId());
        System.out.printf("%-16s : %s %s%n", "Patient",
                test.getPatient().getFirstName(), test.getPatient().getLastName());
        System.out.printf("%-16s : %s %s%n", "Technician",
                test.getTechnician().getFirstName(), test.getTechnician().getLastName());
        System.out.printf("%-16s : %s%n", "Test Name", test.getTestName());
        System.out.printf("%-16s : %s%n", "Test Date", test.getTestDate());
        System.out.printf("%-16s : %s%n", "Result", test.getResult() != null
                ? test.getResult() : "Pending");
        System.out.printf("%-16s : %s%n", "Reference Range", test.getReferenceRange() != null
                ? test.getReferenceRange() : "N/A");
        System.out.printf("%-16s : %s%n", "Status", test.getStatus());

        System.out.println("======================================================");
    }
}