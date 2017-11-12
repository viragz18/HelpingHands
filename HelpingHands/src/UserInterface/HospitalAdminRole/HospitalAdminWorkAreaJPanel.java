package UserInterface.HospitalAdminRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.DatateamOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.EventManagementOrganization;
import Business.Organization.FinanceOrganization;
import Business.Organization.FundRaisingOrganization;
import Business.Organization.HospitalAdminAssistantOrganization;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import Business.Organization.VolunteersOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class HospitalAdminWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private Organization organization;
    private EcoSystem business;

    public HospitalAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        
        this.business=business;
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        this.organization = organization;

        /* Fill entries for Manage Organization */
        populateTableT2();
        populateComboT2();

        /* Fill entries for Manage Employees */
        populateOrganizationEmpComboBox();
        populateTable();


        /* Fill entries for Manage Users */
        popOrganizationComboBoxT3();
        popDataT3();

     

    }



    public void popOrganizationComboBoxT3() {
        cmbOrgT3.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            cmbOrgT3.addItem(organization);
        }
    }

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

    public void popDataT3() {

        DefaultTableModel model = (DefaultTableModel) tblUserT3.getModel();
        model.setRowCount(0);

        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                if (ua.getRole().toString().equals("Business.Role.NGOAdminRole")) {

                } else {
                    Object row[] = new Object[2];
                    row[0] = ua;
                    row[1] = ua.getRole();
                    ((DefaultTableModel) tblUserT3.getModel()).addRow(row);
                }
            }
        }
    }

    private void populateComboT2() {
        cmbOrgT2.removeAllItems();
       
        for (Organization.Type type : Organization.Type.values()) {
            if (type.getValue().equals(Organization.Type.Doctor.getValue())
                     || type.getValue().equals(Organization.Type.HospitalAdminAssistant.getValue())) {
                cmbOrgT2.addItem(type);
            }
        }
    }

    private void populateTableT2() {
        DefaultTableModel model = (DefaultTableModel) tblOrgT2.getModel();
        model.setRowCount(0);
         
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();                    
            row[1] = organization.getName();
            model.addRow(row);
        }
    }

    public void populateOrganizationEmpComboBox() {
        organizationEmpJComboBox.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationEmpJComboBox.addItem(organization);
        }
        populateTable();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainData = new javax.swing.JTabbedPane();
        pnlManageOrg = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrgT2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbOrgT2 = new javax.swing.JComboBox();
        btnAddOrg = new javax.swing.JButton();
        pnlHeader1 = new javax.swing.JPanel();
        txtInfo1 = new javax.swing.JLabel();
        pnlHomePage = new javax.swing.JPanel();
        btnAddEmp = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        pnlHeader = new javax.swing.JPanel();
        txtInfo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUserT3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tflEmpName = new javax.swing.JTextField();
        cmbRoleT3 = new javax.swing.JComboBox();
        cmbEmpT3 = new javax.swing.JComboBox();
        cmbOrgT3 = new javax.swing.JComboBox();
        createUserJButton = new javax.swing.JButton();
        pnlHeader2 = new javax.swing.JPanel();
        txtInfo2 = new javax.swing.JLabel();
        tflEmpPassword = new javax.swing.JPasswordField();
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

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMainData.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlManageOrg.setBackground(new java.awt.Color(255, 255, 255));
        pnlManageOrg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        tblOrgT2.setBackground(new java.awt.Color(204, 204, 204));
        tblOrgT2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblOrgT2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblOrgT2);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Choose Organization");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);

        cmbOrgT2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddOrg.setText("Add Organization");
        btnAddOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrgActionPerformed(evt);
            }
        });

        pnlHeader1.setBackground(new java.awt.Color(102, 102, 102));
        pnlHeader1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtInfo1.setForeground(new java.awt.Color(255, 255, 255));
        txtInfo1.setText("Add Organization -  NGO Enterprise");

        javax.swing.GroupLayout pnlHeader1Layout = new javax.swing.GroupLayout(pnlHeader1);
        pnlHeader1.setLayout(pnlHeader1Layout);
        pnlHeader1Layout.setHorizontalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(txtInfo1)
                .addContainerGap(413, Short.MAX_VALUE))
        );
        pnlHeader1Layout.setVerticalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtInfo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlManageOrgLayout = new javax.swing.GroupLayout(pnlManageOrg);
        pnlManageOrg.setLayout(pnlManageOrgLayout);
        pnlManageOrgLayout.setHorizontalGroup(
            pnlManageOrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageOrgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(pnlManageOrgLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbOrgT2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnAddOrg)
                .addContainerGap(337, Short.MAX_VALUE))
            .addGroup(pnlManageOrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageOrgLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlManageOrgLayout.setVerticalGroup(
            pnlManageOrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageOrgLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(pnlManageOrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbOrgT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddOrg))
                .addContainerGap(396, Short.MAX_VALUE))
            .addGroup(pnlManageOrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlManageOrgLayout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addComponent(pnlHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(442, Short.MAX_VALUE)))
        );

        pnlMainData.addTab("Manage Organization", pnlManageOrg);

        pnlHomePage.setBackground(new java.awt.Color(255, 255, 255));
        pnlHomePage.setPreferredSize(new java.awt.Dimension(702, 800));

        btnAddEmp.setText("Create Employee");
        btnAddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmpActionPerformed(evt);
            }
        });

        jLabel2.setText("Employee Name");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);

        jLabel3.setText("Choose Organization ");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel3.setOpaque(true);

        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        organizationJTable.setBackground(new java.awt.Color(204, 204, 204));
        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(organizationJTable);

        pnlHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtInfo.setForeground(new java.awt.Color(255, 255, 255));
        txtInfo.setText("Create Employee -  NGO Enterprise");

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

        javax.swing.GroupLayout pnlHomePageLayout = new javax.swing.GroupLayout(pnlHomePage);
        pnlHomePage.setLayout(pnlHomePageLayout);
        pnlHomePageLayout.setHorizontalGroup(
            pnlHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomePageLayout.createSequentialGroup()
                .addGroup(pnlHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlHomePageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHomePageLayout.createSequentialGroup()
                                .addGroup(pnlHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHomePageLayout.createSequentialGroup()
                                        .addGap(277, 277, 277)
                                        .addComponent(btnAddEmp))
                                    .addGroup(pnlHomePageLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 217, Short.MAX_VALUE))
                            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlHomePageLayout.setVerticalGroup(
            pnlHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomePageLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(pnlHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddEmp)
                .addGap(0, 272, Short.MAX_VALUE))
        );

        pnlMainData.addTab("Manage Employee", pnlHomePage);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblUserT3.setBackground(new java.awt.Color(204, 204, 204));
        tblUserT3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblUserT3);

        jLabel5.setText("Organization");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.setOpaque(true);

        jLabel4.setText("Employee");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel4.setOpaque(true);

        jLabel6.setText("Role");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setOpaque(true);

        jLabel7.setText("User Name");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setOpaque(true);

        jLabel8.setText("Password");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel8.setOpaque(true);

        cmbRoleT3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEmpT3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEmpT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmpT3ActionPerformed(evt);
            }
        });

        cmbOrgT3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOrgT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrgT3ActionPerformed(evt);
            }
        });

        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });

        pnlHeader2.setBackground(new java.awt.Color(102, 102, 102));
        pnlHeader2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtInfo2.setForeground(new java.awt.Color(255, 255, 255));
        txtInfo2.setText("Manage User -  NGO Enterprise");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbOrgT3, 0, 151, Short.MAX_VALUE)
                            .addComponent(cmbEmpT3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRoleT3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tflEmpName, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(tflEmpPassword))
                        .addGap(145, 145, 145)
                        .addComponent(createUserJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(pnlHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbOrgT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbRoleT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbEmpT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tflEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tflEmpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(createUserJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(490, Short.MAX_VALUE)))
        );

        pnlMainData.addTab("Manage User Account", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pnlTaxFinancial.setBackground(new java.awt.Color(255, 255, 255));
        pnlTaxFinancial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlTaxFinancialBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlTaxFinancialBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        txtBankAcc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtBankAcc.setText("Bank Acc No");
        txtBankAcc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBankAcc.setOpaque(true);

        txtFiscalYear.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtFiscalYear.setText("Fiscal Year");
        txtFiscalYear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFiscalYear.setOpaque(true);

        tflName.setEditable(false);

        tflFiscalYear.setEditable(false);

        txtName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtName.setText("EnterPrise Name");
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtName.setOpaque(true);

        txtTaxPayerID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTaxPayerID.setText("TaxPayerID");
        txtTaxPayerID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTaxPayerID.setOpaque(true);

        txtTaxRegNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTaxRegNumber.setText("Tax Reg Number ");
        txtTaxRegNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTaxRegNumber.setOpaque(true);

        txtAnnual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtAnnual.setText("Annual Cash Inflow");
        txtAnnual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAnnual.setOpaque(true);

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
                    .addGroup(pnlTaxFinancialBodyLayout.createSequentialGroup()
                        .addComponent(tflName, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFiscalYear, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tflFiscalYear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTaxPayerID, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tflTaxPayerId, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTaxFinancialBodyLayout.createSequentialGroup()
                        .addComponent(tflBankAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTaxRegNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tflTaxRegNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnnual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(tflAnnualRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTaxFinancialBodyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(359, 359, 359))
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
                    .addComponent(txtFiscalYear)
                    .addComponent(tflFiscalYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tflBankAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTaxRegNumber)
                        .addComponent(tflTaxRegNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAnnual)
                        .addComponent(tflAnnualRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBankAcc))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTaxFinancialHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlTaxFinancialHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPersonalHeader1.setForeground(new java.awt.Color(255, 255, 255));
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
                    .addComponent(pnlTaxFinancialBody, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTaxFinancialLayout.setVerticalGroup(
            pnlTaxFinancialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFinancialLayout.createSequentialGroup()
                .addComponent(pnlTaxFinancialHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTaxFinancialBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTaxFinancial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTaxFinancial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(411, Short.MAX_VALUE))
        );

        pnlMainData.addTab("Manage Information", jPanel2);

        add(pnlMainData, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 653));
    }// </editor-fold>//GEN-END:initComponents

// Need to change the hard coded year value 
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        account.getEnterpriseinfo().seteName(enterprise.getName());
        account.getEnterpriseinfo().setFiscalYear("2016");
        account.getEnterpriseinfo().setBaccountNo(tflBankAcc.getText());
        account.getEnterpriseinfo().setTaxpayerID(tflTaxPayerId.getText());
        account.getEnterpriseinfo().setTaxRegistrationNo(tflTaxRegNumber.getText());
        account.getEnterpriseinfo().setCashflow(tflAnnualRevenue.getText());
    }//GEN-LAST:event_btnSaveActionPerformed

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed

        if (tflEmpName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter username", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (tflEmpPassword.getPassword().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter password", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (cmbOrgT3.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select the organization name", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (cmbEmpT3.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select the employee name", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (cmbRoleT3.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select the role", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String userName = tflEmpName.getText();
            char[] passwordCharArray = tflEmpPassword.getPassword();
            String password = String.valueOf(passwordCharArray);
            Organization organization = (Organization) cmbOrgT3.getSelectedItem();

            Employee employee = (Employee) cmbEmpT3.getSelectedItem();
            Role role = (Role) cmbRoleT3.getSelectedItem();
            int flag = 0;
            for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                for (UserAccount account : org.getUserAccountDirectory().getUserAccountList()) {
                    String user = tflEmpName.getText();
                    String user1 = account.getUsername();
                    if (user.equals(user1)) {
                        flag = 1;
                    }

                }
            }
            if (flag == 1) {
                JOptionPane.showMessageDialog(this, "Username already exists. Please enter the different username", "Error", JOptionPane.ERROR_MESSAGE);
            }

            else {
                organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                popDataT3();

            }

        }

    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void cmbOrgT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrgT3ActionPerformed
        Organization organization = (Organization) cmbOrgT3.getSelectedItem();
        if (organization != null) {
            populateEmployeeComboBoxT3(organization);
            populateRoleComboBoxT3(organization);
        }
    }//GEN-LAST:event_cmbOrgT3ActionPerformed

    private void cmbEmpT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmpT3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEmpT3ActionPerformed

    private void btnAddEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmpActionPerformed

        String name = null;
        String str = String.valueOf(organizationEmpJComboBox.getSelectedItem());
        if (str.equalsIgnoreCase("null")) {
            JOptionPane.showMessageDialog(this, "Please select the organization for which employee has to be added.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (nameJTextField.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Please enter the employee name.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            /* Fill employees to Doctor Organization under Hospital Enterprise*/
            if (str.equals("Doctor Organization")) {
                organization = (DoctorOrganization) organizationEmpJComboBox.getSelectedItem();
                name = nameJTextField.getText();
                organization.getEmployeeDirectory().createEmployee(name);
            } 
            else /* Fill employees to Admin assistant Organization under Hospital Enterprise*/ if (str.equals("HospitalAdminAssistant Organization")) {
                organization = (HospitalAdminAssistantOrganization) organizationEmpJComboBox.getSelectedItem();
                name = nameJTextField.getText();
                organization.getEmployeeDirectory().createEmployee(name);
            }
        }
        populateTable();
        popOrganizationComboBoxT3();
    }//GEN-LAST:event_btnAddEmpActionPerformed

    private void btnAddOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrgActionPerformed
        Type type = (Type) cmbOrgT2.getSelectedItem();
        if (cmbOrgT2.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select the network name", "Error", JOptionPane.ERROR_MESSAGE);
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
                    populateTableT2();
                    populateOrganizationEmpComboBox();
                    popOrganizationComboBoxT3();
                } else {
                    JOptionPane.showMessageDialog(this, cmbOrgT2.getSelectedItem().toString() + "Organization already exists", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                enterprise.getOrganizationDirectory().createOrganization(type);

            }
        }

        populateTableT2();
        populateOrganizationEmpComboBox();
        popOrganizationComboBoxT3();
    }//GEN-LAST:event_btnAddOrgActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmp;
    private javax.swing.JButton btnAddOrg;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbEmpT3;
    private javax.swing.JComboBox cmbOrgT2;
    private javax.swing.JComboBox cmbOrgT3;
    private javax.swing.JComboBox cmbRoleT3;
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
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlHeader1;
    private javax.swing.JPanel pnlHeader2;
    private javax.swing.JPanel pnlHomePage;
    private javax.swing.JTabbedPane pnlMainData;
    private javax.swing.JPanel pnlManageOrg;
    private javax.swing.JPanel pnlTaxFinancial;
    private javax.swing.JPanel pnlTaxFinancialBody;
    private javax.swing.JPanel pnlTaxFinancialHeader;
    private javax.swing.JTable tblOrgT2;
    private javax.swing.JTable tblUserT3;
    private javax.swing.JTextField tflAnnualRevenue;
    private javax.swing.JTextField tflBankAcc;
    private javax.swing.JTextField tflEmpName;
    private javax.swing.JPasswordField tflEmpPassword;
    private javax.swing.JTextField tflFiscalYear;
    private javax.swing.JTextField tflName;
    private javax.swing.JTextField tflTaxPayerId;
    private javax.swing.JTextField tflTaxRegNumber;
    private javax.swing.JLabel txtAnnual;
    private javax.swing.JLabel txtBankAcc;
    private javax.swing.JLabel txtFiscalYear;
    private javax.swing.JLabel txtInfo;
    private javax.swing.JLabel txtInfo1;
    private javax.swing.JLabel txtInfo2;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtPersonalHeader1;
    private javax.swing.JLabel txtTaxPayerID;
    private javax.swing.JLabel txtTaxRegNumber;
    // End of variables declaration//GEN-END:variables
}
