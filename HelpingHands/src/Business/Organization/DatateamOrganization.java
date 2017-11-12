/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Data.HomelessData;
import Business.Data.HomelessDataDirectory;

import Business.Role.DataTeamRole;
import Business.Role.Role;
import java.util.ArrayList;

public class DatateamOrganization extends Organization{
    
    private ArrayList<HomelessData> homelessDataList;
    public DatateamOrganization() {
        super(Organization.Type.Datateam.getValue());
        homelessDataList=new ArrayList<HomelessData>();
    }

    
    
    

    public ArrayList<HomelessData> getHomelessDataList() {
        return homelessDataList;
    }

    public void setHomelessDataList(ArrayList<HomelessData> homelessDataList) {
        this.homelessDataList = homelessDataList;
    }
    
    public HomelessData addHomelessData(){
        HomelessData homelessData=new HomelessData();
        homelessDataList.add(homelessData);
        return homelessData;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DataTeamRole());
        return roles;
    }
     
}