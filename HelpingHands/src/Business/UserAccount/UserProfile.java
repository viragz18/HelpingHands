
package Business.UserAccount;
import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import javax.swing.ImageIcon;


public class UserProfile {
    private String firstName;
    private String lastName;
    private String emailID;
    private String sex;
    private String age; 
    private String streetL1;
    private String streetL2;
    private String city;
    private String state;
    private String country;
    private String mobileNo;
    private String wrkEx;
    private String DOJ;
    private String Organization;
    private String Role;
    ImageIcon storeImage;

    public ImageIcon getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(ImageIcon storeImage) {
        this.storeImage = storeImage;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStreetL1() {
        return streetL1;
    }

    public void setStreetL1(String streetL1) {
        this.streetL1 = streetL1;
    }

    public String getStreetL2() {
        return streetL2;
    }

    public void setStreetL2(String streetL2) {
        this.streetL2 = streetL2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getWrkEx() {
        return wrkEx;
    }

    public void setWrkEx(String wrkEx) {
        this.wrkEx = wrkEx;
    }

    public String getDOJ() {
        return DOJ;
    }

    public void setDOJ(String DOJ) {
        this.DOJ = DOJ;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String Organization) {
        this.Organization = Organization;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    
    @Override
    public String toString() {
        return firstName;
    }
    
}
