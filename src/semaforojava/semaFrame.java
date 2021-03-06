/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforojava;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import panamahitek.Arduino.PanamaHitek_Arduino;

/**
 *
 * @author Donaldo
 */
public class semaFrame extends javax.swing.JFrame {

    /**
     * Creates new form semaFrame
     */
    String dia, mes, annio;
    String horaActual;
    String fechaActual;
    String shora, sminutos, ssegundos;
    String horafec;
    int hora, minutos, segundos;
    int col = 0;
    int fi = 0;
    int cont1 = 0;
    int cont2 = 0;
    int x = 1;
    String modo = "ON";
    boolean extra = false;
    Thread thread = new Thread(new MyRunnable());

    public class MyRunnable implements Runnable {

        @Override
        public void run() {

            while (x == 1) {
                Calendar c1 = Calendar.getInstance();

                hora = c1.get(Calendar.HOUR_OF_DAY);
                minutos = c1.get(Calendar.MINUTE);
                segundos = c1.get(Calendar.SECOND);

                shora = Integer.toString(hora);
                sminutos = Integer.toString(minutos);
                ssegundos = Integer.toString(segundos);

                if (shora.length() == 2) {

                } else {
                    shora = "0" + shora;

                }
                if (sminutos.length() == 2) {

                } else {
                    sminutos = "0" + sminutos;
                }
                if (ssegundos.length() == 2) {

                } else {
                    ssegundos = "0" + ssegundos;
                }

                horaActual = shora + ":" + sminutos + ":" + ssegundos + " Hrs";

            }
        }
    }

    PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    SerialPortEventListener evento = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            if (arduino.isMessageAvailable() == true) {

                String m = arduino.printMessage();

                if (m.equals("Verde1")) {
                    if (extra == false) {
                        modelo3.addRow(new Object[]{"", ""});

                    } else {
                        extra = false;
                    }
                    modelo3.setValueAt(horaActual, col, 0);
                    col++;
                } else if (m.equals("Verde2")) {
                    String var1 = modelo3.getValueAt(0, 0).toString();
                    if (var1 == null || var1.equals("")) {
                        col++;
                        extra = false;
                        modelo3.setValueAt("null", 0, 0);
                    }
                    modelo3.setValueAt(horaActual, fi, 1);
                    fi++;
                }
                System.out.println(col + " col ---" + fi + "  fi");
            }

            System.out.println("Evento");
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };

    DefaultTableModel modelo3;

    public semaFrame() {
        initComponents();
        thread.start();

        modelo3 = (DefaultTableModel) jTable3.getModel();
        try {
            arduino.arduinoRXTX("COM3", 9600, evento);
         
           
        } catch (Exception ex) {
            Logger.getLogger(semaFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/semaforojava/1.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Led Verde 1", "Led Verde 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/semaforojava/on.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/semaforojava/limp.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            if (modo.equals("ON")) {

                modo = "OFF";
                //  modelo3.addRow(new Object[]{"", ""});
                arduino.sendData("1");
                modo = "OFF";
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/semaforojava/off.png")));

            } else if (modo.equals("OFF")) {
                limp();
                modelo3.addRow(new Object[]{"", ""});
                extra = true;
                fi = 0;
                col = 0;

                modo = "ON";
                arduino.sendData("1");
                modo = "ON";
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/semaforojava/on.png")));

            }

            // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(semaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        limp();
        modelo3.addRow(new Object[]{"", ""});
        extra = true;
        fi = 0;
        col = 0;

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked
    private void limp() {
        for (int i = 0; i < jTable3.getRowCount(); i++) {
            modelo3.removeRow(i);
            i -= 1;
        }
    }

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
            java.util.logging.Logger.getLogger(semaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(semaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(semaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(semaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
           UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new semaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
