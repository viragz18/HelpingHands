/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HospitalAdminAssistant;

import Business.WorkQueue.DataWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.EventOrgRole.EventOrgWorkAreaJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;

/**
 *
 * @author VinothPMoorthy
 */
public class ProcessAssistantWRequests extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private WorkRequest request;
    private Enterprise enterprise;
    public ProcessAssistantWRequests(JPanel userProcessContainer, WorkRequest request,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request; 
        this.enterprise=enterprise;
        fillexisitinData();
    }

    public void fillexisitinData() {
        if (request.getStatus().equalsIgnoreCase("Completed")) {
            tflwreqID.setText(request.getWorkRequestID());
            tflDesc.setText(request.getDescription());
            
            tflReqon.setText(String.valueOf(request.getRequestDate()));
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
            
            tflReqon.setText(String.valueOf(request.getRequestDate()));
            tflReqBy.setText(request.getRequestedby().toString());
            tflOrg.setText(request.getOrganizationName());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        pnlMyworkSpace4.setBackground(new java.awt.Color(255, 255, 255));
        pnlMyworkSpace4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlMyWorkSpaceBody.setBackground(new java.awt.Color(102, 102, 102));
        pnlMyWorkSpaceBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addGap(24, 24, 24)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPersonalHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        cmbAppStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Approve", "Reject" }));

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
                .addContainerGap(379, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
                                    .addComponent(txtreqb, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tflDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tflReqon, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tflReqBy, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(265, 265, 265))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(371, 371, 371))))
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
                .addGap(30, 30, 30)
                .addComponent(btnSubmit)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMyworkSpace4Layout = new javax.swing.GroupLayout(pnlMyworkSpace4);
        pnlMyworkSpace4.setLayout(pnlMyworkSpace4Layout);
        pnlMyworkSpace4Layout.setHorizontalGroup(
            pnlMyworkSpace4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMyWorkSpaceBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMyworkSpace4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMyworkSpace4Layout.setVerticalGroup(
            pnlMyworkSpace4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyworkSpace4Layout.createSequentialGroup()
                .addComponent(pnlMyWorkSpaceBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
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
            .addComponent(pnlMyworkSpace4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

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
            if (cmbAppStat.getSelectedItem().toString().equalsIgnoreCase("Reject")){
            // no check is required. 
            request.setApprovalStatus(cmbAppStat.getSelectedItem().toString());
            request.setComment(tflComments.getText());
            request.setStatus("Completed");
        }else{
            for(Organization org: enterprise.getOrganizationDirectory().getOrganizationList()){
                if(org.getName().contains("Doctor")){
                    if(request.getNoOfDoctors()<=org.getEmployeeDirectory().getEmployeeList().size()){
                        JOptionPane.showMessageDialog(this, "Please reject the request since no of doctors available are less than required doctors", "Error", JOptionPane.ERROR_MESSAGE);
                        tflComments.setText("no of doctors available are less than required doctors");
                    }

                    else{
                        request.setApprovalStatus(cmbAppStat.getSelectedItem().toString());
                        request.setComment(tflComments.getText());
                        request.setStatus("Completed");
                    }
                }
            
            
            

                }
            }
            request.setApprovalStatus(cmbAppStat.getSelectedItem().toString());
            request.setComment(tflComments.getText());
            if(cmbAppStat.getSelectedItem().toString().equalsIgnoreCase("Approve")||cmbAppStat.getSelectedItem().toString().equalsIgnoreCase("reject")){
                request.setStatus("Completed");
            }

        }   
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        HospitalAdminAssistantWorkAreaJPanel eowjp = (HospitalAdminAssistantWorkAreaJPanel) component;
        eowjp.populateWorkRequestFromVolunteer();
        eowjp.populateWorkspace();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbAppStat;
    private javax.swing.JPanel jPanel1;
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