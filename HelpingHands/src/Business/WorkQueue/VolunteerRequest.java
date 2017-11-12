/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author user
 */
public class VolunteerRequest extends WorkRequest{
    
    private String comment;
    private String BMI;
    private String height;
    private String weight;
    private String previousDoctor;
    private String abdominalSurgery;
    private String routineMedicines;
    private String allergies;
    private String operation;
    private String infection;
    private String organ;

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPreviousDoctor() {
        return previousDoctor;
    }

    public void setPreviousDoctor(String previousDoctor) {
        this.previousDoctor = previousDoctor;
    }

    public String getAbdominalSurgery() {
        return abdominalSurgery;
    }

    public void setAbdominalSurgery(String abdominalSurgery) {
        this.abdominalSurgery = abdominalSurgery;
    }

    public String getRoutineMedicines() {
        return routineMedicines;
    }

    public void setRoutineMedicines(String routineMedicines) {
        this.routineMedicines = routineMedicines;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getInfection() {
        return infection;
    }

    public void setInfection(String infection) {
        this.infection = infection;
    }
    
}
