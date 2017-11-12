/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Event;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class EventDirectory {
    private ArrayList<Event> eventList;
    
    public EventDirectory(){
    eventList= new ArrayList<>();
   }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }
    
    public Event addEvent(){
    Event e= new Event();
    eventList.add(e);
    return e;
        
    }
}
