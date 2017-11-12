package Business.WorkQueue;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class WorkRequest {

    private static int count;
    private String message;
    
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private String requestDate;
    private Date resolveDate;
    private String eventName;
    private Date eventDate;
    private String eventLocation;
    private double noOfPpl;
    private double budget;
    private double participation;
    private String volunteerName;
    private String registerEvent;
    private String volEmail;
    private String volContact;
    private String workRequestID;
    private Date requestedOn;
    private String description;
    private UserAccount requestedby;
    private String organizationName;
    private String reqByorganizationName;
    private UserAccount assignedTo;
    private Date resolvedon;
    private String Narration;
    private String ChequeNo;
    private double Debit;
    private double credit;
    private String approvalStatus;
    private int noOfDoctors;
    private String bloodGroup;
    private Date donationDate;
    private String diseaseBg;
    private int age;
    private String myRequestName;
    private String comment;
    private Date approvalDate;

    
    
    
    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
    
    
    
    
    public WorkRequest(){
        Date date=new Date();


        requestDate = new SimpleDateFormat("MM-dd-yyyy").format(date);
        count=count+1;
        workRequestID = String.valueOf(count);
        

    }

    public String getComment() {
        return comment;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoOfDoctors() {
        return noOfDoctors;
    }

    public void setNoOfDoctors(int noOfDoctors) {
        this.noOfDoctors = noOfDoctors;
    }

    public String getMyRequestName() {
        return myRequestName;
    }


    public void setMyRequestName(String myRequestName) {
        this.myRequestName = myRequestName;
    }
   
   


    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReqByorganizationName() {
        return reqByorganizationName;
    }

    public void setReqByorganizationName(String reqByorganizationName) {
        this.reqByorganizationName = reqByorganizationName;
    }

    public String getWorkRequestID() {
        return workRequestID;
    }

    public void setWorkRequestID(String workRequestID) {
        this.workRequestID = workRequestID;
    }

    public Date getRequestedOn() {
        return requestedOn;
    }

    public void setRequestedOn(Date requestedOn) {
        this.requestedOn = requestedOn;
    }

    public double getParticipation() {
        return participation;
    }

    public void setParticipation(double participation) {
        this.participation = participation;
    }

    public UserAccount getRequestedby() {
        return requestedby;
    }

    public void setRequestedby(UserAccount requestedby) {
        this.requestedby = requestedby;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public UserAccount getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UserAccount assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getResolvedon() {
        return resolvedon;
    }

    public void setResolvedon(Date resolvedon) {
        this.resolvedon = resolvedon;
    }

    public String getNarration() {
        return Narration;
    }

    public void setNarration(String Narration) {
        this.Narration = Narration;
    }

    public String getChequeNo() {
        return ChequeNo;
    }

    public void setChequeNo(String ChequeNo) {
        this.ChequeNo = ChequeNo;
    }

    public double getDebit() {
        return Debit;
    }

    public void setDebit(double Debit) {
        this.Debit = Debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public double getNoOfPpl() {
        return noOfPpl;
    }

    public void setNoOfPpl(double noOfPpl) {
        this.noOfPpl = noOfPpl;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getRegisterEvent() {
        return registerEvent;
    }

    public void setRegisterEvent(String registerEvent) {
        this.registerEvent = registerEvent;
    }

    public String getVolEmail() {
        return volEmail;
    }

    public void setVolEmail(String volEmail) {
        this.volEmail = volEmail;
    }

    public String getVolContact() {
        return volContact;
    }

    public void setVolContact(String volContact) {
        this.volContact = volContact;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public String getDiseaseBg() {
        return diseaseBg;
    }

    public void setDiseaseBg(String diseaseBg) {
        this.diseaseBg = diseaseBg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return workRequestID;
    }
}
