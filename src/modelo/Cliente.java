/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Dany Hernandez
 */
public class Cliente extends Persona{
    private String nit;
    Conexion cn;

    public Cliente() {}
    
    public Cliente(String nit, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    public DefaultTableModel leer(){
         DefaultTableModel tabla = new DefaultTableModel();
try{
    cn = new Conexion();
    cn.abrir_conexion();
    String query;
    query = "Select id_cliente as id,nit,nombres,apellidos,telefono,fecha_nacimiento from clientes;"


}catch(Exception ex){
        System.out.println("Error: " + ex.getMessage());
}
         return tabla;
}
    }
    @Override
    public void agregar(){
    try{
        PreparedStatement parametro;
        String query = "INSERT INTO clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento)VALUES(?,?,?,?,?,?);";
        cn = new Conexion();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        parametro.setString(1, getNit());
        parametro.setString(2, getNombres());
        parametro.setString(3, getApellidos());
        parametro.setString(4, getDireccion());
        parametro.setString(5, getTelefono());
        parametro.setString(6, getFecha_nacimiento());
        
        int executar = 0;
        executar = parametro.executeUpdate();
        cn.cerrar_conexion; 
        JOptionPane.showMessageDialog(null,Integer.toString(executar)  + "Registro Ingresado","Agregar", JOptionPane.INFORMATION_MESSAGE);
        
       
        
        
    }catch(Exception ex){
        System.out.println("Error..." + ex.getMessage());
        
    }
    }
    
}
