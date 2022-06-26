package Vista;

import Controlador.CelularesController.CelularesController;
import Controlador.TDA_Lista.ListaEnlazada;
import Controlador.TDA_Lista.ListaEnlazadaServices;
import Controlador.TDA_Lista.TipoOrdenacion;
import Modelo.DatosCelulares;
import Vista.Tablas.TablaCelulares;
import Vista.Tablas.TablaOrden;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hilary Madeley Calva Camacho, , Thais Cartuche 
 */
public class FrmPrincipal extends javax.swing.JFrame {

    TablaCelulares tC = new TablaCelulares();
    TablaOrden tO = new TablaOrden();
    CelularesController ctrlCelular = new CelularesController();

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        cargarTabla();
        this.setTitle("SISTEMA DE MANEJO DE DATOS DE CELULARES");
    }

    private void cargarTabla() {
        tC.setListaCelular(ctrlCelular.guardarLista());
        tblCuenta.setModel(tC);
        tblCuenta.updateUI();
    }

    private void cargarTablaOrden(ListaEnlazadaServices<DatosCelulares> listaPrueba) {
        tC.setListaCelular(listaPrueba);
        tblOrden.setModel(tC);
        tblOrden.updateUI();
    }

    private String cambiarNombre() {
        String nr = cbxAtributo.getSelectedItem().toString();
        if (nr.equals("Marca")) {
            nr = "marca";
        } else {
            if (nr.equals("Color")) {
                nr = "color";
            } else {
                if (nr.equals("Pantalla")) {
                    nr = "pantalla";
                } else {
                    if (nr.equals("Precio")) {
                        nr = "precio";
                    }
                }
            }
        }
        return nr;
    }

    private void buscarAtributo(ListaEnlazada lista, String atributo, String nr, String txt) {
        ctrlCelular.ordenarShell(atributo, TipoOrdenacion.ASCENDENTE);
        try {
            lista = ctrlCelular.getListaCelular().getLista().buscarDatoPosicionObjetoBinaria(nr, txt);
            tO.setListaCelular(lista);
            tblResultados.setModel(tO);
            tblResultados.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscar() {
        String nr = cbxAtributoBuscar.getSelectedItem().toString();
        String txt = txtDato.getText();
        ListaEnlazada lista = new ListaEnlazada();
        try {
            if (txt.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene el dato a buscar");
            } else {
                if (nr.equals("Marca")) {
                    nr = "marca";
                    buscarAtributo(lista, "marca", nr, txt);
                } else {
                    if (nr.equals("Color")) {
                        nr = "color";
                        buscarAtributo(lista, "color", nr, txt);
                    } else {
                        if (nr.equals("Pantalla")) {
                            nr = "pantalla";
                            buscarAtributo(lista, "pantalla", nr, txt);
                        } else {
                            if (nr.equals("Precio")) {
                                nr = "precio";
                                lista = ctrlCelular.getListaCelular().getLista().buscarDatoPosicionObjetoBinaria(nr, Double.valueOf(txt));
                                tO.setListaCelular(lista);
                                tblResultados.setModel(tO);
                                tblResultados.updateUI();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    private void ordenarShell() {

        if (cbxOrden.getSelectedIndex() == 1) {
            ctrlCelular.ordenarShell(cambiarNombre(), TipoOrdenacion.ASCENDENTE);
            cargarTablaOrden(ctrlCelular.getListaCelular());
        } else {
            if (cbxOrden.getSelectedIndex() == 2) {
                ctrlCelular.ordenarShell(cambiarNombre(), TipoOrdenacion.DESCENDENTE);
                cargarTablaOrden(ctrlCelular.getListaCelular());
            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun orden");
            }
        }
    }

    private void ordenarQuickShort() {
        if (cbxOrden.getSelectedIndex() == 1) {
            ctrlCelular.ordenarQuickShort(cambiarNombre(), TipoOrdenacion.ASCENDENTE);
            cargarTablaOrden(ctrlCelular.getListaCelular());
        } else {
            if (cbxOrden.getSelectedIndex() == 2) {
                ctrlCelular.ordenarQuickShort(cambiarNombre(), TipoOrdenacion.DESCENDENTE);
                cargarTablaOrden(ctrlCelular.getListaCelular());
            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun orden");
            }
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

        jPanel1 = new javax.swing.JPanel();
        cbxAtributoBuscar = new javax.swing.JComboBox<>();
        cbxAtributo = new javax.swing.JComboBox<>();
        cbxMetodo = new javax.swing.JComboBox<>();
        cbxOrden = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnOrdenar = new javax.swing.JButton();
        txtDato = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOrden = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxAtributoBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Marca", "Color", "Pantalla", "Precio" }));
        jPanel1.add(cbxAtributoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 280, 130, -1));

        cbxAtributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Marca", "Color", "Pantalla", "Precio" }));
        jPanel1.add(cbxAtributo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 130, -1));

        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Shell", "Quickshort" }));
        jPanel1.add(cbxMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 130, -1));

        cbxOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Ascendente", "Descendente" }));
        jPanel1.add(cbxOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 130, -1));

        tblCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCuenta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 410, 610));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SISTEMA DE MANEJO DE DATOS DE CELULARES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 990, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Orden:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(3, 19, 29));
        jLabel10.setText("SECCIÓN DE BUSQUEDA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 170, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Método:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(2, 14, 26));
        jLabel12.setText("DATOS ORDENADOS");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Dato a buscar:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 330, -1, -1));

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(2, 22, 28));
        jLabel14.setText("SECCIÓN DE ORDENAMIENTO");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 210, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ordenar por:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Buscar por:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 280, -1, -1));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, -1, -1));
        jPanel1.add(txtDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 330, 120, -1));

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblResultados);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 280, 150));

        tblOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblOrden);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 320, 390));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DATOS CUENTAS DE USUARIOS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 270, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO_T.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 590, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO_T.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO_AZUL_GRIS.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 660, 400));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO_AZUL_GRIS.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, -20, 660, 520));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO_T.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 470, 520));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO_AZUL_GRIS.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 330, 400));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO_T.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 800, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1129, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        int seleccion = cbxMetodo.getSelectedIndex();
        switch (seleccion) {
            case 1:
                ordenarShell();
                break;
            case 2:
                ordenarQuickShort();
                break;
            default:
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun metodo");
        }
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JComboBox<String> cbxAtributo;
    private javax.swing.JComboBox<String> cbxAtributoBuscar;
    private javax.swing.JComboBox<String> cbxMetodo;
    private javax.swing.JComboBox<String> cbxOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCuenta;
    private javax.swing.JTable tblOrden;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtDato;
    // End of variables declaration//GEN-END:variables
}
