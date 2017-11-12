/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HospitalAdminAssistant;

import Business.EcoSystem;
import UserInterface.ReceptionRole.*;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.EventManagementOrganization;
import Business.Organization.HospitalAdminAssistantOrganization;
import Business.Organization.Organization;
import Business.Organization.ReceptionOrganization;
import Business.Organization.VolunteersOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DataWorkRequest;
import Business.WorkQueue.EventCreateWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.EventOrgRole.ProcessEventWRequests;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class HospitalAdminAssistantWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private HospitalAdminAssistantOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;

    public HospitalAdminAssistantWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, HospitalAdminAssistantOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        populateWorkRequestFromVolunteer();
        populateWorkspace();
        populateRequestTable();
    }

    public void populateWorkRequestFromVolunteer() {
        DefaultTableModel model = (DefaultTableModel) tblWorkQEvent.getModel();
        model.setRowCount(0);
        for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.getEnterpriseType().getValue().contains("NGO")) {
                    for (WorkRequest request : ent.getWorkQueue().getWorkRequestList()) {
                        if (request.getOrganizationName().equalsIgnoreCase(organization.getName()) || request.getOrganizationName().contains("Doctor")) {

                            Object[] row = new Object[7];

                            row[0] = request;
                            row[1] = request.getRequestDate();
                            row[2] = request.getDescription();
                            row[3] = request.getRequestedby().toString();
                            row[4] = request.getOrganizationName();
                            row[5] = request.getAssignedTo();
                            String result = request.getStatus();
                            row[6] = result == null ? "Waiting" : result;
                            model.addRow(row);

                        }
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
        btnDoctor = new javax.swing.JButton();
        pnlMyworkSpace = new javax.swing.JPanel();
        pnlPMyWorkSpaceBody = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMyWorkSpace = new javax.swing.JTable();
        pnlMyWorkSpaceBody = new javax.swing.JPanel();
        txtPersonalHeader2 = new javax.swing.JLabel();
        btnProcessRequest = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        dataAnalysisPanel = new javax.swing.JPanel();
        pnlPersonalBody4 = new javax.swing.JPanel();
        btnRequest = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblWorkRequest = new javax.swing.JTable();
        pnlPersonalHeader4 = new javax.swing.JPanel();
        txtPersonalHeader4 = new javax.swing.JLabel();
        pnlGraph = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(null);
        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlWorkRequestPool.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlPersonalBody3.setBackground(new java.awt.Color(255, 255, 255));
        pnlPersonalBody3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPersonalBody3Layout.setVerticalGroup(
            pnlPersonalBody3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalBody3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

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

        btnAssigntome.setText("Add To My Work Space");
        btnAssigntome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssigntomeActionPerformed(evt);
            }
        });

        btnDoctor.setText("Assign To Doctor");
        btnDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlWorkRequestPoolLayout = new javax.swing.GroupLayout(pnlWorkRequestPool);
        pnlWorkRequestPool.setLayout(pnlWorkRequestPoolLayout);
        pnlWorkRequestPoolLayout.setHorizontalGroup(
            pnlWorkRequestPoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPersonalHeader3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlWorkRequestPoolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlWorkRequestPoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPersonalBody3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlWorkRequestPoolLayout.createSequentialGroup()
                        .addComponent(btnAssigntome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnlWorkRequestPoolLayout.setVerticalGroup(
            pnlWorkRequestPoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWorkRequestPoolLayout.createSequentialGroup()
                .addComponent(pnlPersonalHeader3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlPersonalBody3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlWorkRequestPoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssigntome)
                    .addComponent(btnDoctor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(pnlWorkRequestPool, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, -1, -1));

        pnlMyworkSpace.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlPMyWorkSpaceBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlPMyWorkSpaceBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

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
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        pnlPMyWorkSpaceBodyLayout.setVerticalGroup(
            pnlPMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPMyWorkSpaceBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

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
                .addGap(21, 21, 21)
                .addComponent(txtPersonalHeader2)
                .addContainerGap(809, Short.MAX_VALUE))
        );
        pnlMyWorkSpaceBodyLayout.setVerticalGroup(
            pnlMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPersonalHeader2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        btnProcessRequest.setText("Process Request");
        btnProcessRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMyworkSpaceLayout = new javax.swing.GroupLayout(pnlMyworkSpace);
        pnlMyworkSpace.setLayout(pnlMyworkSpaceLayout);
        pnlMyworkSpaceLayout.setHorizontalGroup(
            pnlMyworkSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyworkSpaceLayout.createSequentialGroup()
                .addComponent(btnProcessRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlMyworkSpaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMyworkSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPMyWorkSpaceBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMyworkSpaceLayout.createSequentialGroup()
                        .addComponent(pnlMyWorkSpaceBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMyworkSpaceLayout.setVerticalGroup(
            pnlMyworkSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyworkSpaceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMyWorkSpaceBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPMyWorkSpaceBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProcessRequest)
                .addGap(26, 26, 26))
        );

        jPanel2.add(pnlMyworkSpace, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 313, 940, 270));

        jTabbedPane1.addTab("Work Request", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        dataAnalysisPanel.setBackground(new java.awt.Color(255, 255, 255));

        pnlPersonalBody4.setBackground(new java.awt.Color(255, 255, 255));
        pnlPersonalBody4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        btnRequest.setText("Request Test");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        tblWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work request ID", "Request On", "Description", "Requested by", "Assigned Organization", "Assigned To", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblWorkRequest);

        javax.swing.GroupLayout pnlPersonalBody4Layout = new javax.swing.GroupLayout(pnlPersonalBody4);
        pnlPersonalBody4.setLayout(pnlPersonalBody4Layout);
        pnlPersonalBody4Layout.setHorizontalGroup(
            pnlPersonalBody4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalBody4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalBody4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRequest)
                .addGap(375, 375, 375))
        );
        pnlPersonalBody4Layout.setVerticalGroup(
            pnlPersonalBody4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalBody4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRequest)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pnlPersonalHeader4.setBackground(new java.awt.Color(102, 102, 102));
        pnlPersonalHeader4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPersonalHeader4.setForeground(new java.awt.Color(255, 255, 255));
        txtPersonalHeader4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPersonalHeader4.setText("WorkRequests Pool ");

        javax.swing.GroupLayout pnlPersonalHeader4Layout = new javax.swing.GroupLayout(pnlPersonalHeader4);
        pnlPersonalHeader4.setLayout(pnlPersonalHeader4Layout);
        pnlPersonalHeader4Layout.setHorizontalGroup(
            pnlPersonalHeader4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalHeader4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtPersonalHeader4)
                .addContainerGap(769, Short.MAX_VALUE))
        );
        pnlPersonalHeader4Layout.setVerticalGroup(
            pnlPersonalHeader4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPersonalHeader4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dataAnalysisPanelLayout = new javax.swing.GroupLayout(dataAnalysisPanel);
        dataAnalysisPanel.setLayout(dataAnalysisPanelLayout);
        dataAnalysisPanelLayout.setHorizontalGroup(
            dataAnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataAnalysisPanelLayout.createSequentialGroup()
                .addGroup(dataAnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataAnalysisPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlPersonalHeader4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlPersonalBody4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataAnalysisPanelLayout.setVerticalGroup(
            dataAnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataAnalysisPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPersonalHeader4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pnlPersonalBody4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 945, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataAnalysisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataAnalysisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Incoming Work Request ", jPanel3);

        pnlGraph.setBackground(new java.awt.Color(255, 255, 255));
        pnlGraph.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jButton1.setText("Refresh");

        javax.swing.GroupLayout pnlGraphLayout = new javax.swing.GroupLayout(pnlGraph);
        pnlGraph.setLayout(pnlGraphLayout);
        pnlGraphLayout.setHorizontalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGraphLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(848, Short.MAX_VALUE))
        );
        pnlGraphLayout.setVerticalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGraphLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(714, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Analysis", pnlGraph);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssigntomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssigntomeActionPerformed
        int selectedRow = tblWorkQEvent.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int flag=0;
        WorkRequest request = (WorkRequest) tblWorkQEvent.getValueAt(selectedRow, 0);
        if(userAccount.getWorkQueue().getWorkRequestList().size()!=0){
            for(WorkRequest request2 : userAccount.getWorkQueue().getWorkRequestList()){
                if(request2.getWorkRequestID().equals(request.getWorkRequestID())){
                    JOptionPane.showMessageDialog(this, "This request ID is already assigned to you", "Error", JOptionPane.ERROR_MESSAGE);
                    flag=1;
                    break;
                }
                
            }
        }
        if(!request.getOrganizationName().equals(organization.getName())){
            JOptionPane.showMessageDialog(this, "Please assign this request to lab assistant", "Error", JOptionPane.ERROR_MESSAGE);
            flag=2;
        }
        for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.getEnterpriseType().getValue().contains("NGO")) {
                    for (WorkRequest request1 : ent.getWorkQueue().getWorkRequestList()) {

                        if (request1.getWorkRequestID().equals(request.getWorkRequestID())) {
                            
                            if(flag==0 && !(request1.getStatus().contains("Complete"))){
                                request1.setAssignedTo(userAccount);
                            request1.setStatus("Pending");
                                userAccount.getWorkQueue().getWorkRequestList().add(request1);
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
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {

            Object[] row = new Object[7];
//            row[0] = request;
//            row[1] = request.getSender().getEmployee().getName();
//            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
//            row[3] = request.getStatus();
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


    private void btnProcessRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessRequestActionPerformed
        int selectedRow = tblMyWorkSpace.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        WorkRequest request = (WorkRequest) tblMyWorkSpace.getValueAt(selectedRow, 0);
        if(!(request.getStatus().equalsIgnoreCase("Completed"))){
        request.setStatus("Processing");
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ProcessAssistantWRequests", new ProcessAssistantWRequests(userProcessContainer, request,enterprise));
        layout.next(userProcessContainer);

        }else{
        JOptionPane.showMessageDialog(this, "This request is already completed", "Error", JOptionPane.ERROR_MESSAGE);

        }
        //ProcessFinancialWRequests processFinancialWRequests = new ProcessFinancialWRequests(userProcessContainer, request);
        //userProcessContainer.add("processFinancialWRequests", processFinancialWRequests);
        
    }//GEN-LAST:event_btnProcessRequestActionPerformed

    private void btnDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorActionPerformed
        int selectedRow = tblWorkQEvent.getSelectedRow();
        WorkRequest request = (WorkRequest) tblWorkQEvent.getValueAt(selectedRow, 0);
        if (selectedRow < 0) {
            return;
        }
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof DoctorOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {
            //org.getWorkQueue().getWorkRequestList().add(request);
            for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.getEnterpriseType().getValue().contains("NGO")) {
                    for (WorkRequest request1 : ent.getWorkQueue().getWorkRequestList()) {

                        if (request1.getWorkRequestID().equals(request.getWorkRequestID())) {
                            
                            
                                request.setStatus("Sent to doctor");
                                JOptionPane.showMessageDialog(null, "Request Sent Successfully");
                    enterprise.getWorkQueue().getWorkRequestList().add(request);
                                //userAccount.getWorkQueue().getWorkRequestList().add(request);
                            
                            

                            populateWorkRequestFromVolunteer();
                        }
                    }
                }
            }
        }
            
            

            
        }
        else{
            JOptionPane.showMessageDialog(null, "Doctor organiaztion is not available");
        }
    }//GEN-LAST:event_btnDoctorActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("HospitalAdminAssistantRaiseWorkRequest", new HospitalAdminAssistantRaiseWorkRequest(userProcessContainer, userAccount, enterprise));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRequestActionPerformed
    
     public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblWorkRequest.getModel();

        model.setRowCount(0);
        for(WorkRequest request:enterprise.getWorkQueue().getWorkRequestList()){
            if(request.getReqByorganizationName().equalsIgnoreCase(organization.getName()) ){

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
    }}
     
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssigntome;
    private javax.swing.JButton btnDoctor;
    private javax.swing.JButton btnProcessRequest;
    private javax.swing.JButton btnRequest;
    private javax.swing.JPanel dataAnalysisPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlGraph;
    private javax.swing.JPanel pnlMyWorkSpaceBody;
    private javax.swing.JPanel pnlMyworkSpace;
    private javax.swing.JPanel pnlPMyWorkSpaceBody;
    private javax.swing.JPanel pnlPersonalBody3;
    private javax.swing.JPanel pnlPersonalBody4;
    private javax.swing.JPanel pnlPersonalHeader3;
    private javax.swing.JPanel pnlPersonalHeader4;
    private javax.swing.JPanel pnlWorkRequestPool;
    private javax.swing.JTable tblMyWorkSpace;
    private javax.swing.JTable tblWorkQEvent;
    private javax.swing.JTable tblWorkRequest;
    private javax.swing.JLabel txtPersonalHeader2;
    private javax.swing.JLabel txtPersonalHeader3;
    private javax.swing.JLabel txtPersonalHeader4;
    // End of variables declaration//GEN-END:variables
}
