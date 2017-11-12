/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EventOrgRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.EventManagementOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DataWorkRequest;
import Business.WorkQueue.EventCreateWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.DoctorRole.ProceessRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author VinothPMoorthy
 */
public class EventOrgWorkAreaJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer;
    private EventManagementOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private ImageIcon storeImage;
    public EventOrgWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, EventManagementOrganization organization, Enterprise enterprise, EcoSystem business ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business=business;

        populateHistoryTable();
        populateUpComingTable();
        populateRequestTable();
        populateWorkRequestFromData();
        populateWorkspace();
        plotGraph();

    }
    
    public void changemode(boolean value) {
        tflFirstName.setEnabled(value);
        tflLastName.setEnabled(value);
        tflAge.setEnabled(value);
        cmbSex.setEnabled(value);
        tflAddress1.setEnabled(value);
        tflAddress2.setEnabled(value);
        tflCity.setEnabled(value);
        tflState.setEnabled(value);
        tflCountry.setEnabled(value);
        tflEmailID.setEnabled(value);
        tflMobile.setEnabled(value);
        tflDoj.setEnabled(value);
        tflWorkExp.setEnabled(value);
    }
    
    public void populateHistoryTable() {
        DefaultTableModel model = (DefaultTableModel) tblEventHistory.getModel();
        Date today = new Date();
        model.setRowCount(0);
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            if (request.getReqByorganizationName().equalsIgnoreCase(organization.getName())) {
                if (request.getEventDate().before(today) && request.getStatus().contains("Completed")) {
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

    public void populateUpComingTable() {
        DefaultTableModel model = (DefaultTableModel) tblUpComingEvent.getModel();
        Date today = new Date();
        model.setRowCount(0);
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            if (request.getReqByorganizationName().equalsIgnoreCase(organization.getName())) {
                if (request.getEventDate().after(today) && request.getStatus().contains("Complete") && request.getApprovalStatus().contains("Approve")) {
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

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblWorkRequest.getModel();

        model.setRowCount(0);
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            if (request.getReqByorganizationName().equalsIgnoreCase(organization.getName())) {

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
    public void populateWorkRequestFromData() {
        DefaultTableModel model = (DefaultTableModel) tblWorkQEvent.getModel();
        Date today = new Date();
        model.setRowCount(0);
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            if (request.getOrganizationName().equalsIgnoreCase(organization.getName())) {
                
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequest = new javax.swing.JTable();
        btnCreateEvent = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        pnlWorkRequestPool = new javax.swing.JPanel();
        pnlPersonalBody3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblWorkQEvent = new javax.swing.JTable();
        pnlPersonalHeader3 = new javax.swing.JPanel();
        txtPersonalHeader3 = new javax.swing.JLabel();
        btnAssigntome = new javax.swing.JButton();
        pnlMyworkSpace = new javax.swing.JPanel();
        pnlPMyWorkSpaceBody = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMyWorkSpace = new javax.swing.JTable();
        pnlMyWorkSpaceBody = new javax.swing.JPanel();
        txtPersonalHeader2 = new javax.swing.JLabel();
        btnProcessRequest = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblEventHistory = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblUpComingEvent = new javax.swing.JTable();
        btnDetails = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtEventName = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBudget = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPart = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        pnlView = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        pnlProfile = new javax.swing.JPanel();
        pnlContactInfo = new javax.swing.JPanel();
        pnlContactinfoHeader = new javax.swing.JPanel();
        lblContactHeader = new javax.swing.JLabel();
        pnlContactInfoBody = new javax.swing.JPanel();
        tflCity = new javax.swing.JTextField();
        tflAddress2 = new javax.swing.JTextField();
        tflState = new javax.swing.JTextField();
        txtState = new javax.swing.JLabel();
        tflEmailID = new javax.swing.JTextField();
        txtaddress2 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JLabel();
        tflAddress1 = new javax.swing.JTextField();
        txtCountry = new javax.swing.JLabel();
        tflMobile = new javax.swing.JTextField();
        txtCity = new javax.swing.JLabel();
        txtMobile = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        tflCountry = new javax.swing.JTextField();
        pnlPersonalDeatails = new javax.swing.JPanel();
        pnlPersonalHeader = new javax.swing.JPanel();
        txtPersonalHeader = new javax.swing.JLabel();
        pnlPersonalBody = new javax.swing.JPanel();
        txtLastName = new javax.swing.JLabel();
        txtAge = new javax.swing.JLabel();
        tflFirstName = new javax.swing.JTextField();
        txtSex = new javax.swing.JLabel();
        tflAge = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JLabel();
        tflLastName = new javax.swing.JTextField();
        cmbSex = new javax.swing.JComboBox<>();
        pnlEmploymentDetails = new javax.swing.JPanel();
        pnlEmploymentHeader = new javax.swing.JPanel();
        txtEmployementHeader = new javax.swing.JLabel();
        pnlEmployementBody = new javax.swing.JPanel();
        tflOrganization = new javax.swing.JTextField();
        txtRole = new javax.swing.JLabel();
        txtWorkExp = new javax.swing.JLabel();
        tflDoj = new javax.swing.JTextField();
        tflWorkExp = new javax.swing.JTextField();
        TxtDoj = new javax.swing.JLabel();
        tflRole = new javax.swing.JTextField();
        txtOrganization = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblWorkRequest.setBackground(new java.awt.Color(153, 153, 153));
        tblWorkRequest.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        tblWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Request ID", "Requested on", "Description", "Requested By", "Assigned Organization", "Assigned To", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblWorkRequest);

        btnCreateEvent.setText("Create Event Request");
        btnCreateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEventActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(btnCreateEvent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreateEvent)
                .addContainerGap(805, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pending Events", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        pnlWorkRequestPool.setBackground(new java.awt.Color(255, 255, 255));
        pnlWorkRequestPool.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlPersonalBody3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblWorkQEvent.setBackground(new java.awt.Color(204, 204, 204));
        tblWorkQEvent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        tblWorkQEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPersonalBody3Layout.setVerticalGroup(
            pnlPersonalBody3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalBody3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPersonalHeader3.setBackground(new java.awt.Color(102, 102, 102));
        pnlPersonalHeader3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlPersonalHeader3.setForeground(new java.awt.Color(255, 255, 255));

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
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlWorkRequestPoolLayout.setVerticalGroup(
            pnlWorkRequestPoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWorkRequestPoolLayout.createSequentialGroup()
                .addComponent(pnlPersonalHeader3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(pnlPersonalBody3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAssigntome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMyworkSpace.setBackground(new java.awt.Color(255, 255, 255));
        pnlMyworkSpace.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlPMyWorkSpaceBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblMyWorkSpace.setBackground(new java.awt.Color(204, 204, 204));
        tblMyWorkSpace.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        tblMyWorkSpace.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPMyWorkSpaceBodyLayout.setVerticalGroup(
            pnlPMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPMyWorkSpaceBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMyWorkSpaceBody.setBackground(new java.awt.Color(102, 102, 102));
        pnlMyWorkSpaceBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMyWorkSpaceBody.setForeground(new java.awt.Color(255, 255, 255));

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
            .addComponent(pnlMyWorkSpaceBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMyworkSpaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMyworkSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMyworkSpaceLayout.createSequentialGroup()
                        .addComponent(pnlPMyWorkSpaceBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlMyworkSpaceLayout.createSequentialGroup()
                        .addComponent(btnProcessRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlMyworkSpaceLayout.setVerticalGroup(
            pnlMyworkSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyworkSpaceLayout.createSequentialGroup()
                .addComponent(pnlMyWorkSpaceBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPMyWorkSpaceBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProcessRequest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlWorkRequestPool, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMyworkSpace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlWorkRequestPool, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMyworkSpace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(532, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Work Requests", jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblEventHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Request ID", "Requested on", "Description", "Requested By", "Assigned Organization", "Assigned To", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblEventHistory);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(866, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Event History ", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);

        tblUpComingEvent.setBackground(new java.awt.Color(204, 204, 204));
        tblUpComingEvent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        tblUpComingEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Request ID", "Requested on", "Description", "Requested By", "Assigned Organization", "Assigned To", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblUpComingEvent);

        btnDetails.setText("View Full Details");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Event Name:");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);

        txtEventName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtEventName.setEnabled(false);

        txtLocation.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtLocation.setEnabled(false);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Location:");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);

        txtBudget.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtBudget.setEnabled(false);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Budget Proposed:");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel3.setOpaque(true);

        txtPart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtPart.setEnabled(false);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Participation:");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Date:");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.setOpaque(true);

        txtDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtPart, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDetails))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDetails)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 749, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Upcoming Events", jPanel2);

        pnlView.setBackground(new java.awt.Color(255, 255, 255));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlViewLayout = new javax.swing.GroupLayout(pnlView);
        pnlView.setLayout(pnlViewLayout);
        pnlViewLayout.setHorizontalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh)
                .addContainerGap(826, Short.MAX_VALUE))
        );
        pnlViewLayout.setVerticalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh)
                .addContainerGap(977, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Analysis", pnlView);

        pnlProfile.setBackground(new java.awt.Color(255, 255, 255));
        pnlProfile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        pnlProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContactInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlContactInfo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        pnlContactInfo.setPreferredSize(new java.awt.Dimension(685, 307));

        pnlContactinfoHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlContactinfoHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlContactinfoHeader.setForeground(new java.awt.Color(255, 255, 255));

        lblContactHeader.setBackground(new java.awt.Color(102, 102, 102));
        lblContactHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblContactHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContactHeader.setText("Conact Information ");

        javax.swing.GroupLayout pnlContactinfoHeaderLayout = new javax.swing.GroupLayout(pnlContactinfoHeader);
        pnlContactinfoHeader.setLayout(pnlContactinfoHeaderLayout);
        pnlContactinfoHeaderLayout.setHorizontalGroup(
            pnlContactinfoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContactinfoHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblContactHeader)
                .addContainerGap(744, Short.MAX_VALUE))
        );
        pnlContactinfoHeaderLayout.setVerticalGroup(
            pnlContactinfoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContactinfoHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblContactHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlContactInfoBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlContactInfoBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        txtState.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtState.setText("State");
        txtState.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtState.setOpaque(true);

        txtaddress2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtaddress2.setText("Address Line 2");
        txtaddress2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtaddress2.setOpaque(true);

        txtAddress1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAddress1.setText("Address Line 1");
        txtAddress1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAddress1.setOpaque(true);

        txtCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCountry.setText("Country");
        txtCountry.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCountry.setOpaque(true);

        txtCity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCity.setText("City");
        txtCity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCity.setOpaque(true);

        txtMobile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMobile.setText("Mobile Number");
        txtMobile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtMobile.setOpaque(true);

        txtEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEmail.setText("EmailID");
        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtEmail.setOpaque(true);

        tflCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tflCountryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlContactInfoBodyLayout = new javax.swing.GroupLayout(pnlContactInfoBody);
        pnlContactInfoBody.setLayout(pnlContactInfoBodyLayout);
        pnlContactInfoBodyLayout.setHorizontalGroup(
            pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContactInfoBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCountry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMobile, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContactInfoBodyLayout.createSequentialGroup()
                        .addComponent(tflMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tflEmailID))
                    .addGroup(pnlContactInfoBodyLayout.createSequentialGroup()
                        .addComponent(tflAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaddress2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tflAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContactInfoBodyLayout.createSequentialGroup()
                        .addGroup(pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tflCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tflCity, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(tflState)))
                        .addGap(399, 399, 399)))
                .addContainerGap())
        );
        pnlContactInfoBodyLayout.setVerticalGroup(
            pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContactInfoBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress1)
                    .addComponent(tflAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tflAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtaddress2))
                .addGap(0, 0, 0)
                .addGroup(pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity)
                    .addComponent(tflCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtState)
                    .addComponent(tflState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tflCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCountry))
                .addGap(0, 0, 0)
                .addGroup(pnlContactInfoBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMobile)
                    .addComponent(tflMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail)
                    .addComponent(tflEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlContactInfoLayout = new javax.swing.GroupLayout(pnlContactInfo);
        pnlContactInfo.setLayout(pnlContactInfoLayout);
        pnlContactInfoLayout.setHorizontalGroup(
            pnlContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContactInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContactinfoHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlContactInfoLayout.createSequentialGroup()
                        .addComponent(pnlContactInfoBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlContactInfoLayout.setVerticalGroup(
            pnlContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContactInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContactinfoHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlContactInfoBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlProfile.add(pnlContactInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 910, 220));

        pnlPersonalDeatails.setBackground(new java.awt.Color(255, 255, 255));
        pnlPersonalDeatails.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlPersonalHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlPersonalHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlPersonalHeader.setForeground(new java.awt.Color(255, 255, 255));

        txtPersonalHeader.setBackground(new java.awt.Color(102, 102, 102));
        txtPersonalHeader.setForeground(new java.awt.Color(255, 255, 255));
        txtPersonalHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPersonalHeader.setText("Personal Details ");

        javax.swing.GroupLayout pnlPersonalHeaderLayout = new javax.swing.GroupLayout(pnlPersonalHeader);
        pnlPersonalHeader.setLayout(pnlPersonalHeaderLayout);
        pnlPersonalHeaderLayout.setHorizontalGroup(
            pnlPersonalHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtPersonalHeader)
                .addContainerGap(765, Short.MAX_VALUE))
        );
        pnlPersonalHeaderLayout.setVerticalGroup(
            pnlPersonalHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPersonalHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlPersonalBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlPersonalBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        txtLastName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtLastName.setText("LastName");
        txtLastName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtLastName.setOpaque(true);

        txtAge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAge.setText("Age ");
        txtAge.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAge.setOpaque(true);

        tflFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tflFirstNameActionPerformed(evt);
            }
        });

        txtSex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSex.setText("Sex ");
        txtSex.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSex.setOpaque(true);

        txtFirstName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFirstName.setText("First Name ");
        txtFirstName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFirstName.setOpaque(true);

        cmbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "N/A" }));
        cmbSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPersonalBodyLayout = new javax.swing.GroupLayout(pnlPersonalBody);
        pnlPersonalBody.setLayout(pnlPersonalBodyLayout);
        pnlPersonalBodyLayout.setHorizontalGroup(
            pnlPersonalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonalBodyLayout.createSequentialGroup()
                        .addGroup(pnlPersonalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPersonalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tflFirstName)
                            .addComponent(tflLastName)
                            .addGroup(pnlPersonalBodyLayout.createSequentialGroup()
                                .addComponent(tflAge, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addGap(182, 182, 182))))
                    .addGroup(pnlPersonalBodyLayout.createSequentialGroup()
                        .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPersonalBodyLayout.setVerticalGroup(
            pnlPersonalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName)
                    .addComponent(tflFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAge)
                    .addComponent(tflAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSex)
                    .addComponent(cmbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPersonalDeatailsLayout = new javax.swing.GroupLayout(pnlPersonalDeatails);
        pnlPersonalDeatails.setLayout(pnlPersonalDeatailsLayout);
        pnlPersonalDeatailsLayout.setHorizontalGroup(
            pnlPersonalDeatailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalDeatailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonalDeatailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPersonalHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPersonalBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPersonalDeatailsLayout.setVerticalGroup(
            pnlPersonalDeatailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalDeatailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPersonalHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPersonalBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pnlProfile.add(pnlPersonalDeatails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 910, 240));

        pnlEmploymentDetails.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmploymentDetails.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlEmploymentHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlEmploymentHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlEmploymentHeader.setForeground(new java.awt.Color(255, 255, 255));

        txtEmployementHeader.setBackground(new java.awt.Color(102, 102, 102));
        txtEmployementHeader.setForeground(new java.awt.Color(255, 255, 255));
        txtEmployementHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEmployementHeader.setText("Employment Details ");

        javax.swing.GroupLayout pnlEmploymentHeaderLayout = new javax.swing.GroupLayout(pnlEmploymentHeader);
        pnlEmploymentHeader.setLayout(pnlEmploymentHeaderLayout);
        pnlEmploymentHeaderLayout.setHorizontalGroup(
            pnlEmploymentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmploymentHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtEmployementHeader)
                .addContainerGap(740, Short.MAX_VALUE))
        );
        pnlEmploymentHeaderLayout.setVerticalGroup(
            pnlEmploymentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmploymentHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEmployementHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlEmployementBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmployementBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        tflOrganization.setEditable(false);
        tflOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tflOrganizationActionPerformed(evt);
            }
        });

        txtRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRole.setText("Role");
        txtRole.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtRole.setOpaque(true);

        txtWorkExp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtWorkExp.setText("WorkExp");
        txtWorkExp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtWorkExp.setOpaque(true);

        TxtDoj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtDoj.setText("DOJ");
        TxtDoj.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtDoj.setOpaque(true);

        tflRole.setEditable(false);

        txtOrganization.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtOrganization.setText("Organization ");
        txtOrganization.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtOrganization.setOpaque(true);

        javax.swing.GroupLayout pnlEmployementBodyLayout = new javax.swing.GroupLayout(pnlEmployementBody);
        pnlEmployementBody.setLayout(pnlEmployementBodyLayout);
        pnlEmployementBodyLayout.setHorizontalGroup(
            pnlEmployementBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployementBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEmployementBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOrganization, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(TxtDoj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(pnlEmployementBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflDoj, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tflOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployementBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtWorkExp, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEmployementBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflWorkExp, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(tflRole))
                .addContainerGap())
        );
        pnlEmployementBodyLayout.setVerticalGroup(
            pnlEmployementBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployementBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEmployementBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrganization)
                    .addComponent(tflOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRole)
                    .addComponent(tflRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(pnlEmployementBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDoj)
                    .addComponent(tflDoj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWorkExp)
                    .addComponent(tflWorkExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlEmploymentDetailsLayout = new javax.swing.GroupLayout(pnlEmploymentDetails);
        pnlEmploymentDetails.setLayout(pnlEmploymentDetailsLayout);
        pnlEmploymentDetailsLayout.setHorizontalGroup(
            pnlEmploymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmploymentDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEmploymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEmploymentHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEmployementBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlEmploymentDetailsLayout.setVerticalGroup(
            pnlEmploymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmploymentDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEmploymentHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEmployementBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlProfile.add(pnlEmploymentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 910, 140));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        pnlProfile.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, -1, 30));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlProfile.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 640, -1, 30));

        jTabbedPane1.addTab("Profile ", pnlProfile);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEventActionPerformed
CardLayout layout = (CardLayout) userProcessContainer.getLayout();

        userProcessContainer.add("RequestEventJPanel", new RequestEventJPanel(userProcessContainer, userAccount, enterprise, organization,business));

//        userProcessContainer.add("RequestEventJPanel", new RequestEventJPanel(userProcessContainer, userAccount, enterprise, organization));

        layout.next(userProcessContainer);        

    }//GEN-LAST:event_btnCreateEventActionPerformed

    public void populateWorkspace() {
        DefaultTableModel model = (DefaultTableModel) tblMyWorkSpace.getModel();
        //Organiz
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
    

    private void btnAssigntomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssigntomeActionPerformed
      int selectedRow = tblWorkQEvent.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null,"Please select the row first");
            return;
        }
        int flag=0;
        WorkRequest request = (WorkRequest) tblWorkQEvent.getValueAt(selectedRow, 0);
        if(userAccount.getWorkQueue().getWorkRequestList().size()!=0){
            for(WorkRequest request2 : userAccount.getWorkQueue().getWorkRequestList()){
                if(request2.getWorkRequestID().equals(request.getWorkRequestID())){
                    JOptionPane.showMessageDialog(this, "This request ID is already assigned to you", "Error", JOptionPane.ERROR_MESSAGE);
                    flag=1;
                    return;
                }
                
            }
        }
        
        for(WorkRequest request1:enterprise.getWorkQueue().getWorkRequestList()){
            if(request1.getWorkRequestID().equals(request.getWorkRequestID())){
        request1.setAssignedTo(userAccount);
        request1.setStatus("Pending");
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        populateWorkspace();
        populateWorkRequestFromData();
        
        }}        
    }//GEN-LAST:event_btnAssigntomeActionPerformed

    private void btnProcessRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessRequestActionPerformed

        int selectedRow = tblMyWorkSpace.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        WorkRequest request = (WorkRequest) tblMyWorkSpace.getValueAt(selectedRow, 0);
        if(!(request.getStatus().equalsIgnoreCase("Completed"))){
        request.setStatus("Processing");
        userProcessContainer.add("ProcessEventWRequests", new ProcessEventWRequests(userProcessContainer, request));
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        
        layout.next(userProcessContainer);
        }
        else{
           JOptionPane.showMessageDialog(this, "This request is already processed", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        

    }//GEN-LAST:event_btnProcessRequestActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
       int selectedRow=tblUpComingEvent.getSelectedRow();
        if(selectedRow>=0){
            WorkRequest wr= (WorkRequest)tblUpComingEvent.getValueAt(selectedRow,0);
            txtEventName.setText(wr.getEventName());
            txtLocation.setText(wr.getEventLocation());
            txtBudget.setText(String.valueOf(wr.getBudget()));
            txtPart.setText(String.valueOf(wr.getParticipation()));
            txtDate.setText(String.valueOf(wr.getEventDate()));
        }
        else 
            JOptionPane.showMessageDialog(null,"Please select the row first");
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        plotGraph();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tflCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflCountryActionPerformed

    }//GEN-LAST:event_tflCountryActionPerformed

    private void tflFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflFirstNameActionPerformed

    }//GEN-LAST:event_tflFirstNameActionPerformed

    private void cmbSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSexActionPerformed

    private void tflOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflOrganizationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tflOrganizationActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        changemode(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (validation() == true) {
            userAccount.getUserProfile().setFirstName(tflFirstName.getText());
            userAccount.getUserProfile().setLastName(tflLastName.getText());
            userAccount.getUserProfile().setAge(tflAge.getText());
            userAccount.getUserProfile().setSex(String.valueOf(cmbSex.getSelectedItem()));
            userAccount.getUserProfile().setStreetL1(tflAddress1.getText());
            userAccount.getUserProfile().setStreetL2(tflAddress2.getText());
            userAccount.getUserProfile().setCity(tflCity.getText());
            userAccount.getUserProfile().setState(tflState.getText());
            userAccount.getUserProfile().setCountry(tflCountry.getText());
            userAccount.getUserProfile().setEmailID(tflEmailID.getText());
            userAccount.getUserProfile().setMobileNo(tflMobile.getText());
            userAccount.getUserProfile().setOrganization("FundRaisingManagement");
            userAccount.getUserProfile().setRole("Marketing-Analyst");
            userAccount.getUserProfile().setDOJ(tflDoj.getText());
            userAccount.getUserProfile().setWrkEx(tflWorkExp.getText());
            JOptionPane.showMessageDialog(null, "User Profile Updated Successfully!!");
            btnEdit.setEnabled(true);
            btnSave.setEnabled(false);
            changemode(false);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

public boolean validation() {
        boolean flag = true;

        /* First Name and Last Name Validations */
        if (!(tflFirstName.getText().isEmpty())) {
            if (!(Pattern.matches("[a-zA-Z]+", tflFirstName.getText()))) {
                flag = false;
                JOptionPane.showMessageDialog(null, "Invalid First name");
            }
        }

        if (!(tflLastName.getText().isEmpty()) && (flag == true)) {
            if (!(Pattern.matches("[a-zA-Z]+", tflLastName.getText()))) {
                flag = false;
                JOptionPane.showMessageDialog(null, "Invalid Last Name");
            }

        }

        /* Age Data Validations */
        if (!(tflAge.getText().isEmpty()) && (flag == true)) {
            if (!(Pattern.matches("\\d+", tflAge.getText()))) {
                flag = false;
                JOptionPane.showMessageDialog(null, "Invalid Age. Please enter a valid Age");
            }

        }

        /* EmailID Validations */
        if ((!(tflEmailID.getText().isEmpty())) && (flag == true)) {
            String rPat = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            boolean rvalue = tflEmailID.getText().matches(rPat);
            if (rvalue == false) {
                flag = false;
                JOptionPane.showMessageDialog(null, "Invalid EmailID.Please enter your EmailID");
            }
        }

        /* Mobile Number Validations */
//        if ((!(tflMobile.getText().isEmpty())) && (flag == true)) {
//            if ((!(Pattern.matches("[a-zA-Z]+", tflMobile.getText()))) || (tflMobile.getText().length() != 10)) {
//                flag = false;
//                JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Please enter a valid Mobile Number");
//            }
//        }

        /* Workexperience Validations*/
        if ((!(tflWorkExp.getText().isEmpty())) && (flag == true)) {

            if (!(Pattern.matches("[0-9.]+", tflWorkExp.getText()))) {

                flag = false;
                JOptionPane.showMessageDialog(null, "Invalid Work Experience");
            }
        }

        return flag;
    }
    
    public void plotGraph(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        ArrayList<WorkRequest> home1 = new ArrayList<WorkRequest>();

        for (int i = 0; i < enterprise.getWorkQueue().getWorkRequestList().size(); i++) {
            if(enterprise.getWorkQueue().getWorkRequestList().get(i).getReqByorganizationName().contains("Event")){
            int noOfPeople1 = 0, flag = 0, flag1 = 0;
            for (WorkRequest wr : enterprise.getWorkQueue().getWorkRequestList()) {
               if(wr.getReqByorganizationName().contains("Event")){
                if (wr.getEventName().equals(enterprise.getWorkQueue().getWorkRequestList().get(i).getEventName())) {
                    noOfPeople1 += wr.getParticipation();
                    flag1 = 1;
                }
               }
            }
            if (!home1.isEmpty()) {
                for (WorkRequest h1 : home1) {
                    
                    if (enterprise.getWorkQueue().getWorkRequestList().get(i).getEventName().equals(h1.getEventName())) {
                        flag = 1;
                        break;
                    }}
                
            }
            if (flag == 0 &&  !enterprise.getWorkQueue().getWorkRequestList().get(i).getEventName().equals("")) {
                EventCreateWorkRequest hd=new EventCreateWorkRequest();
                hd.setEventName(enterprise.getWorkQueue().getWorkRequestList().get(i).getEventName());
                if (flag1 == 1) {
                    hd.setParticipation(noOfPeople1);
                } else {
                    hd.setParticipation(enterprise.getWorkQueue().getWorkRequestList().get(i).getParticipation());
                    
                }
                home1.add(hd);
            }
        }}
        for (int i = 0; i < home1.size(); i++) {
            dataSet.setValue(home1.get(i).getParticipation(), "values", home1.get(i).getEventName());
        }

        JFreeChart chart = ChartFactory.createBarChart("Event data", "Event name", "no of volunteers", dataSet, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(Color.YELLOW);
        chart.getTitle().setPaint(Color.red);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartPanel frame = new ChartPanel(chart);
    
        
        frame.setSize(350, 250);
        pnlView.removeAll();
        pnlView.setLayout(new java.awt.BorderLayout());
        pnlView.setLayout(new GridLayout(2, 2));
//      jPanel1.setSize(450,350);
        pnlView.add(frame, BorderLayout.EAST);
        

        pnlView.validate();
       try {

            //ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\user\\AED_LAB\\aed_fall_2016_project_vinoth_punniyamoorthy_001225656\\Barchart1.jpg"), chart, 500, 300);

            ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\MyPC1\\Desktop\\Barchart1.jpg"), chart, 500, 300);

        } catch (IOException e) {
            System.err.println("Problem occurred creating chart.");
        }
        
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TxtDoj;
    private javax.swing.JButton btnAssigntome;
    private javax.swing.JButton btnCreateEvent;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnProcessRequest;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblContactHeader;
    private javax.swing.JPanel pnlContactInfo;
    private javax.swing.JPanel pnlContactInfoBody;
    private javax.swing.JPanel pnlContactinfoHeader;
    private javax.swing.JPanel pnlEmployementBody;
    private javax.swing.JPanel pnlEmploymentDetails;
    private javax.swing.JPanel pnlEmploymentHeader;
    private javax.swing.JPanel pnlMyWorkSpaceBody;
    private javax.swing.JPanel pnlMyworkSpace;
    private javax.swing.JPanel pnlPMyWorkSpaceBody;
    private javax.swing.JPanel pnlPersonalBody;
    private javax.swing.JPanel pnlPersonalBody3;
    private javax.swing.JPanel pnlPersonalDeatails;
    private javax.swing.JPanel pnlPersonalHeader;
    private javax.swing.JPanel pnlPersonalHeader3;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JPanel pnlView;
    private javax.swing.JPanel pnlWorkRequestPool;
    private javax.swing.JTable tblEventHistory;
    private javax.swing.JTable tblMyWorkSpace;
    private javax.swing.JTable tblUpComingEvent;
    private javax.swing.JTable tblWorkQEvent;
    private javax.swing.JTable tblWorkRequest;
    private javax.swing.JTextField tflAddress1;
    private javax.swing.JTextField tflAddress2;
    private javax.swing.JTextField tflAge;
    private javax.swing.JTextField tflCity;
    private javax.swing.JTextField tflCountry;
    private javax.swing.JTextField tflDoj;
    private javax.swing.JTextField tflEmailID;
    private javax.swing.JTextField tflFirstName;
    private javax.swing.JTextField tflLastName;
    private javax.swing.JTextField tflMobile;
    private javax.swing.JTextField tflOrganization;
    private javax.swing.JTextField tflRole;
    private javax.swing.JTextField tflState;
    private javax.swing.JTextField tflWorkExp;
    private javax.swing.JLabel txtAddress1;
    private javax.swing.JLabel txtAge;
    private javax.swing.JTextField txtBudget;
    private javax.swing.JLabel txtCity;
    private javax.swing.JLabel txtCountry;
    private javax.swing.JTextField txtDate;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtEmployementHeader;
    private javax.swing.JTextField txtEventName;
    private javax.swing.JLabel txtFirstName;
    private javax.swing.JLabel txtLastName;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JLabel txtMobile;
    private javax.swing.JLabel txtOrganization;
    private javax.swing.JTextField txtPart;
    private javax.swing.JLabel txtPersonalHeader;
    private javax.swing.JLabel txtPersonalHeader2;
    private javax.swing.JLabel txtPersonalHeader3;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtSex;
    private javax.swing.JLabel txtState;
    private javax.swing.JLabel txtWorkExp;
    private javax.swing.JLabel txtaddress2;
    // End of variables declaration//GEN-END:variables

}
