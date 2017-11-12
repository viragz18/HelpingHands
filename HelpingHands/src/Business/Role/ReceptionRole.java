/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.EventManagementOrganization;
import Business.Organization.FinanceOrganization;
import Business.Organization.Organization;
import Business.Organization.ReceptionOrganization;
import Business.Organization.VolunteersOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.EventOrgRole.EventOrgWorkAreaJPanel;
import UserInterface.FinanaceRole.FinanceTeamWorkAreaJPanel;
import UserInterface.ReceptionRole.ReceptionWorkAreaJPanel;
import UserInterface.VolunteerRole.VolunteerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class ReceptionRole extends Role {
    
        @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) { 
             return new ReceptionWorkAreaJPanel(userProcessContainer, account, (ReceptionOrganization)organization, enterprise, business);
    }
    

}
