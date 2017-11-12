
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;


public abstract class Role {
    
    public enum RoleType{
        Admin("AdminRole"),
        Datateam("DataTeamRole"),
        Volunteer("VolunteerRole"),
        FundRaising("FundraisingRole"),
        Eventmgt("EventOrgRole"),
        FinanceTeam("FinanceRole"),
        Lab("LabAssistant"),
        Reception("ReceptionRole");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return getValue();
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
    
}