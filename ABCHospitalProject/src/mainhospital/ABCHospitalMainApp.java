package mainhospital;

import mainhospital.models.Patient;
import mainhospital.models.Doctor;
import mainhospital.models.Nurse;
import mainhospital.models.Department;
import mainhospital.models.Appointment;
import mainhospital.models.LaboratoryTechnician;
import mainhospital.models.Pharmacist;
import mainhospital.models.User;
import mainhospital.models.StaffRole;
import mainhospital.models.Ward;
import mainhospital.models.Room;
import mainhospital.models.Bed;
import mainhospital.models.Admission;
import mainhospital.models.NurseAssignment;







import mainhospital.services.PatientService;
import mainhospital.services.DoctorService;
import mainhospital.services.NurseService;
import mainhospital.services.AppointmentService;
import mainhospital.services.UserService;
import mainhospital.services.LaboratoryTechnicianService;
import mainhospital.services.PharmacistService;
import mainhospital.services.WardService;
import mainhospital.services.RoomService;
import mainhospital.services.BedService;
import mainhospital.services.AdmissionService;
import mainhospital.services.NurseAssignmentService;

import mainhospital.userview.PatientView;
import mainhospital.userview.DoctorView;
import mainhospital.userview.NurseView;
import mainhospital.userview.AppointmentView;
import mainhospital.userview.LaboratoryTechnicianView;
import mainhospital.userview.PharmacistView;
import mainhospital.userview.UserView;
import mainhospital.userview.WardView;
import mainhospital.userview.RoomView;
import mainhospital.userview.BedView;
import mainhospital.userview.AdmissionView;
import mainhospital.userview.NurseAssignmentView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ABCHospitalMainApp {

    private static final Scanner scanner =
            new Scanner(System.in);
    
    // =========================================================
    // USER ACCOUNT
    // =========================================================

    private static final UserView userView =
        new UserView();
    
    private static final UserService userService =
            new UserService();

    // =========================================================
    // PATIENT
    // =========================================================

    private static final PatientService patientService =
            new PatientService();

    private static final PatientView patientView =
            new PatientView();


    // =========================================================
    // DOCTOR
    // =========================================================

    private static final DoctorService doctorService =
            new DoctorService();

    private static final DoctorView doctorView =
            new DoctorView();


    // =========================================================
    // NURSE
    // =========================================================

    private static final NurseService nurseService =
            new NurseService();

    private static final NurseView nurseView =
            new NurseView();
    
    // =======================================================
    // LABORATORY TECHNICIAN
    // =======================================================
    
    private static final LaboratoryTechnicianService laboratoryTechnicianService =
        new LaboratoryTechnicianService();

    private static final LaboratoryTechnicianView laboratoryTechnicianView =
        new LaboratoryTechnicianView();

    // =========================================================
    // PHARMACIST
    // =========================================================
    
    private static final PharmacistService pharmacistService=
            new PharmacistService();
    
    private static final PharmacistView pharmacistView =
            new PharmacistView();
    
    // =========================================================
    // APPOINTMENT
    // =========================================================

    private static final AppointmentService appointmentService =
            new AppointmentService();

    private static final AppointmentView appointmentView =
            new AppointmentView();
    
    // =========================================================
    // ADMISSION & BED MANAGEMENT
    // =========================================================

    private static final WardService wardService = new WardService();
    private static final WardView wardView = new WardView();

    private static final RoomService roomService = new RoomService();
    private static final RoomView roomView = new RoomView();

    private static final BedService bedService = new BedService();
    private static final BedView bedView = new BedView();

    private static final AdmissionService admissionService = new AdmissionService();
    private static final AdmissionView admissionView = new AdmissionView();

    private static final NurseAssignmentService nurseAssignmentService = new NurseAssignmentService();
    private static final NurseAssignmentView nurseAssignmentView = new NurseAssignmentView();


    // =========================================================
    // DATE FORMATTER
    // =========================================================

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        while (true) {

            displayMainMenu();

            int choice =
                    readInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    displayMainMenu();
                    break;

                case 2:
                    patientMenu();
                    break;

                case 3:
                    staffMenu();
                    break;

                case 4:
                    appointmentMenu();
                    break;

                case 5:
                    admissionMenu();
                    System.out.println(
                            "Admission and bed Management coming soon."
                    );
                    break;
                    
                case 6:
                    //clinicMenu();
                    System.out.println(
                            "Clinical management coming soon"
                    );
                    break;

                

                case 7:
                    //laboratoryMenu();
                    System.out.println(
                            "Laboratory Management coming soon."
                    );
                    break;

                case 8:
                    //pharmacyMenu();
                    System.out.println(
                            "Pharmacy Management coming soon."
                    );
                    break;
                case 9:
                    //BillingAndPaymentMenu();
                    System.out.println(
                            "Billing and payment Management coming soon."
                    );
                    break;
                case 10:
                    //hospitalAdminMenu();
                    System.out.println(
                            "hospital administration Management coming soon."
                    );
                    break;
                case 11:
                    userMenu();
                    break;

                case 0:

                    System.out.println();

                    System.out.println(
                            "Thank you for using ABC Hospital System."
                    );

                    scanner.close();

                    return;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // MAIN MENU
    // =========================================================

    private static void displayMainMenu() {

        System.out.println();

        System.out.println(
                "========================================"
        );

        System.out.println(
                "       ABC HOSPITAL MANAGEMENT SYSTEM"
        );

        System.out.println(
                "========================================"
        );
        
        System.out.println(
                "1. Dashboard"
        );

        System.out.println(
                "2. Patient Management"
        );

        System.out.println(
                "3. Staff Management"
        );

        System.out.println(
                "4. Appointment Management"
        );

        System.out.println(
                "5. Admission & Bed Management"
        );

        System.out.println(
                "6. Clinical Management"
        );

        System.out.println(
                "7. Laboratory Services"
        );
        
        System.out.println(
                    "8. Pharmacy Services"
        );

        System.out.println(
                "9. Billing & Payment"
        );

        System.out.println(
                "10. Hospital Administration"
        );

        System.out.println(
                "11. User Account"
        );
        
        System.out.println(
                    "0. Logout"
        );

        System.out.println(
                "========================================"
        );
    }


    // =========================================================
    // PATIENT MENU
    // =========================================================

    private static void patientMenu() {

        while (true) {

            System.out.println();

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "           PATIENT MANAGEMENT"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Register Patient"
            );

            System.out.println(
                    "2. View All Patients"
            );

            System.out.println(
                    "3. Find Patient"
            );

            System.out.println(
                    "4. Update Patient"
            );

            System.out.println(
                    "5. Delete Patient"
            );

            System.out.println(
                    "0. Back"
            );

            System.out.println(
                    "========================================"
            );

            int choice =
                    readInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    viewAllPatients();
                    break;

                case 3:
                    findPatient();
                    break;

                case 4:
                    updatePatient();
                    break;

                case 5:
                    deletePatient();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // REGISTER PATIENT
    // =========================================================

    private static void registerPatient() {

        System.out.println();

        System.out.println(
                "========== REGISTER PATIENT =========="
        );

        System.out.print(
                "First Name: "
        );

        String firstName =
                scanner.nextLine();

        System.out.print(
                "Last Name: "
        );

        String lastName =
                scanner.nextLine();

        System.out.print(
                "Gender (M/F): "
        );

        char gender =
                scanner.nextLine()
                        .charAt(0);

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        LocalDate dateOfBirth =
                LocalDate.parse(
                        scanner.nextLine()
                );

        System.out.print(
                "Phone: "
        );

        String phone =
                scanner.nextLine();

        System.out.print(
                "Email: "
        );

        String email =
                scanner.nextLine();

        System.out.print(
                "Street: "
        );

        String street =
                scanner.nextLine();

        System.out.print(
                "City: "
        );

        String city =
                scanner.nextLine();

        System.out.print(
                "Country: "
        );

        String country =
                scanner.nextLine();

        System.out.print(
                "Blood Group: "
        );

        String bloodGroup =
                scanner.nextLine();

        System.out.print(
                "Genotype: "
        );

        String genotype =
                scanner.nextLine();

        System.out.print(
                "Allergies: "
        );

        String allergies =
                scanner.nextLine();

        System.out.print(
                "Emergency Contact: "
        );

        String emergencyContact =
                scanner.nextLine();

        System.out.print(
                "Emergency Phone: "
        );

        String emergencyPhone =
                scanner.nextLine();

        Patient patient =
                new Patient(
                        0,
                        bloodGroup,
                        genotype,
                        allergies,
                        emergencyContact,
                        emergencyPhone,
                        firstName,
                        lastName,
                        gender,
                        dateOfBirth,
                        phone,
                        email,
                        street,
                        city,
                        country
                );

        boolean success =
                patientService.registerPatient(
                        patient
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Patient registered successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Failed to register patient."
            );
        }
    }


    // =========================================================
    // VIEW ALL PATIENTS
    // =========================================================

    private static void viewAllPatients() {

        List<Patient> patients =
                patientService.getAllPatients();

        patientView.displayPatients(
                patients
        );
    }


    // =========================================================
    // FIND PATIENT
    // =========================================================

    private static void findPatient() {

        int id =
                readInt(
                        "Enter Patient ID: "
                );

        Patient patient =
                patientService.getPatientById(
                        id
                );

        patientView.displayPatient(
                patient
        );
    }


    // =========================================================
    // UPDATE PATIENT
    // =========================================================

    private static void updatePatient() {

        int id =
                readInt(
                        "Enter Patient ID to update: "
                );

        Patient patient =
                patientService.getPatientById(
                        id
                );

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Enter new patient information."
        );

        System.out.print(
                "First Name: "
        );

        patient.setFirstName(
                scanner.nextLine()
        );

        System.out.print(
                "Last Name: "
        );

        patient.setLastName(
                scanner.nextLine()
        );

        System.out.print(
                "Gender (M/F): "
        );

        patient.setGender(
                scanner.nextLine()
                        .charAt(0)
        );

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        patient.setDateOfBirth(
                LocalDate.parse(
                        scanner.nextLine()
                )
        );

        System.out.print(
                "Phone: "
        );

        patient.setPhone(
                scanner.nextLine()
        );

        System.out.print(
                "Email: "
        );

        patient.setEmail(
                scanner.nextLine()
        );

        System.out.print(
                "Street: "
        );

        patient.setStreet(
                scanner.nextLine()
        );

        System.out.print(
                "City: "
        );

        patient.setCity(
                scanner.nextLine()
        );

        System.out.print(
                "Country: "
        );

        patient.setCountry(
                scanner.nextLine()
        );

        System.out.print(
                "Blood Group: "
        );

        patient.setBloodGroup(
                scanner.nextLine()
        );

        System.out.print(
                "Genotype: "
        );

        patient.setGenotype(
                scanner.nextLine()
        );

        System.out.print(
                "Allergies: "
        );

        patient.setAllergies(
                scanner.nextLine()
        );

        System.out.print(
                "Emergency Contact: "
        );

        patient.setEmergencyContact(
                scanner.nextLine()
        );

        System.out.print(
                "Emergency Phone: "
        );

        patient.setEmergencyPhone(
                scanner.nextLine()
        );

        boolean success =
                patientService.updatePatient(
                        patient
                );

        if (success) {

            System.out.println(
                    "Patient updated successfully."
            );

        } else {

            System.out.println(
                    "Patient update failed."
            );
        }
    }


    // =========================================================
    // DELETE PATIENT
    // =========================================================

    private static void deletePatient() {

        int id =
                readInt(
                        "Enter Patient ID to delete: "
                );

        Patient patient =
                patientService.getPatientById(
                        id
                );

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        patientView.displayPatient(
                patient
        );

        System.out.print(
                "Are you sure you want to delete this patient? (Y/N): "
        );

        String answer =
                scanner.nextLine();

        if (!answer.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Delete cancelled."
            );

            return;
        }

        boolean success =
                patientService.deletePatient(
                        id
                );

        if (success) {

            System.out.println(
                    "Patient deleted successfully."
            );

        } else {

            System.out.println(
                    "Patient deletion failed."
            );
        }
    }
    
    //=========================================================
    //STAFF MENU
    //=========================================================
    
    private static void staffMenu(){
        
        while (true) {
            System.out.println();
            System.out.println("==========================================");
            System.out.println("            STAFF MANAGEMENT"
            );
            System.out.println("=============================="
            );
            System.out.println("1. Doctor Management");
            System.out.println("2. Nurse Management");
            System.out.println("3. Laboratory Technician Management");   
            System.out.println("4. Pharmacist Management");  
            System.out.println("5. View All Staff");
            System.out.println("6. Find Staff");
            System.out.println("7. View Staff By Department");
            System.out.println("8. Staff Account Management");
            System.out.println("0. Back");
            
            int choice = readInt("Enter your choice: ");
            
            switch (choice) {
                
                case 1:
                    doctorMenu();
                    break;
                    
                case 2:
                    nurseMenu();
                    break;
                    
                case 3:
                    laboratoryTechnicianMenu();
                    break;
                    
                case 4:
                    pharmacistMenu();
                    break;
                    
                case 5:
                    viewAllStaffMenu();
                    break;
                //case 6:
                  //  findStaffMenu();
                    //break;
                    
                //case 7:
                    //staffDepartmentMenu();
                    //break;
                    
                case 8:
                    userMenu();
                    break;
                    
                    
                    
                    
                case 0:
                    return;
                    
                default:
                    System.out.println("Invalid choice.");
            }
            
        }
    }


    // =========================================================
    // DOCTOR MENU
    // =========================================================

    private static void doctorMenu() {

        while (true) {

            System.out.println();

            System.out.println(
                    "========================================"
            );

            System.out.println(
                                    
                    "           DOCTOR MANAGEMENT"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Register Doctor"
            );

            System.out.println(
                    "2. View All Doctors"
            );

            System.out.println(
                    "3. Find Doctor"
            );

            System.out.println(
                    "4. Update Doctor"
            );

            System.out.println(
                    "5. Delete Doctor"
            );

            System.out.println(
                    "0. Back"
            );

            System.out.println(
                    "========================================"
            );

            int choice =
                    readInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    registerDoctor();
                    break;

                case 2:
                    viewAllDoctors();
                    break;

                case 3:
                    findDoctor();
                    break;

                case 4:
                    updateDoctor();
                    break;

                case 5:
                    deleteDoctor();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // REGISTER DOCTOR
    // =========================================================

    private static void registerDoctor() {

        System.out.println();

        System.out.println(
                "========== REGISTER DOCTOR =========="
        );

        System.out.print(
                "First Name: "
        );

        String firstName =
                scanner.nextLine();

        System.out.print(
                "Last Name: "
        );

        String lastName =
                scanner.nextLine();

        System.out.print(
                "Gender (M/F): "
        );

        char gender =
                scanner.nextLine()
                        .charAt(0);

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        LocalDate dateOfBirth =
                LocalDate.parse(
                        scanner.nextLine()
                );

        System.out.print(
                "Phone: "
        );

        String phone =
                scanner.nextLine();

        System.out.print(
                "Email: "
        );

        String email =
                scanner.nextLine();

        System.out.print(
                "Street: "
        );

        String street =
                scanner.nextLine();

        System.out.print(
                "City: "
        );

        String city =
                scanner.nextLine();

        System.out.print(
                "Country: "
        );

        String country =
                scanner.nextLine();


        System.out.print(
                "Employment Date (yyyy-MM-dd): "
        );

        LocalDate employmentDate =
                LocalDate.parse(
                        scanner.nextLine()
                );

        System.out.print(
                "Salary: "
        );

        double salary =
                Double.parseDouble(
                        scanner.nextLine()
                );


        int departmentId =  
                readInt(
                        "Department ID: "
                );

        System.out.print(
                "Department Name: "
        );

        String departmentName =
                scanner.nextLine();

        Department department =
                new Department();

        department.setId(
                departmentId
        );

        department.setName(
                departmentName
        );


        System.out.print(
                "Specialization: "
        );

        String specialization =
                scanner.nextLine();

        System.out.print(
                "License Number: "
        );

        String licenseNumber =
                scanner.nextLine();


        Doctor doctor =
                new Doctor(
                        firstName,
                        lastName,
                        gender,
                        dateOfBirth,
                        phone,
                        email,
                        street,
                        city,
                        country,
                        0,
                        employmentDate,
                        salary,
                        department,
                        specialization,
                        licenseNumber
                );


        boolean success =
                doctorService.registerDoctor(
                        doctor
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Doctor registered successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Failed to register doctor."
            );
        }
    }


    // =========================================================
    // VIEW ALL DOCTORS
    // =========================================================

    private static void viewAllDoctors() {

        List<Doctor> doctors =
                doctorService.getAllDoctors();

        doctorView.displayDoctors(
                doctors
        );
    }


    // =========================================================
    // FIND DOCTOR
    // =========================================================

    private static void findDoctor() {

        int id =
                readInt(
                        "Enter Doctor/Staff ID: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        id
                );

        doctorView.displayDoctor(
                doctor
        );
    }


    // =========================================================
    // UPDATE DOCTOR
    // =========================================================

    private static void updateDoctor() {

        int id =
                readInt(
                        "Enter Doctor/Staff ID to update: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        id
                );

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        System.out.println();

        doctorView.displayDoctor(
                doctor
        );

        System.out.println();

        System.out.println(
                "Enter new doctor information."
        );


        System.out.print(
                "First Name: "
        );

        doctor.setFirstName(
                scanner.nextLine()
        );

        System.out.print(
                "Last Name: "
        );

        doctor.setLastName(
                scanner.nextLine()
        );

        System.out.print(
                "Gender (M/F): "
        );

        doctor.setGender(
                scanner.nextLine()
                        .charAt(0)
        );

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        doctor.setDateOfBirth(
                LocalDate.parse(
                        scanner.nextLine()
                )
        );

        System.out.print(
                "Phone: "
        );

        doctor.setPhone(
                scanner.nextLine()
        );

        System.out.print(
                "Email: "
        );

        doctor.setEmail(
                scanner.nextLine()
        );

        System.out.print(
                "Street: "
        );

        doctor.setStreet(
                scanner.nextLine()
        );

        System.out.print(
                "City: "
        );

        doctor.setCity(
                scanner.nextLine()
        );

        System.out.print(
                "Country: "
        );

        doctor.setCountry(
                scanner.nextLine()
        );


        System.out.print(
                "Employment Date (yyyy-MM-dd): "
        );

        doctor.setEmploymentDate(
                LocalDate.parse(
                        scanner.nextLine()
                )
        );

        System.out.print(
                "Salary: "
        );

        doctor.setSalary(
                Double.parseDouble(
                        scanner.nextLine()
                )
        );


        int departmentId =
                readInt(
                        "Department ID: "
                );

        System.out.print(
                "Department Name: "
        );

        String departmentName =
                scanner.nextLine();

        Department department =
                new Department();

        department.setId(
                departmentId
        );

        department.setName(
                departmentName
        );

        doctor.setDepartment(
                department
        );


        System.out.print(
                "Specialization: "
        );

        doctor.setSpecialization(
                scanner.nextLine()
        );

        System.out.print(
                "License Number: "
        );

        doctor.setLicenseNumber(
                scanner.nextLine()
        );


        boolean success =
                doctorService.updateDoctor(
                        doctor
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Doctor updated successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Doctor update failed."
            );
        }
    }


    // =========================================================
    // DELETE DOCTOR
    // =========================================================

    private static void deleteDoctor() {

        int id =
                readInt(
                        "Enter Doctor/Staff ID to delete: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        id
                );

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        doctorView.displayDoctor(
                doctor
        );

        System.out.print(
                "Are you sure you want to delete this doctor? (Y/N): "
        );

        String answer =
                scanner.nextLine();

        if (!answer.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Delete cancelled."
            );

            return;
        }

        boolean success =
                doctorService.deleteDoctor(
                        id
                );

        if (success) {

            System.out.println(
                    "Doctor deleted successfully."
            );

        } else {

            System.out.println(
                    "Doctor deletion failed."
            );
        }
    }


    // =========================================================
    // NURSE MENU
    // =========================================================

    private static void nurseMenu() {

        while (true) {

            System.out.println();

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "            NURSE MANAGEMENT"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Register Nurse"
            );

            System.out.println(
                    "2. View All Nurses"
            );

            System.out.println(
                    "3. Find Nurse"
            );

            System.out.println(
                    "4. Update Nurse"
            );

            System.out.println(
                    "5. Delete Nurse"
            );

            System.out.println(
                    "0. Back"
            );

            System.out.println(
                    "========================================"
            );

            int choice =
                    readInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    registerNurse();
                    break;

                case 2:
                    viewAllNurses();
                    break;

                case 3:
                    findNurse();
                    break;

                case 4:
                    updateNurse();
                    break;

                case 5:
                    deleteNurse();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // REGISTER NURSE
    // =========================================================

    private static void registerNurse() {

        System.out.println();

        System.out.println(
                "========== REGISTER NURSE =========="
        );

        System.out.println();

        System.out.println(
                "----- PERSONAL INFORMATION -----"
        );

        System.out.print(
                "First Name: "
        );

        String firstName =
                scanner.nextLine();

        System.out.print(
                "Last Name: "
        );

        String lastName =
                scanner.nextLine();

        System.out.print(
                "Gender (M/F): "
        );

        char gender =
                scanner.nextLine()
                        .charAt(0);

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        LocalDate dateOfBirth =
                LocalDate.parse(
                        scanner.nextLine()
                );

        System.out.print(
                "Phone: "
        );

        String phone =
                scanner.nextLine();

        System.out.print(
                "Email: "
        );

        String email =
                scanner.nextLine();

        System.out.print(
                "Street: "
        );

        String street =
                scanner.nextLine();

        System.out.print(
                "City: "
        );

        String city =
                scanner.nextLine();

        System.out.print(
                "Country: "
        );

        String country =
                scanner.nextLine();


        System.out.println();

        System.out.println(
                "----- STAFF INFORMATION -----"
        );

        System.out.print(
                "Employment Date (yyyy-MM-dd): "
        );

        LocalDate employmentDate =
                LocalDate.parse(
                        scanner.nextLine()
                );

        System.out.print(
                "Salary: "
        );

        double salary =
                Double.parseDouble(
                        scanner.nextLine()
                );


        System.out.println();

        System.out.println(
                "----- DEPARTMENT INFORMATION -----"
        );

        int departmentId =
                readInt(
                        "Department ID: "
                );

        System.out.print(
                "Department Name: "
        );

        String departmentName =
                scanner.nextLine();

        Department department =
                new Department();

        department.setId(
                departmentId
        );

        department.setName(
                departmentName
        );


        System.out.println();

        System.out.println(
                "----- NURSE INFORMATION -----"
        );

        System.out.print(
                "Nursing License: "
        );

        String nursingLicense =
                scanner.nextLine();

        System.out.print(
                "Qualification: "
        );

        String qualification =
                scanner.nextLine();


        Nurse nurse =
                new Nurse(
                        firstName,
                        lastName,
                        gender,
                        dateOfBirth,
                        phone,
                        email,
                        street,
                        city,
                        country,
                        0,
                        employmentDate,
                        salary,
                        department,
                        nursingLicense,
                        qualification
                );


        boolean success =
                nurseService.registerNurse(
                        nurse
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Nurse registered successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Failed to register nurse."
            );
        }
    }


    // =========================================================
    // VIEW ALL NURSES
    // =========================================================

    private static void viewAllNurses() {

        List<Nurse> nurses =
                nurseService.getAllNurses();

        nurseView.displayNurses(
                nurses
        );
    }


    // =========================================================
    // FIND NURSE
    // =========================================================

    private static void findNurse() {

        int staffId =
                readInt(
                        "Enter Nurse/Staff ID: "
                );

        Nurse nurse =
                nurseService.getNurseById(
                        staffId
                );

        nurseView.displayNurse(
                nurse
        );
    }


    // =========================================================
    // UPDATE NURSE
    // =========================================================

    private static void updateNurse() {

        int staffId =
                readInt(
                        "Enter Nurse/Staff ID to update: "
                );

        Nurse nurse =
                nurseService.getNurseById(
                        staffId
                );

        if (nurse == null) {

            System.out.println(
                    "Nurse not found."
            );

            return;
        }


        System.out.println();

        System.out.println(
                "Current nurse information:"
        );

        nurseView.displayNurse(
                nurse
        );


        System.out.println();

        System.out.println(
                "Enter new nurse information."
        );


        System.out.println();

        System.out.println(
                "----- PERSONAL INFORMATION -----"
        );

        System.out.print(
                "First Name: "
        );

        nurse.setFirstName(
                scanner.nextLine()
        );

        System.out.print(
                "Last Name: "
        );

        nurse.setLastName(
                scanner.nextLine()
        );

        System.out.print(
                "Gender (M/F): "
        );

        nurse.setGender(
                scanner.nextLine()
                        .charAt(0)
        );

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        nurse.setDateOfBirth(
                LocalDate.parse(
                        scanner.nextLine()
                )
        );

        System.out.print(
                "Phone: "
        );

        nurse.setPhone(
                scanner.nextLine()
        );

        System.out.print(
                "Email: "
        );

        nurse.setEmail(
                scanner.nextLine()
        );

        System.out.print(
                "Street: "
        );

        nurse.setStreet(
                scanner.nextLine()
        );

        System.out.print(
                "City: "
        );

        nurse.setCity(
                scanner.nextLine()
        );

        System.out.print(
                "Country: "
        );

        nurse.setCountry(
                scanner.nextLine()
        );


        System.out.println();

        System.out.println(
                "----- STAFF INFORMATION -----"
        );

        System.out.print(
                "Employment Date (yyyy-MM-dd): "
        );

        nurse.setEmploymentDate(
                LocalDate.parse(
                        scanner.nextLine()
                )
        );

        System.out.print(
                "Salary: "
        );

        nurse.setSalary(
                Double.parseDouble(
                        scanner.nextLine()
                )
        );


        System.out.println();

        System.out.println(
                "----- DEPARTMENT INFORMATION -----"
        );

        int departmentId =
                readInt(
                        "Department ID: "
                );

        System.out.print(
                "Department Name: "
        );

        String departmentName =
                scanner.nextLine();

        Department department =
                new Department();

        department.setId(
                departmentId
        );

        department.setName(
                departmentName
        );

        nurse.setDepartment(
                department
        );


        System.out.println();

        System.out.println(
                "----- NURSE INFORMATION -----"
        );

        System.out.print(
                "Nursing License: "
        );

        nurse.setNursingLicense(
                scanner.nextLine()
        );

        System.out.print(
                "Qualification: "
        );

        nurse.setQualification(
                scanner.nextLine()
        );


        boolean success =
                nurseService.updateNurse(
                        nurse
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Nurse updated successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Nurse update failed."
            );
        }
    }


    // =========================================================
    // DELETE NURSE
    // =========================================================

    private static void deleteNurse() {

        int staffId =
                readInt(
                        "Enter Nurse/Staff ID to delete: "
                );

        Nurse nurse =
                nurseService.getNurseById(
                        staffId
                );

        if (nurse == null) {

            System.out.println(
                    "Nurse not found."
            );

            return;
        }

        nurseView.displayNurse(
                nurse
        );

        System.out.print(
                "Are you sure you want to delete this nurse? (Y/N): "
        );

        String answer =
                scanner.nextLine();

        if (!answer.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Delete cancelled."
            );

            return;
        }

        boolean success =
                nurseService.deleteNurse(
                        staffId
                );

        if (success) {

            System.out.println(
                    "Nurse deleted successfully."
            );

        } else {

            System.out.println(
                    "Nurse deletion failed."
            );
        }
    }
    
    // =========================================================
