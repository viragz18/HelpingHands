
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;


public class BloodBankEnterprise extends Enterprise {
    private int aPositive;
    private int aNegative;
    private int bPositive;
    private int bNegavtive;
    private int abPositive;
    private int abNegative;
    private int oPositive;
    private int oNegative;
    
    public BloodBankEnterprise(String name){
        super(name,Enterprise.EnterpriseType.BloodBank);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public int getaPositive() {
        return aPositive;
    }

    public void setaPositive(int aPositive) {
        this.aPositive = aPositive;
    }

    public int getaNegative() {
        return aNegative;
    }

    public void setaNegative(int aNegative) {
        this.aNegative = aNegative;
    }

    public int getbPositive() {
        return bPositive;
    }

    public void setbPositive(int bPositive) {
        this.bPositive = bPositive;
    }

    public int getbNegavtive() {
        return bNegavtive;
    }

    public void setbNegavtive(int bNegavtive) {
        this.bNegavtive = bNegavtive;
    }

    public int getAbPositive() {
        return abPositive;
    }

    public void setAbPositive(int abPositive) {
        this.abPositive = abPositive;
    }

    public int getAbNegative() {
        return abNegative;
    }

    public void setAbNegative(int abNegative) {
        this.abNegative = abNegative;
    }

    public int getoPositive() {
        return oPositive;
    }

    public void setoPositive(int oPositive) {
        this.oPositive = oPositive;
    }

    public int getoNegative() {
        return oNegative;
    }

    public void setoNegative(int oNegative) {
        this.oNegative = oNegative;
    }
    
    
    
}
