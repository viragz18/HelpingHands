
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FundRaisingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.FundRaisingRole.FundRaisingTeamWorkAreaJPanel;

public class FundraisingRole extends Role{

     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new  FundRaisingTeamWorkAreaJPanel(userProcessContainer, account, (FundRaisingOrganization)organization, enterprise);
    }
 
}