// LABORATORY TECHNICIAN MENU
// =========================================================

private static void laboratoryTechnicianMenu() {

    while (true) {

        System.out.println();

        System.out.println(
                "========================================"
        );

        System.out.println(
                "     LABORATORY TECHNICIAN MANAGEMENT"
        );

        System.out.println(
                "========================================"
        );

        System.out.println(
                "1. Register Laboratory Technician"
        );

        System.out.println(
                "2. View All Laboratory Technicians"
        );

        System.out.println(
                "3. Find Laboratory Technician"
        );

        System.out.println(
                "4. Update Laboratory Technician"
        );

        System.out.println(
                "5. Delete Laboratory Technician"
        );

        System.out.println(
                "0. Back"
        );

        System.out.println(
                "========================================"
        );

        int choice =
                readInt(
                        "Enter your choice: "
                );

        switch (choice) {

            case 1:
                registerLaboratoryTechnician();
                break;

            case 2:
                viewAllLaboratoryTechnicians();
                break;

            case 3:
                findLaboratoryTechnician();
                break;

            case 4:
                updateLaboratoryTechnician();
                break;

            case 5:
                deleteLaboratoryTechnician();
                break;

            case 0:
                return;

            default:
                System.out.println(
                        "Invalid choice."
                );
        }
    }
}


