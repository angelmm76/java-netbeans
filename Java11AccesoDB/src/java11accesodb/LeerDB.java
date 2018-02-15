package java11accesodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeerDB {
    private String dbname;
    Connection conn;
    Statement statem;
    String sqlquery;
    ResultSet rs;
    
    // Constructor
    public LeerDB(String dbna, String usuario, String pass){
        this.dbname =dbna;
        // Abrir conexión mysql de una base de datos con user y password
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbname, usuario, pass);
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Class exception");
            cnfe.printStackTrace();
        }
        catch(SQLException sqle){
            System.out.println("Closing exception");
            sqle.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        // Crear statement con su query
        sqlquery = "SELECT * FROM actor;";
        try {
            statem = conn.createStatement();
            rs = statem.executeQuery(sqlquery);
            // Resultado de la consulta
            rs = statem.getResultSet();          

        } catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
               
    }
    
    public void showData(){
        // Leer los registros del result set
        int i = 0;
        
        try {   
            System.out.println(rs.toString());
            System.out.println(rs.getMetaData().getColumnCount());
            while (rs.next()){ // Leer mientras existan registros 
                System.out.println(rs.getString("actor_id") + ": " + 
                        rs.getString("first_name") + ", " + 
                        rs.getString("last_name") + ", " +
                        rs.getString("last_update"));
                i++;
            }
        } 
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
           System.out.println("Registros leidos de " + dbname + ": " + i);
           
    }
    
    public void close(){
        // Cerrar conexión
        try{
           conn.close(); 
        }
        catch (SQLException sqle) {
            System.out.println("Closing error");
            sqle.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
