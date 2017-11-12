/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.HospitalAdminAssistantOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.FundRaisingRole.FundRaisingTeamWorkAreaJPanel;
import UserInterface.HospitalAdminAssistant.HospitalAdminAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author MyPC1
 */
public class HospitalAdminAssistantRole extends Role {
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new  HospitalAdminAssistantWorkAreaJPanel(userProcessContainer,account,(HospitalAdminAssistantOrganization)organization,enterprise,business);
    }
}