// =========================================================
// REGISTER LABORATORY TECHNICIAN
// =========================================================

private static void registerLaboratoryTechnician() {

    System.out.println();

    System.out.println(
            "========== REGISTER LABORATORY TECHNICIAN =========="
    );

    System.out.print(
            "First Name: "
    );

    String firstName =
            scanner.nextLine();

    System.out.print(
            "Last Name: "
    );

    String lastName =
            scanner.nextLine();

    System.out.print(
            "Gender (M/F): "
    );

    char gender =
            scanner.nextLine()
                    .charAt(0);

    System.out.print(
            "Date of Birth (yyyy-MM-dd): "
    );

    LocalDate dateOfBirth =
            LocalDate.parse(
                    scanner.nextLine()
            );

    System.out.print(
            "Phone: "
    );

    String phone =
            scanner.nextLine();

    System.out.print(
            "Email: "
    );

    String email =
            scanner.nextLine();

    System.out.print(
            "Street: "
    );

    String street =
            scanner.nextLine();

    System.out.print(
            "City: "
    );

    String city =
            scanner.nextLine();

    System.out.print(
            "Country: "
    );

    String country =
            scanner.nextLine();


    System.out.print(
            "Employment Date (yyyy-MM-dd): "
    );

    LocalDate employmentDate =
            LocalDate.parse(
                    scanner.nextLine()
            );

    System.out.print(
            "Salary: "
    );

    double salary =
            Double.parseDouble(
                    scanner.nextLine()
            );


    int departmentId =
            readInt(
                    "Department ID: "
            );

    System.out.print(
            "Department Name: "
    );

    String departmentName =
            scanner.nextLine();

    Department department =
            new Department();

    department.setId(
            departmentId
    );

    department.setName(
            departmentName
    );


    System.out.print(
            "Qualification: "
    );

    String qualification =
            scanner.nextLine();

    System.out.print(
            "License Number: "
    );

    String licenseNumber =
            scanner.nextLine();


    LaboratoryTechnician technician =
            new LaboratoryTechnician(
                    firstName,
                    lastName,
                    gender,
                    dateOfBirth,
                    phone,
                    email,
                    street,
                    city,
                    country,
                    0,
                    employmentDate,
                    salary,
                    department,
                    qualification,
                    licenseNumber
            );


    boolean success =
            laboratoryTechnicianService.registerLaboratoryTechnician(
                    technician
            );

    if (success) {

        System.out.println();

        System.out.println(
                "Laboratory technician registered successfully."
        );

    } else {

        System.out.println();

        System.out.println(
                "Failed to register laboratory technician."
        );
    }
}


