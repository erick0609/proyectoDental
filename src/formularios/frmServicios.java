package formularios;

import clases.bdConexion;
import clases.servicios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author laptop-1
 */
public class frmServicios extends javax.swing.JInternalFrame {

    bdConexion con;
    servicios s = new servicios();
    Object[][] dtServicios; //variable de tipo Object que almacena una matriz de datos
    int fila=-1;
    
    {
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
        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        jXTaskPane1 = new org.jdesktop.swingx.JXTaskPane();
        lblNuevo = new javax.swing.JLabel();
        lblModificar = new javax.swing.JLabel();
        lblBorrar = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();
        lblCancelar = new javax.swing.JLabel();
        lblListaServicios = new javax.swing.JLabel();
        jXTaskPane2 = new org.jdesktop.swingx.JXTaskPane();
        jcBuscar = new javax.swing.JComboBox();
        txtValorBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelContenedor = new javax.swing.JPanel();
        panelPacientes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoServicio = new javax.swing.JTextField();
        txtNombreServicio = new javax.swing.JTextField();
        txtModo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionServicio = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("SERVICIOS");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jXTaskPaneContainer1.setBackground(java.awt.SystemColor.activeCaption);

        jXTaskPane1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/24_Services.png"))); // NOI18N
        jXTaskPane1.setTitle("SERVICIOS");

        lblNuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/16_AddDataBase.png"))); // NOI18N
        lblNuevo.setText("Nuevo Servicio");
        lblNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNuevoMouseClicked(evt);
            }
        });
        jXTaskPane1.getContentPane().add(lblNuevo);

        lblModificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblModificar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/16_database_edit.png"))); // NOI18N
        lblModificar.setText("Modificar Servicio");
        lblModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificarMouseClicked(evt);
            }
        });
        jXTaskPane1.getContentPane().add(lblModificar);

        lblBorrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBorrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/16_database_delete.png"))); // NOI18N
        lblBorrar.setText("Borrar Servicio");
        lblBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBorrarMouseClicked(evt);
            }
        });
        jXTaskPane1.getContentPane().add(lblBorrar);

        lblGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGuardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/16_database_save.png"))); // NOI18N
        lblGuardar.setText("Guardar Cambios");
        lblGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });
        jXTaskPane1.getContentPane().add(lblGuardar);

        lblCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/16_database_refresh.png"))); // NOI18N
        lblCancelar.setText("Cancelar Cambios");
        lblCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });
        jXTaskPane1.getContentPane().add(lblCancelar);

        lblListaServicios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblListaServicios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblListaServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/16_ListaPacientes.png"))); // NOI18N
        lblListaServicios.setText("Lista de Servicios");
        lblListaServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jXTaskPane1.getContentPane().add(lblListaServicios);

        jXTaskPaneContainer1.add(jXTaskPane1);

        jXTaskPane2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/24_Search.png"))); // NOI18N
        jXTaskPane2.setTitle("Busqueda Por:");
        jXTaskPane2.setMaximumSize(new java.awt.Dimension(145, 120));
        jXTaskPane2.setPreferredSize(new java.awt.Dimension(145, 150));
        jXTaskPane2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nombreServicio", "descripcion" }));
        jXTaskPane2.getContentPane().add(jcBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 30, 133, 30));

        txtValorBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorBuscarKeyTyped(evt);
            }
        });
        jXTaskPane2.getContentPane().add(txtValorBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 85, 133, 30));

        jLabel4.setText("Buscar Por:");
        jXTaskPane2.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        jLabel5.setText("Valor a buscar:");
        jXTaskPane2.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        jXTaskPaneContainer1.add(jXTaskPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        panelContenedor.setBackground(java.awt.SystemColor.activeCaption);

        panelPacientes.setBackground(java.awt.SystemColor.activeCaption);
        panelPacientes.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Datos Lista de Servicios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11))); // NOI18N
        panelPacientes.setFocusable(false);
        panelPacientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelPacientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Codigo:");
        panelPacientes.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 25, 98, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del Servicio:");
        panelPacientes.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Descripción:");
        panelPacientes.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 75, 98, -1));

        txtCodigoServicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCodigoServicio.setForeground(new java.awt.Color(255, 0, 51));
        panelPacientes.add(txtCodigoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 130, 25));

        txtNombreServicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreServicioKeyReleased(evt);
            }
        });
        panelPacientes.add(txtNombreServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 410, 25));
        panelPacientes.add(txtModo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        txtDescripcionServicio.setColumns(1);
        txtDescripcionServicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescripcionServicio.setLineWrap(true);
        txtDescripcionServicio.setRows(3);
        txtDescripcionServicio.setTabSize(1);
        txtDescripcionServicio.setWrapStyleWord(true);
        txtDescripcionServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionServicioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcionServicio);

        panelPacientes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 76, 410, 60));

        tablaServicios.setBackground(new java.awt.Color(255, 255, 204));
        tablaServicios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaServicios.setRowHeight(25);
        tablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServiciosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaServicios);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosMouseClicked
        // MUESTRA CADA REGISTRO SELECCIONADO EN LOS CAMPOS CORRESPONDIENTES DEL FORMULARIO
        fila= tablaServicios.rowAtPoint(evt.getPoint());//obtiene el indice de la fila seleccionada

        if (fila>-1){

            /*colocamos en los campos del formulario, el valor correspondiente obtenido
             * de la posicion de la fila y de la posicion de la columna. 
            */
            txtCodigoServicio.setText(String.valueOf(tablaServicios.getValueAt(fila, 0)));
            txtNombreServicio.setText(String.valueOf(tablaServicios.getValueAt(fila, 1)));
            txtDescripcionServicio.setText(String.valueOf(tablaServicios.getValueAt(fila, 2)));
                   
        }

        activaOpciones(true,true,true,false,false);//procedimiento
        activaControles(false, false, false);//procedimiento
    }//GEN-LAST:event_tablaServiciosMouseClicked

    private void lblNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoMouseClicked
        // TODO add your handling code here:
        nuevoServicio();//procedimiento
    }//GEN-LAST:event_lblNuevoMouseClicked

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked
        // TODO add your handling code here:
       txtModo.setText("1");
       activaOpciones(false,false,false,true,true);//procedimiento
       activaControles(false,true,true);//procedimiento
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrarMouseClicked
        // TODO add your handling code here:
        s.eliminarServicio(this.tablaServicios.getValueAt(this.tablaServicios.getSelectedRow(),0).toString());
        updateTabla();//procedimiento
        limpiarObjetos();//procedimiento
    }//GEN-LAST:event_lblBorrarMouseClicked

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        // TODO add your handling code here:
        validarCampos();//procedimiento
    }//GEN-LAST:event_lblGuardarMouseClicked

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        // TODO add your handling code here:
        updateTabla();//procedimiento
        limpiarObjetos();//procedimiento
        activaOpciones (true, false, false, false,false);//procedimiento
        activaControles (false, false, false);//procedimiento
    }//GEN-LAST:event_lblCancelarMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        updateTabla();
        limpiarObjetos();
        activaOpciones (true, false, false, false,false);
        activaControles (false, false, false);
        txtModo.setVisible(false);
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtNombreServicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreServicioKeyReleased
         // TODO add your handling code here:
        String n = txtNombreServicio.getText().toUpperCase();
        txtNombreServicio.setText(n);
    }//GEN-LAST:event_txtNombreServicioKeyReleased

    private void txtDescripcionServicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionServicioKeyReleased
        String d = txtDescripcionServicio.getText().toUpperCase();
        txtDescripcionServicio.setText(d);
    }//GEN-LAST:event_txtDescripcionServicioKeyReleased

    private void txtValorBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorBuscarKeyTyped
        String vBuscar="";
        String vValor="";
        vBuscar = (String) jcBuscar.getSelectedItem();
        vValor = txtValorBuscar.getText();
        try {
            //p.buscarPaciente(vBuscar, vValor);           
            tablaServicios.setModel( s.buscarServicio(vBuscar, vValor));
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(frmPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtValorBuscarKeyTyped

    //METODO PARA ACTUALIZAR LOS REGISTROS DE LA TABLA
    private void updateTabla() {
        String[] columNames = {"Id_Servicio", "Nombre Servicio", "Descripción"};
        //usamos la funcion
        dtServicios = s.getDatos();

        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtServicios, columNames);
        tablaServicios.setModel(datos);
        TableColumnModel columnModel = tablaServicios.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(200);        
    }
    
    //METODO PARA GENERAR NUEVO SERVICIO
    public void nuevoServicio()
    {
       txtModo.setText("0");
       
       limpiarObjetos();
       activaOpciones(false, false, false, true,true);
       activaControles(false,true,true);

       //GENERAR CODIGO DEL SERVICIO AUTOMANTICO
       int registros=0;
       try
        {
            con = new bdConexion();
            PreparedStatement pstm=(PreparedStatement)
            con.getConnection().prepareStatement("SELECT count(1) as total FROM servicios");//cuenta el total de registros de la tabla servicios
            ResultSet res=pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();

            if (registros <=0)//significa que la tabla no tiene ningun registro
            {
                txtCodigoServicio.setText("001");
            }
            else
            {                                  
                con = new bdConexion();
                PreparedStatement pstm1=(PreparedStatement)
                con.getConnection().prepareStatement("SELECT MAX(IdServicio) as codigo FROM servicios");
                ResultSet res1=pstm1.executeQuery();

                res1.first();
                String v =res1.getString("codigo");

                int cod=(Integer.parseInt(v))+1;

                if ( cod<10)
                {
                    txtCodigoServicio.setText("00"+cod);
                }
                else if(cod<100)
                {
                    txtCodigoServicio.setText("0"+cod);
                }
                else
                {
                    txtCodigoServicio.setText(v);
                }

            res1.close();
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
   
    //METODO GUARDAR SERVICIO
    public void guardarServicio()
    {
        String nModo=txtModo.getText();
        int modo=Integer.parseInt(nModo);

        switch (modo)
        {
            case 0:

                    int resp;
                    resp=JOptionPane.showConfirmDialog(null,"¿Desea guardar el registro?","Pregunta",0);

                    if (resp==0)
                    {
                        String cservicio = txtCodigoServicio.getText();
                        String nservicio = txtNombreServicio.getText();
                        String desservicio = txtDescripcionServicio.getText();                        

                        s.nuevoServicio(cservicio, nservicio, desservicio);
                        updateTabla();

                        activaOpciones(true,false,false,false,false);
                        activaControles (false, false, false);
                        limpiarObjetos();

                    }
                    break;
            case 1://SIGNIFICA QUE ES UNA MODIFICACION

                        String cservicio = txtCodigoServicio.getText();
                        String nservicio = txtNombreServicio.getText();
                        String desservicio = txtDescripcionServicio.getText();


                        //ENVIAMOS LOS CAMPOS AL CONSTRUCTOR DE LA CLASE SERVICIOS
                        s.modificarServicio(cservicio, nservicio, desservicio);
                        
                        //ACTUALIZAMOS LOS CAMPOS DE LA TABLA
                        updateTabla();
                        activaOpciones(true,false,false,false,false);
                        activaControles(false, false, false);
                        limpiarObjetos();
                        JOptionPane.showMessageDialog(null,"El regisgtro fue actualizado correctamente","Informacion",1);

                        break;
            default: JOptionPane.showMessageDialog(null,"Error al guardar el registro, intente otra vez");
        }
    }
    
        //METODO PARA ACTIVAR O BLOQUEAR LOS CONTROLES USADOS EN EL FORMULARIO
    public void activaControles(boolean cs, boolean ns, boolean ds)
    {
        txtCodigoServicio.setEditable(cs);
        txtNombreServicio.setEditable(ns);
        txtDescripcionServicio.setEditable(ds);               
    }
    
    //METODO PARA ACTIVAR O DESACTIVAR LAS OPCIONES DE CONTROL DEL FORMULARIO
    public void activaOpciones(boolean n, boolean m, boolean e, boolean g, boolean c)
    {
        lblNuevo.setEnabled(n);
        lblModificar.setEnabled(m);
        lblBorrar.setEnabled(e);
        lblGuardar.setEnabled(g);        
        lblCancelar.setEnabled(c);        
    }
    
    //METODO PARA LIMPIAR LOS OBJETOS
    public void limpiarObjetos()
    {
        txtCodigoServicio.setText("");
        txtNombreServicio.setText("");
        txtDescripcionServicio.setText("");       
    }
    
    //METODO PARA VALIDAR LOS CAMPOS DE TEXTO CUANDO ES UN REGISTRO NUEVO O MODIFICACION

    public void validarCampos()
    {
        
        if (txtNombreServicio.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Escriba el Nombre del Servicio");
            txtNombreServicio.requestFocus();
        }
        else if (txtDescripcionServicio.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Escriba la descripcion del servicio");
            txtDescripcionServicio.requestFocus();
        }
        else
        {
            //SI TODOS LOS CAMPOS ESTAN CORRECTOS, LLAMAMOS AL METODO GUARDAR SERVICIO
            guardarServicio();
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane2;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private javax.swing.JComboBox jcBuscar;
    private javax.swing.JLabel lblBorrar;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblListaServicios;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JLabel lblNuevo;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelPacientes;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txtCodigoServicio;
    private javax.swing.JTextArea txtDescripcionServicio;
    private javax.swing.JTextField txtModo;
    private javax.swing.JTextField txtNombreServicio;
    private javax.swing.JTextField txtValorBuscar;
    // End of variables declaration//GEN-END:variables
}
