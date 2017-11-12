/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DataTeamRole;

import Business.Data.HomelessData;
import Business.Enterprise.Enterprise;
import Business.Organization.DatateamOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DataWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author VinothPMoorthy
 */
public class DataTeamWorkAreaJPanel extends javax.swing.JPanel {

     /**
     * Creates new form DataTeamWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private DatateamOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private ImageIcon storeImage;

    public DataTeamWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, DatateamOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        populateTable();
        panelView.setVisible(false);
        populateRequestTable();
        populateBarGraph();
        populateProfileTab();
        btnSave.setEnabled(false);
    }

    public void populateBarGraph() {
        DefaultPieDataset pieDataSet = new DefaultKeyedValuesDataset();
        
        ArrayList<HomelessData> home1 = new ArrayList<HomelessData>();
        for (int i = 0; i < organization.getHomelessDataList().size(); i++) {
            int noOfPeople1 = 0, flag = 0, flag1 = 0;
            for (HomelessData homeless : organization.getHomelessDataList()) {
                if (homeless.getAgeGroup().equals(organization.getHomelessDataList().get(i).getAgeGroup())) {
                    noOfPeople1 += homeless.getNoOfPeople();
                    flag1 = 1;
                }

            }
            if (!home1.isEmpty()) {
                for (HomelessData h1 : home1) {
                    if (organization.getHomelessDataList().get(i).getAgeGroup().equals(h1.getAgeGroup())) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                HomelessData hd = new HomelessData();
                hd.setAgeGroup(organization.getHomelessDataList().get(i).getAgeGroup());
                if (flag1 == 1) {
                    hd.setNoOfPeople(noOfPeople1);
                } else {
                    hd.setNoOfPeople(organization.getHomelessDataList().get(i).getNoOfPeople());
                }
                home1.add(hd);
            }
        }
        for (int i = 0; i < home1.size(); i++) {
            
            pieDataSet.setValue(home1.get(i).getAgeGroup(), new Integer(home1.get(i).getNoOfPeople()));
            
        }

        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart", pieDataSet, true, true, true);
        PiePlot3D p = (PiePlot3D) chart.getPlot();
        p.setStartAngle(290);
        //p.setDirection(Rotation.CLOCKWISE);
        p.setForegroundAlpha(0.5f);
        chart.setBackgroundPaint(Color.YELLOW);
        chart.getTitle().setPaint(Color.red); 
        p.setOutlinePaint(Color.red);
        p.setBackgroundPaint(Color.BLUE);
        ChartPanel frame = new ChartPanel(plotLocation());
        ChartPanel frame1 = new ChartPanel(plotReason());
        ChartPanel frame2 = new ChartPanel(chart);
        ChartPanel frame3 = new ChartPanel(chart);
        frame.setSize(350, 250);
        pnlGraph.removeAll();
        pnlGraph.setLayout(new java.awt.BorderLayout());
        pnlGraph.setLayout(new GridLayout(2, 2));
//      jPanel1.setSize(450,350);
        pnlGraph.add(frame, BorderLayout.EAST);
        pnlGraph.add(frame1, BorderLayout.EAST);
        pnlGraph.add(frame2, BorderLayout.EAST);
        pnlGraph.add(frame3, BorderLayout.EAST);

        pnlGraph.validate();
    }

    public JFreeChart plotLocation() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        ArrayList<HomelessData> home1 = new ArrayList<HomelessData>();

        for (int i = 0; i < organization.getHomelessDataList().size(); i++) {
            int noOfPeople1 = 0, flag = 0, flag1 = 0;
            for (HomelessData homeless : organization.getHomelessDataList()) {
                if (homeless.getLocation().equals(organization.getHomelessDataList().get(i).getLocation())) {
                    noOfPeople1 += homeless.getNoOfPeople();
                    flag1 = 1;
                }

            }
            if (!home1.isEmpty()) {
                for (HomelessData h1 : home1) {
                    if (organization.getHomelessDataList().get(i).getLocation().equals(h1.getLocation())) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                HomelessData hd = new HomelessData();
                hd.setLocation(organization.getHomelessDataList().get(i).getLocation());
                if (flag1 == 1) {
                    hd.setNoOfPeople(noOfPeople1);
                } else {
                    hd.setNoOfPeople(organization.getHomelessDataList().get(i).getNoOfPeople());
                }
                home1.add(hd);
            }
        }
        for (int i = 0; i < home1.size(); i++) {
            dataSet.setValue(home1.get(i).getNoOfPeople(), "values", home1.get(i).getLocation());
        }

        JFreeChart chart = ChartFactory.createBarChart("Homeless people data", "location", "no of homeless people", dataSet, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(Color.YELLOW);
        chart.getTitle().setPaint(Color.red);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);
       try {

            ChartUtilities.saveChartAsJPEG(new File("/Users/VinothPMoorthy/Documents/AED/Repository/FinalProjectFall2016/aed_fall_2016_project_vinoth_punniyamoorthy_001225656/HelpingHands/Barchart1.jpg"), chart, 500, 300);

            ChartUtilities.saveChartAsJPEG(new File("/Users/VinothPMoorthy/Documents/AED/Repository/FinalProjectFall2016/aed_fall_2016_project_vinoth_punniyamoorthy_001225656/HelpingHands/Barchart1.jpg"), chart, 500, 300);

        } catch (IOException e) {
            System.err.println("Problem occurred creating chart.");
        }
        return chart;
    }

    public JFreeChart plotReason() {
        DefaultCategoryDataset dataSet1 = new DefaultCategoryDataset();

        ArrayList<HomelessData> home = new ArrayList<HomelessData>();

        for (int i = 0; i < organization.getHomelessDataList().size(); i++) {
            int noOfPeople = 0, flag = 0, flag1 = 0;
            for (HomelessData homeless : organization.getHomelessDataList()) {
                if (homeless.getReason().equals(organization.getHomelessDataList().get(i).getReason())) {
                    noOfPeople += homeless.getNoOfPeople();
                    flag1 = 1;
                }

            }
            if (!home.isEmpty()) {
                for (HomelessData h1 : home) {
                    if (organization.getHomelessDataList().get(i).getReason().equals(h1.getReason())) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                HomelessData hd = new HomelessData();
                hd.setReason(organization.getHomelessDataList().get(i).getReason());
                if (flag1 == 1) {
                    hd.setNoOfPeople(noOfPeople);
                } else {
                    hd.setNoOfPeople(organization.getHomelessDataList().get(i).getNoOfPeople());
                }

                home.add(hd);
            }
        }
        for (int i = 0; i < home.size(); i++) {
            dataSet1.setValue(home.get(i).getNoOfPeople(), "values", home.get(i).getReason());
        }

        JFreeChart chart1 = ChartFactory.createBarChart("Homeless people data", "Reason for homelessness", "no of homeless people", dataSet1, PlotOrientation.VERTICAL, false, true, false);
        chart1.setBackgroundPaint(Color.YELLOW);
        chart1.getTitle().setPaint(Color.red);
        CategoryPlot p1 = chart1.getCategoryPlot();
        p1.setRangeGridlinePaint(Color.BLUE);
        try {

            //ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\user\\AED_LAB\\aed_fall_2016_project_vinoth_punniyamoorthy_001225656\\Barchart.jpg"), chart1, 500, 300);

            ChartUtilities.saveChartAsJPEG(new File("/Users/VinothPMoorthy/Documents/AED/Repository/FinalProjectFall2016/aed_fall_2016_project_vinoth_punniyamoorthy_001225656/HelpingHands/Barchart2.jpg"), chart1, 500, 300);

        } catch (IOException e) {
            System.err.println("Problem occurred creating chart.");
        }
        return chart1;
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        tabbedPane = new javax.swing.JTabbedPane();
        userPanel = new javax.swing.JPanel();
        pnlButton = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlGraph = new javax.swing.JPanel();
        dataPanel = new javax.swing.JPanel();
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
        workRequestPanel = new javax.swing.JPanel();
        scrollPaneDetails = new javax.swing.JScrollPane();
        tblDetails = new javax.swing.JTable();
        btnViewDetails = new javax.swing.JButton();
        btnAddDetails = new javax.swing.JButton();
        panelView = new javax.swing.JPanel();
        lblLocation = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        lblReason = new javax.swing.JLabel();
        txtReason = new javax.swing.JTextField();
        lblCount = new javax.swing.JLabel();
        txtCount = new javax.swing.JTextField();
        lblAgeGroup = new javax.swing.JLabel();
        txtAgeGroup = new javax.swing.JTextField();
        lblDisease = new javax.swing.JLabel();
        txtDisease = new javax.swing.JTextField();
        lblFamilies = new javax.swing.JLabel();
        txtFamilies = new javax.swing.JTextField();
        lblTimestamp = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        lblCreated = new javax.swing.JLabel();
        txtModified = new javax.swing.JTextField();
        dataAnalysisPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        pnlPersonalBody3 = new javax.swing.JPanel();
        btnRequest = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequest = new javax.swing.JTable();
        pnlPersonalHeader3 = new javax.swing.JPanel();
        txtPersonalHeader3 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPane.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        pnlButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        pnlButton.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, -1, -1));

        pnlGraph.setBackground(new java.awt.Color(255, 255, 255));
        pnlGraph.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane2.setViewportView(pnlGraph);

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, 1358, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
        );

        tabbedPane.addTab("Data analysis", userPanel);

        pnlProfile.setBackground(new java.awt.Color(255, 255, 255));
        pnlProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContactInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlContactInfo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlContactInfo.setPreferredSize(new java.awt.Dimension(685, 307));

        pnlContactinfoHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlContactinfoHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(txtaddress2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
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
                        .addComponent(pnlContactInfoBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 13, Short.MAX_VALUE)))
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

        pnlProfile.add(pnlContactInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 720, 220));

        pnlPersonalDeatails.setBackground(new java.awt.Color(255, 255, 255));
        pnlPersonalDeatails.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlPersonalHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlPersonalHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addContainerGap(575, Short.MAX_VALUE))
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
                .addContainerGap(40, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlProfile.add(pnlPersonalDeatails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 720, 240));

        pnlEmploymentDetails.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmploymentDetails.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlEmploymentHeader.setBackground(new java.awt.Color(102, 102, 102));
        pnlEmploymentHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addContainerGap(576, Short.MAX_VALUE))
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
                    .addComponent(tflWorkExp, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
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

        pnlProfile.add(pnlEmploymentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 720, 140));

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

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 1358, Short.MAX_VALUE)
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("User profile", dataPanel);

        workRequestPanel.setBackground(new java.awt.Color(255, 255, 255));
        workRequestPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location", "No. of homeless people", "Reason for homelessness", "Age group"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneDetails.setViewportView(tblDetails);

        workRequestPanel.add(scrollPaneDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 6, 573, 89));

        btnViewDetails.setText("View details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });
        workRequestPanel.add(btnViewDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 107, -1, -1));

        btnAddDetails.setText("Add details");
        btnAddDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDetailsActionPerformed(evt);
            }
        });
        workRequestPanel.add(btnAddDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 107, -1, -1));

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        lblLocation.setText("Location:");

        lblReason.setText("Major reason for homelessness:");

        lblCount.setText("No of people:");

        lblAgeGroup.setText("Age group:");

        lblDisease.setText("Chronic diseases:");

        lblFamilies.setText("No of families:");

        lblTimestamp.setText("Timestamp:");

        lblCreated.setText("Created by:");

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelViewLayout.createSequentialGroup()
                            .addComponent(lblCreated)
                            .addGap(18, 18, 18)
                            .addComponent(txtModified, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelViewLayout.createSequentialGroup()
                            .addComponent(lblTimestamp)
                            .addGap(18, 18, 18)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelViewLayout.createSequentialGroup()
                            .addComponent(lblFamilies)
                            .addGap(18, 18, 18)
                            .addComponent(txtFamilies, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelViewLayout.createSequentialGroup()
                            .addComponent(lblDisease)
                            .addGap(18, 18, 18)
                            .addComponent(txtDisease, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelViewLayout.createSequentialGroup()
                                .addComponent(lblAgeGroup)
                                .addGap(18, 18, 18)
                                .addComponent(txtAgeGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelViewLayout.createSequentialGroup()
                                    .addComponent(lblCount)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelViewLayout.createSequentialGroup()
                                        .addComponent(lblLocation)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelViewLayout.createSequentialGroup()
                                        .addComponent(lblReason)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtReason, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addContainerGap(389, Short.MAX_VALUE)))
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
            .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLocation)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblReason)
                        .addComponent(txtReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCount)
                        .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAgeGroup)
                        .addComponent(txtAgeGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDisease)
                        .addComponent(txtDisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFamilies)
                        .addComponent(txtFamilies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTimestamp)
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtModified, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCreated))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        workRequestPanel.add(panelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 731, -1));

        tabbedPane.addTab("Overall data", workRequestPanel);

        dataAnalysisPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "Organization", "Status" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter By"));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton2.setText("Search");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dataAnalysisPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 52, -1, -1));

        pnlPersonalBody3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
        jScrollPane1.setViewportView(tblWorkRequest);

        javax.swing.GroupLayout pnlPersonalBody3Layout = new javax.swing.GroupLayout(pnlPersonalBody3);
        pnlPersonalBody3.setLayout(pnlPersonalBody3Layout);
        pnlPersonalBody3Layout.setHorizontalGroup(
            pnlPersonalBody3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalBody3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlPersonalBody3Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(btnRequest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPersonalBody3Layout.setVerticalGroup(
            pnlPersonalBody3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalBody3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRequest)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        dataAnalysisPanel.add(pnlPersonalBody3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 120, -1, -1));

        pnlPersonalHeader3.setBackground(new java.awt.Color(51, 153, 255));
        pnlPersonalHeader3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPersonalHeader3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPersonalHeader3.setText("WorkRequests Pool ");

        javax.swing.GroupLayout pnlPersonalHeader3Layout = new javax.swing.GroupLayout(pnlPersonalHeader3);
        pnlPersonalHeader3.setLayout(pnlPersonalHeader3Layout);
        pnlPersonalHeader3Layout.setHorizontalGroup(
            pnlPersonalHeader3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalHeader3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtPersonalHeader3)
                .addContainerGap(1206, Short.MAX_VALUE))
        );
        pnlPersonalHeader3Layout.setVerticalGroup(
            pnlPersonalHeader3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPersonalHeader3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        dataAnalysisPanel.add(pnlPersonalHeader3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        tabbedPane.addTab("Work requests", dataAnalysisPanel);

        add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 810));
    }// </editor-fold>//GEN-END:initComponents


    private void btnAddDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDetailsActionPerformed
             // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("AddDataJPanel", new AddDataJPanel(userProcessContainer, userAccount, enterprise, organization));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddDetailsActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
         // TODO add your handling code here:
        panelView.setVisible(true);
        int selectedRow = tblDetails.getSelectedRow();
        if (selectedRow >= 0) {
            HomelessData data = (HomelessData) tblDetails.getValueAt(selectedRow, 0);
            txtLocation.setText(data.getLocation());
            txtReason.setText(data.getReason());
            txtCount.setText(String.valueOf(data.getNoOfPeople()));
            txtAgeGroup.setText(data.getAgeGroup());
            txtDisease.setText(data.getDiseases());
            txtFamilies.setText(String.valueOf(data.getNoOfFamilies()));
            txtTime.setText(String.valueOf(data.getTimeStamp()));
            txtModified.setText(data.getCreatedBy());
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from the table", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnViewDetailsActionPerformed

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

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
              // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("DataTeamWorkRequestJPanel", new DataTeamWorkRequestJPanel(userProcessContainer, userAccount, enterprise));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
       populateBarGraph();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tflFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflFirstNameActionPerformed
        // TODO add your handling code here:
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
            userAccount.getUserProfile().setOrganization("FinanceManagement");
            userAccount.getUserProfile().setRole("Finance-Analyst");
            userAccount.getUserProfile().setDOJ(tflDoj.getText());
            userAccount.getUserProfile().setWrkEx(tflWorkExp.getText());
            JOptionPane.showMessageDialog(null, "User Profile Updated Successfully!!");
            btnEdit.setEnabled(true);
            btnSave.setEnabled(false);
            changemode(false);
        }
       
    }//GEN-LAST:event_btnSaveActionPerformed

    public void populateProfileTab() {
        changemode(false);
        tflFirstName.setText(userAccount.getEmployee().getName());
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
        tflOrganization.setText("DataManagement");
        tflRole.setText("Data-Analyst");
        tflDoj.setText(userAccount.getUserProfile().getDOJ());
        tflWorkExp.setText(userAccount.getUserProfile().getWrkEx());

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

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblDetails.getModel();

        model.setRowCount(0);
        for (HomelessData request : organization.getHomelessDataList()) {
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getNoOfPeople();
            row[2] = request.getReason();
            row[3] = request.getAgeGroup();
            model.addRow(row);
        }
    }
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TxtDoj;
    private javax.swing.JButton btnAddDetails;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JComboBox<String> cmbSex;
    private javax.swing.JPanel dataAnalysisPanel;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblAgeGroup;
    private javax.swing.JLabel lblContactHeader;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblCreated;
    private javax.swing.JLabel lblDisease;
    private javax.swing.JLabel lblFamilies;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblReason;
    private javax.swing.JLabel lblTimestamp;
    private javax.swing.JPanel panelView;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlContactInfo;
    private javax.swing.JPanel pnlContactInfoBody;
    private javax.swing.JPanel pnlContactinfoHeader;
    private javax.swing.JPanel pnlEmployementBody;
    private javax.swing.JPanel pnlEmploymentDetails;
    private javax.swing.JPanel pnlEmploymentHeader;
    private javax.swing.JPanel pnlGraph;
    private javax.swing.JPanel pnlPersonalBody;
    private javax.swing.JPanel pnlPersonalBody3;
    private javax.swing.JPanel pnlPersonalDeatails;
    private javax.swing.JPanel pnlPersonalHeader;
    private javax.swing.JPanel pnlPersonalHeader3;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JScrollPane scrollPaneDetails;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tblDetails;
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
    private javax.swing.JTextField txtAgeGroup;
    private javax.swing.JLabel txtCity;
    private javax.swing.JTextField txtCount;
    private javax.swing.JLabel txtCountry;
    private javax.swing.JTextField txtDisease;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtEmployementHeader;
    private javax.swing.JTextField txtFamilies;
    private javax.swing.JLabel txtFirstName;
    private javax.swing.JLabel txtLastName;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JLabel txtMobile;
    private javax.swing.JTextField txtModified;
    private javax.swing.JLabel txtOrganization;
    private javax.swing.JLabel txtPersonalHeader;
    private javax.swing.JLabel txtPersonalHeader3;
    private javax.swing.JTextField txtReason;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtSex;
    private javax.swing.JLabel txtState;
    private javax.swing.JTextField txtTime;
    private javax.swing.JLabel txtWorkExp;
    private javax.swing.JLabel txtaddress2;
    private javax.swing.JPanel userPanel;
    private javax.swing.JPanel workRequestPanel;
    // End of variables declaration//GEN-END:variables
}
