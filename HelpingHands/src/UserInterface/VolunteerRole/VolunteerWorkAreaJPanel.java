/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.VolunteerRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Event.Event;
import Business.Network.Network;
import Business.Organization.EventManagementOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.Volunteer;
import Business.Organization.VolunteersOrganization;
import Business.UserAccount.UserAccount;
import Business.Volunteer.Volunteer;
import Business.WorkQueue.DataWorkRequest;
import Business.WorkQueue.VolunteerRequest;
import Business.WorkQueue.EventCreateWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
//import UserInterface.EventOrgRole.RequestEventJPanel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author VinothPMoorthy
 */
public class VolunteerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private VolunteersOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EventManagementOrganization org;
    private EcoSystem business;
    private ArrayList<WorkRequest> myRequests;
    private double amtDonated = 0;

    public VolunteerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, VolunteersOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        myRequests = new ArrayList<WorkRequest>();

        org = new EventManagementOrganization();
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o.getName().equalsIgnoreCase("EventManagement Organization")) {
                org = (EventManagementOrganization) o;
            }
        }
        populateUpcoming();
        popOrganizationComboBoxT3();
        populateParticipationHistory();
        txtBName.setText(userAccount.getEmployee().getName());
        txtName.setText(userAccount.getEmployee().getName());
        populateMyRequest();
        populateDonatedAmt();
    }

    public void popOrganizationComboBoxT3() {
        comboOrg.removeAllItems();
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization.getName().contains("Lab")) {
                        comboOrg.addItem(organization);
                    }

                }
            }
        }
    }

    public void populateDonatedAmt() {
        String name = "";
        for (Employee e : organization.getEmployeeDirectory().getEmployeeList()) {
            if (e.getId() == userAccount.getEmployee().getId()) {
                name = e.getName();
                for (Volunteer v : organization.getVolunteerList()) {
                    if (name.equalsIgnoreCase(v.getVolunteerName())) {
                        txtDonatedAmt.setText(String.valueOf(v.getDonatedAmt()));
                    }
                }
            }
        }
    }

    public void populateParticipationHistory() {
        DefaultTableModel model = (DefaultTableModel) tblPartHistory.getModel();
        model.setRowCount(0);
        for (Volunteer v : organization.getVolunteerList()) {
            if (v.getVolunteerName().contains(userAccount.getEmployee().getName())) {
                for (Event e : v.getRegisteredEvent()) {
                    Object[] row = new Object[3];
                    row[0] = e.getEventName();
                    row[1] = e.getEventDate();
                    row[2] = e.getLocation();

                    model.addRow(row);
                }
            }
        }
    }

    public void populateMyRequest() {

        DefaultTableModel model = (DefaultTableModel) tblMyRequest.getModel();

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartHistory = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUpcoming = new javax.swing.JTable();
        btnParticipate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblMyRequest = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtBName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDisease = new javax.swing.JTextField();
        lblOrganization = new javax.swing.JLabel();
        comboOrg = new javax.swing.JComboBox();
        dateDonation = new com.toedter.calendar.JDateChooser();
        comboBlood = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        lblHeight = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        lblWieght = new javax.swing.JLabel();
        lblOperation = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSurgery = new javax.swing.JTextArea();
        lblAllergy = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAllergy = new javax.swing.JTextArea();
        lblAbdominal = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtMedicine = new javax.swing.JTextArea();
        lblMed = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtAbdominal = new javax.swing.JTextArea();
        lblInfection = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtInfection = new javax.swing.JTextArea();
        btnSendDetails = new javax.swing.JButton();
        lblPrevious = new javax.swing.JLabel();
        txtPreviousDoctor = new javax.swing.JTextField();
        lblOrgan = new javax.swing.JLabel();
        txtOrgan = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtDonatedAmt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDonationCause = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAmt = new javax.swing.JTextField();
        btnSubmitMoney = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1000, 1200));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        tblPartHistory.setBackground(new java.awt.Color(153, 153, 153));
        tblPartHistory.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblPartHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event Name", "Date", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPartHistory);
        if (tblPartHistory.getColumnModel().getColumnCount() > 0) {
            tblPartHistory.getColumnModel().getColumn(0).setResizable(false);
            tblPartHistory.getColumnModel().getColumn(1).setResizable(false);
            tblPartHistory.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(799, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Participation History", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblUpcoming.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event Name", "Date", "Location", "Expected Participation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblUpcoming);
        if (tblUpcoming.getColumnModel().getColumnCount() > 0) {
            tblUpcoming.getColumnModel().getColumn(0).setResizable(false);
            tblUpcoming.getColumnModel().getColumn(1).setResizable(false);
            tblUpcoming.getColumnModel().getColumn(2).setResizable(false);
            tblUpcoming.getColumnModel().getColumn(3).setResizable(false);
        }

        btnParticipate.setText("Participate");
        btnParticipate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticipateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Upcoming Registered Event List");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(btnParticipate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnParticipate)
                .addContainerGap(714, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Upcoming Events", jPanel3);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        tblMyRequest.setBackground(new java.awt.Color(153, 153, 153));
        tblMyRequest.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblMyRequest.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(tblMyRequest);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(808, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 954, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Work Request", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name:");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setOpaque(true);
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 77, 153, -1));

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Age:");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setOpaque(true);
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 119, 153, -1));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Blood Group:");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel8.setOpaque(true);
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 162, 153, -1));

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Donation Date:");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel9.setOpaque(true);
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 210, 153, -1));

        txtBName.setEditable(false);
        txtBName.setEnabled(false);
        jPanel6.add(txtBName, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 73, 163, -1));
        jPanel6.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 117, 163, -1));

        btnSubmit.setText("Submit Request");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel6.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(569, 353, -1, -1));

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Any Past Disease:");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel4.setOpaque(true);
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 252, 153, -1));
        jPanel6.add(txtDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 250, 163, -1));

        lblOrganization.setBackground(new java.awt.Color(102, 102, 102));
        lblOrganization.setForeground(new java.awt.Color(255, 255, 255));
        lblOrganization.setText("Assign to organization:");
        lblOrganization.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblOrganization.setOpaque(true);
        jPanel6.add(lblOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 295, -1, -1));

        comboOrg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(comboOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 294, 163, -1));
        jPanel6.add(dateDonation, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 206, 163, -1));

        comboBlood.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-", " " }));
        jPanel6.add(comboBlood, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 161, 163, -1));

        jTabbedPane1.addTab("Blood Donation", jPanel6);

        jPanel5.setPreferredSize(new java.awt.Dimension(836, 800));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(1200, 1200));

        jLabel3.setText("Name:");

        txtName.setEditable(false);
        txtName.setEnabled(false);

        lblHeight.setText("Height:");

        lblWieght.setText("Weight:");

        lblOperation.setText("Provide previous other surgery details, if any:");

        txtSurgery.setColumns(20);
        txtSurgery.setRows(5);
        jScrollPane4.setViewportView(txtSurgery);

        lblAllergy.setText("Provide allergic details, if any:");

        txtAllergy.setColumns(20);
        txtAllergy.setRows(5);
        jScrollPane6.setViewportView(txtAllergy);

        lblAbdominal.setText("Provide previous abdominal surgery details, if any:");

        txtMedicine.setColumns(20);
        txtMedicine.setRows(5);
        jScrollPane7.setViewportView(txtMedicine);

        lblMed.setText("Provide routine medicine details, if any:");

        txtAbdominal.setColumns(20);
        txtAbdominal.setRows(5);
        jScrollPane8.setViewportView(txtAbdominal);

        lblInfection.setText("Provide infection details, if any:");

        txtInfection.setColumns(20);
        txtInfection.setRows(5);
        jScrollPane9.setViewportView(txtInfection);

        btnSendDetails.setText("Send details");
        btnSendDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendDetailsActionPerformed(evt);
            }
        });

        lblPrevious.setText("Previous Doctor Name:");

        lblOrgan.setText("Organ to donate");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(btnSendDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblOrgan)
                            .addComponent(lblOperation)
                            .addComponent(jLabel3)
                            .addComponent(lblHeight)
                            .addComponent(lblWieght)
                            .addComponent(lblInfection)
                            .addComponent(lblMed)
                            .addComponent(lblAbdominal)
                            .addComponent(lblAllergy)
                            .addComponent(lblPrevious))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane9)
                            .addComponent(txtHeight, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWeight, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPreviousDoctor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrgan))))
                .addContainerGap(537, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrgan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrgan))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeight)
                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWieght)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAbdominal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMed, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAllergy, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfection, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreviousDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrevious))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSendDetails)
                .addContainerGap())
        );

        jScrollPane5.setViewportView(jPanel9);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Organ Donation", jPanel5);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Donate For Good");

        jLabel12.setText("Select Donation Method:");

        jButton1.setText("Cash ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Credit Card");
        jButton2.setEnabled(false);

        jLabel13.setText("Money Donated :");

        txtDonatedAmt.setEditable(false);
        txtDonatedAmt.setEnabled(false);

        jLabel15.setText("Donation Cause: ");

        jLabel16.setText("Amount:");

        btnSubmitMoney.setText("Submit");
        btnSubmitMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitMoneyActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("\"The NGO is dedicatedly working towrds the community progres. I am specially intrested by their events organizaed for the creating awareness. NGO is has good task force to take care of the   homeless people and works for their good will \"\n\t\t\t-John Williams");
        jTextArea1.setEnabled(false);
        jScrollPane11.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("\"It's been five years since when I am involved with this NGO and it's a great pleasure to see how NGO is functioning. I request all other donors to take part in it to work towards give back to society. \"\n\n\t\t\t- Dishank Shah");
        jTextArea2.setEnabled(false);
        jScrollPane12.setViewportView(jTextArea2);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Our Donor Comments:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16)
                                .addComponent(jLabel15))))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDonationCause, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(101, 101, 101))
                            .addComponent(btnSubmitMoney))
                        .addGap(319, 319, 319))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(26, 26, 26)
                        .addComponent(txtDonatedAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(32, 32, 32)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel13)
                    .addComponent(txtDonatedAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtDonationCause, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnSubmitMoney)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(44, 44, 44)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Money Donation", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnParticipateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticipateActionPerformed
        int selectedRow = tblUpcoming.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest e = (WorkRequest) tblUpcoming.getValueAt(selectedRow, 0);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("RequestParticipation", new RequestParticipation(userProcessContainer, userAccount, enterprise, organization, e, org));
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "Please Select Row first");
        }
    }//GEN-LAST:event_btnParticipateActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        Date date = new Date();
        String bldGrp = comboBlood.getSelectedItem().toString();
        String diseaseBg = txtDisease.getText();
        Date d = dateDonation.getDate();
        int age = 0;
        if (txtAge.getText().isEmpty() || !(Pattern.matches("^\\d+(\\.\\d+)?", txtAge.getText()))){
            JOptionPane.showMessageDialog(this, "Please enter valid Age", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if( Integer.parseInt(txtAge.getText())<18){
            JOptionPane.showMessageDialog(this, "Age should be greater than 18 to donate the blood", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            age = Integer.parseInt(txtAge.getText());
        }

        if (d == null) {
            JOptionPane.showMessageDialog(this, "Please choose Donation Date", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(d.before(date)){
            JOptionPane.showMessageDialog(this, "Donation date should be future date", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");
        String formattedDate = sdf.format(date);

        VolunteerRequest request = new VolunteerRequest();
        request.setRequestDate(formattedDate);
        request.setRequestedby(userAccount);
        request.setAge(age);
        request.setBloodGroup(bldGrp);
        request.setDonationDate(d);
        request.setDiseaseBg(diseaseBg);
        request.setSender(userAccount);
        request.setOrganizationName(comboOrg.getSelectedItem().toString());
        request.setDescription(txtBName.getText() + "having blood group" + bldGrp + "Wants to donate blood ");
        request.setStatus("Sent");
        request.setReqByorganizationName(organization.getName());
        request.setMyRequestName("Blood Donation");
        //enterprise.getWorkQueue().getWorkRequestList().add(request);

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof VolunteersOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {
//            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
            myRequests.add(request);
            enterprise.getWorkQueue().getWorkRequestList().add(request);

            JOptionPane.showMessageDialog(null, "Request Sent Successfully");
        }
        populateMyRequest();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnSendDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendDetailsActionPerformed
        VolunteerRequest request = new VolunteerRequest();

        if(txtOrgan.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Please enter Organ Name", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        if(txtHeight.getText().isEmpty()||!( Pattern.matches("^\\d+(\\.\\d+)?", txtHeight.getText()))){
        JOptionPane.showMessageDialog(this, "Please enter valid Height", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        if(txtHeight.getText().isEmpty()|| !(Pattern.matches("^\\d+(\\.\\d+)?", txtWeight.getText()))){
        JOptionPane.showMessageDialog(this, "Please enter valid Weight", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        if(txtAbdominal.getText().isEmpty()||txtAllergy.getText().isEmpty()||txtInfection.getText().isEmpty()||
                txtMedicine.getText().isEmpty()||txtSurgery.getText().isEmpty()||txtPreviousDoctor.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Please provide all the details", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");
        String formattedDate = sdf.format(date);
        request.setRequestDate(formattedDate);
        request.setRequestedby(userAccount);
        request.setSender(userAccount);
        request.setOrganizationName("Doctor Organization");
        request.setStatus("Sent");
        request.setReqByorganizationName(organization.getName());
       // txtName.setText(userAccount.getEmployee().getName());
        request.setOrgan(txtOrgan.getText());
        request.setHeight(txtHeight.getText());
        request.setWeight(txtWeight.getText());
        String bmi = String.valueOf(((Integer.parseInt(txtWeight.getText()) * 703) / Integer.parseInt(txtHeight.getText()) * Integer.parseInt(txtHeight.getText())));
        request.setBMI(bmi);
        request.setDescription(txtBName.getText() + " wants to donate " + txtOrgan.getText());
        request.setAbdominalSurgery(txtAbdominal.getText());
        request.setRoutineMedicines(txtMedicine.getText());
        request.setAllergies(txtAllergy.getText());
        request.setOperation(txtSurgery.getText());
        request.setInfection(txtInfection.getText());
        request.setPreviousDoctor(txtPreviousDoctor.getText());

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof VolunteersOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {
//            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
            myRequests.add(request);
            enterprise.getWorkQueue().getWorkRequestList().add(request);

            JOptionPane.showMessageDialog(null, "Request Sent Successfully");
        }
        populateMyRequest();
    }//GEN-LAST:event_btnSendDetailsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSubmitMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitMoneyActionPerformed
        String name = "";
        if(txtDonationCause.getText().isEmpty()|| !(Pattern.matches("[a-zA-Z]+", txtDonationCause.getText()))){
            JOptionPane.showMessageDialog(this, "Please enter the valid Donation cause", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(txtAmt.getText().isEmpty()||!(Pattern.matches("^\\d+(\\.\\d+)?",txtAmt.getText()))){
                JOptionPane.showMessageDialog(this, "Please enter the valid Donation Amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (Employee e : organization.getEmployeeDirectory().getEmployeeList()) {
            if (e.getId() == userAccount.getEmployee().getId()) {
                name = e.getName();
                for (Volunteer v : organization.getVolunteerList()) {
                    if (name.equalsIgnoreCase(v.getVolunteerName())) {
                        amtDonated = v.getDonatedAmt();
                        amtDonated += Double.parseDouble(txtAmt.getText());
                        v.setDonatedAmt(amtDonated);
                    }
                }

            }
        }

        VolunteerRequest request = new VolunteerRequest();
        Date date = new Date();
        request.setRequestedby(userAccount);
        request.setRequestDate(String.valueOf(date));
        request.setRequestedOn(date);
        request.setSender(userAccount);
        request.setDebit(0.0);
        request.setNarration("Donation-Fundraising");
        request.setChequeNo("Cash Payment Recorded");
        request.setOrganizationName("Finance Organization");
        request.setDescription(userAccount.getEmployee().getName() + " Wants to Donate " + txtAmt.getText() + " for " + txtDonationCause.getText());
        request.setStatus("Sent");
        request.setReqByorganizationName(organization.getName());
        request.setCredit(Double.parseDouble(txtAmt.getText()));
        txtDonatedAmt.setText(String.valueOf(amtDonated));
        enterprise.getWorkQueue().getWorkRequestList().add(request);
        JOptionPane.showMessageDialog(null, "Amount Doantion Request Sent Successfully! ");
        populateMyRequest();

    }//GEN-LAST:event_btnSubmitMoneyActionPerformed

    public void populateUpcoming() {
        DefaultTableModel model = (DefaultTableModel) tblUpcoming.getModel();
        Date today = new Date();
        model.setRowCount(0);
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o.getName().equalsIgnoreCase("EventManagement Organization")) {
                org = (EventManagementOrganization) o;
            }
        }

        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            if (request.getReqByorganizationName().contains("Event") && request.getApprovalStatus().contains("Approve")){

            if (request.getEventDate().after(today)) {
                Object[] row = new Object[4];
                row[0] = request.getEventName();
                row[1] = request.getEventDate();
                row[2] = request.getEventLocation();
                row[3] = request.getNoOfPpl();

                model.addRow(row);
            }
        }}

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnParticipate;
    private javax.swing.JButton btnSendDetails;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmitMoney;
    private javax.swing.JComboBox comboBlood;
    private javax.swing.JComboBox comboOrg;
    private com.toedter.calendar.JDateChooser dateDonation;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblAbdominal;
    private javax.swing.JLabel lblAllergy;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblInfection;
    private javax.swing.JLabel lblMed;
    private javax.swing.JLabel lblOperation;
    private javax.swing.JLabel lblOrgan;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblPrevious;
    private javax.swing.JLabel lblWieght;
    private javax.swing.JTable tblMyRequest;
    private javax.swing.JTable tblPartHistory;
    private javax.swing.JTable tblUpcoming;
    private javax.swing.JTextArea txtAbdominal;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextArea txtAllergy;
    private javax.swing.JTextField txtAmt;
    private javax.swing.JTextField txtBName;
    private javax.swing.JTextField txtDisease;
    private javax.swing.JTextField txtDonatedAmt;
    private javax.swing.JTextField txtDonationCause;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextArea txtInfection;
    private javax.swing.JTextArea txtMedicine;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrgan;
    private javax.swing.JTextField txtPreviousDoctor;
    private javax.swing.JTextArea txtSurgery;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
