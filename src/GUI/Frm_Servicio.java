package GUI;

import Bo.ServicioBo;
import Entidad.Servicio;
import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vrb00
 */
public class Frm_Servicio extends javax.swing.JFrame {

    private int id_servicio;
    private DefaultTableModel tabla;
    private Servicio servicio = new Servicio();
    private ServicioBo servicioBo = new ServicioBo();
    private String mensaje = "";

    /**
     * Creates new form Frm_Servicio
     */
    public Frm_Servicio() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        mostrarDatosTabla();
        obtenerSeleccion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_servicios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre_servicio = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(49, 66, 82));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Servicios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tabla_servicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Servicio", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tabla_servicios);

        jLabel1.setText("Nombre del Servicio");

        btn_buscar.setBackground(new java.awt.Color(0, 204, 204));
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_agregar.setBackground(new java.awt.Color(1, 186, 59));
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_editar.setBackground(new java.awt.Color(49, 66, 82));
        btn_editar.setForeground(new java.awt.Color(255, 255, 255));
        btn_editar.setText("Editar");
        btn_editar.setToolTipText("Guardar cambios");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(255, 0, 0));
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Precio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nombre_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btn_agregar)
                        .addGap(84, 84, 84)
                        .addComponent(btn_editar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btn_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(btn_eliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(btn_editar)
                    .addComponent(btn_buscar)
                    .addComponent(btn_eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        if (verificarDatos()) {
            if (verificarPrecio()) {
                try {
                    servicio.setNombre_servicio(txt_nombre_servicio.getText());
                    int precioS = Integer.parseInt(txt_precio.getText());
                    servicio.setPrecio(precioS);

                    mensaje = servicioBo.agregarServicio(servicio);
                    JOptionPane.showMessageDialog(this, mensaje);
                    limpiarCampos();
                    mostrarDatosTabla();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, mensaje);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El precio del servicio tiene que ser un valor numerico.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tienes que llenar todos los campos");
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        try {
            ArrayList<Servicio> servicio = servicioBo.buscarNombreServicio(txt_nombre_servicio.getText());

            for (Servicio s : servicio) {
                id_servicio = s.getId_servicio();
                txt_nombre_servicio.setText(s.getNombre_servicio());
                txt_precio.setText(s.getPrecio() + "");
            }
        } catch (Exception sql) {
            JOptionPane.showMessageDialog(null, sql);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // TODO add your handling code here:
        if (verificarDatos()) {
            if (verificarPrecio()) {
                try {
                    servicio.setId_servicio(id_servicio);
                    servicio.setNombre_servicio(txt_nombre_servicio.getText());
                    servicio.setPrecio(Integer.parseInt(txt_precio.getText()));
                    mensaje = servicioBo.actualizarServicio(servicio);
                    tabla_servicios.clearSelection();
                    JOptionPane.showMessageDialog(this, mensaje);
                    mostrarDatosTabla();
                    limpiarCampos();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, mensaje);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El precio del servicio tiene que ser un valor numerico.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tienes que llenar todos los campos");
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        try {
            mensaje = servicioBo.eliminarServicio(id_servicio);
            JOptionPane.showMessageDialog(this, mensaje);
            mostrarDatosTabla();
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, mensaje);
        }
        mostrarDatosTabla();
    }//GEN-LAST:event_btn_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Servicio().setVisible(true);
            }
        });
    }

    private void mostrarDatosTabla() {
        DefaultTableModel contenido = (DefaultTableModel) tabla_servicios.getModel();

        contenido.setRowCount(0);

        try {
            Connection conn = Conexion.Conectar();

            //Vista
            String procedureCall = "Select * from datos_servicio";
            CallableStatement stmt = conn.prepareCall(procedureCall);

            stmt.execute();

            ResultSet resultSet = stmt.getResultSet();
            if (resultSet != null) {
                while (resultSet.next()) {

                    Integer servicioID = resultSet.getInt("ID");
                    String servicio = resultSet.getString("NombreServicio");
                    int precio = resultSet.getInt("Precio");
                    String precioServicio = "₡" + precio;

                    // Agregar los datos a la tabla
                    ((DefaultTableModel) tabla_servicios.getModel()).addRow(new Object[]{servicioID, servicio, precioServicio});
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

    private boolean verificarDatos() {
        boolean verificar = false;
        String nombre = txt_nombre_servicio.getText();
        String precio = txt_precio.getText();

        if (nombre != "" && precio != "") {
            verificar = true;
        }

        return verificar;
    }

    private boolean verificarPrecio() {
        String precio = txt_precio.getText();
        boolean verifica = true;
        try {
            int precioS = Integer.parseInt(precio);
        } catch (Exception e) {
            System.out.println("El precio no es un valor numerico");
            verifica = false;
        }
        return verifica;
    }

    private void limpiarCampos() {
        txt_nombre_servicio.setText("");
        txt_precio.setText("");
    }

    private void obtenerSeleccion() {
        // Agregar un ListSelectionListener a la tabla
        tabla_servicios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Obtener el número de fila y columna seleccionada
                    int selectedRow = tabla_servicios.getSelectedRow();

                    System.out.println(selectedRow);

                    // Obtener la primera celda seleccionada
                    Object selectedData = tabla_servicios.getValueAt(selectedRow, 0);

                    String id = selectedData.toString();
                    int idConsulta = Integer.parseInt(id);

                    try {
                        ArrayList<Servicio> servicio = servicioBo.buscarIdServicio(idConsulta);

                        for (Servicio s : servicio) {
                            id_servicio = s.getId_servicio();
                            txt_nombre_servicio.setText(s.getNombre_servicio());
                        }
                    } catch (Exception sql) {
                        JOptionPane.showMessageDialog(null, sql);
                    }

                    tabla_servicios.clearSelection();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_servicios;
    private javax.swing.JTextField txt_nombre_servicio;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
