
package Business.Organization;


import Business.Role.Role;
import Business.Role.VolunteerRole;
import Business.Volunteer.Volunteer;
import Business.Volunteer.VolunteerDirectory;
import java.util.ArrayList;


public class VolunteersOrganization extends Organization{
 private ArrayList<Volunteer> volunteerList;
 public VolunteersOrganization() {
        super(Organization.Type.Volunteer.getValue());
        volunteerList= new ArrayList<Volunteer>();
        
    }
    public ArrayList<Volunteer> getVolunteerList() {
        return volunteerList;
    }

    public void setVolunteerList(ArrayList<Volunteer> volunteerList) {
        this.volunteerList = volunteerList;
    }
    
    public Volunteer addVolunteer(){
    Volunteer v= new Volunteer();
    volunteerList.add(v);
    return v;
    }
    
 
 
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new VolunteerRole());
        return roles;
    }
     
}

