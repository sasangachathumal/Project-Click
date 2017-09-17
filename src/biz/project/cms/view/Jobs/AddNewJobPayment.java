/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.view.Jobs;

import biz.project.cms.controller.CustomerController;
import biz.project.cms.controller.JobCategoryController;
import biz.project.cms.controller.JobController;
import biz.project.cms.controller.JobPaymentController;
import biz.project.cms.fileaccess.LoggerFileAcceess;
import biz.project.cms.model.Accounts;
import biz.project.cms.model.Customer;
import biz.project.cms.model.Job;
import biz.project.cms.model.JobCategory;
import biz.project.cms.model.JobCheque;
import biz.project.cms.model.JobPayment;
import biz.project.cms.other.IdGenerator;
import biz.project.cms.other.Validation;
import biz.project.cms.view.main.HomeFrame;
import java.awt.Color;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

/**
 *
 * @author Dilhan Mendis
 */
public class AddNewJobPayment extends javax.swing.JDialog {

    private DefaultTableModel dtm;
    private String jobId;
    private double dueBalance;
    private ManageJob manageJob;

    /**
     * Creates new form addNewJobPayment
     *
     * @param parent
     * @param modal
     */
    public AddNewJobPayment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //
        UIManager UI = new UIManager();
        UIManager.put("OptionPane.background", Color.white);
        UIManager.put("Panel.background", Color.white);

    }

    public AddNewJobPayment(java.awt.Frame parent, boolean modal, String jobId, double dueBalance, ManageJob manageJob) {
        super(parent, modal);
        initComponents();
        this.manageJob = manageJob;
        //
        UIManager UI = new UIManager();
        this.setIconImage(new ImageIcon(getClass().getResource("/image/Home/Logo Company.png")).getImage());
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        //
        this.jobId = jobId;
        this.dueBalance = dueBalance;
        txtJobId.setText(jobId);
        txtDuePayment.setText(dueBalance + "");
        txtChequeNo.setEnabled(false);
        datepickerChequeDate.setEnabled(false);
        cmbBankName.setEnabled(false);
        rbtnCash.setRequestFocusEnabled(true);
        try {
            getPaymentId();
            loadPayments();
        } catch (SQLException | ClassNotFoundException ex) {
            StringWriter sw = new StringWriter();
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace(new PrintWriter(sw));
            String trace = sw.toString();
            LoggerFileAcceess.exceptionLogger(trace);
        }
        if (dueBalance == 0) {
            rbtnCash.setEnabled(false);
            rbtnCheque.setEnabled(false);
            txtChequeNo.setEnabled(false);
            datepickerChequeDate.setEnabled(false);
            btnPay.setEnabled(false);
        }
        tblAllPayments.setOpaque(true);
        tblAllPayments.setFillsViewportHeight(true);
        tblAllPayments.setBackground(Color.WHITE);
        setLocationRelativeTo(parent);
        setTitle("Job Payment");
    }

    private void print(Customer c, Job j, JobCategory jc) {
        HashMap<String, Object> map = new HashMap<>();
        JRTableModelDataSource dataSource = new JRTableModelDataSource(dtm);
        try {
            double bal = Double.parseDouble(txtDuePayment.getText()) - Double.parseDouble(txtAmount.getText());
            String type = "--";
            if (rbtnCash.isSelected()) {
                type = "CASH";
            }
            if (rbtnCheque.isSelected()) {
                type = "CHEQUE";
            }

            JasperReport compileReport = JasperCompileManager.compileReport(getClass()
                    .getResourceAsStream("/reports/ServiceNote_1.jrxml"));

            map.put("INVOICE NO", txtJobId.getText());
            map.put("NAME", c.getName());
            map.put("TELEPHONE", c.getContact() + "");
            map.put("TYPE", jc.getTitle());
            map.put("TOTAL", j.getTotalAmount() + "");
            map.put("BALANCE", bal + "");
            map.put("PTYPE", type);
            map.put("DUE", txtDuePayment.getText());
            map.put("AMOUNT", txtAmount.getText());
            map.put("DESC", j.getDescription());
            map.put("USER", HomeFrame.user.getUsername());
            JasperPrint fillReport = JasperFillManager.fillReport(compileReport, map, dataSource);
            //JasperViewer.viewReport(fillReport, false);
            JasperPrintManager.printReport(fillReport, false);
        } catch (NumberFormatException | JRException ex) {
            StringWriter sw = new StringWriter();
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace(new PrintWriter(sw));
            String trace = sw.toString();
            LoggerFileAcceess.exceptionLogger(trace);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelMain = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        scrlPayments = new javax.swing.JScrollPane();
        tblAllPayments = new javax.swing.JTable();
        lblPaymentId = new javax.swing.JLabel();
        lblJobId = new javax.swing.JLabel();
        lblDueBalance = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblChequeNumber = new javax.swing.JLabel();
        lblChequeDate = new javax.swing.JLabel();
        lblbankName = new javax.swing.JLabel();
        txtPaymentId = new javax.swing.JTextField();
        txtJobId = new javax.swing.JTextField();
        txtDuePayment = new javax.swing.JTextField();
        rbtnCash = new javax.swing.JRadioButton();
        rbtnCheque = new javax.swing.JRadioButton();
        txtChequeNo = new javax.swing.JTextField();
        datepickerChequeDate = new org.jdesktop.swingx.JXDatePicker();
        txtAmount = new javax.swing.JTextField();
        btnPay = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmbBankName = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        panelTitle.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/job.png"))); // NOI18N
        lblTitle.setText("New job Payment");
        lblTitle.setIconTextGap(15);

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Payment History", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 255))); // NOI18N

        tblAllPayments.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tblAllPayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pay.Id", "Date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAllPayments.setRowHeight(22);
        tblAllPayments.setSelectionBackground(new java.awt.Color(0, 204, 153));
        tblAllPayments.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAllPayments.getTableHeader().setReorderingAllowed(false);
        scrlPayments.setViewportView(tblAllPayments);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrlPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrlPayments, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblPaymentId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPaymentId.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPaymentId.setText("Payment Id   :");

        lblJobId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblJobId.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblJobId.setText("Job Id   :");

        lblDueBalance.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDueBalance.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDueBalance.setText("Due Bal.   :");

        lblAmount.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAmount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblAmount.setText("Amount  :");

        lblType.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblType.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblType.setText("Type   :");

        lblChequeNumber.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblChequeNumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblChequeNumber.setText("Cheque No  :");

        lblChequeDate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblChequeDate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblChequeDate.setText("Cheque Date :");

        lblbankName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblbankName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblbankName.setText("Bank  :");

        txtPaymentId.setEditable(false);
        txtPaymentId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPaymentId.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPaymentId.setSelectionColor(new java.awt.Color(102, 51, 255));

        txtJobId.setEditable(false);
        txtJobId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtJobId.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtJobId.setSelectionColor(new java.awt.Color(102, 51, 255));

        txtDuePayment.setEditable(false);
        txtDuePayment.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDuePayment.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDuePayment.setSelectionColor(new java.awt.Color(102, 51, 255));

        rbtnCash.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnCash);
        rbtnCash.setSelected(true);
        rbtnCash.setText("  Cash");
        rbtnCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCashActionPerformed(evt);
            }
        });

        rbtnCheque.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnCheque);
        rbtnCheque.setText("  Cheque");
        rbtnCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnChequeActionPerformed(evt);
            }
        });

        txtChequeNo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtChequeNo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtChequeNo.setSelectionColor(new java.awt.Color(102, 51, 255));
        txtChequeNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtChequeNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtChequeNoKeyTyped(evt);
            }
        });

        txtAmount.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAmount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtAmount.setSelectionColor(new java.awt.Color(102, 51, 255));
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountKeyTyped(evt);
            }
        });

        btnPay.setBackground(new java.awt.Color(255, 255, 255));
        btnPay.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnPay.setText("Pay");
        btnPay.setToolTipText("Create for Cheque details.Click this");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setToolTipText("Create for Cheque details.Click this");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cmbBankName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sampath Bank", "Commercial Bank", "Nation's Trust Bank", "BOC", "People's Bank", "DFCC Bank", "Pan Asia Bank", "Seylan Bank", "Other" }));
        cmbBankName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBankNameActionPerformed(evt);
            }
        });
        cmbBankName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbBankNameKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(lblDueBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDuePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(lblJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(lblPaymentId, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPaymentId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblChequeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblChequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datepickerChequeDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtChequeNo)))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(rbtnCash, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 9, Short.MAX_VALUE))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblbankName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelMainLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE))
                                    .addGroup(panelMainLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(cmbBankName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))))
                        .addGap(10, 10, 10)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPaymentId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPaymentId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDueBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDuePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnCash)
                            .addComponent(rbtnCheque)
                            .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChequeNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChequeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datepickerChequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblbankName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        try {
            checkPayment();
        } catch (ClassNotFoundException ex) {
            StringWriter sw = new StringWriter();
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace(new PrintWriter(sw));
            String trace = sw.toString();
            LoggerFileAcceess.exceptionLogger(trace);
        }

    }//GEN-LAST:event_btnPayActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        btnPay.doClick();
    }//GEN-LAST:event_txtAmountActionPerformed

    private void rbtnCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCashActionPerformed
        txtChequeNo.setEnabled(false);
        datepickerChequeDate.setEnabled(false);
        cmbBankName.setEnabled(false);
        txtAmount.setRequestFocusEnabled(true);
    }//GEN-LAST:event_rbtnCashActionPerformed

    private void rbtnChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnChequeActionPerformed
        txtChequeNo.setEnabled(true);
        datepickerChequeDate.setEnabled(true);
        cmbBankName.setEnabled(true);
        txtChequeNo.setRequestFocusEnabled(true);
    }//GEN-LAST:event_rbtnChequeActionPerformed

    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyReleased
        Validation.priceText(txtAmount);
    }//GEN-LAST:event_txtAmountKeyReleased

    private void txtAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyTyped
        Validation.priceText(txtAmount);
    }//GEN-LAST:event_txtAmountKeyTyped

    private void cmbBankNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBankNameActionPerformed

    }//GEN-LAST:event_cmbBankNameActionPerformed

    private void cmbBankNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbBankNameKeyPressed

    }//GEN-LAST:event_cmbBankNameKeyPressed

    private void txtChequeNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChequeNoKeyReleased
        Validation.numberOnly(txtChequeNo);
    }//GEN-LAST:event_txtChequeNoKeyReleased

    private void txtChequeNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChequeNoKeyTyped
        Validation.numberOnly(txtChequeNo);
    }//GEN-LAST:event_txtChequeNoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewJobPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewJobPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewJobPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewJobPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddNewJobPayment dialog = new AddNewJobPayment(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPay;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbBankName;
    private org.jdesktop.swingx.JXDatePicker datepickerChequeDate;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblChequeDate;
    private javax.swing.JLabel lblChequeNumber;
    private javax.swing.JLabel lblDueBalance;
    private javax.swing.JLabel lblJobId;
    private javax.swing.JLabel lblPaymentId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblbankName;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JRadioButton rbtnCash;
    private javax.swing.JRadioButton rbtnCheque;
    private javax.swing.JScrollPane scrlPayments;
    private javax.swing.JTable tblAllPayments;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtChequeNo;
    private javax.swing.JTextField txtDuePayment;
    private javax.swing.JTextField txtJobId;
    private javax.swing.JTextField txtPaymentId;
    // End of variables declaration//GEN-END:variables

    private void loadPayments() throws SQLException, ClassNotFoundException {
        dtm = (DefaultTableModel) tblAllPayments.getModel();
        dtm.setRowCount(0);
        ArrayList<JobPayment> allPayments = JobPaymentController.getAllJobPaymentByJobID(jobId);
        if (allPayments.size() > 0) {
            for (JobPayment payment : allPayments) {
                Object[] row = {payment.getJobPayID(), payment.getDate(), payment.getAmount()};
                dtm.addRow(row);
            }
        }
    }

    private void getPaymentId() throws SQLException, ClassNotFoundException {
        String payId = IdGenerator.getNewId(3);
        txtPaymentId.setText(payId);
    }

    private String getDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    private String getTime() {
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        String format1 = time.format(new Date());
        return format1;
    }

    private void checkPayment() throws ClassNotFoundException {
        try {
            double amount = Double.parseDouble(txtAmount.getText());
            if (amount > 0) {
                Job j = JobController.searchJobById(txtJobId.getText());
                Customer c = null;
                JobCategory jc1 = null;
                if (j != null) {
                    c = CustomerController.searchCustomerByID(j.getCustId());
                    jc1 = JobCategoryController.searchJobCategorybyID(j.getJobCatId() + "");
                }
                if (amount <= dueBalance) {
                    JobPayment jp = null;
                    JobCheque jc = null;
                    if (rbtnCheque.isSelected()) {
                        String date = new SimpleDateFormat("yyyy-MM-dd").format(datepickerChequeDate.getDate());
                        jc = new JobCheque(txtChequeNo.getText(), date, cmbBankName.getSelectedItem() + "", txtPaymentId.getText());
                    }
                    jp = new JobPayment(txtPaymentId.getText(), getDate(), amount, jobId);
                    addJobPayment(jp, jc);
                    if (manageJob != null) {
                        manageJob.reloadAfterPayment();
                    }
                    this.dispose();
                    int i = JOptionPane.showConfirmDialog(this, "Do you want to print an invoice ?");
                    if (i == 0) {
                        print(c, j, jc1);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please Enter valid Amount...", "Warning", JOptionPane.WARNING_MESSAGE);
                    txtAmount.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Enter valid Amount...", "Warning", JOptionPane.WARNING_MESSAGE);
                txtAmount.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Number.", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            StringWriter sw = new StringWriter();
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace(new PrintWriter(sw));
            String trace = sw.toString();
            LoggerFileAcceess.exceptionLogger(trace);
        }
    }

    private void addJobPayment(JobPayment jp, JobCheque jc) throws ClassNotFoundException {
        Accounts accounts = null;
        accounts = new Accounts(0, 1, getDate(), getTime(), 2, "Add(From Job Payment.paymentId = " + txtPaymentId.getText() + ")", Double.parseDouble(txtAmount.getText()));
        new JobPaymentController().createNewJobPaymentWithTransaction(jp, accounts, jc);
    }
}
