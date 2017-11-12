/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ReceptionRole;

import Business.Enterprise.BloodBankEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.HospitalAdminAssistant;
import Business.WorkQueue.HospitalAdminAssistant;
import Business.WorkQueue.WorkRequest;
import UserInterface.VolunteerRole.VolunteerWorkAreaJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class ProcessBloodDonationRequest extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private WorkRequest request;
    private Enterprise enterprise;
    ProcessBloodDonationRequest(JPanel userProcessContainer, WorkRequest request,Enterprise enterprise) {
         initComponents();
         this.userProcessContainer=userProcessContainer;
         this.request=request;
         this.enterprise=enterprise;
         fillexisitinData();
        
         
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        pnlMyworkSpace4 = new javax.swing.JPanel();
        pnlMyWorkSpaceBody = new javax.swing.JPanel();
        txtPersonalHeader2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmbAppStat = new javax.swing.JComboBox<>();
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

        jLabel6.setText("Work Request ID:");

        jTextField5.setEditable(false);
        jTextField5.setEnabled(false);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMyworkSpace4.setBackground(new java.awt.Color(255, 255, 255));
        pnlMyworkSpace4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlMyWorkSpaceBody.setBackground(new java.awt.Color(102, 102, 102));
        pnlMyWorkSpaceBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPersonalHeader2.setBackground(new java.awt.Color(102, 102, 102));
        txtPersonalHeader2.setForeground(new java.awt.Color(255, 255, 255));
        txtPersonalHeader2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPersonalHeader2.setText("Process Work Request - Event Management ");

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMyWorkSpaceBodyLayout = new javax.swing.GroupLayout(pnlMyWorkSpaceBody);
        pnlMyWorkSpaceBody.setLayout(pnlMyWorkSpaceBodyLayout);
        pnlMyWorkSpaceBodyLayout.setHorizontalGroup(
            pnlMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMyWorkSpaceBodyLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPersonalHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMyWorkSpaceBodyLayout.setVerticalGroup(
            pnlMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPersonalHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        cmbAppStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "InProcess", "Approve", "Reject" }));

        txtreqOn.setText("Requested On");
        txtreqOn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtreqOn.setOpaque(true);

        txtWrokREq.setText("WorkRequest ID");
        txtWrokREq.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtWrokREq.setOpaque(true);

        tflReqon.setEditable(false);

        tflwreqID.setEditable(false);

        txtOrg.setText("Organization");
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

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(txtWrokREq, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tflwreqID, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtreqOn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtreqb, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tflDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tflReqon, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tflReqBy, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout pnlMyworkSpace4Layout = new javax.swing.GroupLayout(pnlMyworkSpace4);
        pnlMyworkSpace4.setLayout(pnlMyworkSpace4Layout);
        pnlMyworkSpace4Layout.setHorizontalGroup(
            pnlMyworkSpace4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMyWorkSpaceBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMyworkSpace4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );
        pnlMyworkSpace4Layout.setVerticalGroup(
            pnlMyworkSpace4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyworkSpace4Layout.createSequentialGroup()
                .addComponent(pnlMyWorkSpaceBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        add(pnlMyworkSpace4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    
    public void fillexisitinData() {
        if (request.getStatus().equalsIgnoreCase("Completed")) {
            tflwreqID.setText(request.getWorkRequestID());
            tflDesc.setText(request.getDescription());
            
            tflReqon.setText(request.getRequestDate());
            tflReqBy.setText(request.getRequestedby().toString());
            tflOrg.setText(request.getOrganizationName());
            tflComments.setText(request.getComment());
            
            cmbAppStat.setSelectedItem(request.getApprovalStatus());
            cmbAppStat.setEnabled(false);
            tflComments.setEditable(false);
            
            btnSubmit.setEnabled(false);
        } else {
            tflwreqID.setText(request.getWorkRequestID());
            tflDesc.setText(request.getDescription());
            
            tflReqon.setText(request.getRequestDate());
            tflReqBy.setText(request.getRequestedby().toString());
            tflOrg.setText(request.getOrganizationName());
        }
        
    }
    
    private boolean validation() {
        if (cmbAppStat.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select approval status", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (tflComments.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter comments", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } 
        return true;
    }
    
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (validation()) {
            for(Organization org: enterprise.getOrganizationDirectory().getOrganizationList()){
                if(org.getName().contains("Reception") && cmbAppStat.getSelectedItem().toString().equalsIgnoreCase("Approve")){
                    if(request.getBloodGroup().contains("A+") && ((HospitalAdminAssistant)request).getQuantity()>((BloodBankEnterprise)enterprise).getaPositive()){
                        JOptionPane.showMessageDialog(this, "Please reject the request since blood sample requirement is more than availability", "Error", JOptionPane.ERROR_MESSAGE);
                        tflComments.setText("less stock");
                        
                    }
                    else if(request.getBloodGroup().contains("A-") && ((HospitalAdminAssistant)request).getQuantity()>((BloodBankEnterprise)enterprise).getaNegative()){
                        JOptionPane.showMessageDialog(this, "Please reject the request since blood sample requirement is more than availability", "Error", JOptionPane.ERROR_MESSAGE);
                        tflComments.setText("less stock");
                    }
                    else if(request.getBloodGroup().contains("B+") && ((HospitalAdminAssistant)request).getQuantity()>((BloodBankEnterprise)enterprise).getbPositive()){
                        JOptionPane.showMessageDialog(this, "Please reject the request since blood sample requirement is more than availability", "Error", JOptionPane.ERROR_MESSAGE);
                        tflComments.setText("less stock");
                    }
                    else if(request.getBloodGroup().contains("B-") && ((HospitalAdminAssistant)request).getQuantity()>((BloodBankEnterprise)enterprise).getbNegavtive()){
                        JOptionPane.showMessageDialog(this, "Please reject the request since blood sample requirement is more than availability", "Error", JOptionPane.ERROR_MESSAGE);
                        tflComments.setText("less stock");
                    }
                    else if(request.getBloodGroup().contains("AB+") && ((HospitalAdminAssistant)request).getQuantity()>((BloodBankEnterprise)enterprise).getAbPositive()){
                        JOptionPane.showMessageDialog(this, "Please reject the request since blood sample requirement is more than availability", "Error", JOptionPane.ERROR_MESSAGE);
                        tflComments.setText("less stock");
                    }
                    else if(request.getBloodGroup().contains("AB-") && ((HospitalAdminAssistant)request).getQuantity()>((BloodBankEnterprise)enterprise).getAbNegative()){
                        JOptionPane.showMessageDialog(this, "Please reject the request since blood sample requirement is more than availability", "Error", JOptionPane.ERROR_MESSAGE);
                        tflComments.setText("less stock");
                    }
                    else if(request.getBloodGroup().contains("O+") && ((HospitalAdminAssistant)request).getQuantity()>((BloodBankEnterprise)enterprise).getoPositive()){
                        JOptionPane.showMessageDialog(this, "Please reject the request since blood sample requirement is more than availability", "Error", JOptionPane.ERROR_MESSAGE);
                        tflComments.setText("less stock");
                    }
                    else if(request.getBloodGroup().contains("O-") && ((HospitalAdminAssistant)request).getQuantity()>((BloodBankEnterprise)enterprise).getoNegative()){
                        JOptionPane.showMessageDialog(this, "Please reject the request since blood sample requirement is more than availability", "Error", JOptionPane.ERROR_MESSAGE);
                        tflComments.setText("less stock");
                    }
                }
            }
            request.setApprovalStatus(cmbAppStat.getSelectedItem().toString());
            request.setComment(tflComments.getText());
            if(cmbAppStat.getSelectedItem().toString().equalsIgnoreCase("Approve") || cmbAppStat.getSelectedItem().toString().equalsIgnoreCase("Reject")){
                request.setStatus("Completed");
            }

        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ReceptionWorkAreaJPanel eowjp = (ReceptionWorkAreaJPanel) component;
        eowjp.populateWorkRequestFromVolunteer();
        eowjp.populateWorkspace();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbAppStat;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel pnlMyWorkSpaceBody;
    private javax.swing.JPanel pnlMyworkSpace4;
    private javax.swing.JTextField tflComments;
    private javax.swing.JTextField tflDesc;
    private javax.swing.JTextField tflOrg;
    private javax.swing.JTextField tflReqBy;
    private javax.swing.JTextField tflReqon;
    private javax.swing.JTextField tflwreqID;
    private javax.swing.JLabel txtApprov;
    private javax.swing.JLabel txtComments;
    private javax.swing.JLabel txtDesc;
    private javax.swing.JLabel txtOrg;
    private javax.swing.JLabel txtPersonalHeader2;
    private javax.swing.JLabel txtWrokREq;
    private javax.swing.JLabel txtreqOn;
    private javax.swing.JLabel txtreqb;
    // End of variables declaration//GEN-END:variables
}
