package UserInterface.FundRaisingRole;

import Business.Enterprise.Enterprise;
import Business.Organization.DatateamOrganization;
import Business.Organization.FinanceOrganization;
import Business.Organization.FundRaisingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DataWorkRequest;
import Business.WorkQueue.FundWRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.DataTeamRole.DataTeamWorkAreaJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class FundRaisingTeamWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private FundRaisingOrganization organization;
    private Enterprise enterprise;
    private ImageIcon storeImage;
    private UserAccount userAccount;

    public FundRaisingTeamWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, FundRaisingOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        /* Fill ProfileTab */
        populateProfileTab();
        /*Fundraising Tab*/
        populateFundRaisingTab();

        popOrganizationComboBoxT3();
        
        periodicFunding();
    }
    private void periodicFunding(){
    /* Funding from some regular Sources*/ 
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      Date date = calendar.getTime();
      int day = calendar.get(Calendar.DAY_OF_MONTH);
      DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
      Date dateobj = new Date();
 
 /*** Get periodic funding on 15th of every Month***/ 
                if (day== 15){
                Organization org = null;
                for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof FundRaisingOrganization) {
                        org = organization1;
                        break;
                    }
                }
                FundWRequest requestnew = new FundWRequest();
                /*FieldsRequired for FinanceTeam Organization*/
                requestnew.setRequestedOn(dateobj);
                requestnew.setDescription("Regular Funding");
                requestnew.setRequestedby(userAccount);
                requestnew.setOrganizationName("Finance Organization");
                requestnew.setReqByorganizationName("FundRaising Organization");
                requestnew.setStatus("Sent");

                /*Fields Required forFundRaising Organization */
                requestnew.setSource("National Fundings");
                requestnew.setTransferMode("Online Transfer");
                requestnew.setFundingamt(100000000.00);
                requestnew.setEstimateDate(dateobj);

                /*Fields Required for Finance team - Statements page  */
                requestnew.setNarration("Periodic Funding Resource");
                String trans = "NFFund"+String.valueOf(dateobj) ;
                
                requestnew.setChequeNo(trans);
                requestnew.setDebit(0.0);
                requestnew.setCredit(1000000.00);

                if (org != null) {
                    enterprise.getWorkQueue().getWorkRequestList().add(requestnew);
                    JOptionPane.showMessageDialog(null, "Funds Recorded and Request send to Finance Dept for Notification");
                    populateFundRaisingTab();

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
        tflOrganization.setText("FundRaisingManagement");
        tflRole.setText("Marketing-Analyst");
        tflDoj.setText(userAccount.getUserProfile().getDOJ());
        tflWorkExp.setText(userAccount.getUserProfile().getWrkEx());

    }

    public void populateFundRaisingTab() {

        /* Populate the WorkQ tbale */
        DefaultTableModel model = (DefaultTableModel) tbltransferSt.getModel();
        model.setRowCount(0);
        for (WorkRequest wr : enterprise.getWorkQueue().getWorkRequestList()) {

            String str = wr.getReqByorganizationName();
            if (str != null) {
                if (str.equalsIgnoreCase("FundRaising Organization")) {
                    {
                        Object[] row = new Object[5];
                        row[0] = wr.getRequestedOn();
                        row[1] = ((FundWRequest) wr).getSource();
                        row[2] = ((FundWRequest) wr).getTransferMode();
                        row[3] = ((FundWRequest) wr).getFundingamt();
                        row[4] = ((FundWRequest) wr).getEstimateDate();
                        model.addRow(row);
                    }
                }
            }
        }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbdPaneFundRaisingWa = new javax.swing.JTabbedPane();
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
        pnlFundRaising = new javax.swing.JPanel();
        pnlManageFunds = new javax.swing.JPanel();
        pnlTaxFundsBody = new javax.swing.JPanel();
        txtFundingMode = new javax.swing.JLabel();
        txtFundingAmt = new javax.swing.JLabel();
        tflfundingAmt = new javax.swing.JTextField();
        txtEstimateDate = new javax.swing.JLabel();
        txtDescription = new javax.swing.JLabel();
        tflDescription = new javax.swing.JTextField();
        txtBankAcc = new javax.swing.JLabel();
        tflSrcName = new javax.swing.JTextField();
        cmbTmode = new javax.swing.JComboBox<>();
        cmbcalestimaDate = new de.wannawork.jcalendar.JCalendarComboBox();
        txtOrganization1 = new javax.swing.JLabel();
        comboOrg = new javax.swing.JComboBox();
        txttransactionRefno = new javax.swing.JLabel();
        tflTransactionRef = new javax.swing.JTextField();
        pnlManageFundsHeader = new javax.swing.JPanel();
        txtMfundsHeader = new javax.swing.JLabel();
        btnRecord = new javax.swing.JButton();
        pnlFinancialAccounts = new javax.swing.JPanel();
        pnlFundTansferActivity = new javax.swing.JPanel();
        lblFundHeader = new javax.swing.JLabel();
        pnlFundBody = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransferSt = new javax.swing.JTable();
        pnlSubHead = new javax.swing.JPanel();
        txtFromDate = new javax.swing.JLabel();
        txtToDate1 = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        cmbcalFrom = new de.wannawork.jcalendar.JCalendarComboBox();
        cmbcalTo = new de.wannawork.jcalendar.JCalendarComboBox();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbdPaneFundRaisingWa.setBackground(new java.awt.Color(255, 255, 255));
        tbdPaneFundRaisingWa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

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

        tbdPaneFundRaisingWa.addTab("Profile ", pnlProfile);

        pnlFundRaising.setBackground(new java.awt.Color(255, 255, 255));
        pnlFundRaising.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlManageFunds.setBackground(new java.awt.Color(255, 255, 255));
        pnlManageFunds.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlTaxFundsBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlTaxFundsBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        txtFundingMode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtFundingMode.setText("FundTransfer Mode");
        txtFundingMode.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFundingMode.setOpaque(true);

        txtFundingAmt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtFundingAmt.setText("Funding (in $)");
        txtFundingAmt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFundingAmt.setOpaque(true);

        txtEstimateDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtEstimateDate.setText("Estimated Date of Credit");
        txtEstimateDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtEstimateDate.setOpaque(true);

        txtDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtDescription.setText("Description / Comment");
        txtDescription.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDescription.setOpaque(true);

        txtBankAcc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtBankAcc.setText("Name (Source of Fund)");
        txtBankAcc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBankAcc.setOpaque(true);

        cmbTmode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Demand Draft", "Online Transfer", "Cheque" }));

        txtOrganization1.setText("Assign to organization:");
        txtOrganization1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtOrganization1.setOpaque(true);

        comboOrg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrgActionPerformed(evt);
            }
        });

        txttransactionRefno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txttransactionRefno.setText("Transaction Ref. No");
        txttransactionRefno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txttransactionRefno.setOpaque(true);

        javax.swing.GroupLayout pnlTaxFundsBodyLayout = new javax.swing.GroupLayout(pnlTaxFundsBody);
        pnlTaxFundsBody.setLayout(pnlTaxFundsBodyLayout);
        pnlTaxFundsBodyLayout.setHorizontalGroup(
            pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFundsBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttransactionRefno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOrganization1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFundingMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBankAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tflSrcName)
                    .addComponent(cmbTmode, 0, 1, Short.MAX_VALUE)
                    .addComponent(comboOrg, 0, 142, Short.MAX_VALUE)
                    .addComponent(tflTransactionRef))
                .addGap(27, 27, 27)
                .addGroup(pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEstimateDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFundingAmt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflDescription)
                    .addComponent(tflfundingAmt)
                    .addComponent(cmbcalestimaDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTaxFundsBodyLayout.setVerticalGroup(
            pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaxFundsBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFundingAmt)
                    .addComponent(tflfundingAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBankAcc)
                    .addComponent(tflSrcName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstimateDate)
                        .addComponent(txtFundingMode)
                        .addComponent(cmbTmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbcalestimaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTaxFundsBodyLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDescription))
                    .addComponent(tflDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtOrganization1)
                        .addComponent(comboOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(pnlTaxFundsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttransactionRefno)
                    .addComponent(tflTransactionRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnlManageFundsHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlManageFundsHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlManageFundsHeader.setForeground(new java.awt.Color(255, 255, 255));

        txtMfundsHeader.setBackground(new java.awt.Color(102, 102, 102));
        txtMfundsHeader.setForeground(new java.awt.Color(255, 255, 255));
        txtMfundsHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMfundsHeader.setText("ManageFunds");

        javax.swing.GroupLayout pnlManageFundsHeaderLayout = new javax.swing.GroupLayout(pnlManageFundsHeader);
        pnlManageFundsHeader.setLayout(pnlManageFundsHeaderLayout);
        pnlManageFundsHeaderLayout.setHorizontalGroup(
            pnlManageFundsHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageFundsHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtMfundsHeader)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlManageFundsHeaderLayout.setVerticalGroup(
            pnlManageFundsHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMfundsHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        btnRecord.setText("Raise Request");
        btnRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlManageFundsLayout = new javax.swing.GroupLayout(pnlManageFunds);
        pnlManageFunds.setLayout(pnlManageFundsLayout);
        pnlManageFundsLayout.setHorizontalGroup(
            pnlManageFundsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageFundsLayout.createSequentialGroup()
                .addGroup(pnlManageFundsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlManageFundsHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlManageFundsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlTaxFundsBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageFundsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(351, 351, 351))
        );
        pnlManageFundsLayout.setVerticalGroup(
            pnlManageFundsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageFundsLayout.createSequentialGroup()
                .addComponent(pnlManageFundsHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTaxFundsBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnRecord)
                .addContainerGap())
        );

        pnlFinancialAccounts.setBackground(new java.awt.Color(255, 255, 255));
        pnlFinancialAccounts.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        pnlFundTansferActivity.setBackground(new java.awt.Color(102, 102, 102));
        pnlFundTansferActivity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlFundTansferActivity.setForeground(new java.awt.Color(255, 255, 255));

        lblFundHeader.setBackground(new java.awt.Color(102, 102, 102));
        lblFundHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblFundHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFundHeader.setText("Fund Transfer Activity Details ");

        javax.swing.GroupLayout pnlFundTansferActivityLayout = new javax.swing.GroupLayout(pnlFundTansferActivity);
        pnlFundTansferActivity.setLayout(pnlFundTansferActivityLayout);
        pnlFundTansferActivityLayout.setHorizontalGroup(
            pnlFundTansferActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFundTansferActivityLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblFundHeader)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFundTansferActivityLayout.setVerticalGroup(
            pnlFundTansferActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFundHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        pnlFundBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlFundBody.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        tbltransferSt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "TimeStamp", "Name (Source of Fund)", "Fund TransferMode", "Funding Amount", "Credit Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbltransferSt);

        javax.swing.GroupLayout pnlFundBodyLayout = new javax.swing.GroupLayout(pnlFundBody);
        pnlFundBody.setLayout(pnlFundBodyLayout);
        pnlFundBodyLayout.setHorizontalGroup(
            pnlFundBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlFundBodyLayout.setVerticalGroup(
            pnlFundBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFundBodyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );

        pnlSubHead.setBackground(new java.awt.Color(255, 255, 255));
        pnlSubHead.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

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

        javax.swing.GroupLayout pnlSubHeadLayout = new javax.swing.GroupLayout(pnlSubHead);
        pnlSubHead.setLayout(pnlSubHeadLayout);
        pnlSubHeadLayout.setHorizontalGroup(
            pnlSubHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFromDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbcalFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtToDate1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbcalTo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlSubHeadLayout.setVerticalGroup(
            pnlSubHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubHeadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlSubHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbcalFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSubHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGenerate)
                        .addComponent(jButton1))
                    .addComponent(txtFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSubHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtToDate1)
                        .addComponent(cmbcalTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlFinancialAccountsLayout = new javax.swing.GroupLayout(pnlFinancialAccounts);
        pnlFinancialAccounts.setLayout(pnlFinancialAccountsLayout);
        pnlFinancialAccountsLayout.setHorizontalGroup(
            pnlFinancialAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFinancialAccountsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFinancialAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSubHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFundTansferActivity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFundBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFinancialAccountsLayout.setVerticalGroup(
            pnlFinancialAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinancialAccountsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFundTansferActivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSubHead, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFundBody, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlFundRaisingLayout = new javax.swing.GroupLayout(pnlFundRaising);
        pnlFundRaising.setLayout(pnlFundRaisingLayout);
        pnlFundRaisingLayout.setHorizontalGroup(
            pnlFundRaisingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFundRaisingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlManageFunds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlFinancialAccounts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFundRaisingLayout.setVerticalGroup(
            pnlFundRaisingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFundRaisingLayout.createSequentialGroup()
                .addComponent(pnlFinancialAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(pnlManageFunds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tbdPaneFundRaisingWa.addTab("FundRaising", pnlFundRaising);

        add(tbdPaneFundRaisingWa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbltransferSt.getModel();
        model.setRowCount(0);
        for (WorkRequest wr : enterprise.getWorkQueue().getWorkRequestList()) {
            Boolean flagy = true;
            String str = wr.getReqByorganizationName();
            if (str.equalsIgnoreCase("FundRaising Organization")) {
                datavalidations(wr, flagy);
                if (flagy == true) {
                    Object[] row = new Object[5];
                    row[0] = wr.getRequestedOn();
                    row[1] = ((FundWRequest) wr).getSource();
                    row[2] = ((FundWRequest) wr).getTransferMode();
                    row[3] = ((FundWRequest) wr).getFundingamt();
                    row[4] = ((FundWRequest) wr).getEstimateDate();
                    model.addRow(row);
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
        Date dad = wr.getRequestedOn();
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
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        populateFundRaisingTab();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tflCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflCountryActionPerformed

    }//GEN-LAST:event_tflCountryActionPerformed
    public void popOrganizationComboBoxT3() {
        comboOrg.removeAllItems();
        for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization1.getName().contains("Finance")) {
                comboOrg.addItem(organization1);
            }
        }
    }
    private void btnRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordActionPerformed
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date dateobj = new Date();
        Boolean flagnew = true;

        for (WorkRequest wr : enterprise.getWorkQueue().getWorkRequestList()) {
            String str = wr.getReqByorganizationName();
            if (str != null) {
                if (str.equalsIgnoreCase("FundRaising Organization")) {
                    {
                        if (((FundWRequest) wr).getChequeNo().equalsIgnoreCase(tflTransactionRef.getText())) {
                            flagnew = false;
                            JOptionPane.showMessageDialog(this, "Fund with same Transaction Code already Exist.Please Check", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }
            }
        }
        if (flagnew == true) {
            if (Validateinput() == true) {
                Organization org = null;
                for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof FundRaisingOrganization) {
                        org = organization1;
                        break;
                    }
                }
                FundWRequest requestnew = new FundWRequest();
                /*FieldsRequired for FinanceTeam Organization*/
                requestnew.setRequestedOn(dateobj);
                requestnew.setDescription(tflDescription.getText());
                requestnew.setRequestedby(userAccount);
                requestnew.setOrganizationName(comboOrg.getSelectedItem().toString());
                requestnew.setReqByorganizationName("FundRaising Organization");
                requestnew.setStatus("Sent");

                /*Fields Required forFundRaising Organization */
                requestnew.setSource(tflSrcName.getText());
                requestnew.setTransferMode(String.valueOf(cmbTmode.getSelectedItem()));
                requestnew.setFundingamt(Double.parseDouble(tflfundingAmt.getText()));
                requestnew.setEstimateDate(cmbcalestimaDate.getDate());

                /*Fields Required for Finance team - Statements page  */
                requestnew.setNarration("Donation - Fundraising");
                requestnew.setChequeNo(tflTransactionRef.getText());
                requestnew.setDebit(0.0);
                requestnew.setCredit(Double.parseDouble(tflfundingAmt.getText()));

                if (org != null) {
                    enterprise.getWorkQueue().getWorkRequestList().add(requestnew);
                    JOptionPane.showMessageDialog(null, "Funds Recorded and Request send to Finance Dept for Notification");
                    populateFundRaisingTab();

                }
            }
        }
    }//GEN-LAST:event_btnRecordActionPerformed

    private void comboOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboOrgActionPerformed
    public boolean Validateinput() {
        boolean flag = true;

        /* Manadatory Check */
        if (tflSrcName.getText().isEmpty()) {
            flag = false;
            JOptionPane.showMessageDialog(null, "All fields are Mandatory. Please enter Source of Funding", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!(Pattern.matches("[a-zA-Z]+", tflSrcName.getText()))) {
            flag = false;
            JOptionPane.showMessageDialog(null, "Invalid Source name", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (tflfundingAmt.getText().isEmpty()) {
            flag = false;
            JOptionPane.showMessageDialog(null, "All fields are Mandatory. Please enter Funding", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (tflTransactionRef.getText().isEmpty()) {
            flag = false;
            JOptionPane.showMessageDialog(this, "All fields are Mandatory. Please enter Transaction Reference Number", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ((!(Pattern.matches("[0-9a-zA-Z]+", tflTransactionRef.getText())))) {
            flag = false;
        } else {
            try {

                double val = Double.parseDouble(tflfundingAmt.getText());
            } catch (IllegalArgumentException ex) {
                flag = false;
                JOptionPane.showMessageDialog(null, "Invalid Funding  Amount", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
        return flag;
    }

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TxtDoj;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnRecord;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbSex;
    private javax.swing.JComboBox<String> cmbTmode;
    private de.wannawork.jcalendar.JCalendarComboBox cmbcalFrom;
    private de.wannawork.jcalendar.JCalendarComboBox cmbcalTo;
    private de.wannawork.jcalendar.JCalendarComboBox cmbcalestimaDate;
    private javax.swing.JComboBox comboOrg;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContactHeader;
    private javax.swing.JLabel lblFundHeader;
    private javax.swing.JPanel pnlContactInfo;
    private javax.swing.JPanel pnlContactInfoBody;
    private javax.swing.JPanel pnlContactinfoHeader;
    private javax.swing.JPanel pnlEmployementBody;
    private javax.swing.JPanel pnlEmploymentDetails;
    private javax.swing.JPanel pnlEmploymentHeader;
    private javax.swing.JPanel pnlFinancialAccounts;
    private javax.swing.JPanel pnlFundBody;
    private javax.swing.JPanel pnlFundRaising;
    private javax.swing.JPanel pnlFundTansferActivity;
    private javax.swing.JPanel pnlManageFunds;
    private javax.swing.JPanel pnlManageFundsHeader;
    private javax.swing.JPanel pnlPersonalBody;
    private javax.swing.JPanel pnlPersonalDeatails;
    private javax.swing.JPanel pnlPersonalHeader;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JPanel pnlSubHead;
    private javax.swing.JPanel pnlTaxFundsBody;
    private javax.swing.JTabbedPane tbdPaneFundRaisingWa;
    private javax.swing.JTable tbltransferSt;
    private javax.swing.JTextField tflAddress1;
    private javax.swing.JTextField tflAddress2;
    private javax.swing.JTextField tflAge;
    private javax.swing.JTextField tflCity;
    private javax.swing.JTextField tflCountry;
    private javax.swing.JTextField tflDescription;
    private javax.swing.JTextField tflDoj;
    private javax.swing.JTextField tflEmailID;
    private javax.swing.JTextField tflFirstName;
    private javax.swing.JTextField tflLastName;
    private javax.swing.JTextField tflMobile;
    private javax.swing.JTextField tflOrganization;
    private javax.swing.JTextField tflRole;
    private javax.swing.JTextField tflSrcName;
    private javax.swing.JTextField tflState;
    private javax.swing.JTextField tflTransactionRef;
    private javax.swing.JTextField tflWorkExp;
    private javax.swing.JTextField tflfundingAmt;
    private javax.swing.JLabel txtAddress1;
    private javax.swing.JLabel txtAge;
    private javax.swing.JLabel txtBankAcc;
    private javax.swing.JLabel txtCity;
    private javax.swing.JLabel txtCountry;
    private javax.swing.JLabel txtDescription;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtEmployementHeader;
    private javax.swing.JLabel txtEstimateDate;
    private javax.swing.JLabel txtFirstName;
    private javax.swing.JLabel txtFromDate;
    private javax.swing.JLabel txtFundingAmt;
    private javax.swing.JLabel txtFundingMode;
    private javax.swing.JLabel txtLastName;
    private javax.swing.JLabel txtMfundsHeader;
    private javax.swing.JLabel txtMobile;
    private javax.swing.JLabel txtOrganization;
    private javax.swing.JLabel txtOrganization1;
    private javax.swing.JLabel txtPersonalHeader;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtSex;
    private javax.swing.JLabel txtState;
    private javax.swing.JLabel txtToDate1;
    private javax.swing.JLabel txtWorkExp;
    private javax.swing.JLabel txtaddress2;
    private javax.swing.JLabel txttransactionRefno;
    // End of variables declaration//GEN-END:variables
}
