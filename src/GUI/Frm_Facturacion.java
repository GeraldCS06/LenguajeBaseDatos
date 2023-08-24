/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Bo.FacturacionBo;
import CRUDS.BD;
import Entidad.Facturacion;
import Entidad.Persona;
import conexion.Conexion;
import static java.awt.image.ImageObserver.ABORT;
import static java.awt.image.ImageObserver.ERROR;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Frm_Facturacion extends javax.swing.JFrame {

    private int factura;
    private DefaultTableModel tabla;
    private Facturacion Factura = new Facturacion();
    private FacturacionBo FacturacionBo = new FacturacionBo();
    private String mensaje = "";

    public Frm_Facturacion() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Txt_fecha = new javax.swing.JTextField();
        Txt_Num_factura = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Combo_cliente = new javax.swing.JComboBox<>();
        Combo_producto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Txt_Cantidad = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_factura = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        Txt_subtotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Txt_impuesto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Txt_montoTotal = new javax.swing.JTextField();
        btn_facturar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(49, 66, 82));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Facturación");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Datos de facturación");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText(" Nº Factura: ");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Fecha: ");

        Txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_fechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Txt_Num_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(Txt_Num_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Cliente: ");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Producto: ");

        Combo_cliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Combo_clienteItemStateChanged(evt);
            }
        });
        Combo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_clienteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Cantidad: ");

        btn_agregar.setBackground(new java.awt.Color(0, 0, 51));
        btn_agregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setText("AGREGAR");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(0, 0, 51));
        btn_eliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("BORRAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        Tabla_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Precio_Uni", "Cantidad", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla_factura);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("SubTotal:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Impuesto: ");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Monto total: ");

        btn_facturar.setBackground(new java.awt.Color(0, 0, 51));
        btn_facturar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_facturar.setForeground(new java.awt.Color(255, 255, 255));
        btn_facturar.setText("Facturar");
        btn_facturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_facturarActionPerformed(evt);
            }
        });

        btn_buscar.setBackground(new java.awt.Color(0, 0, 51));
        btn_buscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(177, 177, 177)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Txt_impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(213, 213, 213)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Txt_montoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(201, 201, 201)
                            .addComponent(btn_facturar))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(Combo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Combo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3)
                            .addGap(244, 244, 244)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btn_agregar)
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_eliminar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Combo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(Combo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Txt_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(Txt_impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Txt_montoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_facturar)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Combo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_clienteActionPerformed
        //Revisar si esta bien el llenado de el combo box
        /*Crear instancia para consultas a la BD*/
        BD base_datos = new BD();
        try {
            base_datos.LlenarCliente("Persona", "Nombre", Combo_cliente);
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_Combo_clienteActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        if (verificaDatos()) {
            try {
                /*Crear instancia para consultas a la BD*/
                BD base_datos = new BD();

                /*Obtener la fecha actual*/
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();

                Facturacion f = new Facturacion(base_datos.ObtenerUltimoValorFactura(), formatter.format(date), WIDTH, WIDTH, mensaje, mensaje, mensaje, mensaje, mensaje);

//                Factura.setNum_Factura(mensaje);
//                Factura.setFecha(mensaje);
//                Factura.setCliente(WIDTH);
//                Factura.setCedula(mensaje);
//                Factura.setProducto(WIDTH);
//                Factura.setCantida(mensaje);
//                Factura.setSubTotal(mensaje);
//                Factura.setImpuesto(mensaje);
//                Factura.setMontoTotal(mensaje);
                mensaje = FacturacionBo.agregarFactura(f);
                JOptionPane.showMessageDialog(this, mensaje);
                limpiarCampos();
                mostrarDatosTabla();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, mensaje);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tienes que llenar todos los campos");
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        try {
            mensaje = FacturacionBo.eliminarFactura(factura);
            JOptionPane.showMessageDialog(this, mensaje);
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, mensaje);
        }
        mostrarDatosTabla();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        if (verificaDatos()) {
            Factura.setNum_Factura(WIDTH);
            Factura.setFecha(mensaje);
            Factura.setCliente(WIDTH);
            Factura.setCedula(mensaje);
            Factura.setProducto(WIDTH);
            Factura.setCantida(mensaje);
            Factura.setSubTotal(mensaje);
            Factura.setImpuesto(mensaje);
            Factura.setMontoTotal(mensaje);

            try {

                mensaje = FacturacionBo.actualizaFactura(Factura);
            } catch (SQLException ex) {
                Logger.getLogger(Frm_Facturacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            Tabla_factura.clearSelection();
            JOptionPane.showMessageDialog(this, mensaje);
            mostrarDatosTabla();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Tienes que llenar todos los campos");
        }    }//GEN-LAST:event_btn_buscarActionPerformed

    private void Txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_fechaActionPerformed

    private void Combo_clienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Combo_clienteItemStateChanged

    }//GEN-LAST:event_Combo_clienteItemStateChanged

    private void btn_facturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facturarActionPerformed
        String Num_factura = Txt_Num_factura.getText();
        String Fecha = Txt_fecha.getText();
        String Cantidad = Txt_Cantidad.getText();
        String SubTota = Txt_subtotal.getText();
        String Impuesto = Txt_impuesto.getText();
        String MontoTotal = Txt_montoTotal.getText();
        int cliente = Integer.parseInt(Combo_cliente.getItemAt(WIDTH));
        int producto = Integer.parseInt(Combo_producto.getItemAt(WIDTH));

        String factura = "Numer de factura: " + Num_factura + "\n"
                + "Fecha: " + Fecha + "\n"
                + "Cantidad: " + Cantidad + "\n"
                + "SubTota: " + SubTota + "\n"
                + "Impuesto: " + Impuesto + "\n"
                + "MontoTotal: " + MontoTotal + "\n"
                + "cliente: " + cliente + "\n"
                + "producto: $" + producto + "\n";


    }//GEN-LAST:event_btn_facturarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Facturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_cliente;
    private javax.swing.JComboBox<String> Combo_producto;
    private javax.swing.JTable Tabla_factura;
    private javax.swing.JTextField Txt_Cantidad;
    private javax.swing.JTextField Txt_Num_factura;
    private javax.swing.JTextField Txt_fecha;
    private javax.swing.JTextField Txt_impuesto;
    private javax.swing.JTextField Txt_montoTotal;
    private javax.swing.JTextField Txt_subtotal;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_facturar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private boolean verificaDatos() {
        boolean verificar = false, verificarD = true;
        String Num_factura = Txt_Num_factura.getText();
        String Fecha = Txt_fecha.getText();
        String Cantidad = Txt_Cantidad.getText();
        String SubTota = Txt_subtotal.getText();
        String Impuesto = Txt_impuesto.getText();
        String MontoTotal = Txt_montoTotal.getText();

        if (Num_factura == "" && Fecha == "" && Cantidad == ""
                && SubTota == "" && Impuesto == "" && MontoTotal == "") {
            verificarD = false;
        }

        boolean verificarR = false;
        if (Combo_cliente.getSelectedIndex() != 0) {
            if (Combo_producto.getSelectedIndex() != 0) {
                verificarR = true;
            }
        }

        if (verificarD && verificarR) {
            verificar = true;
        }
        return verificar;
    }

    private void limpiarCampos() {
        Txt_Num_factura.setText("");
        Txt_fecha.setText("");
        Txt_Cantidad.getText();
        Txt_subtotal.getText();
        Txt_impuesto.getText();
        Txt_montoTotal.getText();
        try {
            Combo_cliente.setSelectedIndex(0);
            Combo_producto.setSelectedIndex(0);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    private void mostrarDatosTabla() {
        DefaultTableModel contenido = (DefaultTableModel) Tabla_factura.getModel();

        contenido.setRowCount(0);

        try {
            Connection conn = Conexion.Conectar();

            //Vista
            String procedureCall = "Select * from datos_factura";
            CallableStatement stmt = conn.prepareCall(procedureCall);

            stmt.execute();

            ResultSet resultSet = stmt.getResultSet();
            if (resultSet != null) {
                while (resultSet.next()) {

                    Integer Num_factura = resultSet.getInt("Numero factura");
                    Integer fecha = resultSet.getInt("Fecha");
                    Integer cliente = resultSet.getInt("Cliente");
                    Integer cedula = resultSet.getInt("Cedula");
                    Integer producto = resultSet.getInt("Producto");
                    Integer cantidad = resultSet.getInt("Cantidad");
                    Integer subtotal = resultSet.getInt("SubTotal");
                    Integer impuesto = resultSet.getInt("Impuesto");
                    Integer montototal = resultSet.getInt("MontoTotal");

                    // Agregar los datos a la tabla
                    ((DefaultTableModel) Tabla_factura.getModel()).addRow(new Object[]{Num_factura, fecha, cliente,
                        cedula, producto, cantidad, subtotal, impuesto, montototal});
                }
            }

            if (resultSet != null) {
                resultSet.close();
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error al conectar: " + e);
        }
    }

    private void mostrarCliente() {

        try {
            Connection conn = Conexion.Conectar();

            //Vista
            String procedureCall = "Select * from datos_nombre";
            CallableStatement stmt = conn.prepareCall(procedureCall);

            stmt.execute();

            ResultSet resultSet = stmt.getResultSet();
            if (resultSet != null) {
                while (resultSet.next()) {

                    String cliente = resultSet.getString("Persona");

                    // Agregar los datos al Combo Box
                    Combo_cliente.addItem(cliente);
                }
            }

            if (resultSet != null) {
                resultSet.close();
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error al conectar: " + e);
        }
    }

    private void mostrarProducto() {

        try {
            Connection conn = Conexion.Conectar();

            //Vista
            String procedureCall = "Select * from datos_nombre_producto";
            CallableStatement stmt = conn.prepareCall(procedureCall);

            stmt.execute();

            ResultSet resultSet = stmt.getResultSet();
            if (resultSet != null) {
                while (resultSet.next()) {

                    String producto = resultSet.getString("Producto");

                    // Agregar los datos al Combo Box
                    Combo_producto.addItem(producto);
                }
            }

            if (resultSet != null) {
                resultSet.close();
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error al conectar: " + e);
        }
    }

    private int getInt_Producto() {
        String Dproducto = Combo_producto.getSelectedItem().toString();
        int Producto;
        try {
            String produc = Dproducto.substring(0, 2);
            Producto = Integer.parseInt(produc + "");
        } catch (Exception e) {
            String produc = Dproducto.substring(0, 1);
            Producto = Integer.parseInt(produc + "");
        }
        return Producto;
    }

    private int getInt_Cliente() {
        String Dcliente = Combo_cliente.getSelectedItem().toString();
        int Cliente;
        try {
            String clien = Dcliente.substring(0, 2);
            Cliente = Integer.parseInt(clien + "");
        } catch (Exception e) {
            String clien = Dcliente.substring(0, 1);
            Cliente = Integer.parseInt(clien + "");
        }
        return Cliente;
    }

    private void setIndexComboCliente(int cliente) {
        for (int i = 1; i < Combo_cliente.getItemCount(); i++) {

            String item = Combo_cliente.getItemAt(i);
            char clien = item.charAt(0);
            int persona = Integer.parseInt(clien + "");
            if (persona == cliente) {
                Combo_cliente.setSelectedIndex(i);
                break;
            }
        }
    }

    private void setIndexComboProducto(int producto) {
        for (int i = 1; i < Combo_producto.getItemCount(); i++) {

            String item = Combo_producto.getItemAt(i);
            char produc = item.charAt(0);
            int produ = Integer.parseInt(produc + "");
            if (produ == producto) {
                Combo_producto.setSelectedIndex(i);
                break;
            }
        }
    }
}
