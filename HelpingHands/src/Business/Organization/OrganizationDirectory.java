
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.Datateam.getValue())) {
            organization = new DatateamOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.EventMngt.getValue())) {
            organization = new EventManagementOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Fundraising.getValue())) {
            organization = new FundRaisingOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Finance.getValue())) {
            organization = new FinanceOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Volunteer.getValue())) {
            organization = new VolunteersOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Doctor.getValue())) {
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())) {
            organization = new LabOrganization();
            organizationList.add(organization);
        }
       
           else if (type.getValue().equals(Type.BloodBankAdmin.getValue())) {
            organization = new BloodBankAdminOrganization();
            organizationList.add(organization);
        }
           else if (type.getValue().equals(Type.Reception.getValue())) {
            organization = new ReceptionOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.HospitalAdminAssistant.getValue())) {
            organization = new HospitalAdminAssistantOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
}