// =========================================================
// VIEW ALL LABORATORY TECHNICIANS
// =========================================================

private static void viewAllLaboratoryTechnicians() {

    List<LaboratoryTechnician> technicians =
            laboratoryTechnicianService.getAllLaboratoryTechnicians();

    laboratoryTechnicianView.displayLaboratoryTechnicians(
            technicians
    );
}


// =========================================================
// FIND LABORATORY TECHNICIAN
// =========================================================

private static void findLaboratoryTechnician() {

    int id =
            readInt(
                    "Enter Laboratory Technician/Staff ID: "
            );

    LaboratoryTechnician technician =
            laboratoryTechnicianService.getLaboratoryTechnicianById(
                    id
            );

    laboratoryTechnicianView.displayLaboratoryTechnician(
            technician
    );
}


// =========================================================
// UPDATE LABORATORY TECHNICIAN
// =========================================================

private static void updateLaboratoryTechnician() {

    int id =
            readInt(
                    "Enter Laboratory Technician/Staff ID to update: "
            );

    LaboratoryTechnician technician =
            laboratoryTechnicianService.getLaboratoryTechnicianById(
                    id
            );

    if (technician == null) {

        System.out.println(
                "Laboratory technician not found."
        );

        return;
    }

    System.out.println();

    laboratoryTechnicianView.displayLaboratoryTechnician(
            technician
    );

    System.out.println();

    System.out.println(
            "Enter new laboratory technician information."
    );


    System.out.print(
            "First Name: "
    );

    technician.setFirstName(
            scanner.nextLine()
    );

    System.out.print(
            "Last Name: "
    );

    technician.setLastName(
            scanner.nextLine()
    );

    System.out.print(
            "Gender (M/F): "
    );

    technician.setGender(
            scanner.nextLine()
                    .charAt(0)
    );

    System.out.print(
            "Date of Birth (yyyy-MM-dd): "
    );

    technician.setDateOfBirth(
            LocalDate.parse(
                    scanner.nextLine()
            )
    );

    System.out.print(
            "Phone: "
    );

    technician.setPhone(
            scanner.nextLine()
    );

    System.out.print(
            "Email: "
    );

    technician.setEmail(
            scanner.nextLine()
    );

    System.out.print(
            "Street: "
    );

    technician.setStreet(
            scanner.nextLine()
    );

    System.out.print(
            "City: "
    );

    technician.setCity(
            scanner.nextLine()
    );

    System.out.print(
            "Country: "
    );

    technician.setCountry(
            scanner.nextLine()
    );


    System.out.print(
            "Employment Date (yyyy-MM-dd): "
    );

    technician.setEmploymentDate(
            LocalDate.parse(
                    scanner.nextLine()
            )
    );

    System.out.print(
            "Salary: "
    );

    technician.setSalary(
            Double.parseDouble(
                    scanner.nextLine()
            )
    );


    int departmentId =
            readInt(
                    "Department ID: "
            );

    System.out.print(
            "Department Name: "
    );

    String departmentName =
            scanner.nextLine();

    Department department =
            new Department();

    department.setId(
            departmentId
    );

    department.setName(
            departmentName
    );

    technician.setDepartment(
            department
    );


    System.out.print(
            "Qualification: "
    );

    technician.setQualification(
            scanner.nextLine()
    );

    System.out.print(
            "License Number: "
    );

    technician.setLicenseNumber(
            scanner.nextLine()
    );


    boolean success =
            laboratoryTechnicianService.updateLaboratoryTechnician(
                    technician
            );

    if (success) {

        System.out.println();

        System.out.println(
                "Laboratory technician updated successfully."
        );

    } else {

        System.out.println();

        System.out.println(
                "Laboratory technician update failed."
        );
    }
}


// =========================================================
// DELETE LABORATORY TECHNICIAN
// =========================================================

private static void deleteLaboratoryTechnician() {

    int id =
            readInt(
                    "Enter Laboratory Technician/Staff ID to delete: "
            );

    LaboratoryTechnician technician =
            laboratoryTechnicianService.getLaboratoryTechnicianById(
                    id
            );

    if (technician == null) {

        System.out.println(
                "Laboratory technician not found."
        );

        return;
    }

    laboratoryTechnicianView.displayLaboratoryTechnician(
            technician
    );

    System.out.print(
            "Are you sure you want to delete this laboratory technician? (Y/N): "
    );

    String answer =
            scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {

        System.out.println(
                "Delete cancelled."
        );

        return;
    }

    boolean success =
            laboratoryTechnicianService.deleteLaboratoryTechnician(
                    id
            );

    if (success) {

        System.out.println(
                "Laboratory technician deleted successfully."
        );

    } else {

        System.out.println(
                "Laboratory technician deletion failed."
        );
    }
}


// =========================================================
// PHARMACIST MENU
// =========================================================

private static void pharmacistMenu() {

    while (true) {

        System.out.println();

        System.out.println(
                "========================================"
        );

        System.out.println(
                "           PHARMACIST MANAGEMENT"
        );

        System.out.println(
                "========================================"
        );

        System.out.println(
                "1. Register Pharmacist"
        );

        System.out.println(
                "2. View All Pharmacists"
        );

        System.out.println(
                "3. Find Pharmacist"
        );

        System.out.println(
                "4. Update Pharmacist"
        );

        System.out.println(
                "5. Delete Pharmacist"
        );

        System.out.println(
                "0. Back"
        );

        System.out.println(
                "========================================"
        );

        int choice =
                readInt(
                        "Enter your choice: "
                );

        switch (choice) {

            case 1:
                registerPharmacist();
                break;

            case 2:
                viewAllPharmacists();
                break;

            case 3:
                findPharmacist();
                break;

            case 4:
                updatePharmacist();
                break;

            case 5:
                deletePharmacist();
                break;

            case 0:
                return;

            default:
                System.out.println(
                        "Invalid choice."
                );
        }
    }
}


// =========================================================
// REGISTER PHARMACIST
// =========================================================

private static void registerPharmacist() {

    System.out.println();

    System.out.println(
            "========== REGISTER PHARMACIST =========="
    );

    System.out.print(
            "First Name: "
    );

    String firstName =
            scanner.nextLine();

    System.out.print(
            "Last Name: "
    );

    String lastName =
            scanner.nextLine();

    System.out.print(
            "Gender (M/F): "
    );

    char gender =
            scanner.nextLine()
                    .charAt(0);

    System.out.print(
            "Date of Birth (yyyy-MM-dd): "
    );

    LocalDate dateOfBirth =
            LocalDate.parse(
                    scanner.nextLine()
            );

    System.out.print(
            "Phone: "
    );

    String phone =
            scanner.nextLine();

    System.out.print(
            "Email: "
    );

    String email =
            scanner.nextLine();

    System.out.print(
            "Street: "
    );

    String street =
            scanner.nextLine();

    System.out.print(
            "City: "
    );

    String city =
            scanner.nextLine();

    System.out.print(
            "Country: "
    );

    String country =
            scanner.nextLine();


    System.out.print(
            "Employment Date (yyyy-MM-dd): "
    );

    LocalDate employmentDate =
            LocalDate.parse(
                    scanner.nextLine()
            );

    System.out.print(
            "Salary: "
    );

    double salary =
            Double.parseDouble(
                    scanner.nextLine()
            );


    int departmentId =
            readInt(
                    "Department ID: "
            );

    System.out.print(
            "Department Name: "
    );

    String departmentName =
            scanner.nextLine();

    Department department =
            new Department();

    department.setId(
            departmentId
    );

    department.setName(
            departmentName
    );


    System.out.print(
            "Qualification: "
    );

    String qualification =
            scanner.nextLine();

    System.out.print(
            "License Number: "
    );

    String licenseNumber =
            scanner.nextLine();


    Pharmacist pharmacist =
            new Pharmacist(
                    firstName,
                    lastName,
                    gender,
                    dateOfBirth,
                    phone,
                    email,
                    street,
                    city,
                    country,
                    0,
                    employmentDate,
                    salary,
                    department,
                    qualification,
                    licenseNumber
            );


    boolean success =
            pharmacistService.registerPharmacist(
                    pharmacist
            );

    if (success) {

        System.out.println();

        System.out.println(
                "Pharmacist registered successfully."
        );

    } else {

        System.out.println();

        System.out.println(
                "Failed to register pharmacist."
        );
    }
}


// =========================================================
// VIEW ALL PHARMACISTS
// =========================================================

private static void viewAllPharmacists() {

    List<Pharmacist> pharmacists =
            pharmacistService.getAllPharmacists();

    pharmacistView.displayPharmacists(
            pharmacists
    );
}


