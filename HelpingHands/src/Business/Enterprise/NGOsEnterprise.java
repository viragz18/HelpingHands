package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

public class NGOsEnterprise extends Enterprise {

    public NGOsEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.NGOs);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

}
