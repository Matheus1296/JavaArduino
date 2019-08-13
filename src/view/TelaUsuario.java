package view;

import Controller.Controlador;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Dados;

public class TelaUsuario extends javax.swing.JFrame {

    private int nivel = 0;
    private boolean cadastro = false;

    public TelaUsuario() {

        estilo();
        initComponents();
        setVisible(true);
        //jpAlerta.setVisible(false);

        jtNivelGas.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jpPrincipal = new javax.swing.JPanel();
        jlAlerta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtNivelGas = new javax.swing.JTextArea();
        ListTel = new javax.swing.JButton();
        jbRgAlerta = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GF-Alarme");
        setResizable(false);

        jpPrincipal.setPreferredSize(new java.awt.Dimension(500, 400));

        jlAlerta.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jlAlerta.setForeground(new java.awt.Color(255, 0, 0));
        jlAlerta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("Nível do gás :");

        jtNivelGas.setColumns(20);
        jtNivelGas.setRows(5);
        jScrollPane1.setViewportView(jtNivelGas);

        ListTel.setText("Lista Telefonica");
        ListTel.setToolTipText("");
        ListTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListTelActionPerformed(evt);
            }
        });

        jbRgAlerta.setText("Registro de Alerta");
        jbRgAlerta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRgAlertaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlAlerta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128))
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ListTel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbRgAlerta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jlAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRgAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListTel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jpPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ListTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListTelActionPerformed
        telaListaTel();
    }//GEN-LAST:event_ListTelActionPerformed

    private void jbRgAlertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRgAlertaActionPerformed
        telaRegistroDeAlerta();
    }//GEN-LAST:event_jbRgAlertaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ListTel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbRgAlerta;
    private javax.swing.JLabel jlAlerta;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTextArea jtNivelGas;
    // End of variables declaration//GEN-END:variables

    private void estilo() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void telaListaTel() {
        TelaListaTel aux = new TelaListaTel();
        aux.setVisible(true);

    }
    
    private void telaRegistroDeAlerta() {
        Controlador aux = new Controlador();
        aux.buscarTodosDados();
    }
    

    public void setTextJTextArea(String text) {
        jtNivelGas.append(text);
        jtNivelGas.setCaretPosition(jtNivelGas.getText().length());
        verificar(text);

    }

    public void verificar(String text) {

        int nivel = Integer.parseInt(text.trim());
        
        if (nivel > this.nivel) {
            this.nivel = nivel;

        }

        if (nivel <= 250) {
            jlAlerta.setText("NÍVEL NORMAL");
            jlAlerta.setForeground(Color.black);
            repaint();
            cadastro = true;

        } else {

            jlAlerta.setText("ALERTA NÍVEL ACIMA DO NORMAL");
            jlAlerta.setForeground(Color.red);
            //jlAlerta2.setText("verifique seu nivel de gás");
            repaint();
            //  if (nivel == 252 || nivel == 253 || nivel == 254) {
            if (cadastro) {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();

                String data = dateFormat.format(date);
                String hora = dateFormat1.format(date);

                Dados dados = new Dados(0, nivel, hora, data);

                Controlador aux = new Controlador();
                aux.salvarDados(dados);
                cadastro = false;
            }
        }
    }
}