// =========================================================
// FIND PHARMACIST
// =========================================================

private static void findPharmacist() {

    int id =
            readInt(
                    "Enter Pharmacist/Staff ID: "
            );

    Pharmacist pharmacist =
            pharmacistService.getPharmacistById(
                    id
            );

    pharmacistView.displayPharmacist(
            pharmacist
    );
}


// =========================================================
// UPDATE PHARMACIST
// =========================================================

private static void updatePharmacist() {

    int id =
            readInt(
                    "Enter Pharmacist/Staff ID to update: "
            );

    Pharmacist pharmacist =
            pharmacistService.getPharmacistById(
                    id
            );

    if (pharmacist == null) {

        System.out.println(
                "Pharmacist not found."
        );

        return;
    }

    System.out.println();

    pharmacistView.displayPharmacist(
            pharmacist
    );

    System.out.println();

    System.out.println(
            "Enter new pharmacist information."
    );


    System.out.print(
            "First Name: "
    );

    pharmacist.setFirstName(
            scanner.nextLine()
    );

    System.out.print(
            "Last Name: "
    );

    pharmacist.setLastName(
            scanner.nextLine()
    );

    System.out.print(
            "Gender (M/F): "
    );

    pharmacist.setGender(
            scanner.nextLine()
                    .charAt(0)
    );

    System.out.print(
            "Date of Birth (yyyy-MM-dd): "
    );

    pharmacist.setDateOfBirth(
            LocalDate.parse(
                    scanner.nextLine()
            )
    );

    System.out.print(
            "Phone: "
    );

    pharmacist.setPhone(
            scanner.nextLine()
    );

    System.out.print(
            "Email: "
    );

    pharmacist.setEmail(
            scanner.nextLine()
    );

    System.out.print(
            "Street: "
    );

    pharmacist.setStreet(
            scanner.nextLine()
    );

    System.out.print(
            "City: "
    );

    pharmacist.setCity(
            scanner.nextLine()
    );

    System.out.print(
            "Country: "
    );

    pharmacist.setCountry(
            scanner.nextLine()
    );


    System.out.print(
            "Employment Date (yyyy-MM-dd): "
    );

    pharmacist.setEmploymentDate(
            LocalDate.parse(
                    scanner.nextLine()
            )
    );

    System.out.print(
            "Salary: "
    );

    pharmacist.setSalary(
            Double.parseDouble(
                    scanner.nextLine()
            )
    );


    int departmentId =
            readInt(
                    "Department ID: "
            );

    System.out.print(
            "Department Name: "
    );

    String departmentName =
            scanner.nextLine();

    Department department =
            new Department();

    department.setId(
            departmentId
    );

    department.setName(
            departmentName
    );

    pharmacist.setDepartment(
            department
    );


    System.out.print(
            "Qualification: "
    );

    pharmacist.setQualification(
            scanner.nextLine()
    );

    System.out.print(
            "License Number: "
    );

    pharmacist.setLicenseNumber(
            scanner.nextLine()
    );


    boolean success =
            pharmacistService.updatePharmacist(
                    pharmacist
            );

    if (success) {

        System.out.println();

        System.out.println(
                "Pharmacist updated successfully."
        );

    } else {

        System.out.println();

        System.out.println(
                "Pharmacist update failed."
        );
    }
}


// =========================================================
// DELETE PHARMACIST
// =========================================================

private static void deletePharmacist() {

    int id =
            readInt(
                    "Enter Pharmacist/Staff ID to delete: "
            );

    Pharmacist pharmacist =
            pharmacistService.getPharmacistById(
                    id
            );

    if (pharmacist == null) {

        System.out.println(
                "Pharmacist not found."
        );

        return;
    }

    pharmacistView.displayPharmacist(
            pharmacist
    );

    System.out.print(
            "Are you sure you want to delete this pharmacist? (Y/N): "
    );

    String answer =
            scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {

        System.out.println(
                "Delete cancelled."
        );

        return;
    }

    boolean success =
            pharmacistService.deletePharmacist(
                    id
            );

    if (success) {

        System.out.println(
                "Pharmacist deleted successfully."
        );

    } else {

        System.out.println(
                "Pharmacist deletion failed."
        );
    }
}

    // =========================================================
    // SELECT ROLE
    // =========================================================

    private static StaffRole selectRole() {

    System.out.println();
    System.out.println("Select Role:");
    System.out.println("1. Staff (general)");
    System.out.println("2. Doctor");
    System.out.println("3. Nurse");
    System.out.println("4. Pharmacist");
    System.out.println("5. Laboratory Technician");

    int choice = readInt("Select role: ");

    switch (choice) {

        case 1:
            return StaffRole.STAFF;

        case 2:
            return StaffRole.DOCTOR;

        case 3:
            return StaffRole.NURSE;

        case 4:
            return StaffRole.PHARMACIST;

        case 5:
            return StaffRole.LABORATORY_TECHNICIAN;

        default:
            System.out.println("Invalid role.");
            return null;
    }
}
    
    // =========================================================
    // SELECT STAFF LINK (VERIFIED)
    // =========================================================

    private static int selectStaffLink(StaffRole role) {

    if (role == StaffRole.STAFF) {

        System.out.println("General Staff role - no specific staff record to link.");

        return 0;
    }

    int staffId =
            readInt("Enter Staff ID to link this account to: ");

    String name = null;

    switch (role) {

        case DOCTOR:

            Doctor doctor =
                    doctorService.getDoctorById(staffId);

            if (doctor != null) {
                name = "Dr. " + doctor.getFirstName() + " " + doctor.getLastName();
            }

            break;

        case NURSE:

            Nurse nurse =
                    nurseService.getNurseById(staffId);

            if (nurse != null) {
                name = nurse.getFirstName() + " " + nurse.getLastName();
            }

            break;

        case PHARMACIST:

            Pharmacist pharmacist =
                    pharmacistService.getPharmacistById(staffId);

            if (pharmacist != null) {
                name = pharmacist.getFirstName() + " " + pharmacist.getLastName();
            }

            break;

        case LABORATORY_TECHNICIAN:

            LaboratoryTechnician technician =
                    laboratoryTechnicianService.getLaboratoryTechnicianById(staffId);

            if (technician != null) {
                name = technician.getFirstName() + " " + technician.getLastName();
            }

            break;

        default:
            break;
    }

    if (name == null) {

        System.out.println("No " + role + " found with Staff ID " + staffId + ".");
        System.out.println("Continuing without a staff link.");

        return 0;
    }

    System.out.println();
    System.out.println("Found: " + name + " (" + role + ")");

    System.out.print("Link this account to " + name + "? (Y/N): ");

    String answer = scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {

        System.out.println("Continuing without a staff link.");

        return 0;
    }

    return staffId;
}
    

    // =========================================================
    // VIEW ALL STAFF
    // =========================================================

    private static void viewAllStaffMenu() {
        System.out.println("View All Staff - connect StaffService Here");
    }
    
    // =========================================================
    // VIEW STAFF BY DEPARTMENT
    // =========================================================
    

    
    // =========================================================
    // USER ACCOUNT MENU
    // =========================================================

private static void userMenu() {

    while (true) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("         USER ACCOUNT MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. Create User");
        System.out.println("2. View All Users");
        System.out.println("3. Find User");
        System.out.println("4. Update User");
        System.out.println("5. Deactivate User");
        System.out.println("6. Activate User");
        System.out.println("7. Reset Password");
        System.out.println("0. Back");
        System.out.println("========================================");

        int choice = readInt("Enter your choice: ");

        switch (choice) {

            case 1:
                registerUser();
                break;

            case 2:
                viewAllUsers();
                break;

            case 3:
                findUser();
                break;

            case 4:
                updateUser();
                break;

            case 5:
                deactivateUser();
                break;

            case 6:
                activateUser();
                break;

            case 7:
                resetUserPassword();
                break;

            case 0:
                return;

            default:
                System.out.println("Invalid choice.");
        }
    }
}


// =========================================================
// CREATE USER
// =========================================================

private static void registerUser() {

    System.out.println();
    System.out.println("========== CREATE USER =========="); 

    System.out.print("Username: ");
    String username = scanner.nextLine();

    System.out.print("Password: ");
    String password = scanner.nextLine();

    StaffRole role = selectRole();

    if (role == null) {
        return;
    }

    int staffID = selectStaffLink(role);

    User user = new User(0, username, password, role, null, true);
    user.setStaffID(staffID);

    boolean success = userService.createUser(user);

    if (success) {

        System.out.println();
        System.out.println("User created successfully.");
        System.out.println("User ID: " + user.getId());

    } else {

        System.out.println();
        System.out.println("Failed to create user.");
    }
}


// =========================================================
// VIEW ALL USERS
// =========================================================

private static void viewAllUsers() {

    List<User> users = userService.getAllUsers();

    userView.displayUsers(users);
}


// =========================================================
// FIND USER
// =========================================================

private static void findUser() {

    int id = readInt("Enter User ID: ");

    User user = userService.getUserById(id);

    userView.displayUser(user);
}


// =========================================================
// UPDATE USER
// =========================================================

private static void updateUser() {

    int id = readInt("Enter User ID to update: ");

    User user = userService.getUserById(id);

    if (user == null) {

        System.out.println("User not found.");

        return;
    }

    System.out.println();

    userView.displayUser(user);

    System.out.println();
    System.out.println("Enter new user information.");

    System.out.print("Username: ");
    user.setUsername(scanner.nextLine());

    StaffRole role = selectRole();

    if (role == null) {
        return;
    }

    user.setRole(role);

    int staffID = selectStaffLink(role);

    user.setStaffID(staffID);

    boolean success = userService.updateUser(user);

    if (success) {

        System.out.println();
        System.out.println("User updated successfully.");

    } else {

        System.out.println();
        System.out.println("User update failed.");
    }
}


// =========================================================
// DEACTIVATE USER
// =========================================================

