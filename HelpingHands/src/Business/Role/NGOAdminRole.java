
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DatateamOrganization;
import Business.Organization.EventManagementOrganization;
import Business.Organization.FinanceOrganization;
import Business.Organization.FundRaisingOrganization;
import Business.Organization.Organization;
import Business.Organization.VolunteersOrganization;
import Business.UserAccount.UserAccount;

import UserInterface.NGOAdminRole.NGOAdminWorkAreaJPanel;
import javax.swing.JPanel;


public class NGOAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new NGOAdminWorkAreaJPanel(userProcessContainer, account, organization, enterprise);
    }
    
}
