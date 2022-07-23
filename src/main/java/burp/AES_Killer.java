/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;




/**
 *
 * @author n00b
 */
public class AES_Killer extends javax.swing.JPanel {

    /**
     * Creates new form AES_Killer
     */
    
    BurpExtender _burpObj;
    
    public AES_Killer(BurpExtender _b) {
        this._burpObj = _b;
        //this.callbacks = _b.callbacks;
        initComponents();

        //_b.callbacks.
        
        this.jCheckBox9.setSelected(true);
        this.jCheckBox10.setSelected(true);
        this.jCheckBox11.setSelected(true);
        this.jCheckBox12.setSelected(true);
        
        this.jCheckBox9.setEnabled(false);
        this.jCheckBox10.setEnabled(false);
        this.jCheckBox11.setEnabled(false);
        this.jCheckBox12.setEnabled(false);
    }

    private void loadConfig(){

            String AesKillerConfig = _burpObj.callbacks.loadExtensionSetting("AES_Killer_Data");

            try {
                Gson gson = new Gson();
                Type confMapType = new TypeToken<Map<String, Object>>() {
                }.getType();
                Map<String, Object> map = gson.fromJson(AesKillerConfig, confMapType);


                jTextField1.setText(map.get("jTextField1").toString());
                jTextField2.setText(map.get("jTextField2").toString());
                jTextField3.setText(map.get("jTextField3").toString());
                jTextField4.setText(map.get("jTextField4").toString());
                jTextField5.setText(map.get("jTextField5").toString());
                jTextField6.setText(map.get("jTextField6").toString());
                jTextField7.setText(map.get("jTextField7").toString());

                jCheckBox1.setSelected(Boolean.parseBoolean(map.get("jCheckBox1").toString()));
                jCheckBox2.setSelected(Boolean.parseBoolean(map.get("jCheckBox2").toString()));
                jCheckBox3.setSelected(Boolean.parseBoolean(map.get("jCheckBox3").toString()));
                jCheckBox4.setSelected(Boolean.parseBoolean(map.get("jCheckBox4").toString()));
                jCheckBox5.setSelected(Boolean.parseBoolean(map.get("jCheckBox5").toString()));
                jCheckBox6.setSelected(Boolean.parseBoolean(map.get("jCheckBox6").toString()));
                jCheckBox7.setSelected(Boolean.parseBoolean(map.get("jCheckBox7").toString()));
                jCheckBox8.setSelected(Boolean.parseBoolean(map.get("jCheckBox8").toString()));
                jCheckBox13.setSelected(Boolean.parseBoolean(map.get("jCheckBox13").toString()));
                jCheckBox14.setSelected(Boolean.parseBoolean(map.get("jCheckBox14").toString()));
                jCheckBox15.setSelected(Boolean.parseBoolean(map.get("jCheckBox15").toString()));
                jCheckBox16.setSelected(Boolean.parseBoolean(map.get("jCheckBox16").toString()));
                jCheckBox17.setSelected(Boolean.parseBoolean(map.get("jCheckBox17").toString()));

                jComboBox1.setSelectedItem(map.get("jComboBox1"));
                _burpObj.callbacks.printOutput(AesKillerConfig);
                _burpObj.callbacks.printOutput("AESKiller config loaded !");
            } catch (RuntimeException e) {
                _burpObj.callbacks.printError(e.toString());
                _burpObj.callbacks.printOutput("Error load AESKiller config !");
            }

    }

