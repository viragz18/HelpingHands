package Business.UserAccount;

public class EnterpriseInfo {

    private String eName;
    private String BaccountNo;
    private String fiscalYear;
    private String taxpayerID;
    private String taxRegistrationNo;
    private String cashflow;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getBaccountNo() {
        return BaccountNo;
    }

    public void setBaccountNo(String BaccountNo) {
        this.BaccountNo = BaccountNo;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getTaxpayerID() {
        return taxpayerID;
    }

    public void setTaxpayerID(String taxpayerID) {
        this.taxpayerID = taxpayerID;
    }

    public String getTaxRegistrationNo() {
        return taxRegistrationNo;
    }

    public void setTaxRegistrationNo(String taxRegistrationNo) {
        this.taxRegistrationNo = taxRegistrationNo;
    }

    public String getCashflow() {
        return cashflow;
    }

    public void setCashflow(String cashflow) {
        this.cashflow = cashflow;
    }

    @Override
    public String toString() {
        return eName;
    }

}
