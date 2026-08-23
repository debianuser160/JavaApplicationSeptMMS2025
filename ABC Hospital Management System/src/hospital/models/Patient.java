
package hospital.models;

import java.time.LocalDate;


public class Patient extends Person{
    private String patientID;
    private String bloodGroup;
    private String genotype;
    private String allergies;
    private String emmeregencyContact;
    private String emmeregencyNumber;
    
    public Patient(){
        
    }

    public Patient(String patientID, String bloodGroup, String genotype, 
            String allergies, String emmeregencyContact, 
            String emmeregencyNumber, String firstName, String lastName, 
            LocalDate dateOfBirth, String phone, String email, String street, 
            String city, String country) {
        super(firstName, lastName, dateOfBirth, phone, email, street, 
                city, country);
        this.patientID = patientID;
        this.bloodGroup = bloodGroup;
        this.genotype = genotype;
        this.allergies = allergies;
        this.emmeregencyContact = emmeregencyContact;
        this.emmeregencyNumber = emmeregencyNumber;
    }

    

    public String getPatientID() {
        return patientID;
    }

    

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGenotype() {
        return genotype;
    }

    public void setGenotype(String genotype) {
        this.genotype = genotype;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getEmmeregncyContact() {
        return emmeregencyContact;
    }

    public void setEmmeregncyContact(String emmeregncyContact) {
        this.emmeregencyContact = emmeregncyContact;
    }

    public String getEmmeregncyNumber() {
        return emmeregencyNumber;
    }

    public void setEmmeregncyNumber(String emmeregncyNumber) {
        this.emmeregencyNumber = emmeregncyNumber;
    }
    
   
    
}
