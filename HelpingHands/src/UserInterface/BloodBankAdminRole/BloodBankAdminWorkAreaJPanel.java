/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BloodBankAdminRole;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.BloodBankAdminOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.ReceptionOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class BloodBankAdminWorkAreaJPanel extends javax.swing.JPanel {

     private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private Organization organization;

    public BloodBankAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, BloodBankAdminOrganization bloodBankAdminOrganization, Enterprise enterprise) {
         initComponents();
          this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        this.organization = bloodBankAdminOrganization;
        
        populateOrgCombo();
        populateOrgTable();
    }

        private void populateOrgCombo() {
        comboOrgType.removeAllItems();
        for (Organization.Type type : Organization.Type.values()) {
            if (type.getValue().equals(Organization.Type.Reception.getValue())
                    || type.getValue().equals(Organization.Type.Lab.getValue())) {
                comboOrgType.addItem(type);
            }
        }
    }
        
        private void populateOrgTable() {
        DefaultTableModel model = (DefaultTableModel) tblAddOrg.getModel();
        model.setRowCount(0);
         
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();                    
            row[1] = organization.getName();
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainData = new javax.swing.JTabbedPane();
        pnlManageOrg = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAddOrg = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        comboOrgType = new javax.swing.JComboBox();
        btnAddOrg = new javax.swing.JButton();
        pnlHeader1 = new javax.swing.JPanel();
        txtInfo1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        cmbRoleT3 = new javax.swing.JComboBox();
        cmbEmpT3 = new javax.swing.JComboBox();
        comboUserOrg = new javax.swing.JComboBox();
        createUserJButton = new javax.swing.JButton();
        pnlHeader2 = new javax.swing.JPanel();
        txtInfo2 = new javax.swing.JLabel();
        txtPwd = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        pnlTaxFinancial = new javax.swing.JPanel();
        pnlTaxFinancialBody = new javax.swing.JPanel();
        txtBankAcc = new javax.swing.JLabel();
        txtFiscalYear = new javax.swing.JLabel();
        tflName = new javax.swing.JTextField();
        tflFiscalYear = new javax.swing.JTextField();
        txtName = new javax.swing.JLabel();
        tflBankAcc = new javax.swing.JTextField();
        txtTaxPayerID = new javax.swing.JLabel();
        tflTaxPayerId = new javax.swing.JTextField();
        txtTaxRegNumber = new javax.swing.JLabel();
        tflTaxRegNumber = new javax.swing.JTextField();
        txtAnnual = new javax.swing.JLabel();
        tflAnnualRevenue = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        pnlTaxFinancialHeader = new javax.swing.JPanel();
        txtPersonalHeader1 = new javax.swing.JLabel();
        pnlHomePage = new javax.swing.JPanel();
        btnAddEmp = new javax.swing.JButton();
        txtEmpName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboEmpOrg = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        pnlHeader = new javax.swing.JPanel();
        txtInfo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMainData.setBackground(new java.awt.Color(255, 255, 255));

        pnlManageOrg.setBackground(new java.awt.Color(255, 255, 255));
        pnlManageOrg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        pnlManageOrg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAddOrg.setBackground(new java.awt.Color(153, 153, 153));
        tblAddOrg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblAddOrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAddOrg);

        pnlManageOrg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 25, 1183, 92));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Choose Organization");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);
        pnlManageOrg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 175, 206, -1));

        comboOrgType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboOrgType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrgTypeActionPerformed(evt);
            }
        });
        pnlManageOrg.add(comboOrgType, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 174, 172, -1));

        btnAddOrg.setText("Add Organization");
        btnAddOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrgActionPerformed(evt);
            }
        });
        pnlManageOrg.add(btnAddOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 173, -1, -1));

        pnlHeader1.setBackground(new java.awt.Color(102, 102, 102));
        pnlHeader1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtInfo1.setForeground(new java.awt.Color(255, 255, 255));
        txtInfo1.setText("Add Organization -  BloodBank Enterprise");

        javax.swing.GroupLayout pnlHeader1Layout = new javax.swing.GroupLayout(pnlHeader1);
        pnlHeader1.setLayout(pnlHeader1Layout);
        pnlHeader1Layout.setHorizontalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(txtInfo1)
                .addContainerGap(667, Short.MAX_VALUE))
        );
        pnlHeader1Layout.setVerticalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtInfo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlManageOrg.add(pnlHeader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 122, -1, -1));

        pnlMainData.addTab("Manage Organization", pnlManageOrg);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUser.setBackground(new java.awt.Color(153, 153, 153));
        tblUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblUser);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, 1183, 105));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Organization");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 184, 121, -1));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Employee");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 184, 133, -1));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Role");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 223, 133, -1));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("User Name");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 223, 121, -1));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Password");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 255, 121, -1));

        txtUserName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 223, 203, -1));

        cmbRoleT3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbRoleT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 222, 223, -1));

        cmbEmpT3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbEmpT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 183, 223, -1));

        comboUserOrg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboUserOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUserOrgActionPerformed(evt);
            }
        });
        jPanel1.add(comboUserOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 183, 203, -1));

        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 295, 117, -1));

        pnlHeader2.setBackground(new java.awt.Color(102, 102, 102));
        pnlHeader2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtInfo2.setForeground(new java.awt.Color(255, 255, 255));
        txtInfo2.setText("Manage User -  BloodBank Enterprise");

        javax.swing.GroupLayout pnlHeader2Layout = new javax.swing.GroupLayout(pnlHeader2);
        pnlHeader2.setLayout(pnlHeader2Layout);
        pnlHeader2Layout.setHorizontalGroup(
            pnlHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader2Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(txtInfo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHeader2Layout.setVerticalGroup(
            pnlHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtInfo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlHeader2, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 137, 1183, -1));

        txtPwd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel1.add(txtPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 255, 203, -1));

        pnlMainData.addTab("Manage User Account", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTaxFinancial.setBackground(new java.awt.Color(255, 255, 255));
        pnlTaxFinancial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlTaxFinancialBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtBankAcc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtBankAcc.setText("Bank Acc No");
        txtBankAcc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFiscalYear.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtFiscalYear.setText("Fiscal Year");
        txtFiscalYear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tflName.setEditable(false);

        tflFiscalYear.setEditable(false);

        txtName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtName.setText("EnterPrise Name");
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTaxPayerID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTaxPayerID.setText("TaxPayerID");
        txtTaxPayerID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTaxRegNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTaxRegNumber.setText("Tax Reg Number ");
        txtTaxRegNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtAnnual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtAnnual.setText("Annual Cash Inflow");
        txtAnnual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSave.setText("Save ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTaxFinancialBodyLayout = new javax.swing.GroupLayout(pnlTaxFinancialBody);
        pnlTaxFinancialBody.setLayout(pnlTaxFinancialBodyLayout);
        pnlTaxFinancialBodyLayout.setHorizontalGroup(
            pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFinancialBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtBankAcc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflName, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tflBankAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFiscalYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAnnual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tflAnnualRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(tflFiscalYear))
                .addGap(128, 128, 128)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTaxPayerID, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaxRegNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tflTaxRegNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(tflTaxPayerId, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(pnlTaxFinancialBodyLayout.createSequentialGroup()
                .addGap(533, 533, 533)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTaxFinancialBodyLayout.setVerticalGroup(
            pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFinancialBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName)
                    .addComponent(tflName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaxPayerID)
                    .addComponent(tflTaxPayerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnnual)
                    .addComponent(tflAnnualRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tflBankAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFiscalYear)
                        .addComponent(tflFiscalYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBankAcc)
                        .addComponent(tflTaxRegNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTaxRegNumber)))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlTaxFinancialHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlTaxFinancialHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPersonalHeader1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPersonalHeader1.setText("Manage EnterPrise Information  ");

        javax.swing.GroupLayout pnlTaxFinancialHeaderLayout = new javax.swing.GroupLayout(pnlTaxFinancialHeader);
        pnlTaxFinancialHeader.setLayout(pnlTaxFinancialHeaderLayout);
        pnlTaxFinancialHeaderLayout.setHorizontalGroup(
            pnlTaxFinancialHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFinancialHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtPersonalHeader1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTaxFinancialHeaderLayout.setVerticalGroup(
            pnlTaxFinancialHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPersonalHeader1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTaxFinancialLayout = new javax.swing.GroupLayout(pnlTaxFinancial);
        pnlTaxFinancial.setLayout(pnlTaxFinancialLayout);
        pnlTaxFinancialLayout.setHorizontalGroup(
            pnlTaxFinancialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFinancialLayout.createSequentialGroup()
                .addGroup(pnlTaxFinancialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTaxFinancialHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTaxFinancialBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTaxFinancialLayout.setVerticalGroup(
            pnlTaxFinancialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFinancialLayout.createSequentialGroup()
                .addComponent(pnlTaxFinancialHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTaxFinancialBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.add(pnlTaxFinancial, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, -1, -1));

        pnlMainData.addTab("Manage Information", jPanel2);

        pnlHomePage.setBackground(new java.awt.Color(255, 255, 255));
        pnlHomePage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        pnlHomePage.setPreferredSize(new java.awt.Dimension(702, 800));
        pnlHomePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddEmp.setText("Create Employee");
        btnAddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmpActionPerformed(evt);
            }
        });
        pnlHomePage.add(btnAddEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 329, -1, -1));
        pnlHomePage.add(txtEmpName, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 285, 200, -1));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Employee Name");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);
        pnlHomePage.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 287, 186, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Choose Organization ");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel3.setOpaque(true);
        pnlHomePage.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 241, 186, -1));

        comboEmpOrg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlHomePage.add(comboEmpOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 240, 208, -1));

        tblEmployee.setBackground(new java.awt.Color(153, 153, 153));
        tblEmployee.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Employeed Identification Number", "Employee Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        pnlHomePage.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 26, 806, 92));

        pnlHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtInfo.setForeground(new java.awt.Color(255, 255, 255));
        txtInfo.setText("Create Employee -  BloodBank Enterprise");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(txtInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHomePage.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 153, 1189, -1));

        pnlMainData.addTab("Manage Employee", pnlHomePage);

        add(pnlMainData, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 588));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrgActionPerformed
        Type type = (Type) comboOrgType.getSelectedItem();
        if (comboOrgType.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select the Organization name", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (enterprise.getOrganizationDirectory().getOrganizationList().size() != 0) {
                int flag = 0;
                for (Organization org1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    String s1 = type.getValue();
                    String s2 = org1.getName();
                    if (s1.equals(s2)) {
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    enterprise.getOrganizationDirectory().createOrganization(type);
                    populateOrgTable();
                    populateOrganizationEmpComboBox();
                    popOrganizationComboBoxT3();
                } else {
                    JOptionPane.showMessageDialog(this, comboOrgType.getSelectedItem().toString() + "Organization already exists", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                enterprise.getOrganizationDirectory().createOrganization(type);

            }
        }

        populateOrgTable();
        populateOrganizationEmpComboBox();
        popOrganizationComboBoxT3();
    }//GEN-LAST:event_btnAddOrgActionPerformed

      public void populateOrganizationEmpComboBox() {
        comboEmpOrg.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            comboEmpOrg.addItem(organization);
        }
        populateTable();
    }
          public void popOrganizationComboBoxT3() {
        comboUserOrg.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            comboUserOrg.addItem(organization);
        }
    }
           private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        model.setRowCount(0);
        /* Fill Table with Organization data */
        if (enterprise != null) {
            for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                for (Employee employeefin : org.getEmployeeDirectory().getEmployeeList()) {
                    Object[] rowfin = new Object[2];
                    rowfin[0] = employeefin.getId();
                    rowfin[1] = employeefin.getName();
                    model.addRow(rowfin);
                }
            }
        }

    }
    private void btnAddEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmpActionPerformed

        String name = null;
        String str = String.valueOf(comboEmpOrg.getSelectedItem());
        if (str.equalsIgnoreCase("null")) {
            JOptionPane.showMessageDialog(this, "Please select the organization for which employee has to be added.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtEmpName.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Please enter the employee name.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            /* Fill employees to Finance Organization under NGO Enterprise*/
            if (str.equals("Lab Organization")) {
                organization = (LabOrganization) comboEmpOrg.getSelectedItem();
                name = txtEmpName.getText();
                organization.getEmployeeDirectory().createEmployee(name);
            } else /* Fill employees to EventManagement Organization under NGO Enterprise*/ if (str.equals("Reception Organization")) {
                organization = (ReceptionOrganization) comboEmpOrg.getSelectedItem();
                name = txtEmpName.getText();
                organization.getEmployeeDirectory().createEmployee(name);
            } else {
                JOptionPane.showMessageDialog(null,"Invalid Organization");
            } 
        }
        populateTable();
        popOrganizationComboBoxT3();
    }//GEN-LAST:event_btnAddEmpActionPerformed

    private void comboUserOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUserOrgActionPerformed
        Organization organization = (Organization) comboUserOrg.getSelectedItem();
        if (organization != null) {
            populateEmployeeComboBoxT3(organization);
            populateRoleComboBoxT3(organization);
        }
    }//GEN-LAST:event_comboUserOrgActionPerformed
    public void populateEmployeeComboBoxT3(Organization organization) {
        cmbEmpT3.removeAllItems();
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            cmbEmpT3.addItem(employee);
        }
    }
    
      private void populateRoleComboBoxT3(Organization organization) {
        cmbRoleT3.removeAllItems();
        for (Role role : organization.getSupportedRole()) {
            cmbRoleT3.addItem(role);
        }
    }
    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed

        if (txtUserName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter username", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtPwd.getPassword().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter password", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (comboUserOrg.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select the organization name", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (cmbEmpT3.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select the employee name", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (cmbRoleT3.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select the role", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String userName = txtUserName.getText();
            char[] passwordCharArray = txtPwd.getPassword();
            String password = String.valueOf(passwordCharArray);
            Organization organization = (Organization) comboUserOrg.getSelectedItem();

            Employee employee = (Employee) cmbEmpT3.getSelectedItem();
            Role role = (Role) cmbRoleT3.getSelectedItem();
            int flag = 0;
            for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                for (UserAccount account : org.getUserAccountDirectory().getUserAccountList()) {
                    String user = txtUserName.getText();
                    String user1 = account.getUsername();
                    if (user.equals(user1)) {
                        flag = 1;
                    }
                }
            }
            if (flag == 1) {
                JOptionPane.showMessageDialog(this, "Username already exists. Please enter the different username", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                popDataT3();

            }

        }

    }//GEN-LAST:event_createUserJButtonActionPerformed

    public void popDataT3() {

        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        model.setRowCount(0);

        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                if (ua.getRole().toString().equals("Business.Role.NGOAdminRole")) {

                } else {
                    Object row[] = new Object[2];
                    row[0] = ua;
                    row[1] = ua.getRole();
                    ((DefaultTableModel) tblUser.getModel()).addRow(row);
                }
            }
        }
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        account.getEnterpriseinfo().seteName(enterprise.getName());
        account.getEnterpriseinfo().setFiscalYear("2016");
        account.getEnterpriseinfo().setBaccountNo(tflBankAcc.getText());
        account.getEnterpriseinfo().setTaxpayerID(tflTaxPayerId.getText());
        account.getEnterpriseinfo().setTaxRegistrationNo(tflTaxRegNumber.getText());
        account.getEnterpriseinfo().setCashflow(tflAnnualRevenue.getText());
    }//GEN-LAST:event_btnSaveActionPerformed

    private void comboOrgTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrgTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboOrgTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmp;
    private javax.swing.JButton btnAddOrg;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbEmpT3;
    private javax.swing.JComboBox cmbRoleT3;
    private javax.swing.JComboBox comboEmpOrg;
    private javax.swing.JComboBox comboOrgType;
    private javax.swing.JComboBox comboUserOrg;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlHeader1;
    private javax.swing.JPanel pnlHeader2;
    private javax.swing.JPanel pnlHomePage;
    private javax.swing.JTabbedPane pnlMainData;
    private javax.swing.JPanel pnlManageOrg;
    private javax.swing.JPanel pnlTaxFinancial;
    private javax.swing.JPanel pnlTaxFinancialBody;
    private javax.swing.JPanel pnlTaxFinancialHeader;
    private javax.swing.JTable tblAddOrg;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField tflAnnualRevenue;
    private javax.swing.JTextField tflBankAcc;
    private javax.swing.JTextField tflFiscalYear;
    private javax.swing.JTextField tflName;
    private javax.swing.JTextField tflTaxPayerId;
    private javax.swing.JTextField tflTaxRegNumber;
    private javax.swing.JLabel txtAnnual;
    private javax.swing.JLabel txtBankAcc;
    private javax.swing.JTextField txtEmpName;
    private javax.swing.JLabel txtFiscalYear;
    private javax.swing.JLabel txtInfo;
    private javax.swing.JLabel txtInfo1;
    private javax.swing.JLabel txtInfo2;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtPersonalHeader1;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JLabel txtTaxPayerID;
    private javax.swing.JLabel txtTaxRegNumber;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
