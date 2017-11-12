
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.FinanceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.FinanaceRole.FinanceTeamWorkAreaJPanel;


public class FinanceRole extends Role{

     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) { 
             return new FinanceTeamWorkAreaJPanel(userProcessContainer, account, (FinanceOrganization)organization, enterprise);
    }
    
    
}

