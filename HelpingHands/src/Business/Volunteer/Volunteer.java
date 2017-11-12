/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Volunteer;

import Business.Event.Event;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Volunteer {
    private String volunteerName;
    private String email;
    private String phone;
    private double donatedAmt=0;

    

    private ArrayList<Event> registeredEvent;
    public Volunteer(){
        registeredEvent=new ArrayList<Event>();
                
    }

    public double getDonatedAmt() {
        return donatedAmt;
    }

    public void setDonatedAmt(double donatedAmt) {
        this.donatedAmt = donatedAmt;
    }
    
    
    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Event> getRegisteredEvent() {
        return registeredEvent;
    }

    public void setRegisteredEvent(ArrayList<Event> registeredEvent) {
        this.registeredEvent = registeredEvent;
    }
    
    public Event addRegisteredEvent(){
    Event e= new Event();
    registeredEvent.add(e);
    return e;
        
    }
    
}