private static void deactivateUser() {

    int id = readInt("Enter User ID to deactivate: ");

    User user = userService.getUserById(id);

    if (user == null) {

        System.out.println("User not found.");

        return;
    }

    userView.displayUser(user);

    System.out.print("Are you sure you want to deactivate this account? (Y/N): ");

    String answer = scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {

        System.out.println("Deactivation cancelled.");

        return;
    }

    boolean success = userService.deactivateUser(id);

    if (success) {

        System.out.println("User deactivated successfully.");

    } else {

        System.out.println("Failed to deactivate user.");
    }
}


// =========================================================
// ACTIVATE USER
// =========================================================

private static void activateUser() {

    int id = readInt("Enter User ID to activate: ");

    User user = userService.getUserById(id);

    if (user == null) {

        System.out.println("User not found.");

        return;
    }

    userView.displayUser(user);

    System.out.print("Are you sure you want to activate this account? (Y/N): ");

    String answer = scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {

        System.out.println("Activation cancelled.");

        return;
    }

    boolean success = userService.activateUser(id);

    if (success) {

        System.out.println("User activated successfully.");

    } else {

        System.out.println("Failed to activate user.");
    }
}


// =========================================================
// RESET PASSWORD
// =========================================================

private static void resetUserPassword() {

    int id = readInt("Enter User ID: ");

    User user = userService.getUserById(id);

    if (user == null) {

        System.out.println("User not found.");

        return;
    }

    System.out.println("Resetting password for: " + user.getUsername());

    System.out.print("New Password: ");
    String newPassword = scanner.nextLine();

    boolean success = userService.resetPassword(id, newPassword);

    if (success) {

        System.out.println("Password reset successfully.");

    } else {

        System.out.println("Failed to reset password.");
    }
}


        // =========================================================
    // APPOINTMENT MENU
    // =========================================================

    private static void appointmentMenu() {

        while (true) {

            System.out.println();

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "        APPOINTMENT MANAGEMENT"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Create Appointment"
            );

            System.out.println(
                    "2. View All Appointments"
            );

            System.out.println(
                    "3. Find Appointment"
            );

            System.out.println(
                    "4. Update Appointment"
            );

            System.out.println(
                    "5. Cancel Appointment"
            );

            System.out.println(
                    "6. Delete Appointment"
            );

            System.out.println(
                    "7. View Patient Appointments"
            );

            System.out.println(
                    "8. View Doctor Appointments"
            );

            System.out.println(
                    "9. Today's Appointments"
            );

            System.out.println(
                    "10. Upcoming Appointments"
            );


            System.out.println(
                    "0. Back"
            );

            System.out.println(
                    "========================================"
            );

            int choice =
                    readInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    createAppointment();
                    break;

                case 2:
                    viewAllAppointments();
                    break;

                case 3:
                    findAppointment();
                    break;

                case 4:
                    updateAppointment();
                    break;

                case 5:
                    cancelAppointment();
                    break;

                case 6:
                    deleteAppointment();
                    break;

                case 7:
                    viewPatientAppointments();
                    break;

                case 8:
                    viewDoctorAppointments();
                    break;

                case 9:
                    viewTodaysAppointments();
                    break;

                case 10:
                    viewUpcomingAppointments();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // CREATE APPOINTMENT
    // =========================================================

    private static void createAppointment() {

        System.out.println();

        System.out.println(
                "========== CREATE APPOINTMENT =========="
        );


        // =====================================================
        // PATIENT
        // =====================================================

        int patientId =
                readInt(
                        "Enter Patient ID: "
                );

        Patient patient =
                patientService.getPatientById(
                        patientId
                );

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Patient: "
                        + patient.getFirstName()
                        + " "
                        + patient.getLastName()
        );


        // =====================================================
        // DOCTOR
        // =====================================================

        int doctorId =
                readInt(
                        "Enter Doctor/Staff ID: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        doctorId
                );

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Doctor: Dr. "
                        + doctor.getFirstName()
                        + " "
                        + doctor.getLastName()
        );

        System.out.println(
                "Specialization: "
                        + doctor.getSpecialization()
        );


        // =====================================================
        // APPOINTMENT DATE
        // =====================================================

        System.out.println();

        System.out.println(
                "Date format: yyyy-MM-dd HH:mm"
        );

        System.out.print(
                "Appointment Date: "
        );

        String dateInput =
                scanner.nextLine();

        LocalDateTime appointmentDate;

        try {

            appointmentDate =
                    LocalDateTime.parse(
                            dateInput,
                            DATE_TIME_FORMATTER
                    );

        } catch (Exception e) {

            System.out.println(
                    "Invalid date/time format."
            );

            System.out.println(
                    "Please use: yyyy-MM-dd HH:mm"
            );

            return;
        }


        // =====================================================
        // REASON
        // =====================================================

        System.out.print(
                "Reason for Appointment: "
        );

        String reason =
                scanner.nextLine();


        // =====================================================
        // STATUS
        // =====================================================

        String status =
                selectAppointmentStatus();

        if (status == null) {
            return;
        }


        // =====================================================
        // NOTES
        // =====================================================

        System.out.print(
                "Notes: "
        );

        String notes =
                scanner.nextLine();


        // =====================================================
        // CREATE OBJECT
        // =====================================================

        Appointment appointment =
                new Appointment();

        // ID is generated by SQL Server.
        // Do not set the ID manually.

        appointment.setPatient(
                patient
        );

        appointment.setDoctor(
                doctor
        );

        appointment.setAppointmentDate(
                appointmentDate
        );

        appointment.setReason(
                reason
        );

        appointment.setStatus(
                status
        );

        appointment.setNotes(
                notes
        );


        // =====================================================
        // SAVE
        // =====================================================

        boolean success =
                appointmentService.addAppointment(
                        appointment
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Appointment created successfully."
            );

            if (appointment.getId() > 0) {

                System.out.println(
                        "Appointment ID: "
                                + appointment.getId()
                );
            }

        } else {

            System.out.println();

            System.out.println(
                    "Failed to create appointment."
            );
        }
    }


    // =========================================================
    // SELECT APPOINTMENT STATUS
    // =========================================================

    private static String selectAppointmentStatus() {

        System.out.println();

        System.out.println(
                "Appointment Status"
        );

        System.out.println(
                "1. Scheduled"
        );

        System.out.println(
                "2. Completed"
        );

        System.out.println(
                "3. Cancelled"
        );

        System.out.println(
                "4. Pending"
        );

        int choice =
                readInt(
                        "Select status: "
                );

        switch (choice) {

            case 1:
                return "Scheduled";

            case 2:
                return "Completed";

            case 3:
                return "Cancelled";

            case 4:
                return "Pending";

            default:

                System.out.println(
                        "Invalid status."
                );

                return null;
        }
    }


    // =========================================================
    // VIEW ALL APPOINTMENTS
    // =========================================================

    private static void viewAllAppointments() {

        List<Appointment> appointments =
                appointmentService.getAllAppointments();

        appointmentView.displayAppointments(
                appointments
        );
    }


    // =========================================================
    // FIND APPOINTMENT
    // =========================================================

    private static void findAppointment() {

        int appointmentId =
                readInt(
                        "Enter Appointment ID: "
                );

        Appointment appointment =
                appointmentService.getAppointmentById(
                        appointmentId
                );

        appointmentView.displayAppointment(
                appointment
        );
    }


    // =========================================================
    // UPDATE APPOINTMENT
    // =========================================================

    private static void updateAppointment() {

        int appointmentId =
                readInt(
                        "Enter Appointment ID to update: "
                );

        Appointment appointment =
                appointmentService.getAppointmentById(
                        appointmentId
                );

        if (appointment == null) {

            System.out.println(
                    "Appointment not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Current appointment information:"
        );

        appointmentView.displayAppointment(
                appointment
        );


        // =====================================================
        // PATIENT
        // =====================================================

        int patientId =
                readInt(
                        "Enter new Patient ID: "
                );

        Patient patient =
                patientService.getPatientById(
                        patientId
                );

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        appointment.setPatient(
                patient
        );


        // =====================================================
        // DOCTOR
        // =====================================================

        int doctorId =
                readInt(
                        "Enter new Doctor/Staff ID: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        doctorId
                );

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        appointment.setDoctor(
                doctor
        );


        // =====================================================
        // DATE
        // =====================================================

        System.out.println();

        System.out.println(
                "Date format: yyyy-MM-dd HH:mm"
        );

        System.out.print(
                "Appointment Date: "
        );

        String dateInput =
                scanner.nextLine();

        try {

            appointment.setAppointmentDate(
                    LocalDateTime.parse(
                            dateInput,
                            DATE_TIME_FORMATTER
                    )
            );

        } catch (Exception e) {

            System.out.println(
                    "Invalid date/time format."
            );

            System.out.println(
                    "Please use: yyyy-MM-dd HH:mm"
            );

            return;
        }


        // =====================================================
        // REASON
        // =====================================================

        System.out.print(
                "Reason: "
        );

        appointment.setReason(
                scanner.nextLine()
        );


        // =====================================================
        // STATUS
        // =====================================================

        String status =
                selectAppointmentStatus();

        if (status == null) {
            return;
        }

        appointment.setStatus(
                status
        );


        // =====================================================
        // NOTES
        // =====================================================

        System.out.print(
                "Notes: "
        );

        appointment.setNotes(
                scanner.nextLine()
        );


        // =====================================================
        // UPDATE
        // =====================================================

        boolean success =
                appointmentService.updateAppointment(
                        appointment
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Appointment updated successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Appointment update failed."
            );
        }
    }


    // =========================================================
    // CANCEL APPOINTMENT
    // =========================================================

    private static void cancelAppointment() {

        int appointmentId =
                readInt(
                        "Enter Appointment ID to cancel: "
                );

        Appointment appointment =
                appointmentService.getAppointmentById(
                        appointmentId
                );

        if (appointment == null) {

            System.out.println(
                    "Appointment not found."
            );

            return;
        }

        appointmentView.displayAppointment(
                appointment
        );

        System.out.print(
                "Are you sure you want to cancel this appointment? (Y/N): "
        );

        String answer =
                scanner.nextLine();

        if (!answer.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Cancel aborted."
            );

            return;
        }

        boolean success =
                appointmentService.cancelAppointment(
                        appointmentId
                );

        if (success) {

            System.out.println(
                    "Appointment cancelled successfully."
            );

        } else {

            System.out.println(
                    "Failed to cancel appointment."
            );
        }
    }


    // =========================================================
    // DELETE APPOINTMENT
    // =========================================================

    private static void deleteAppointment() {

        int appointmentId =
                readInt(
                        "Enter Appointment ID to delete: "
                );

        Appointment appointment =
                appointmentService.getAppointmentById(
                        appointmentId
                );

        if (appointment == null) {

            System.out.println(
                    "Appointment not found."
            );

            return;
        }

        appointmentView.displayAppointment(
                appointment
        );

        System.out.print(
                "Are you sure you want to delete this appointment? (Y/N): "
        );

        String answer =
                scanner.nextLine();

        if (!answer.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Delete cancelled."
            );

            return;
        }

        boolean success =
                appointmentService.deleteAppointment(
                        appointmentId
                );

        if (success) {

            System.out.println(
                    "Appointment deleted successfully."
            );

        } else {

            System.out.println(
                    "Appointment deletion failed."
            );
        }
    }


    // =========================================================
    // VIEW PATIENT APPOINTMENTS
    // =========================================================

    private static void viewPatientAppointments() {

        int patientId =
                readInt(
                        "Enter Patient ID: "
                );

        Patient patient =
                patientService.getPatientById(
                        patientId
                );

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Appointments for "
                        + patient.getFirstName()
                        + " "
                        + patient.getLastName()
        );

        List<Appointment> appointments =
                appointmentService.getAppointmentsByPatient(
                        patientId
                );

        appointmentView.displayAppointments(
                appointments
        );
    }


    // =========================================================
    // VIEW DOCTOR APPOINTMENTS
    // =========================================================

    private static void viewDoctorAppointments() {

        int doctorId =
                readInt(
                        "Enter Doctor/Staff ID: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        doctorId
                );

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Appointments for Dr. "
                        + doctor.getFirstName()
                        + " "
                        + doctor.getLastName()
        );

        List<Appointment> appointments =
                appointmentService.getAppointmentsByDoctor(
                        doctorId
                );

        appointmentView.displayAppointments(
                appointments
        );
    }


    // =========================================================
    // VIEW TODAY'S APPOINTMENTS
    // =========================================================

    private static void viewTodaysAppointments() {

        List<Appointment> appointments =
                appointmentService.getTodaysAppointments();

        System.out.println();

        System.out.println(
                "Today's Appointments:"
        );

        appointmentView.displayAppointments(
                appointments
        );
    }


    // =========================================================
    // VIEW UPCOMING APPOINTMENTS
    // =========================================================

    private static void viewUpcomingAppointments() {

        List<Appointment> appointments =
                appointmentService.getUpcomingAppointments();

        System.out.println();

        System.out.println(
                "Upcoming Appointments:"
        );

        appointmentView.displayAppointments(
                appointments
        );
    }


    // =========================================================
    // READ INTEGER
    // =========================================================

    private static int readInt(
            String message
    ) {

        while (true) {

            try {

                System.out.print(
                        message
                );

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
    private static void admissionMenu() {

    while (true) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("      ADMISSION & BED MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. Admit Patient");
        System.out.println("2. View All Admissions");
        System.out.println("3. Find Admission");
        System.out.println("4. Update Admission");
        System.out.println("5. Discharge Patient");
        System.out.println("6. View Active Admissions");
        System.out.println("7. Ward Management");
        System.out.println("8. Room Management");
        System.out.println("9. Bed Management");
        System.out.println("10. View Available Beds");
        System.out.println("11. View Occupied Beds");
        System.out.println("12. Nurse Assignment");
        System.out.println("0. Back");
        System.out.println("========================================");

        int choice = readInt("Enter your choice: ");

        switch (choice) {

            case 1: admitPatient(); 
                    break;
            case 2: viewAllAdmissions(); 
            break;
            case 3: findAdmission(); 
            break;
            case 4: updateAdmission();
            break;
            case 5: dischargePatient();
            break;
            case 6: viewActiveAdmissions();
            break;
            case 7: wardMenu(); break;
            case 8: roomMenu(); break;
            case 9: bedMenu(); break;
            case 10: viewAvailableBeds(); break;
            case 11: viewOccupiedBeds(); break;
            case 12: nurseAssignmentMenu(); break;
            case 0: return;

            default:
                System.out.println("Invalid choice.");
        }
    }
}
    private static void wardMenu() {

    while (true) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("           WARD MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. Create Ward");
        System.out.println("2. View All Wards");
        System.out.println("3. Find Ward");
        System.out.println("4. Update Ward");
        System.out.println("5. Delete Ward");
        System.out.println("0. Back");
        System.out.println("========================================");

        int choice = readInt("Enter your choice: ");

        switch (choice) {
            case 1: createWard(); break;
            case 2: viewAllWards(); break;
            case 3: findWard(); break;
            case 4: updateWard(); break;
            case 5: deleteWard(); break;
            case 0: return;
            default: System.out.println("Invalid choice.");
        }
    }
}

private static void createWard() {

    System.out.println();
    System.out.println("========== CREATE WARD ==========");

    System.out.print("Name: ");
    String name = scanner.nextLine();

    System.out.print("Ward Type: ");
    String wardType = scanner.nextLine();

    int capacity = readInt("Capacity: ");

    Ward ward = new Ward();
    ward.setName(name);
    ward.setWardType(wardType);
    ward.setCapacity(capacity);

    boolean success = wardService.createWard(ward);

    System.out.println(success ? "Ward created successfully." : "Failed to create ward.");
}

private static void viewAllWards() {
    wardView.displayWards(wardService.getAllWards());
}

private static void findWard() {
    int id = readInt("Enter Ward ID: ");
    wardView.displayWard(wardService.getWardById(id));
}

private static void updateWard() {

    int id = readInt("Enter Ward ID to update: ");
    Ward ward = wardService.getWardById(id);

    if (ward == null) {
        System.out.println("Ward not found.");
        return;
    }

    wardView.displayWard(ward);

    System.out.print("Name: ");
    ward.setName(scanner.nextLine());

    System.out.print("Ward Type: ");
    ward.setWardType(scanner.nextLine());

    ward.setCapacity(readInt("Capacity: "));

    boolean success = wardService.updateWard(ward);

    System.out.println(success ? "Ward updated successfully." : "Ward update failed.");
}

private static void deleteWard() {

    int id = readInt("Enter Ward ID to delete: ");
    Ward ward = wardService.getWardById(id);

    if (ward == null) {
        System.out.println("Ward not found.");
        return;
    }

    wardView.displayWard(ward);

    System.out.print("Are you sure you want to delete this ward? (Y/N): ");
    String answer = scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {
        System.out.println("Delete cancelled.");
        return;
    }

    boolean success = wardService.deleteWard(id);

    System.out.println(success ? "Ward deleted successfully." : "Ward deletion failed.");
}





private static void roomMenu() {

    while (true) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("           ROOM MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. Create Room");
        System.out.println("2. View All Rooms");
        System.out.println("3. Find Room");
        System.out.println("4. Update Room");
        System.out.println("5. Delete Room");
        System.out.println("0. Back");
        System.out.println("========================================");

        int choice = readInt("Enter your choice: ");

        switch (choice) {
            case 1: createRoom(); break;
            case 2: viewAllRooms(); break;
            case 3: findRoom(); break;
            case 4: updateRoom(); break;
            case 5: deleteRoom(); break;
            case 0: return;
            default: System.out.println("Invalid choice.");
        }
    }
}

