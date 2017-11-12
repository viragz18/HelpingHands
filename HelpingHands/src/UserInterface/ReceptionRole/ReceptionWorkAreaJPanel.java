/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ReceptionRole;

import Business.EcoSystem;
import Business.Enterprise.BloodBankEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.EventManagementOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Organization.ReceptionOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.VolunteerRequest;
import Business.WorkQueue.DataWorkRequest;
import Business.WorkQueue.FundWRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.HospitalAdminAssistant.ProcessAssistantWRequests;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author user
 */
public class ReceptionWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ReceptionOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;

    public ReceptionWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ReceptionOrganization receptionOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = receptionOrganization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;

        populateWorkRequestFromVolunteer();
        populateWorkspace();
        commonGraph();
    }

    public void populateWorkRequestFromVolunteer() {
        DefaultTableModel model = (DefaultTableModel) tblWorkQEvent.getModel();
        model.setRowCount(0);
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise1 : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (WorkRequest request : enterprise1.getWorkQueue().getWorkRequestList()) {
                    if (request.getOrganizationName().equalsIgnoreCase(organization.getName()) || request.getOrganizationName().contains("Lab")) {

                        Object[] row = new Object[7];

                        row[0] = request;
                        row[1] = request.getRequestDate();
                        row[2] = request.getDescription();
                        row[3] = request.getRequestedby().toString();
                        row[4] = request.getOrganizationName();
                        row[5] = request.getAssignedTo();

                        row[6] = request.getStatus();

                        model.addRow(row);

                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pnlWorkRequestPool = new javax.swing.JPanel();
        pnlPersonalBody3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblWorkQEvent = new javax.swing.JTable();
        pnlPersonalHeader3 = new javax.swing.JPanel();
        txtPersonalHeader3 = new javax.swing.JLabel();
        btnAssigntome = new javax.swing.JButton();
        btnAssign = new javax.swing.JButton();
        pnlMyworkSpace = new javax.swing.JPanel();
        pnlPMyWorkSpaceBody = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMyWorkSpace = new javax.swing.JTable();
        pnlMyWorkSpaceBody = new javax.swing.JPanel();
        txtPersonalHeader2 = new javax.swing.JLabel();
        btnProcessRequest = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        pnlGraph = new javax.swing.JPanel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlWorkRequestPool.setBackground(new java.awt.Color(255, 255, 255));
        pnlWorkRequestPool.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        pnlWorkRequestPool.setForeground(new java.awt.Color(102, 102, 102));
        pnlWorkRequestPool.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPersonalBody3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblWorkQEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "WorkRequestID", "Requested On", "Description ", "Requested By", "Organization ", "Assigned To", "Status "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblWorkQEvent);

        javax.swing.GroupLayout pnlPersonalBody3Layout = new javax.swing.GroupLayout(pnlPersonalBody3);
        pnlPersonalBody3.setLayout(pnlPersonalBody3Layout);
        pnlPersonalBody3Layout.setHorizontalGroup(
            pnlPersonalBody3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalBody3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPersonalBody3Layout.setVerticalGroup(
            pnlPersonalBody3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalBody3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlWorkRequestPool.add(pnlPersonalBody3, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 93, -1, -1));

        pnlPersonalHeader3.setBackground(new java.awt.Color(102, 102, 102));
        pnlPersonalHeader3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPersonalHeader3.setForeground(new java.awt.Color(255, 255, 255));
        txtPersonalHeader3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPersonalHeader3.setText("WorkRequests Pool ");

        javax.swing.GroupLayout pnlPersonalHeader3Layout = new javax.swing.GroupLayout(pnlPersonalHeader3);
        pnlPersonalHeader3.setLayout(pnlPersonalHeader3Layout);
        pnlPersonalHeader3Layout.setHorizontalGroup(
            pnlPersonalHeader3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalHeader3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtPersonalHeader3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPersonalHeader3Layout.setVerticalGroup(
            pnlPersonalHeader3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPersonalHeader3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        pnlWorkRequestPool.add(pnlPersonalHeader3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 803, -1));

        btnAssigntome.setText("Add To My Work Space");
        btnAssigntome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssigntomeActionPerformed(evt);
            }
        });
        pnlWorkRequestPool.add(btnAssigntome, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 216, -1, -1));

        btnAssign.setText("Assign to Lab Assignment");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        pnlWorkRequestPool.add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 216, -1, -1));

        jPanel2.add(pnlWorkRequestPool, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, -1, -1));

        pnlMyworkSpace.setBackground(new java.awt.Color(255, 255, 255));
        pnlMyworkSpace.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        pnlMyworkSpace.setForeground(new java.awt.Color(102, 102, 102));
        pnlMyworkSpace.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPMyWorkSpaceBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblMyWorkSpace.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "WorkRequestID", "Requested On", "Description ", "Requested By", "Organization ", "Assigned To", "Status "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblMyWorkSpace);

        javax.swing.GroupLayout pnlPMyWorkSpaceBodyLayout = new javax.swing.GroupLayout(pnlPMyWorkSpaceBody);
        pnlPMyWorkSpaceBody.setLayout(pnlPMyWorkSpaceBodyLayout);
        pnlPMyWorkSpaceBodyLayout.setHorizontalGroup(
            pnlPMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPMyWorkSpaceBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPMyWorkSpaceBodyLayout.setVerticalGroup(
            pnlPMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPMyWorkSpaceBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMyworkSpace.add(pnlPMyWorkSpaceBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 43, -1, -1));

        pnlMyWorkSpaceBody.setBackground(new java.awt.Color(102, 102, 102));
        pnlMyWorkSpaceBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPersonalHeader2.setForeground(new java.awt.Color(255, 255, 255));
        txtPersonalHeader2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPersonalHeader2.setText("My Work Space");

        javax.swing.GroupLayout pnlMyWorkSpaceBodyLayout = new javax.swing.GroupLayout(pnlMyWorkSpaceBody);
        pnlMyWorkSpaceBody.setLayout(pnlMyWorkSpaceBodyLayout);
        pnlMyWorkSpaceBodyLayout.setHorizontalGroup(
            pnlMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyWorkSpaceBodyLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtPersonalHeader2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMyWorkSpaceBodyLayout.setVerticalGroup(
            pnlMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPersonalHeader2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        pnlMyworkSpace.add(pnlMyWorkSpaceBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, 797, -1));

        btnProcessRequest.setText("Process Request");
        btnProcessRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessRequestActionPerformed(evt);
            }
        });
        pnlMyworkSpace.add(btnProcessRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 170, 131, -1));

        jPanel2.add(pnlMyworkSpace, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 379, -1, -1));

        jTabbedPane1.addTab("Work Request", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefresh.setText("Refresh");
        jPanel3.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, -1, -1));

        pnlGraph.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlGraphLayout = new javax.swing.GroupLayout(pnlGraph);
        pnlGraph.setLayout(pnlGraphLayout);
        pnlGraphLayout.setHorizontalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
        );
        pnlGraphLayout.setVerticalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );

        jPanel3.add(pnlGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 53, -1, -1));

        jTabbedPane1.addTab("Analysis", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssigntomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssigntomeActionPerformed
        int selectedRow = tblWorkQEvent.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        int flag = 0;
        WorkRequest request = (WorkRequest) tblWorkQEvent.getValueAt(selectedRow, 0);
        if (userAccount.getWorkQueue().getWorkRequestList().size() != 0) {
            for (WorkRequest request2 : userAccount.getWorkQueue().getWorkRequestList()) {
                if (request2.getWorkRequestID().equals(request.getWorkRequestID())) {
                    JOptionPane.showMessageDialog(this, "This request ID is already assigned to you", "Error", JOptionPane.ERROR_MESSAGE);
                    flag = 1;
                    break;
                }

            }
        }
        if (!request.getOrganizationName().equals(organization.getName())) {
            JOptionPane.showMessageDialog(this, "Please assign this request to Lab Assistant", "Error", JOptionPane.ERROR_MESSAGE);
            flag = 2;
        }
        for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.getEnterpriseType().getValue().contains("NGOs") || ent.getEnterpriseType().getValue().contains("Hospital")) {
                    for (WorkRequest request1 : ent.getWorkQueue().getWorkRequestList()) {

                        if (request1.getWorkRequestID().equals(request.getWorkRequestID())) {

                            if (flag == 0) {
                                request1.setAssignedTo(userAccount);
                                request1.setStatus("Pending");
                                //userAccount.getWorkQueue().getWorkRequestList().add(request);
                            }
                            populateWorkspace();

                            populateWorkRequestFromVolunteer();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAssigntomeActionPerformed

    public void populateWorkspace() {
        DefaultTableModel model = (DefaultTableModel) tblMyWorkSpace.getModel();
        //Organiza
        model.setRowCount(0);
        //for(Organization org)
        for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.getEnterpriseType().getValue().contains("NGOs") || ent.getEnterpriseType().getValue().contains("Hospital")) {
                    for (WorkRequest request1 : ent.getWorkQueue().getWorkRequestList()) {
                        if(request1.getOrganizationName().contains("Reception")  && (request1.getStatus().equalsIgnoreCase("Pending") || request1.getStatus().equalsIgnoreCase("Processing")||request1.getStatus().equalsIgnoreCase("Completed"))  ){
            Object[] row = new Object[7];
//            row[0] = request;
//            row[1] = request.getSender().getEmployee().getName();
//            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
//            row[3] = request.getStatus();
            row[0] = request1;
            row[1] = request1.getRequestDate();
            row[2] = request1.getDescription();
            row[3] = request1.getRequestedby().toString();
            row[4] = request1.getOrganizationName();
            row[5] = request1.getAssignedTo();
            row[6] = request1.getStatus();
            model.addRow(row);
        }
                }}}}
    }
    private void btnProcessRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessRequestActionPerformed
        int selectedRow = tblMyWorkSpace.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        WorkRequest request = (WorkRequest) tblMyWorkSpace.getValueAt(selectedRow, 0);
        
          if(!(request.getStatus().equalsIgnoreCase("Completed"))){
        request.setStatus("Processing");
        ProcessBloodDonationRequest processFinancialWRequests = new ProcessBloodDonationRequest(userProcessContainer, request, enterprise);
        userProcessContainer.add("processBloodDonationRequests", processFinancialWRequests);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }else{
        JOptionPane.showMessageDialog(this, "This request is already completed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
       
    }//GEN-LAST:event_btnProcessRequestActionPerformed

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        int selectedRow = tblWorkQEvent.getSelectedRow();
        WorkRequest request = (WorkRequest) tblWorkQEvent.getValueAt(selectedRow, 0);
        if(request.getStatus().equalsIgnoreCase("Sent to lab assistant")){
        JOptionPane.showMessageDialog(this, "This request is already sent to Lab Assistant", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        if (selectedRow < 0) {
            return;
        }
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof LabOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {
            //org.getWorkQueue().getWorkRequestList().add(request);
            for (Network network : business.getNetworkList()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (ent.getEnterpriseType().getValue().contains("NGOs")) {
                        for (WorkRequest request1 : ent.getWorkQueue().getWorkRequestList()) {

                            if (request1.getOrganizationName().equals(request.getOrganizationName())) {
                                
                                request1.setStatus("Sent to lab assistant");
                                //enterprise.getWorkQueue().getWorkRequestList().add(request);
//                                userAccount.getWorkQueue().getWorkRequestList().add(request);
                                JOptionPane.showMessageDialog(null, "Request Sent Successfully");
                                populateWorkRequestFromVolunteer();
                                break;
                            }
                        }
                    }
                }
            }

            
        } else {
            JOptionPane.showMessageDialog(null, "Lab organiaztion is not available");
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    public JFreeChart populateBarGraph() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        dataSet.setValue((((BloodBankEnterprise)enterprise).getaPositive()), "No. of Bottles", "A+");
        dataSet.setValue((((BloodBankEnterprise)enterprise).getaNegative()), "No. of Bottles", "A-");
        dataSet.setValue((((BloodBankEnterprise)enterprise).getAbPositive()), "No. of Bottles", "AB+");
        dataSet.setValue((((BloodBankEnterprise)enterprise).getAbNegative()), "No. of Bottles", "AB-");
        dataSet.setValue((((BloodBankEnterprise)enterprise).getbPositive()), "No. of Bottles", "B+");
        dataSet.setValue((((BloodBankEnterprise)enterprise).getbNegavtive()), "No. of Bottles", "B-");
        dataSet.setValue((((BloodBankEnterprise)enterprise).getoPositive()), "No. of Bottles", "O+");
        dataSet.setValue((((BloodBankEnterprise)enterprise).getoNegative()), "No. of Bottles", "O-");

        JFreeChart chart = ChartFactory.createBarChart("Blood Quantity Available", "Blood Group", "No. of Bottles", dataSet, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(Color.YELLOW);
        chart.getTitle().setPaint(Color.red);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        //p.setDirection(Rotation.CLOCKWISE);
        p.setForegroundAlpha(0.5f);
        chart.setBackgroundPaint(Color.YELLOW);
        chart.getTitle().setPaint(Color.red);
        p.setOutlinePaint(Color.red);
        p.setBackgroundPaint(Color.BLUE);
        return chart;
    }

    public void commonGraph() {
        ChartPanel frame2 = new ChartPanel(populateBarGraph());
        frame2.setSize(200, 200);

        pnlGraph.removeAll();
        pnlGraph.setLayout(new java.awt.BorderLayout());
        pnlGraph.setLayout(new GridLayout(1, 1));

//       jPanel1.setSize(450,350);
//        pnlGraph.add(frame, BorderLayout.EAST);
//        pnlGraph.add(frame1, BorderLayout.EAST);
//        pnlGraph.add(frame2, BorderLayout.EAST);
        
        pnlGraph.add(frame2, BorderLayout.EAST);
        pnlGraph.validate();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnAssigntome;
    private javax.swing.JButton btnProcessRequest;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlGraph;
    private javax.swing.JPanel pnlMyWorkSpaceBody;
    private javax.swing.JPanel pnlMyworkSpace;
    private javax.swing.JPanel pnlPMyWorkSpaceBody;
    private javax.swing.JPanel pnlPersonalBody3;
    private javax.swing.JPanel pnlPersonalHeader3;
    private javax.swing.JPanel pnlWorkRequestPool;
    private javax.swing.JTable tblMyWorkSpace;
    private javax.swing.JTable tblWorkQEvent;
    private javax.swing.JLabel txtPersonalHeader2;
    private javax.swing.JLabel txtPersonalHeader3;
    // End of variables declaration//GEN-END:variables
}
