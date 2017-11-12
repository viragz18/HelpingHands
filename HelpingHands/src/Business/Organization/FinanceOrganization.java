
package Business.Organization;


import Business.Role.FinanceRole;
import Business.Role.Role;
import java.util.ArrayList;


public class FinanceOrganization extends Organization{
 public FinanceOrganization() {
        super(Organization.Type.Finance.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new FinanceRole());
        return roles;
    }
     
}
