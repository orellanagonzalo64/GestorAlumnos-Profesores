/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.vistas;

import gui.interfaces.IControladorAMAlumno;

/**
 *
 * @author Tuquina Fernando, Orellana Gonzalo
 */
public class AMAlumno extends javax.swing.JDialog {

    private IControladorAMAlumno ca;
    
    /**
     * Creates new form AMAlumno
     */
    public AMAlumno(java.awt.Frame parent, boolean modal,IControladorAMAlumno ca) {
        super(parent, modal);
        initComponents();
        this.ca=ca;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextFieldNombre = new javax.swing.JTextField();
        TextFieldApellido = new javax.swing.JTextField();
        TextFieldDNI = new javax.swing.JTextField();
        TextFieldCX = new javax.swing.JTextField();
        BotonGuardar = new javax.swing.JButton();
        BotonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Titulo.setForeground(new java.awt.Color(51, 0, 255));
        Titulo.setText("Nuevo Alumno");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DNI:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("CX:");

        TextFieldNombre.setToolTipText("<html> <body bgcolor=\"white\"> <p width=\\\"100\"\\ style=\"color:#F14520\">[Ingresar s??lo letras]</p> </body>  </html>");
        TextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresPresionarTecla(evt);
            }
        });

        TextFieldApellido.setToolTipText("<html> <body bgcolor=\"white\"> <p width=\\\"100\"\\ style=\"color:#F14520\">[Ingresar s??lo letras]</p> </body>  </html>");
        TextFieldApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldApellidoActionPerformed(evt);
            }
        });
        TextFieldApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosPresionarTecla(evt);
            }
        });

        TextFieldDNI.setToolTipText("<html> <body bgcolor=\"white\"> <p width=\\\"100\"\\ style=\"color:#F14520\">[Ingresar s??lo n??meros]</p> </body>  </html>");
        TextFieldDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldDNIActionPerformed(evt);
            }
        });
        TextFieldDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocumentoPresionarTecla(evt);
            }
        });

        TextFieldCX.setToolTipText("<html> <body bgcolor=\"white\"> <p width=\\\"100\"\\ style=\"color:#F14520\">[Ingresar s??lo n??meros]</p> </body>  </html>");
        TextFieldCX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCXPresionarTecla(evt);
            }
        });

        BotonGuardar.setText("Guardar");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        BotonVolver.setText("Volver");
        BotonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BotonGuardar)
                            .addGap(18, 18, 18)
                            .addComponent(BotonVolver))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(TextFieldApellido)
                                .addComponent(TextFieldDNI)
                                .addComponent(TextFieldCX))))
                    .addComponent(Titulo))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextFieldCX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonGuardar)
                    .addComponent(BotonVolver))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        this.ca.btnGuardarClic(evt);
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVolverActionPerformed
       this.ca.btnCancelarClic(evt);
    }//GEN-LAST:event_BotonVolverActionPerformed

    private void txtNombresPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresPresionarTecla
        this.ca.txtNombresPresionarTecla(evt);
    }//GEN-LAST:event_txtNombresPresionarTecla

    private void txtApellidosPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosPresionarTecla
        this.ca.txtApellidosPresionarTecla(evt);
    }//GEN-LAST:event_txtApellidosPresionarTecla

    private void txtDocumentoPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoPresionarTecla
        this.ca.txtDocumentoPresionarTecla(evt);
    }//GEN-LAST:event_txtDocumentoPresionarTecla

    private void txtCXPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCXPresionarTecla
        this.ca.txtCXPresionarTecla(evt);
    }//GEN-LAST:event_txtCXPresionarTecla

    private void TextFieldDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldDNIActionPerformed

    private void TextFieldApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldApellidoActionPerformed

    /**
     * @param args the command line arguments
     */
  

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonVolver;
    private javax.swing.JTextField TextFieldApellido;
    private javax.swing.JTextField TextFieldCX;
    private javax.swing.JTextField TextFieldDNI;
    private javax.swing.JTextField TextFieldNombre;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    
    
    
    public javax.swing.JTextField getTextFieldApellido() {
        return TextFieldApellido;
    }

    public javax.swing.JTextField getTextFieldCX() {
        return TextFieldCX;
    }

    public javax.swing.JTextField getTextFieldDNI() {
        return TextFieldDNI;
    }

    public javax.swing.JTextField getTextFieldNombre() {
        return TextFieldNombre;
    }

    public javax.swing.JLabel getTitulo() {
        return Titulo;
    }
}
