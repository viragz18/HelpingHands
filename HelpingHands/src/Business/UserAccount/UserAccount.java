/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

public class UserAccount {

    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private UserProfile userProfile;
    private EnterpriseInfo enterpriseinfo;

    public UserAccount() {
        workQueue = new WorkQueue();
        userProfile = new UserProfile();
        enterpriseinfo = new EnterpriseInfo();
    }

    public EnterpriseInfo getEnterpriseinfo() {
        return enterpriseinfo;
    }

    public void setEnterpriseinfo(EnterpriseInfo enterpriseinfo) {
        this.enterpriseinfo = enterpriseinfo;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    @Override
    public String toString() {
        return username;
    }

}
