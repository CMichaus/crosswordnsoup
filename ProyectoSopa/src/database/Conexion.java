package database;


import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion{

    private String db = "sopaletras";
    private String user = "root";
    private String pass = "123qwe";
    private String url = "jdbc:mysql://localhost/"+db;
    
    public Conexion() {
        
    }  
    
    public Connection Conectar(){
    Connection link = null;
        try {
            //Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
       } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error en conexión"+ex);
}
    return link;
}
}