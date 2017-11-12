package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.EventManagementOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.EventOrgRole.EventOrgWorkAreaJPanel;

public class EventOrgRole extends Role{

     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
         
             return new  EventOrgWorkAreaJPanel(userProcessContainer,account,(EventManagementOrganization)organization, enterprise, business);
    }
    
}