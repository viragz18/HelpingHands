/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.HospitalAdminAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class HospitalAdminAssistantOrganization extends Organization{

    public HospitalAdminAssistantOrganization() {
        super(Organization.Type.HospitalAdminAssistant.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new HospitalAdminAssistantRole());
        return roles;
    }
}
