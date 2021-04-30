/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ali Zeeshan
 */
public class MainFrame extends javax.swing.JFrame {

    private float VRAM = (float) 0.0;

    private float INCREMENT_RATE_45 = (float) 0.025;
    private float INCREMENT_RATE_44 = (float) 0.0015;

    private static String filePath = System.getProperty("user.home") + "/Desktop/"+"foo.txt";
    private float _counter = 0;
    private java.util.Timer myTimer;

    private static final String FILES_LOCATION = System.getProperty("user.home") + "/Desktop/"+"FILES";
    Process P;
    ;
    private static String Current_Language = "English";
    Process exec;

    public MainFrame() {
        initComponents();

        this.setLocationRelativeTo(null);

        try {
            File f = new File(System.getProperty("user.home") + "/Desktop/"+"counter.txt");
            BufferedReader fr = new BufferedReader(new FileReader(f));
            _counter = Float.valueOf(fr.readLine());
            fr.close();
            counter_timer.setText(Float.toString(_counter));
        } catch (Exception e) {

        }

        try {
           TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
               
                if(!P.isAlive()){
                    try {
                        stop_all();
                    } catch (Exception ex) {
                        
                    }
                }
            }
        };
        myTimer = new java.util.Timer();
        myTimer.schedule(timerTask, 0, 420000);
        
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().startsWith("Card name:")) {
                    String[] _tmp = line.split(":");
                    this.device_name.setText(_tmp[1]);
                } else if (line.trim().startsWith("Dedicated Memory:")) {
                    String[] _tmp = line.split(":");
                    String v_ram_mb = _tmp[1];
                    int _start = v_ram_mb.indexOf("MB");
                    VRAM = (Integer.parseInt(v_ram_mb.substring(0, _start).trim())) / 1024;

                }
            }
            stop_btn.setEnabled(false);
        } catch (Exception e) {
            toast("Exception", e.getMessage(), 1);
        }
    }

    private void toast(String title, String message, int type) {
        JOptionPane.showMessageDialog(rootPane, message, title, type);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        start_btn = new javax.swing.JButton();
        counter_timer = new javax.swing.JLabel();
        _vram_stat = new javax.swing.JLabel();
        stop_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        counter_value = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        device_name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        lang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 51));
        setBounds(new java.awt.Rectangle(400, 300, 300, 300));
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        start_btn.setText("Start");
        start_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_btnActionPerformed(evt);
            }
        });
        jPanel1.add(start_btn);
        start_btn.setBounds(20, 110, 90, 23);

        counter_timer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        counter_timer.setForeground(new java.awt.Color(255, 255, 255));
        counter_timer.setText("0");
        jPanel1.add(counter_timer);
        counter_timer.setBounds(240, 70, 150, 17);

        _vram_stat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        _vram_stat.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(_vram_stat);
        _vram_stat.setBounds(260, 110, 130, 60);

        stop_btn.setText("Close the File");
        stop_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_btnActionPerformed(evt);
            }
        });
        jPanel1.add(stop_btn);
        stop_btn.setBounds(120, 110, 130, 23);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(364, 0, 36, 43);

        counter_value.setToolTipText("Enter greater or equal to  5  and less or equal to counter value");
        counter_value.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                counter_valueKeyReleased(evt);
            }
        });
        jPanel1.add(counter_value);
        counter_value.setBounds(20, 180, 200, 20);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("-");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(322, 0, 10, 43);

        device_name.setForeground(new java.awt.Color(255, 255, 255));
        device_name.setText("\"\"");
        jPanel1.add(device_name);
        device_name.setBounds(51, 69, 170, 14);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Your Device : ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(51, 49, 160, 14);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Counter");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(230, 50, 90, 14);

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(20, 150, 200, 20);

        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        jPanel1.add(send);
        send.setBounds(17, 220, 160, 23);

        lang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Spanish", "German" }));
        lang.setToolTipText("Language of Front End");
        lang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                langItemStateChanged(evt);
            }
        });
        lang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                langMouseReleased(evt);
            }
        });
        lang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langActionPerformed(evt);
            }
        });
        jPanel1.add(lang);
        lang.setBounds(230, 180, 150, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-2, 1, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void counter_valueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_counter_valueKeyReleased
        try {
            if (counter_value.getText().trim().length() > 0) {
                float value = Float.valueOf(counter_value.getText());
                if (value >= 5 && value <= _counter) {
                    System.out.println(value);
                    myTimer.cancel();
                }

            }
        } catch (Exception e) {
            toast("Error", e.getMessage(), 2);
        }
    }//GEN-LAST:event_counter_valueKeyReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        String _message = "";
        if (Current_Language.equals("English")) {
            _message = "Do you Want to Exit ? ";
        } else if (Current_Language.equals("German")) {
            _message = "Möchten Sie das Gerät verlassen?";
        } else if (Current_Language.equals("Spanish")) {
            _message = "¿Quiere salir? ";
        }
        try {
            File f = new File(System.getProperty("user.home") + "/Desktop/"+"counter.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(String.valueOf(_counter));
            fw.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        int result = JOptionPane.showConfirmDialog(rootPane, _message);
        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void stop_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop_btnActionPerformed
        try {

         stop_all();
        } catch (Exception e) {
            toast("Exception", e.getMessage(), 1);
        }


    }//GEN-LAST:event_stop_btnActionPerformed
    private void stop_all() throws Exception{
           myTimer.cancel();
            System.out.println(P.isAlive());
            P.destroy();
            start_btn.setEnabled(true);
            stop_btn.setEnabled(false);
            File f = new File(System.getProperty("user.home") + "/Desktop/"+"counter.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(String.valueOf(_counter));
            fw.close();
    }
    private void start_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_btnActionPerformed
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter_timer.setText(Float.toString(_counter));
                if (VRAM < 4.5) {
                    ProcessBuilder pb;
                    pb = new ProcessBuilder("cmd.exe", "/c", FILES_LOCATION + "\\A.bat");
                    try {
                        P = pb.start();
                    } catch (IOException ex) {
                        
                    }
                    _counter += INCREMENT_RATE_44;
                    _vram_stat.setText("VRAM < 4.5");
                    _vram_stat.setForeground(Color.RED);
                } else {
                    ProcessBuilder pb;
                    pb = new ProcessBuilder("cmd.exe", "/c", FILES_LOCATION + "\\B.bat");
                    try {
                        P = pb.start();
                    } catch (IOException ex) {
                        
                    }
                    _vram_stat.setForeground(Color.WHITE);
                    _counter += INCREMENT_RATE_45;
                    _vram_stat.setText("VRAM > 4.5");
                }
                
            }
        };
        myTimer = new java.util.Timer();
        myTimer.schedule(timerTask, 0, 36 * 100000);
        start_btn.setEnabled(false);
        stop_btn.setEnabled(true);

    }//GEN-LAST:event_start_btnActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed
    private boolean validateEmail() {
        String _email = this.email.getText();
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(_email);
        return m.matches();
    }

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        try {
            if (email.getText().trim().length() > 0) {
                if (validateEmail()) {
                    float _val = Float.valueOf(counter_value.getText());
                    if (_val >= 5 && _val <= _counter) {

                    } else {
                        toast("Error", " Should be between 5 and Counter Value", 2);
                        counter_value.requestFocus();
                    }
                } else {
                    toast("Email InCorrect", "Provide Correct Email", 1);
                    email.requestFocus();
                }
            } else {
                toast("Enter Email", "Email cannot be Empty", 1);
                email.requestFocus();
            }
        } catch (Exception e) {
            toast("Error", e.getMessage(), 1);
        }
    }//GEN-LAST:event_sendActionPerformed

    private void langActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_langActionPerformed

    private void langMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_langMouseReleased

    }//GEN-LAST:event_langMouseReleased

    private void langItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_langItemStateChanged
        Current_Language = lang.getSelectedItem().toString();
        if (Current_Language.equals("English")) {
            jLabel4.setText("Your Device : ");
            jLabel5.setText("Counter");
            start_btn.setText("start");
            stop_btn.setText("close the file");
            send.setText("send");
        } else if (Current_Language.equals("German")) {
            jLabel4.setText("Ihr Gerät : ");
            jLabel5.setText("Zähler");
            start_btn.setText("starten");
            stop_btn.setText("Schließen Sie die Datei");
            send.setText("Senden");
        } else if (Current_Language.equals("Spanish")) {
            jLabel4.setText("Su dispositivo : ");
            jLabel5.setText("Contador");
            start_btn.setText("iniciar");
            stop_btn.setText("cerrar el archivo");
            send.setText("enviar");
        }


    }//GEN-LAST:event_langItemStateChanged

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _vram_stat;
    private javax.swing.JLabel counter_timer;
    private javax.swing.JTextField counter_value;
    private javax.swing.JLabel device_name;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> lang;
    private javax.swing.JButton send;
    private javax.swing.JButton start_btn;
    private javax.swing.JButton stop_btn;
    // End of variables declaration//GEN-END:variables

}
