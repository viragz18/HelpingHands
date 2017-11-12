
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.VolunteersOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.VolunteerRole.VolunteerWorkAreaJPanel;


public class VolunteerRole extends Role{

     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new VolunteerWorkAreaJPanel(userProcessContainer,account,(VolunteersOrganization)organization, enterprise, business);
    }
    
}