private static void createRoom() {

    System.out.println();
    System.out.println("========== CREATE ROOM ==========");

    int wardId = readInt("Enter Ward ID: ");
    Ward ward = wardService.getWardById(wardId);

    if (ward == null) {
        System.out.println("Ward not found.");
        return;
    }

    System.out.println("Ward: " + ward.getName());

    System.out.print("Room Number: ");
    String roomNumber = scanner.nextLine();

    System.out.print("Room Type: ");
    String roomType = scanner.nextLine();

    int capacity = readInt("Capacity: ");

    Room room = new Room();
    room.setWard(ward);
    room.setRoomNumber(roomNumber);
    room.setRoomType(roomType);
    room.setCapacity(capacity);

    boolean success = roomService.createRoom(room);

    System.out.println(success ? "Room created successfully." : "Failed to create room.");
}

private static void viewAllRooms() {
    roomView.displayRooms(roomService.getAllRooms());
}

private static void findRoom() {
    int id = readInt("Enter Room ID: ");
    roomView.displayRoom(roomService.getRoomById(id));
}

private static void updateRoom() {

    int id = readInt("Enter Room ID to update: ");
    Room room = roomService.getRoomById(id);

    if (room == null) {
        System.out.println("Room not found.");
        return;
    }

    roomView.displayRoom(room);

    int wardId = readInt("Enter Ward ID: ");
    Ward ward = wardService.getWardById(wardId);

    if (ward == null) {
        System.out.println("Ward not found.");
        return;
    }

    room.setWard(ward);

    System.out.print("Room Number: ");
    room.setRoomNumber(scanner.nextLine());

    System.out.print("Room Type: ");
    room.setRoomType(scanner.nextLine());

    room.setCapacity(readInt("Capacity: "));

    boolean success = roomService.updateRoom(room);

    System.out.println(success ? "Room updated successfully." : "Room update failed.");
}

private static void deleteRoom() {

    int id = readInt("Enter Room ID to delete: ");
    Room room = roomService.getRoomById(id);

    if (room == null) {
        System.out.println("Room not found.");
        return;
    }

    roomView.displayRoom(room);

    System.out.print("Are you sure you want to delete this room? (Y/N): ");
    String answer = scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {
        System.out.println("Delete cancelled.");
        return;
    }

    boolean success = roomService.deleteRoom(id);

    System.out.println(success ? "Room deleted successfully." : "Room deletion failed.");
}

