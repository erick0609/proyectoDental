package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laptop-1
 */
public class paciente {
    bdConexion con;
    
    public paciente()
    {
        con = new bdConexion();
    }
    
     /* constructor explicito agregar un nuevo registro*/
    public void nuevoPaciente(String idPaciente,String nombres, String aP, String aM, String dni, String fNa, String telefono, String email, String direccion, String estado, String tDoc, String coddis)
    {
        try
        {
            PreparedStatement pstm=(PreparedStatement)
            con.getConnection().prepareStatement("INSERT INTO paciente(idPaciente, nombres, aPaterno, aMaterno, numDocumento, fechaNacimiento, telefono, email, direccion, estado, idTipoDocumento, codigoDistrito)" + "values (?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pstm.setString(1, idPaciente);
            pstm.setString(2, nombres);
            pstm.setString(3, aP);
            pstm.setString(4, aM);
            pstm.setString(5, dni);
            pstm.setString(6, fNa);
            pstm.setString(7, telefono);
            pstm.setString(8, email);
            pstm.setString(9, direccion);
            pstm.setString(10, estado);
            pstm.setString(11, tDoc);
            pstm.setString(12, coddis);            
            
            pstm.execute();
            pstm.close();
        }
        catch(SQLException e)
        {
            System.out.print(e);
        }
    }
    
    //Codigo para obtener los datos de la tabla
    public Object[][]getDatos()
    {
        int registros=0;
        //obtener la cantidad de registros que hay en la tabla pacientes
        try
        {
            PreparedStatement pstm=(PreparedStatement)
            con.getConnection().prepareStatement("SELECT count(1) as total FROM paciente WHERE estado = '1'");//cuenta el total de registros de la tabla pacientes
            ResultSet res=pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }
        catch(SQLException e)
        {
         System.out.println(e);   
        }
        
        Object[][] data=new String [registros][14];
        
        //realizamos la consulta sql y llenamos los datos del Object
        
        try
        {
            PreparedStatement pstm=(PreparedStatement)
            con.getConnection().prepareStatement("SELECT * FROM paciente p INNER JOIN "
                    + "distrito ds ON ds.codigoPostal = p.codigoDistrito INNER JOIN "
                    + "provincia pv ON pv.idProvincia = ds.idProvincia INNER JOIN "
                    + "departamento dp ON dp.idDepartamento = pv.idDepartamento INNER JOIN "
                    + "pais ps ON ps.avPais = dp.avPais INNER JOIN "
                    + "tipodocumento td ON td.idTipoDocumento = p.idTipoDocumento WHERE p.estado = '1' ORDER BY idPaciente ASC;");
            ResultSet res=pstm.executeQuery();
            
            int i=0;
            
            while (res.next())
            {
                String estIdPaciente = res.getString("idPaciente");
                String estNombres = res.getString("nombres");
                String estAPaterno = res.getString("aPaterno");
                String estAMaterno = res.getString("aMaterno");
                String estDireccion = res.getString("direccion");
                String estPa = res.getString("pais");
                String estDe = res.getString("departamento");
                String estProvincia = res.getString("provincia");
                String estDistrito = res.getString("distrito");
                String estNumDoc = res.getString("numDocumento");
                String estTelefono = res.getString("telefono");
                String estEmail = res.getString("email");
                String estTDoc = res.getString("documento");
                String estFechaNac = res.getString("fechaNacimiento");
                
                
                data [i][0]=estIdPaciente;
                data [i][1]=estTDoc;
                data [i][2]=estNumDoc;
                data [i][3]=estNombres;
                data [i][4]=estAPaterno;
                data [i][5]=estAMaterno;
                data [i][6]=estFechaNac;
                data [i][7]=estTelefono;
                data [i][8]=estEmail;
                data [i][9]=estDireccion;
                data [i][10]=estPa;
                data [i][11]=estDe;
                data [i][12]=estProvincia;
                data [i][13]=estDistrito;
                    
                
                i++;//retorna el ciclo hasta finalizar
                
            }
            
            res.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return data;
    }
    
    public Object[][]getDatos2Pacientes()
    {
        int registros=0;
        //obtener la cantidad de registros que hay en la tabla pacientes
        con = new bdConexion();
        try
        {            
            String sql = "SELECT count(1) as total FROM paciente";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet res = ps.executeQuery();
                       
            res.next();
            registros = res.getInt("total");
            res.close();
        }
        catch(SQLException e)
        {
         System.out.println(e);   
        }
        
        Object[][] data=new String [registros][3];
        
        //realizamos la consulta sql y llenamos los datos del Object        
        try
        {
            PreparedStatement pstm=(PreparedStatement)            
            con.getConnection().prepareStatement("SELECT idPaciente, concat(nombres,' ',aPaterno,' ',aMaterno) as nombrePa FROM paciente WHERE estado = 1 ORDER BY idPaciente ASC");
            ResultSet res=pstm.executeQuery();
                        
            int i=0;            
            while (res.next())
            {
                String estIdPaciente = res.getString("idPaciente");                
                String estNombres = res.getString("nombrePa");
                                              
                
                data [i][0]=estIdPaciente;                
                data [i][1]=estNombres;
  
                i++;//retorna el ciclo hasta finalizar
                
            }
            
            res.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return data;
    }
    
    
    //METODO QUE PERMITE ELIMINAR UN REGISTRO DE LA TABLA PACIENTE
    public void eliminarPaciente(String codigo)
    {
        try
        {
            int rows_update=0;
            PreparedStatement pstm=con.getConnection().prepareStatement("UPDATE paciente SET estado = '0' WHERE idPaciente='"+codigo+"'");
            //PreparedStatement pstm=con.conexion.prepareStatement("DELETE paciente.* FROM paciente WHERE IdPaciente='"+codigo+"'");
            rows_update=pstm.executeUpdate();
            
            if (rows_update==1)
            {
                JOptionPane.showMessageDialog(null,"Registro eliminado exitosamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No se pudo eliminar el registro, verifique datos");
                con.desconectar();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());            
        }
    }
    
    //METODO PARA ACTUALIZAR/MODIFICAR REGISTROS DE LA TABLA PACIENTE
    public void modificarPaciente(String idPaciente,String nombres, String aP, String aM, String dni, String fNa, String telefono, String email, String direccion, String estado, String tDoc, String coddis)
    {
        try
        {
            PreparedStatement pstm=(PreparedStatement)
            con.getConnection().prepareStatement("UPDATE paciente SET "
                    + "nombres='"+nombres+"',aPaterno='"+aP+"',aMaterno='"+aM+"',"
                    + "numDocumento='"+dni+"',fechaNacimiento='"+fNa+"',"
                    + "telefono='"+telefono+"',email='"+email+"',direccion='"+direccion+"',"
                    + "estado='"+estado+"',idTipoDocumento='"+tDoc+"',codigoDistrito='"+coddis+"' "
                    + "WHERE idPaciente = '"+idPaciente+"';");
            pstm.executeUpdate();
            pstm.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    //METODO PARA REALIZAR BUSQUEDA DE REGISTROS TABLA PACIENTE
    public DefaultTableModel buscarPaciente(String campo, String valor) throws SQLException
    {               
        String v = '%'+valor+'%';
        String[] columNames = {"IdPaciente", "Tipo Documento", "N° DOC", "Nombres", "A. Paterno","A. Materno","F. Nacimiento","Teléfono", "email", "Dirección", "Pais","Deapartamento", "Provincia","Distrito"};
        
        DefaultTableModel res= new DefaultTableModel();
        
        for (int i = 0; i < columNames.length; i++) {
            res.addColumn(columNames[i]);
        }               
  
    try
    {
        String sql = "SELECT * FROM paciente p INNER JOIN "
                    + "distrito ds ON ds.codigoPostal = p.codigoDistrito INNER JOIN "
                    + "provincia pv ON pv.idProvincia = ds.idProvincia INNER JOIN "
                    + "departamento dp ON dp.idDepartamento = pv.idDepartamento INNER JOIN "
                    + "pais ps ON ps.avPais = dp.avPais INNER JOIN "
                    + "tipodocumento td ON td.idTipoDocumento = p.idTipoDocumento "
                + "WHERE p.estado = '1' AND "+campo+" like ?";        
        PreparedStatement ps = con.getConnection().prepareStatement(sql);        
        ps.setString(1, v);
        ResultSet resultado = ps.executeQuery();           
        
        int x=0;
        resultado.last();
        
        if(resultado.getRow()<=0)
        {
            //JOptionPane.showMessageDialog(null,"Lo siento, su consulta con el campo "+campo+" \n y con el valor "+valor+" no obtubo resultados");
            return res;
        }
        else
        {
            resultado.beforeFirst();
            
            while(resultado.next())
            {
                
                res.addRow(new Object[]{});
                res.setValueAt(resultado.getString("idPaciente"), x, 0);
                res.setValueAt(resultado.getString("documento"), x, 1);                
                res.setValueAt(resultado.getString("numDocumento"), x, 2);
                res.setValueAt(resultado.getString("nombres"), x, 3);
                res.setValueAt(resultado.getString("aPaterno"), x,  4);
                res.setValueAt(resultado.getString("aMaterno"), x,  5);
                res.setValueAt(resultado.getString("fechaNacimiento"), x, 6);
                res.setValueAt(resultado.getString("telefono"), x, 7);
                res.setValueAt(resultado.getString("email"), x, 8);
                res.setValueAt(resultado.getString("direccion"), x, 9); 
                res.setValueAt(resultado.getString("pais"), x, 10);
                res.setValueAt(resultado.getString("departamento"), x, 11);
                res.setValueAt(resultado.getString("provincia"), x, 12);
                res.setValueAt(resultado.getString("distrito"), x, 13);                           
                
                x++;
            }
            return res;
        }
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
    }
        con.desconectar();
        return res;
    }
     
     //METODO PARA REALIZAR BUSQUEDA DE REGISTROS TABLA PACIENTE
    public DefaultTableModel buscarPaciente2(String campo, String valor) throws SQLException
    {               
        String v = '%'+valor+'%';
        
        DefaultTableModel res= new DefaultTableModel();
        res.addColumn("IdPaciente");        
        res.addColumn("Nombre del Paciente");
                  
  
    try
    {
        String sql = "SELECT * FROM paciente WHERE "+campo+" like ?";        
        PreparedStatement ps = con.getConnection().prepareStatement(sql);        
        ps.setString(1, v);
        ResultSet resultado = ps.executeQuery();           
        
        int x=0;
        resultado.last();
        
        if(resultado.getRow()<=0)
        {
            //JOptionPane.showMessageDialog(null,"Lo siento, su consulta con el campo "+campo+" \n y con el valor "+valor+" no obtubo resultados");
            return res;
        }
        else
        {
            resultado.beforeFirst();
            
            while(resultado.next())
            {
                res.addRow(new Object[]{});
                res.setValueAt(resultado.getString("IdPaciente"), x, 0);                           
                res.setValueAt(resultado.getString("nombres")+" "+resultado.getString("apellidos"), x, 1);                
                x++;
            }
            return res;
        }
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
    }
        con.desconectar();
        return res;
    }
    
    //METODO PARA REALIZAR BUSQUEDA DE REGISTROS TABLA PACIENTE EN formulario Citas
    public DefaultTableModel buscarPaciente3(String campo, String valor) throws SQLException
    {               
        String v = '%'+valor+'%';
        
        DefaultTableModel res= new DefaultTableModel();
        res.addColumn("IdPaciente");      
        res.addColumn("N° Documento");
        res.addColumn("Nombre");
        res.addColumn("Teléfono");           
  
    try
    {
        String sql = "SELECT idPaciente, numDocumento, concat(nombres,' ',aPaterno,' ',aMaterno) as nombrePa, telefono FROM paciente WHERE estado = 1 AND "+campo+" like ?";        
        PreparedStatement ps = con.getConnection().prepareStatement(sql);        
        ps.setString(1, v);
        ResultSet resultado = ps.executeQuery();           
        
        int x=0;
        resultado.last();
        
        if(resultado.getRow()<=0)
        {
            //JOptionPane.showMessageDialog(null,"Lo siento, su consulta con el campo "+campo+" \n y con el valor "+valor+" no obtubo resultados");
            return res;
        }
        else
        {
            resultado.beforeFirst();
            
            while(resultado.next())
            {
                res.addRow(new Object[]{});
                res.setValueAt(resultado.getString("idPaciente"), x, 0);
                res.setValueAt(resultado.getString("numDocumento"), x, 1);                
                res.setValueAt(resultado.getString("nombrePa"), x, 2);
                res.setValueAt(resultado.getString("telefono"), x, 3);                        
                
                x++;
            }
            return res;
        }
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
    }
        con.desconectar();
        return res;
    }
    
}
