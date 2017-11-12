
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;


public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.Hospital){
            enterprise=new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        }else if(type==Enterprise.EnterpriseType.NGOs){
            enterprise=new NGOsEnterprise(name);
            enterpriseList.add(enterprise);
        }else if (type==Enterprise.EnterpriseType.BloodBank){
            enterprise=new BloodBankEnterprise(name);
            enterpriseList.add(enterprise);
        } 
        return enterprise;
    }
}
