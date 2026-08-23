
package hospital.models;

import java.time.LocalDateTime;

public class MedicationDispensing {
    private int id;
    private Prescription prescription;
    private PrescriptionItem prescriptionItem;
    private Patient aptient;
    private LocalDateTime dispensingDate;
    private int quantity;
    private String status;
    private String notes;
    
    public MedicationDispensing(){
        
    }

    public int getId() {
        return id;
    }


    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public PrescriptionItem getPrescriptionItem() {
        return prescriptionItem;
    }

    public void setPrescriptionItem(PrescriptionItem prescriptionItem) {
        this.prescriptionItem = prescriptionItem;
    }

    public Patient getAptient() {
        return aptient;
    }

    public void setAptient(Patient aptient) {
        this.aptient = aptient;
    }

    public LocalDateTime getDispensingDate() {
        return dispensingDate;
    }

    public void setDispensingDate(LocalDateTime dispensingDate) {
        this.dispensingDate = dispensingDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
    
}
