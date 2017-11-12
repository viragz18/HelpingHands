/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FinanaceRole;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.DataTeamRole.DataTeamWorkAreaJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VinothPMoorthy
 */
public class ProcessFinancialWRequests extends javax.swing.JPanel {

    JPanel userProcessContainer;
    WorkRequest request;
    Enterprise enterprise;

    public ProcessFinancialWRequests(JPanel userProcessContainer, WorkRequest request, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.enterprise = enterprise;
        fillexisitinData();
    }

    public void fillexisitinData() {
        tflwreqID.setText(request.getWorkRequestID());
        tflDesc.setText(request.getDescription());
        tflCredit.setText(String.valueOf(request.getCredit()));
        tflDebit.setText(String.valueOf(request.getDebit()));
        tflReqon.setText(String.valueOf(request.getRequestDate()));
        tflReqBy.setText(String.valueOf(request.getRequestedby()));
        tflOrg.setText(request.getReqByorganizationName());
        tflComments.setText(request.getComment());
        cmbAppStat.setSelectedItem(request.getApprovalStatus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMyworkSpace4 = new javax.swing.JPanel();
        pnlMyWorkSpaceBody = new javax.swing.JPanel();
        txtPersonalHeader2 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmbAppStat = new javax.swing.JComboBox<>();
        txtCredit = new javax.swing.JLabel();
        tflCredit = new javax.swing.JTextField();
        txtDeb = new javax.swing.JLabel();
        tflDebit = new javax.swing.JTextField();
        txtreqOn = new javax.swing.JLabel();
        txtWrokREq = new javax.swing.JLabel();
        tflReqon = new javax.swing.JTextField();
        tflwreqID = new javax.swing.JTextField();
        txtOrg = new javax.swing.JLabel();
        txtreqb = new javax.swing.JLabel();
        tflOrg = new javax.swing.JTextField();
        tflReqBy = new javax.swing.JTextField();
        txtApprov = new javax.swing.JLabel();
        txtDesc = new javax.swing.JLabel();
        tflDesc = new javax.swing.JTextField();
        txtComments = new javax.swing.JLabel();
        tflComments = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();

        pnlMyworkSpace4.setBackground(new java.awt.Color(255, 255, 255));
        pnlMyworkSpace4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlMyWorkSpaceBody.setBackground(new java.awt.Color(102, 102, 102));
        pnlMyWorkSpaceBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPersonalHeader2.setBackground(new java.awt.Color(102, 102, 102));
        txtPersonalHeader2.setForeground(new java.awt.Color(255, 255, 255));
        txtPersonalHeader2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPersonalHeader2.setText("Process Work Request - Finance Management ");

        btnback.setText("<Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMyWorkSpaceBodyLayout = new javax.swing.GroupLayout(pnlMyWorkSpaceBody);
        pnlMyWorkSpaceBody.setLayout(pnlMyWorkSpaceBodyLayout);
        pnlMyWorkSpaceBodyLayout.setHorizontalGroup(
            pnlMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyWorkSpaceBodyLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPersonalHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMyWorkSpaceBodyLayout.setVerticalGroup(
            pnlMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPersonalHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        cmbAppStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "InProcess", "Approve", "Reject" }));

        txtCredit.setText("Inflow cash request");
        txtCredit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCredit.setOpaque(true);

        tflCredit.setEditable(false);

        txtDeb.setText("OutFlow cash Request");
        txtDeb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDeb.setOpaque(true);

        tflDebit.setEditable(false);

        txtreqOn.setText("Requested On");
        txtreqOn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtreqOn.setOpaque(true);

        txtWrokREq.setText("WorkRequest ID");
        txtWrokREq.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtWrokREq.setOpaque(true);

        tflReqon.setEditable(false);

        tflwreqID.setEditable(false);

        txtOrg.setText("Requested Organization");
        txtOrg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtOrg.setOpaque(true);

        txtreqb.setText("Requested By");
        txtreqb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtreqb.setOpaque(true);

        tflOrg.setEditable(false);

        tflReqBy.setEditable(false);

        txtApprov.setText("Approval Status ");
        txtApprov.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApprov.setOpaque(true);

        txtDesc.setText("Description ");
        txtDesc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDesc.setOpaque(true);

        tflDesc.setEditable(false);

        txtComments.setText("Comments");
        txtComments.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtComments.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtComments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tflComments, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtApprov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAppStat, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtOrg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tflOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtreqb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tflReqBy, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtreqOn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tflReqon, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDeb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tflDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tflCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtWrokREq, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tflwreqID, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(tflDesc))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWrokREq)
                    .addComponent(tflwreqID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDesc)
                    .addComponent(tflDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCredit)
                    .addComponent(tflCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeb)
                    .addComponent(tflDebit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtreqOn)
                    .addComponent(tflReqon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtreqb)
                    .addComponent(tflReqBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrg)
                    .addComponent(tflOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApprov)
                    .addComponent(cmbAppStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComments)
                    .addComponent(tflComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMyworkSpace4Layout = new javax.swing.GroupLayout(pnlMyworkSpace4);
        pnlMyworkSpace4.setLayout(pnlMyworkSpace4Layout);
        pnlMyworkSpace4Layout.setHorizontalGroup(
            pnlMyworkSpace4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMyWorkSpaceBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMyworkSpace4Layout.createSequentialGroup()
                .addGroup(pnlMyworkSpace4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMyworkSpace4Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMyworkSpace4Layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        pnlMyworkSpace4Layout.setVerticalGroup(
            pnlMyworkSpace4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyworkSpace4Layout.createSequentialGroup()
                .addComponent(pnlMyWorkSpaceBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMyworkSpace4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMyworkSpace4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        /**
         * *check the incoming request in Credit or Debit
         */
        if (request.getReqByorganizationName().contains("FundRaising") ||request.getReqByorganizationName().contains("Volunteer") ) {
            // Its a credit - No Validations are required . Proceed. 
            if (cmbAppStat.getSelectedItem().equals("InProcess")){
                // Do Nothing 
            }else{
            processRequest();
            calculateBalance();                
            }


        } else if (request.getReqByorganizationName().contains("EventManagement")) {
            if (cmbAppStat.getSelectedItem().equals("Approve")) {
                // its a Debit 
                double currentBalance = currentOrgBalance();
                if (currentBalance <= request.getBudget()) {
                    // Funding not available. 
                    JOptionPane.showMessageDialog(this, "Sorry ! Not enough Funding Available. Please Reject this Request", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    processRequest();
                    calculateBalance();
                }
            } else if (cmbAppStat.getSelectedItem().equals("Reject")) {

                processRequest();

            }
        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void processRequest() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date dateobj = new Date();
        String curval = request.getApprovalStatus();
        if (curval == null) {
            request.setComment(tflComments.getText());
            request.setStatus("Complete");
            request.setApprovalStatus(String.valueOf(cmbAppStat.getSelectedItem()));
            request.setApprovalDate(dateobj);

            JOptionPane.showMessageDialog(null, "Request Submitted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Request cannot be Submited again", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private double currentOrgBalance() {
        double currbalance = 0.0;
        for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
            currbalance = ua.getEnterpriseinfo().getBalance();
        }
        return currbalance;
    }

    private void calculateBalance() {
        Double currbalance = 0.0;
        for (WorkRequest wr : enterprise.getWorkQueue().getWorkRequestList()) {
            String str = wr.getOrganizationName();
            String str1 = wr.getReqByorganizationName();
            if (str.equalsIgnoreCase("Finance Organization")) {
                if (wr.getApprovalStatus() != null) {
                    if (wr.getApprovalStatus().equalsIgnoreCase("Approve")) {
                        if (str1.equalsIgnoreCase("FundRaising Organization") || str1.equalsIgnoreCase("Volunteers Organization")) {
                            currbalance = currbalance + wr.getCredit();
                        } else if (str1.equalsIgnoreCase("EventManagement Organization")) {
                            currbalance = currbalance - wr.getDebit();
                        }

                    }
                }
            }
        }
        /*--- Set Balance to  NGO Admin Page -------*/
        for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
            ua.getEnterpriseinfo().setBalance(currbalance);
        }        
    }
    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);

        //re-populate
        Component[] component = userProcessContainer.getComponents();
        Component previous = component[component.length - 1];
        FinanceTeamWorkAreaJPanel finance = (FinanceTeamWorkAreaJPanel) previous;
        finance.populateProfileTab();
        finance.populateWorkrequestTab();
        finance.populateWorkspace();
        finance.populatefmanTab();
        finance.populatestatementstable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnbackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnback;
    private javax.swing.JComboBox<String> cmbAppStat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlMyWorkSpaceBody;
    private javax.swing.JPanel pnlMyworkSpace4;
    private javax.swing.JTextField tflComments;
    private javax.swing.JTextField tflCredit;
    private javax.swing.JTextField tflDebit;
    private javax.swing.JTextField tflDesc;
    private javax.swing.JTextField tflOrg;
    private javax.swing.JTextField tflReqBy;
    private javax.swing.JTextField tflReqon;
    private javax.swing.JTextField tflwreqID;
    private javax.swing.JLabel txtApprov;
    private javax.swing.JLabel txtComments;
    private javax.swing.JLabel txtCredit;
    private javax.swing.JLabel txtDeb;
    private javax.swing.JLabel txtDesc;
    private javax.swing.JLabel txtOrg;
    private javax.swing.JLabel txtPersonalHeader2;
    private javax.swing.JLabel txtWrokREq;
    private javax.swing.JLabel txtreqOn;
    private javax.swing.JLabel txtreqb;
    // End of variables declaration//GEN-END:variables
}
