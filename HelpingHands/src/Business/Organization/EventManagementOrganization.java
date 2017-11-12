
package Business.Organization;

import Business.Event.Event;

import Business.Role.EventOrgRole;
import Business.Role.Role;
import java.util.ArrayList;

public class EventManagementOrganization extends Organization {
    private ArrayList<Event> eventList;
 public EventManagementOrganization() {
        super(Organization.Type.EventMngt.getValue());
        eventList=new ArrayList<Event>();
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new EventOrgRole());
        return roles;
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

