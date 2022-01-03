/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.areas.vistas;

import java.awt.Dialog;
import javax.swing.JDialog;
import javax.swing.JTextField;
import gui.interfaces.IControladorAMArea;

public class VentanaAMArea extends JDialog {
    private IControladorAMArea controlador;
   
    /**
     * Constructor 
     * @param controlador controlador de la ventana
     * @param ventanaPadre ventana padre (VentanaAreas en este caso)
     */        
    public VentanaAMArea(IControladorAMArea controlador, Dialog ventanaPadre) {
        super(ventanaPadre, true);
        initComponents();
        this.controlador = controlador;
    }
    
    /**
     * Devuelve el campo txtNombre
     * @return JTextField  - campo txtNombre
     */
    public JTextField verTxtNombre() {
        return this.txtNombre;
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
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nombre:");

        txtNombre.setToolTipText("Nombre del nivel");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePresionarTecla(evt);
            }
        });

        btnGuardar.setMnemonic('G');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guarda el área");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClic(evt);
            }
        });

        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela la operación");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarClic(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(txtNombre)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarClic(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarClic
        this.controlador.btnCancelarClic(evt);
    }//GEN-LAST:event_btnCancelarClic

    private void btnGuardarClic(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClic
        this.controlador.btnGuardarClic(evt);
    }//GEN-LAST:event_btnGuardarClic

    private void txtNombrePresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePresionarTecla
        this.controlador.txtNombrePresionarTecla(evt);
    }//GEN-LAST:event_txtNombrePresionarTecla


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
