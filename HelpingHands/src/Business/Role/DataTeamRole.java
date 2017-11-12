/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DatateamOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import UserInterface.DoctorRole.DoctorWorkAreaJPanel;
import javax.swing.JPanel;
import UserInterface.DataTeamRole.DataTeamWorkAreaJPanel;


public class DataTeamRole extends Role{

     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) { 
        return new DataTeamWorkAreaJPanel(userProcessContainer,account,(DatateamOrganization)organization,enterprise);
             
    }
    
}
