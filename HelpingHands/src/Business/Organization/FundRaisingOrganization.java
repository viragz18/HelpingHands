/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.FundraisingRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author VinothPMoorthy
 */
public class FundRaisingOrganization extends Organization {
 public FundRaisingOrganization() {
        super(Organization.Type.Fundraising.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new FundraisingRole());
        return roles;
    }
     
}

