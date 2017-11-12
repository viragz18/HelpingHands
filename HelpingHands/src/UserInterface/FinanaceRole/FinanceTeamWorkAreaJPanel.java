/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FinanaceRole;

import Business.Data.HomelessData;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.FinanceOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FundWRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkQueue;
//import Business.WorkQueue.FinanceWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.LabAssistantRole.ProcessWorkRequestJPanel;
import com.jgoodies.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
//import static jdk.nashorn.internal.objects.NativeJava.type;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;

public class FinanceTeamWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private FinanceOrganization organization;
    private Enterprise enterprise;
    private ImageIcon storeImage;
    private UserAccount userAccount;
    private UserAccount adminuseraccount;
//    private JDatePickerImpl datePicker;

    public FinanceTeamWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, FinanceOrganization organization, Enterprise enterprise) {

        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;

        /* Fill ProfileTab */
        populateProfileTab();
        /* Fill finance Management Tab */
        populatefmanTab();
        /* Fill Work Q data */
        populateWorkrequestTab();
        /* Fill the WorkSPace */
        populateWorkspace();
        populatestatementstable();
        btnSave.setEnabled(false);
        commonGraph();

    }

    public void populateWorkrequestTab() {
        /* Populate the WorkQ tbale */

        DefaultTableModel model = (DefaultTableModel) tblWorkQFinance.getModel();
        model.setRowCount(0);

        for (WorkRequest wr : enterprise.getWorkQueue().getWorkRequestList()) {
            String str = wr.getOrganizationName();
            if (str.equalsIgnoreCase("Finance Organization")) {
                Object[] row = new Object[7];
                row[0] = wr;
                row[1] = wr.getRequestedOn();
                row[2] = wr.getDescription();
                row[3] = wr.getRequestedby();
                row[4] = wr.getReqByorganizationName();
                row[5] = wr.getAssignedTo();
                row[6] = wr.getStatus();
                model.addRow(row);
            }
        }

    }

    public void populatefmanTab() {
        for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {

            tflName.setText(ua.getEnterpriseinfo().geteName());
            tflBankAcc.setText(ua.getEnterpriseinfo().getBaccountNo());
            tflFiscalYear.setText(ua.getEnterpriseinfo().getFiscalYear());
            tflAnnualRevenue.setText(ua.getEnterpriseinfo().getCashflow());
            tflTaxPayerId.setText(ua.getEnterpriseinfo().getTaxpayerID());
            tflTaxRegNumber.setText(ua.getEnterpriseinfo().getTaxRegistrationNo());
            tflBalance.setText(String.valueOf(ua.getEnterpriseinfo().getBalance()));
            populatestatementstable();
        }
    }

    public void populatestatementstable() {

        DefaultTableModel model = (DefaultTableModel) tblStatement.getModel();
        model.setRowCount(0);
        for (WorkRequest wr : enterprise.getWorkQueue().getWorkRequestList()) {
            String str = wr.getOrganizationName();
            if (str.equalsIgnoreCase("Finance Organization")) {
                if (wr.getApprovalStatus() != null) {
                    if (wr.getApprovalStatus().equalsIgnoreCase("Approve")) {
                        Object[] row = new Object[5];
                        row[0] = wr.getApprovalDate();
                        row[1] = wr.getNarration();
                        row[2] = wr.getChequeNo();
                        row[3] = wr.getDebit();
                        row[4] = wr.getCredit();
                        model.addRow(row);
                    }
                }
            }
        }
    }

    public void populateProfileTab() {
        changemode(false);
        tflFirstName.setText(userAccount.getUserProfile().getFirstName());
        tflLastName.setText(userAccount.getUserProfile().getLastName());
        tflAge.setText(userAccount.getUserProfile().getAge());;
        cmbSex.setSelectedItem(userAccount.getUserProfile().getSex());
        tflAddress1.setText(userAccount.getUserProfile().getStreetL1());
        tflAddress2.setText(userAccount.getUserProfile().getStreetL2());
        tflCity.setText(userAccount.getUserProfile().getCity());
        tflState.setText(userAccount.getUserProfile().getState());
        tflCountry.setText(userAccount.getUserProfile().getCountry());
        tflEmailID.setText(userAccount.getUserProfile().getEmailID());
        tflMobile.setText(userAccount.getUserProfile().getMobileNo());
        tflOrganization.setText("FinanceManagement");
        tflRole.setText("Finance-Analyst");
        tflDoj.setText(userAccount.getUserProfile().getDOJ());
        tflWorkExp.setText(userAccount.getUserProfile().getWrkEx());


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil2 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil3 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil4 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil5 = new org.jdatepicker.util.JDatePickerUtil();
        tbdPaneFinanceWa = new javax.swing.JTabbedPane();
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
        pnlFinanceManagement = new javax.swing.JPanel();
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
        txtFiscalYear1 = new javax.swing.JLabel();
        tflBalance = new javax.swing.JTextField();
        pnlTaxFinancialHeader = new javax.swing.JPanel();
        txtPersonalHeader1 = new javax.swing.JLabel();
        pnlFinancialAccounts = new javax.swing.JPanel();
        pnlFinancialAccount = new javax.swing.JPanel();
        lblFinancialAcount = new javax.swing.JLabel();
        pnlFinancialAccountBody = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStatement = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtFromDate = new javax.swing.JLabel();
        txtToDate1 = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        cmbcalFrom = new de.wannawork.jcalendar.JCalendarComboBox();
        cmbcalTo = new de.wannawork.jcalendar.JCalendarComboBox();
        jButton1 = new javax.swing.JButton();
        pnlWorkRequest = new javax.swing.JPanel();
        pnlMyworkSpace = new javax.swing.JPanel();
        pnlPMyWorkSpaceBody = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMyWorkSpace = new javax.swing.JTable();
        pnlMyWorkSpaceBody = new javax.swing.JPanel();
        txtPersonalHeader2 = new javax.swing.JLabel();
        btnProcessRequest = new javax.swing.JButton();
        pnlWorkRequestPool = new javax.swing.JPanel();
        pnlPersonalBody3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblWorkQFinance = new javax.swing.JTable();
        pnlPersonalHeader3 = new javax.swing.JPanel();
        txtPersonalHeader3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmbsort = new javax.swing.JComboBox<>();
        cmbSearch = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        tflSearch = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnAssigntome = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnRefreshChart = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        pnlGraph = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbdPaneFinanceWa.setBackground(null);
        tbdPaneFinanceWa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

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

        tbdPaneFinanceWa.addTab("Profile ", pnlProfile);

        pnlFinanceManagement.setBackground(null);

        pnlTaxFinancial.setBackground(null);
        pnlTaxFinancial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlTaxFinancialBody.setBackground(null);
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
        txtName.setText("Name");
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tflBankAcc.setEditable(false);

        txtTaxPayerID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTaxPayerID.setText("TaxPayerID");
        txtTaxPayerID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tflTaxPayerId.setEditable(false);

        txtTaxRegNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTaxRegNumber.setText("Tax Reg Number ");
        txtTaxRegNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tflTaxRegNumber.setEditable(false);

        txtAnnual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtAnnual.setText("Annual Cash Inflow");
        txtAnnual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tflAnnualRevenue.setEditable(false);

        txtFiscalYear1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtFiscalYear1.setText("Current Balance");
        txtFiscalYear1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tflBalance.setEditable(false);

        javax.swing.GroupLayout pnlTaxFinancialBodyLayout = new javax.swing.GroupLayout(pnlTaxFinancialBody);
        pnlTaxFinancialBody.setLayout(pnlTaxFinancialBodyLayout);
        pnlTaxFinancialBodyLayout.setHorizontalGroup(
            pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFinancialBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFiscalYear1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(txtBankAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFiscalYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tflName, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(tflBankAcc)
                    .addComponent(tflFiscalYear)
                    .addComponent(tflBalance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAnnual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTaxPayerID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTaxRegNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tflTaxRegNumber, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflTaxPayerId, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflAnnualRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlTaxFinancialBodyLayout.setVerticalGroup(
            pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFinancialBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName)
                    .addComponent(tflName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaxPayerID)
                    .addComponent(tflTaxPayerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflBankAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBankAcc)
                        .addComponent(tflTaxRegNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTaxRegNumber)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiscalYear)
                    .addComponent(tflFiscalYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnnual)
                    .addComponent(tflAnnualRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTaxFinancialBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiscalYear1)
                    .addComponent(tflBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTaxFinancialHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlTaxFinancialHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPersonalHeader1.setForeground(new java.awt.Color(255, 255, 255));
        txtPersonalHeader1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPersonalHeader1.setText("Tax and Financial Information  ");

        javax.swing.GroupLayout pnlTaxFinancialHeaderLayout = new javax.swing.GroupLayout(pnlTaxFinancialHeader);
        pnlTaxFinancialHeader.setLayout(pnlTaxFinancialHeaderLayout);
        pnlTaxFinancialHeaderLayout.setHorizontalGroup(
            pnlTaxFinancialHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFinancialHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtPersonalHeader1)
                .addContainerGap(680, Short.MAX_VALUE))
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
                    .addGroup(pnlTaxFinancialLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlTaxFinancialBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

        pnlFinancialAccounts.setBackground(null);
        pnlFinancialAccounts.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlFinancialAccount.setBackground(new java.awt.Color(102, 102, 102));
        pnlFinancialAccount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblFinancialAcount.setForeground(new java.awt.Color(255, 255, 255));
        lblFinancialAcount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFinancialAcount.setText("Financial Account Statements ");

        javax.swing.GroupLayout pnlFinancialAccountLayout = new javax.swing.GroupLayout(pnlFinancialAccount);
        pnlFinancialAccount.setLayout(pnlFinancialAccountLayout);
        pnlFinancialAccountLayout.setHorizontalGroup(
            pnlFinancialAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinancialAccountLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblFinancialAcount)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFinancialAccountLayout.setVerticalGroup(
            pnlFinancialAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFinancialAcount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        pnlFinancialAccountBody.setBackground(null);
        pnlFinancialAccountBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblStatement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "TimeStamp", "Narration ", "Ref/Cheque No", "Debit", "Credit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStatement);

        javax.swing.GroupLayout pnlFinancialAccountBodyLayout = new javax.swing.GroupLayout(pnlFinancialAccountBody);
        pnlFinancialAccountBody.setLayout(pnlFinancialAccountBodyLayout);
        pnlFinancialAccountBodyLayout.setHorizontalGroup(
            pnlFinancialAccountBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinancialAccountBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlFinancialAccountBodyLayout.setVerticalGroup(
            pnlFinancialAccountBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFinancialAccountBodyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );

        jPanel1.setBackground(null);
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFromDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtFromDate.setText("From Date ");

        txtToDate1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtToDate1.setText("To Date ");

        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFromDate)
                .addGap(5, 5, 5)
                .addComponent(cmbcalFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtToDate1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbcalTo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbcalTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnGenerate)
                                .addComponent(jButton1)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbcalFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(txtFromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtToDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlFinancialAccountsLayout = new javax.swing.GroupLayout(pnlFinancialAccounts);
        pnlFinancialAccounts.setLayout(pnlFinancialAccountsLayout);
        pnlFinancialAccountsLayout.setHorizontalGroup(
            pnlFinancialAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFinancialAccountsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFinancialAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFinancialAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFinancialAccountBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFinancialAccountsLayout.setVerticalGroup(
            pnlFinancialAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinancialAccountsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFinancialAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFinancialAccountBody, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlFinanceManagementLayout = new javax.swing.GroupLayout(pnlFinanceManagement);
        pnlFinanceManagement.setLayout(pnlFinanceManagementLayout);
        pnlFinanceManagementLayout.setHorizontalGroup(
            pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinanceManagementLayout.createSequentialGroup()
                .addGroup(pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTaxFinancial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFinanceManagementLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlFinancialAccounts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFinanceManagementLayout.setVerticalGroup(
            pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinanceManagementLayout.createSequentialGroup()
                .addComponent(pnlTaxFinancial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnlFinancialAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        tbdPaneFinanceWa.addTab("FinanceManagement", pnlFinanceManagement);

        pnlMyworkSpace.setBackground(new java.awt.Color(255, 255, 255));
        pnlMyworkSpace.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlPMyWorkSpaceBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlPMyWorkSpaceBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

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
        jScrollPane2.setViewportView(tblMyWorkSpace);

        javax.swing.GroupLayout pnlPMyWorkSpaceBodyLayout = new javax.swing.GroupLayout(pnlPMyWorkSpaceBody);
        pnlPMyWorkSpaceBody.setLayout(pnlPMyWorkSpaceBodyLayout);
        pnlPMyWorkSpaceBodyLayout.setHorizontalGroup(
            pnlPMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPMyWorkSpaceBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPMyWorkSpaceBodyLayout.setVerticalGroup(
            pnlPMyWorkSpaceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPMyWorkSpaceBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProcessRequest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlWorkRequestPool.setBackground(new java.awt.Color(255, 255, 255));
        pnlWorkRequestPool.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlPersonalBody3.setBackground(new java.awt.Color(255, 255, 255));
        pnlPersonalBody3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        tblWorkQFinance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "WorkRequestID", "Requested On", "Description ", "Requested By", "Requested Organization ", "Assigned To", "Status "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblWorkQFinance);

        javax.swing.GroupLayout pnlPersonalBody3Layout = new javax.swing.GroupLayout(pnlPersonalBody3);
        pnlPersonalBody3.setLayout(pnlPersonalBody3Layout);
        pnlPersonalBody3Layout.setHorizontalGroup(
            pnlPersonalBody3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalBody3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPersonalBody3Layout.setVerticalGroup(
            pnlPersonalBody3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalBody3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlPersonalHeader3.setBackground(new java.awt.Color(102, 102, 102));
        pnlPersonalHeader3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

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
                .addContainerGap(758, Short.MAX_VALUE))
        );
        pnlPersonalHeader3Layout.setVerticalGroup(
            pnlPersonalHeader3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalHeader3Layout.createSequentialGroup()
                .addComponent(txtPersonalHeader3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        cmbsort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "Status" }));
        cmbsort.setBorder(javax.swing.BorderFactory.createTitledBorder("Sory By"));
        cmbsort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbsortActionPerformed(evt);
            }
        });

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "WorkRequestID", "Status" }));
        cmbSearch.setBorder(javax.swing.BorderFactory.createTitledBorder("SearchBy"));
        cmbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSearchActionPerformed(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tflSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tflSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tflSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tflSearch)))
        );

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbsort, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbsort)
                        .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRefresh)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlWorkRequestPoolLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlWorkRequestPoolLayout.setVerticalGroup(
            pnlWorkRequestPoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWorkRequestPoolLayout.createSequentialGroup()
                .addComponent(pnlPersonalHeader3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(pnlPersonalBody3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAssigntome)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnlWorkRequestLayout = new javax.swing.GroupLayout(pnlWorkRequest);
        pnlWorkRequest.setLayout(pnlWorkRequestLayout);
        pnlWorkRequestLayout.setHorizontalGroup(
            pnlWorkRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWorkRequestLayout.createSequentialGroup()
                .addGroup(pnlWorkRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlWorkRequestPool, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlWorkRequestLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlMyworkSpace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlWorkRequestLayout.setVerticalGroup(
            pnlWorkRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWorkRequestLayout.createSequentialGroup()
                .addComponent(pnlWorkRequestPool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(pnlMyworkSpace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        tbdPaneFinanceWa.addTab("Work Request ", pnlWorkRequest);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        btnRefreshChart.setText("Refresh");
        btnRefreshChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshChartActionPerformed(evt);
            }
        });

        pnlGraph.setBackground(new java.awt.Color(255, 255, 255));
        pnlGraph.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        pnlGraph.setPreferredSize(new java.awt.Dimension(700, 250));

        javax.swing.GroupLayout pnlGraphLayout = new javax.swing.GroupLayout(pnlGraph);
        pnlGraph.setLayout(pnlGraphLayout);
        pnlGraphLayout.setHorizontalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGraphLayout.setVerticalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(pnlGraph);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnRefreshChart)
                .addContainerGap(794, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefreshChart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        tbdPaneFinanceWa.addTab("Analysis", jPanel4);

        add(tbdPaneFinanceWa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

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

    public JFreeChart populateBarGraph() {
        DefaultPieDataset pieDataSet = new DefaultKeyedValuesDataset();
        double credit = 0, debit = 0;
        for (WorkRequest wr : enterprise.getWorkQueue().getWorkRequestList()) {
            credit += wr.getCredit();
            debit += wr.getDebit();
        }

        pieDataSet.setValue("credit", new Double(credit));
        pieDataSet.setValue("debit", new Double(debit));

        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart", pieDataSet, true, true, true);
        PiePlot3D p = (PiePlot3D) chart.getPlot();
        p.setStartAngle(290);
        //p.setDirection(Rotation.CLOCKWISE);
        p.setForegroundAlpha(0.5f);
        chart.setBackgroundPaint(Color.YELLOW);
        chart.getTitle().setPaint(Color.red);
        p.setOutlinePaint(Color.red);
        p.setBackgroundPaint(Color.BLUE);
        return chart;
    }

    public JFreeChart populateBarGraph2() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
       
        for(WorkRequest wr:enterprise.getWorkQueue().getWorkRequestList()){
            if(wr instanceof FundWRequest){
            dataSet.setValue(((FundWRequest)wr).getFundingamt(), "values", (((FundWRequest)wr).getSource()));
            
        }
        }
         JFreeChart chart = ChartFactory.createBarChart("Income Chart", "Sources", "Amount", dataSet, PlotOrientation.VERTICAL, false, true, false);
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
        ChartPanel frame3 = new ChartPanel(populateBarGraph2());
        frame3.setSize(200, 200);
        frame2.setSize(200, 200);

        pnlGraph.removeAll();
        pnlGraph.setLayout(new java.awt.BorderLayout());
        pnlGraph.setLayout(new GridLayout(1, 2));

//       jPanel1.setSize(450,350);
//        pnlGraph.add(frame, BorderLayout.EAST);
//        pnlGraph.add(frame1, BorderLayout.EAST);
//        pnlGraph.add(frame2, BorderLayout.EAST);
        pnlGraph.add(frame3, BorderLayout.EAST);
        pnlGraph.add(frame2, BorderLayout.EAST);
        pnlGraph.validate();

    }    public void changemode(boolean value) {
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
    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblStatement.getModel();
        model.setRowCount(0);
        for (WorkRequest wr : enterprise.getWorkQueue().getWorkRequestList()) {
            String str = wr.getOrganizationName();
            Boolean flag = true;
            if (str.equalsIgnoreCase("Finance Organization")) {
                if (wr.getApprovalStatus() != null) {
                    if (wr.getApprovalStatus().equalsIgnoreCase("Approve")) {
                        datavalidations(wr, flag);
                        if (flag == true) {
                            Object[] row = new Object[5];

                            row[0] = wr.getApprovalDate();

                            row[1] = wr.getNarration();
                            row[2] = wr.getChequeNo();
                            row[3] = wr.getDebit();
                            row[4] = wr.getCredit();
                            model.addRow(row);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGenerateActionPerformed

    public void datavalidations(WorkRequest wr, Boolean flag) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date dateobj = new Date();
        String from = String.valueOf(cmbcalFrom.getDate());
        Date frd = cmbcalFrom.getDate();
        Date tod = cmbcalTo.getDate();

        Date dad = wr.getApprovalDate();

        /*From Date is in Future*/
        if (frd.compareTo(dateobj) > 0) {
            JOptionPane.showMessageDialog(null, " From Date is a future Date. Please check!");
            flag = false;
        } else /*Validate From < To */ if (frd.compareTo(tod) > 0) {
            JOptionPane.showMessageDialog(null, " From Date if greater than To Date. Please check!");
            flag = false;
        }

        if (!((dad.compareTo(frd) >= 0) && (dad.compareTo(tod) <= 0))) {
            flag = false;
        }

    }
    private void cmbsortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbsortActionPerformed
//        if (cmbsort.getSelectedItem().equals("Date")) {
//            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tblWorkQFinance.getModel());
//            tblWorkQFinance.setRowSorter(sorter);
//            ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
//            sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
//            sorter.setSortKeys(sortKeys);
//        }
        if (cmbsort.getSelectedItem().equals("Status")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tblWorkQFinance.getModel());
            tblWorkQFinance.setRowSorter(sorter);
            ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(6, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        }
    }//GEN-LAST:event_cmbsortActionPerformed

    private void btnAssigntomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssigntomeActionPerformed
        int selectedRow = tblWorkQFinance.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the WorkREquest Pool", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            WorkRequest request = (WorkRequest) tblWorkQFinance.getValueAt(selectedRow, 0);
            String asignTo = String.valueOf(request.getAssignedTo());
            if (asignTo.equalsIgnoreCase("null")) {
                request.setAssignedTo(userAccount);
                request.setStatus("Pending");
                populateWorkspace();
                populateWorkrequestTab();
            } else {
                JOptionPane.showMessageDialog(null, "Sorry! Request Already Assigned", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAssigntomeActionPerformed

    private void btnProcessRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessRequestActionPerformed
        int selectedRow = tblMyWorkSpace.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the WorkSpace", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            WorkRequest request = (WorkRequest) tblMyWorkSpace.getValueAt(selectedRow, 0);
            String stat = request.getStatus();
            if (stat.equalsIgnoreCase("Complete")) {
                JOptionPane.showMessageDialog(null, "Sorry ! - Request Processed. Can't be Re-Processed", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                request.setStatus("Processing");
                ProcessFinancialWRequests processFinancialWRequests = new ProcessFinancialWRequests(userProcessContainer, request, enterprise);
                userProcessContainer.add("processFinancialWRequests", processFinancialWRequests);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
    }//GEN-LAST:event_btnProcessRequestActionPerformed
    }
    private void cmbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        populatestatementstable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        if (tflSearch.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Search Condition . Please check!");
        } else {
            DefaultTableModel model = (DefaultTableModel) tblWorkQFinance.getModel();
            model.setRowCount(0);
            for (WorkRequest wr : enterprise.getWorkQueue().getWorkRequestList()) {
                String str = wr.getOrganizationName();
                Boolean flag = true;
                if (str.equalsIgnoreCase("Finance Organization")) {
                    if (cmbSearch.getSelectedItem().equals("Status")) {
                        if (!(wr.getStatus().equalsIgnoreCase(tflSearch.getText()))) {
                            flag = false;
                        }
                    } else if (cmbSearch.getSelectedItem().equals("WorkRequestID")) {
                        String str1 = tflSearch.getText();
                        if (wr.getWorkRequestID().equalsIgnoreCase(str1)) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                    }
                    if (flag == true) {
                        Object[] row = new Object[7];
                        row[0] = wr;
                        row[1] = wr.getRequestedOn();
                        row[2] = wr.getDescription();
                        row[3] = wr.getRequestedby();
                        row[4] = wr.getReqByorganizationName();
                        row[5] = wr.getAssignedTo();
                        row[6] = wr.getStatus();
                        model.addRow(row);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    public void searchCondition(WorkRequest wr, Boolean flag) {
        if (cmbSearch.getSelectedItem().equals("Status")) {
            if (!(wr.getStatus().equalsIgnoreCase(tflSearch.getText()))) {
                flag = false;
            }
        } else if (cmbSearch.getSelectedItem().equals("WorkRequestID")) {
            String str = tflSearch.getText();
            if (wr.getWorkRequestID().equalsIgnoreCase(str)) {
                flag = true;
            } else {
                flag = false;
            }

        }

    }
    private void tflSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tflSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateWorkrequestTab();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRefreshChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshChartActionPerformed
        commonGraph();
    }//GEN-LAST:event_btnRefreshChartActionPerformed

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

    public void populateWorkspace() {
        DefaultTableModel model = (DefaultTableModel) tblMyWorkSpace.getModel();

        model.setRowCount(0);
        String aname = userAccount.getUsername();
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            if ((!(request.getStatus().equalsIgnoreCase("Sent")))) {
                if ((request.getAssignedTo().getUsername().equals(aname))) {
                    Object[] row = new Object[7];
                    row[0] = request;
                    row[1] = request.getRequestedOn();
                    row[2] = request.getDescription();
                    row[3] = request.getRequestedby();
                    row[4] = request.getOrganizationName();
                    row[5] = request.getAssignedTo();
                    row[6] = request.getStatus();
                    model.addRow(row);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TxtDoj;
    private javax.swing.JButton btnAssigntome;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnProcessRequest;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefreshChart;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbSearch;
    private javax.swing.JComboBox<String> cmbSex;
    private de.wannawork.jcalendar.JCalendarComboBox cmbcalFrom;
    private de.wannawork.jcalendar.JCalendarComboBox cmbcalTo;
    private javax.swing.JComboBox<String> cmbsort;
    private javax.swing.JButton jButton1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil2;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil3;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil4;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblContactHeader;
    private javax.swing.JLabel lblFinancialAcount;
    private javax.swing.JPanel pnlContactInfo;
    private javax.swing.JPanel pnlContactInfoBody;
    private javax.swing.JPanel pnlContactinfoHeader;
    private javax.swing.JPanel pnlEmployementBody;
    private javax.swing.JPanel pnlEmploymentDetails;
    private javax.swing.JPanel pnlEmploymentHeader;
    private javax.swing.JPanel pnlFinanceManagement;
    private javax.swing.JPanel pnlFinancialAccount;
    private javax.swing.JPanel pnlFinancialAccountBody;
    private javax.swing.JPanel pnlFinancialAccounts;
    private javax.swing.JPanel pnlGraph;
    private javax.swing.JPanel pnlMyWorkSpaceBody;
    private javax.swing.JPanel pnlMyworkSpace;
    private javax.swing.JPanel pnlPMyWorkSpaceBody;
    private javax.swing.JPanel pnlPersonalBody;
    private javax.swing.JPanel pnlPersonalBody3;
    private javax.swing.JPanel pnlPersonalDeatails;
    private javax.swing.JPanel pnlPersonalHeader;
    private javax.swing.JPanel pnlPersonalHeader3;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JPanel pnlTaxFinancial;
    private javax.swing.JPanel pnlTaxFinancialBody;
    private javax.swing.JPanel pnlTaxFinancialHeader;
    private javax.swing.JPanel pnlWorkRequest;
    private javax.swing.JPanel pnlWorkRequestPool;
    private javax.swing.JTabbedPane tbdPaneFinanceWa;
    private javax.swing.JTable tblMyWorkSpace;
    private javax.swing.JTable tblStatement;
    private javax.swing.JTable tblWorkQFinance;
    private javax.swing.JTextField tflAddress1;
    private javax.swing.JTextField tflAddress2;
    private javax.swing.JTextField tflAge;
    private javax.swing.JTextField tflAnnualRevenue;
    private javax.swing.JTextField tflBalance;
    private javax.swing.JTextField tflBankAcc;
    private javax.swing.JTextField tflCity;
    private javax.swing.JTextField tflCountry;
    private javax.swing.JTextField tflDoj;
    private javax.swing.JTextField tflEmailID;
    private javax.swing.JTextField tflFirstName;
    private javax.swing.JTextField tflFiscalYear;
    private javax.swing.JTextField tflLastName;
    private javax.swing.JTextField tflMobile;
    private javax.swing.JTextField tflName;
    private javax.swing.JTextField tflOrganization;
    private javax.swing.JTextField tflRole;
    private javax.swing.JTextField tflSearch;
    private javax.swing.JTextField tflState;
    private javax.swing.JTextField tflTaxPayerId;
    private javax.swing.JTextField tflTaxRegNumber;
    private javax.swing.JTextField tflWorkExp;
    private javax.swing.JLabel txtAddress1;
    private javax.swing.JLabel txtAge;
    private javax.swing.JLabel txtAnnual;
    private javax.swing.JLabel txtBankAcc;
    private javax.swing.JLabel txtCity;
    private javax.swing.JLabel txtCountry;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtEmployementHeader;
    private javax.swing.JLabel txtFirstName;
    private javax.swing.JLabel txtFiscalYear;
    private javax.swing.JLabel txtFiscalYear1;
    private javax.swing.JLabel txtFromDate;
    private javax.swing.JLabel txtLastName;
    private javax.swing.JLabel txtMobile;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtOrganization;
    private javax.swing.JLabel txtPersonalHeader;
    private javax.swing.JLabel txtPersonalHeader1;
    private javax.swing.JLabel txtPersonalHeader2;
    private javax.swing.JLabel txtPersonalHeader3;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtSex;
    private javax.swing.JLabel txtState;
    private javax.swing.JLabel txtTaxPayerID;
    private javax.swing.JLabel txtTaxRegNumber;
    private javax.swing.JLabel txtToDate1;
    private javax.swing.JLabel txtWorkExp;
    private javax.swing.JLabel txtaddress2;
    // End of variables declaration//GEN-END:variables
}
