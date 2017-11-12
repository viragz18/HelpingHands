/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Event;

import java.util.Date;

/**
 *
 * @author user
 */
public class Event {
    private String eventName;
    private String location;
    private Date eventDate;
    private int noOfPpl;
    private double budget;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getNoOfPpl() {
        return noOfPpl;
    }

    public void setNoOfPpl(int noOfPpl) {
        this.noOfPpl = noOfPpl;
    }

  

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    
    @Override
    public String toString(){
    
    return this.eventName;
    }
    
}
