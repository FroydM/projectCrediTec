/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

/**
 *
 * @author march
 */
public class CreditoView extends javax.swing.JPanel {

    /**
     * Creates new form CreditoView
     */
    public CreditoView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnMainPanel = new javax.swing.JTabbedPane();
        panelDatosGenerales = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbTipoCredito = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPlazo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtInteres = new javax.swing.JTextField();
        cbxMoneda = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCedulaSolicitante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion"));

        btnGuardar.setText("Guardar");

        jButton2.setText("jButton2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(jButton2))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnMainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de credito"));

        panelDatosGenerales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tipo:");
        panelDatosGenerales.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 36, -1, -1));

        cbTipoCredito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiduciario", "Personal", "Prendario", "Terreno", "Vivienda", " ", " ", " " }));
        panelDatosGenerales.add(cbTipoCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 33, 206, -1));

        jLabel2.setText("Monto:");
        panelDatosGenerales.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 94, -1, -1));
        panelDatosGenerales.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 91, 206, -1));

        jLabel3.setText("Plazo:");
        panelDatosGenerales.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 149, -1, -1));

        txtPlazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlazoActionPerformed(evt);
            }
        });
        panelDatosGenerales.add(txtPlazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 146, 206, -1));

        jLabel4.setText("Interés:");
        panelDatosGenerales.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 203, -1, -1));

        jLabel5.setText("Moneda");
        panelDatosGenerales.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));
        panelDatosGenerales.add(txtInteres, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 200, 206, -1));

        cbxMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colones", "Dólares" }));
        panelDatosGenerales.add(cbxMoneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 257, 206, -1));

        jLabel6.setText("Datos Solicitante");
        panelDatosGenerales.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, -1, -1));

        jLabel7.setText("Cédula:");
        panelDatosGenerales.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));
        panelDatosGenerales.add(txtCedulaSolicitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 200, -1));

        jLabel8.setText("Nombre:");
        panelDatosGenerales.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        txtNombre.setEditable(false);
        panelDatosGenerales.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 200, -1));

        jLabel9.setText("Segundo Apellido:");
        panelDatosGenerales.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, -1, -1));

        txtApellido2.setEditable(false);
        txtApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido2ActionPerformed(evt);
            }
        });
        panelDatosGenerales.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 200, 20));

        jLabel10.setText("Primer Apellido:");
        panelDatosGenerales.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        txtApellido1.setEditable(false);
        txtApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido1ActionPerformed(evt);
            }
        });
        panelDatosGenerales.add(txtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 200, 20));

        pnMainPanel.addTab("Datos generales", panelDatosGenerales);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlazoActionPerformed

    private void txtApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido2ActionPerformed

    private void txtApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JComboBox<String> cbTipoCredito;
    private javax.swing.JComboBox<String> cbxMoneda;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel panelDatosGenerales;
    public javax.swing.JTabbedPane pnMainPanel;
    public javax.swing.JTextField txtApellido1;
    public javax.swing.JTextField txtApellido2;
    public javax.swing.JTextField txtCedulaSolicitante;
    public javax.swing.JTextField txtInteres;
    public javax.swing.JTextField txtMonto;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPlazo;
    // End of variables declaration//GEN-END:variables
}