    private void saveConfig(){
        try {
            Object obj = this;
            Map<String, Object> map = new HashMap<>();
            // Convert a map having list of values.
            map.put("jTextField7", jTextField7.getText());
            map.put("jCheckBox8", jCheckBox8.isSelected());
            map.put("jCheckBox13", jCheckBox13.isSelected());
            map.put("jCheckBox14", jCheckBox14.isSelected());
            map.put("jComboBox1", jComboBox1.getSelectedItem());
            map.put("jTextField1", jTextField1.getText());
            map.put("jTextField2", jTextField2.getText());
            map.put("jCheckBox1", jCheckBox1.isSelected());
            map.put("jTextField5", jTextField5.getText());
            map.put("jTextField6", jTextField6.getText());
            map.put("jCheckBox2", jCheckBox2.isSelected());
            map.put("jCheckBox3", jCheckBox3.isSelected());
            map.put("jTextField3", jTextField3.getText());
            map.put("jCheckBox6", jCheckBox6.isSelected());
            map.put("jCheckBox16", jCheckBox16.isSelected());
            map.put("jCheckBox4", jCheckBox4.isSelected());
            map.put("jCheckBox5", jCheckBox5.isSelected());
            map.put("jTextField4", jTextField4.getText());
            map.put("jCheckBox7", jCheckBox7.isSelected());
            map.put("jCheckBox15", jCheckBox15.isSelected());
            map.put("jCheckBox17", jCheckBox17.isSelected());

            String AesKillerConfig = new Gson().toJson(map);

            _burpObj.callbacks.saveExtensionSetting("AES_Killer_Data", AesKillerConfig);
            _burpObj.callbacks.printOutput(AesKillerConfig);
            _burpObj.callbacks.printOutput("AESKiller config saved !");
        }
        catch (RuntimeException e) {
            _burpObj.callbacks.printError(e.toString());
            //this.callbacks.printOutput(e.toString());
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField3 = new javax.swing.JTextField();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jTextField4 = new javax.swing.JTextField();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane1.setDividerLocation(440);
        jSplitPane1.setDividerSize(20);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton1.setText("Stop AES Killer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Start AES Killer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Encrypt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Decrypt");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel10.setEnabled(false);

        jCheckBox9.setText("Proxy");

        jCheckBox10.setText("Repeater");

        jCheckBox11.setText("Scanner");

        jCheckBox12.setText("Intruder");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jCheckBox9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox11))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCheckBox10)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox12)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox11))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox12))
                .addGap(16, 16, 16))
        );

        jLabel8.setText("Host URL");

        jTextField7.setName("host_url"); // NOI18N

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jCheckBox8.setText("Do / Remove Obfuscation");

        jCheckBox13.setText("Enable Debug Mode");
        jCheckBox13.setName("isDebug"); // NOI18N

        jCheckBox14.setText("URL encode/decode");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox14)
                    .addComponent(jCheckBox13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox13)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton4)
                            .addGap(18, 18, 18)
                            .addComponent(jButton5))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField7))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 430, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(null);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Select Encryption");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AES/CBC/PKCS5Padding", "AES/ECB/PKCS5Padding", "GOST3412-2015/ECB/PKCS7Padding" }));
        jComboBox1.setName("encryption_type"); // NOI18N

        jLabel2.setText("Secret Key (Base64 Encoded)");

        jTextField1.setName("secretKey"); // NOI18N

        jLabel3.setText("IV (Base64 Encoded)");

        jTextField2.setName("iv"); // NOI18N

        jCheckBox1.setText("Exclude / Ignore IV");
        jCheckBox1.setName("excludeIV"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jCheckBox1))
                        .addGap(0, 204, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );

        jPanel4.add(jPanel5);
        jPanel5.setBounds(8, 7, 423, 270);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setText("Obff. char (Separated with space)");

        jTextField5.setName("off_char"); // NOI18N

        jLabel7.setText("Replace with (Separated with space)");

        jTextField6.setName("replace_with"); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel9);
        jPanel9.setBounds(450, 220, 540, 58);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setText("Request Options to Decrypt & Encrypt");

        buttonGroup2.add(jCheckBox2);
        jCheckBox2.setText("Complete Request Body");
        jCheckBox2.setName("req_body"); // NOI18N

        buttonGroup2.add(jCheckBox3);
        jCheckBox3.setText("Specific Request Parameters (Separated with space)");

        jTextField3.setName("req_parameter"); // NOI18N

        //buttonGroup3.add(jCheckBox6);
        jCheckBox6.setText("Override Complete request body (After decrypting - Form)");
        jCheckBox6.setName("override_req"); // NOI18N

        //buttonGroup3.add(jCheckBox16);
        jCheckBox16.setText("Override Complete request body (After decrypting - JSON)");
        jCheckBox16.setName("override_req"); // NOI18N


        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jCheckBox2)
                        .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox6)
                        .addComponent(jTextField3))
                    .addComponent(jCheckBox16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox16)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel7);
        jPanel7.setBounds(450, 10, 450, 200);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setText("Response Options to Decrypt & Encrypt");

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setText("Complete Response Body");
        jCheckBox4.setName("req_body"); // NOI18N

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setText("Specific Response Parameters (Separated with space)");

        jTextField4.setName("req_parameter"); // NOI18N

        //buttonGroup4.add(jCheckBox7);
        jCheckBox7.setText("Override Complete response body (After decrypting - Form)");
        jCheckBox7.setName("override_res"); // NOI18N
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox15);
        jCheckBox15.setText("Ignore Response");

        //buttonGroup4.add(jCheckBox17);
        jCheckBox17.setText("Override Complete response body (After decrypting - JSON)");
        jCheckBox17.setName("override_res"); // NOI18N
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jCheckBox4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox15))
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField4))
                    .addComponent(jCheckBox17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox17)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8);
        jPanel8.setBounds(910, 10, 460, 200);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel3.add(jScrollPane1);

        jTabbedPane3.addTab("Input", jPanel3);

        jPanel11.add(jTabbedPane3);

        jTabbedPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane4.addTab("Output", jPanel2);

        jPanel11.add(jTabbedPane4);

        jSplitPane1.setRightComponent(jPanel11);

        add(jSplitPane1);

        loadConfig();
    }// </editor-fold>//GEN-END:initComponents

    public Boolean is_string_empty(String _str){
        if(_str.length() == 0 || _str.isEmpty() || _str.equals("") || _str == null){
            return true;
        }
        return false;
    }
    
    
    public Boolean validate_host(){
        String _url = this.jTextField7.getText().trim();
        if(is_string_empty(_url)){ JOptionPane.showMessageDialog(this, "Please provide a Host URL !!!"); return false; }
        
        try{
            URL abc = new URL(_url);
            this._burpObj._host = abc.getHost();
            return true;
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Please provide a valid Host URL (e.g https://abc.com) !!!");
            return false;
        }
    }
    
    public Boolean validate_secret_key(){
        String _secret_key = this.jTextField1.getText().trim();
        if(is_string_empty(_secret_key)){ JOptionPane.showMessageDialog(this, "Please provide a Secret Key !!!"); return false; }
        this._burpObj._secret_key = _secret_key;
        return true;
    }
    
    public Boolean validate_iv_param(){
        if(this.jCheckBox1.isSelected()){
            this._burpObj._exclude_iv = true;
            return true;
        }

        String _iv_param = this.jTextField2.getText().trim();
        if(is_string_empty(_iv_param)){ JOptionPane.showMessageDialog(this, "Please provide a IV Parameter !!!"); return false; }
        this._burpObj._iv_param = _iv_param;
        return true;
    }
    
    public Boolean validate_Obff(){
        if(!this.jCheckBox8.isSelected()){
            this._burpObj._do_off = false;
            return true;
        }
        
        String _obff_char = this.jTextField5.getText().trim();
        if(is_string_empty(_obff_char)){ JOptionPane.showMessageDialog(this, "Please provide Obff char !!!"); return false; }
        
        String _replace_with = this.jTextField6.getText().trim();
        if(is_string_empty(_replace_with)){ JOptionPane.showMessageDialog(this, "Please provide Replace with char !!!"); return false; }
        
        this._burpObj._obffusicatedChar = _obff_char.split(" ");
        this._burpObj._replaceWithChar = _replace_with.split(" ");
        return true;
    }
    
    public Boolean validate_url_ed(){
        if(this.jCheckBox14.isSelected()){
            this._burpObj._url_enc_dec = true;
        }
        return true;
    }
    
    public Boolean validate_debug_mode(){
        if(this.jCheckBox13.isSelected()){
            this._burpObj.isDebug = true;
        }
        else{
            this._burpObj.isDebug = false;
        }
        return true;
    }
    
    public Boolean validate_request_params(){
        if(this.jCheckBox2.isSelected()){
            this._burpObj._is_req_body = true;
            this._burpObj._is_ovrr_req_body = false;
            this._burpObj._is_req_param = false;
            return true;
        }
        else if (this.jCheckBox3.isSelected()) {
            this._burpObj._is_req_body = false;
            this._burpObj._is_req_param = true;
            this._burpObj._is_ovrr_req_body = false;
            if(this.jCheckBox6.isSelected()){ this._burpObj._is_ovrr_req_body = true;  this._burpObj._is_ovrr_req_body_form = true; this._burpObj._is_ovrr_req_body_json = false;}
            if(this.jCheckBox16.isSelected()){ this._burpObj._is_ovrr_req_body = true; this._burpObj._is_ovrr_req_body_json = true; this._burpObj._is_ovrr_req_body_form = false; }
            
            String _req_param = this.jTextField3.getText().trim();
            if (is_string_empty(_req_param)) { JOptionPane.showMessageDialog(this, "Please provide Request Parameter !!!"); return false; }
            
            this._burpObj._req_param = _req_param.split(" ");
            if(this._burpObj._is_ovrr_req_body && this._burpObj._req_param.length > 1){ JOptionPane.showMessageDialog(this, "Request can't exceed more than once in case of override !!!"); return false;}
            return true;
        }
        else {
            JOptionPane.showMessageDialog(this, "Please Select Request Options !!!"); 
            return false;
        }
    }
    
    public Boolean validate_response_params(){
        if(this.jCheckBox15.isSelected()){
            this._burpObj._is_res_body = false;
            this._burpObj._is_ovrr_res_body = false;
            this._burpObj._is_res_param = false;
            return true;
        }
        else if(this.jCheckBox4.isSelected()){
            this._burpObj._is_res_body = true;
            this._burpObj._is_ovrr_res_body = false;
            this._burpObj._is_res_param = false;
            return true;
        }
        else if (this.jCheckBox5.isSelected()){
            this._burpObj._is_res_body = false;
            this._burpObj._is_ovrr_res_body = false;
            this._burpObj._is_res_param = true;
            if(this.jCheckBox7.isSelected()){ this._burpObj._is_ovrr_res_body = true; this._burpObj._is_ovrr_res_body_form = true; this._burpObj._is_ovrr_res_body_json = false; }
            if(this.jCheckBox17.isSelected()){ this._burpObj._is_ovrr_res_body = true; this._burpObj._is_ovrr_res_body_json = true; this._burpObj._is_ovrr_res_body_form = false; }
            
            String _res_param = this.jTextField4.getText().trim();
            if(is_string_empty(_res_param)) { JOptionPane.showMessageDialog(this, "Please provide Respons Parameter !!!"); return false; }
            
            this._burpObj._res_param = _res_param.split(" ");
            if(this._burpObj._is_ovrr_res_body && this._burpObj._res_param.length > 1){ JOptionPane.showMessageDialog(this, "Response can't exceed more than once in case of override !!!"); return false;}
            return true;
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select Response Options !!!"); 
            return false;
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        // Validate Host
        if(!validate_host()){ return; }
        
        // Validate encryption / decryption input
        this._burpObj._enc_type = String.valueOf(this.jComboBox1.getSelectedItem());
        if(!validate_secret_key()) { return; }
        if(!validate_iv_param()) { return; }
        
        // Validate Obff + URL
        if(!validate_Obff()) { return; }
        if(!validate_url_ed()) { return; }
        
        // Validate Debug Mode
        validate_debug_mode();
        
        // Validate Request
        if(!validate_request_params()) { return; }
        
        // Validate Response
        if(!validate_response_params()) { return; }
        
        // Start AES Killer
        this._burpObj.start_aes_killer();
        
        // Change Enable / Disable Button
        this.jButton2.setEnabled(false);
        this.jButton1.setEnabled(true);

        saveConfig();

        JOptionPane.showMessageDialog(this, "AES Killer started !!!"); 
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this._burpObj.stop_aes_killer();
        
        this.jButton2.setEnabled(true);
        this.jButton1.setEnabled(false);
        
        JOptionPane.showMessageDialog(this, "AES Killer stopped !!!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.jTextArea1.setText("");
        this.jTextArea2.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String _txt = this.jTextArea1.getText().trim();
        if (is_string_empty(_txt)) { JOptionPane.showMessageDialog(this, "Please provide data to encrypt !!!"); return; }
        
        if(this._burpObj.isRunning){
            this.jTextArea2.setText(this._burpObj.do_encrypt(_txt));
        }
        else{
            // Validate encryption / decryption input
            this._burpObj._enc_type = String.valueOf(this.jComboBox1.getSelectedItem());
            if(!validate_secret_key()) { return; }
            if(!validate_iv_param()) { return; }

            // Validate Obff + URL
            if(!validate_Obff()) { return; }
            if(!validate_url_ed()) { return; }
            
            this.jTextArea2.setText(this._burpObj.do_encrypt(_txt));
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String _txt = this.jTextArea1.getText().trim();
        if (is_string_empty(_txt)) { JOptionPane.showMessageDialog(this, "Please provide data to decrypt !!!"); return; }
        
        if(this._burpObj.isRunning){
            this.jTextArea2.setText(this._burpObj.do_decrypt(_txt));
        }
        else{
            // Validate encryption / decryption input
            this._burpObj._enc_type = String.valueOf(this.jComboBox1.getSelectedItem());
            if(!validate_secret_key()) { return; }
            if(!validate_iv_param()) { return; }

            // Validate Obff + URL
            if(!validate_Obff()) { return; }
            if(!validate_url_ed()) { return; }
            
            this.jTextArea2.setText(this._burpObj.do_decrypt(_txt));
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