private static void bedMenu() {

    while (true) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("           BED MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. Create Bed");
        System.out.println("2. View All Beds");
        System.out.println("3. Find Bed");
        System.out.println("4. Update Bed");
        System.out.println("5. Delete Bed");
        System.out.println("0. Back");
        System.out.println("========================================");

        int choice = readInt("Enter your choice: ");

        switch (choice) {
            case 1: createBed(); break;
            case 2: viewAllBeds(); break;
            case 3: findBed(); break;
            case 4: updateBed(); break;
            case 5: deleteBed(); break;
            case 0: return;
            default: System.out.println("Invalid choice.");
        }
    }
}

private static void createBed() {

    System.out.println();
    System.out.println("========== CREATE BED ==========");

    int roomId = readInt("Enter Room ID: ");
    Room room = roomService.getRoomById(roomId);

    if (room == null) {
        System.out.println("Room not found.");
        return;
    }

    System.out.println("Room: " + room.getRoomNumber() + " (" + room.getWard().getName() + ")");

    System.out.print("Bed Number: ");
    String bedNumber = scanner.nextLine();

    Bed bed = new Bed();
    bed.setRoom(room);
    bed.setBedNumber(bedNumber);
    bed.setOccupied(false);

    boolean success = bedService.createBed(bed);

    System.out.println(success ? "Bed created successfully." : "Failed to create bed.");
}

private static void viewAllBeds() {
    bedView.displayBeds(bedService.getAllBeds());
}

private static void findBed() {
    int id = readInt("Enter Bed ID: ");
    bedView.displayBed(bedService.getBedById(id));
}

private static void updateBed() {

    int id = readInt("Enter Bed ID to update: ");
    Bed bed = bedService.getBedById(id);

    if (bed == null) {
        System.out.println("Bed not found.");
        return;
    }

    bedView.displayBed(bed);

    int roomId = readInt("Enter Room ID: ");
    Room room = roomService.getRoomById(roomId);

    if (room == null) {
        System.out.println("Room not found.");
        return;
    }

    bed.setRoom(room);

    System.out.print("Bed Number: ");
    bed.setBedNumber(scanner.nextLine());

    boolean success = bedService.updateBed(bed);

    System.out.println(success ? "Bed updated successfully." : "Bed update failed.");
}

private static void deleteBed() {

    int id = readInt("Enter Bed ID to delete: ");
    Bed bed = bedService.getBedById(id);

    if (bed == null) {
        System.out.println("Bed not found.");
        return;
    }

    bedView.displayBed(bed);

    System.out.print("Are you sure you want to delete this bed? (Y/N): ");
    String answer = scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {
        System.out.println("Delete cancelled.");
        return;
    }

    boolean success = bedService.deleteBed(id);

    System.out.println(success ? "Bed deleted successfully." : "Bed deletion failed.");
}

private static void admitPatient() {

    System.out.println();
    System.out.println("========== ADMIT PATIENT ==========");

    int patientId = readInt("Enter Patient ID: ");
    Patient patient = patientService.getPatientById(patientId);

    if (patient == null) {
        System.out.println("Patient not found.");
        return;
    }

    System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName());

    System.out.println();
    System.out.println("Available Beds:");
    bedView.displayBeds(bedService.getAvailableBeds());

    int bedId = readInt("Enter Bed ID: ");
    Bed bed = bedService.getBedById(bedId);

    if (bed == null) {
        System.out.println("Bed not found.");
        return;
    }

    if (bed.isOccupied()) {
        System.out.println("That bed is already occupied.");
        return;
    }

    System.out.print("Reason for Admission: ");
    String reason = scanner.nextLine();

    Admission admission = new Admission();
    admission.setPatient(patient);
    admission.setBed(bed);
    admission.setReason(reason);

    boolean success = admissionService.admitPatient(admission);

    if (success) {
        System.out.println();
        System.out.println("Patient admitted successfully.");
        System.out.println("Admission ID: " + admission.getId());
    } else {
        System.out.println();
        System.out.println("Failed to admit patient.");
    }
}

private static void viewAllAdmissions() {
    admissionView.displayAdmissions(admissionService.getAllAdmissions());
}

private static void findAdmission() {
    int id = readInt("Enter Admission ID: ");
    admissionView.displayAdmission(admissionService.getAdmissionById(id));
}

private static void updateAdmission() {

    int id = readInt("Enter Admission ID to update: ");
    Admission admission = admissionService.getAdmissionById(id);

    if (admission == null) {
        System.out.println("Admission not found.");
        return;
    }

    admissionView.displayAdmission(admission);

    System.out.print("New Reason: ");
    admission.setReason(scanner.nextLine());

    boolean success = admissionService.updateAdmission(admission);

    System.out.println(success ? "Admission updated successfully." : "Admission update failed.");
}

private static void dischargePatient() {

    int id = readInt("Enter Admission ID to discharge: ");
    Admission admission = admissionService.getAdmissionById(id);

    if (admission == null) {
        System.out.println("Admission not found.");
        return;
    }

    admissionView.displayAdmission(admission);

    System.out.print("Are you sure you want to discharge this patient? (Y/N): ");
    String answer = scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {
        System.out.println("Discharge cancelled.");
        return;
    }

    boolean success = admissionService.dischargePatient(id);

    System.out.println(success ? "Patient discharged successfully." : "Discharge failed.");
}

private static void viewActiveAdmissions() {
    admissionView.displayAdmissions(admissionService.getActiveAdmissions());
}

private static void viewAvailableBeds() {
    bedView.displayBeds(bedService.getAvailableBeds());
}

private static void viewOccupiedBeds() {
    bedView.displayBeds(bedService.getOccupiedBeds());
}

private static void nurseAssignmentMenu() {

    while (true) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("          NURSE ASSIGNMENT");
        System.out.println("========================================");
        System.out.println("1. Create Assignment");
        System.out.println("2. View All Assignments");
        System.out.println("3. Find Assignment");
        System.out.println("4. View Assignments by Nurse");
        System.out.println("5. End Assignment");
        System.out.println("6. Delete Assignment");
        System.out.println("0. Back");
        System.out.println("========================================");

        int choice = readInt("Enter your choice: ");

        switch (choice) {
            case 1: createAssignment(); break;
            case 2: viewAllAssignments(); break;
            case 3: findAssignment(); break;
            case 4: viewAssignmentsByNurse(); break;
            case 5: endAssignment(); break;
            case 6: deleteAssignment(); break;
            case 0: return;
            default: System.out.println("Invalid choice.");
        }
    }
}

private static void createAssignment() {

    System.out.println();
    System.out.println("========== CREATE NURSE ASSIGNMENT ==========");

    int nurseId = readInt("Enter Nurse/Staff ID: ");
    Nurse nurse = nurseService.getNurseById(nurseId);

    if (nurse == null) {
        System.out.println("Nurse not found.");
        return;
    }

    System.out.println("Nurse: " + nurse.getFirstName() + " " + nurse.getLastName());

    int patientId = readInt("Enter Patient ID: ");
    Patient patient = patientService.getPatientById(patientId);

    if (patient == null) {
        System.out.println("Patient not found.");
        return;
    }

    System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName());

    NurseAssignment assignment = new NurseAssignment();
    assignment.setNurse(nurse);
    assignment.setPatient(patient);

    System.out.print("Link to an Admission? (Y/N): ");
    String linkAnswer = scanner.nextLine();

    if (linkAnswer.equalsIgnoreCase("Y")) {

        int admissionId = readInt("Enter Admission ID: ");
        Admission admission = admissionService.getAdmissionById(admissionId);

        if (admission == null) {
            System.out.println("Admission not found. Continuing without a link.");
        } else {
            assignment.setAdmission(admission);
        }
    }

    System.out.print("Shift (e.g. Morning/Afternoon/Night): ");
    assignment.setShift(scanner.nextLine());

    System.out.print("Notes: ");
    assignment.setNotes(scanner.nextLine());

    boolean success = nurseAssignmentService.createAssignment(assignment);

    if (success) {
        System.out.println();
        System.out.println("Assignment created successfully.");
        System.out.println("Assignment ID: " + assignment.getId());
    } else {
        System.out.println();
        System.out.println("Failed to create assignment.");
    }
}

private static void viewAllAssignments() {
    nurseAssignmentView.displayAssignments(nurseAssignmentService.getAllAssignments());
}

private static void findAssignment() {
    int id = readInt("Enter Assignment ID: ");
    nurseAssignmentView.displayAssignment(nurseAssignmentService.getAssignmentById(id));
}

private static void viewAssignmentsByNurse() {

    int nurseId = readInt("Enter Nurse/Staff ID: ");
    Nurse nurse = nurseService.getNurseById(nurseId);

    if (nurse == null) {
        System.out.println("Nurse not found.");
        return;
    }

    System.out.println();
    System.out.println("Assignments for " + nurse.getFirstName() + " " + nurse.getLastName());

    nurseAssignmentView.displayAssignments(
            nurseAssignmentService.getAssignmentsByNurse(nurseId)
    );
}

private static void endAssignment() {

    int id = readInt("Enter Assignment ID to end: ");
    NurseAssignment assignment = nurseAssignmentService.getAssignmentById(id);

    if (assignment == null) {
        System.out.println("Assignment not found.");
        return;
    }

    nurseAssignmentView.displayAssignment(assignment);

    System.out.print("Are you sure you want to end this assignment? (Y/N): ");
    String answer = scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {
        System.out.println("Cancelled.");
        return;
    }

    boolean success = nurseAssignmentService.endAssignment(id);

    System.out.println(success ? "Assignment ended successfully." : "Failed to end assignment.");
}

private static void deleteAssignment() {

    int id = readInt("Enter Assignment ID to delete: ");
    NurseAssignment assignment = nurseAssignmentService.getAssignmentById(id);

    if (assignment == null) {
        System.out.println("Assignment not found.");
        return;
    }

    nurseAssignmentView.displayAssignment(assignment);

    System.out.print("Are you sure you want to delete this assignment? (Y/N): ");
    String answer = scanner.nextLine();

    if (!answer.equalsIgnoreCase("Y")) {
        System.out.println("Delete cancelled.");
        return;
    }

    boolean success = nurseAssignmentService.deleteAssignment(id);

    System.out.println(success ? "Assignment deleted successfully." : "Assignment deletion failed.");
}

//DO NOT INSERT BELOW THIS LINE
}




